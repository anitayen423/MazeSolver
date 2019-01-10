/* 
 * NAME: Anita Yen
 * PID: A13457606
 * LOGIN: cs12wanf
 */
package hw4;

/**
 * An class that extends MazeSolver and uses a stack to solve the maze
 * 
 * @version 1.0
 * @author Anita Yen
 * @since 2017-01-31
 */
public class MazeSolverStack extends MazeSolver {

	private MyStack<Square> stack = new MyStack<>();

	/**
	 * Constructor that takes a maze parameter and stores it in a variable that
	 * the child classes can access
	 * 
	 * @param maze2
	 *            is the maze to be set to maze
	 */
	MazeSolverStack(Maze maze) {
		super(maze);
	}

	/**
	 * Method that makes the worklist empty
	 */
	public void makeEmpty() {
		while (!stack.isEmpty()) {
			stack.removeElement();
		}

	}

	/**
	 * Gets the size of the worklist
	 * 
	 * @return size of worklist
	 */
	public int size() {
		return stack.size();
	}

	/**
	 * Checks to see if the worklist is empty
	 * 
	 * @return true if the worklist is empty, false otherwise
	 */
	public boolean isEmpty() {
		if (stack.isEmpty()) {
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
		stack.addElement(sq);
	}

	/**
	 * Retrieves the next Square in the worklsit
	 * 
	 * @return next item from the worklist
	 */
	public Square next() {
		return stack.removeElement();
	}

	/**
	 * Getter method for the stack of squares
	 * 
	 * @return the stack of squares
	 */
	public MyStack<Square> getStack() {
		return stack;
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
			MazeSolverStack stackSolver = new MazeSolverStack(myMaze);
			stackSolver.solve();
			System.out.println(stackSolver.getPath() + "\n");
			System.out.println(stackSolver.getMaze().toString());
			System.out.println("Number of squares remaining in the worklist = "
					+ stackSolver.getStack().size());
		}
	}
}
