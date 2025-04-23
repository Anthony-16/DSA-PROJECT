import java.util.Iterator;

public class CircIterator<E> implements Iterator<E>{

	private Node<E> next;
	private Node<E> previous;
	boolean nextCalled = false;
	
	
	public CircIterator() {
		next = null;
		previous = null;
		nextCalled = false;
	}
	
	
	public CircIterator(Node<E> current, int size) {
		Node<E> temp = current;
		for (int i = 0; i < size - 1; i++) {
			temp = temp.getNext();
		}
		previous = temp;
		next = current.getNext(); 
		nextCalled = false;
	}
	
	
	
	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		if(previous == null || next == null) {
			return false;
		}
		return true;
	}

	@Override
	public E next() {
		E data = next.getElement();
		previous = previous.getNext();
		next = next.getNext();
		nextCalled = true;
		return data;
	}
	
	
	
	public void remove() {
		if (!nextCalled) {
			return;
		}
		if (previous.getNext() == next && next == previous) {  // if there is one item in list
		next = null;
		previous = null;
		}
		else if (previous.getNext() == next && next != previous) { // if there are two items in the list
			next.setNext(next);
			nextCalled = false;
		}
		else {
		previous.setNext(next);
		nextCalled = false;
		}
	}
	
	
}
