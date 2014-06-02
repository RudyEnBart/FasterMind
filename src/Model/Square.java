package Model;

import java.awt.Color;
import java.awt.Graphics;

public class Square {
	private int _posX;
	private int _posY;
	private int _width;
	private int _height;
	private Color _color;
	
	// create a square with the required arguments (w = width, h = height, c = color)
	public Square(int x, int y, int w, int h, Color c) {
		_posX = x;
		_posY = y;
		_width = w;
		_height = h;
		_color = c;
	}
	
	public void draw(Graphics g) {
		Color temp = g.getColor();
		g.setColor(_color);
		g.fillRect(_posX, _posY, _width, _height);
		g.setColor(temp);
	}
}
