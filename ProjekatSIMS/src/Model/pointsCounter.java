package Model;

import java.util.ArrayList;

import Model.fieldGoalAttempt.FgTypeEnum;
import Model.fieldGoalAttempt.OutcomeEnum;
import Model.fieldGoalAttempt.PositionEnum;

public class pointsCounter {
	private ArrayList<fieldGoalAttempt> attempts;
	private int ftGood = 0 , ftMiss = 0; 
	
	pointsCounter(){
		attempts = new ArrayList<fieldGoalAttempt>();
	}
	
	void addFgAttempt(FgTypeEnum type,OutcomeEnum outcome, PositionEnum position){
		attempts.add(new fieldGoalAttempt(type,outcome,position));
	}
	
	void addFreeThrow(boolean isGood){
		if(isGood)
			ftGood++;
		else
			ftMiss++;
	}
	
	public int countFreeThrows(boolean countGood){
		if(countGood)
			return ftGood;
		else
			return ftMiss;
	}
	
	public int countFieldGoalsMade(FgTypeEnum type,PositionEnum position,OutcomeEnum outcome){
		int counter = 0;
		for (fieldGoalAttempt fga : attempts) {
			if(fga.isTwoPoint() && type == type.TREE_POINTS)
				continue;
			if(fga.isMiss() && outcome == outcome.GOOD)
				continue;
			switch(position){
            case ONE : counter++ ;
                     break;
            case TWO : counter++;
            		break;
            case TREE : counter++;
            		break;
            case FOUR : counter++;
            		break;
            case FIVE : counter++;
            		break;
            case SIX :	counter++;
            		break;
			}
		}
		return counter;
	}
	
	
}
