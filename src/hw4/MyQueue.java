/* 
 * NAME: Anita Yen
 * PID: A13457606
 * LOGIN: cs12wanf
 */
package hw4;

/**
 * A class that utilizes a queue and implements the Stack_QueueInterface<T>
 * 
 * @version 1.0
 * @author Anita Yen
 * @since 2017-01-31
 */
public class MyQueue<T> implements Stack_QueueInterface<T> {
	private int size;
	private int front;
	private int rear;
	private int default_size = 5;
	private T[] array;

	/**
	 * Constructor that initializes size, front, rear, and array
	 */
	public MyQueue() {
		size = 0;
		front = 0;
		rear = 0;
		array = (T[]) new Object[default_size];
	}

	/**
	 * Tests if the storage is empty.
	 * 
	 * @return true a storage contains no items; false otherwise.
	 */
	@Override
	public boolean isEmpty() {
		if (size == 0) {
			return true;
		}
		return false;
	}

	/**
	 * Adds an element to a storage
	 * 
	 * @param newItem
	 *            - item to be added
	 */
	@Override
	public void addElement(T newItem) {

		if (size == array.length) {
			T[] newArray = (T[]) new Object[size * 2];

			for (int i = 0; i < size; i++) {
				newArray[i] = array[front];
				front = (front + 1) % array.length;
			}

			front = 0;
			rear = size;
			array = newArray;

		}

		array[rear] = newItem;
		rear = (rear + 1) % array.length;
		size++;

	}

	/**
	 * Removes the object from the storage and returns that object as the value
	 * of this function.
	 * 
	 * @return value of the removed object.
	 */
	@Override
	public T removeElement() {
		if (isEmpty()) {
			throw new NullPointerException();
		}

		T data = array[front];
		array[front] = null;

		front = (front + 1) % array.length;

		size--;
		return data;
	}

	/**
	 * Returns the number of items in the storage
	 * 
	 * @return the number of items in the storage
	 */
	@Override
	public int size() {
		return size;
	}

	/**
	 * Returns the next item to be removed
	 * 
	 * @return element to be removed next
	 * @throws NullPointerException
	 *             if list is empty
	 */
	@Override
	public T peek() {
		if (front == rear) {
			throw new NullPointerException();
		}

		return array[front];
	}

	/**
	 * Gets the number of elements in the array
	 * 
	 * @return number of elements in array
	 */
	public int getSize() {
		return size;
	}

	/**
	 * Returns the front of the array
	 * 
	 * @return front of array
	 */
	public int getFront() {
		return front;
	}

	/**
	 * Gets the rear of the array
	 * 
	 * @return rear of array
	 */
	public int getRear() {
		return rear;
	}

}
