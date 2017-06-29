import Controler.Controler;
import View.View;

public class test {

	public static void main(String[] args) {
		View v = new View();
		Controler c = new Controler(v);
		v.setControler(c);
		v.setVisible(true);

	}

}
