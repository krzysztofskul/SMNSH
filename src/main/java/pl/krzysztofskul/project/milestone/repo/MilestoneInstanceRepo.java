package pl.krzysztofskul.project.milestone.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.krzysztofskul.project.milestone.MilestoneInstance;

public interface MilestoneInstanceRepo extends JpaRepository<MilestoneInstance, Long>{

}
