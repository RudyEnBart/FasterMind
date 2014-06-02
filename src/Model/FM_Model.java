package Model;

import java.awt.Color;
import java.util.ArrayList;

public class FM_Model {
	private Square[][] _squareArray = new Square[4][10];
	private Square[][] _squareArray2 = new Square[4][10];
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
				_squareArray[j][i] = new Square(j*(_squareSize + 5), i*(_squareSize + 5), _squareSize, _colorList.get(0)); 
			}
		}
		for (int i = 0; i < GRIDSIZE; i++) {
			for (int j = 0; j < AMOUNTOFSQUARES; j++) {
				_squareArray2[j][i] = new Square(j*(_squareSize + 5) + _squareSize * 10, i*(_squareSize + 5), _squareSize, _colorList.get(0)); 
			}
		}
	}
	
	public void drawSquares() {
	}
	
	public ArrayList<Color> getColorList() {
		return _colorList;
	}
	
	public Square[][] getSquareArray() {
		return _squareArray;
	}
	
	public Square[][] getSquareArray2() {
		return _squareArray2;
	}
	
	public void setSquareSize(int size) {
		int oldSize = _squareSize;
		_squareSize = size;
		for (int i = 0; i < GRIDSIZE; i++) {
			for (int j = 0; j < AMOUNTOFSQUARES; j++) {
				_squareArray[j][i] = new Square(j*(_squareSize + 5), i*(_squareSize + 5), _squareSize, _squareArray[j][i].getColor()); 
			}
		}
		for (int i = 0; i < GRIDSIZE; i++) {
			for (int j = 0; j < AMOUNTOFSQUARES; j++) {
				_squareArray2[j][i] = new Square(j*(_squareSize + 5) + _squareSize * 20, i*(_squareSize + 5), _squareSize, _colorList.get(0)); 
			}
		}
	}
}
