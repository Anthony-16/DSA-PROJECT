import java.util.Iterator;

public class CircularList<E> implements Iterable<E> {

	private Node<E> current; //reference to current node
	private int size; //size of list
	
	 
	
    public CircularList() {
    	current = null;
    	size = 0;
    }

    public CircularList(Node<E> c) {
    	current = c;
    	size = 1;
    }
    
    
   public void add(E item) {
	   if (size > 0) { 
		   Node<E> newNode = new Node<E>(item);
		   newNode.setNext(current.getNext());
		   current.setNext(newNode);
		   current = newNode;
		   size++;
	   }
	   else {
		   current = new Node<E>(item);
		   current.setNext(current);
		   size++;
	   }
   }


   public E get() {
	   return current.getElement();
   }
   
   public int size() {
	   return size;
   }
   
   public Iterator<E> iterator(){
	   Iterator<E> Iterator = new CircIterator<E>(current, size);
	   return Iterator;
   }
	
 
	
}
