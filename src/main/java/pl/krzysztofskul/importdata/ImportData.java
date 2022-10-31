package pl.krzysztofskul.importdata;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import pl.krzysztofskul.project.Project;

//Singleton
public class ImportData {
	
	/*
	 * PARAMS.
	 */
	
	private static ImportData importData;
	private String pathProjectsToImport = "D:\\SMNSH\\karta_projektu\\Projekty";
	private Map<LocalDateTime, String> logs = new HashMap<LocalDateTime, String>();
	
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
	
	/**
	 * 
	 * @param path: path to the folder with projects created by sales rep. (or copy of them)
	 * @return: list of all project codes using by sales rep.
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
	
	/**
	 * 
	 * @return list of all paths to calculation files from default location
	 */
	public List<String> getCalculationFilesFullPath() {
		
		List<String> pathsToCalculationFiles = new ArrayList<String>();
		
			for (String projectFolder : this.importProjectsFolderNames(ImportData.getImportDataSingleton().pathProjectsToImport)) {
				
				/*
				 * declaring folder with sls documentation
				 */
				String folder01name;
				try {
					File folder01 = new File(
							ImportData.getImportDataSingleton().pathProjectsToImport+"//"+projectFolder+"//01. Dokumenty_SLS KFP"
							); // project folder
					File[] files = folder01.listFiles();
					
					/*
					 * search and get calculation file for array files
					 */
					
					 for (int i = 0; i < files.length; i++) { 
						 if (files[i].getName().contains("Kalkulacja") && files[i].getName().contains(".xls")) {
							 pathsToCalculationFiles.add(files[i].getPath());
							 System.out.println("Imported "+projectFolder+" succesfully!");
							 logs.put(LocalDateTime.now(), "imported calculation file for:" + projectFolder);
							 break; 
						 }
						 if (i == files.length - 1) {
							 System.err.println("Not found calculation XLS file for: " + projectFolder);
							 logs.put(LocalDateTime.now(), "Not found calculation XLS file for:" + projectFolder);
						 }
					 }					 
					
				} catch (Exception e){
					System.err.println("Not found folder: 01. Dokumenty_SLS KFP for: " + projectFolder);
					logs.put(LocalDateTime.now(), "Not found folder: 01. Dokumenty_SLS KFP for: " + projectFolder);
				}

				
			}
		
		//System.out.println("************** LOGS FROM IMPORTS *********************");
		//System.out.println(logs);
		
		return pathsToCalculationFiles;

	}
	
	/**
	 * 
	 * @param projectSlsCode: specific project code / folder name created by sls 
	 * @return path to calculation xls file (first found)
	 */
	public String getCalculationFileFullPath(String projectSlsCode) {
		String calculationFileFullPath = null;
		File folderSlsDoc = new File(ImportData.getImportDataSingleton().getPathProjectsToImport()+"//"+projectSlsCode+"//01. Dokumenty_SLS KFP");
		
		File[] files = folderSlsDoc.listFiles();
		
		/*
		 * searching calculation file
		 */
		for (File file : files) {
			if (file.getName().contains("Kalkulacja") && file.getName().contains(".xls")) {
				calculationFileFullPath = file.getPath();
				break;
			}
		}
		
		return calculationFileFullPath;
	}
	/**
	 * 
	 * @return map of projects' codes (long and short) from default location for all of project folders
	 */
	public Map<String, String> getMapWithProjectsSlsCodes() {
		Map<String, String> projectsSlsCodes = new HashMap<String, String>();

		String slsCodeShort = null;
		String slsCodeFull = null;
		
		for (String calculationFilePath : this.getCalculationFilesFullPath()) {
			
			try {
				FileInputStream fis=new FileInputStream(calculationFilePath);  
				Workbook wb = new XSSFWorkbook(fis);
				Sheet sheet;  
				Row row;
				Cell cell;

//				sheet=wb.getSheetAt(1);   //getting the XSSFSheet object at given index  
				sheet=wb.getSheet("Kontrolka Umowy");   //getting the XSSFSheet object at given index  
				row=sheet.getRow(2); //returns the logical row  
				cell=row.getCell(2); //getting the cell representing the given column  
				slsCodeFull=cell.getStringCellValue();    //getting cell value  

				slsCodeShort=slsCodeFull.substring(0, 7);
				slsCodeShort=slsCodeFull.substring(0, slsCodeFull.indexOf("/"));
		
			} catch (Exception e) {
				//e.printStackTrace();
				System.out.println("Błąd odczytu danych z pliku: "+calculationFilePath);
			} finally {
				projectsSlsCodes.put(slsCodeShort, slsCodeFull);
				
				//TODO 2022-10-29
				//createAndSaveProjectsFromMappedSlsData(projectsSlsCodes);
			}
		}
		
		return projectsSlsCodes;
	}

	/**
	 * 
	 * @param calculationFilePath to specific xls file
	 * @return map of parameters imported from given path to xls file
	 */
	public Map<String, String> importProjectDataFromXls (String calculationFilePath) {
		Map<String, String> dataImported = new HashMap<String,String>();
		FileInputStream fis;
		try {
			fis = new FileInputStream(calculationFilePath);
			Workbook wb = new XSSFWorkbook(fis);
			
			dataImported.put("slsCodeShort", getSlsCodeShort(wb));
			
			dataImported.put("deviceCategory", getCellValue(wb, "SRF", 2, 6, calculationFilePath));
			
			dataImported.put("deviceModelName", getCellValue(wb, "SRF", 2, 7, calculationFilePath));
			
			dataImported.put("projectManager", getCellValue(wb, "SRF", 3, 11, calculationFilePath));
			
			dataImported.put("investorSapNo", getCellValue(wb, "HCALC-1", 4, 9, calculationFilePath));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		} catch (Exception e) {
			System.err.println("ERROR: "+calculationFilePath);
			dataImported = null;
		}
		return dataImported;
	}

	private String getCellValue(Workbook wb, String sheetName, int rowNo, int colNo, String calculationFilePath) {
		String cellValue = null;
		try {
			Sheet sheet=wb.getSheet(sheetName);   //getting the XSSFSheet object at given index  
			Row row=sheet.getRow(rowNo); //returns the logical row  
			Cell cell=row.getCell(colNo); //getting the cell representing the given column  
			cellValue=cell.getStringCellValue();    //getting cell value  
		} catch (NullPointerException e) {
			System.err.println("Not found sheet/row/col/cell for specified calculation xls file! "+ calculationFilePath);
			return null;
		}
		
		return cellValue;
	}

	private String getSlsCodeShort(Workbook wb) {
		Sheet sheet=wb.getSheet("Kontrolka Umowy");   //getting the XSSFSheet object at given index  
		Row row=sheet.getRow(2); //returns the logical row  
		Cell cell=row.getCell(2); //getting the cell representing the given column  
		
		String slsCodeFull=cell.getStringCellValue();    //getting cell value  

		//String slsCodeShort=slsCodeFull.substring(0, 7);
		String slsCodeShort=slsCodeFull.substring(0, slsCodeFull.indexOf("/"));
		return slsCodeShort;
	}

	/**
	 * list of projects imported from default location
	 */
	public List<Project> importSlsProjects() {
		List<Project> projectList = new ArrayList<Project>();
		
		/**
		 * get the default path to the folder with projects created by SLS
		 */
		String defaultPath = this.getPathProjectsToImport();
		
		/**
		 * get the list of calculation files for SLS projects
		 */
		List<String> calculationXlsFiles = this.getCalculationFilesFullPath();
		
		/**
		 * get the Map of projects' data imported from SLS
		 */
		List<Map<String, String>> dataImported = new ArrayList<Map<String,String>>();
		
		for (String caluclationFile : calculationXlsFiles) {
			if (null != importProjectDataFromXls(caluclationFile)) {
				dataImported.add(importProjectDataFromXls(caluclationFile));
			}
		}
		
		for (Map<String, String> di : dataImported) {
			/*projectList.add(new Project(
						di.get("slsCodeShort"),
						di.get("deviceCategory"),
						di.get("deviceModelName"),
						di.get("projectManager"),
						di.get("investorSapNo")
					));*/
			if (di != null) {
				Project project = new Project();
				project.getDetailsSls().setSlsCodeShort(di.get("slsCodeShort"));
				project.getDetailsSls().setImportedDeviceModality(di.get("deviceCategory"));
				project.getDetailsSls().setImportedDeviceModelName(di.get("deviceModelName"));
				project.getDetailsSls().setImportedProjectManager(di.get("projectManager"));
				project.getDetailsSls().setImportedCostumer(di.get("investorSapNo"));
				projectList.add(project);
			}
		}
		
		return projectList;
	}
	
}
