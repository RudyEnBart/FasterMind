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
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(this);
		setBackground(Color.black);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		_screenWidth = frame.getWidth();
		_screenHeight = frame.getHeight();
		model.setSquareSize(_screenHeight / 14);
		for (Square[] sArray : model.getSquareArray()) {
			for (Square s : sArray) {
				s.draw(g);
			}
		}
		for (Square[] sArray : model.getSquareArray2()) {
			for (Square s : sArray) {
				s.draw(g);
			}
		}
	}
}
