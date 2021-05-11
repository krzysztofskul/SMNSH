package pl.krzysztofskul.project.configuration;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.krzysztofskul.device.part.Part;

import java.util.List;

@Service
@Transactional
public class ConfigurationService {

    private ConfigurationRepo configurationRepo;

    @Autowired
    public ConfigurationService(ConfigurationRepo configurationRepo) {
        this.configurationRepo = configurationRepo;
    }

    public Configuration save(Configuration configuration) {
        return configurationRepo.save(configuration);
    }

    public List<Configuration> loadAll() {
        return configurationRepo.findAll();
    }

    public Configuration loadByIdWithParts(Long id) {
        Configuration configuration = configurationRepo.findById(id).get();
        Hibernate.initialize(configuration.getPartList());
        return configuration;
    }
}
