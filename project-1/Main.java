import java.util.Iterator;

public class Main {

	public static void main(String[] args) {

		CircularList<Integer> cList1 = new CircularList<Integer>();
		cList1.add(2);
		cList1.add(3);
		cList1.add(4);
		//creates circular list 2 -> 3 -> 4 -> (back to 2)

		
		CircularList<String> cList2 = new CircularList<String>();
		cList2.add("a");
		cList2.add("b");
		cList2.add("c");
		cList2.add("d");
		cList2.add("e");
		//creates circular list a -> b -> c -> d -> e -> (back to a)
		
		int counter = 0;
		Iterator<Integer> iter1 = cList1.iterator();
		Iterator<String> iter2 = cList2.iterator();
		
		
		System.out.println("List 1| size: "+cList1.size()+" | current: "+cList1.get()+" | next: "+iter1.next());
		System.out.println("List 2| size: "+cList2.size()+" | current: "+cList2.get()+" | next: "+iter2.next());
		
		iter2.remove(); //remove a because current = e and next() will return a 

		
		while(counter < 10) {
			System.out.print(iter2.next()+" ");
			counter++;
	    }
		//iterate through the circular list 10 times with a removed
		
		
		
		
		
		
		
	

	}

}
