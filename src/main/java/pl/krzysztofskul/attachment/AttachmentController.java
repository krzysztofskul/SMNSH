package pl.krzysztofskul.attachment;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import pl.krzysztofskul.logger.LoggerService;
import pl.krzysztofskul.logger.loggerProject.LoggerProjectService;
import pl.krzysztofskul.project.Project;
import pl.krzysztofskul.project.ProjectService;

@Controller
public class AttachmentController {

	private AttachmentService attachmentService;
	private ProjectService projectService;
	private LoggerProjectService<Object> loggerProjectService;
	
	
	@Autowired
	private AttachmentController(
			AttachmentService attachmentService,
			ProjectService projectService,
			LoggerProjectService<Object> loggerProjectService
			) {
		super();
		this.attachmentService = attachmentService;
		this.projectService = projectService;
		this.loggerProjectService = loggerProjectService;
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
	
	@GetMapping("/attachments/new")
	public String getAttachmentsNew(
				@RequestParam(value = "projectId", required = false) Long projectId,
				Model model
			) {
		Attachment attachment = new Attachment();
		if (projectId != null) {
			attachment.setProject(projectService.loadById(projectId));
		}
		model.addAttribute("attachment", attachment);
		model.addAttribute("project", projectService.loadById(projectId));
		return "attachment/new";
	}
	
	@PostMapping("/attachments/new")
	public String postAttachmentsNew(
			@ModelAttribute(name = "attachment") Attachment attachment,
			@RequestParam(name = "fileUpload", required = false) MultipartFile fileUpload,
			@RequestParam(name = "description", required = false) String description,
			@RequestParam(name = "projectId", required = false) Long projectId,
			HttpSession httpSession
		) throws IOException
	{
			if (attachment != null) {
				attachmentService.saveToProject(fileUpload, attachment.getProject(), description);
			}
			
        	if (fileUpload.getOriginalFilename() != null & fileUpload.getOriginalFilename() != "" && projectId != null) {
        		Project project = projectService.loadById(projectId);
                attachmentService.saveToProject(fileUpload, project, description);
                loggerProjectService.log(project, ZonedDateTime.now(ZoneId.of("Europe/Warsaw")).toLocalDateTime(), "Attachement added.", "Dodano załącznik", httpSession.getAttribute("userLoggedIn"));        		
        	}
        
        	
		return "redirect:/projects/"+attachment.getProject().getId()+"/attachments";
	}
	
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
