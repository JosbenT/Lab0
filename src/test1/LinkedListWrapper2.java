package test1;

import java.util.Iterator;
import java.util.NoSuchElementException;


public class LinkedListWrapper2 {
	public static interface List<E> extends Iterable<E> {

		public int size();

		public boolean isEmpty();

		public boolean isMember(E e);

		public int firstIndexOf(E e);

		public int lastIndexOf(E e);

		public void add(E e);

		public void add(E e, int index);

		public E get(int index);

		public E remove(int index);

		public boolean remove(E e);

		public int removeAll(E e);

		public E replace(int index, E newElement);

		public void clear();

		public Object[] toArray();	

		public List<E> findDuplicates();

	}

	public static class SinglyLinkedList<E> implements List<E> {

		@SuppressWarnings("hiding")
		private class SinglyLinkedListIterator<E> implements Iterator<E>{
			private Node<E> nextNode;



			@SuppressWarnings("unchecked")
			public SinglyLinkedListIterator() {
				this.nextNode = (Node<E>) header.getNext();
			}
			@Override
			public boolean hasNext() {
				return nextNode != null;
			}

			@Override
			public E next() {
				if (this.hasNext()) {
					E result = this.nextNode.getElement();
					this.nextNode = this.nextNode.getNext();
					return result;
				}
				else {
					throw new NoSuchElementException();
				}
			}

		}

		private static class Node<E> {
			private E element;
			private Node<E> next;

			public Node(E element, Node<E> next) {
				super();
				this.element = element;
				this.next = next;
			}
			public Node() {
				super();
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

		private Node<E> header;
		private int currentSize;

		public SinglyLinkedList() {
			this.header = new Node<>();
			this.currentSize = 0;
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
		public boolean isMember(E e) {
			return this.firstIndexOf(e) >= 0;
		}

		@Override
		public int firstIndexOf(E e) {
			int i = 0;
			for (Node<E> temp = this.header.getNext(); temp != null; 
					temp = temp.getNext(), ++i) {
				if (temp.getElement().equals(e)) {
					return i;
				}
			}
			// not found
			return -1;
		}

		@Override
		public void add(E e) {
			if (this.isEmpty()) {
				this.header.setNext(new Node<E>(e, null));
				this.currentSize++;
			}
			else {
				Node<E>temp= this.header.getNext();
				while (temp.getNext() != null) {
					temp = temp.getNext();
				}
				Node<E> newNode = new Node<>(e, null);
				temp.setNext(newNode);
				this.currentSize++;
			}

		}

		@Override
		public void add(E e, int index) {
			if ((index < 0) || (index > this.currentSize)) {
				throw new IndexOutOfBoundsException();
			}
			if (index == this.currentSize) {
				this.add(e);
			}
			else {
				Node<E> temp = null;
				if (index == 0) {
					temp = this.header;
				}
				else {
					temp = this.getPosition(index -1);
				}
				Node<E> newNode = new Node<>();
				newNode.setElement(e);
				newNode.setNext(temp.getNext());			
				temp.setNext(newNode);
				this.currentSize++;
			}
		}

		@Override
		public E get(int position) {
			if ((position < 0) || position >= this.currentSize) {
				throw new IndexOutOfBoundsException();
			}

			Node<E> temp  = this.getPosition(position);
			return temp.getElement();

		}

		private Node<E> getPosition(int index){
			int currentPosition=0;
			Node<E> temp = this.header.getNext();

			while(currentPosition != index) {
				temp = temp.getNext();
				currentPosition++;
			}
			return temp;

		}

		@Override
		public E remove(int index) {
			if ((index < 0) || (index >= this.currentSize)){
				throw new IndexOutOfBoundsException();
			}
			else {
				Node<E> temp = this.header;
				int currentPosition =0;
				Node<E> target = null;

				while (currentPosition != index) {
					temp = temp.getNext();
					currentPosition++;
				}
				E result = null;
				target = temp.getNext();
				result = target.getElement();
				temp.setNext(target.getNext());
				target.setElement(null);
				target.setNext(null);
				this.currentSize--;
				return result;

			}
		}

		@Override
		public E replace(int position, E newElement) {
			if ((position < 0) || position >= this.currentSize) {
				throw new IndexOutOfBoundsException();
			}
			Node<E> temp  = this.getPosition(position);
			E result = temp.getElement();
			temp.setElement(newElement);
			return result;

		}

		@Override
		public void clear() {
			while(!this.isEmpty()) {
				this.remove(0);
			}
		}

		@Override
		public Object[] toArray() {
			Object[] result = new Object[this.size()];
			for (int i=0; i < this.size(); ++i) {
				result[i] = this.get(i);
			}
			return result;
		}


		@Override
		public Iterator<E> iterator() {
			return new SinglyLinkedListIterator<E>();
		}


		@Override
		public int lastIndexOf(E e) {
			int i = 0, result = -1;
			for (Node<E> temp = this.header.getNext(); temp != null; 
					temp = temp.getNext(), ++i) {
				if (temp.getElement().equals(e)) {
					result = i;
				}
			}
			// not found
			return result;
		}


		@Override
		public boolean remove(E e) {
			int i = this.firstIndexOf(e);
			if (i < 0) {
				return false;
			}else {
				this.remove(i);
				return true;
			}
		}


		@Override
		public int removeAll(E e) {
			int count = 0;
			while (this.remove(e)) {
				count++;
			}
			return count;
		}


		@Override
		public List<E> findDuplicates() {
			// ADD YOUR CODE HERE

			Node<E> current = this.header, index = null, temp = null;  
			SinglyLinkedList<E> output = new SinglyLinkedList<>(); 

			if(this.header == null) {  
				return new SinglyLinkedList<>();  
			}  
			else {  
				while(current != null){  
					//Node temp will point to previous node to index.  
					temp = current;  
					//Index will point to node next to current  
					index = current.next;  

					while(index != null) {  
						//If current node's data is equal to index node's data  
						if(current.getElement() == index.getElement()) {  
							//Here, index node is pointing to the node which is duplicate of current node  
							//Skips the duplicate node by pointing to next node  
							output.add(current.getElement());
							temp.next = index.next;  
						}  
						else {  
							//Temp will point to previous node of index.  
							temp = index;  
						}  
						index = index.next;  
					}  
					current = current.next; 
				}
				return output;
			}
		}

		public static void main(String[] args) {
			SinglyLinkedList<String> tester = new SinglyLinkedList<>();
			tester.add("Ken");
			tester.add("Ron");
			tester.add("Joe");
			tester.add("Amy");
			tester.add("Xi");

			List<String> test = new SinglyLinkedList<>();

			test = tester.findDuplicates();
		}
	}
}

