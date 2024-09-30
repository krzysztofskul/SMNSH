package pl.krzysztofskul.smnsh4.Company.qualityrate;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import pl.krzysztofskul.initDB.InitDataGenerator;

@Service
public class QualityrateInitDataGenerator implements InitDataGenerator<Qualityrate> {

	@Override
	public List<Qualityrate> initDataAndReturn() {
		
		List<Qualityrate> qualitrateList = new ArrayList<Qualityrate>();
		qualitrateList.add(new Qualityrate(QualityrateEnum.WHITE));
		qualitrateList.add(new Qualityrate(QualityrateEnum.GREEN));
		qualitrateList.add(new Qualityrate(QualityrateEnum.YELLOW));
		qualitrateList.add(new Qualityrate(QualityrateEnum.RED));
		qualitrateList.add(new Qualityrate(QualityrateEnum.BLACK));
		return qualitrateList;
	}
	
}
