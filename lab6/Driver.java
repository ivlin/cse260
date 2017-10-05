import java.util.Arrays;
import java.util.List;
import java.util.Collections;
public class Driver{
    public static void main(String[]args){
	Point[] i = new Point[100];
	for (int cur=0; cur<i.length; cur++){
	    i[cur]=new Point((int)(Math.random()*100),(int)(Math.random()*100));
	}
	System.out.println("Unsorted: "+Arrays.toString(i));
	List<Point> l = Arrays.asList(i);
	Collections.sort(l);
	System.out.println("\nSorted by X: "+l);
	Arrays.asList(i).sort(new CompareY());
	System.out.println("\nSorted by Y: "+Arrays.toString(i));
    }
}
