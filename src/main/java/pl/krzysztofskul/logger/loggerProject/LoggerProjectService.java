package pl.krzysztofskul.logger.loggerProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.krzysztofskul.project.Project;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class LoggerProjectService<T> /*implements LoggerService<Project>*/ {

    private LoggerProjectRepo loggerProjectRepo;

    @Autowired
    public LoggerProjectService(LoggerProjectRepo loggerProjectRepo) {
        this.loggerProjectRepo = loggerProjectRepo;
    }

//    @Override
    public void log(Project project, LocalDateTime localDateTime, String actionEN, T actionBy) {
        LoggerProject loggerProject = new LoggerProject();

        loggerProject.setProject(project);
        loggerProject.setLocalDateTime(localDateTime);
        loggerProject.setActionEN(actionEN);
        loggerProject.setActionBy(actionBy.toString());
        loggerProjectRepo.save(loggerProject);
    }

    public List<LoggerProject> loadByProjectId(Long projectId) {
        return loggerProjectRepo.findByProjectId(projectId);
    }

}
