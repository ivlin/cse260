import java.util.HashMap;
import java.util.Scanner;
import java.io.FileReader;
import java.util.Iterator;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Set;
import java.util.Map;
public class NumberOccurences{

    public static void main(String[]args) throws IOException{
	Scanner sc = new Scanner(System.in);

	HashMap<Integer,Integer> intmap = new HashMap<Integer,Integer>();
	
	int read;
	while ((read = sc.nextInt())!=0){
	    if (intmap.containsKey(read)){
		intmap.put(read, intmap.get(read)+1);
	    }
	    else{
		intmap.put(read, 1);
	    }
	}
	System.out.println(intmap);
	Iterator<Integer> c = intmap.values().iterator();
	int max = c.next();
	int temp;
	while (c.hasNext()){
	    temp = c.next();
	    max = temp>max? temp: max;
	}
	
	Iterator<Integer> k = intmap.keySet().iterator();
	
	while (k.hasNext()){
	    temp = k.next();
	    if (intmap.get(temp)==max){
		System.out.println("Max:"+temp+" with 
+max+" occurences);
	    }
	}
    }
}
