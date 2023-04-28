package pl.krzysztofskul.kpds;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Arrays;
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
//import pl.krzysztofskul.email.EmailCredentials;
import pl.krzysztofskul.email.EmailServiceImpl;
import pl.krzysztofskul.importdata.ImportData;
import pl.krzysztofskul.logger.loggerProject.LoggerProject;
import pl.krzysztofskul.logger.loggerProject.LoggerProjectService;
import pl.krzysztofskul.project.Project;
import pl.krzysztofskul.project.ProjectService;

@Service
@Transactional
public class KpdsService {
	
	private static String path_kpds_generated = "D://SMNSH/karta_projektu//kpds_generated";
	//private String kpdsEmailSendTo = EmailCredentials.getKpdsEmailSendTo();
	private String kpdsEmailSendTo;
	
//	private EmailCredentials emailCredentials;
	private ProjectService projectService;
	private KpdsRepo kpdsRepo;
	private LoggerProjectService loggerProjectService;
	private EmailServiceImpl emailServiceImpl;
	
	@Autowired
	public KpdsService(
//			EmailCredentials emailCredentials,
			ProjectService projectService, 
			KpdsRepo kpdsRepo, 
			LoggerProjectService loggerProjectService,
			EmailServiceImpl emailServiceImpl
			) {
		super();		
//		this.emailCredentials = emailCredentials;
		this.projectService = projectService;
		this.kpdsRepo = kpdsRepo;
		this.loggerProjectService = loggerProjectService;
		this.emailServiceImpl = emailServiceImpl;
//		this.kpdsEmailSendTo = emailCredentials.getKpdsEmailSendTo();
	}

	public void generateKpds(Long projectId) {
		//load project connected with kpds
		Project project = projectService.loadByIdWithDeviceList(projectId);
		
		//create new kpds entity and save to DB
		Kpds kpds = new Kpds(project);
		kpds = this.save(kpds);
		
		String inwestor = kpds.getProject().getInvestor().getName();
		inwestor = inwestor.replace("\n", " ").replace("\r", " ");
		
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
			
			writeText(contentStream, fontBold, 24, 125, 750, "Karta przekazania do Serwisu");			

			
			/*
			 * section 1
			 */
			drawLine(contentStream, 10, 730, 595, 730);
			writeText(contentStream, fontBold, 14, 150, 710, "1. INFORMACJE OGÓLNE");
			drawLine(contentStream, 10, 700, 595, 700);
			
			/*
			 * section 1a
			 */		
			this.writeText(contentStream, fontBold, 10, 20, 680, "Nazwa użytownika: ");
			this.writeText(contentStream, font, 10, 170, 680, "b.d.");
			
			this.writeText(contentStream, fontBold, 10, 20, 660, "Ulica: ");
			if (project.getRecipient() != null) {
				this.writeText(contentStream, font, 10, 170, 660, project.getRecipient());				
			} else {
				this.writeText(contentStream, font, 10, 170, 660, "b.d.");	
			}
			
			
			this.writeText(contentStream, fontBold, 10, 20, 640, "Adres cd. (kod, miejscowość): ");
			this.writeText(contentStream, font, 10, 170, 640, "b.d.");
			
			this.writeText(contentStream, fontBold, 10, 20, 620, "Płatnik (inwestor): ");
			this.writeTextWithMaxLength(contentStream, font, 10, 170, 620, inwestor, 36);
			
			/*
			 * section 1b
			 */
			this.writeText(contentStream, fontBold, 10, 325, 680, "Nr projektu: ");
			this.writeText(contentStream, font, 10, 435, 680, kpds.getProject().getDetailsSls().getSlsCodeShort());

			this.writeText(contentStream, fontBold, 10, 325, 660, "Kierownik projektu: ");
			this.writeText(contentStream, font, 10, 435, 660, kpds.getProject().getDetailsSls().getImportedProjectManager());
			
			this.writeText(contentStream, fontBold, 10, 325, 640, "SAP: ");
			this.writeText(contentStream, font, 10, 435, 640, kpds.getProject().getInvestor().getSapInfo().getSapNo());
			
			this.writeText(contentStream, fontBold, 10, 325, 620, "Gwarancja: ");
			this.writeText(contentStream, font, 10, 435, 620, "b.d.");

			this.writeText(contentStream, fontBold, 10, 325, 600, "Data odbioru: ");
			this.writeText(contentStream, font, 10, 435, 600, "b.d.");
			
			this.writeText(contentStream, fontBold, 10, 325, 580, "Czas reakcji/naprawy: ");
			this.writeText(contentStream, font, 10, 435, 580, "b.d.");
			
			
//			contentStream.beginText();
//			contentStream.setFont(font, 11);
//			contentStream.newLineAtOffset(25, 600);
//			if (kpds.getProject().getAgreementNo() == null ) {
//				contentStream.showText("Numer umowy: B/D");
//			} else {
//				contentStream.showText("Numer umowy: " + kpds.getProject().getAgreementNo());	
//			}
//			contentStream.endText();

			/*
			 * section 2
			 */
			drawLine(contentStream, 10, 560, 595, 560);
			writeText(contentStream, fontBold, 14, 150, 540, "2. NUMERY SERYJNE APARATÓW/URZĄDZEŃ");
			drawLine(contentStream, 10, 530, 595, 530);
			
			contentStream.beginText();
			contentStream.setFont(fontBold, 12);
			contentStream.newLineAtOffset(25, 510);
			contentStream.showText("WYKAZ URZĄDZEŃ:");
			contentStream.endText();
			
			contentStream.moveTo(10, 500);
			contentStream.lineTo(150, 500);
			contentStream.stroke();
			
			int y = 480;
			for (Prototype prototypeDevice : kpds.getProject().getPrototypeList()) {

				contentStream.beginText();
				contentStream.setFont(font, 11);
				contentStream.newLineAtOffset(30, y);
				contentStream.showText(prototypeDevice.getModelName());
				contentStream.endText();

				contentStream.beginText();
				contentStream.setFont(font, 10);
				contentStream.newLineAtOffset(200, y);
				contentStream.showText("nr seryjny: ");
				contentStream.endText();
				
				contentStream.beginText();
				contentStream.setFont(font, 10);
				contentStream.newLineAtOffset(300, y);
				contentStream.showText("gwarancja: ");
				contentStream.endText();
				
				contentStream.beginText();
				contentStream.setFont(font, 10);
				contentStream.newLineAtOffset(400, y);
				contentStream.showText("data przekazania: ");
				contentStream.endText();
				
				y = y - 20;
			}
			
			/*
			 * section 3
			 */
			drawLine(contentStream, 10, 450, 595, 450);
			writeText(contentStream, fontBold, 14, 150, 430, "3. SPRZĘT OBCY");
			drawLine(contentStream, 10, 420, 595, 420);
			
			
			/*
			 * section 4
			 */
			drawLine(contentStream, 10, 350, 595, 350);
			writeText(contentStream, fontBold, 14, 150, 330, "4. WYKONAWCY ADAPTACJI");
			drawLine(contentStream, 10, 320, 595, 320);
			

			/*
			 * section 5
			 */
			drawLine(contentStream, 10, 260, 595, 260);
			writeText(contentStream, fontBold, 14, 150, 240, "5. INFORMACJE DODATKOWE");
			drawLine(contentStream, 10, 230, 595, 230);
			
			y= 210;
			y = y - 100;
			
			contentStream.beginText();
			contentStream.setFont(fontBold, 12);
			contentStream.newLineAtOffset(25, y);
			contentStream.showText("SZKOLENIA:");
			contentStream.endText();
			
			y = y - 10;
			
			contentStream.moveTo(10, y);
			contentStream.lineTo(150, y);
			contentStream.stroke();
			
			y = y - 15;
			
			if (null != kpds.getProject().getTrainings()) {
				for (String training : Arrays.asList(kpds.getProject().getTrainings().split(";"))) {
					contentStream.beginText();
					contentStream.setFont(font, 11);
					contentStream.newLineAtOffset(30, y);
					contentStream.showText(training);
					contentStream.endText();
					
					contentStream.beginText();
					contentStream.setFont(font, 11);
					contentStream.newLineAtOffset(375, y);
					contentStream.showText("przeprowadzono w dn: ");
					contentStream.endText();
					
					y = y- 15;
				}	
			}
			
			
			
			/*
			 * footer of the page
			 */
			drawLine(contentStream, 10, 50, 595, 50);
			
			contentStream.beginText();
			contentStream.setFont(fontItalic, 11);
			contentStream.newLineAtOffset(475, 35);
			contentStream.showText(kpds.getDateTimeGenerated().toLocalDate().toString());
			contentStream.endText();
			
			contentStream.close();

			document.save(path_kpds_generated+"/kpds-projectId_"+kpds.getProject().getId()+".pdf");
			document.close();
			
			loggerProjectService.log(project, LocalDateTime.now(ZoneId.of("Europe/Warsaw")), "KPDS created", "Utworzono KPDS", null);
			
			emailServiceImpl.sendHtmlMessageWithAttachment(kpdsEmailSendTo, "KPDS", "Test kpds email.", "kpds-projectId_"+kpds.getProject().getId()+".pdf", new java.io.File(path_kpds_generated+"/kpds-projectId_"+kpds.getProject().getId()+".pdf"));
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void writeTextWithMaxLength(
			PDPageContentStream contentStream, 
			PDType0Font fontType,
			int fontSize,
			int xStart,
			int yStart,
			String text,
			int maxLength
			) throws IOException 
		{		
		String textMaxLength = null;
//		String textLeft = null;
		if (text.length() > maxLength) {
			textMaxLength = text.substring(0, maxLength);
			text = text.substring(maxLength);
			writeText(contentStream, fontType, fontSize, xStart, yStart, textMaxLength);	
			writeTextWithMaxLength(contentStream, fontType, fontSize, xStart, yStart-15, text, maxLength);
		} else {
			writeText(contentStream, fontType, fontSize, xStart, yStart, text);	
		}
		
	}
	
	private void writeText(
			PDPageContentStream contentStream, 
			PDType0Font fontType,
			int fontSize,
			int xStart,
			int yStart,
			String text
			) throws IOException {
		contentStream.beginText();
		contentStream.setFont(fontType, fontSize);
		contentStream.newLineAtOffset(xStart, yStart);
		contentStream.showText(text);
		contentStream.endText();
	}

	private void drawLine(PDPageContentStream contentStream, int xStart, int yStart, int xEnd, int yEnd) throws IOException {
		contentStream.moveTo(xStart, yStart);
		contentStream.lineTo(xEnd, yEnd);
		contentStream.stroke();
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
