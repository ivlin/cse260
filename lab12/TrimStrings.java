import java.util.ListIterator;
import java.util.Arrays;
import java.util.List;
public class TrimStrings{

    public static void main(String[]args){
	String[] s = {"  a","b","   c   ","d   "};
	List<String> l = Arrays.asList(s);
	System.out.println(l);
	TrimStrings.trimStrings(l);
	System.out.println(l);
    }

    public static void trimStrings(List<String> strings){
	ListIterator<String> l = strings.listIterator();
	while (l.hasNext()){
	    l.set(l.next().trim());
	}
    }
    
}
