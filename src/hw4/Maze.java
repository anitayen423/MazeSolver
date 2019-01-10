/* 
 * NAME: Anita Yen
 * PID: A13457606
 * LOGIN: cs12wanf
 */
package hw4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * An interface that implements functions of a Queue and Stack
 * 
 * @version 1.0
 * @author Anita Yen
 * @since 2017-01-31
 */

public class Maze {
	public Square[][] maze; // a 2D Maze
	protected int numRows; // No of rows
	protected int numCols; // No of cols
	private int startX; // position of start
	private int startY;
	private int endX; // position of end
	private int endY;
	private final int start = 2;
	private final int end = 3;

	/**
	 * Constructor that initializes numRows and numCols
	 */
	public Maze() {
		numRows = 0;
		numCols = 0;
	}

	/**
	 * Reads in a text file of a maze and creates the maze
	 * 
	 * @param fname
	 *            text file name
	 * @return true always
	 */
	public boolean loadMaze(String fname) {

		String line;
		BufferedReader inputStrem;
		StringTokenizer st;

		try {
			int currentRow = 0;

			inputStrem = new BufferedReader(new FileReader(fname));
			line = inputStrem.readLine();
			if (line != null) {
				st = new StringTokenizer(line);
				numRows = Integer.parseInt(st.nextToken());
				numCols = Integer.parseInt(st.nextToken());
				maze = new Square[numRows][numCols];
			} else {
				return false;
			}

			while ((line = inputStrem.readLine()) != null) {
				if (numRows == 0) { // true if reading first line in file,
									// containing numRows numColums
					st = new StringTokenizer(line);
					numRows = Integer.parseInt(st.nextToken());
					numCols = Integer.parseInt(st.nextToken());
					maze = new Square[numRows][numCols];

				} else if (line.length() == 1)
					break;
				else {
					int col = 0;
					for (int c = 0; c < line.length(); c++) {

						if (line.charAt(c) == ' ')
							continue;
						maze[currentRow][col] = new Square(currentRow, col,
								Character.getNumericValue(line.charAt(c)));

						if (Character.getNumericValue(line.charAt(c)) == 2) {
							// get start of maze
							startX = currentRow;
							startY = col;
						} else if (maze[currentRow][col].isFinish()) {
							// get exit of maze
							endX = currentRow;
							endY = col;
						}
						col++;
					}
					currentRow++;
				}
			}
		} catch (IOException e) {
			System.out.println(e.toString());
			System.out.println("Could not find file " + fname);
		}

		return true;
	}

	/**
	 * Checks to see how many neighbors each square has and returns them in an
	 * ArrayList in the order North, East, South, West
	 * 
	 * @param sq
	 *            the sqaure to find neighbors for
	 * @return an arrayList of squares that contains the neighbors of sq
	 */
	public ArrayList<Square> getNeighbors(Square sq) {

		ArrayList<Square> neighbors = new ArrayList<Square>();
		if (sq.getRow() == 0 && sq.getCol() == 0) {
			// Check left upper corner
			if (maze[sq.getRow()][sq.getCol() + 1].isValid()) {
				neighbors.add(maze[sq.getRow()][sq.getCol() + 1]);
			}
			if (maze[sq.getRow() + 1][sq.getCol()].isValid()) {
				neighbors.add(maze[sq.getRow() + 1][sq.getCol()]);
			}
		} else if (sq.getRow() == 0 && sq.getCol() != numCols - 1
				&& sq.getCol() != 0) {
			// check first row
			if (maze[sq.getRow()][sq.getCol() + 1].isValid()) {
				neighbors.add(maze[sq.getRow()][sq.getCol() + 1]);
			}

			if (maze[sq.getRow() + 1][sq.getCol()].isValid()) {
				neighbors.add(maze[sq.getRow() + 1][sq.getCol()]);
			}
			if (maze[sq.getRow()][sq.getCol() - 1].isValid()) {
				neighbors.add(maze[sq.getRow()][sq.getCol() - 1]);
			}
		} else if (sq.getRow() == 0 && sq.getCol() == numCols - 1) {
			// check right upper corner
			if (maze[sq.getRow() + 1][sq.getCol()].isValid()) {
				neighbors.add(maze[sq.getRow() + 1][sq.getCol()]);
			}
			if (maze[sq.getRow()][sq.getCol() - 1].isValid()) {
				neighbors.add(maze[sq.getRow()][sq.getCol() - 1]);
			}
		} else if (sq.getRow() != 0 && sq.getCol() == 0
				&& sq.getRow() != numRows - 1) {
			// checks left edge
			if (maze[sq.getRow() - 1][sq.getCol()].isValid()) {
				neighbors.add(maze[sq.getRow() - 1][sq.getCol()]);
			}
			if (maze[sq.getRow()][sq.getCol() + 1].isValid()) {
				neighbors.add(maze[sq.getRow()][sq.getCol() + 1]);
			}
			if (maze[sq.getRow() + 1][sq.getCol()].isValid()) {
				neighbors.add(maze[sq.getRow() + 1][sq.getCol()]);
			}
		} else if (sq.getRow() == numRows - 1 && sq.getCol() == 0) {
			// check left lower corner

			if (maze[sq.getRow() - 1][sq.getCol()].isValid()) {
				neighbors.add(maze[sq.getRow() - 1][sq.getCol()]);
			}
			if (maze[sq.getRow()][sq.getCol() + 1].isValid()) {
				neighbors.add(maze[sq.getRow()][sq.getCol() + 1]);
			}
		} else if (sq.getRow() == numRows - 1 && sq.getCol() != 0
				&& sq.getCol() != numCols - 1) {
			// checks last row
			if (maze[sq.getRow() - 1][sq.getCol()].isValid()) {
				neighbors.add(maze[sq.getRow() - 1][sq.getCol()]);
			}
			if (maze[sq.getRow()][sq.getCol() + 1].isValid()) {
				neighbors.add(maze[sq.getRow()][sq.getCol() + 1]);
			}
			if (maze[sq.getRow()][sq.getCol() - 1].isValid()) {
				neighbors.add(maze[sq.getRow()][sq.getCol() - 1]);
			}
		} else if (sq.getRow() == numRows - 1 && sq.getCol() == numCols - 1) {
			// check lower right corner
			if (maze[sq.getRow() - 1][sq.getCol()].isValid()) {
				neighbors.add(maze[sq.getRow() - 1][sq.getCol()]);
			}
			if (maze[sq.getRow()][sq.getCol() - 1].isValid()) {
				neighbors.add(maze[sq.getRow()][sq.getCol() - 1]);
			}
		} else if (sq.getRow() != 0 && sq.getCol() == numCols - 1
				&& sq.getRow() != numRows - 1) {
			// check right edge
			if (maze[sq.getRow() - 1][sq.getCol()].isValid()) {
				neighbors.add(maze[sq.getRow() - 1][sq.getCol()]);
			}
			if (maze[sq.getRow() + 1][sq.getCol()].isValid()) {
				neighbors.add(maze[sq.getRow() + 1][sq.getCol()]);
			}
			if (maze[sq.getRow()][sq.getCol() - 1].isValid()) {
				neighbors.add(maze[sq.getRow()][sq.getCol() - 1]);
			}
		} else {
			// check all other squares
			if (maze[sq.getRow() - 1][sq.getCol()].isValid()) {
				neighbors.add(maze[sq.getRow() - 1][sq.getCol()]);
			}
			if (maze[sq.getRow()][sq.getCol() + 1].isValid()) {
				neighbors.add(maze[sq.getRow()][sq.getCol() + 1]);
			}
			if (maze[sq.getRow() + 1][sq.getCol()].isValid()) {
				neighbors.add(maze[sq.getRow() + 1][sq.getCol()]);
			}
			if (maze[sq.getRow()][sq.getCol() - 1].isValid()) {
				neighbors.add(maze[sq.getRow()][sq.getCol() - 1]);
			}

		}

		return neighbors;
	}

	/**
	 * Gets the start square of the maze
	 * 
	 * @return the start square
	 */
	public Square getStart() {
		return maze[startX][startY];

	}

	/**
	 * Gets the finish square of the maze
	 * 
	 * @return the finish square
	 */
	public Square getFinish() {
		return maze[endX][endY];
	}

	/**
	 * Set visit of a particular square
	 * 
	 * @param row
	 *            the row the square is in
	 * @param col
	 *            the column the square is in
	 */
	public void setVisit(int row, int col) {
		maze[row][col].setVisited();
	}

	/**
	 * Clears the maze and resets visited
	 */
	public void clearMaze() {
		for (int i = 0; i < numRows; i++) {
			for (int j = 0; j < numCols; j++) {
				maze[i][j].clearVisited();
			}
		}
	}

	/**
	 * Getter method for maze
	 * 
	 * @return the maze
	 */
	public Square[][] getMaze() {
		return maze;
	}

	/**
	 * Gets the number of rows in the maze
	 * 
	 * @return the number of rows
	 */
	public int getNumRows() {
		return numRows;
	}

	/**
	 * Gets the number of columns in the maze
	 * 
	 * @return the number of columns
	 */
	public int getNumCols() {
		return numCols;
	}

	/**
	 * Concatenates the maze into a String
	 * 
	 * @return the maze
	 */
	@Override
	public String toString() {

		String s = "";
		for (int r = 0; r < numRows; r++) {
			for (int c = 0; c < numCols; c++)
				s = s + maze[r][c].toString();
			s = s + "\n";
		}
		return s;
	}

}
