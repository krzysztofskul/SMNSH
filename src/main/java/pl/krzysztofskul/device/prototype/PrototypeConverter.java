package pl.krzysztofskul.device.prototype;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

public class PrototypeConverter implements Converter<String, Prototype> {

    @Autowired
    private PrototypeService prototypeService;

    @Override
    public Prototype convert(String s) {
        return prototypeService.loadById(Long.valueOf(s));
    }
}
