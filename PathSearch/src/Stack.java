class Board {
	Point[][] gameboard;
	Point start,end,current;
	
	Board() {
		gameboard = new Point[8][8];
		for (int i = 0; i < gameboard.length; i++) {
			for (int j = 0; j < gameboard[i].length; j++) {
				gameboard[i][j] = new Point();
			}
		}
	}
	
	public void setStart(int pointX, int pointY) {
		start = gameboard[pointX][pointY];
		start.value = 'S';
		current = start;
	}
	
	public void setEnd(int pointX, int pointY) {
		end = gameboard[pointX][pointY];
		end.value = 'E';
	}
	
	public Point getEnd() {
		return end;
	}
	
	public void setCurrent(int pointX, int pointY) {
		current = gameboard[pointX][pointY];
	}
	
	public Point getCurrent() {
		return current;
	}
	
	public void setBlock(int pointX, int pointY) {
		gameboard[pointX][pointY].setBlock();
	}
	
	public Point getPoint(int pointX, int pointY) {
		return gameboard[pointX][pointY];
	}
	
	public void output() {
		for (int i = 0; i < gameboard.length; i++) {
			for (int j = 0; j < gameboard[i].length; j++) {
				if (j == gameboard[i].length - 1) {
					System.out.print("(" + gameboard[i][j].value + ") \n\n");
				} else {
					System.out.print("(" + gameboard[i][j].value + ") ");
				}
			}
		}
	}
}

class Point {
	int x,y;
	char value;
	boolean blocked;
	
	Point() {
		x = 0;
		y = 0;
		value = '0';
		blocked = false;
	}
	
	Point(int pointX, int pointY) {
		x = pointX;
		y = pointY;
		value = '0';
		blocked = false;
	}
	
	Point(int pointX, int pointY, char pointVal, boolean pointBlocked) {
		x = pointX;
		y = pointY;
		value = pointVal;
		blocked = pointBlocked;
	}
	
	public void setBlock() {
		value = 'X';
		blocked = true;
	}
	
	public Boolean isBlocked() {
		return blocked;
	}
}

class Stack {
	char[] sArray;
	int topIndex;
	
	public Stack() {
		sArray = new char[64];
		topIndex = -1;
	}
	
	public char top() {
		return sArray[topIndex];
	}
	
	public void pop() {
		if (topIndex > -1) {
			topIndex--;
		}
	}
	
	public boolean empty() {
		return topIndex == -1;
	}
	
	public void push(char x) {
		if (topIndex < 64) {
			topIndex++;
			sArray[topIndex] = x;
		}
	}
}

class FindPath {
	Board gboard;
	Stack gStack;
	
	FindPath() {
		gboard = new Board();
		gStack = new Stack();
	}
	
	public void findPath(Board gameBoard, Stack gameStack) {
		Point currentPoint = gameBoard.current;
		boolean canGoUp = gameBoard.getPoint(currentPoint.x, currentPoint.y + 1).isBlocked();
		boolean canGoDown = gameBoard.getPoint(currentPoint.x, currentPoint.y - 1).isBlocked();
		boolean canGoLeft = gameBoard.getPoint(currentPoint.x - 1, currentPoint.y).isBlocked();
		boolean canGoRight = gameBoard.getPoint(currentPoint.x + 1, currentPoint.y).isBlocked();
		
		while (!gameStack.empty()) {
			if (canGoUp) {
				
			} else if (canGoLeft) {
				
			} else if (canGoDown) {
				
			} else if (canGoRight) {
				
			}
		}
	}
}