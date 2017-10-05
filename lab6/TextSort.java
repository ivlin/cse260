import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedList;
import java.io.File;
import java.util.Collections;
public class TextSort{

    public static void main(String[]args) throws java.io.IOException{
	if (args.length>1 && args[0].equals("-sort")){
	    TextSort.printSortedFile(args[1]);
	}
	else if (args.length>0 && args[0].equals("-multi")){
	    TextSort.printSortedShuffledReversed(args);
	}
    }

    /** 1 **/
    public static void printSortedFile(String filename) throws java.io.IOException{
	File f = new File(filename);
	Scanner sc = new Scanner(f);
	ArrayList<String> words = new ArrayList<>();
	while (sc.hasNext()) {
	    words.add(sc.next());
	}
	System.out.println(words);
	Collections.sort(words);
	System.out.println(words);
    }
    
    public static void printSortedShuffledReversed(String[]args){
	LinkedList<Integer> l = new LinkedList<>();
	for (int i=1; i<args.length; i++){
	    l.add(Integer.parseInt(args[i]));
	}
	LinkedList<Integer> sorted = new LinkedList<>(l);
	Collections.sort(sorted);
	System.out.println("Sorted:"+sorted);

	LinkedList<Integer> shuffled = new LinkedList<>(l);
	Collections.shuffle(shuffled);
	System.out.println("Shuffled:"+shuffled);
	
	LinkedList<Integer> reversed = new LinkedList<>(l);
	Collections.reverse(reversed);
	System.out.println("Reversed:"+reversed);	
    }
}
