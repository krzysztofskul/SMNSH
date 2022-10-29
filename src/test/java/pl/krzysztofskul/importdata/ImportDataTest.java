package pl.krzysztofskul.importdata;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class ImportDataTest {

	@Test
	public void test01() {
		assertTrue(ImportData.getImportDataSingleton().importProjectsFolderNames("D:\\SMNSH\\karta_projektu\\test").size() > 0);
		
		for (String name : ImportData.getImportDataSingleton().importProjectsFolderNames("D:\\SMNSH\\karta_projektu\\test")) {
			System.out.println(name);
		}
		
	}
	
	@Test
	public void test02() {
		assertTrue(ImportData.getImportDataSingleton().importProjectsFolderNames(ImportData.getImportDataSingleton().getPathProjectsToImport()).size() > 0);
		
		for (String name : ImportData.getImportDataSingleton().importProjectsFolderNames(ImportData.getImportDataSingleton().getPathProjectsToImport())) {
			System.out.println(name);
		}
		
	}
	
	@Test
	public void test03() {
		assertTrue(ImportData.getImportDataSingleton().getCalculationFilesFullPath().size() > 0);
		System.out.println(ImportData.getImportDataSingleton().getCalculationFilesFullPath().toString());
	}

	@Test
	public void test04() throws IOException {
		System.out.println(ImportData.getImportDataSingleton().getMapWithProjectsSlsCodes().toString());
	}

	@Test
	public void test05() {
		List<String> calculationFiles = ImportData.getImportDataSingleton().getCalculationFilesFullPath();
		Map<String, String> dataImportedFromXls = ImportData.getImportDataSingleton().importProjectDataFromXls(calculationFiles.get(0));
		System.out.println(dataImportedFromXls);
	}
	
}
