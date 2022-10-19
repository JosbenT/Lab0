package lab5;

public class Lab07DequeWrapper {
	
	public static interface Deque<E> {
		public void addFirst(E elm);
		public void addLast(E elm);
		public E removeFirst();
		public E removeLast();
		public E getFirst();
		public E getLast();
		public boolean removeFirstOccurrence(E elm);
		public boolean removeLastOccurrence(E elm);
		public int size();
		public boolean isEmpty();
		
		//DO NOT USE THIS IN EXERCISES
		public String[] toArray(); //DO NOT REMOVE, TEST WILL FAIL
	}

	/**
	 * Implementation of Deque ADT using a Circular Doubly-Linked Queue
	 * @author Fernando J. Bermudez & Juan O. Lopez Gerena
	 * @param <E>
	 */
	public static class CircularDoublyLinkedQueque<E> implements Deque<E>{

		private class Node<E>{
			private E element;
			private Node<E> next, prev;

			public Node(E elm, Node<E> next, Node<E> prev) {
				this.element = elm;
				this.next = next;
				this.prev = prev;
			}
			public Node(E elm, Node<E> next) {this(elm, next, null);}

			public Node(E elm) {this(elm, null, null);}

			public Node() {this(null, null, null);}
			
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
			public void clear() {
				next = null;
				prev = null;
				element = null;
			}
		} //End of Node Class
		
		

		private Node<E> header; 
		private int currentSize;

		public CircularDoublyLinkedQueque() {
			header = new Node<>(null, header, header);
			currentSize = 0;
		}

		@Override
		public void addFirst(E elm) {
			if(isEmpty()){
				Node<E> newNode = new Node<E>(elm, this.header, this.header);
				this.header.setNext(newNode);
				this.header.setPrev(newNode);
			}
			else{
				Node<E> curNode = this.header.getNext();
				Node<E> newNode = new Node<E>(elm, curNode, this.header);
				this.header.setNext(newNode);
				curNode.setPrev(newNode);
			}
			currentSize++;
		}

		@Override
		public void addLast(E elm) {
			if(isEmpty()){
				Node<E> newNode = new Node<E>(elm, this.header, this.header);
				this.header.setNext(newNode);
				this.header.setPrev(newNode);
			}
			else{
				Node<E> curNode = this.header.getPrev();
				Node<E> newNode = new Node<E>(elm, this.header, curNode);
				this.header.setPrev(newNode);
				curNode.setNext(newNode);
			}
			currentSize++;
		}

		@Override
		public E removeFirst() {	
			Node<E> curNode = this.header.getNext();
			Node<E> nextNode = curNode.getNext();
			E value = curNode.getElement();
			nextNode.setPrev(this.header);
			this.header.setNext(nextNode);
			curNode.clear();
			curNode = null;
			currentSize--;
			return value;
		}

		@Override
		public E removeLast() {
			Node<E> curNode = this.header.getPrev();
			Node<E> prevNode = curNode.getPrev();
			E value = curNode.getElement();
			prevNode.setNext(this.header);
			this.header.setPrev(prevNode);
			curNode.clear();
			curNode = null;
			currentSize--;
			return value;
		}

		@Override
		public E getFirst() {
			if(isEmpty()){
				return null;
			}
			
			return this.header.getNext().getElement();
		}

		@Override
		public E getLast() {
			if(isEmpty()){
				return null;
			}
			
			return this.header.getPrev().getElement();
		}

		@Override
		public boolean removeFirstOccurrence(E elm) {
			Node<E> prevNode = this.header;
			Node<E> curNode = prevNode.getNext();
			Node<E> nextNode = null;
			
			while(curNode != this.header){
				nextNode = curNode.getNext();
				if(curNode.getElement().equals(elm)){
					prevNode.setNext(nextNode);
					nextNode.setPrev(prevNode);
					curNode.clear();
					curNode = null;
					currentSize--;
					return true;
				}
				prevNode = curNode;
				curNode = nextNode;
			}
			return false;
		}

		@Override
		public boolean removeLastOccurrence(E elm) {
			Node<E> prevNode = this.header;
			Node<E> curNode = prevNode.getPrev();
			Node<E> nextNode = null;
			
			while(curNode != this.header){
				nextNode = curNode.getPrev();
				if(curNode.getElement().equals(elm))
				{
					prevNode.setPrev(nextNode);
					nextNode.setNext(prevNode);
					curNode.clear();
					curNode = null;
					currentSize--;
					return true;
				}
				prevNode = curNode;
				curNode = nextNode;
			}
			return false;
		}

		@Override
		public int size() {
			return currentSize;
		}

		@Override
		public boolean isEmpty() {
			return size() == 0;
		}

		//DO NOT USE THIS IN EXERCISES
		//DO NOT DELETE, TESTS WILL FAILS
		@Override
		public String[] toArray() {
			String[] arr = new String[size()];

			Node<E> curNode = header.getNext();
			for (int i = 0; curNode != header; curNode = curNode.getNext(), i++) {
				arr[i] = (String) curNode.getElement();
			}
			return arr;
		}
	}
}
