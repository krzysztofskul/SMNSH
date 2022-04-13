package pl.krzysztofskul.logger.loggerProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.krzysztofskul.project.Project;
import pl.krzysztofskul.user.User;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Comparator;
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
    public void log(Project project, LocalDateTime localDateTime, String actionEN, String actionPL, T actionBy) {
        LoggerProject loggerProject = new LoggerProject();

        loggerProject.setProject(project);
        loggerProject.setLocalDateTime(localDateTime);
        loggerProject.setActionEN(actionEN);
        loggerProject.setActionPL(actionPL);
        if (actionBy == null) {
            loggerProject.setActionBy("n/a");
        }
        else if (actionBy.getClass() == String.class) {
            loggerProject.setActionBy((String) actionBy);
        } else if (actionBy.getClass() == User.class) {
            loggerProject.setActionBy(((User) actionBy).getNameFirst()+" "+((User) actionBy).getNameLast());
        } else {
            loggerProject.setActionBy(actionBy.toString());
        }
        loggerProjectRepo.save(loggerProject);
    }

    public List<LoggerProject> loadByProjectId(Long projectId) {
        List<LoggerProject> projectLogs = loggerProjectRepo.findByProjectId(projectId);
        Collections.sort(projectLogs, new Comparator<LoggerProject>() {
            @Override
            public int compare(LoggerProject o1, LoggerProject o2) {
                return o2.getId().compareTo(o1.getId());
            }
        });
        return projectLogs;
    }

}
