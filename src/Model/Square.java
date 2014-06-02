package Model;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Square {
	private int _posX;
	private int _posY;
	private int _width;
	private int _height;
	private Color _color;
	private int _colorIndex;
	private ArrayList<Color> _colorList = new ArrayList<>();

	public Square(int x, int y, int size) {
		_posX = x;
		_posY = y;
		_width = size;
		_height = size;
		_colorList.add(Color.GRAY);
		_colorList.add(Color.CYAN);
		_colorList.add(Color.WHITE);
		_colorList.add(Color.RED);
		_colorList.add(Color.ORANGE);
		_colorList.add(Color.YELLOW);
		_colorList.add(Color.GREEN);
		_colorList.add(Color.BLUE);
		_colorList.add(Color.MAGENTA);
		_color = _colorList.get(0);
		_colorIndex = 0;
	}

	public Square(int x, int y, int size, Color c) {
		this(x, y, size);
		_color = c;
		_colorIndex = _colorList.indexOf(c);
	}
	
	
	public void draw(Graphics g) {
		Color temp = g.getColor();
		g.setColor(_color);
		g.fillRect(_posX, _posY, _width, _height);
		g.setColor(temp);
	}
	
	public void changeColor() {
		_color = _colorList.get(++_colorIndex);
		System.out.println("changing color to " + _color.toString());
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
		_colorIndex = _colorList.indexOf(c);
	}
	
	public void setSize(int size) {
		_width = size;
		_height = size;
	}
	
	public ArrayList<Color> getColorList() {
		return _colorList;
	}
}
