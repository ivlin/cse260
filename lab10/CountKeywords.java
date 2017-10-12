import java.io.*;
import java.util.*;
public class CountKeywords{
    
    public static void main(String[]args){
	//System.out.println(""+CountKeywords.countOf("hello","l"));

	try{
	    File f = new File("Keywords");
	    File w = new File(args[0]);
	    ArrayList<String> keys = loadCodeFromFile(f);
	    ArrayList<String> words = loadCodeFromFile(w);
	    printIntersection(words, keys);
	} catch(FileNotFoundException e){
	    System.out.println("Invalid file");
	}
    }

    public static ArrayList<String> loadCodeFromFile(File f) throws FileNotFoundException{
	Scanner sc = new Scanner(f);
	ArrayList<String> s = new ArrayList<>();
	String word;
	while (sc.hasNext()){
	    word = sc.next();
	    if (word.contains("//")&&sc.hasNext()){
		sc.nextLine();
	    }
	    else if (word.contains("\"")){
		if (CountKeywords.countOf(word,"\"")%2!=0){   
		    while (CountKeywords.countOf(sc.next(),"\"")%2 != 1){
		    }
		}
	    }
	    else if (word.contains("/*")){
		while (!(sc.next().contains("*/"))){
		}
	    }
	    else{
		s.add(sc.next());
	    }
	}
	return s;
    }
    
    public static void printIntersection(List<String> words, List<String> keywords){
	Iterator<String> i = words.iterator();
	String cur;
	int count=0;
	while (i.hasNext()){
	    if (keywords.contains(i.next())){
		count++;
	    }
	}
	System.out.println(""+count+" instances of keywords");
    }

    public static int countOf(String primary, String substr){
	int count=0;
	int lastInd=-1;
	do {
	    lastInd = primary.indexOf(substr, lastInd+1);
	    if (lastInd >=0){
		count++;
	    }
	} while (lastInd>=0);
	return count;
    }
}
