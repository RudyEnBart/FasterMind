package Model;

import java.awt.Color;
import java.util.ArrayList;

public class FM_Model {
	private ArrayList<Square> _squareList = new ArrayList<>();
	private ArrayList<Color> _colorList = new ArrayList<>();
	private final int GRIDSIZE = 10;
	private final int AMOUNTOFSQUARES = 4;
	private int _squareSize = 50;
	
	public FM_Model() {
		_colorList.add(Color.GRAY);
		_colorList.add(Color.BLACK);
		_colorList.add(Color.WHITE);
		_colorList.add(Color.RED);
		_colorList.add(Color.ORANGE);
		_colorList.add(Color.YELLOW);
		_colorList.add(Color.GREEN);
		_colorList.add(Color.BLUE);
		_colorList.add(Color.MAGENTA);
		init();
	}
	
	public void init() {
		for (int i = 0; i < GRIDSIZE; i++) {
			for (int j = 0; j < AMOUNTOFSQUARES; j++) {
				_squareList.add(new Square( + j*(_squareSize + 5), i*(_squareSize + 5), _squareSize, _colorList.get(0)));
			}
		}
	}
	
	public void drawSquares() {
	}
	
	public ArrayList<Color> getColorList() {
		return _colorList;
	}
	
	public ArrayList<Square> getSquareList() {
		return _squareList;
	}
	
	public void setSquareSize(int size) {
		_squareSize = size;
		for (Square s: _squareList) {
			s.setSize(size);
		}
	}
}
