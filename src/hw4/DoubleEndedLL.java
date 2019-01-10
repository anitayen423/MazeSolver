/* 
 * NAME: Anita Yen
 * PID: A13457606
 * LOGIN: cs12wanf
 */
package hw4;

import java.awt.List;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * A class that implements DoubleEndedLLInterface
 * 
 * @version 1.0
 * @author Anita Yen
 * @since 2017-01-31
 */
public class DoubleEndedLL<T> implements DoubleEndedLLInterface<T> {
	private int nelems;
	private Node head;
	private Node tail;

	public static void main(String[] args) {
		LinkedList<Double> list = new LinkedList<Double>();

	}

	/**
	 * Checks if the list is empty
	 * 
	 * @return returns true if the list is empty, false otherwise
	 */
	@Override
	public boolean isEmpty() {
		return nelems == 0;
	}

	/**
	 * Checks the size of the list
	 * 
	 * @return returns the number of elements in the list
	 */
	@Override
	public int size() {
		return nelems;
	}

	/**
	 * Adds a new node to the front of the list
	 * 
	 * @param newItem
	 *            - an element to add
	 */
	@Override
	public void addFirst(T newItem) {
		if (newItem == null) {
			throw new NullPointerException();
		}

		Node temp = new Node(newItem);

		if (isEmpty()) {
			tail = head;
			head = temp;

		} else {

			temp.next = head;
			head = temp;
		}

		nelems++;
	}

	/**
	 * Adds a new node to the end of the list
	 * 
	 * @param newItem
	 *            - an element to add
	 */
	@Override
	public void addLast(T newItem) {
		if (newItem == null) {
			throw new NullPointerException();
		}

		Node temp = new Node(newItem);

		if (isEmpty()) {
			head = tail;
			tail = temp;
		} else {
			tail.next = temp;
			tail = temp;
		}

		nelems++;

	}

	/**
	 * Removes a node from the beginning of the list
	 * 
	 * @return element the data found
	 * @throws NullPointerException
	 *             if the list is empty
	 */
	@Override
	public T removeFirst() {
		T o = head.data;

		if (head == tail) {
			head = null;
			tail = null;
		} else {
			head = head.next;
		}

		nelems--;
		return o;
	}

	/**
	 * Removes a node from the end of the list
	 * 
	 * @return element the data found
	 * @throws NullPointerException
	 *             if the list is empty
	 */
	@Override
	public T removeLast() {
		if (nelems == 1) {
			head = null;
			tail = null;
		}

		Node data = head;
		Node prev = head;

		while (data.next != null) {
			prev = data;
			data = data.next;
		}

		if (!(head == tail)) {
			tail = prev;
			tail.next = null;
		} else {
			head = null;
			tail = null;
		}

		T o = data.getElement();

		return o;
	}

	/**
	 * Returns the head of the linked list
	 * 
	 * @return the head node
	 */
	public Node getHead() {
		return head;
	}

	/**
	 * Sets the head node to the node passed into the method
	 * 
	 * @param head
	 *            is the node to be set to the head node
	 */
	public void setHead(Node head) {
		this.head = head;
	}

	/**
	 * Returns the number of elements in the linked list
	 * 
	 * @return number of elements in linked list
	 */
	public int getNelems() {
		return nelems;
	}

	/**
	 * Returns the tail of the linked list
	 * 
	 * @return tail of linked list
	 */
	public Node getTail() {
		return tail;
	}

	/**
	 * Inner class that implements the data in a node
	 * 
	 * @version 1.0
	 * @author Anita Yen
	 * @since 2017-01-31
	 *
	 */
	protected class Node {

		T data;
		Node next;

		/**
		 * Constructor to create singleton Node
		 * 
		 * @param element
		 *            Element to add
		 * */
		public Node(T element) {
			this.data = element;
		}

		/**
		 * Constructor to create singleton link it between previous and next
		 * 
		 * @param element
		 *            Element to add, can be null
		 * @param prevNode
		 *            predecessor Node, can be null
		 * @param nextNode
		 *            successor Node, can be null
		 */
		public Node(T element, Node nextNode) {
			this.data = element;
			this.next = nextNode;
		}

		/**
		 * Set the next node in the list
		 * 
		 * @param n
		 *            new next node
		 */
		public void setNext(Node n) {
			this.next = n;
		}

		/**
		 * Set the element
		 * 
		 * @param e
		 *            new element
		 */
		public void setElement(T e) {
			this.data = e;
		}

		/**
		 * Accessor to get the next Node in the list
		 * 
		 * @return next node
		 */
		public Node getNext() {
			return next;
		}

		/**
		 * Accessor to get the Nodes Element
		 * 
		 * @return data of node
		 */
		public T getElement() {
			return data;
		}
	}

}
