package pl.krzysztofskul.device;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

public class DeviceConverter implements Converter<String, Device> {

    @Autowired
    private DeviceService deviceService;

    @Override
    public Device convert(String s) {
        return deviceService.loadById(Long.valueOf(s));
    }
}
