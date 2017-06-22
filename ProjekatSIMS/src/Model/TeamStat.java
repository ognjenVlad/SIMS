package Model;

public class TeamStat {
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
