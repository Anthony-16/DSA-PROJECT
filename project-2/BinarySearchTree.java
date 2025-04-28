public class BinarySearchTree<E extends Comparable<E>> extends BinaryTree<E> {
	
	 public E find(E target) {
	        return find(root, target);
	    }
	 
	 
	 private E find(Node<E> localRoot, E target) {
	    	if (localRoot == null) {
	    		return null;
	    	}
	    	if ((target.compareTo(localRoot.data) == 0)) {
	    		return localRoot.data;
	    	}
	    	if (target.compareTo(localRoot.data) < 0) {
	    		return find(localRoot.left, target);
	    	}
	    	else {
	    		return find(localRoot.right, target);
	    	}
	    }

	 
	
	
	public boolean contains(E target) {
		return (find(root, target) != null && target.compareTo(find(root, target)) == 0);
	}
	
	public boolean add(E target) {
		 root = add(root, target);
	        return (root == null);
	}
	
	
    private Node<E> add(Node<E> localRoot, E item) {
    	
    	
        

        if (localRoot == null) {
        	Node<E> newNode = new Node<E>(item);
        	return newNode;
        }
        
        if (localRoot.data.compareTo(item) == 0) {
        	return localRoot;
        }
    		
        else if (localRoot.data.compareTo(item) > 0) {  
        	localRoot.left = add(localRoot.left, item);
        }
        	
        else if (localRoot.data.compareTo(item)  < 0) {  
        	localRoot.right = add(localRoot.right, item);
        }
        

        
    		return localRoot;
        
    		
    }

	
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
    	stb.append(root.data);
    	inorderToString(stb, root.right);
		

	
	
	
	
	
	
	
    }
    
	
	
	
	
	
}