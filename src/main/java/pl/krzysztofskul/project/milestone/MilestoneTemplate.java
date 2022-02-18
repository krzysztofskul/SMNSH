package pl.krzysztofskul.project.milestone;

import javax.persistence.Entity;

@Entity
public class MilestoneTemplate extends Milestone {

	

	public MilestoneTemplate() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MilestoneTemplate(Long id, String codeName, String namePL, String nameEN, String description) {
		super(id, codeName, namePL, nameEN, description);
		// TODO Auto-generated constructor stub
	}

	

}
