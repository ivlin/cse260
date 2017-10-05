public class MaxMatrix{

    public static void main(String[]args){
	Integer[][] i={{1}};
	Integer[][] b={{2},{123},{1}};
	Integer[][] c={};
	System.out.println(MaxMatrix.max(i));
	System.out.println(MaxMatrix.max(b));
	System.out.println(MaxMatrix.max(c));
    }
    
    public static <E extends Comparable<E>> E max(E[][]list){
	E max = null;
	for (E[] sublist: list){
	    for (E item: sublist){
		if (max==null || item.compareTo(max)>0){
		    max = item;
		}
	    }
	}
	return max;
    }
}

