package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Model.FM_Model;
import Model.Square;

public class FM_View extends JPanel {
	private FM_Model model;
	private JFrame frame;
	private int _screenWidth;
	private int _screenHeight;
	JButton button = new JButton("Submit");
	
	public FM_View(FM_Model model) {
		this.model = model;
		frame = new JFrame("FasterMind!!!");
		init();
	}
	
	public void init() {
		frame.setVisible(true);
		frame.setMinimumSize(new Dimension(640,480)); //Sets minimum size
		frame.setSize(getMaximumSize());
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(this);
		
		setBackground(Color.black);
		
		this.add(button);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		_screenWidth = frame.getWidth();
		_screenHeight = frame.getHeight();
		model.set_screenWidth(_screenWidth);
		model.set_screenHeight(_screenHeight);
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
		
		int width = 150;
		int height = 50;

		button.setBounds(_screenWidth/2 - width/2, _screenHeight/8*7 , width, height);
	}
}
