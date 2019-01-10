/* 
 * NAME: Anita Yen
 * PID: A13457606
 * LOGIN: cs12wanf
 */
package hw4;

/**
 * A class that instantiates a square
 * 
 * @version 1.0
 * @author Anita Yen
 * @since 2017-01-31
 */
public class Square {
	private int row;
	private int col;
	private boolean visited;
	private int type;
	private Square previous;
	private final int emptySpace = 0;
	private final int wall = 1;
	private final int start = 2;
	private final int exit = 3;
	private boolean onFinalPath;
	private boolean onWorkList;

	/**
	 * Constructor that initializes a square
	 * 
	 * @param row
	 *            the row the square is in
	 * @param col
	 *            the col the square is in
	 * @param type
	 *            the type of the square
	 */
	public Square(int row, int col, int type) {
		this.row = row;
		this.col = col;
		this.type = type;
		this.previous = null;
	}

	/**
	 * Marks the square as an emptySpace, wall, start, or exit and checks to see
	 * if the path is visited, on the workList, or on the final path
	 * 
	 * @return the character that categorizes each square
	 */
	public String toString() {
		if (onFinalPath) {
			return "x";
		}
		if (visited) {
			return ".";
		}
		if (onWorkList) {
			return "o";
		}

		switch (type) {
		case emptySpace:
			return "_";
		case wall:
			return "#";
		case start:
			return "S";
		case exit:
			return "E";
		}

		return null;
	}

	/**
	 * Return the row of each square
	 * 
	 * @return the row each square is in
	 */
	public int getRow() {
		return row;
	}

	/**
	 * Return the column of each square
	 * 
	 * @return the column each square is in
	 */
	public int getCol() {
		return col;
	}

	/**
	 * Return the type of each square
	 * 
	 * @return the type of each square
	 */
	public int getType() {
		return this.type;
	}

	/**
	 * Checks to see if the square is the exit
	 * 
	 * @return true if the square is an exit, false otherwise
	 */
	public boolean isFinish() {
		if (this.type == exit) {
			return true;
		}

		return false;
	}

	/**
	 * Checks to see if the square is the start
	 * 
	 * @return true if the square is the start, false otherwise
	 */
	public boolean isStart() {
		if (this.type == start) {
			return true;
		}
		return false;
	}

	/**
	 * Checks to see if the square is a wall or the start
	 * 
	 * @return false if the square is a wall or a start, true otherwise
	 */
	public boolean isValid() {
		if (this.type == wall || isStart()) {
			return false;
		}

		return true;
	}

	/**
	 * Checks to see if the square has been visited
	 * 
	 * @return return true if the square has been visited, false otherwise
	 */
	public boolean isVisited() {
		if (visited) {
			return true;
		}
		return false;
	}

	/**
	 * Sets the square to visited
	 */
	public void setVisited() {
		visited = true;
	}

	/**
	 * Clears the visited boolean and sets previous to null
	 */
	public void clearVisited() {
		visited = false;
		previous = null;
	}

	/**
	 * Returns the previous square
	 * 
	 * @return previous square
	 */
	public Square getPrevious() {
		return previous;
	}

	/**
	 * Sets the previous square
	 * 
	 * @param previous
	 *            is the square to be set to previous
	 */
	public void setPrevious(Square previous) {
		this.previous = previous;
	}

	/**
	 * Checks to see if the square is on the final path
	 * 
	 * @return true if the square is on the final path, false otherwise
	 */
	public boolean isOnFinalPath() {
		return onFinalPath;
	}

	/**
	 * Sets onFinalPath to true if the square is on the final path
	 * 
	 * @param onFinalPath
	 *            boolean to be set to onFinalPath
	 */
	public void setOnFinalPath(boolean onFinalPath) {
		this.onFinalPath = onFinalPath;
	}

	/**
	 * Checks to see if the square is on the work list
	 * 
	 * @return true if the square is on the worklist, false otherwise
	 */
	public boolean isOnWorkList() {
		return onWorkList;
	}

	/**
	 * Set the worklist to true if the square in in the worklist
	 * 
	 * @param onWorkList
	 *            boolean to be set to onWorkList
	 */
	public void setOnWorkList(boolean onWorkList) {
		this.onWorkList = onWorkList;
	}

}
