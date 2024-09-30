package pl.krzysztofskul.smnsh4.Company.qualityrate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QualityrateRepo extends JpaRepository<Qualityrate, Long>{

	Qualityrate findByQualityrateEnum(QualityrateEnum qualityrateEnum);

}
