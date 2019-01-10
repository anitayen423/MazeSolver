/* 
 * NAME: Anita Yen
 * PID: A13457606
 * LOGIN: cs12wanf
 */
package hw4;

/**
 * An interface that implements functions of a Queue and Stack
 * 
 * @version 1.0
 * @author Anita Yen
 * @since 2017-01-31
 */
interface Stack_QueueInterface<T> {

	/**
	 * Tests if the storage is empty.
	 * 
	 * @return true a storage contains no items; false otherwise.
	 */
	public boolean isEmpty();

	/**
	 * Adds an element to a storage
	 * 
	 * @param newItem
	 *            - item to be added
	 */
	public void addElement(T newItem);

	/**
	 * Removes the object from the storage and returns that object as the value
	 * of this function.
	 * 
	 * @return value of the removed object.
	 */
	public T removeElement();

	/**
	 * Returns the number of items in the storage
	 * 
	 * @return the number of items in the storage
	 */
	public int size();

	/**
	 * Returns the next item to be removed
	 * 
	 * @return element to be removed next
	 * @throws NullPointerException
	 *             if list is empty
	 */
	public T peek();

}
