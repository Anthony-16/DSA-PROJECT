import java.util.Iterator;

public class CircularList {

	private Node current; //reference to current node
	private int size; //size of list
	
	
	
    public CircularList() {
    	current = null;
    	size = 0;
    }

    public CircularList(Node c) {
    	current = c;
    	size = 1;
    }
    
    
   public void add(Object item) {
	  Node newNode = new Node(item);
	  current = newNode;
   }


   public Object get() {
	   return current;
   }
   
   public int size() {
	   return size;
   }
   
   public Iterator<Object> iterator(){
	   Iterator<Object> Iterator = new CircIterator();
	   return Iterator;
   }
	
	
}
