package pl.krzysztofskul.attachment;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AttachmentRepo extends JpaRepository<Attachment, Long> {

}
