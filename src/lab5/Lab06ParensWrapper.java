package lab5;

import java.util.EmptyStackException;
import java.util.Scanner;

public class Lab06ParensWrapper {

	public static interface Stack<E> {
		
		public int size();
		public boolean isEmpty();
		public void clear();
		public void push(E e);
		public E pop();
		public E top(); //A.K.A. peek()

	}

	
	public static class LinkedStack<E> implements Stack<E>{
		
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
		
		private int currentSize;
		private Node<E> header;
		
		public LinkedStack() {
			this.currentSize =0;
			this.header = new Node<>();
		}

		@Override
		public int size() {
			return currentSize;
		}

		@Override
		public boolean isEmpty() {
			return size() == 0;
		}

		@Override
		public void clear() {
			while(!isEmpty()) pop();
		}


		/**  
		 * Note: For operations to be O(1), 
		 * header will always point to the top of the stack
		 * 
		 * Example:
		 * header -> Jim -> Bob -> Ned -> Jil -> Kim -> null
		 * 
		 * Example:
		 * newNode = Jim
		 * header -> Jim -> null
		 * 
		 * Bob <- Top of stack
		 * Ned
		 * Jil
		 * Kim 
		 */
		@Override
		public void push(E e) {
			//Equivalent to SLL.add(e, 0)
			Node<E> newNode;
			if(isEmpty())
				newNode = new Node<>(e);
			else
				newNode = new Node<>(e, header.getNext());
			
			header.setNext(newNode);
			currentSize++;
		}

		@Override
		public E pop() {
			//Equivalent to SLL.remove(0)
			if(isEmpty())
				throw new EmptyStackException();
				
			Node<E> curNode = header;
			Node<E> rmNode = curNode.getNext();
			E value = rmNode.getElement();
			
			curNode.setNext(rmNode.getNext());
			rmNode.clear();
			rmNode = null;
			currentSize--;
			
			return value;
		}

		@Override
		public E top() {
			//Equivalent to SLL.get(0)
			if(isEmpty()) 
				throw new EmptyStackException();
			return header.getNext().getElement();
		}

	}
    
    /**
     * You can implement any auxiliary function, as well as declare any static 
     * fields inside this wrapper class to help you out.
     * For ease of use declare the static fields here, above this method
     */
	public static void fullyParens() {
		/**************************
		 * TODO ADD YOUR CODE HERE*
		 **************************/
	}

    /**********************************
     * ADD YOUR AUXILIARY METHODS HERE*
     **********************************/
}
						