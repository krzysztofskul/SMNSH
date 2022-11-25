package pl.krzysztofskul.importdata;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import pl.krzysztofskul.project.Project;

@Service
public class ImportProject {

	ImportData importData = ImportData.getImportDataSingleton().getImportDataSingleton();
	
	/**
	 * Searches the directory for the project folder specified by the SLS project code;
	 * Converts data found to the Project class;
	 * 
	 * @param String slsCode - the code of the SLS project;
	 * @param String pathToprojectsDirectory - the path to the projects directory; if null default path from ImportData.class is used;
	 * @return Project with imported and converted data from SLS directory;
	 */
	public Project importProjectBySlsCode (String slsCode, String pathToprojectsDirectory) {
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
				// get calculation file
				
				//create new project
				project = new Project();
				
				// import and convert data from directory to the Project
				String calculationFilePath = this.getCalculationFilePath(slsCode, pathToprojectsDirectory);
				project.getDetailsSls().setPathToXls(calculationFilePath);
				//TODO 2022-11-25
			
			} else if (!slsProjectFolderName.equals(slsCode) && slsProjectFolderName.contains(slsCode)) {
				System.out.println("App. WARNING! Found non-standard folder name for sls project code in selected projects path.");
				//TODO send information and ask user what to do
			} else {
				// else if not found slsCode directory					
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
	
}
