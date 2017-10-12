import java.util.HashSet;
import java.util.Set;
import java.util.Iterator;
import java.util.Arrays;
public class SetOperations{

    public static void main(String[]args){
	HashSet<String> one = new HashSet<>(Arrays.asList("George","Jim","John","Blake","Kevin","Michael"));
	HashSet<String> two = new HashSet<>(Arrays.asList("George","Katie","Kevin","Michelle","Ryan"));
	System.out.println("Intersection");
	SetOperations.printIntersection(one,two);
	System.out.println("Difference");
	SetOperations.printDifference(one,two);
	System.out.println("Union");
	SetOperations.printUnion(one,two);
    }

    public static void printIntersection(Set<String> a, Set<String> b){
	Iterator<String> i = a.iterator();
	String cur;
	while (i.hasNext()){
	    if (b.contains(cur=i.next())){
		System.out.println(cur);
	    }
	}
    }

    public static void printDifference(Set<String> a, Set<String> b){
	Iterator<String> i = a.iterator();
	String cur;
	while (i.hasNext()){
	    if (!b.contains(cur=i.next())){
		System.out.println(cur);
	    }
	}
	i = b.iterator();
	while (i.hasNext()){
	    if (!a.contains(cur=i.next())){
		System.out.println(cur);
	    }
	}
    }
    
    public static void printUnion(Set<String> a, Set<String> b){
	printIntersection(a,b);
	printDifference(a,b);
    }
}
