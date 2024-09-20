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
		milestoneTemplates.add(new MilestoneTemplate (null, null, "checklista", "", null));
		milestoneTemplates.add(new MilestoneTemplate (null, null, "inwentaryzacja", "", null));
		milestoneTemplates.add(new MilestoneTemplate (null, null, "zamówienie projektu koncepcyjnego", "", null));
		milestoneTemplates.add(new MilestoneTemplate (null, null, "wykonanie projektu koncepcyjnego", "", null));
		milestoneTemplates.add(new MilestoneTemplate (null, null, "akceptacja projektu koncepcyjnego", "", null));
		milestoneTemplates.add(new MilestoneTemplate (null, null, "zamówienie projektu wytycznych instalacyjnych", "", null));
		milestoneTemplates.add(new MilestoneTemplate (null, null, "wykonanie projektu wytycznych instalacyjnych", "", null));
		milestoneTemplates.add(new MilestoneTemplate (null, null, "adaptacja pomieszczeń", "", null));
		milestoneTemplates.add(new MilestoneTemplate (null, null, "uruchomienie", "", null));
		milestoneTemplates.add(new MilestoneTemplate (null, null, "szkolenia", "", null));
		milestoneTemplates.add(new MilestoneTemplate (null, null, "odbiór", "", null));
	}
	
}
