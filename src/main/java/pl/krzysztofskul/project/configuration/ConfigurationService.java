package pl.krzysztofskul.project.configuration;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.krzysztofskul.device.part.Part;
import pl.krzysztofskul.device.part.PartService;
import pl.krzysztofskul.project.Project;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
@Transactional
public class ConfigurationService {

    private ConfigurationRepo configurationRepo;
    private PartService partService;

    @Autowired
    public ConfigurationService(ConfigurationRepo configurationRepo, PartService partService) {
        this.configurationRepo = configurationRepo;
        this.partService = partService;
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

    public Configuration getTestConfiguration(Project project) {

            Configuration configuration = new Configuration();
            configuration.setProject(project);
            List<Part> partList = new ArrayList<>();
            for (int i = 0; i < 5; i++) {
                Random random = new Random();
                partList.add(
                        partService.loadById(
                                Long.parseLong(
                                        String.valueOf(random.nextInt(partService.loadAll().size())
                                        )
                                )
                        )
                );
            }
            configuration.setPartList(partList);
            //this.save(configuration);
            return configuration;

    }

}
