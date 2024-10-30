package pl.krzysztofskul.project.milestone;

import java.time.ZoneOffset;
import java.util.Comparator;

public class MilestoneInstanceSortByDateFinishPlanned implements Comparator<MilestoneInstance> {
	
	@Override
	public int compare(MilestoneInstance a, MilestoneInstance b) {
		return (int) a.getMilestoneTimeline().getDateFinishPlanned().toEpochSecond(ZoneOffset.ofHours(0)) - (int) b.getMilestoneTimeline().getDateFinishPlanned().toEpochSecond(ZoneOffset.ofHours(0));
	}
	
}
