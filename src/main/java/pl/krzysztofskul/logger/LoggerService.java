package pl.krzysztofskul.logger;

import java.time.LocalDateTime;

public interface LoggerService<T> {

    void log(T t, LocalDateTime localDateTime, String actionEN);

}
