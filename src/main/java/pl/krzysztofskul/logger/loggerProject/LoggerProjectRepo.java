package pl.krzysztofskul.logger.loggerProject;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LoggerProjectRepo extends JpaRepository<LoggerProject, Long> {

    List<LoggerProject> findByProjectId(Long projectId);

}
