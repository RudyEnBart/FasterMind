package View;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Model.FM_Model;
import Model.Square;

public class FM_View extends JPanel {
	private FM_Model model;
	private JFrame frame;
	private int _screenWidth;
	private int _screenHeight;
	
	public FM_View(FM_Model model) {
		this.model = model;
		frame = new JFrame("FasterMind!!!");
		init();
	}
	
	public void init() {
		frame.setVisible(true);
		frame.setSize(getMaximumSize());
		_screenWidth = frame.getWidth();
		_screenHeight = frame.getHeight();
		frame.add(this);
		setBackground(Color.black);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		for (Square s : model.getSquareList()) {
			s.draw(g);
		}
	}
}
