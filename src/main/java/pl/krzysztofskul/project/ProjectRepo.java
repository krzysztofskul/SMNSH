package pl.krzysztofskul.project;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.krzysztofskul.user.User;

import java.util.List;

public interface ProjectRepo extends JpaRepository<Project, Long> {

    List<Project> findAllByStatusOrderByDeadlineAsc(StatusProject statusProject);

    Project findByProjectName(String projectName);

    List<Project> findAllByProjectManager(User user);

    List<Project> findAllById(Long userId);

    List<Project> findAllBySls(User user);

    List<Project> findAllByDes(User user);
}
