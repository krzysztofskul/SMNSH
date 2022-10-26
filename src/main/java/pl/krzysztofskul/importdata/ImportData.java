package pl.krzysztofskul.importdata;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ImportData {

	public List<String> importFolderNames(String path) {
		List<String> folderNameList = new ArrayList<String>();
		
		File rootFolder = new File(path);
		
		File[] fileList = rootFolder.listFiles();
		
		for (File file : fileList) {
			folderNameList.add(file.getName());
		}
		
		return folderNameList;
	}
	
}
