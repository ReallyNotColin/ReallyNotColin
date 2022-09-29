public class MinHeap{
    // Declare array of integers
    int[] array;
    // Declare integer index value
    int index;
    // Declare capacity value to go back and forth between personal tests and main
    int capacity;

    // Default constructor (i.e. no parameters)
    public MinHeap(){
        // Initialize space for 7 items (or more if I want)
        capacity = 7;
        array = new int[capacity];
    }

    // Adds a new key to the heap while maintaining minheap property
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
            // Calls minHeapUp() before index is increased, 
            // as long as the value's parent index is a positive number
            if(parent(index) >= 0){
                minHeapifyUp(index);
                //-----DEBUGGING STATEMENT-----
                Debug.print("The minHeapifyUp function has been entered");
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

    // Returns the minimum key in the heap but does not remove
    public int findMin(){
        if(isEmpty() == true){
            return -1;
        }
        // Otherwise, return the top/root value
        else{
            return array[0];
        }
    }

    // Returns the minimum key in the heap, removes it
    // Maintains minheap by calling appropriate minHeapify version
    public int extractMin(){
        // Declare integer max
        int min;
        // If the array is empty, return true 
        if(isEmpty() == true){
            min = -1;
        }
        // Otherwise: Recursion!!! 
        else{
                //-----DEBUGGING STATEMENTS-----
                Debug.print("EXTRACTING: The current index is " + (index-1));
                Debug.print("The value at root is: " + array[0]);
                Debug.print("The value at index " + (index-1) + " is: " + array[(index-1)]);
                Debug.print("Switch!!");
            // Min value is going to be the latest value
            min = array[(index-1)];
            // Set latest value as the root (value at index 0 )
            array[0] = min;
            // Set value at the latest index to be 0 (where the previous min would've been)
            array[(index-1)] = 0;
            int root = 0;
                //-----DEBUGGING STATEMENTS-----
                Debug.print("The value at root is: " + array[0]);
                Debug.print("The value at index " + (index-1) + " is: " + array[(index-1)]);
            // Swap root  with latest index
            // minheapify down
            minHeapifyDown(root);
        }
        // Return max value when done 
        return min;
    }

    // Scans the heap, fixing violations of the minheap property
    // Starts from last inserted value and goes up, stops when minheap prop is satisfied
    // Iteration or Recursion here
    private void minHeapifyUp(int index){
        // If the parent value is greater 
        if (array[parent(index)] > array[index] && index > 0){
                //-----DEBUGGING STATEMENT-----
                Debug.print("Comparing " + array[parent(index)] + " and " + array[index]);
            // Trade values: The debugging statements check if they worked
                //-----DEBUGGING STATEMENTS-----
                Debug.print(" Value at index " + parent(index) + ": " + array[parent(index)]);
                Debug.print(" Value at index " + index + ": " + array[index]);
            // Duplicate array[index]'s value
            int element = array[index];
            // Set it equal to the above parent value
            array[index] = array[parent(index)];
            // Change the parent value with the duplicate
            array[parent(index)] = element;
                //-----DEBUGGING STATEMENTS-----
                Debug.print("SWITCH!!!");
                Debug.print(" Value at index " + parent(index) + ": " + array[parent(index)]);
                Debug.print(" Value at index " + index + ": " + array[index]);
            // STOP RECURSION IF THE PARENT INDEX IS GREATER THAN 0 
            if(parent(index) > 0){
                minHeapifyUp(parent(index));
            }
        }
    }

    // Scans the heap, fixing violations of the minheap property
    // Starts from root and goes down, stops when minheap prop is satisfied
    // Iteration or Recursion here
    private void minHeapifyDown(int root){
        // holds index left of min
        int left = leftchild(root);
        // holds index right of min
        int right = rightchild(root);
            //-----DEBUGGING STATEMENTS-----
            Debug.print("Root value is: " + array[root]);
            Debug.print("Index " + leftchild(root) + ": " + array[left]);
            Debug.print("Index " + rightchild(root) + ": " + array[right]);
        if(array[root] > array[left] || array[root] > array[right] ){
            // If left is lesser
            if(array[left] < array[right]){
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
                if(leftchild(leftchild(root)) < (capacity-1) || rightchild(rightchild(root)) < (capacity-1) ){
                    minHeapifyDown(leftchild(root));
                }
                
            }
            // If right is Greater 
            if(array[left] > array[right]){
                // swap values
                // copy left child's value
                int duplicate = array[right];
                // Replace right child's value with root's
                array[right] = array[root];
                // Replace root's value with right child's 
                array[root] = duplicate;
                    //-----DEBUGGING STATEMENTS-----
                    Debug.print("Root value is: " + array[root]);
                    Debug.print("Index " + leftchild(root) + ": " + array[left]);
                    Debug.print("Index " + rightchild(root) + ": " + array[right]);
                // Recursion with the children's child nodes as long as they're in bounds of the array
                if(leftchild(rightchild(root)) < (capacity-1) || rightchild(rightchild(root)) < (capacity-1) ){
                    minHeapifyDown(rightchild(root));
                }
            }
        }
        else{
            return;
        }
    } // end of minHeapifyDown() function

    // Returns true if heap has no keys, false otherwise
    public boolean isEmpty(){
        // Checks if root value is 0 (which may not work if user inputs 0)
        if(array[0] == 0){
            return true;
        }
        else{
            return false;
        }
    }
}