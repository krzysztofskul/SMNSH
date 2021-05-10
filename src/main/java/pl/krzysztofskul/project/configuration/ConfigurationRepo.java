package pl.krzysztofskul.project.configuration;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfigurationRepo extends JpaRepository<Configuration, Long> {
}
