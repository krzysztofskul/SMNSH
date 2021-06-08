package pl.krzysztofskul.project;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.krzysztofskul.device.Device;
import pl.krzysztofskul.device.DeviceService;
import pl.krzysztofskul.device.part.PartService;
import pl.krzysztofskul.logger.loggerProject.LoggerProjectService;
import pl.krzysztofskul.project.comment.Comment;
import pl.krzysztofskul.project.configuration.Configuration;
import pl.krzysztofskul.project.configuration.ConfigurationService;
import pl.krzysztofskul.user.User;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
@Transactional
public class ProjectService {

    private ProjectRepo projectRepo;
    private PartService partService;
    private ConfigurationService configurationService;
    private LoggerProjectService loggerProjectService;
    private DeviceService deviceService;

    @Autowired
    public ProjectService(
            ProjectRepo projectRepo,
            PartService partService, ConfigurationService configurationService, LoggerProjectService loggerProjectService,
            DeviceService deviceService) {
        this.projectRepo = projectRepo;
        this.partService = partService;
        this.configurationService = configurationService;
        this.loggerProjectService = loggerProjectService;
        this.deviceService = deviceService;
    }

    /** CRUD METHODS */

    public void save(Project project) {
        if (project.getId() == null) {
            for (Device device : project.getDeviceList()) {
                Hibernate.initialize(device.getConfigurationList());
                device.addTestConfiguration(configurationService.getTestConfiguration(project));
                //deviceService.save(device);
            }
        }

        projectRepo.save(project);
    }

//    public void saveAndLog(Project project, String logActionEN) {
//        projectRepo.save(project);
//        loggerProjectService.log(project, LocalDateTime.now(), logActionEN, null);
//    }

    public List<Project> loadAll() {
        return projectRepo.findAll();
    }

    public List<Project> loadAllWithDeviceList() {
        List<Project> projectList = projectRepo.findAll();
        for (Project project : projectList) {
            Hibernate.initialize(project.getDeviceList());
        }
        return projectList;
    }

    public Project loadById(Long id) {
        return projectRepo.findById(id).get();
    }

    public Project loadByIdWithDeviceList(Long id) {
        Project project = projectRepo.findById(id).get();
        Hibernate.initialize(project.getDeviceList());
        return project;
    }

    public Project loadByIdWithDeviceListAndConceptList(Long id) {
        Project project = projectRepo.findById(id).get();
        Hibernate.initialize(project.getDeviceList());
        Hibernate.initialize(project.getConfigurationList());
        for (Device device : project.getDeviceList()) {
            Hibernate.initialize(device.getConfigurationList());
            for (Configuration configuration : device.getConfigurationList()) {
                Hibernate.initialize(configuration.getPartList());
            }
        }
        Hibernate.initialize(project.getConceptList());
        return project;
    }


    public List<Project> loadAllWithConfigurationList() {
        List<Project> projectList = projectRepo.findAll();
        for (Project project : projectList) {
            Hibernate.initialize(project.getConfigurationList());
        }
        return projectList;
    }

    public List<Project> loadAllByStatusWithDevices(StatusProject statusProject) {
        List<Project> projects = projectRepo.findAllByStatusOrderByDeadlineAsc(statusProject);
        for (Project project : projects) {
            Hibernate.initialize(project.getDeviceList());
        }
        return projects;
    }

    public Project loadByProjectName(String projectName) {
        return projectRepo.findByProjectName(projectName);
    }

    public List<Project> loadAllByProjectManager(User user) {
        return projectRepo.findAllByProjectManager(user);
    }

    public Project loadByIdWithComments(Long id) {
        Project project = projectRepo.findById(id).get();
        Hibernate.initialize(project.getCommentList());
        Collections.sort(project.getCommentList(), new Comparator<Comment>() {
            @Override
            public int compare(Comment c1, Comment c2) {
                return c2.getDateOfCreation().compareTo(c1.getDateOfCreation());
            }
        });
        return project;
    }

    public void deleteById(Long projectId) {
        projectRepo.deleteById(projectId);
    }

    public void deleteByProjectName(String name) {
        List<Project> projectList = projectRepo.findAll();
        for (Project project : projectList) {
            if (name.equals(project.getProjectName())) {
                projectRepo.delete(project);
            }
        }
    }



}