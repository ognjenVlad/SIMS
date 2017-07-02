package Model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Model {
	private BasketballModel basket_model;
	private ObjectOutputStream os;
	private ObjectInputStream is;

	public Model(){
		basket_model = new BasketballModel();
		readFile();
	}
	public void updateFile() {

		try {
			os = new ObjectOutputStream(new FileOutputStream("./resources/teams.app"));
			os.writeObject(basket_model);
			os.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void readFile(){
		
		try {
			is = new ObjectInputStream(new FileInputStream("./resources/teams.app"));
			basket_model =  (BasketballModel) is.readObject();
			is.close();
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

	public BasketballModel getBasket_model() {
		return basket_model;
	}

	public void setBasket_model(BasketballModel basket_model) {
		this.basket_model = basket_model;
	}
	
}
