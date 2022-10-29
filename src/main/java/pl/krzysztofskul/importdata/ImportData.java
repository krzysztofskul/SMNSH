package pl.krzysztofskul.importdata;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

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
	
}
