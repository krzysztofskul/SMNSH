package pl.krzysztofskul.smnsh4.Company.qualityrate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QualityrateService {

	private QualityrateRepo qualityrateRepo;
	private QualityrateInitDataGenerator qualityrateInitDataGenerator;
	
	@Autowired
	public QualityrateService(QualityrateRepo qualityrateRepo,
				QualityrateInitDataGenerator qualityrateInitDataGenerator
			) {
		super();
		this.qualityrateRepo = qualityrateRepo;
		this.qualityrateInitDataGenerator = qualityrateInitDataGenerator;
	}
	
	public void save(Qualityrate qualityrate) {
		qualityrateRepo.save(qualityrate);
	}
	
	public List<Qualityrate> loadAll() {
		return qualityrateRepo.findAll();
	}
	
	public Qualityrate loadByQualityrateEnum(QualityrateEnum qualityrateEnum) {
		return qualityrateRepo.findByQualityrateEnum(qualityrateEnum);
	}

	/**
	 * Method gets initial quality rating list for companies and save to database.
	 */
	public void createAndSaveQualityrates() {
		List<Qualityrate> qualityrateList = qualityrateInitDataGenerator.initDataAndReturn();	
		qualityrateRepo.saveAll(qualityrateList);
	}
	
}
