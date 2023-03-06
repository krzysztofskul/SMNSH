package pl.krzysztofskul.smnsh4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;
import org.springframework.stereotype.Service;

import com.thedeanda.lorem.LoremIpsum;

import pl.krzysztofskul.initDB.InitDataGenerator;

@Service
public class ContactDetailsDemoGenerator implements InitDataGenerator<ContactDetails> {

	private List<ContactDetails> demoContactDetailsList = new ArrayList<ContactDetails>();
	
	@Override
	public List<ContactDetails> initDataAndReturn() {
		
		demoContactDetailsList.add(
					
					new ContactDetails(
								Long.valueOf("0"),
								getDemoAddress(),
								getDemoPhoneNumbers(),
								getDemoEmailAdresses(),
								"www.goole.com"
							)
				
				);
		
		return demoContactDetailsList;
	}
	
	public ContactDetails getDemoContactDetails() {
		return demoContactDetailsList.get(0);
	}
	
	private Address getDemoAddress() {
		Address address = new Address();
		return address;
	}
	
	private Map<String, String> getDemoPhoneNumbers() {
		Map<String, String> phoneNumbers = new HashMap<String, String>();
		phoneNumbers.put("Nr tel. stacjonarny", "+48 22 989 99 88");
		phoneNumbers.put("Nr tel. komórkowy", "+48 999 888 999");
		return phoneNumbers;
	}
	
	private Map<String, String> getDemoEmailAdresses() {
		Map<String, String> emailAddresses = new HashMap<String, String>();
		emailAddresses.put("Email", "biuro@test.pl");
		return emailAddresses;
	}
	
}
