
// Node Class
class Node{
    // Left child link
    private Node left;
    // Right child link
    private Node right;
    // Data within the node
    private int data; 

    // Constructor
    public Node(int value){
        this.data = value;
    }

    // Accessor/Getter for returning left node
    // returns left link
    public Node getLeft(){
        return left;
    }

    // Accessor/Getter for returning right node 
    // returns right link
    public Node getRight(){
        return right;
    }

    // Accessor/Getter for returning data in a node
    // returns data within a node
    public int getData(){
        return data;
    }

    // Mutator/Setter for changing left link
    public void setLeft(Node newleft){
        this.left = newleft;
    }
    // Mutator/Setter for changing right link
    public void setRight(Node newright){
        this.right = newright;
    }
    // MUtator/Setter for changing data within node
    public void setData(int newdata){
        this.data = newdata;
    }
}

// Binary Search Tree class
public class BST {
    // Root Node
    Node root;

    // Function that, when given a value, inserts the value in 
    // its appropriate place if there is an empty node within the BST
    // using recursion. Displays nodes when inserted
    public void insert(int value){
        // Wrap value in a node
        Node node = new Node(value);

        // If the root is empty
        if(root == null){
            // insert the node!!
            root = node;
        }
        // If the root is NOT empty
        else{
            // Call the traverse helper method
            traverse(root, node);

        }
    } // End of Insert function 
    // Traverse helper function
    private void traverse(Node cur, Node node){
        // If the node's value is LESS than the current node's value
        if(node.getData() < cur.getData()){
            // If the node is null...
            if(cur.getLeft() == null){
                // ... insert the node!!
                cur.setLeft(node);
            }
            // Go left, and if the node is NOT null
            else{
                //... keep going left :(
                traverse(cur.getLeft(), node);
            }
        }
        // If the node's value is GREATER than the  current node's value
        else if(node.getData() > cur.getData()){
            // If the node is null...
            if(cur.getRight() == null){
                ///... insert the node
                cur.setRight(node);
            }
            // Go Right, and if the node is NOT null...
            else{
                //... keep going Right :(
                traverse(cur.getRight(), node);
            }
        }
    }// End of Traverse helper function

    // Function that, when given a value, searches the BST for it iteratively
    // and returns a boolean value
    public boolean search(int value){
        // Create pointer/current/focus node and set it to root
        Node cur = root;
        // Create and initialize boolean value (bv) to false by default
        boolean bv = false;
        // While the node's value doesn't match the inserted value...
        while(cur.getData() != value){
            // Check if the value is less than the current node
            if(value < cur.getData()){
                // if so, go left (until the value is found)
                cur = cur.getLeft();
            }
            // If the value is GREATER than the current node
            else{
                // go right (until the value is found)
                cur = cur.getRight();
            }
            // If the value isn't found, set bv to false and return
            if (cur == null){
                bv = false;
            }
        }
        // IF THE VALUE IS FOUND
        if(cur.getData() == value){
            // Returns true if value is in the tree
            bv = true;
        }
        // return boolean value 
        return bv;
    }

    // takes an int as input, searches it in the tree,
    // and deletes it. If not found, does nothing.
    public void delete(int value){
        // deletes root if the root is by itself
        if (value == root.getData() && root.getLeft() == null && root.getRight() == null){
            root = null;
        }
        if (root == null){
            return;
        }
        else{
            deleteR(root, value);
        }
    }
    // incomplete
    public Node deleteR(Node cur, int value){
        Node parent = root;
       
        while(cur.getData() != value){
            // Check if the value is less than the current node
            if(value < cur.getData()){
                // if so, go left (until the value is found)
                parent = cur;
                cur = cur.getLeft();
            }
            // If the value is GREATER than the current node
            else{
                // go right (until the value is found)
                parent = cur;
                cur = cur.getRight();
            }
            // If the value isn't found, set bv to false and return
            if (cur == null){
                return cur;
            }
        }
        // IF THE VALUE IS FOUND
        if(cur.getData() == value){
            // CASE 0: Node to be deleted has no left or right child (leaf)
            if (cur.getLeft() == null && cur.getRight() == null){
                if (parent.getRight() == cur){
                    parent.setRight(null);
                }
                if (parent.getLeft() == cur){
                    parent.setLeft(null);
                }
            }
            // CASE 1: Node to be deleted has one child 
            if (cur.getLeft() == null && cur.getRight() != null){
                parent.setRight(cur.getRight());
            }
            if (cur.getLeft() != null && cur.getRight() == null){
                parent.setLeft(cur.getLeft());
            }
            // CASE 2: Node to be deleted has two children nodes
            else if (cur.getLeft() != null && cur.getRight() != null){
                Node succ = findMinAgain(cur.getRight());
                int val = succ.getData();

                deleteR(cur, succ.getData());

                val = cur.getData();
            }
        }
        return cur;
    }
    private Node findMinAgain(Node root){
        // If the left child of the node isn't null
        if (root.getLeft() != null){
            // keep going left (moving "root" left)
            return findMinAgain(root.getLeft());
        }
        // Otherwise (parent == null)
        else{
            // Return the value of the node
            return root;
        }
    }// end of findMin()  recursive function
    
    // Uses recursion to return smallest value in the tree
    public int min(){
        // Create integer result
        int result;
        // if root == null, returns -1
        if (root == null){
            result = -1;
        }
        // Otherwise
        else{
            // Call the recursive function
            result = findMin(root);
        }
        // Return result at the end
        return result;
    } // end of min() function
    // Recursive function to find minimum value in BST
    private int findMin(Node root){
        // If the left child of the node isn't null
        if (root.getLeft() != null){
            // keep going left (moving "root" left)
            return findMin(root.getLeft());
        }
        // Otherwise (parent == null)
        else{
            // Return the value of the node
            return root.getData();
        }
    }// end of findMin()  recursive function
    public void setNewMin(int value){
        Node cur = root;
        while (cur.getLeft() != null){
            cur = cur.getLeft();
        }
        cur.setData(value);
    }
    // returns largest value in the tree
    public int max(){
        int result;
        // if root == null, returns -1 
        if (root == null){
            result = -1;
        }
        // Otherwise
        else{
            // Calls the recursive function to find max value in BST
            result = findMax(root);
        }
        // Return the result
        return result;
    }// end of max() function
    // Recursive function to find the max value in BST
    private int findMax(Node root){
        // if the parent's right child isn't null
        if (root.getRight() != null){
            // keep moving the parent to the right
            return findMax(root.getRight());
        }
        // Otherwise (right child == null)
        else{
            // return the value of the node
            return root.getData();
        }
    }// end of findMax recursive function
    public void createNewMax(int value){
        Node node = new Node(value);
        if(root == null){
            return;
        }
        Node cur = root;
        while(cur.getRight() != null){
            cur = cur.getRight();
        }
        if( cur.getRight() == null){
            if (node.getData() < cur.getData()){
                return;
            }
            cur.setRight(node);
        }
        
    }
    
    // L N R 
    // Uses recurstion to traverse the tree and concatonates values as it goes
    public String inorder(){
        String string = "";
        // If the root is NOT null
        if(root != null){
            // Start node at the root
            Node node = root;

            // If the root is the only value
            if (root.getLeft() == null && root.getRight() == null){
                string += node.getData();
            }
            else{
                // if the root's left child isn't null
                if(node.getLeft() != null){
                    // call recursive function to go left and concatonate lesser values
                    string += inorderRecursive(node.getLeft());
                }
                // concatonate the root
                string += node.getData() + " ";
                // if the root's right child isn't null
                if(node.getRight() != null){
                    // call recursive function to go right and concatonate greater values
                    string += inorderRecursive(node.getRight());
                }
            }
        }
        // return the final string
        return string;
    } // end of inorder function
    // Helper recursive function for inorder()
    private String inorderRecursive(Node node){
        // Create the string (empty by default)
        String result = "";
        // if the left child isn't null
        if (node.getLeft() != null){
            // add it to the result
            result += inorderRecursive(node.getLeft());
        }
        // create the result
        result += node.getData() + " ";
        // if the right child isn't null
        if(node.getRight() != null){
            // add it to the result 
            result += inorderRecursive(node.getRight());
        }
        // return the result back to the inorder() function
        return result;
    } // end of inorder recursive

    // N L R 
    // Uses recursion to traverse the tree and concatonates values as it goes
    public String preorder(){
        // Create empty string 
        String string = "";
        // If the root is NOT null 
        if(root != null){
            // Create pointer node, set to root
            Node node = root;

            // If the root is the only value
            if (node.getLeft() == null && node.getRight() == null){
                string += node.getData();
            }
            // Otherwise
            else{
                // concatonate the root
                string += node.getData() + " ";
                // if the roots left child isn't null
                if(node.getLeft() != null){
                    // call recursive function to go left and concatonate
                    string += preorderRecursive(node.getLeft());
                }
                // if the roots right child isn't null
                if(node.getRight() != null){
                    // call recursive function to go right and concatonate
                    string += preorderRecursive(node.getRight());
                }
            }
        }
        // Return the final string
        return string;
    } // end of preorder function
    // Helper recursive function for preorder()
    private String preorderRecursive(Node node){
        // Create empty string
        String result = "";
        // Set the result before the recursive calls
        result +=(node.getData()) + " ";
        if (node.getLeft() != null){
            result += preorderRecursive(node.getLeft());
        }
        if(node.getRight() != null){
            result += preorderRecursive(node.getRight());
        }
        return result;
    }// end of preorder recursive

    // L R N 
    // Uses recursion to traverse the tree and concatonates values as it goes
    public String postorder(){
        String string = "";
        if(root != null){
            Node node = root;
            // If the root is the only value
            if (node.getLeft() == null && node.getRight() == null){
                string += node.getData();
            }
            else{
                // if the roots left child isn't null
                if(node.getLeft() != null){
                    // call recursive function to go left and concatonate
                    string += postorderRecursive(node.getLeft());
                }
                // if the roots right child isn't null
                if(node.getRight() != null){
                    // call recursive function to go right and concatonate
                    string += postorderRecursive(node.getRight());
                }
                // concatonate the root
                string += node.getData() + " ";
            }
        }
        return string;
    } // end of postorder function
    // Helper recursive function for postorder()
    private String postorderRecursive(Node node){
        String result = "";
        result +=(node.getData()) + " ";
        if (node.getLeft() != null){
            result += postorderRecursive(node.getLeft());
        }
        if(node.getRight() != null){
            result += postorderRecursive(node.getRight());
        }
        return result;
    }// end of postorder recursive
    
} // End of BST Class
