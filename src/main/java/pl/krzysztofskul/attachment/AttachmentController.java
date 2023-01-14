package pl.krzysztofskul.attachment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class AttachmentController {

	private AttachmentRepo attachmentRepo;
	
	
	@Autowired
	private AttachmentController(AttachmentRepo attachmentRepo) {
		super();
		this.attachmentRepo = attachmentRepo;
	}

	
	
}
