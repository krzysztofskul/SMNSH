package pl.krzysztofskul.kpds;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
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
		
		// create and save new kpds.pdf document from kpds entity
		// TODO KPDS
		try {	
			PDDocument document = new PDDocument();
			PDPage page = new PDPage();
			document.addPage(page);

			PDPageContentStream contentStream = new PDPageContentStream(document, page);

			contentStream.beginText();
			contentStream.setFont(PDType1Font.TIMES_BOLD, 24);
			contentStream.newLineAtOffset(150, 750);
			contentStream.showText("KPDS");
			contentStream.endText();
			
			contentStream.moveTo(10, 740);
			contentStream.lineTo(400, 740);
			contentStream.stroke();
			
			contentStream.beginText();
			contentStream.setFont(PDType1Font.TIMES_ITALIC, 11);
			contentStream.newLineAtOffset(25, 675);
			contentStream.showText("Data utworzenia: " + kpds.getDateTimeGenerated().toString());
			contentStream.endText();
			
			contentStream.beginText();
			contentStream.setFont(PDType1Font.TIMES_ROMAN, 11);
			contentStream.newLineAtOffset(25, 650);
			contentStream.showText("Project ID: " + kpds.getProject().getId());
			contentStream.endText();
			
			contentStream.beginText();
			contentStream.setFont(PDType1Font.TIMES_ROMAN, 11);
			contentStream.newLineAtOffset(25, 600);
			contentStream.showText("Numer umowy: " + kpds.getProject().getAgreementNo());
			contentStream.endText();
			
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
