package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

import Model.FM_Model;
import Model.Square;
import View.FM_View;

public class FM_Controller implements MouseListener, ActionListener{
	private FM_Model model;
	private FM_View view;
	private boolean easyMode = true;

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
		Square[] current = model.getPlayer();
		for (int i = 0; i < 4; i++) {
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
		if(e.getSource() == view.button) {
			Square[] current = model.getPlayer();
			int value = 0;
			for (int i = 0; i < 4; i++) {
				if (current[i].getColorIndex() == 0 && easyMode) {
					JOptionPane.showMessageDialog(view, "Not all squares have been filled in!");
					model.resetPlayer();
					return;
				}
				value += current[i].getColorIndex();
				value *= 10;
			}
			value /= 10;
			
			if (model.getCode() >= 0) {
				model.checkCode(value);
			} else {
				model.setCode(value);
			}
		}
		model.resetPlayer();
	}
}
