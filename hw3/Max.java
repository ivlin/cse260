public class Max{

    public static void main(String[]args){
	Integer[] i = {2,4,54,6,4,23,4,23,54,57,57,8,56,8,536,23,4523,5,325,2};
	Integer[] p = {};
	System.out.println(Max.max(i));
	System.out.println(Max.max(p));
    }
    
    public static <E extends Comparable<E>> E max(E[] list){
	if (list.length<=0){
	    return null;
	}
	E max = list[0];
	for (E current: list){
	    if (current.compareTo(max)>0){
		max = current;
	    }
	}
	return max;
    }
    
}
