package pl.krzysztofskul.attachment;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class AttachmentCategoryService {

	private AttachmentCategoryRepo attachmentCategoryRepo;

	@Autowired
	public AttachmentCategoryService(AttachmentCategoryRepo attachmentCategoryRepo) {
		this.attachmentCategoryRepo = attachmentCategoryRepo;
	}
	
	public AttachmentCategory save(AttachmentCategory ac) {
		return attachmentCategoryRepo.save(ac);
	}
	
}
