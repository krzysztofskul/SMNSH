package pl.krzysztofskul.project;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.krzysztofskul.device.Device;
import pl.krzysztofskul.device.DeviceService;
import pl.krzysztofskul.device.part.PartService;
import pl.krzysztofskul.importdata.ImportData;
import pl.krzysztofskul.investor.Investor;
import pl.krzysztofskul.investor.InvestorService;
import pl.krzysztofskul.investor.SapInfo;
import pl.krzysztofskul.logger.loggerProject.LoggerProjectService;
import pl.krzysztofskul.project.comment.Comment;
import pl.krzysztofskul.project.configuration.Configuration;
import pl.krzysztofskul.project.configuration.ConfigurationService;
import pl.krzysztofskul.projectCharter.ProjectCharter;
import pl.krzysztofskul.user.User;
import pl.krzysztofskul.user.UserBusinessPosition;
import pl.krzysztofskul.user.UserService;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class ProjectService {

    private ProjectRepo projectRepo;
    private PartService partService;
    private ConfigurationService configurationService;
    private LoggerProjectService loggerProjectService;
    private DeviceService deviceService;
    private UserService userService;
    private InvestorService investorService;

    @Autowired
    public ProjectService(
            ProjectRepo projectRepo,
            PartService partService, ConfigurationService configurationService, LoggerProjectService loggerProjectService,
            DeviceService deviceService, UserService userService, InvestorService investorService) {
        this.projectRepo = projectRepo;
        this.partService = partService;
        this.configurationService = configurationService;
        this.loggerProjectService = loggerProjectService;
        this.deviceService = deviceService;
        this.userService = userService;
        this.investorService = investorService;
    }

    /** CRUD METHODS */

    public void save(Project project) {
        if (project.getId() == null) {
        	loggerProjectService.log(project, ZonedDateTime.now(ZoneId.of("Europe/Warsaw")).toLocalDateTime(), "Projekt created/imported.", "Utworzono/zaimportowano projekt.", project.getSls());
            for (Device device : project.getDeviceList()) {
                Hibernate.initialize(device.getConfigurationList());
                device.addConfiguration(configurationService.getStandardConfiguration(project, device));
                //deviceService.save(device);
            }
        }

        projectRepo.save(project);
    }
    
    public Project saveAndReturn(Project project) {
        if (project.getId() == null) {
            for (Device device : project.getDeviceList()) {
                Hibernate.initialize(device.getConfigurationList());
                device.addConfiguration(configurationService.getStandardConfiguration(project, device));
                //deviceService.save(device);
            }
        }

        return projectRepo.save(project);
    }

    public List<Project> loadAll() {
        return projectRepo.findAll();
    }
    
	public List<Project> loadAllByUserId(Long userId) {
		// TODO Auto-generated method stub
		
		List<Project> projectList = new ArrayList<Project>();
		
		User user = userService.loadById(userId);
		switch (user.getBusinessPosition()) {
		case SALES_REP: {
			 projectList = projectRepo.findAllBySls(user);
			break;
		}
		case PROJECT_MANAGER: {
			projectList = projectRepo.findAllByProjectManager(user);
			break;
		}
		case PLANNER: {
			projectList = projectRepo.findAllByDes(user);
			break;
		}
		default:
			break;
		}
        for (Project project : projectList) {
            Hibernate.initialize(project.getDeviceList());
        }
		return projectList;
	}

    public List<Project> loadAllByIdWithDeviceList(Long userId) {
        User user = userService.loadById(userId);
        List<Project> projectList;
        switch (user.getBusinessPosition().name()) {
            case "SALES_REP": {
                projectList = projectRepo.findAllBySls(user);
                break;
            }
            case "PROJECT_MANAGER": {
                projectList = projectRepo.findAllByProjectManager(user);
                break;
            }
            case "PLANNER": {
                projectList = projectRepo.findAllByDes(user);
                break;
            }
            default:
                projectList = projectRepo.findAllById(userId);
                break;
        }
        for (Project project : projectList) {
            Hibernate.initialize(project.getDeviceList());
        }
        return projectList;
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
    
	public Project loadByIdWithStakeholders(Long id) {
		Project project = this.loadById(id);
		ProjectCharter projectCharter = project.getProjectCharter();
		Hibernate.initialize(projectCharter.getStakeholders());
		return project;
	}

    public Project loadByIdWithConceptList(Long id) {
        Project project = projectRepo.findById(id).get();
        Hibernate.initialize(project.getConceptList());
        return project;
    }

    public Project loadByIdWithDeviceList(Long id) {
        Project project = projectRepo.findById(id).get();
        Hibernate.initialize(project.getDeviceList());
        return project;
    }

    public Project loadByIdWithDeviceListAndConceptList(Long id) {
        Project project = projectRepo.findById(id).get();
        Hibernate.initialize(project.getDeviceList());
        Hibernate.initialize(project.getLoggerProjectList());
        Hibernate.initialize(project.getConfigurationList());
        Hibernate.initialize(project.getPrototypeList());
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

	public Project convertDataSlsToProject(Project project) {

		project = convertProjectManager(project);
		project = convertInvestor(project);
		
		return project;
	}

	private Project convertInvestor(Project project) {
		//TODO 2022-11-18
		int counter = 0;
		if (null != project.getDetailsSls().getImportedCustomer()) {
			String investorSapNo = project.getDetailsSls().getImportedCustomer();
			if (null != investorService.loadBySapNo(investorSapNo)) {
				Investor investor = investorService.loadBySapNo(investorSapNo);	
				project.setInvestor(investor);
			} else {
				// TODO 2022-11-18 try to add new investor to db if not found and try to convert again
					// save path to Xls file in DetailsSls while importing ne project first ...
				if (counter == 0) { // try to import and save new investor only once
					Map<String,String> dataImported = ImportData.getImportDataSingleton().importInvestorFromXls(project.getDetailsSls().getPathToXls());
					Investor investor = new Investor();
					investor.setSapInfo(new SapInfo(dataImported.get("sapNo"), null, null));
					investor.setName(dataImported.get("customer"));
					
					investor = investorService.saveAndReturn(investor);
					
					project.setInvestor(investor);
					
					counter++;
				}
			} {
				
			}
		}
		return project;
	}

	/**
	 * Converts project manager (String) imported from sls data to project class
	 * @param Project 
	 * @return Project
	 */
	private Project convertProjectManager(Project project) {
		
		if (project.getDetailsSls().getImportedProjectManager().contains("Kra")) {
			project.setProjectManager(userService.loadByEmail("sebastian.k@test.test"));
		}
		if (project.getDetailsSls().getImportedProjectManager().contains("Wil")) {
			project.setProjectManager(userService.loadByEmail("ewa.w-m@test.test"));
		}
		if (project.getDetailsSls().getImportedProjectManager().contains("Sil")) {
			project.setProjectManager(userService.loadByEmail("henryk.s@test.test"));
		}
		if (project.getDetailsSls().getImportedProjectManager().contains("Szp")) {
			project.setProjectManager(userService.loadByEmail("sebastian.s@test.test"));
		}
		if (project.getDetailsSls().getImportedProjectManager().contains("Rel")) {
			project.setProjectManager(userService.loadByEmail("sebastian.r@test.test"));
		}
		if (project.getDetailsSls().getImportedProjectManager().contains("Szo")) {
			project.setProjectManager(userService.loadByEmail("kamil.s@test.test"));
		}
		if (project.getDetailsSls().getImportedProjectManager().contains("Pon")) {
			project.setProjectManager(userService.loadByEmail("wojciech.p@test.test"));
		}
		if (project.getDetailsSls().getImportedProjectManager().contains("Ols")) {
			project.setProjectManager(userService.loadByEmail("arkadiusz.o@test.test"));
		}
		if (project.getDetailsSls().getImportedProjectManager().contains("Saw")) {
			project.setProjectManager(userService.loadByEmail("piotr.s@test.test"));
		}
		if (project.getDetailsSls().getImportedProjectManager().contains("San")) {
			project.setProjectManager(userService.loadByEmail("krzysztof.s@test.test"));
		}
		if (project.getDetailsSls().getImportedProjectManager().contains("Jag")) {
			project.setProjectManager(userService.loadByEmail("marika.j-b@test.test"));
		}
		if (project.getDetailsSls().getImportedProjectManager().contains("Chr")) {
			project.setProjectManager(userService.loadByEmail("mateusz.c@test.test"));
		}
		if (project.getDetailsSls().getImportedProjectManager().contains("Neu")) {
			project.setProjectManager(userService.loadByEmail("jaroslaw.n@test.test"));
		}
		if (project.getDetailsSls().getImportedProjectManager().contains("Bar")) {		
			project.setProjectManager(userService.loadByEmail("emilia.b@test.test"));
		}
		return project;
	}




}