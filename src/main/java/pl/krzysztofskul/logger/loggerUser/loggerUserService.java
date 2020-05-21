package pl.krzysztofskul.logger.loggerUser;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.krzysztofskul.logger.LoggerService;
import pl.krzysztofskul.user.User;

import java.time.LocalDateTime;

@Service
@Transactional
public class loggerUserService implements LoggerService<User> {

    @Override
    public void log(User user, LocalDateTime localDateTime, String actionEN) {

    }
}
