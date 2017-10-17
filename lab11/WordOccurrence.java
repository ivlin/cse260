import java.util.*;
import java.io.*;
public class WordOccurrence implements Comparable<WordOccurrence>{

    private String word;
    private int count;

    public static void main(String[]args) throws IOException{
	File f = new File(args[0]);
	Scanner sc = new Scanner(f);
	sc.useDelimiter("\\s*|\"|.|,|:|;| ? |(|)");
	
	ArrayList<WordOccurrence> oc = new ArrayList<>();
	boolean present;
	String temp;
	while (sc.hasNext()){
	    present=false;
	    
	    temp = sc.next();
	    System.out.println(temp);
	    for (WordOccurrence w:oc){
		if (present= (present||w.getWord().equalsIgnoreCase(temp))){
		    w.setCount(w.getCount()+1);
		}
	    }
	    if (!present){
		oc.add(new WordOccurrence(temp,1));
	    }
	}
	Collections.sort(oc);
	System.out.println(oc);
    }
	
    public WordOccurrence(String word, int count){
	this.word = word;
	setCount(count);
    }

    public String getWord(){
	return word;
    }
    public int getCount(){
	return count;
    }

    public void setCount(int count){
	this.count = count;
    }
    
    public int compareTo(WordOccurrence o){
	return getCount()-o.getCount();
    }

    public String toString(){
	return ""+getCount()+ " " + getWord();
    }
}
