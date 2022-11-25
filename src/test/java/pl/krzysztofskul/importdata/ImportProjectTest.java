package pl.krzysztofskul.importdata;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ImportProjectTest {

	ImportProject importProject = new ImportProject();
	
	@Test
	public void testImportProjectBySlsCode() {
		importProject.importProjectBySlsCode("TEST", null);
		
		assertTrue(
				
				importProject.importProjectBySlsCode("BIE1524", null).getDetailsSls().getPathToXls() != null
				&&
				importProject.importProjectBySlsCode("BIE1524", null).getDetailsSls().getPathToXls().length() > 0
				);
		
	
	
	}

	
	
}
