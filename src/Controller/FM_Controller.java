package Controller;

import java.awt.event.MouseListener;

import Model.FM_Model;
import View.FM_View;

public class FM_Controller implements MouseListener{
	private FM_Model model;
	private FM_View view;
	
	public FM_Controller(FM_Model model, FM_View view) {
		this.model = model;
		this.view = view;
	}
}
