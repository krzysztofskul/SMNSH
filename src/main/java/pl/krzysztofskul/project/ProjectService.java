package pl.krzysztofskul.project;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProjectService {

    private ProjectRepo projectRepo;

    @Autowired
    public ProjectService(ProjectRepo projectRepo) {
        this.projectRepo = projectRepo;
    }

    public void save(Project project) {
        projectRepo.save(project);
    }

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

    public void deleteByProjectName(String name) {
        List<Project> projectList = projectRepo.findAll();
        for (Project project : projectList) {
            if (name.equals(project.getProjectName())) {
                projectRepo.delete(project);
            }
        }
    }
}