package pl.krzysztofskul.localDateTime;

import org.springframework.core.convert.converter.Converter;

import java.time.LocalDateTime;

public class LocalDateTimeConverterToString implements Converter<LocalDateTime, String> {

    @Override
    public String  convert(LocalDateTime ldt) {
        String string = ldt.toLocalDate().toString();
        return string;
    }
}
