/* 
 * NAME: Anita Yen
 * PID: A13457606
 * LOGIN: cs12wanf
 */
package hw4;

import static org.junit.Assert.*;
import java.util.LinkedList;
import org.junit.Before;
import org.junit.Test;

/**
 * A JUnit Tester that tests the method in DoubleEndedLL.java
 * 
 * @version 1.0
 * @author Anita Yen
 * @since 2017-01-31
 */
public class DoubleEndedLLTester<T> {
	LinkedList<T> data = new LinkedList<T>();

	//Set up the linked list to be tested
	@Before
	public void setUp() {
		for (int i = 0; i < 10; i++) {
			Integer a = i;
			data.add(i, (T) a);
		}
	}

	// Tests the isEmpty method in DoubleEndedLL
	@Test
	public void testisEmpty() {
		assertTrue("Test isEmpty", !data.isEmpty());
	}

	// Tests the size method in DoubleEndedLL
	@Test
	public void testSize() {
		assertEquals("Test size", 10, data.size());
	}

	// Tests the addFirst method in DoubleEndedLL
	@Test
	public void testAddFirst() {
		data.addFirst((T) new Integer(1));
		assertEquals("test addFirst", 1, data.get(0));

	}

	// Tests the addLast method in DoubleEndedLL
	@Test
	public void testAddLast() {
		data.addLast((T) new Integer(10));
		assertEquals("tests addLast", 10, data.get(10));
	}

	// Tests the removeFirst method in DoubleEndedLL
	@Test
	public void testRemoveFirst() {
		data.removeFirst();
		assertEquals("test removeFirst", 1, data.get(0));
		assertEquals("tests removeFirst", 9, data.size());
	}

	// Tests the removeLast method in DoubleEndedLL
	@Test
	public void testRemoveLast() {
		data.removeLast();
		assertEquals("test removeLast", 8, data.get(data.size() - 1));
		assertEquals("tests removeLast", 9, data.size());
	}
}
