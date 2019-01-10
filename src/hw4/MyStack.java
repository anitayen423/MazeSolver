/* 
 * NAME: Anita Yen
 * PID: A13457606
 * LOGIN: cs12wanf
 */
package hw4;

import hw4.DoubleEndedLL.Node;

import java.util.LinkedList;
import java.util.Queue;

/**
 * A class that utilizes a stack implements the Stack_QueueInterface
 * 
 * @version 1.0
 * @author Anita Yen
 * @since 2017-01-31
 */

public class MyStack<T> implements Stack_QueueInterface<T> {
	DoubleEndedLL<T> data = new DoubleEndedLL();

	/**
	 * Tests if the storage is empty.
	 * 
	 * @return true a storage contains no items; false otherwise.
	 */
	@Override
	public boolean isEmpty() {
		return data.isEmpty();
	}

	/**
	 * Adds an element to a storage
	 * 
	 * @param newItem
	 *            - item to be added
	 */
	@Override
	public void addElement(T newItem) {
		data.addFirst(newItem);
	}

	/**
	 * Removes the object from the storage and returns that object as the value
	 * of this function.
	 * 
	 * @return value of the removed object.
	 */
	@Override
	public T removeElement() {
		return (T) data.removeFirst();
	}

	/**
	 * Returns the number of items in the storage
	 * 
	 * @return the number of items in the storage
	 */
	@Override
	public int size() {
		return data.size();
	}

	/**
	 * Returns the next item to be removed
	 * 
	 * @return element to be removed next
	 * @throws NullPointerException
	 *             if list is empty
	 */
	@Override
	public T peek() throws NullPointerException {
		if (data.getNelems() == 0) {
			throw new NullPointerException();
		}

		return data.getHead().getElement();

	}

}
