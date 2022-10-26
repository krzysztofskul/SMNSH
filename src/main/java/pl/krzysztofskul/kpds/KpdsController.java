package pl.krzysztofskul.kpds;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.pdf.PdfWriter;

import pl.krzysztofskul.project.Project;

@Controller
public class KpdsController {
	
	private KpdsService kpdsService;
	
	@Autowired
	private KpdsController(KpdsService kpdsService) {
		super();
		this.kpdsService = kpdsService;
	}

	@GetMapping("/downloadTestKpds")
	public String generateTestKpdsPdf() throws IOException {
		

		Document document = new Document();
		try {
			
			/*
			 * create and save a pdf using iText
			 */
			PdfWriter.getInstance(document, new FileOutputStream("D://SMNSH/karta_projektu/kpds.pdf"));
			
			document.open();
			Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);
			Chunk chunk = new Chunk("Test title Lorem Ipsum", font);

			document.add(chunk);
			document.close();
			
			/*
			 * create and save a pdf using PdfBox
			 */
			PDDocument documentPdfBox = new PDDocument();
			PDPage page = new PDPage();
			documentPdfBox.addPage(page);

			PDPageContentStream contentStream = new PDPageContentStream(documentPdfBox, page);

			contentStream.setFont(PDType1Font.COURIER, 12);
			contentStream.beginText();
			contentStream.showText("Test title Lorem Ipsum by PdfBox");
			contentStream.endText();
			contentStream.close();

			documentPdfBox.save("D://SMNSH/karta_projektu/kpds_byPdfBox.pdf");
			documentPdfBox.close();
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "redirect:/home";
		
	}

	@GetMapping("/generate-kpds/{projectId}")
	public String generateKpds(
				@PathVariable Long projectId
			) {
		kpdsService.generateKpds(projectId);
		return "redirect:/home";
	}

	// test
	@GetMapping("/kpds/{kpdsId}")
	public void getKpdsById(
				@PathVariable Long kpdsId
			) {
		Kpds kpds = kpdsService.loadById(kpdsId);
	}
}
