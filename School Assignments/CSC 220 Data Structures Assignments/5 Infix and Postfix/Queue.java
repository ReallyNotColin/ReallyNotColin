/** Queue abstract data type */
public class Queue <T> {
  /** List objects to hold our queue items.
      Use List operations to implement the methods below */
  private List <T> list;
  
  // Fields: 
  // The Head (First) node is set to null by default
  private Node <T> head = null;
  // The Tail (Last) node is set to null by default
  private Node <T> tail = null; 
  // Set the Counter of Nodes equal to 0
  private int count = 0;

  // constructor 
  public Queue() {
    // instantiate list here
    list = new List<T>();
  }
  
  // Enqueue Method (adds value to the end of the queue)
  public void enqueue(T value) {
    // wrap value in a node
    Node <T> node = new Node<T>(value);
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
  public T dequeue() {
    // If the queue isn't empty 
    if (isEmpty() == false){
      // Create the field frontValue and set it equal to the value at the head/first node
     T frontValue = head.getData();
     // Set the head/first node equal to the NExT node 
     head = head.next;
     // Decrease the Counter of Nodes by 1 
     count --;
     // Return the new head/first value 
     return frontValue;
    }
    // If the queue is empty 
    else{
      // Return null since it's a reference type?
      return null;
    }
  }

  // front Method (Returns but does not remove the head/first value)
  public T front() {
    // If the queue isn't empty
    if (isEmpty() == false){
      // Create the front variable and set it equal to the head/first node's value
      T front = head.getData();
      // return the head/first node's value
      return front;
    }
    // Otherwise 
    else{
      // Return null since it's a reference type?
      return null;
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

  // reverse Method (reverses the lines of the map)
  public void reverse() {
    // creates an empty stack
    Stack<T> stack = new Stack<T>();

    // while the queue isn't empty 
    while (! isEmpty()){
      // dequeue the first value in the queue into the stack
      stack.push(dequeue());
    }
    
    // while the stack isn't empty 
    while(!stack.isEmpty()){
      // enqueue the top value of the stack back into the queue 
      enqueue(stack.pop());
    }

  }

}
