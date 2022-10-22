package pl.krzysztofskul.recipient;

import static org.junit.Assert.*;

import org.junit.Test;

public class RecipientScannerTest {

	@Test
	public void testReadCSV() {
		RecipientScanner recipientScanner = new RecipientScanner();
		
		
		recipientScanner.readCSV();
	}

}
