package pl.krzysztofskul.project.configuration;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.krzysztofskul.device.Device;
import pl.krzysztofskul.device.part.Part;
import pl.krzysztofskul.device.part.PartService;
import pl.krzysztofskul.device.prototype.Prototype;
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

    public List<Configuration> loadAllByProjectIdWithParts(Long projectId) {
    	
    	List<Configuration> configurationList = configurationRepo.findAllByProjectId(projectId);
    	for (Configuration configuration : configurationList) {
			Hibernate.initialize(configuration.getPartList());
		}
    	
    	return configurationList;
    }
    
    public Configuration loadByIdWithParts(Long id) {
        Configuration configuration = configurationRepo.findById(id).get();
        Hibernate.initialize(configuration.getPartList());
        return configuration;
    }

    public Configuration getTestConfiguration(Project project) {

            Configuration configuration = new Configuration();
            //configuration.setProject(project);
            project.addConfiguration(configuration);
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

    public Configuration getStandardConfiguration(Project project, Device device) {

        Configuration configuration = new Configuration();
        device.addConfiguration(configuration);

        if (device.getDeviceCategory().getCode().contains("X-RAY")) {
            for (long i = 1; i <= 5 ; i++) {
                configuration.addPart(partService.loadById(i));
            }
        } else if (device.getDeviceCategory().getCode().contains("CT")) {
            for (long i = 6; i <= 15 ; i++) {
                configuration.addPart(partService.loadById(i));
            }
        } else if (device.getDeviceCategory().getCode().contains("MRI")) {
            for (long i = 16; i <= 25 ; i++) {
                configuration.addPart(partService.loadById(i));
            }
        } else {
            return getTestConfiguration(project);
        }

        project.addConfiguration(configuration);

        return configuration;
    }
    
    public Configuration getStandardConfiguration(Project project, Prototype prototype) {

        //Configuration configuration = new Configuration();
        //prototype.addConfiguration(configuration);

        return this.getTestConfiguration(project);

        //project.addConfiguration(configuration);

        //return configuration;
    }

}
