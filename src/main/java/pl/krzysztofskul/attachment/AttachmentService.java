package pl.krzysztofskul.attachment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@Transactional
public class AttachmentService {

    private AttachmentRepo attachmentRepo;

    @Autowired
    public AttachmentService(AttachmentRepo attachmentRepo) {
        this.attachmentRepo = attachmentRepo;
    }

    public void save(MultipartFile multipartFile) throws IOException {
        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());

        Attachment attachment = new Attachment();
        attachment.setFileName(fileName);
        attachment.setFileType(multipartFile.getContentType());
        attachment.setData(multipartFile.getBytes());

        attachmentRepo.save(attachment);
    }

}
