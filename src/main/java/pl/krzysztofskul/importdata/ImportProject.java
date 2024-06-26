package pl.krzysztofskul.importdata;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.krzysztofskul.HomePageService;
import pl.krzysztofskul.attachment.Attachment;
import pl.krzysztofskul.attachment.AttachmentService;
import pl.krzysztofskul.device.prototype.PrototypeService;
import pl.krzysztofskul.project.Project;
import pl.krzysztofskul.project.ProjectService;
import pl.krzysztofskul.stakeholder.Stakeholder;

@Service
public class ImportProject {

	ImportData importData = ImportData.getImportDataSingleton().getImportDataSingleton();
	
	ProjectService projectService;
	HomePageService homePageService;
	PrototypeService prototypeService;
	AttachmentService attachmentsService;
	
	@Autowired
	private ImportProject(
			ProjectService projectService, 
			HomePageService homePageService,
			PrototypeService prototypeService,
			AttachmentService attachmentService
			) {
		super();
		this.projectService = projectService;
		this.homePageService = homePageService;
		this.prototypeService = prototypeService;
		this.attachmentsService = attachmentService;
	}



	/**
	 * Searches the directory for the project folder specified by the SLS project code;
	 * Converts data found to the Project class;
	 * 
	 * @param String slsCode - the code of the SLS project;
	 * @param String pathToprojectsDirectory - the path to the projects directory; if null default path from ImportData.class is used;
	 * @return Project with imported and converted data from SLS directory;
	 * @throws IOException 
	 */
	public Project importProjectBySlsCode (String slsCode, String pathToprojectsDirectory) throws IOException {
		Project project = null;
		
		if (null == slsCode) {
			return null;
		}
		
		// set the default path to projects directory if null
		if (null == pathToprojectsDirectory) {
			pathToprojectsDirectory = ImportData.getImportDataSingleton().getPathProjectsToImport();
		}
		
		// get list of all directory names
		List<String> slsProjectFolders = this.getAllFolderNames(pathToprojectsDirectory);
			
		// search sls code in project folder names
		for (String slsProjectFolderName : slsProjectFolders) {
			// if found slsCode directory create new Project
			if (slsProjectFolderName.equals(slsCode)) {
				
				//create new project
				project = new Project();
				
				// import and convert data from directory to the Project
				String calculationFilePath = this.getCalculationFilePath(slsCode, pathToprojectsDirectory);
				project.getDetailsSls().setPathToXls(calculationFilePath);
				project = this.importDataFromXlsCalc(project);
				//import attachments - offers
				project = importAttachments(project, calculationFilePath, "offers");

			
			} else if (!slsProjectFolderName.equals(slsCode) && slsProjectFolderName.contains(slsCode)) {
				System.out.println("App. WARNING! Found non-standard folder name for sls project code in selected projects path.");
				//TODO send information and ask user what to do
			} else {
				// else if not found slsCode directory					
			}
							
			}
		
		return project;
	}
	
	private Project importAttachments(Project project, String calculationFilePath, String attachemntsType) throws IOException {
		switch (attachemntsType) {
			case "offers": {
				/*
				 * import offers
				 */
//				int x = calculationFilePath.lastIndexOf("\\");
				String calculationFilePathParent = calculationFilePath.substring(0, calculationFilePath.lastIndexOf("\\"));
				List<String> folderNames = this.getAllFolderNames(calculationFilePathParent);
				for (String folderName : folderNames) {
					if (folderName.contains("Oferty")) {
						String attachemntsFolderPath = calculationFilePathParent+"\\"+folderName+"\\";
						File folder = new File(attachemntsFolderPath);
						File[] fileList = folder.listFiles(); //TODO 2023-02-26  the problem is null returned from listFiles()
						for (File file : fileList) {
							if (file.isFile()) {
								project = attachmentsService.setToProject(file, project, "offers");
							}
						}
					}
				}
				break;
			}
		}
		
		return project;
	}



	/**
	 * Gets all folder names from specified directory path
	 * @param String directoryPath
	 * @return List<String> folderNames
	 */
	private List<String> getAllFolderNames(String directoryPath) {
		List<String> folderNameList = new ArrayList<String>();
		
		File rootFolder = new File(directoryPath);
		
		File[] fileList = rootFolder.listFiles();
		
		for (File file : fileList) {
			folderNameList.add(file.getName());
		}
		
		return folderNameList;
	}
	
	/**
	 * Methods search and return the fulla path to the calculation xls file
	 * @param slsCode
	 * @param pathToprojectsDirectory
	 * @return String
	 */
	private String getCalculationFilePath(String slsCode, String pathToProjectsDirectory) {
		String calculationFilePath = new String();
		
		List<String> folderNames = this.getAllFolderNames(pathToProjectsDirectory+"//"+slsCode);
		
		String slsDocFolderName = new String();
		for (String folderName : folderNames) {
			if(folderName.contains("01.") || folderName.contains("SLS")) {
				slsDocFolderName = folderName.toString();
				break;
			}
		}
		
		File fileSlsDoc = new File(pathToProjectsDirectory+"//"+slsCode+"//"+slsDocFolderName);
		File[] files = fileSlsDoc.listFiles();
		
		for (File file : files) {
			if (file.getName().toLowerCase().contains("kalk") && file.getName().contains(".xls")) {
				calculationFilePath = file.getPath();
				break;
			}
			if (file.getName().toLowerCase().contains("calc") && file.getName().contains(".xls")) {
				calculationFilePath = file.getPath();
				break;
			}
		}
		
		return calculationFilePath;
	}
	
	private Project importDataFromXlsCalc(Project project) {
		Map<String, String> mapDataFromXls = importData.importProjectDataFromXls(project.getDetailsSls().getPathToXls());
		String calculationFilePath = project.getDetailsSls().getPathToXls();
		
		//set up fileInputStream and workbook
		try {
			ImportData.setFileInputStream(new FileInputStream(calculationFilePath));
			ImportData.setWorkbook(new XSSFWorkbook(ImportData.getFileInputStream()));
		
			// import and set stakeholder
			project.getDetailsSls().setSlsCodeShort(mapDataFromXls.get("slsCodeShort"));
			project.getProjectCharter().addStakeholder(
					new Stakeholder(
							importData.importSlsStakeholderContactPerson(project.getDetailsSls().getPathToXls()),
							null,null,null
					)
			);

			// import and set deadline
			String dateImported = importData.importSlsDeadline(calculationFilePath);
			
			try {
				project.setDeadline(
					LocalDateTime.of(
							LocalDate.parse(dateImported), 
							LocalTime.of(0, 0))
					);
			} catch (DateTimeParseException e) {
				System.err.println("Error while trying to convert date from xls file! "+calculationFilePath);
			}
				
			//import and set project manager
			String pmImported = importData.importSlsProjectManager(calculationFilePath);
			project.getDetailsSls().setImportedProjectManager(pmImported);

			
			//import and set device prototype name
			String device = importData.importSlsDevicePrototypeModelName(calculationFilePath);
			project.getDetailsSls().setImportedDeviceModelName(device);
			homePageService.savePrototypeToDbIfNotExist(device);
			project.addPrototype(prototypeService.loadByModelName(device));
			
			//import and set investor
			String slsInvestorSapNo = importData.importSlsInvestorSapNo(calculationFilePath);
			project.getDetailsSls().setImportedCustomer(slsInvestorSapNo);

			//import slsTrainingsOther
			String slsTrainingsOther = importData.importSlsData(calculationFilePath, "slsTrainingsOther");
			System.out.println("Zaimportowano szkolenia do ImportProject:" + slsTrainingsOther);
			//List<String> trainingList = new ArrayList<String>(Arrays.asList(slsTrainingsOther.split(";")));
			project.setTrainings(slsTrainingsOther);
			
			projectService.convertDataSlsToProject(project);
			
			//disable fileInputStream and workbook
			ImportData.setFileInputStream(null);
			ImportData.setWorkbook(null);
		
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println("App. ERROR!!! while trying to set up file input stream and workbook!");
		}

		
		return project;
	}
	
}
