import java.io.*;
import java.util.Scanner;
import java.util.TreeSet;
public class NonduplicateWords{

    public static void main(String[]args){
	try{
	    File f = new File(args[0]);
	    printWordsFromFile(f);
	} catch(Exception e){
	    System.out.println("Invalid file");
	}
    }

    public static void printWordsFromFile(File f) throws FileNotFoundException{
	Scanner sc = new Scanner(f);
	TreeSet<String> s = new TreeSet<>();
	String word;
	while (sc.hasNext()){
	    s.add(sc.next());
	}
	for (String cur: s){
	    System.out.println(cur);
	}
    }
}
