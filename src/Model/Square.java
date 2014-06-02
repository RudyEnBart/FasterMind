package Model;

import java.awt.Color;
import java.awt.Graphics;

public class Square {
	private int _posX;
	private int _posY;
	private int _width;
	private int _height;
	private Color _color;
	
	// create a square with the required arguments
	public Square(int x, int y, int size, Color c) {
		_posX = x;
		_posY = y;
		_width = size;
		_height = size;
		_color = c;
	}
	
	public void draw(Graphics g) {
		Color temp = g.getColor();
		g.setColor(_color);
		g.fillRect(_posX, _posY, _width, _height);
		g.setColor(temp);
	}
	
	public int getX() {
		return _posX;
	}
	
	public int getY() {
		return _posY;
	}
	
	public int getWidth() {
		return _width;
	}
	
	public int getHeight() {
		return _height;
	}
	
	public Color getColor() {
		return _color;
	}
	
	public void setX(int x) {
		_posX = x;
	}
	
	public void setY(int y) {
		_posY = y;
	}
	
	public void setColor(Color c) {
		_color = c;
	}
	
	public void setSize(int size) {
		_width = size;
		_height = size;
	}
}
