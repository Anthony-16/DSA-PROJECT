import java.io.FileNotFoundException;



public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		
		  //you must increase console buffer size to see entire output**
		  // Window -> Preferences -> Run/Debug -> Console -> Console Buffer Size
 	      IndexTree theTree = new IndexTree("input");
	      
	      theTree.printIndex();
	      
	}
}
