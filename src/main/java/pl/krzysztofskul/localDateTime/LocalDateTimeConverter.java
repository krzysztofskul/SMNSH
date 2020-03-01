package pl.krzysztofskul.localDateTime;

import org.springframework.core.convert.converter.Converter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeConverter implements Converter<String, LocalDateTime> {

    @Override
    public LocalDateTime convert(String s) {
        LocalDate date = LocalDate.parse(s);
        LocalDateTime dateTimeConverted = LocalDateTime.of(date.getYear(), date.getMonth(), date.getDayOfMonth(), 23, 59, 59, 00);
        return dateTimeConverted;
    }
}
