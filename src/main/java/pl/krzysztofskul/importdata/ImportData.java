package pl.krzysztofskul.importdata;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

//Singleton
public class ImportData {
	
	/*
	 * PARAMS.
	 */
	
	private static ImportData importData;
	private String pathProjectsToImport = "D:\\SMNSH\\karta_projektu\\Projekty";
	
	/*
	 * CONSTR.
	 */
	
	private ImportData() {
		super();
		// TODO Auto-generated constructor stub
	}

	public static ImportData getImportDataSingleton() {
		if (importData == null) {
			importData = new ImportData();
		}
		
		return importData;
	}

	/*
	 * GETTERS AND SETTERS
	 */
	
	public String getPathProjectsToImport() {
		return pathProjectsToImport;
	}

	public void setPathProjectsToImport(String pathProjectsToImport) {
		this.pathProjectsToImport = pathProjectsToImport;
	}

	/*
	 * METHODS
	 */
	
	public List<String> importProjectsFolderNames(String path) {
		List<String> folderNameList = new ArrayList<String>();
		
		File rootFolder = new File(path);
		
		File[] fileList = rootFolder.listFiles();
		
		for (File file : fileList) {
			folderNameList.add(file.getName());
		}
		
		return folderNameList;
	}
	
	public List<String> getCalculationFilesFullPath() /* throws FileNotFoundException */ {
		
		List<String> pathsToCalculationFiles = new ArrayList<String>();
		
			for (String pathToProjectFolder : this.importProjectsFolderNames(ImportData.getImportDataSingleton().pathProjectsToImport)) {
				
				/*
				 * declaring folder with sls documentation
				 */
				File folderSlsDoc = new File(ImportData.getImportDataSingleton().pathProjectsToImport+"//"+pathToProjectFolder+"//01. Dokumenty_SLS KFP"); // project folder
				File[] files = folderSlsDoc.listFiles();
				
				/*
				 * searching calculation file
				 */
				for (File file : files) {
					if (file.getName().contains("Kalkulacja") && file.getName().contains(".xls")) {
						pathsToCalculationFiles.add(file.getPath());
						break;
					}
				}
				
			}
		return pathsToCalculationFiles;
		

	}
}
