import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class IndexTree {

	private BinarySearchTree<Word> index = new BinarySearchTree<Word>();
	
	
	public IndexTree(String fileName) throws FileNotFoundException {
		File inputFile = new File(fileName);
	    Scanner in = new Scanner(inputFile);
	    int line = 0;
				
	      while (in.hasNextLine()) { 
	    	line++;
	    	String token;
	    	String theLine = in.nextLine();
	    	if(!theLine.trim().isEmpty()) {
	  	    StringTokenizer tokenizer = new StringTokenizer(theLine);
	  	  while (tokenizer.hasMoreTokens()) {
	  		  	token = tokenizer.nextToken();
	  		  	if (!stripSpecChar(token).isEmpty()) { //if the stripped char was only nonletters ie "-" the it would return null or "" this makes it so if the stripped word returned null then it would not count
	            addRecord(stripSpecChar(token), line);
	  		  }
	  	  }
	     }
	    }
	      in.close();
	}
	
	public void addRecord(String w, int line) {
		Word newW = new Word(w, line);
		Word tryToFind = index.find(newW);
		
		
		
		if (tryToFind == null) {
			index.add(newW);
		}
		else {
			tryToFind.addOccurrence(line);
		}
	}
	
	public void printIndex() {
		String str = index.inorderToString();
		System.out.println(str);
	}
	
	//strips special characters and captials ie: cat = CAT = cat. = cat,
	public String stripSpecChar(String w) {
		StringBuilder stb = new StringBuilder();
		
		
			for (int i = 0; i < w.length(); i++) {
			char letter = w.charAt(i);
			if(Character.isLetter(letter)) {
				stb.append(letter);
			}
			}
		

	
		return stb.toString().toLowerCase();
		
		  	
	}
	
	
	
	
	
	
	private class Word implements Comparable<Word>{
		
		private String w;
		private int count;
		private ArrayList<Integer> lines =  new ArrayList<Integer>();
		
		
		public Word(String w, int line) {
			this.w = w;
			count = 1;
			
			lines.add(line);
		}
		
		
		public void addOccurrence(int line) {
			
			if (lines.contains(line)) {
				count++;
			}
			else {
				count++;
				lines.add(line);
			}
		}
		
		public String toString( ) {
			return "Word: '"+w+"' | Count: "+count+" | Unique Lines: "+lines.toString()+"\n";
		}
		
		
		public int  compareTo(Word o) {
			return w.compareTo(o.w);
		}

		
	}
	
}