/*****************************************************************************
 * Name: Colin Bumpass, CSC 220 - 003
 * Date: October 4, 2021
 * Description: Program 3; This program features an Abstract Data Type 
 * IList and two classes (ListAsArray and ListAsLinkedList) that replicate the 
 * IList's functions' operations. 
 ****************************************************************************/

/** The interface for our List (Abstract Data Type) */
interface IList {
	/** Adds the given value to the end of the list */
	void append(char value);
	
	/** Adds the given value to the beginning of the list */
	void prepend(char value);
	
	/** Deletes the container at the given position (a container holds a value) */
	void deleteAt(int position);
	
	/** Returns the number of values currently in our list */
	int size();

	/** Retrieves the value at the given position (0-based) */
	char getValueAt(int position);

	/** Searches for the FIRST occurence of a given value in our list.
		* If found, it returns the position of that value.
		* If not found, it returns -1 */
	int positionOf(char value);

}
/** */
/** Array implementation of our List */
class ListAsArray implements IList {
	/* initialize array to a size of 30 elements */
	/** this will prevent the need to resize our array */
	private char[] data = new char[30];
	private int endpoint = 0;

	/** Adds the given value to the end of the list */
	@Override
	public void append(char value){
		data[endpoint] = value;
		/** move the endpoint over one*/
		endpoint++;
	}

	/** Adds the given value to the beginning of the list */
	@Override
	public void prepend(char value){
		/** i is set equal to endpoint's value */
		/** While i >= 1 (would be 0 but its exclusive), i decreases by one and... */
		for (int i = endpoint; i >= 1 ;i--){
			/** the value at index "i" of the data array is */
			/** moved up ONE index */
			data[i] = data[i - 1]; 	
		}
		/**index 0 houses the new value */
		data[0] = value;
		/** the endpoint is moved over by one so it can  */
		/** make room for the new, prepended value at index 0 */
		endpoint ++;
		
	}
	
	/** Deletes the container at the given position (a container holds a value) */
	@Override
	public void deleteAt(int position){
		/** if the desired position is >= 0 and less than the size of the array */
		if (position >= 0 && position < size()){
			/** value is set to the position to the right*/
				for(int i = position; i < (size()-1 ); i++){
					data[i] = data[i + 1];
				}
				/** array size/endpoint is decreased to make up for the deleted value */
				endpoint --;
		}
	}

	/** Returns the number of values currently in our list */
	@Override
	public int size(){
		/** Simply return the endpoint */
		return endpoint;
		}
		

	/** Retrieves the value at the given position (0-based) */
	@Override
	public char getValueAt(int position){
		/** As long as the position is within the array's size...*/
		if (position >=0 && position < size()){
			/** return the value at the desired index*/
			return data[position]; 
		}
		/** Otherwise*/
		else{
			/** return nothing (32 = ASCII for " ")*/
			return 32;
		}
	}

	/** Searches for the FIRST occurence of a given value in our list.
		* If found, it returns the position of that value.
		* If not found, it returns -1 */
	@Override
	public int positionOf(char value){
		/** Increase the value i until it matches the desired value*/
	
		for(int i = 0; i < size() ; i++){
			/** when it does, return whatever i is */
			if (data[i] == value){
				return i;
			}
		}
		/** If i reaches the array's size and the value isn't found return -1 */
		return -1;
	}
}


/** Singly Linked List implementation of our List */
class ListAsLinkedList implements IList {
	/** Use a node for the head (beginning of the list) */
	public Node head;
	/** Use a node for the tail (end of the list) */
	private Node tail;

	/** append method */ 
	/** Adds the given value to the end of the list */
	@Override
	public void append(char value){
		/** Wrap value into a node!  */
		Node node = new Node(value);

		/** if there are 0 nodes in the list: */
		if (size() == 0){
			head = node;
			tail = node;
		}
		
		/**  if there is 1 or more nodes in the list: */
		/** if the list length is 1, makes the tail = node. */
		/** if the list size is greater than 1, makes the tail = node.  */
		else{
			tail.setNext(node);
			tail = node;
		}
	}

	/** prepend Method */
	/** Adds the given value to the beginning of the list */
	@Override
	public void prepend(char value){
		/** Wrap the value in a node */
		Node node = new Node(value);
		/** set the link to the next node equal to the current head */
		node.setNext(head);
		/** change the current head to the new node */
		head = node;
	}

	/** deleteAt method */
	/** Deletes the container at the given position (a container holds a value) */
	@Override
	public void deleteAt(int position){
		/** Check if linked list is empty*/
		if (head == null){
			return;
		}
		/** store head node with temp*/
		Node temp = head;

		/** Check if the position == head*/
		if (position == 0){
			/** Move the head to the next node */
			head = temp.next;
			return;
		}
		/** Find the node before the position and set the node equal to the next node*/
		for (int i = 0; temp != null && i < (position -1); i++){
			temp = temp.next;
		}
		/** Check if the position is not inside the array's size*/
		if (temp == null || temp.next == null){
			return;
		}
		/** Point to the node to be deleted*/
		Node next = temp.next.next;
		temp.next = next;
	}
	
	/** size Method */
	/** Returns the number of values currently in our list */
	@Override
	public int size(){
		/** counter of nodes */
		int count = 0;
		/** Keeps track of current node */
		Node cur = head;
		/** While the node isn't equal to null (tail) */
		while(cur != null){
			/** Increase the counter of nodes by 1 */
			count++;
			/** Get the link to the next node  */
			cur = cur.getNext();
		}
		/** return the value of the counter of nodes */
		return count;
	}

	/** getValueAt Method */
	/** Retrieves the value at the given position (0-based) */
	@Override
	public char getValueAt(int position){
		/**counter of nodes (will return node 1,2,3,4,5,6...) */
		int count = 0;
		/** keeps track of current node, sets it to head by default */
		Node cur = head;
		/** keeps track of the current node's value, which is the head by default */
		char curv = cur.getData();

		/** While the counter of nodes doesn't equal the desired position...*/
		while (count!= position){
			/** Get the link to the next node */
			cur = cur.getNext();
			/** Increase the counter of nodes by one */
			count ++;
		}

		/** If the counter of nodes DOES equal the desired position... */
		if (count == position){
			/** Return the value at the desired position/node */
			curv = cur.getData();
		}

		/** Return the result  */
		return curv;
	}

	/** positionOf Method */
	/** Searches for the FIRST occurence of a given value in our list.
		* If found, it returns the position of that value.
		* If not found, it returns -1 */
	@Override
	public int positionOf(char value){
		/** counter of nodes (will return node 1,2,3,4,5,6...) */
		int count = 0;
		/** keeps track of current node, sets it to head by default  */
		Node cur = head;
		/** keeps track of the current node's value, which is the head by default */
		char curv = cur.getData();

		/**  While the current node's value doesn't equal the desired value... */
		while(curv != value){
			/** get the link to the next node */
			cur = cur.getNext();
			/** if the next node isn't null, get that node's value */
			if (cur != null){
				curv = cur.getData();
				count ++;
			}
			/** if the next node is equal to null (past tail), just return -1, 
			as the end of the list has been reached, and the value has not 
			been found. */
			if (cur == null){
				return -1;
			}
		}

		/**  If the current node's value MATCHES the desired value, return the count (the position/"index") */
		if (curv == value){
			return count;
		}
		/**  Otherwise... return -1
		 Not sure if this is contradictory, but getting rid of it makes
		 the IDE mad at me.  */
		
		else{
			return -1;
		}	
	}
}

/** A singly linked list node for our singly linked list */
class Node {
	/**  the value within a node  */
	private char data;
	/**  the link to the next node*/
	public Node next;

	/** Constructor:  */
	public Node(char data){
		/** data is whatever value the node holds  */
		this.data = data;
		/** next is set to null by default unless it changes */
		next = null;
	}

	/**  funtion to return the value of node  */
	public char getData() {return data;}
	/** function to return the link to the next node */
	public Node getNext() {return next;}
	/**function that changes the link to the next node from null */
	public void setNext(Node newNext) {this.next = newNext;}
}

/** contains our entry point */
public class Main {
	/** entry point - DO NOT CHANGE the pre-existing code below */
	public static void main(String[] args) {
		int[] numbers = {105,116,112,115,65,58,47,47,116,105,110,121,88,117,114,108,46,99,111,109,47};
		int[] numbers2 = {97,59,111,53,33,111,106,42,50};
		int[] numbers3 = {116,104,32,111,116,32,111,71};
		
		
		/// List as an Array
		IList array = new ListAsArray();
		
		// add values
		for(int num : numbers) {
			array.append((char)num);
		}
		for(int num : numbers3) {
			array.prepend((char)num);
		}
		
		// delete some values
		int position;
		
		position = array.positionOf((char)105);
		array.deleteAt(position);
		
		position = array.positionOf((char)65);
		array.deleteAt(position);
		
		position = array.positionOf((char)88);
		array.deleteAt(position);
	 
		// print em
		position = 0;
		while (position < array.size()) {
			System.out.print(array.getValueAt(position));
			position++;
		}
		
		/// List as a Linked List
		IList linkedList = new ListAsLinkedList();
		
		// add values
		for(int num : numbers2) {
			linkedList.append((char)num);
		}
		linkedList.prepend((char)55);
		linkedList.prepend((char)121);

		// delete some values
		position = linkedList.positionOf((char)59);
		linkedList.deleteAt(position);
		
		position = linkedList.positionOf((char)33);
		linkedList.deleteAt(position);
		
		position = linkedList.positionOf((char)42);
		linkedList.deleteAt(position);
		
		// print em
		position = 0;
		while (position < linkedList.size()) {
			System.out.print(linkedList.getValueAt(position));
			position++;
		}
		
		System.out.println();
		
		// ???
		System.out.println(175 % 10);
	}
}
