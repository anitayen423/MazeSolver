/* 
 * NAME: Anita Yen
 * PID: A13457606
 * LOGIN: cs12wanf
 */
package hw4;

import java.util.ArrayList;

/**
 * An abstract class to be extended by MazeSolverStack and MazeSolverQueue
 * 
 * @version 1.0
 * @author Anita Yen
 * @since 2017-01-31
 */
public abstract class MazeSolver {

	protected Maze maze = new Maze();
	private String path = "Found the Escape!";
	boolean gameOver = false; // when stop our game
	boolean foundExit = false; // exit has been found
	boolean firstTime = true;
	MyStack<Square> end = new MyStack<Square>();

	/**
	 * Abstract method that makes the worklist empty
	 */
	abstract void makeEmpty(); // make worklist empty

	/**
	 * Checks to see if the worklist is empty
	 * 
	 * @return true if the worklist is empty, false otherwise
	 */
	abstract boolean isEmpty(); // if (worklist.size == 0) return true;

	/**
	 * Adds a Square to worklist
	 * 
	 * @param sq
	 *            Square to be added to worklist
	 */
	abstract void add(Square sq); // add Square to worklist

	/**
	 * Retrieves the next Square in the worklsit
	 * 
	 * @return next item from the worklist
	 */
	abstract Square next(); // Return next item from the worklist

	/**
	 * Gets the size of the worklist
	 * 
	 * @return size of worklist
	 */
	abstract int size();

	/**
	 * Non-abstract constructor that takes a maze parameter and stores it in a
	 * variable that the child classes can access
	 * 
	 * @param maze2
	 *            is the maze to be set to maze
	 */
	MazeSolver(Maze maze2) {
		maze = maze2;
	}

	/**
	 * Getter for maze
	 * 
	 * @return current maze
	 */
	public Maze getMaze() {
		return maze;
	}

	/**
	 * Add start location to worklist
	 */
	public void addStartToWorklist() {
		add(maze.getStart());
	}

	/**
	 * repeatedly call step() until you get to the exit square or the worklist
	 * is empty.
	 */
	public void solve() {
		while (!gameOver) {
			step();
		}
	}

	/**
	 * Adds the neighbors of a square to the worklist if they have not been
	 * visited yet
	 * 
	 * @return the square that was just explored
	 */
	public Square step() {
		Square sq = null;
		if (firstTime && isEmpty()) {
			// if the worklist is empty
			firstTime = false;
			makeEmpty();
			addStartToWorklist();
		} else {
			// when the worklist is empty, the game is over
			if (isEmpty()) {
				setGameOver();
			}
			sq = next();
			// if the square is the finish, the game is over
			if (sq.equals(maze.getFinish())) {
				setFoundExit();
				tracePath();
				setGameOver();
				return sq;
			}
			// adds the neighbors to the worklist if they have not been added to
			// the worklist yet
			ArrayList<Square> neighbors = new ArrayList<Square>();
			neighbors = maze.getNeighbors(sq);
			for (int i = 0; i < neighbors.size(); i++) {
				if (neighbors.get(i).getPrevious() == null) {
					if (!neighbors.get(i).equals(maze.getFinish())) {
						neighbors.get(i).setOnWorkList(true);
					}

					add(neighbors.get(i));
					neighbors.get(i).setPrevious(sq);
				}
			}
			// Set the start square to visited
			if (!sq.equals(maze.getStart())) {
				sq.setVisited();
			}
		}
		return sq;
	}

	/**
	 * Traces the path from end to start using a stack to keep track of the path
	 */
	public void tracePath() {
		Square sq = maze.getFinish().getPrevious();
		// Adds each element to the stack
		while (sq.getPrevious() != null) {
			sq.setOnFinalPath(true);
			end.addElement(sq);
			sq = sq.getPrevious();
		}

		end.addElement(maze.getStart());

		// Stores the coordinates of the path
		path = path + "\nPath from Start to Exit : ";

		int size = end.size();
		for (int i = 0; i < size; i++) {
			Square endSquare = end.removeElement();
			int row = endSquare.getRow();
			int col = endSquare.getCol();
			path += "[" + row + "," + col + "] ";

		}

	}

	/**
	 * Checks to see if the path exists
	 * 
	 * @return true if a path from the start to the exit has been found, false
	 *         otherwise
	 */
	public boolean foundExit() {
		return foundExit;
	}

	/**
	 * Keeps track of the game progress
	 * 
	 * @return true when the game ends - when an exit is found or when the
	 *         worklist becomes empty
	 */
	public boolean gameOver() {

		return gameOver;
	}

	/**
	 * Sets the foundExit boolean to true
	 */
	public void setFoundExit() {
		foundExit = true;
	}

	/**
	 * Sets the gameOver boolean to true
	 */
	public void setGameOver() {

		gameOver = true;

	}

	/**
	 * Returns the path if there is one
	 * 
	 * @return Path from S to E as a list of coordinates [i,j] If not solvable,
	 *         print message
	 */
	public String getPath() {

		if (foundExit()) {
			return path;
		} else {
			path = "Uh Oh!! There's no escape!!";
			return path;

		}
	}
}
