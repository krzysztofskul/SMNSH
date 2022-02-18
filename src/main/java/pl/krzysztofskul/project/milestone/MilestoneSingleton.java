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
		milestoneTemplates.add(new MilestoneTemplate (null, null, null, "conceptual design order", null));
		milestoneTemplates.add(new MilestoneTemplate (null, null, null, "conceptual design receive", null));
		milestoneTemplates.add(new MilestoneTemplate (null, null, null, "conceptual design approve", null));
		milestoneTemplates.add(new MilestoneTemplate (null, null, null, "installation guidelines design order", null));
		milestoneTemplates.add(new MilestoneTemplate (null, null, null, "installation guidelines design receive", null));
		milestoneTemplates.add(new MilestoneTemplate (null, null, null, "installation guidelines design approve", null));
		milestoneTemplates.add(new MilestoneTemplate (null, null, null, "construction design order", null));
		milestoneTemplates.add(new MilestoneTemplate (null, null, null, "construction design receive", null));
		milestoneTemplates.add(new MilestoneTemplate (null, null, null, "construction design approve", null));
	}
	
}
