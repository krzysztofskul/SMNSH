package pl.krzysztofskul.subcontractor;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import pl.krzysztofskul.initDB.InitDataGenerator;

@Service
public class SubcontractorUndefinedGenerator implements InitDataGenerator<Subcontractor>{

	@Override
	public List<Subcontractor> initDataAndReturn() {
		
		List<Subcontractor> undefsub = new ArrayList<Subcontractor>();
		undefsub.add(new Subcontractor(
					"NIEOKREŚLONY",
					"nie dotyczy",
					"nie dotyczy",
					"nie dotyczy",
					"nie dotyczy",
					0,
					"nie dotyczy",
					"nie dotyczy",
					"nie dotyczy"				
				));
		return undefsub;
	}
	
	

}
