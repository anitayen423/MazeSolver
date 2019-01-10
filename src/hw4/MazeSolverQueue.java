/* 
 * NAME: Anita Yen
 * PID: A13457606
 * LOGIN: cs12wanf
 */
package hw4;

/**
 * An class that extends MazeSolver and uses a queue to solve the maze
 * 
 * @version 1.0
 * @author Anita Yen
 * @since 2017-01-31
 */
public class MazeSolverQueue extends MazeSolver {

	MyQueue<Square> queue = new MyQueue<>();

	/**
	 * Constructor that takes a maze parameter and stores it in a variable that
	 * the child classes can access
	 * 
	 * @param maze2
	 *            is the maze to be set to maze
	 */
	MazeSolverQueue(Maze maze) {
		super(maze);
	}

	/**
	 * Makes the worklist empty
	 */
	public void makeEmpty() {
		while (!isEmpty()) {
			queue.removeElement();
		}
	}

	/**
	 * Checks to see if the worklist is empty
	 * 
	 * @return true if the worklist is empty, false otherwise
	 */
	public boolean isEmpty() {
		if (queue.isEmpty()) {
			return true;
		}
		return false;
	}

	/**
	 * Adds a Square to worklist
	 * 
	 * @param sq
	 *            Square to be added to worklist
	 */
	public void add(Square sq) {
		queue.addElement(sq);
	}

	/**
	 * Retrieves the next Square in the worklsit
	 * 
	 * @return next item from the worklist
	 */
	public Square next() {
		return queue.removeElement();
	}

	/**
	 * Getter method for the queue of squares
	 * 
	 * @return the queue of squares
	 */
	public MyQueue<Square> getQueue() {
		return queue;
	}

	/**
	 * Returns the size of the queue
	 * 
	 * @return size of queue
	 */
	@Override
	public int size() {
		return queue.size();
	}

	/**
	 * Main method to run the program and solve the maze
	 * 
	 * @param args
	 *            array of console line argument whose data type is String
	 */
	public static void main(String[] args) {
		Maze myMaze = new Maze();
		boolean load = myMaze.loadMaze(args[0]);
		if (!load) {
			System.out.println("Oops!! Could not load the Maze");
		} else {
			MazeSolverQueue queueSolver = new MazeSolverQueue(myMaze);
			queueSolver.solve();
			System.out.println(queueSolver.getPath() + "\n");
			System.out.println(queueSolver.getMaze().toString());
			System.out.println("Number of squares remaining in the worklist = "
					+ queueSolver.getQueue().size());
		}
	}

}
