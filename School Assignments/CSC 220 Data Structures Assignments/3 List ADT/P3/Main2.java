package P3;
/****************************************************************************************
 * Name: Colin Bumpass, CSC 220 - 003
 * Date: September 28, 2021
 * Description: Program 3.
 ***************************************************************************************/
// Questions:
// how could I count the items in an array and not just its size?
// how to delete?

/** The interface for our List (Abstract Data Type) */
interface IList {
	/** Adds the given value to the end of the list */
	void append(char value);
	
	/** Adds the given value to the beginning of the list */
	void prepend(char value);
	
	/** Deletes the container at the given position (a container holds a value) */
	// array = index?
	// linkedList = node? 
	void deleteAt(int position);
	
	/** Returns the number of values currently in our list */
	// array = index?
	// linkedList = tail?
	int size();

	/** Retrieves the value at the given position (0-based) */
	char getValueAt(int position);

	/** Searches for the FIRST occurence of a given value in our list.
		* If found, it returns the position of that value.
		* If not found, it returns -1 */
	int positionOf(char value);
}


/** Array implementation of our List */
class ListAsArray implements IList {
	// initialize array to a size of 30 elements
	// this will prevent the need to resize our array
	private char[] array;
	private int index;
	
	// Constructor (Look at parameters)
	public ListAsArray(){
		array = new char[30];
		index = 0;
	}
	
	// append(method
	/** Adds the given value to the end of the list */
	@Override
	public void append(char value){
		value = array[index];
		// This returns nothing for some reason
		System.out.println(array[index]);
		index ++;
	}

	// prepend method
	/** Adds the given value to the beginning of the list */
	@Override
	public void prepend(char value){
		value = array[0-1];

	}
	// deleteAt method
	/** Deletes the container at the given position (a container holds a value) */
	@Override
	public void deleteAt(int position){

	}
	// size method
	/** Returns the number of values currently in our list */
	@Override
	public int size(){

		for (int i = 0; i <= array.length - 1; i++){
			// If the value at index i isn't 0 (empty?)...
			if (array[i] != 0){
				//...increase index by 1 
				index ++;
			}
		}
		return index;
	}
	// getValueAt method
	/** Retrieves the value at the given position (0-based) */
	@Override
	public char getValueAt(int position){
		char value = array[position];
		return value;
	}

	/** Searches for the FIRST occurence of a given value in our list.
		* If found, it returns the position of that value.
		* If not found, it returns -1 */
	// positionOf method
	@Override
	public int positionOf(char value){
		
		for (int n = 0; n <= size(); n++){
			if (value == array[n]){
				return array[n];
			}
		}
		return -1;
	}
}


/** Singly Linked List implementation of our List */
class ListAsLinkedList implements IList {
	// Fields:
	// Node head
	public Node head;
	// Node tail
	private Node tail;

	// Constructor (Look at parameters)
	public ListAsLinkedList(){
		head = tail = null;
	}

	/** append method */ 
	/** Adds the given value to the end of the list */
	@Override
	public void append(char value){
		// Creates a new node with the value
		Node node = new Node(value);
		// Set pointer to the next node, which is null by default
		tail.setNext(node);
		tail = node;

	}

	/** prepend Method */
	/** Adds the given value to the beginning of the list */
	@Override
	public void prepend(char value){
		Node node = new Node(value);
		node.setNext(head);
		head = node;

	}

	/** deleteAt method */
	/** Deletes the container at the given position (a container holds a value) */
	@Override
	public void deleteAt(int position){

	}
	
	/** size Method */
	/** Returns the number of values currently in our list */
	@Override
	public int size(){
		// counter 
		int count = 0;
		// walker
		Node cur = head;

		// walker walks the list, counter counts the nodes
		while(cur != null){

			count++;
			cur = cur.getNext();
		}
		return count;
	}

	/** getValueAt Method */
	/** Retrieves the value at the given position (0-based) */
	@Override
	public char getValueAt(int position){

		char a = 1;
		// use the parameter Colin.
		// make it act like an index? or a walker? 
		return a;

	}

	/** positionOf Method */
	/** Searches for the FIRST occurence of a given value in our list.
		* If found, it returns the position of that value.
		* If not found, it returns -1 */
	@Override
	public int positionOf(char value){
		int a = 1;
		// find the index of a character
		return 1;
		
	}
	
}

/** A singly linked list node for our singly linked list */
class Node {
	// Fields:
	// int data?
	private char data;
	// Node next "address"
	private Node next;
	
	// Constructor(look at parameters):
	// this.data = data;
	// next = null;
	public Node(char data){
		this.data = data;
		next = null;
	}
	

	// get data method
	public char getData() { return data;}
	// get next "address" method
	public Node getNext() {return next;}
	// set next "address" method
	public void setNext(Node newNext){this.next = newNext;}
}

class TestArray{
	public static void main(String[]args){
		// Creates IList Array object
		IList array = new ListAsArray();

		// Appends values to the list
		System.out.println("Array Size: " + array.size());
		array.append('0');
		System.out.println("Array Size: " + array.size());
		array.append('2');
		System.out.println("Array Size: " + array.size());
		array.append('3');
		System.out.println("Array Size: " + array.size());

		// Finds value at certain indices
		int position;
		position = array.positionOf('2');
		// returns -1 for any value other than 0. Is it just running once? 
		System.out.println(position);
		
		// returns a blank. Why? 
		System.out.println(array.getValueAt(2));
	}
}


class TestList{
	public static void main(String[] args){
		int[] numbers = {1,2,3};
		IList linkedList = new ListAsLinkedList();

		System.out.println(linkedList.size());
		// try to append a number
		linkedList.append((char)2);

		// try to append numbers array
		for (int num: numbers){
			linkedList.append((char)num);
		}
	}
	
}


/** contains cooler entry point */
class Main{
	public static void main(String[] args){
		int[] numbers = {105,116,112,115,65,58,47,47,116,105,110,121,88,117,114,108,46,99,111,109,47};
		int[] numbers2 = {97,59,111,53,33,111,106,42,50};
		int[] numbers3 = {116,104,32,111,116,32,111,71};
		
		/// List as an Array
		IList array = new ListAsArray();

		
		// add values
		// : = "in" for python
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
//=============================================================================================================
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
	}

}

/** contains our entry point */
public class Main2 {
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
	}
}