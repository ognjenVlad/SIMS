package Model;

public class ShootingAttempt {
	static public enum PositionEnum { ONE , TWO , TREE , FOUR , FIVE , SIX , NONE };
	static public enum OutcomeEnum { GOOD , MISS , NONE};
	static public enum FgTypeEnum { ONE_POINT , TWO_POINTS , TREE_POINTS ,NONE};
	
	PositionEnum position;
	OutcomeEnum outcome;
	FgTypeEnum type;
	QuarterEnum quarter;
	
	
	ShootingAttempt() {};
	
	ShootingAttempt(FgTypeEnum type, OutcomeEnum outcome
			,PositionEnum position,QuarterEnum quarter){
		this.position = position;
		this.outcome = outcome;
		this.type = type;
		this.quarter = quarter;
	}

	public PositionEnum getPosition() {
		return position;
	}

	public void setPosition(PositionEnum position) {
		this.position = position;
	}

	public OutcomeEnum getOutcome() {
		return outcome;
	}

	public void setOutcome(OutcomeEnum outcome) {
		this.outcome = outcome;
	}

	public FgTypeEnum getType() {
		return type;
	}

	public void setType(FgTypeEnum type) {
		this.type = type;
	}
	
	public QuarterEnum getQuarter() {
		return quarter;
	}

	public void setQuarter(QuarterEnum quarter) {
		this.quarter = quarter;
	}

	public boolean isMiss(){
		if(outcome == OutcomeEnum.MISS){
			return true;
		}
		return false;
	}
		
	
}
