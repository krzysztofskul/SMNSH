package pl.krzysztofskul.recipient;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipientRepo extends JpaRepository<Recipient, Long> {
}
