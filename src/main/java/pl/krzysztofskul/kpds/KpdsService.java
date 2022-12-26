package pl.krzysztofskul.kpds;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType0Font;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.pdf.PdfWriter;

import pl.krzysztofskul.device.Device;
import pl.krzysztofskul.device.prototype.Prototype;
import pl.krzysztofskul.project.Project;
import pl.krzysztofskul.project.ProjectService;

@Service
@Transactional
public class KpdsService {

	private static String path_kpds_generated = "D://SMNSH/karta_projektu//kpds_generated";
	
	private ProjectService projectService;
	private KpdsRepo kpdsRepo;
	
	@Autowired
	public KpdsService(ProjectService projectService, KpdsRepo kpdsRepo) {
		super();
		this.projectService = projectService;
		this.kpdsRepo = kpdsRepo;
	}

	public void generateKpds(Long projectId) {
		//load project connected with kpds
		Project project = projectService.loadByIdWithDeviceList(projectId);
		
		//create new kpds entity and save to DB
		Kpds kpds = new Kpds(project);
		kpds = this.save(kpds);
		
		String inwestor = kpds.getProject().getInvestor().getName();
		
		List<String> devices = new ArrayList<String>();
		for (Device device : kpds.getProject().getDeviceList()) {
			devices.add(device.getDeviceCategory().getName() + " "+ device.getModel());
		}
		 
		
		// create and save new kpds.pdf document from kpds entity
		try {	
			PDDocument document = new PDDocument();
			PDPage page = new PDPage();
			document.addPage(page);

			PDPageContentStream contentStream = new PDPageContentStream(document, page);
//			PDType0Font font = PDType0Font.load(document, new File("c:/windows/fonts/times.ttf"));
			PDType0Font font = PDType0Font.load(document, new File("c:/windows/fonts/SiemensSans_Prof_Roman.ttf"));
			PDType0Font fontItalic = PDType0Font.load(document, new File("c:/windows/fonts/SiemensSans_Prof_Italic.ttf"));
			PDType0Font fontBold = PDType0Font.load(document, new File("c:/windows/fonts/SiemensSans_Prof_Bold.ttf"));
			PDType0Font fontBoldItalic = PDType0Font.load(document, new File("c:/windows/fonts/SiemensSans_Prof_BoldItalic.ttf"));

			PDImageXObject logo = PDImageXObject.createFromFile("D://SMNSH/karta_projektu//AppData//logo//logo_smnsh.png", document);
			contentStream.drawImage(logo, 475, 750);
			
			contentStream.beginText();
			contentStream.setFont(fontBold, 24);
			contentStream.newLineAtOffset(175, 750);
			contentStream.showText("Dokument KPDS");
			contentStream.endText();
			
			contentStream.moveTo(10, 740);
			contentStream.lineTo(595, 740);
			contentStream.stroke();
			
			contentStream.beginText();
			contentStream.setFont(fontItalic, 11);
			contentStream.newLineAtOffset(450, 725);
			contentStream.showText("Data utworzenia: " + kpds.getDateTimeGenerated().toLocalDate().toString());
			contentStream.endText();
			
			contentStream.beginText();
			contentStream.setFont(font, 11);
			contentStream.newLineAtOffset(25, 675);
			contentStream.showText("Kierownik projektu: " + kpds.getProject().getDetailsSls().getImportedProjectManager());
			contentStream.endText();
			
			contentStream.beginText();
			contentStream.setFont(font, 11);
			contentStream.newLineAtOffset(25, 650);
			contentStream.showText("Nr projektu: " + kpds.getProject().getDetailsSls().getSlsCodeShort());
			contentStream.endText();
			
			contentStream.beginText();
			contentStream.setFont(font, 11);
			contentStream.newLineAtOffset(25, 625);
			inwestor = inwestor.replace("\n", " ").replace("\r", " ");
			contentStream.showText("Inwestor: " + inwestor);
			contentStream.endText();
			
			contentStream.beginText();
			contentStream.setFont(font, 11);
			contentStream.newLineAtOffset(25, 600);
			if (kpds.getProject().getAgreementNo() == null ) {
				contentStream.showText("Numer umowy: B/D");
			} else {
				contentStream.showText("Numer umowy: " + kpds.getProject().getAgreementNo());	
			}
			contentStream.endText();
			
			contentStream.beginText();
			contentStream.setFont(fontBold, 12);
			contentStream.newLineAtOffset(25, 550);
			contentStream.showText("WYKAZ URZĄDZEŃ:");
			contentStream.endText();
			
			contentStream.moveTo(10, 540);
			contentStream.lineTo(400, 540);
			contentStream.stroke();
			
			int y = 520;
			for (Prototype prototypeDevice : kpds.getProject().getPrototypeList()) {

				contentStream.beginText();
				contentStream.setFont(font, 11);
				contentStream.newLineAtOffset(30, y);
				contentStream.showText(prototypeDevice.getModelName());
				contentStream.endText();
				
				contentStream.beginText();
				contentStream.setFont(fontItalic, 11);
				contentStream.newLineAtOffset(200, y);
				contentStream.showText("gwarancja: ......... m-cy");
				contentStream.endText();
				
				y = y - 20;
			}
			
			y = y - 100;
			
			contentStream.beginText();
			contentStream.setFont(fontBold, 12);
			contentStream.newLineAtOffset(25, y);
			contentStream.showText("SZKOLENIA:");
			contentStream.endText();
			
			contentStream.moveTo(10, y-10);
			contentStream.lineTo(400, y-10);
			contentStream.stroke();
			
			contentStream.close();

			document.save(path_kpds_generated+"/kpds-projectId_"+kpds.getProject().getId()+".pdf");
			document.close();
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public Kpds save(Kpds kpds) {
		return kpdsRepo.save(kpds);
	}

	public Kpds loadById(Long kpdsId) {
		Kpds kpds = kpdsRepo.findById(kpdsId).get();
		Hibernate.initialize(kpds.getProject());
		return kpds;
	}
	
}
