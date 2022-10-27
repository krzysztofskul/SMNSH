package pl.krzysztofskul.recipient;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import pl.krzysztofskul.SapCustomer.SapCustomer;

//Singleton
public class RecipientScanner implements Serializable{

	private static RecipientScanner recipientScanner;
		
	private RecipientScanner() {
		super();
		// TODO Auto-generated constructor stub
	}

	public static RecipientScanner getRecipientScanner() {
		if (null == recipientScanner) {
			recipientScanner = new RecipientScanner();
		}
		return recipientScanner;
	}


	public List<SapCustomer> readCSV() {
		
		List<SapCustomer> sapCustomers = new ArrayList<SapCustomer>();
		
		Scanner scanner;
		try {
			//scanner and file configuration
			String path = "D://SMNSH/karta_projektu/Klienci_master_data_.csv";
			File file = new File(path);
			scanner = new Scanner(file);
			scanner.useDelimiter("\n");
			
			
			//test Files
			/*
			 * Path pathFiles = Path.of(path); Files.newBufferedReader(pathFiles,
			 * StandardCharsets.US_ASCII);
			 */
			
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
			//test
			/*
			 * System.out.println("splitting rows..."); for (String row : rows) {
			 * System.out.print(row.split(";")[0]); System.out.print(" | ");
			 * System.out.print(row.split(";")[1]); System.out.print(" | ");
			 * System.out.print(row.split(";")[2]); System.out.print(" | ");
			 * System.out.println(row.split(";")[3]); }
			 */
			rows.remove(0);
			for (String row : rows) {
				SapCustomer sapCustomer = new SapCustomer(
						Long.parseLong(row.split(",")[0]),
						row.split(",")[1],
						row.split(",")[2],
						row.split(",")[3],
						row.split(",")[4],
						row.split(",")[5],
						row.split(",")[6],
						row.split(",")[7],
						row.split(",")[8],
						row.split(",")[9],
						row.split(",")[10],
						row.split(",")[11]
				);
				sapCustomers.add(sapCustomer);
			}
			
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.print("Error while reading CSV file!");
		}
		return sapCustomers;
	}
	
	
}
