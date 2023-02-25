/**
 * 
 */
package pl.krzysztofskul.subcontractor;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.transaction.Transactional;

import org.apache.poi.ss.formula.functions.T;
import org.springframework.stereotype.Service;

import com.thedeanda.lorem.LoremIpsum;

import pl.krzysztofskul.initDB.InitDataGenerator;

/**
 * @author krzysztofskul
 *
 */
@Service
public class SubcontractorDemoGenerator implements InitDataGenerator<Subcontractor>{

	public static List<Subcontractor> demoSubcontractors = new ArrayList<Subcontractor>();
	
	@Override
	public List<Subcontractor> initDataAndReturn() {
		
		LoremIpsum li = LoremIpsum.getInstance();
		for (int i = 0; i < new Random().nextInt(5)+5; i++) {
			
			demoSubcontractors.add(
						new Subcontractor(
								"Demo " + li.getTitle(1)+" sp. z o.o.", 
								li.getCountry(), 
								li.getCity(), 
								li.getZipCode(), 
								"ul."+li.getName(), 
								new Random().nextInt(200)+1, 
								li.getEmail(), 
								"www"+li.getWords(1)+"test.com", 
								li.getPhone()
								)
					);
		}
		
		return demoSubcontractors;
	}

}
