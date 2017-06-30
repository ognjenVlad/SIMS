package Model;

import java.util.ArrayList;

import Model.ShootingAttempt.FgTypeEnum;
import Model.ShootingAttempt.OutcomeEnum;
import Model.ShootingAttempt.PositionEnum;
import Model.TeamStat.TeamTypeEnum;

public class TeamStatCounter {
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
