public class BinarySearch{
    
    public static void main(String[]args){
	String[] a = new String[10];
	for (int i=0; i<a.length; i++){
	    a[i]=""+(char)('a'+i);
	}
	Integer[] i = new Integer[0];
	System.out.println(BinarySearch.binarySearch(a,"c"));
	System.out.println(BinarySearch.binarySearch(i,2));
    }
    
    public static <E extends Comparable<E>> int binarySearch(E[] list, E key){
	int upper = list.length-1;
	int lower = 0;
	int i = (upper + lower) / 2;
	while (upper >= lower){
	    if (list[i].compareTo(key)==0){
		return i;
	    }
	    else if (list[i].compareTo(key)>0){
		upper = i-1;
	    }
	    else{
		lower = i+1;
	    }
	    i = (upper + lower) / 2;
	}	
	return -1;
    }
    
}
