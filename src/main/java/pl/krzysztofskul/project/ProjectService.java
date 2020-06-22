package pl.krzysztofskul.project;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.krzysztofskul.logger.loggerProject.LoggerProjectService;
import pl.krzysztofskul.user.User;

import java.util.List;

@Service
@Transactional
public class ProjectService {

    private ProjectRepo projectRepo;
    private LoggerProjectService loggerProjectService;

    @Autowired
    public ProjectService(
            ProjectRepo projectRepo,
            LoggerProjectService loggerProjectService
    ) {
        this.projectRepo = projectRepo;
        this.loggerProjectService = loggerProjectService;
    }

    /** CRUD METHODS */

    public void save(Project project) {
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
        Hibernate.initialize(project.getConceptList());
        return project;
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