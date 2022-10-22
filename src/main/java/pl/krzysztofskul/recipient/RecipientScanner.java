package pl.krzysztofskul.recipient;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RecipientScanner {

	public void readCSV() {
		
		Scanner scanner;
		try {
			//scanner and file configuration
			scanner = new Scanner(new File("D://SMNSH/karta_projektu/Klienci_master_data_.csv"));
			scanner.useDelimiter("\n");
			
			//test
			System.out.println("Start reading csv file...");
			
			//scanned row from a file declaration
			List<String> rows = new ArrayList<>();
			
			while (scanner.hasNext()) {
				
				//scannig cell to String
				/*scanner.useDelimiter(",");
				String cell = scanner.next();
				if (null == cell || cell.length()==0) {
					System.out.println("-");
				}
				else {
					System.out.println(cell);					
				}*/
				
				//scanning rows to List<String>
				String row = scanner.next();
				System.out.println(row);
				rows.add(row);

			}
			
			//test
			System.out.println("Finished reading csv file!");
			System.out.println("scanned rows: "+rows.size());
			
			//TODO 2022-10-22 : transfer scanned cells to customer class
			System.out.println("splitting rows...");
			for (String row : rows) {
				System.out.print(row.split(";")[0]);
				System.out.print(" | ");
				System.out.print(row.split(";")[1]);
				System.out.print(" | ");
				System.out.print(row.split(";")[2]);
				System.out.print(" | ");
				System.out.println(row.split(";")[3]);
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.print("Error while reading CSV file!");
		}
		
	}
	
}
