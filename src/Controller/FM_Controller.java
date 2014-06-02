package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import Model.FM_Model;
import Model.Square;
import View.FM_View;

public class FM_Controller implements MouseListener, ActionListener{
	private FM_Model model;
	private FM_View view;
	
	public FM_Controller(FM_Model model, FM_View view) {
		this.model = model;
		this.view = view;
		view.addMouseListener(this);
		view.addButtonListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		System.out.println("mouse pressed");
		int size = model.getSquareSize();
		for (int i = 0; i < 4; i++) {
			Square[] current = model.getPlayer();
			int currentX = current[i].getX();
			int currentY = current[i].getY();
			int mouseX = e.getX(); 
			int mouseY = e.getY(); 
			if (mouseX > currentX && mouseX < currentX + size && mouseY > currentY && mouseY < currentY + size) {
				current[i].changeColor();
				view.repaint();
				System.out.println("changing color of square " + i);
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == view.button){
			System.out.println("het werkt");
		}
		
	}
}
