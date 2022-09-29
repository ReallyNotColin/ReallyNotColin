/** Queue abstract data type */
public class Queue {
  /** List objects to hold our queue items.
      Use List operations to implement the methods below */
  private List list;
  
  // Fields: 
  // The Head (First) node is set to null by default
  Node head = null;
  // The Tail (Last) node is set to null by default
  Node tail = null; 
  // Set the Counter of Nodes equal to 0
  int count = 0;

  // constructor 
  public Queue() {
    // instantiate list here
    List list = new List();
  }
  
  // Enqueue Method (adds value to the end of the queue)
  public void enqueue(char value) {
    // wrap value in a node
    Node node = new Node(value);
    // If the head/first node is null (empty queue)
    if (head == null){
      // Set the head/first node equal to the new node
      head = node;
    }
    // Otherwise
    else{
      // Set the tail/last node point to the new node
      tail.next = node;
    }
    // set the current tail equal to the new node
    tail = node;
    // Increase the Counter of Nodes by 1 
    count ++;
  }
  
  // Dequeue Method (Removes head/first node from queue)
  public char dequeue() {
    // If the queue isn't empty 
    if (isEmpty() == false){
      // Create the field frontValue and set it equal to the value at the head/first node
     char frontValue = head.getData();
     // Set the head/first node equal to the NExT node 
     head = head.next;
     // Decrease the Counter of Nodes by 1 
     count --;
     // Return the new head/first value 
     return frontValue;
    }
    // If the queue is empty 
    else{
      // Return the ASCII character for " " I guess
      return 32;
    }
  }

  // front Method (Returns but does not remove the head/first value)
  public char front() {
    // If the queue isn't empty
    if (isEmpty() == false){
      // Create the front variable and set it equal to the head/first node's value
      char front = head.getData();
      // return the head/first node's value
      return front;
    }
    // Otherwise 
    else{
      // Return the ASCII character for " " I guess
      return 32;
    }
  }

  // isEmpty method (Returns if the queue is empty or not )
  public boolean isEmpty() {
    // If the Counter of Nodes is equal to 0
    if (count == 0){
      // return true 
      return true;
    }
    // If the Counter of Nodes isn't equal to 0
    else{
      // return false 
      return false;
    }
  }
}
