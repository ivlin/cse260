import java.util.ArrayList;
public class RemoveDuplicates{

    public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list) {
	ArrayList<E> noDup = new ArrayList<E>();
	for (E e: list){
	    if (!noDup.contains(e)){
		noDup.add(e);
	    }
	}
	return noDup;
    }
    
}
