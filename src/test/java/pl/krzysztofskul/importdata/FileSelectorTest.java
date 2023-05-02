package pl.krzysztofskul.importdata;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class FileSelectorTest {

	@Autowired
	FileSelector fileSelector;
	
	@Test
	public void test() {
		fileSelector.select("file");
		fileSelector.select("folder");
	}

}
