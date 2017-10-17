import java.util.TreeSet;
import java.util.Arrays;
public class PrintSorted{
    public static void main(String[]args){
	TreeSet<String> a = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
	a.addAll(Arrays.asList(args));
	System.out.println(a);
    }
}
