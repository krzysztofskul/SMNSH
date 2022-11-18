package pl.krzysztofskul.investor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SapInfoRepo extends JpaRepository<SapInfo, Long>{
	
	public SapInfo findBySapNo(String sapNo);

}
