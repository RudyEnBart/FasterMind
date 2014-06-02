package Model;

import java.awt.Color;
import java.util.ArrayList;

public class FM_Model {
	private Square[][] _leftPlayField = new Square[4][10];
	private Square[][] _rightPlayField = new Square[4][10];
	private Square[] _leftPlayer = new Square[4];
	private Square[] _rightPlayer = new Square[4];

	private final int GRIDSIZE = 10;
	private final int AMOUNTOFSQUARES = 4;
	private int _squareSize = 50;
	private int _screenWidth;
	private int _screenHeight;

	public FM_Model() {
		init();
	}
	
	public void init() {
		for (int i = 0; i < GRIDSIZE; i++) {
			for (int j = 0; j < AMOUNTOFSQUARES; j++) {
				_leftPlayField[j][i] = new Square(j*(_squareSize + 5) + (_screenWidth/8) , i*(_squareSize + 5), _squareSize); 
			}
		}
		for (int i = 0; i < GRIDSIZE; i++) {
			for (int j = 0; j < AMOUNTOFSQUARES; j++) {
				_rightPlayField[j][i] = new Square(j*(_squareSize + 5) + _squareSize * 10, i*(_squareSize + 5), _squareSize); 
			}
		}
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < AMOUNTOFSQUARES; j++) {
				if (i == 0) {
					_leftPlayer[j] = new Square(j*(_squareSize + 5), _screenHeight - (_squareSize + 10), _squareSize);
				} else {
					_rightPlayer[j] = new Square(j*(_squareSize + 5) + _squareSize * 10, _screenHeight - (_squareSize + 10), _squareSize);
				}
			}
		}
	}
	
	public void drawSquares() {
		
	}
	
	public int getSquareSize() {
		return _squareSize;
	}
	
	public Square[][] getLeftPlayField() {
		return _leftPlayField;
	}
	
	public Square[][] getRightPlayField() {
		return _rightPlayField;
	}
	
	public void setSquareSize(int size) {
		int oldSize = _squareSize;
		_squareSize = size;
		for (int i = 0; i < GRIDSIZE; i++) {
			for (int j = 0; j < AMOUNTOFSQUARES; j++) {
				_leftPlayField[j][i] = new Square(j*(_squareSize + 5) + ((_screenWidth/4)-(_squareSize*2))-10 , i*(_squareSize + 5), _squareSize, _leftPlayField[j][i].getColor()); 
			}
		}
		for (int i = 0; i < GRIDSIZE; i++) {
			for (int j = 0; j < AMOUNTOFSQUARES; j++) {
				_rightPlayField[j][i] = new Square(j*(_squareSize + 5) + ((_screenWidth/4*3)-(_squareSize*2))-10 , i*(_squareSize + 5), _squareSize, _colorList.get(0)); 
			}
		}
	}
	
	public int get_screenWidth() {
		return _screenWidth;
	}

	public void set_screenWidth(int _screenWidth) {
		this._screenWidth = _screenWidth;
	}

	public int get_screenHeight() {
		return _screenHeight;
	}

	public void set_screenHeight(int _screenHeight) {
		this._screenHeight = _screenHeight;
	}
	
	public Square[] getLeftPlayer() {
		return _leftPlayer;
	}

	public void setLeftPlayer(Square[] _leftPlayer) {
		this._leftPlayer = _leftPlayer;
	}

	public Square[] getRightPlayer() {
		return _rightPlayer;
	}

	public void setRightPlayer(Square[] _rightPlayer) {
		this._rightPlayer = _rightPlayer;
	}

}
