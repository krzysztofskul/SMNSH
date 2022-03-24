package pl.krzysztofskul.stakeholder;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StakeholderInPtojectDetailsRepo extends JpaRepository<StakeholderInProjectDetails, Long>{

}
