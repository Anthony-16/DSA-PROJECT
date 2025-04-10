import java.util.Iterator;

public class CircIterator implements Iterator<Object> {

	Node next;
	Node previous;
	boolean nextCalled = false;
	
	
	public CircIterator() {
		next = null;
		previous = null;
		nextCalled = false;
	}
	
	
	
	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Node next() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void remove() {
		
	}
	
	
	}

}
