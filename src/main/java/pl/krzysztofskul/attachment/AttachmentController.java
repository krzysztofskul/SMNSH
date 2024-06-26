package pl.krzysztofskul.attachment;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AttachmentController {

	private AttachmentService attachmentService;
	
	
	@Autowired
	private AttachmentController(AttachmentService attachmentService) {
		super();
		this.attachmentService = attachmentService;
	}

	/*
	 * Obsolete; no file name set when save on hdd.
	 */
//	@GetMapping(value = "/attachments/download/{attachmentId}", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
//	public @ResponseBody byte[] getDownloadAttachment(
//				@PathVariable Long attachmentId
//			) {
//		return attachmentService.loadById(attachmentId).getData();
//		
//	}
	
	@GetMapping(value = "/attachments/download/{attachmentId}")
	public ResponseEntity<ByteArrayResource> getDownloadAttachment(
				@PathVariable Long attachmentId
			) {
		Attachment attachment = attachmentService.loadById(attachmentId);
		return ResponseEntity.ok()
				.contentType(MediaType.parseMediaType(attachment.getFileType()))
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename="+attachment.getFileName())
				.body(new ByteArrayResource(attachment.getData()));
		
	}
	
	
}
