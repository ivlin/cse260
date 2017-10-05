public class LinearSearch{

    public static void main(String[]args){
	Integer[] a= {1,2,3,5,6,234,2,34,23,4,23,543,6,5,23,452,3,254,3};
	System.out.println(linearSearch(a,543));
	System.out.println(linearSearch(a,17));
    }
    
    public static <E extends Comparable<E>> int linearSearch(E[] list, E key){
	for (int i=0; i<list.length; i++){
	    if (list[i].compareTo(key)==0){
		return i;
	    }
	}
	return -1;
    }
    
}
