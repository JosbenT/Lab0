package lab6;
import java.util.Comparator;

public class Lab05P1Wrapper {

	public static interface List<E> {
		/* Interface methods are public by default */
		public void add(E e);
		public void add(int index, E e) throws IndexOutOfBoundsException;
		public boolean remove(int index);
		public E get(int index) throws IndexOutOfBoundsException;
		public E set(int index, E e) throws IndexOutOfBoundsException;
		public int size();
		public boolean isEmpty();
		public E[] toArray();
		public int removeAll(E e);
		public E first();
		public E last();
		public int firstIndex(E e);
		public int lastIndex(E e);
		public boolean contains(E e);
		public void clear();

	}

	public static class RecursiveLinkedList<E> implements List<E> {

		private Node<E> head; // References first data node
		private int currentSize;

		@SuppressWarnings("unused")
		private static class Node<E> {
			private E value;
			private Node<E> next;

			public Node(E value, Node<E> next) {
				this.value = value;
				this.next = next;
			}

			public Node(E value) {
				this(value, null); // Delegate to other constructor
			}

			public Node() {
				this(null, null); // Delegate to other constructor
			}

			public E getValue() {
				return value;
			}

			public void setValue(E value) {
				this.value = value;
			}

			public Node<E> getNext() {
				return next;
			}

			public void setNext(Node<E> next) {
				this.next = next;
			}

			public void clear() {
				value = null;
				next = null;
			}				
		} // End of Node class

		public RecursiveLinkedList() {
			head = null;
			currentSize = 0;
		}

		@Override
		public int size() {
			return currentSize;
		}

		@Override
		public boolean isEmpty() {
			return size() == 0;
		}

		/*TODO (Part 2) IMPLEMENT THE MISSING INTERFACE METHODS HERE*/

		@Override
		public int removeAll(E e) {
			// TODO ADD YOUR CODE HERE

			return 0;
		}

		@Override
		public E first() {
			// TODO ADD YOUR CODE HERE
			return get(0);
		}

		@Override
		public E last() {
			// TODO ADD YOUR CODE HERE
			return get(currentSize - 1);
		}

		@Override
		public int firstIndex(E e) {
			// TODO ADD YOUR CODE HERE
			return recFIndex(head, e, currentSize);
		}
		public int recFIndex(Node<E> f, E e, int i) {
			if(i == 0) {
				return -1; 
			}
			else if(f.getValue().equals(e)) {
				return i;
			}
			return recFIndex(f.getNext(), e, ++i);
		}

		@Override
		public int lastIndex(E e) {
			// TODO ADD YOUR CODE HERE
			return recLIndex(head, e, currentSize, currentSize);
		}
		public int recLIndex(Node<E> f, E e, int i, int last) {
			if(f.getValue().equals(e)) { last = i; }
			if(f.getNext() == null) { return last; }
			
			return recLIndex(f.getNext(), e, ++i, last);

		}

		@Override
		public boolean contains(E e) {
			// TODO ADD YOUR CODE HERE
			/*THIS IS THE ITERATION METHOD*/
			//			Node<E> temp = this.head;
			//			while(temp.getNext() != null) {
			//				if(temp.getValue().equals(e)) { return true; }
			//				temp = temp.getNext();
			//			}
			//			return false;
			if(this.head.getNext() == null) { return false; }

			else if(this.head.getNext().getValue().equals(e)) { return true; }

			else {
				this.head = this.head.getNext();
				return this.contains(e);
			}

		}

		@Override
		public void clear() {
			// TODO ADD YOUR CODE HERE
			//			while (size() > 0)
			//				remove(0);
			if(size() <= 0) { return; }
			this.remove(0);
			this.clear();
		}

		/*TODO (Part 2) IMPLEMENT THE MISSING INTERFACE METHODS HERE*/

		/*DO NOT MODIFY ANY OF THESE METHODS*/
		@Override
		public E get(int index) throws IndexOutOfBoundsException {
			if (index < 0 || index >= size()) 
				throw new IndexOutOfBoundsException(
						"RecursiveLinkedList.get: invalid index = " + index); 
			// index is valid
			return recGet(head, index); 
		}

		@Override
		public void add(E e) {
			add(size(), e); // Add at the end of the list
		}

		@Override
		public void add(int index, E e) throws IndexOutOfBoundsException {
			if (index < 0 || index > size()) 
				throw new IndexOutOfBoundsException(
						"RecursiveLinkedList.add: invalid index = " + index); 
			// index is valid for the add operation
			head = recAdd(head, index, e); 
			currentSize++;
		}

		@Override
		public boolean remove(int index) {
			/*TODO (Part 4) ADD YOUR CODE HERE*/
			if (index < 0 || index >= size()) 
				throw new IndexOutOfBoundsException("RecursiveLinkedList.set: invalid index = " + index); 
			head = recRemove(head, index);
			currentSize--;
			return true;
		}

		@Override
		public E set(int index, E e) throws IndexOutOfBoundsException {
			if (index < 0 || index >= size()) 
				throw new IndexOutOfBoundsException(
						"RecursiveLinkedList.set: invalid index = " + index); 

			// index is valid for set operation
			return recSet(head, index, e);  
		}

		/*******************************/
		/* Auxiliary recursive methods */
		/*******************************/

		/**
		 * Returns the value in the node corresponding to the index value i in
		 * the linked list whose first node is being referenced by f. On any such
		 * list the first node is the one associated to index 0, the second node
		 * is the one associated with index 1, and so on. It presumes that the
		 * list whose first node is f has at least i+1 nodes. 
		 * 
		 * @param f		First node of linked list to traverse
		 * @param i		Index value of node whose value should be returned
		 * @return		Value within node at index i
		 */
		private static <E> E recGet(Node<E> f, int i) {
			if (i == 0)
				return f.getValue(); 
			else 
				return recGet(f.getNext(), i-1); 
		} 

		/**
		 * (Part 1)
		 * TODO ADD YOUR DESCRIPTION HERE  
		 * Returns the value in the node corresponding to the index value i in 
		 * the linked list whose first node is referenced by f, not unlike in the 
		 * recGet method. The difference would be that at the same time it removes
		 * said value from the linked list. 
		 * 
		 * @param f		First node of linked list to traverse
		 * @param i		Index value of node whose value should be returned
		 * @return		Node to be removed
		 */
		@SuppressWarnings("unused")
		private static <E> Node<E> recRemove(Node<E> f, int i) {
			if(i == 0) {
				
				Node<E> temp = f;
				f = f.getNext();
				temp.clear();
				
			} else  f.setNext(recRemove(f.getNext(), --i));
			
			return f;
		}

		/**
		 * Inserts a new node in the linked list whose first node is being
		 * referenced by f so that the new node contains the data element e and it
		 * ends up occupying the position with index value i. Finally, it returns
		 * the reference to the first node of the list that results after the
		 * insertion is completed. It presumes that the list whose first node is
		 * f has at least i nodes.
		 * 
		 * @param f		First node of linked list where node must be inserted
		 * @param i		Index value of where new node must be inserted
		 * @param e		Value or element that must be contained within the new node
		 */

		private static <E> Node<E> recAdd(Node<E> f, int i, E e) { 
			if(i == 0) {
				Node<E> newNode = new Node<E>(e,f);
				return newNode;
			} else {
				f.setNext(recAdd(f.getNext(), --i, e));
			}
			return f;
		}


		/**
		 * (Part 1)
		 * TODO ADD YOUR DESCRIPTION HERE
		 * Sets a desired element into the target node whose first node is being
		 * referenced by f so that the new node contains the data element e and it
		 * ends up occupying the position with index value i.
		 *   
		 * 
		 * @param f		First node of linked list where value must be inserted
		 * @param i		Index value of where new node must be set
		 * @return		Value or element that must be set within the new node
		 */
		private static <E> E recSet(Node<E> f, int index, E e) { 
			/* TODO (Part 5) ADD YOUR CODE HERE*/
			try {
				if(index == 0) {
					f.setValue(e);
				} else {
					recSet(f.getNext(), --index, e);
				}
				return e;
				
			} catch (Exception e1) {
				throw new IndexOutOfBoundsException();
				}	
		}

		@SuppressWarnings("unchecked")
		@Override
		public E[] toArray() {
			E[] theArray = (E[]) new Object[size()];
			int i = 0;
			for (Node<E> curNode = head; curNode != null; curNode = curNode.getNext())
				theArray[i++] = curNode.getValue();
			return theArray;
		}

	}
	public static void main(String[] args) {
		listTester("Testing the List ADT based on recursive singly linked list (SLRIndexList): ",
				new RecursiveLinkedList<Integer>());
	}

	private static void listTester(String msg, List<Integer>  list) {
		System.out.println(msg);

		try {
			list.add(1, 400); // Test adding with invalid index
		}
		catch (Exception e) {
			System.out.println(e);
		}
		
		/*Uncomment once you have implemented recAdd()*/
		list.add(100);    // Test adding without position
		list.add(0, 1);   // Test adding at the beginning
		list.add(2, 200); // Test adding at the end
		list.add(300);    // Test adding without position again

		for (int i=20, j=1; i< 50; i+=5, j++)
			list.add(j, i);
		
		
		
		showList(list); //recGet() is already implemented


		/*Uncomment once you have implemented remove()*/
		showListAfterDeleting(list, 4);
		showListAfterDeleting(list, 0);   // Test deleting at beginning
		showListAfterDeleting(list, 30);  // Test deleting at invalid index
		showListAfterDeleting(list, 7);   // Test deleting at end
		
		
		/*Uncommment once you have implemented recAdd()
		showListAfterAdding(list, 3, 700);
		showListAfterAdding(list, 0, 700);
		showListAfterAdding(list, 1, 800);
		showListAfterAdding(list, 2, 900);
		showListAfterAdding(list, 2, 1000);
		showListAfterAdding(list, 7, 1001);
		showListAfterAdding(list, 13, 1002);
		showListAfterAdding(list, 3, 1002);
		*/


		/*Uncomment once you have implemented recSet()
		showListAfterReplacingElement(list, 0,  1800);
		showListAfterReplacingElement(list, 2,  999);
		showListAfterReplacingElement(list, 2,  2222);
		showListAfterReplacingElement(list, 1,  1511);
		showListAfterReplacingElement(list, list.size()-1, 404);
		*/
		
	}


	private static void showElement(List<Integer> list, int position) {
		try {
			System.out.println(" --Element in position "
					+ position + " is: "+ list.get(position));
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
	
	private static void showSize(List<Integer> list) {
		System.out.println("\nSize of the list is: "+list.size());
	}
	private static void showList(List<Integer> list) {
		System.out.println("\n*** The " + list.size() + " elements in the list are: ");
		int lpindex = list.size();
		for (int i=0; i < lpindex; i++)
		    showElement(list,i);
	}

	private static void showListAfterDeleting(List<Integer> list, int pos) {
		System.out.println("\n -- deleting element at position " + pos);
		try {
			Integer etr = list.get(pos);
			if (list.remove(pos)) {
				System.out.println(" -- value of deleted element was " + etr);
				showList(list);
			}
			else
				System.out.println("ERROR: Was not able to delete element at position " + pos);
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}

	private static void showListAfterAdding(List<Integer> list, int pos, Integer element) {
		System.out.println("\n -- adding value " + element + " at position " + pos);
		try {
			list.add(pos, element);
			showList(list);
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}

	private static void showListAfterReplacingElement(List<Integer> list, int pos, Integer element) {
		System.out.println("\n -- replacing value at position " + pos + " by " + element);
		try {
			Integer etr = list.set(pos, element);
			System.out.println(" -- value of replaced element was "+ etr);
			showList(list);
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
}