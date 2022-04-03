package pl.krzysztofskul.stakeholder;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StakeholderRepo extends JpaRepository<Stakeholder, Long> {

	Stakeholder findStakeholderByUserId(Long userId);
	
	List<Stakeholder> findAllStakeholdersByUserId(Long userId);
	
}
