package Model;

import java.io.Serializable;

public class TeamStat implements Serializable{
	private static final long serialVersionUID = 1L;



	enum TeamTypeEnum {TIMEOUT , TWOFOUR_SECONDS , EIGHT_SECONDS 
		, FIVE_SECONDS ,  TRAINER_TECHICAL , NONE};
	
	TeamTypeEnum type;
	QuarterEnum quarter;
	
	
	
	public TeamStat(TeamTypeEnum type, QuarterEnum quarter) {
		super();
		this.type = type;
		this.quarter = quarter;
	}



	public TeamTypeEnum getType() {
		return type;
	}



	public void setType(TeamTypeEnum type) {
		this.type = type;
	}



	public QuarterEnum getQuarter() {
		return quarter;
	}



	public void setQuarter(QuarterEnum quarter) {
		this.quarter = quarter;
	}
	
	
	
}
