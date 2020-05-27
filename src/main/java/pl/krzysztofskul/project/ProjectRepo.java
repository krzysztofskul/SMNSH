package pl.krzysztofskul.project;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectRepo extends JpaRepository<Project, Long> {

    List<Project> findAllByStatusOrderByDeadlineAsc(StatusProject statusProject);

    Project findByProjectName(String projectName);

}
