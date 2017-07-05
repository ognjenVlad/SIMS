package Model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
			os = new ObjectOutputStream(new FileOutputStream("./resources/teams.app"));
			os.writeObject(basketModel);
			os.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void readFile(){
		
		try {
			is = new ObjectInputStream(new FileInputStream("./resources/teams.app"));
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
		return  basketModel.countAvgShots(team,jersey,shot_for, isGood, pos,quart);
	}
	
	public double countAvgStat(String team,int jersey,String count_what,int quart) {
		return basketModel.countAvgStat(team,jersey,count_what, quart);
	}

	public double countAvgTStat(String team,String count_what,int quart) {
		return basketModel.countAvgTStat(team,count_what, quart);
	}

	


}
