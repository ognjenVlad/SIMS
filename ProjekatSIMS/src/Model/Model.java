package Model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigDecimal;
import java.util.ArrayList;

public class Model {
	private BasketballModel basketModel;
	private ObjectOutputStream os;
	private ObjectInputStream is;

	public Model(){
		basketModel = new BasketballModel();
		readFile();
	}
	public void updateFile() {

		try {
			os = new ObjectOutputStream(new FileOutputStream("./resources/teams2.app"));
			os.writeObject(basketModel);
			os.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void readFile(){
		
		try {
			is = new ObjectInputStream(new FileInputStream("./resources/teams2.app"));
			basketModel =  (BasketballModel) is.readObject();
			is.close();
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

	public BasketballModel getBasketModel() {
		return basketModel;
	}

	public void setBasketModel(BasketballModel basket_model) {
		this.basketModel = basket_model;
	}
	
	public ArrayList<String> getPlayersSorter(String team){
		return basketModel.getPlayersSorter(team);
	}
	
	public void addPoints(String game_id ,String team_name,int jersey,int shot_for,int total 
			, int good , int pos , int quart){
		basketModel.addPoints(game_id, team_name, jersey, shot_for, total, good, pos, quart);;
	}
	
	public void addStat(String game_id ,String team_name,int jersey
			,String add_what,int amount,int quart){
		basketModel.addStat(game_id, team_name, jersey, add_what, amount, quart);
	}
	
	public void addTStat(String game_id,String team_name,String add_what,int amount,int quart) {
		basketModel.addTStat(game_id,team_name,add_what,amount,quart);
	}
	
	public double countAvgShots(String team,int jersey,int shot_for,boolean isGood,int pos,int quart) {
		Double num = basketModel.countAvgShots(team,jersey,shot_for, isGood, pos,quart);
		num = (double) Math.round(num*10d)/10d;
		return num.doubleValue();
	}
	
	public double countAvgStat(String team,int jersey,String count_what,int quart) {
		Double num =  basketModel.countAvgStat(team,jersey,count_what, quart);
		num = (double) Math.round(num*10d)/10d;
		BigDecimal bd = new BigDecimal(num.toString());
		bd = bd.setScale(2, BigDecimal.ROUND_HALF_UP);
		return bd.doubleValue();
	}

	public double countAvgTStat(String team,String count_what,int quart) {
		Double num = basketModel.countAvgTStat(team,count_what, quart);
		num =  (double) (Math.round(num*10d)/10d);
		BigDecimal bd = new BigDecimal(num.toString());
		bd = bd.setScale(2, BigDecimal.ROUND_HALF_UP);
		return bd.doubleValue();
	}

	public int countTStat(String game_id,String team,String count_what,int quart){
		return basketModel.countTStat(game_id,team,count_what,quart);
	}
	
	public int countShots(String game_id,String team,int jersey,int shot_for,boolean isGood,int pos,int quart){
		return basketModel.countShots(game_id, team, jersey, shot_for, isGood, pos, quart);
	}

	public int countStats(String game_id,String team,int jersey,String count_what,int quart){
		return basketModel.countStats(game_id, team, jersey, count_what, quart);
	}

	


}
