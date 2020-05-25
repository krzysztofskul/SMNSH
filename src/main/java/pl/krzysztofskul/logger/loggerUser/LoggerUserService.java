package pl.krzysztofskul.logger.loggerUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.krzysztofskul.user.User;
import pl.krzysztofskul.user.UserAction;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

@Service
@Transactional
public class LoggerUserService<T> /*implements LoggerService<User>*/ {

    private LoggerUserRepo loggerUserRepo;

    @Autowired
    public LoggerUserService(LoggerUserRepo loggerUserRepo) {
        this.loggerUserRepo = loggerUserRepo;
    }

    //    @Override
    public void log(User user, LocalDateTime localDateTime, UserAction userAction, T actionAt) {
        LoggerUser loggerUser = new LoggerUser();
        loggerUser.setUser(user);
//        loggerUser.setLocalDateTime(localDateTime);
        ZoneId zonedId = ZoneId.of("Europe/Warsaw");
//        loggerUser.setLocalDateTime(LocalDateTime.now(zonedId));
        loggerUser.setLocalDateTime(localDateTime.atZone(zonedId).toLocalDateTime());
        loggerUser.setUserAction(userAction);
        if (actionAt != null) {
            loggerUser.setActionAt(actionAt.toString());
        } else {
            loggerUser.setActionAt("smnsh app.");
        }
        loggerUserRepo.save(loggerUser);
    }

    public List<LoggerUser> loadAll() {
        return loggerUserRepo.findAll();
    }

}
