import java.util.ArrayList;
public class ArrayMethods {

    public static void main(String[]args){
	ArrayList<String> a = new ArrayList<>();
	a.add("A first");
	a.add("Z last");
	a.add("Y third");
	a.add("C second");
	System.out.println(a);
	ArrayMethods.sort(a);
	System.out.println(a);
	System.out.println(ArrayMethods.max(a));
    }
    
    public static <E extends Comparable<E>> void sort(ArrayList<E> list){
	E temp;
	int minInd;
	for (int partition=0; partition<list.size(); partition++){
	    minInd = partition;
	    for (int i=partition; i<list.size(); i++){
		if (list.get(partition).compareTo(list.get(i)) > 0){
		    minInd = i;
		}
	    }
	    temp = list.get(minInd);
	    list.set(minInd, list.get(partition));
	    list.set(partition, temp);
	}
    }

    public static <E extends Comparable<E>> E max(ArrayList<E> list){
	E max = list.size()>0 ? list.get(0) : null;
	for (E item: list){
	    if (item.compareTo(max)>0){
		max = item;
	    }
	}
	return max;
    }
}
