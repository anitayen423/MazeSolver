/* 
 * NAME: Anita Yen
 * PID: A13457606
 * LOGIN: cs12wanf
 */
package hw4;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

/**
 * A JUnit Tester that tests the methods of Maze
 * 
 * @version 1.0
 * @author Anita Yen
 * @since 2017-01-31
 */
public class MazeTester {
	Maze m = new Maze();
	Square[][] test = new Square[m.getNumRows()][m.getNumCols()];

	// Sets up the maze for testing
	@Before
	public void setUp() throws Exception {
		m.loadMaze("maze-4.txt");
	}

	// Tests the getNeighbors() method in the Maze class
	@Test
	public void testGetNeighbors() {
		ArrayList<Square> neighbors = new ArrayList<Square>();

		Square sqStart = m.getStart();

		neighbors = m.getNeighbors(sqStart);

		// neighbors of start position, when start is in first row
		assertEquals("test getNeighbors", 2, neighbors.size());
		assertEquals("test getNeighbors", 0, neighbors.get(0).getRow());
		assertEquals("test getNeighbors", 2, neighbors.get(0).getCol());
		assertEquals("test getNeighbors", 0, neighbors.get(1).getRow());
		assertEquals("test getNeighbors", 0, neighbors.get(1).getCol());

		Square sqEnd = m.getFinish();

		neighbors = m.getNeighbors(sqEnd);

		// neighbors of finish position, when end position is in the middle
		assertEquals("test getNeighbors", 1, neighbors.size());
		assertEquals("test getNeighbors", 4, neighbors.get(0).getRow());
		assertEquals("test getNeighbors", 4, neighbors.get(0).getCol());

		test = m.getMaze();
		Square upperLeft = test[0][0];

		neighbors = m.getNeighbors(upperLeft);

		// neighbors of upperLeft corner
		assertEquals("test getNeighbors", 1, neighbors.size());
		assertEquals("test getNeighbors", 1, neighbors.get(0).getRow());
		assertEquals("test getNeighbors", 0, neighbors.get(0).getCol());

		Square upperRight = test[0][9];

		neighbors = m.getNeighbors(upperRight);

		// neighbors of upperRight corner
		assertEquals("test getNeighbors", 1, neighbors.size());
		assertEquals("test getNeighbors", 0, neighbors.get(0).getRow());
		assertEquals("test getNeighbors", 8, neighbors.get(0).getCol());

		Square bottomRight = test[9][9];

		neighbors = m.getNeighbors(bottomRight);

		// neighbors of bottomRight corner
		assertEquals("test getNeighbors", 1, neighbors.size());
		assertEquals("test getNeighbors", 9, neighbors.get(0).getRow());
		assertEquals("test getNeighbors", 8, neighbors.get(0).getCol());

		Square bottomLeft = test[9][0];

		neighbors = m.getNeighbors(bottomLeft);

		// neighbors of bottomLeft corner
		assertEquals("test getNeighbors", 2, neighbors.size());
		assertEquals("test getNeighbors", 8, neighbors.get(0).getRow());
		assertEquals("test getNeighbors", 0, neighbors.get(0).getCol());
		assertEquals("test getNeighbors", 9, neighbors.get(1).getRow());
		assertEquals("test getNeighbors", 1, neighbors.get(1).getCol());

		Square left = test[1][0];

		neighbors = m.getNeighbors(left);

		// neighbors of left edge
		assertEquals("test getNeighbors", 2, neighbors.size());
		assertEquals("test getNeighbors", 0, neighbors.get(0).getRow());
		assertEquals("test getNeighbors", 0, neighbors.get(0).getCol());
		assertEquals("test getNeighbors", 2, neighbors.get(1).getRow());
		assertEquals("test getNeighbors", 0, neighbors.get(1).getCol());

		Square bottom = test[9][5];

		neighbors = m.getNeighbors(bottom);

		// neighbors of bottom edge
		assertEquals("test getNeighbors", 2, neighbors.size());
		assertEquals("test getNeighbors", 9, neighbors.get(0).getRow());
		assertEquals("test getNeighbors", 6, neighbors.get(0).getCol());
		assertEquals("test getNeighbors", 9, neighbors.get(1).getRow());
		assertEquals("test getNeighbors", 4, neighbors.get(1).getCol());
	}

	// Tests the getStart() method in the Maze class
	@Test
	public void testGetStart() {
		Square start = m.getStart();
		assertEquals("test getStart", 0, start.getRow());
		assertEquals("test getStart", 1, start.getCol());
	}

	// Tests the getFinish() method in the Maze class
	@Test
	public void testGetFinish() {
		Square end = m.getFinish();
		assertEquals("test getFinish", 5, end.getRow());
		assertEquals("test getFinish", 4, end.getCol());
	}

	// Tests the setVisit() method in the Maze class
	@Test
	public void testSetVisit() {
		Square test = m.getStart();
		test.setVisited();

		assertTrue("test setVisit", test.isVisited());
	}

	// Tests the clearMaze() method in the Maze class
	@Test
	public void testClearMaze() {
		Square test = m.getStart();
		m.setVisit(0, 0);
		m.clearMaze();

		assertTrue("test clearMaze", !(test.isVisited()));

	}

	// Tests the getMaze() method in the Maze class
	@Test
	public void testGetMaze() {
		test = m.getMaze();

		assertEquals("test getMaze", 2, test[0][1].getType());
		assertEquals("test getMaze", 3, test[5][4].getType());
		assertEquals("test getMaze", 1, test[1][1].getType());
	}

	// Prints the maze out using the toString() method in the Maze class
	@Test
	public void testPrintMaze() {
		System.out.println(m.toString());
	}

}
