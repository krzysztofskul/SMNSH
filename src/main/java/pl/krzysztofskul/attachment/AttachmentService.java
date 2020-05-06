package pl.krzysztofskul.attachment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import pl.krzysztofskul.project.Project;
import pl.krzysztofskul.project.ProjectService;

import java.io.IOException;

@Service
@Transactional
public class AttachmentService {

    private AttachmentRepo attachmentRepo;
    private ProjectService projectService;

    @Autowired
    public AttachmentService(
            AttachmentRepo attachmentRepo, ProjectService projectService
    ) {
        this.attachmentRepo = attachmentRepo;
        this.projectService = projectService;
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

        attachmentRepo.save(attachment);

    }

    public Attachment loadById(Long attachmentId) {
        return attachmentRepo.findById(attachmentId).get();
    }
}
