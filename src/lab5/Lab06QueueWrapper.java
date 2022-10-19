package lab5;

import java.util.NoSuchElementException;

public class Lab06QueueWrapper {
	
	@SuppressWarnings("serial")
	public static class EmptyQueueException extends RuntimeException {
		public EmptyQueueException(String message) {
			super(message);
		}

	}
	
	public static interface Queue<E> {

		public int size();
		public boolean isEmpty();
		public void clear();
		public void enqueue(E e);
		public E dequeue();
		public E front();
		
	}

	public static class SinglyLinkedQueue<E> implements Queue<E>{
		
		
		
		@SuppressWarnings("hiding")
		private class Node<E> {
			
			private E element;
			private Node<E> next;
			
			public Node(E elm, Node<E> next) {
				this.element = elm;
				this.next = next;
				
			}
			

			public Node(E elm) {
				this(elm, null);
			}
			

			public Node() {
				this(null, null);
			}
			
			public void clear() {
				this.element = null;
				this.next = null;
			}
			
			public E getElement() {
				return element;
			}

			public void setElement(E element) {
				this.element = element;
			}

			public Node<E> getNext() {
				return next;
			}

			public void setNext(Node<E> next) {
				this.next = next;
			}
			

		}
		
		private Node<E> head, tail;
		private int currentSize;
		
		public SinglyLinkedQueue() {
			head = tail = null;
			currentSize = 0; 
		}

		@Override
		public int size() {
			return this.currentSize; //Dummy Return
		}

		@Override
		public boolean isEmpty() {
			return size() == 0; //Dummy Return
		}

		@Override
		public void clear() {
			
			while(size() != 0) {
				this.dequeue();
			}
		}

		@Override
		public void enqueue(E e) {
			if(e == null)
				throw new EmptyQueueException("invalid element");
			
			Node<E> newNode = new Node<E>(e);
			
			if(size() == 0) {
				tail = head = newNode;
				currentSize++;
			}
			
			else {
				tail.setNext(newNode);
				tail = newNode;
				currentSize++;
			}
		}

		@Override
		public E dequeue() {
			if(size() == 0) {
				throw new EmptyQueueException("the queue is empty");
			}			
			
			Node<E> nodeToErase = head;
			head = head.getNext();
			E temp = nodeToErase.getElement();
			nodeToErase = null;
			currentSize--;
			return temp; //Dummy Return
		}

		@Override
		public E front() {
			if(size() == 0) {
				throw new EmptyQueueException("the queue is empty");
			}
			return head.getElement(); //Dummy Return
		}

	}


}