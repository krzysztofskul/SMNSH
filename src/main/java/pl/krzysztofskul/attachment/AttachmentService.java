package pl.krzysztofskul.attachment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import pl.krzysztofskul.project.Project;
import pl.krzysztofskul.project.ProjectService;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

@Service
@Transactional
public class AttachmentService {

    private AttachmentRepo attachmentRepo;
    private ProjectService projectService;
    private AttachmentCategoryService attachmentCategoryService;

    @Autowired
    public AttachmentService(
            AttachmentRepo attachmentRepo, ProjectService projectService,
            AttachmentCategoryService attachmentCategoryService
    ) {
        this.attachmentRepo = attachmentRepo;
        this.projectService = projectService;
        this.attachmentCategoryService = attachmentCategoryService;
    }

    public void save(MultipartFile multipartFile) throws IOException {
        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());

        Attachment attachment = new Attachment();
        attachment.setFileName(fileName);
        attachment.setFileType(multipartFile.getContentType());
        attachment.setData(multipartFile.getBytes());

        attachmentRepo.save(attachment);
    }

    public void saveToProject(MultipartFile multipartFile, Project project) throws IOException {
        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());

        Attachment attachment = new Attachment();
        attachment.setFileName(fileName);
        attachment.setFileType(multipartFile.getContentType());
        attachment.setData(multipartFile.getBytes());

        attachment.setProject(project);

        if (attachment.getAttachmentCategory() == null) {
        	attachment.setAttachmentCategory(attachmentCategoryService.loadByCode("DOC-GENERAL"));
        }
        
        attachmentRepo.save(attachment);

    }
    
    public Project setToProject(File file, Project project, String attachmentType) throws IOException {
    	
		FileInputStream fis = new FileInputStream(file);
		byte[] fileDataByte  = fis.readAllBytes();
		
        String fileName = file.getName().substring(0, file.getName().indexOf("."));
        String fileType = file.getName().substring(file.getName().indexOf(".")+1);
        fileType = Files.probeContentType(file.toPath());

        Attachment attachment = new Attachment();
        attachment.setFileName(fileName);
        attachment.setFileType(fileType);
        attachment.setData(fileDataByte);

        
        //attachment.setProject(project);

        if (attachment.getAttachmentCategory() == null) {
        	attachment.setAttachmentCategory(attachmentCategoryService.loadByCode("DOC-GENERAL"));
        }
        
        if (attachmentType.equals("offers")) {
        	attachment.setAttachmentCategory(attachmentCategoryService.loadByCode("DOC-OFFER"));
        }
        
        project.addAttachment(attachment);
        
        return project;

    }

    public Attachment loadById(Long attachmentId) {
        return attachmentRepo.findById(attachmentId).get();
    }
    
    public List<Attachment> loadAll() {
    	return attachmentRepo.findAll();
    }
}
