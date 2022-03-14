package pl.krzysztofskul.project.milestone;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MilestoneSingleton {

	/**
	 * params.
	 */
	
	private static MilestoneSingleton MILESTONE_SINGLETON;
	
	private List<MilestoneTemplate> milestoneTemplates = new ArrayList<>();
	
	/**
	 * constr.
	 */
	
	private MilestoneSingleton() {
		createMapWithMilestoneTemplates();
	}
	
	/**
	 * getters and setters
	 */
	
	public List<MilestoneTemplate> getMilestoneTemplates() {
		return milestoneTemplates;
	}

	private void setMilestoneTemplates(List<MilestoneTemplate> milestoneTemplates) {
		this.milestoneTemplates = milestoneTemplates;
	}

	/**
	 * methods
	 */
	
	public static MilestoneSingleton getMilestoneSingleton() {
		if (MilestoneSingleton.MILESTONE_SINGLETON == null) {
			return new MilestoneSingleton();
		} else {
			return MILESTONE_SINGLETON;
		}
	}
	
	private void createMapWithMilestoneTemplates() {
		milestoneTemplates.add(new MilestoneTemplate (null, null, "zamówienie projektu koncepcyjnego", "conceptual design ordered", null));
		milestoneTemplates.add(new MilestoneTemplate (null, null, "wykonanie projektu koncepcyjnego", "conceptual design received", null));
		milestoneTemplates.add(new MilestoneTemplate (null, null, "akceptacja projektu koncepcyjnego", "conceptual design approved", null));
		milestoneTemplates.add(new MilestoneTemplate (null, null, "zamówienie projektu wytycznych instalacyjnych", "installation guidelines design ordered", null));
		milestoneTemplates.add(new MilestoneTemplate (null, null, "wykonanie projektu wytycznych instalacyjnych", "installation guidelines design received", null));
		milestoneTemplates.add(new MilestoneTemplate (null, null, "akceptacja projektu wytycznych instalacyjnych", "installation guidelines design approved", null));
		milestoneTemplates.add(new MilestoneTemplate (null, null, "zamówienie projektu konstrukcyjnego", "construction design ordered", null));
		milestoneTemplates.add(new MilestoneTemplate (null, null, "wykonanie projektu konstrukcyjnego", "construction design received", null));
		milestoneTemplates.add(new MilestoneTemplate (null, null, "akceptacja projektu konstrukcyjnego", "construction design approved", null));
	}
	
}
