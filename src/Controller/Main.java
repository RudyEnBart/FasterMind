package Controller;

import Model.FM_Model;
import View.FM_View;

public class Main {
	public static void main(String[] args) {
		FM_Model model = new FM_Model();
		FM_View view = new FM_View(model);
		FM_Controller controller = new FM_Controller(model, view);
	}
}
