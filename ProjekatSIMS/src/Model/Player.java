package Model;

import java.io.Serializable;
import java.util.HashMap;

import Model.ShootingAttempt.FgTypeEnum;
import Model.ShootingAttempt.OutcomeEnum;
import Model.ShootingAttempt.PositionEnum;
import Model.Stat.TypeEnum;

public class Player implements Serializable {
	HashMap<String,PointsCounter> pCounter = new HashMap<String,PointsCounter>();
	HashMap<String,StatsCounter> sCounter = new HashMap<String,StatsCounter>();
	private int dress_num;
	private String name;
	private String surname;
	
	
	Player(){}


	public Player(int dress_num, String name, String surname) {
		this.dress_num = dress_num;
		this.name = name;
		this.surname = surname;
	}
	
	public void addGame(String game_id){
		pCounter.put(game_id, new PointsCounter());
		sCounter.put(game_id, new StatsCounter());
	}
	
	
	public void addShots(String game_id,int shot_for,int total 
			, int good , int pos , int quart){
		QuarterEnum quarter = getQuarterEnumVal(quart);
		PositionEnum position = getPositionEnumVal(pos);
		FgTypeEnum type = getFgTypeEnumVal(shot_for);
		OutcomeEnum outcome = OutcomeEnum.GOOD;
		
		
		for(int i = 0 ; i < total ; i ++){
			if(i >= good)
				outcome = outcome.MISS;
			pCounter.get(game_id).addShotAttempt(type, outcome, position,quarter );
		}
	}
	

	public int countShots(String game_id,int shot_for,boolean isGood 
			, int pos , int quart){
		if(quart == 0) {
			return this.countShots(game_id, shot_for, isGood, pos);
		}
		QuarterEnum quarter = getQuarterEnumVal(quart);
		PositionEnum position = getPositionEnumVal(pos);
		FgTypeEnum type = getFgTypeEnumVal(shot_for);
		OutcomeEnum outcome;
		
		if(isGood)
			outcome = OutcomeEnum.GOOD;
		else
			outcome = OutcomeEnum.MISS;
			
		int counter = pCounter.get(game_id).countShotsMade(type, position, outcome, quarter);
		return counter;
	}
	
	public int countShots(String game_id,int shot_for,boolean isGood 
			, int pos){

		PositionEnum position = getPositionEnumVal(pos);
		FgTypeEnum type = getFgTypeEnumVal(shot_for);
		OutcomeEnum outcome;
		
		if(isGood)
			outcome = OutcomeEnum.GOOD;
		else
			outcome = OutcomeEnum.MISS;
			
		int counter = pCounter.get(game_id).countShotsMade(type, position, outcome);
		return counter;
	}
	
	public double countAvgShots(int shot_for,boolean isGood,int pos,int quart) {
		if(quart == 0) {
			return this.countAvgShots(shot_for, isGood, pos);
		}
		double counter=0;		
		
		for (String game_id : pCounter.keySet()) {
			counter += this.countShots(game_id, shot_for, isGood, pos,quart);
		}
		
		counter /= pCounter.size();
		
		return counter;
	}
	
	public double countAvgShots(int shot_for,boolean isGood,int pos) {
		double counter=0;
		
		for (String game_id : pCounter.keySet()) {
			counter += this.countShots(game_id, shot_for, isGood, pos);
		}
		
		counter /= pCounter.size();
		
		return counter;
	}
	
	public void addStats(String game_id,String add_what,int amount,int quart){
		
		QuarterEnum quarter = getQuarterEnumVal(quart);
		TypeEnum type = getTypeEnumVal(add_what);
		
		for(int i = 0 ; i < amount ; i++){
			sCounter.get(game_id).addStat(type, quarter);
		}
		
		return;
	}
	
	public int countStat(String game_id,String count_what,int quart){
		if(quart == 0) {
			return this.countStat(game_id, count_what);
		}
		QuarterEnum quarter = getQuarterEnumVal(quart);
		TypeEnum type = getTypeEnumVal(count_what);
		int count = sCounter.get(game_id).countStats(type,quarter);
		return count;
	}
	
	public int countStat(String game_id,String count_what){
		TypeEnum type = getTypeEnumVal(count_what);
		int count = sCounter.get(game_id).countStats(type);
		return count;
	}
	
	public double countAvgStat(String count_what,int quart){
		double counter=0;
		for (String game_id : pCounter.keySet()) {
			counter += this.countStat(game_id, count_what, quart);
		}
		
		counter /= pCounter.size();
		return counter;
	}
	
	public double countAvgStat(String count_what){
		double counter=0;
		TypeEnum type = getTypeEnumVal(count_what);
		for (String game_id : pCounter.keySet()) {
			counter += sCounter.get(game_id).countStats(type);
		}
		
		counter /= pCounter.size();
		return counter;
	}
	
	private QuarterEnum getQuarterEnumVal(int i){
		switch(i){
		case 1: return QuarterEnum.FIRST;
		case 2: return QuarterEnum.SECOND;
		case 3: return QuarterEnum.THIRD;
		case 4: return QuarterEnum.FOURTH;
		}
		return QuarterEnum.NONE;
	}


	private FgTypeEnum getFgTypeEnumVal(int i){
		switch(i){
		case 1: return FgTypeEnum.ONE_POINT;
		case 2: return FgTypeEnum.TWO_POINTS;
		case 3: return FgTypeEnum.TREE_POINTS;
		}
	return FgTypeEnum.NONE;
	}
	
	
	private PositionEnum getPositionEnumVal(int i){
		switch(i){
		case 1: return PositionEnum.SIX;
		case 2: return PositionEnum.TWO;
		case 3: return PositionEnum.TREE;
		case 4: return PositionEnum.FOUR;
		case 5: return PositionEnum.FIVE;
		case 6: return PositionEnum.SIX;
		}
		return PositionEnum.NONE;
	}

	
	private TypeEnum getTypeEnumVal(String str){
		// Possible enum values for strings
		if(str.equals("assist"))
			return TypeEnum.ASSIST;
		else if(str.equals("off_rebound"))
			return TypeEnum.OFF_REBOUND;
		else if(str.equals("def_rebound"))
			return TypeEnum.DEF_REBOUND;
		else if(str.equals("back_court"))
			return TypeEnum.BACK_COURT;
		else if(str.equals("foul"))
			return TypeEnum.FOUL;
		else if(str.equals("technical_foul"))
			return TypeEnum.TECHNICAL_FOUL;
		else if(str.equals("tree_sec"))
			return TypeEnum.TREE_SEC;
		else if(str.equals("travel"))
			return TypeEnum.TRAVEL;
		else if(str.equals("bad_pass"))
			return TypeEnum.BAD_PASS;
		return TypeEnum.NONE;
	}


	public int getDress_num() {
		return dress_num;
	}


	public void setDress_num(int dress_num) {
		this.dress_num = dress_num;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getSurname() {
		return surname;
	}


	public void setSurname(String surname) {
		this.surname = surname;
	}
	
}
