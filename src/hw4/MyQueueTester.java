/* 
 * NAME: Anita Yen
 * PID: A13457606
 * LOGIN: cs12wanf
 */
package hw4;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * A JUnit tester that tests the methods of MyQueue
 * 
 * @version 1.0
 * @author Anita Yen
 * @since 2017-01-31
 */

public class MyQueueTester<T> {
	MyQueue<T> q = new MyQueue<T>();

	//Sets up the queue to be tested
	@Before
	public void setUp() {
		for (int i = 0; i < 1000; i++) {
			T data = (T) new Integer(i);
			q.addElement(data);
		}

	}
	
	//Tests the constructor in MyQueue
	@Test
	public void testCtor() {
		MyQueue<T> test = new MyQueue<T>();
		assertEquals("Test constructor", 0, test.getFront());
		assertEquals("Test constructor", 0, test.getSize());
		assertEquals("Test constructor", 0, test.getRear());

	}

	//Tests the isEmpty() method in MyQueue
	@Test
	public void testIsEmpty() {
		assertTrue("Test isEmpty", !q.isEmpty());
	}

	//Tests addElement() method in MyQueue
	@Test
	public void testAddElement() {
		q.addElement((T) new Integer(100));
		assertEquals("Test addElement", 1001, q.getRear());
		assertEquals("Test addElement", 1001, q.size());
	}

	//Tests the testSize() method in MyQueue
	@Test
	public void testSize() {
		assertEquals("Test size", 1000, q.getSize());
	}

	//Tests the removeElement() method in MyQueue
	@Test
	public void testRemoveElement() {
		q.removeElement();
		assertEquals("Test removeElement", 1, q.peek());
		assertEquals("Test removeElement", 999, q.getSize());
	}

	//Tests the peek() method in MyQueue
	@Test
	public void testPeek() {
		assertEquals("Test peek", 0, q.peek());
		assertEquals("Test peek", 0, q.getFront());
	}

}
