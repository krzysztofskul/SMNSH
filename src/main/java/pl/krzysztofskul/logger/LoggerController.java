package pl.krzysztofskul.logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.krzysztofskul.logger.loggerUser.LoggerUserService;


@Controller
@RequestMapping("/admin/logs")
public class LoggerController {

    private LoggerUserService<Object> loggerUserService;

    @Autowired
    public LoggerController(LoggerUserService<Object> loggerUserService) {
        this.loggerUserService = loggerUserService;
    }


    @GetMapping("/all")
    public String logsAll(
            Model model
    ) {
        model.addAttribute("logs", loggerUserService.loadAll());
        return "/admin/logs/all";
    }

}
