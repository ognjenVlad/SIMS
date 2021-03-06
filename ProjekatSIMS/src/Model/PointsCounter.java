package Model;

import java.io.Serializable;
import java.util.ArrayList;

import Model.ShootingAttempt.FgTypeEnum;
import Model.ShootingAttempt.OutcomeEnum;
import Model.ShootingAttempt.PositionEnum;

public class PointsCounter implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private ArrayList<ShootingAttempt> attempts;
	
	PointsCounter(){
		attempts = new ArrayList<ShootingAttempt>();
	}
	
	void addShotAttempt(FgTypeEnum type,OutcomeEnum outcome
			, PositionEnum position,QuarterEnum quarter){
		attempts.add(new ShootingAttempt(type,outcome,position,quarter));
	}
	
	
	public int countShotsMade(FgTypeEnum type,PositionEnum position
			,OutcomeEnum outcome,QuarterEnum quarter){

		int counter = 0;
		for (ShootingAttempt fga : attempts) {
			if(type != fga.getType())
				continue;
			if(outcome != fga.getOutcome())
				continue;
			if(quarter != fga.getQuarter())
				continue;
			
			// Sigurno dobra cetvrtina i outcome , nije bitna pozicija!
			if(type == type.ONE_POINT){
				counter++;
				continue;
			}
			
			if(position != fga.getPosition()){
				continue;
			}
			
			counter++;
		}
		return counter;
	}

	public int countShotsMade(FgTypeEnum type,PositionEnum position
			,OutcomeEnum outcome){

		int counter = 0;
		for (ShootingAttempt fga : attempts) {
			if(type != fga.getType())
				continue;
			if(outcome != fga.getOutcome())
				continue;
			
			// Sigurno dobra cetvrtina i outcome , nije bitna pozicija!
			if(type == type.ONE_POINT){
				counter++;
				continue;
			}
			
			if(position != fga.getPosition()){
				continue;
			}
			
			counter++;
		}
		return counter;
	}

	
	
}
