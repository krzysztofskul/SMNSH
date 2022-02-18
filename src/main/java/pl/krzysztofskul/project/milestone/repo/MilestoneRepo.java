package pl.krzysztofskul.project.milestone.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.krzysztofskul.project.milestone.Milestone;

@Repository
public interface MilestoneRepo extends JpaRepository<Milestone, Long>{

}
