package pl.krzysztofskul.importdata;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ImportProjectTest {

	@Autowired
	ImportProject importProject;
	
	@Test
	public void testImportProjectBySlsCode() throws IOException {
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
