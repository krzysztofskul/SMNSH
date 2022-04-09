package pl.krzysztofskul.project.configuration;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfigurationRepo extends JpaRepository<Configuration, Long> {
	
	List<Configuration> findAllByProjectId(Long projectId);
	
}
