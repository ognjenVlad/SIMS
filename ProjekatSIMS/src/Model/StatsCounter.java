package Model;

import java.io.Serializable;
import java.util.ArrayList;

import Model.Stat.TypeEnum;

public class StatsCounter implements Serializable{
	ArrayList<Stat> stats = new ArrayList<Stat>();
	
	
	StatsCounter(){}
	
	public void addStat(TypeEnum type,QuarterEnum quarter){
		stats.add(new Stat(type,quarter));
	}
	public int countStats(TypeEnum type){
		int count=0;
		
		for (Stat stat : stats) {
			if(type != stat.getType())
				continue;
		}
		
		return count;
	}
	
	public int countStats(TypeEnum type,QuarterEnum quarter){
		int counter = 0;
		for (Stat stat : stats) {
			if(type != stat.getType())
				continue;
			if(quarter != stat.getQuarter())
				continue;
			counter++;
		}
		
		return counter;
	}
}
