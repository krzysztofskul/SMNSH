package pl.krzysztofskul.importdata;

import static org.junit.Assert.*;

import org.junit.Test;

public class ImportDataTest {

	@Test
	public void test() {
		assertTrue(new ImportData().importFolderNames("D:\\SMNSH\\karta_projektu\\test").size() > 0);
		
		for (String name : new ImportData().importFolderNames("D:\\SMNSH\\karta_projektu\\test")) {
			System.out.println(name);
		}
		
	}

}
