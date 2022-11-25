package pl.krzysztofskul.importdata;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ImportProjectTest {

	ImportProject importProject = new ImportProject();
	
	@Test
	public void testImportProjectBySlsCode() {
		//importProject.importProjectBySlsCode("TEST", null);
		
		assertTrue(
				
				importProject.importProjectBySlsCode("KAT1215", null).getDetailsSls().getPathToXls() != null
				&&
				importProject.importProjectBySlsCode("KAT1215", null).getDetailsSls().getPathToXls().length() > 0
		);
		
		assertTrue(
				importProject.importProjectBySlsCode("KAT1215", null).getDetailsSls().getSlsCodeShort().toLowerCase().contains("kat1215")
				
		);
		
	
	}

	
	
}
