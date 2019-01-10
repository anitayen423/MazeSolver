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
 * A JUnit Tester that tests the public methods in MyStack.java
 * 
 * @version 1.0
 * @author Anita Yen
 * @since 2017-01-31
 */
public class MyStackTester<T> {
	MyStack<T> data = new MyStack<T>();

	// Sets up a stack to be tested
	@Before
	public void setUp() {
		for (int i = 0; i < 10; i++) {
			T a = (T) new Integer(i);
			data.addElement(a);

		}
	}

	// Tests the isEmpty method in MyStack
	@Test
	public void testIsEmpty() {
		assertTrue("Test empty", !data.isEmpty());
	}

	// Tests the addElement method in MyStack
	@Test
	public void testAddElement() {
		T newItem = (T) new Integer(100);
		data.addElement(newItem);
		assertEquals("test AddElement", 100, data.peek());

	}

	// Tests the removeElement method in myStack
	@Test
	public void testRemoveElement() {
		data.removeElement();
		assertEquals("test removeElement", 8, data.peek());
		assertEquals("test removeElement", 9, data.size());
	}

	// Tests the size method in myStack
	@Test
	public void testSize() {
		assertEquals("Test Size", 10, data.size());
	}

	// Tests the peek method in myStack
	@Test
	public void testPeek() {
		assertEquals("Test peek", 9, data.peek());
	}
}
