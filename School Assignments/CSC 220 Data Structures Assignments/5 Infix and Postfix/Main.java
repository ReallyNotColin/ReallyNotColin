/*******************************************************************************
 * Name: Colin Bumpass, CSC 220 - 003
 * Date: October 18, 2021
 * Desc: Program 5: Using the classes from Program 4, this program asks the user
 *       to input an infix expression and then displays the postfix form of the 
 *       espression as well as the evaluation of the expression. 
 ******************************************************************************/

// grab the scanner library
import java.util.Scanner;

// This file contains the LinkedList class from Program 3

/** Linked List implementation of our List abstract data type */
class List <T> {
    // put all fields from ListAsLinkedList class here
      /** Use a node for the head (beginning of the list) */
  public Node <T> head;
  /** Use a node for the tail (end of the list) */
  private Node <T> tail;
  
  // Totally legititmate and original constructor that was here for the entirety of program 3
  public List() {
    // By default, head and tail are equal to null
    head = tail = null;
  }
  
  // put all methods from ListAsLinkedList class here
  /** append method */ 
  /** Adds the given value to the end of the list */
  public void append(T value){
    /** Wrap value into a node!  */
    Node <T> node = new Node<T> (value);
  
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
  public void prepend(T value){
    /** Wrap the value in a node */
    Node <T> node = new Node <T> (value);
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
    Node <T> temp = head;
  
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
    Node <T> next = temp.next.next;
    temp.next = next;
  }
  
  /** size Method */
  /** Returns the number of values currently in our list */
  public int size(){
    /** counter of nodes */
    int count = 0;
    /** Keeps track of current node */
    Node <T> cur = head;
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
  public T getValueAt(int position){
    /**counter of nodes (will return node 1,2,3,4,5,6...) */
    int count = 0;
    /** keeps track of current node, sets it to head by default */
    Node <T> cur = head;
    /** keeps track of the current node's value, which is the head by default */
    T curv = cur.getData();
  
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
  public int positionOf(T value){
    /** counter of nodes (will return node 1,2,3,4,5,6...) */
    int count = 0;
    /** keeps track of current node, sets it to head by default  */
    Node <T> cur = head;
    /** keeps track of the current node's value, which is the head by default */
    T curv = cur.getData();
  
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
class Node <T> {
// put all fields from Node class here
/**  the value within a node  */
private T data;
/**  the link to the next node*/
public Node <T> next;

/** Constructor:  */
public Node(T value){
    /** data is whatever value the node holds  */
    this.data = value;
    /** next is set to null by default unless it changes */
    next = null;
}

    
// put all methods from Node class here
/**  funtion to return the value of node  */
public T getData() {return data;}
/** function to return the link to the next node */
public Node <T> getNext() {return next;}
/**function that changes the link to the next node from null */
public void setNext(Node <T> newNext) {this.next = newNext;}
}
  
/** Queue abstract data type */
class Queue <T> {
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

/** Stack generic data type */
class Stack <T> {
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


// Main entry point 
public class Main{
    public static void main(String args[]){
        // prompt the user for an infix expression
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter infix expression: ");
        String infixString = scan.nextLine();
        scan.close();
        // Display text
        System.out.println("Summary");
        System.out.println("-------");
        // Display the user's infix expression
        System.out.println("  Infix: " + infixString);
        // Send the user's infix expression to infixToPostfix function
        System.out.println("Postfix: " + infixToPostfix(infixString));
        // Send the user's postfix expression to evalPostfix function
        System.out.println(" Result: " + evalPostfix(infixToPostfix(infixString)));
    }

    // Function that associates a specific operator with a value for the Infix Priority
    public static int getInfixPriority(char c){
      if (c == '('){
        return 4;
      }      
      if (c == '^'){
        return 3;
      }
      if (c == '*' || c == '/'){
        return 2;
      }
      if (c == '+' || c == '-'){
        return 1;
      }
      else{
        return 0;
      }
    }
    // Function that associates a specific operator with a value for the Stack priority
    public static int getStackPriority(char c){
      if (c == '^' || c == '*' || c == '/'){
        return 2;
      }
      if (c == '+' || c == '-'){
        return 1;
      }
      else{
        return 0;
      }
    }
    // Function that checks if the character is a digit between 0 and 9 
    public static boolean isOperand(char c){
      if (c == '0'|| c == '1' || c == '2' || c == '3'||c == '4'||c == '5'||c == '6'
      ||c == '7'||c == '8'||c == '9'){
        return true;
      }
      else{
        return false;
      }
    }
    // Function that identifies the operator and applies it to both a and b appropriately
    public static int eval(char operator, int a, int b){
      // If operator is a + sign, add two characters
      if (operator == '+'){
        return a + b;
      }
      // If the operator is a - sign, subtract two characters
      if (operator == '-'){
        return a - b;
      }
      // If the operator is a * sign, multiply two characters
      if (operator == '*'){
        return a*b;
      }
      // If the operator is a / sign, divide two characters
      if (operator == '/'){
        return a/b;
      }
      // If the operator is a ^, exponentiate (?) two characters
      if (operator == '^'){
        return (int)(Math.pow(a, b));
      }
      // Otherwise, return error number (which I think is -1)
      else{
        return -1;
      }
    }

    // Function that takes inin an expression in infix form (user input) and produces the 
    // equivalent expression in postfix form.
    // returns a string 
    public static String infixToPostfix(String infixString){
      // Create empty stacks
      Queue<Character> postfixQueue = new Queue<Character>();
      Stack<Character> operatorStack = new Stack<Character>();

      // enqueue each character from the user's string into infixQueue
      Queue<Character> infixQueue = new Queue<Character>();
      for (int i = 0; i < infixString.length();i++){
        infixQueue.enqueue(infixString.charAt(i));
        //----DEBUGGING STATEMENT----
        /*System.out.println("Characters being added to infixQueue: " 
        + infixString.charAt(i)); */
      }

      // Process the infixQueue
      while(infixQueue.isEmpty() != true){
       // dequeue a token
       char token = infixQueue.dequeue();

      // Process operands (digits)
      // If the token is a number, place it in the postfix queue
      if (isOperand(token) == true){
        postfixQueue.enqueue(token);
        //----DEBUGGING STATEMENT----
        //System.out.println("Line 519: Tokens being enqueued into postfixQueue: " + token);
      }
      // If the token is a right parenthesis
      else if (token == ')'){
        char operator = operatorStack.pop();
        // while operator is NOT a left parenthesis
        while (operator != '('){
          postfixQueue.enqueue(operator); // does this happen in the demo???
          operator = operatorStack.pop();
        }
      }
      // Process operators (other than right parenthesis)
      else{
        // handle operators already on the operatorStack
        if (operatorStack.isEmpty() != true){
          // returns operator on top of operatorStack
          char operator = operatorStack.peek();

          // move operators with HIGH priority into the postfixQueue
          while(getStackPriority(operator) >= getInfixPriority(token)){
            operator = operatorStack.pop();
            postfixQueue.enqueue(operator);
           
            
            // are there more operators on the operatorStack?
            if (operatorStack.isEmpty() != true){
              //if so, grab it
              operator = operatorStack.peek();
            }
            // otherwise, exit
            else{
              break;
            }

          }
        }
        // Add (assumingly the) operator to the Stack
        operatorStack.push(token);
        //----DEBUGGING STATEMENT----
        //System.out.println("Line 558: Tokens being added to operatorStack: " + token);
      }

      }// end of infixQueue processing
     

      // unload the operator stack onto our postfixQueue
      while(operatorStack.isEmpty() != true){
        // Remove operator from operatorStack and enqueue into postfix
        char operator = operatorStack.pop();
        postfixQueue.enqueue(operator);
        //----DEBUGGING STATEMENT----
        //System.out.println("Line 570: From operatorStack to postfixQueue: " + operator);
      }

      String postfix = "";
      // dequeue each value in postfixQueue into the string postfix
      while (postfixQueue.isEmpty() != true){
        postfix += Character.toString(postfixQueue.dequeue());
        // DEBUGGING STATEMENT
        //System.out.println("Line 578: From postfixQueue to postfix: " + postfix);
      }
      // Return postfix form!!
      return postfix;
      
    } // end of infixToPostfix function
    public static int evalPostfix(Queue<Character> postfixqueue){
      // create (empty) eval stack
      Stack<Integer> evalStack = new Stack<Integer>();
       // create the final result (set equal to nothing for now) 
      int finalResult;
      Queue<Character> queue =postfixqueue;
      if(queue == null){
        System.out.println("no expression");
        finalResult= -1;
      }
      if(queue.isEmpty() == true){
        System.out.println("empty expression");
        finalResult= -2;
      }
      if(queue != postfixqueue){
        System.out.println("empty expression");
        finalResult= -2;
      }
      else{
        //process the postfixQueue
        // While the postfixQueue isn't empty...
        while(queue.isEmpty() != true){
          //...A token is made from whatever is dequeued
          char token = queue.dequeue();

          // if the token is a digit, throw it on the evalStack
          if(isOperand(token)==true){
            evalStack.push(Character.getNumericValue(token));
            //----DEBUGGING STATEMENT-----
            System.out.println("Added to evalStack: " + token);
          }
          // if token is an operator, pop the values from the stack and 
          // apply them AND the token into the eval function to ge the answer. 
          else{
            // a is going to be the (ASCII equivalent of) the top stored value
            int a = evalStack.pop();
            //----DEBUGGING STATEMENT-----
            System.out.println("Integer a: " + a);
            // b is going to be the (ASCII equivalent of) the next stored value
            int b = evalStack.pop();
            //----DEBUGGING STATEMENT----
            System.out.println("Integer b: " + b);
            // answer is going to be the evaluation of the operator, a, and b
            int answer = eval(token,b,a);
              //----DEBUGGING STATEMENT----
              System.out.println("The evaulated Answer: " + answer);
            
            // push the answer from the eval stack (which holds characters),
            //
             evalStack.push(answer);
            }
          }
          // if our evalStack is not empty after processing everything, then return the final
          // answer stored at the top
          if(evalStack.isEmpty() != true){
            finalResult = evalStack.pop();
            return finalResult;
      }

      // otherwise report an error value (I think -1 will work)
      else{
        return -1;
      }
        }
        return finalResult;  
    } // END OF CLASS
    // Function that evaulates the postfix form and returns and integer
    public static int evalPostfix(String postfixString){
      // enqueue each character from postfixString into postfixQueue
      Queue<Character> postfixQueue = new Queue<Character>();
      for(int i = 0; i < postfixString.length(); i++){
        postfixQueue.enqueue(postfixString.charAt(i));
        //----DEBUGGING STATEMENT-----
        //System.out.println("Chars being enqueued: " + postfixString.charAt(i));
      }
      // create (empty) eval stack
      Stack<Integer> evalStack = new Stack<Integer>();
      // create the final result (set equal to nothing for now) 
      int finalResult;

      //process the postfixQueue
      // While the postfixQueue isn't empty...
      while(postfixQueue.isEmpty() != true){
        //...A token is made from whatever is dequeued
        char token = postfixQueue.dequeue();

        // if the token is a digit, throw it on the evalStack
        if(isOperand(token)==true){
          evalStack.push(Character.getNumericValue(token));
          //----DEBUGGING STATEMENT-----
          System.out.println("Added to evalStack: " + token);
        }

        // if token is an operator, pop the values from the stack and 
        // apply them AND the token into the eval function to ge the answer. 
        else{
          // a is going to be the (ASCII equivalent of) the top stored value
          int a = evalStack.pop();
          //----DEBUGGING STATEMENT-----
          System.out.println("Integer a: " + a);
          // b is going to be the (ASCII equivalent of) the next stored value
          int b = evalStack.pop();
          //----DEBUGGING STATEMENT----
          System.out.println("Integer b: " + b);
          // answer is going to be the evaluation of the operator, a, and b
          int answer = eval(token,b,a);
           //----DEBUGGING STATEMENT----
           System.out.println("The evaulated Answer: " + answer);
          // push the answer from the eval stack (which holds characters),
          // so cast answer as a character?? Works for subtraction but nothing else
          evalStack.push(answer);
        }
      }

      // if our evalStack is not empty after processing everything, then return the final
      // answer stored at the top
      if(evalStack.isEmpty() != true){
        finalResult = evalStack.pop();
        return finalResult;
      }

      // otherwise report an error value (I think -1 will work)
      else{
        return -1;
      }
    }

    
}// end of Main class