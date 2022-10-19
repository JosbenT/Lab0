package lab5;

import java.io.PrintStream;


public class ProblemQueue3Wrapper {
	public interface Queue<E> {
		
		public int size();
		
		public boolean isEmpty();
		
		public E front();
		
		public void enqueue(E e);
		
		public E dequeue();
		
		public void makeEmpty();
		
		public void print(PrintStream P);
		

	}

	public static class DoublyLinkedQueue<E> implements Queue<E> {
		
		private static class Node<E>{
			private E element;
			private Node<E> next;
			private Node<E> prev;
			
			public Node() {
				this.element = null;
				this.next = this.prev = null;
				
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
			public Node<E> getPrev() {
				return prev;
			}
			public void setPrev(Node<E> prev) {
				this.prev = prev;
			}
			
		}

		private Node<E> header;
		private Node<E> tail;
		private int currentSize;
		
		public DoublyLinkedQueue() {
			this.currentSize = 0;
			this.header = new Node<>();
			this.tail = new Node<>();
			
			this.header.setNext(this.tail);
			this.tail.setPrev(this.header);
		}
		
		@Override
		public int size() {
			return this.currentSize;
		}

		@Override
		public boolean isEmpty() {
			return this.size() == 0;
		}

		@Override
		public E front() {
			return (this.isEmpty() ? null : this.header.getNext().getElement());
		}

		@Override
		public E dequeue() {
			if (this.isEmpty()) {
				return null;
			}
			else {
				Node<E> target = null;
				target = this.header.getNext();
				E result = target.getElement();
				this.header.setNext(target.getNext());
				target.getNext().setPrev(this.header);
				target.setNext(null);
				target.setPrev(null);
				target.setElement(null);
				this.currentSize--;
				return result;
			}
		}

		@Override
		public void enqueue(E e) {
			Node<E> newNode = new Node<E>();
			newNode.setElement(e);
			newNode.setNext(this.tail);
			newNode.setPrev(this.tail.getPrev());
			this.tail.setPrev(newNode);
			newNode.getPrev().setNext(newNode);
			this.currentSize++;
		}

		@Override
		public void makeEmpty() {
			while (this.dequeue() != null);

		}

		@Override
		public void print(PrintStream P) {
			// TODO Auto-generated method stub
			Node<E> temp = this.header.getNext();
			while(temp != this.tail) {
				P.println(temp.getElement());
				temp = temp.getNext();
			}
		}
	}
	
	/*
	 * Decimal numbers use the digits 0,1,2,3,5,6,7,8,9. We form decimal numbers creating strings 
	 * with these digits. For example: 102, 88, 12. Binary numbers use only 0 and 1. We can
	 * create numbers by creating strings with 0s and 1s.
	 * For example, 1 is expressed as 1, 2 is expressed as 10, 3 is expressed as 11. 
	 * The first 5 integers as 1, 10, 11, 100, 101.
	 * The first 8 integers are expressed as 1, 10, 11, 100, 101, 110, 111, 1000
	 * The first 16 integers are expressed as 1, 10, 11, 100, 101, 110, 111, 1000, 1001, 1010,
	 * 1011, 1100, 1101, 1110, 1111, 10000.
	 * 
	 * Write a non-member method binaryNumberSequence() that produces the sequence of the first N integers.
	 * The method receives as parameter the number N, and returns a Queue<String> with N strings 
	 * representing the first N integers. The elements in the queue come in the sequence order.
	 * 
	 */
	
	public static String toBinary(int n) {
		if( n == 0) { return ""; }
		return toBinary(n/2) + (n % 2);
	}
	
	public static Queue<String> binaryNumberSequence(int N){
		/*ADD YOUR CODE HERE*/
		DoublyLinkedQueue<String> answer = new DoublyLinkedQueue<>();
		
		if(N < 0) { return answer; }
		else {
			for(int i = 1; i <= N ; i++) {
				answer.enqueue(toBinary(i));
			}
		}
		return answer;
	}
}
