package Model;

import java.awt.Color;


public class FM_Model {
	private Square[][] _leftPlayField = new Square[4][10];
	private Square[][] _rightPlayField = new Square[4][10];
	private Square[] _player = new Square[4];
	private Square[] _codeArray = new Square[4];

	private Square[][] _results = new Square[2][20];
	private Square[][] _enemyResults = new Square[2][20];

	private final int GRIDSIZE = 10;
	private final int AMOUNTOFSQUARES = 4;
	private final int CODE = 0;
	private final int LEFT = 1;
	private final int RIGHT = 2;

	private int _squareSize = 50;
	private int _screenWidth;
	private int _screenHeight;
	private int _code;
	private int _currentTry;
	private int _currentEnemyTry;
	private int _enemyCode;

	public FM_Model() {
		init();
	}

	public void init() {
		_code = -1;
		_enemyCode = 0;
		_currentTry = 0;
		_currentEnemyTry = 0;
		for (int i = 0; i < GRIDSIZE; i++) {
			for (int j = 0; j < AMOUNTOFSQUARES; j++) {
				_leftPlayField[j][i] = new Square(j*(_squareSize + 5) + ((_screenWidth/4)-(_squareSize*2))-10 , i*(_squareSize + 5), _squareSize); 
			}
		}
		for (int i = 0; i < GRIDSIZE; i++) {
			for (int j = 0; j < AMOUNTOFSQUARES; j++) {
				_rightPlayField[j][i] = new Square(j*(_squareSize + 5) + ((_screenWidth/4*3)-(_squareSize*2))-10, i*(_squareSize + 5), _squareSize); 
			}
		}
		for (int j = 0; j < AMOUNTOFSQUARES; j++) {
			_player[j] = new Square(j*(_squareSize + 5) + ((_screenWidth/4)-(_squareSize*2))-10, _screenHeight - (_squareSize + 50), _squareSize);
		}
		for (int i = 0; i < GRIDSIZE*2; i++) {
			for (int j = 0; j < AMOUNTOFSQUARES/2; j++) {
				_results[j][i] = new Square(j*(_squareSize/2 + 5) + ((_screenWidth/4)-(_squareSize*2))-10 + _squareSize*4 + 25, i*(_squareSize/2 + 5), _squareSize/2, 9);
			}
		}
	}

	public void updateField(int side, int code) {
		int tempCode = code;
		int offset = 1000;
		for (int i = 0; i < AMOUNTOFSQUARES; i++) {
			System.out.println("square in colorindex: " + tempCode/offset);
			switch (side) {
			case CODE:
				_codeArray[i] = new Square(i*(_squareSize + 5) + ((_screenWidth/4*3)-(_squareSize*2))-10, _screenHeight - (_squareSize + 50), _squareSize, tempCode/offset);
				break;
			case LEFT: 
				_leftPlayField[i][_currentTry] = new Square(i*(_squareSize + 5) + ((_screenWidth/4)-(_squareSize*2))-10, _screenHeight - (_squareSize + 50), _squareSize, tempCode/offset);
				break;
			case RIGHT:
				_rightPlayField[i][_currentEnemyTry] = new Square(i*(_squareSize + 5) + ((_screenWidth/4*3)-(_squareSize*2))-10, _screenHeight - (_squareSize + 50), _squareSize, tempCode/offset); 
				break;
			}
			tempCode -= (tempCode/offset) * offset;
			offset /= 10;
		}
		switch (side) {
		case LEFT:
			if (_currentTry >= 9) {
				done(false);
			} else {
				_currentTry++;
			}
			break;
		case RIGHT:
			_currentEnemyTry++;
			break;
		}
	}

	public void setSquareSize(int size) {
		_squareSize = size;
		for (int i = 0; i < GRIDSIZE; i++) {
			for (int j = 0; j < AMOUNTOFSQUARES; j++) {
				_leftPlayField[j][i] = new Square(j*(_squareSize + 5) + ((_screenWidth/4)-(_squareSize*2))-10 , i*(_squareSize + 5), _squareSize, _leftPlayField[j][i].getColor()); 
			}
		}
		for (int i = 0; i < GRIDSIZE; i++) {
			for (int j = 0; j < AMOUNTOFSQUARES; j++) {
				_rightPlayField[j][i] = new Square(j*(_squareSize + 5) + ((_screenWidth/4*3)-(_squareSize*2))-10 , i*(_squareSize + 5), _squareSize, _rightPlayField[j][i].getColor()); 
			}
		}
		for (int i = 0; i < AMOUNTOFSQUARES; i++) {
			_player[i] = new Square(i*(_squareSize + 5) + ((_screenWidth/4)-(_squareSize*2))-10, _screenHeight - (_squareSize + 50), _squareSize, _player[i].getColor());
		}
	}

	public int getCode() {
		//System.out.println("getting code");
		return _code;
	}

	public void setCode(int code) {
		this._code = code;
		updateField(CODE, code);
		System.out.println("setting code to: " + code);
	}

	public void checkCode(int code) {
		if (_enemyCode == code) {
			done(true);
		} else {
			int[] correct = checkForCorrectPosition(code);
			updateResult(correct);
			updateField(LEFT, code);
		}
	}

	private int[] checkForCorrectPosition(int code) {
		int[] correct = new int [2];
		int enemyCode = _code; //_enemyCode;
		int checkCode = code;
		
		correct[0] = 0;
		correct[1] = 0;
		int position = 0;
		for (int i = 1000; i > 0; i/=10) {
			System.out.println("checking: " + checkCode/i + " with: " + (enemyCode/i)%10);
			if (checkCode/i == (enemyCode/i)%10) {
				System.out.println("correct");
				correct[0]++;
				enemyCode -= ((enemyCode/i)%10)*i; 	
				code -= ((code/i)%10)*i;
			}
			System.out.println("enemyCode = " + enemyCode);
			checkCode -= (checkCode/i)*i;
		}
		checkCode = code;
		for (int i = 1000; i > 0; i/=10) {
			System.out.println("checking: " + checkCode/i + " with: " + (enemyCode/1000)%10 + " and: " + (enemyCode/100)%10 + " and: " + (enemyCode/10)%10 + " and: " + enemyCode%10);
			if (checkCode/i != 0) {
				if (checkCode/i == (enemyCode/1000)%10) {
					enemyCode -= ((enemyCode/1000)%10)*1000;
					correct[1]++;
				} else if (checkCode/i == (enemyCode/100)%10) {
					enemyCode -= ((enemyCode/100)%10)*100;
					correct[1]++;
				} else if (checkCode/i == (enemyCode/10)%10) {
					enemyCode -= ((enemyCode/10)%10)*10;
					correct[1]++;
				} else if (checkCode/i == enemyCode%10) {
					enemyCode -= enemyCode%10;
					correct[1]++;
				}
			}
			checkCode -= (checkCode/i)*i;
		}
		System.out.println("the amount of correct squares is: " + correct[0] + " and the number of almost correct squares is: " + correct[1]);
		return correct;
	}

	//first entry in the array is correct position and color
	//second entry in the array is correct color but incorrect position
	private void updateResult(int[] correct) {
		int resultColorIndex;
		for (int i = 0; i < AMOUNTOFSQUARES/2; i++) {
			for (int j = 0; j < AMOUNTOFSQUARES/2; j++) {
				if (correct[0] > 0) {
					resultColorIndex = 2;
					correct[0]--;
				} else if (correct[1] > 0) {
					resultColorIndex = 1;
					correct[1]--;
				} else {
					resultColorIndex = 0;
				}
				_results[j][i] = new Square(j*(_squareSize/2 + 5) + ((_screenWidth/4)-(_squareSize*2))-10 + _squareSize*4 + 25 , i*(_squareSize/2 + 5), _squareSize/2, resultColorIndex);
			}
		}
		//TODO show small squares of correct and almost correct colors and positions
	}

	public void done(boolean success) {
		//TODO code for being finished
		if (success) {

		} else {

		}
	}

	public void resetPlayer() {
		for (Square s : _player) {
			s.setColorIndex(0);
		}
	}

	public void setPlayer(Square[] _leftPlayer) {
		this._player = _leftPlayer;
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

	public Square[] getPlayer() {
		return _player;
	}

	public Square[] getCodeArray() {
		return _codeArray;
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

	public Square[][] getResults() {
		return _results;
	}
}
