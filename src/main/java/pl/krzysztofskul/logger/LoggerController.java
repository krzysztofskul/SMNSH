package pl.krzysztofskul.logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pl.krzysztofskul.logger.loggerProject.LoggerProjectService;
import pl.krzysztofskul.logger.loggerUser.LoggerUser;
import pl.krzysztofskul.logger.loggerUser.LoggerUserService;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;


@Controller
public class LoggerController {

    private LoggerUserService<Object> loggerUserService;
    private LoggerProjectService<Object> loggerProjectService;

    @Autowired
    public LoggerController(
            LoggerUserService<Object> loggerUserService,
            LoggerProjectService<Object> loggerProjectService
    ) {
        this.loggerUserService = loggerUserService;
        this.loggerProjectService = loggerProjectService;
    }

    /** logs for admin */
    @GetMapping("/admin/logs/all")
    public String logsAll(
            Model model
    ) {
        List<LoggerUser> logsAll = loggerUserService.loadAll();
        Collections.sort(logsAll, new Comparator<LoggerUser>() {
            @Override
            public int compare(LoggerUser o1, LoggerUser o2) {
                return o2.getLocalDateTime().compareTo(o1.getLocalDateTime());
            }
        });
        model.addAttribute("logs", logsAll);
        return "/admin/logs/all";
    }

    /** logs for users */
    @GetMapping("/logs/project/{projectId}")
    public String logsProjectById(
            @PathVariable(name = "projectId") Long projectId,
            Model model
    ) {
        model.addAttribute("projectLogs", loggerProjectService.loadByProjectId(projectId));
        return "projects/logs/projectLogs";
    }
}
