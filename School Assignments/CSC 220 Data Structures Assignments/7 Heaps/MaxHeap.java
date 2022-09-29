/******************************************************************************
 * Name: Colin Bumpass, CSC 222
 * Date: November 1, 2021
 * Desc: Program 7: Heaps. The MaxHeap.java and MinHeap.java files use
 *       fundamental heap functions to create their respective heaps out of
 *       arrays. Displays the result in Main.java
 *****************************************************************************/

public class MaxHeap {
    // Declare array of integers
    int[] array;
    // Declare integer index value
    int index;
    // Declare capacity value to go back and forth between personal tests and main
    int capacity;

    // constructor
    public MaxHeap(){
        // Initialize space for 7 items (or more if I want)
        capacity = 7;
        array = new int[capacity];
    }

    // Adds a new key to the heap while maintaining maxheap property
    public void insert(int key){
        // If the index exceeds the array's, stop inserting
        if(index > (capacity-1)){
            return;
        }
        else{
            // Match value at index n to the given value 
            array[index] = key;
                //-----DEBUGGING STATEMENT-----
                Debug.print("Inserting " + key + " at index " + index);
            // Calls maxHeapUp() before index is increased, 
            // as long as the value's parent index is a positive number
            if(parent(index) >= 0){
                maxHeapifyUp(index);
            }
            // increase the overall index by 1;
            index++; 
        }
    }
    // Takes in an index and returns its parent index
    private int parent(int index){
        return Math.floorDiv((index-1), 2);
    }

    // Takes in an index and returns its left child index
    private int leftchild(int index){
        return (2* index + 1);
    }
    
    // Takes in an index and returns its right child's index
    private int rightchild(int index){
        return (2* index + 2);
    }

    // Returns the maximum key in the heap, does not remove key
    public int findMax(){
        // If the array is empty
        if(isEmpty() == true){
            return -1;
        }
        // Otherwise, return the top/root value
        else{
            return array[0];
        }
    }

    // Returns the maximum key in the heap, removes key
    // Calls maxHeapifyDown()
    public int extractMax(){
        // Declare integer max
        int max;
        // If the array is empty, return true 
        if(isEmpty() == true){
            max = -1;
        }
        // Otherwise: Recursion!!! 
        else{
                //-----DEBUGGING STATEMENTS-----
                Debug.print("EXTRACTING: The current index is " + (index-1));
                Debug.print("The value at root is: " + array[0]);
                Debug.print("The value at index " + (index-1) + " is: " + array[(index-1)]);
                Debug.print("SWAP and DELETE root!!");
            // Max value is going to be the latest value
            max = array[(index-1)];
            // Set latest value as the root (value at index 0 )
            array[0] = max;
            // Set value at the latest index to be 0 (where the previous max would've been)
            array[(index-1)] = 0;
            int root = 0;
                //-----DEBUGGING STATEMENTS-----
                Debug.print("The value at root is: " + array[0]);
                Debug.print("The value at index " + (index-1) + " is: " + array[(index-1)]);
            // Swap root  with latest index
            // maxheapify down
            maxHeapifyDown(root);
        }
        // Return max value when done 
        return max;
    }

    // Scans the heap, fixing violations of the max heap property
    // Starts from last inserted VALUE and goes up until not needed
    // Recursion or Iteration
    private void maxHeapifyUp(int index){
        if (array[parent(index)] < array[index] && index > 0){
                //-----DEBUGGING STATEMENT-----
                Debug.print("Comparing " + array[parent(index)] + " and " + array[index]);
            // Trade values: The debugging statements check if they worked
                //-----DEBUGGING STATEMENTS-----
                Debug.print(" Value at index " + parent(index) + ": " + array[parent(index)]);
                Debug.print(" Value at index " + index + ": " + array[index]);
            // Duplicate array[index]'s value
            int element = array[index];
            array[index] = array[parent(index)];
            array[parent(index)] = element;
                //-----DEBUGGING STATEMENTS-----
                Debug.print("SWITCH!!!");
                Debug.print(" Value at index " + parent(index) + ": " + array[parent(index)]);
                Debug.print(" Value at index " + index + ": " + array[index]);
            // RECURSION IF THE PARENT INDEX IS GREATER THAN 0 
            if(parent(index) > 0){
                maxHeapifyUp(parent(index));
            }
        }
    }

    // Scans the heap, fixing violations of the max heap property
    // Starts from root and goes down until not needed
    // Recursion or Iteration
    private void maxHeapifyDown(int root){
        // holds index left of max
        int left = leftchild(root);
        // holds index right of max
        int right = rightchild(root);

            //-----DEBUGGING STATEMENTS-----
            Debug.print("Root value is: " + array[root]);
            Debug.print("Index " + leftchild(root) + ": " + array[left]);
            Debug.print("Index " + rightchild(root) + ": " + array[right]);
        if(array[root] < array[left] || array[root] < array[right] ){
            // If the left is greater than the right 
            if(array[left] > array[right]){
                // swap values
                // copy left child's value
                int duplicate = array[left];
                // Replace left child's value with root's
                array[left] = array[root];
                // Replace root's value with left child's 
                array[root] = duplicate;
                    //-----DEBUGGING STATEMENTS-----
                    Debug.print("Root value is: " + array[root]);
                    Debug.print("Index " + leftchild(root) + ": " + array[left]);
                    Debug.print("Index " + rightchild(root) + ": " + array[right]);
                // Recursion with the children's child nodes as long as they're in bounds of the array
                if(leftchild(leftchild(root)) < (capacity) || rightchild(rightchild(root)) < (capacity) ){
                    maxHeapifyDown(leftchild(root));
                }
            }
            // If the left is less than the right 
            if(array[left] < array[right]){
                // swap values
                // copy left child's value
                int duplicate = array[right];
                // Replace right child's value with root's
                array[right] = array[root];
                // Replace root's value with right child's 
                array[root] = duplicate;
                    //-----DEBUGGING STATEMENTS------
                    Debug.print("Root value is: " + array[root]);
                    Debug.print("Index " + leftchild(root) + ": " + array[left]);
                    Debug.print("Index " + rightchild(root) + ": " + array[right]);
                if(leftchild(rightchild(root)) < (capacity) || rightchild(rightchild(root)) < (capacity) ){
                    maxHeapifyDown(rightchild(root));
                }
            }
        }
        else{
            return;
        }
    } // end of maxHeapifyDown() function

    public boolean isEmpty(){
        // Checks if root value is 0 (which may not work if user inputs 0)
        if(array[0] == 0){
            return true;
        }
        else{
            return false;
        }
    }

    

} // end of MaxHeap class
