/** Stack abstract data type */
public class Stack <T> {
  /** List objects to hold our stack items.
      Use List operations to implement the methods below */
  private List <T> list;
  // Head Node is set to null by default
  Node <T> head = null;
  // Tail Node is set to null by default
  Node <T> tail = null;
  // Counter of Nodes is set to null by default
  int count = 0;

  // constructor
  public Stack() {
    // instantiate list here
    list = new List<T>();
  }

  // Push Method (adds value to top of stack)
  public void push(T value) {
    //Wrap value in a node
    Node <T> node = new Node <T> (value);
    // If stack is empty
    if (head == null){
      // set the tail (bottom node) equal to the node
      tail = node;
    }
    // Otherwise
    else{
      // Move the head to the next Node
      node.next = head;
    }
    // set the current head equal to the node
    head = node;
    // Increase the counter of nodes by one
    count ++;
  }

  // Pop method (removes top (head) node)
  public T pop() {
    // If the stack isn't empty
    if (isEmpty() == false){
      // Create topValue and set it equal to the data at the top node
      T topValue = head.getData();
      // set the top node equal to the "next node" (nothing);
      head = head.next;
      // decrease the Counter of Nodes by one
      count --;
      // return the top value 
      return topValue;
    }
    // If the list is empty
    else{
      // return null since its now a reference type? 
      return null;
    }
  }

  // Peek() method (returns but doesn't remove the top node's value)
  public T peek() {
    // If the stack isn't empty
    if (isEmpty() == false){
      // return the head/top node's value
      return head.getData();
    }
    // If the stack is empty 
    else{
      // return null since it's a reference type? 
      return null;
    }

  }

  // isEmpty() Method (checks if stack is empty)
  public boolean isEmpty() {
    // If the Counter of Nodes is equal to 0
    if (count == 0){
      // return true
      return true;
    }
    // Otherwise (Counter of Nodes != 0)
    else{
      // return false
      return false;
    }
  }
}
