import java.io.BufferedReader;
import java.io.IOException;

/**
 * Class for a binary tree that stores type E objects.
 **/
public class BinaryTree<E>{

    /** Class to encapsulate a tree node. */
    protected static class Node<E>{
        // Data Fields

        /** The information stored in this node. */
        public E data;
        /** Reference to the left child. */
        public Node<E> left;
        /** Reference to the right child. */
        public Node<E> right;

        // Constructors  ------------------------------------------------------ Missing code 1
        /**
         * Construct a node with given data and no children.
         * @param data The data to store in this node
         */
        public Node(E data) {
        	this.data = data;
        	left = null;
        	right = null;
		
        }


		// Methods
        /**
         * Returns a string representation of the node.
         * @return A string representation of the data fields
         */
        @Override
        public String toString() {
            return data.toString();
        }
    }
    /*</listing>*/
    // Data Field
    /** The root of the binary tree */
    protected Node<E> root;
    
    /** Construct an empty BinaryTree */
    public BinaryTree() {
        root = null;
    }

    /**
     * Construct a BinaryTree with a specified root.
     * Should only be used by subclasses.
     * @param root The node that is the root of the tree.
     */
    protected BinaryTree(Node<E> root) {
        this.root = root;
    }

    /**
     * Constructs a new binary tree with data in its root,leftTree ------------------------------------------------------ Missing code 2
     * as its left subtree and rightTree as its right subtree.
     */
   
	public BinaryTree(E data, BinaryTree<E> leftTree, BinaryTree<E> rightTree) {
    
    	this.root = new Node<E>(data);

		
    	if (leftTree != null) { 
        	root.left = leftTree.root;

    	}
    	
    	if (rightTree != null) {
        	root.right = rightTree.root;

    	}
    	
	
	
	
	
	
	
    }
	
	
		
	

    /**
     * Return the left subtree. ------------------------------------------------------ Missing code 3
     * @return The left subtree or null if either the root or
     * the left subtree is null
     */
    public BinaryTree<E> getLeftSubtree() {

	if (this.root.left == null || this.root == null) {
		return null;
	}
	else {
		BinaryTree<E> leftSubTree = new BinaryTree<E>(root.left);
		
		return leftSubTree;
	}
    }

    /**
     * Return the right sub-tree ------------------------------------------------------ Missing code 4
     * @return the right sub-tree or
     *         null if either the root or the
     *         right subtree is null.
     */
    public BinaryTree<E> getRightSubtree() {
    	
    	if (this.root.right == null || this.root == null) {
    		return null;
    	}
    	else {
    		BinaryTree<E> rightSubTree = new BinaryTree<E>(root.right);
    		
    		return rightSubTree;
    	}
	
	
	
    }

    /**
     * Return the data field of the root
     * @return the data field of the root
     *         or null if the root is null
     */
    public E getData() {
        if (root != null) {
            return root.data;
        } else {
            return null;
        }
    }

    /**
     * Determine whether this tree is a leaf. ------------------------------------------------------ Missing code 5
     * @return true if the root has no children
     */
    public boolean isLeaf() {
        
    	if (this.root.left == null && this.root.right == null) {
    		return true;
    	}
    	else {
    		return false;
    	}
    	
    }
    

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        preOrderTraverse(root, 1, sb);
        return sb.toString();
    }

    /**
     * Perform a preorder traversal.
     * @param node The local root
     * @param depth The depth
     * @param sb The string buffer to save the output
     */
    private void preOrderTraverse(Node<E> node, int depth,
            StringBuilder sb) {
        for (int i = 1; i < depth; i++) {
            sb.append("  ");
        }
        if (node == null) {
            sb.append("null\n");
        } else {
            sb.append(node.toString());
            sb.append("\n");
            preOrderTraverse(node.left, depth + 1, sb);
            preOrderTraverse(node.right, depth + 1, sb);
        }
    }

    
    /**
     * Method to read a binary tree.
     * @pre The input consists of a preorder traversal
     *      of the binary tree. The line "null" indicates a null tree.
     * @param bR The input file
     * @return The binary tree
     * @throws IOException If there is an input error
     */
    public static BinaryTree<String> readBinaryTree(BufferedReader bR)
            throws IOException {
        // Read a line and trim leading and trailing spaces.
        String data = bR.readLine().trim();
        if (data.equals("null")) {
            return null;
        } else {
            BinaryTree<String> leftTree = readBinaryTree(bR);
            BinaryTree<String> rightTree = readBinaryTree(bR);
            return new BinaryTree<String>(data, leftTree, rightTree);
        }
    }

    /*<exercise Lab Assignment 6 - Programming exercise 2/
    /**
     * Method to return the preorder traversal of the binary tree
     * as a sequence of strings each separated by a space.
     * @return A preorder traversal as a string
     */
    public String preorderToString() {
        StringBuilder stb = new StringBuilder();
        preorderToString(stb, root);
        return stb.toString();
    }

    private void preorderToString(StringBuilder stb, Node<E> root) {
    	
    	if (root == null) {
    		return;
    	}
    	stb.append(root.data +" ");
    	preorderToString(stb, root.left);
    	preorderToString(stb, root.right);
    	

	
	
	
    }
   

    /*<exercise Lab Assignment 6 - Programming exercise 3/
    /**
     * Method to return the postorder traversal of the binary tree
     * as a sequence of strings each separated by a space.
     * @return A postorder traversal as a string
     */
    public String postorderToString() {
        StringBuilder stb = new StringBuilder();
        postorderToString(stb, root);
        return stb.toString();
    }

    private void postorderToString(StringBuilder stb, Node<E> root) {

	
    	if (root == null) {
    		return;
    	}
    	postorderToString(stb, root.left);
    	postorderToString(stb, root.right);
    	stb.append(root.data+" ");
	
	
	
	
	
	
    }

    /*<exercise Lab Assignment 6-Programming exercise 4/
    /** 
     * A method to display the inorder traversal of a binary tree 
     * placing a left parenthesis before each subtree and a right 
     * parenthesis after each subtree. For example the expression 
     * tree shown in the Figure would be represented as
     * (((x) + (y)) * ((a) / (b))).
     * @return An inorder string representation of the tree
     */
    public String inorderToString() {
        StringBuilder stb = new StringBuilder();
        inorderToString(stb, root);
        return stb.toString();
    }

    private void inorderToString(StringBuilder stb, Node<E> root) {

    	
    	if (root == null) {
    		return;
    	}
    	
    
    	
		
    	inorderToString(stb, root.left);
    	stb.append(" "+root.data+" ");
    	inorderToString(stb, root.right);
		

	
	
	
	
	
	
	
    }
    
 
}