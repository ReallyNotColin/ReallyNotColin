// This file contains the LinkedList class from Program 3



/** Linked List implementation of our List abstract data type */
public class List {
  // put all fields from ListAsLinkedList class here
    /** Use a node for the head (beginning of the list) */
public Node head;
/** Use a node for the tail (end of the list) */
private Node tail;

// Totally legititmate and original constructor that was here for the entirety of program 3
public List() {
  // By default, head and tail are equal to null
  head = tail = null;
}

// put all methods from ListAsLinkedList class here
/** append method */ 
/** Adds the given value to the end of the list */
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

/** A linked list node for our linked list */
class Node {
  // put all fields from Node class here
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
  
    
  // put all methods from Node class here
  /**  funtion to return the value of node  */
  public char getData() {return data;}
  /** function to return the link to the next node */
  public Node getNext() {return next;}
  /**function that changes the link to the next node from null */
  public void setNext(Node newNext) {this.next = newNext;}
}

