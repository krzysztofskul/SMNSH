package pl.krzysztofskul.logger.loggerUser;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LoggerUserRepo extends JpaRepository<LoggerUser, Long> {

}
