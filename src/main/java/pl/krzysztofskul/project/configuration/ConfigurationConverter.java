package pl.krzysztofskul.project.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

public class ConfigurationConverter implements Converter<String, Configuration> {
	
	@Autowired
	private ConfigurationService configurationService;

	@Override
	public Configuration convert(String s) {
		return configurationService.loadByIdWithParts(Long.parseLong(s));
	}
	
}
