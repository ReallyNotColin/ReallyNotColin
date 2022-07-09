/**
 * Name: 
 * Date: 
 * Description:  
 */
// Questions:
//  Do I have to fill out IList? 
//  Could you explain the append and prepend methods in the Main class? Won't characters conflict with integers?

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


/** Array implementation of our List */
class ListAsArray implements IList {
	// initialize array to a size of 30 elements
	// this will prevent the need to resize our array

	// Constructor (Look at parameters)
	// append(method
	// prepend method
	// deleteAt method
	// size method
	// getValueAt method
	// positionOf method
	/** Adds the given value to the end of the list */
	@Override
	public void append(char value){

	}

	/** Adds the given value to the beginning of the list */
	@Override
	public void prepend(char value){

	}
	
	/** Deletes the container at the given position (a container holds a value) */
	@Override
	public void deleteAt(int position){

	}
	
	/** Returns the number of values currently in our list */
	@Override
	public int size(){

	}

	/** Retrieves the value at the given position (0-based) */
	@Override
	public char getValueAt(int position){

	}

	/** Searches for the FIRST occurence of a given value in our list.
		* If found, it returns the position of that value.
		* If not found, it returns -1 */
	@Override
	public int positionOf(char value){

	}
	
}


/** Singly Linked List implementation of our List */
class ListAsLinkedList implements IList {
	//Fields:
	// data
	// next

	// Constructor (Look at parameters)

	// getValueAt method
	// positionOf method

	/** append method */ 
	/** Adds the given value to the end of the list */
	@Override
	public void append(char value){

	}

	/** prepend Method */
	/** Adds the given value to the beginning of the list */
	@Override
	public void prepend(char value){

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

	}

	/** getValueAt Method */
	/** Retrieves the value at the given position (0-based) */
	@Override
	public char getValueAt(int position){

	}

	/** positionOf Method */
	/** Searches for the FIRST occurence of a given value in our list.
		* If found, it returns the position of that value.
		* If not found, it returns -1 */
	public int positionOf(char value){

	}
	
}


/** A singly linked list node for our singly linked list */
class Node {
	// Fields:
	// int data
	// Node next (address)

	// Constructor:
	// this.data = data;
	// next = null;

	// get data method
	// get next (address) method
	// set next (address) method
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
