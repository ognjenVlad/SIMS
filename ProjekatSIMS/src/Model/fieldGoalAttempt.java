package Model;

public class fieldGoalAttempt {
	static public enum PositionEnum { ONE , TWO , TREE , FOUR , FIVE , SIX };
	static public enum OutcomeEnum { GOOD , MISS };
	static public enum FgTypeEnum { TWO_POINTS , TREE_POINTS };
	
	PositionEnum position;
	OutcomeEnum outcome;
	FgTypeEnum type;
	
	
	fieldGoalAttempt() {};
	
	fieldGoalAttempt(FgTypeEnum type, OutcomeEnum outcome , PositionEnum position){
		this.position = position;
		this.outcome = outcome;
		this.type = type;
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
	
	public boolean isMiss(){
		if(outcome == OutcomeEnum.MISS){
			return true;
		}
		return false;
	}
	
	public boolean isTwoPoint(){
		if(type == FgTypeEnum.TWO_POINTS){
			return true;
		}
		return false;
	}	
	
	
}
