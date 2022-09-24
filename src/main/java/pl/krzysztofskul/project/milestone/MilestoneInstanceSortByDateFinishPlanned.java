package pl.krzysztofskul.project.milestone;

import java.util.Comparator;

public class MilestoneInstanceSortByDateFinishPlanned implements Comparator<MilestoneInstance> {
	
	@Override
	public int compare(MilestoneInstance a, MilestoneInstance b) {
		return (int) a.getMilestoneTimeline().getDateFinishPlanned().toEpochDay() - (int) b.getMilestoneTimeline().getDateFinishPlanned().toEpochDay();
	}
	
}
