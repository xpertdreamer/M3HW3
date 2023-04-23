package binatytree;

public class BinaryTree {
    Node root;
    //constructor
    public BinaryTree() {
        root = null;
    }
    //adding loop (recursive)
    private Node addRecursive(Node current, int data) {
        //if empty cell was found - create new node and put data here
        if (current == null) {
            return new Node(data);
        }
        //if new data less than current - go left, else if - vice versa, else - null value cell was found
        if (data < current.data) {
            current.left = addRecursive(current.left, data);
        } else if (data > current.data) {
            current.right = addRecursive(current.right, data);
        } else {
            return current;
        }
        return current;
    }
    //removing loop (recursive)
    private Node deleteRecursive(Node current, int value) {
        //if value wasnt found - return null
        if (current == null) {
            return null;
        }
        //if value was found - do next
        if (value == current.data) {
            //if left and right branches are both doesnt exist - delete value
            if(current.left == null && current.right == null) {
                return null;
            }
            //if left branch doesnt exist - delete value and move right branch to the left
            if (current.left == null) {
                return current.right;
            }
            //vice verse
            if (current.right == null) {
                return current.left;
            }
            //if value have two branches - find the smallest value on the right, delete value and replace it with the smallest value from right branch
            current.data = findSmallestRecursive(current.right);
            current.right = deleteRecursive(current.right, current.data);
            return current;
        }
        //iterate tree to find a value
        if (value > current.data) {
            current.right = deleteRecursive(current.right, value);
            return current;
        }
        current.left = deleteRecursive(current.left, value);
        return current;
    }
    //function for searching the smallest value for safe deleting
    private int findSmallestRecursive(Node current) {
        if (current.left == null) {
            return current.data;
        } else {
            return findSmallestRecursive(current.right);
        }
    }
    //add value to tree
    public void add(int value) {
        root = addRecursive(root, value);
    }
    //loop for checking of existence of node
    private boolean containsNodeRecursive(Node current, int data) {
        //if node wasnt found - return false
        if (current == null) {
            return false;
        }
        //if node was found - return true
        if (data == current.data) {
            return true;
        }
        //if data < current data - go left and vice versa
        return data < current.data
                ? containsNodeRecursive(current.left, data)
                : containsNodeRecursive(current.right, data);
    }
    //check is value exist or not
    public boolean containsNode(int value) {
        return containsNodeRecursive(root, value);
    }
    //call deleteRecursive function
    public void remove(int value) {
        deleteRecursive(root, value);
    }
}
