package Model;

import java.io.Serializable;
import java.util.ArrayList;

import Model.TeamStat.TeamTypeEnum;

public class TeamStatCounter implements Serializable {

	private static final long serialVersionUID = 1L;
	ArrayList<TeamStat> stats;

	TeamStatCounter() {
		stats = new ArrayList<TeamStat>();
	}

	public void addStat(TeamTypeEnum type , QuarterEnum quarter)
	{
		stats.add(new TeamStat(type,quarter));
	}


	public int countStats(TeamTypeEnum type,QuarterEnum quarter) {

		int counter = 0;
		for (TeamStat ts : stats) {
			if (type != ts.getType())
				continue;
			if (quarter != ts.getQuarter())
				continue;
			counter++;
		}
		return counter;
	}

	public int countStats(TeamTypeEnum type) {

		int counter = 0;
		for (TeamStat ts : stats) {
			if (type != ts.getType())
				continue;
			counter++;
		}
		return counter;
	}
}
