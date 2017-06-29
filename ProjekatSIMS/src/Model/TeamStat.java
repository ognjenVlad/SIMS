package Model;

import java.io.Serializable;

public class TeamStat implements Serializable{
	enum TeamTypeEnum {TIMEOUT , TWOTREE_SECONDS , EIGHT_SECONDS 
		, FIVE_SECONDS ,  TRAINER_TECHICAL};
	
	TeamTypeEnum type;
	QuarterEnum quarter;
	
	
	
	public TeamStat(TeamTypeEnum type, QuarterEnum quarter) {
		super();
		this.type = type;
		this.quarter = quarter;
	}
	
}