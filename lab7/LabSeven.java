import java.util.*;
public class LabSeven{

  public static void main(String[]args){
    timeLinkedListIteration();
    listComparisons();
    pq();
  }
  
  public static void timeLinkedListIteration(){
    LinkedList<Double> doubles = new LinkedList<>();
    for (double i=0; i<500000; i++){
      doubles.add(i);
    }
    Iterator i = doubles.iterator();
    long timeNow = System.currentTimeMillis();
    for (;i.hasNext();){
      i.next();
    }
    System.out.println("Time total with iterator: " + (System.currentTimeMillis()-timeNow));
    timeNow = System.currentTimeMillis();
    doubles.get(doubles.size()-1);
    System.out.println("Time total with get: " + (System.currentTimeMillis()-timeNow));
  }

    public static void listComparisons(){
	double[] arr = new double[900000];
	ArrayList<Double> al = new ArrayList<>();
	LinkedList<Double> ll = new LinkedList<>();
	for (double i=0; i<900000; i++){
	    arr[(int)i]=i;
	    al.add(i);
	    ll.add(i);
	}
	
	long timeNow = System.currentTimeMillis();
	double d = arr[arr.length/2];
	System.out.println("Time total with array get: " + (System.currentTimeMillis()-timeNow));

	timeNow = System.currentTimeMillis();
	d = al.get(al.size()/2);
	System.out.println("Time total with arraylist get: " + (System.currentTimeMillis()-timeNow));

	
	timeNow = System.currentTimeMillis();
	d = ll.get(ll.size()/2);
	System.out.println("Time total with linkedlist get: " + (System.currentTimeMillis()-timeNow));

	timeNow = System.currentTimeMillis();
	arr[arr.length/2]=0;
	System.out.println("Time total with array add: " + (System.currentTimeMillis()-timeNow));

	timeNow = System.currentTimeMillis();
	al.add(al.size()/2,(double)0);
	System.out.println("Time total with arraylist add: " + (System.currentTimeMillis()-timeNow));

	
	timeNow = System.currentTimeMillis();
	ll.add(ll.size()/2,(double)0);
	System.out.println("Time total with linkedlist add: " + (System.currentTimeMillis()-timeNow));

	
	timeNow = System.currentTimeMillis();
	arr[arr.length/2]=0;
	System.out.println("Time total with array remove: " + (System.currentTimeMillis()-timeNow));

	timeNow = System.currentTimeMillis();
	al.remove(0);//al.size()/2);
	System.out.println("Time total with arraylist remove: " + (System.currentTimeMillis()-timeNow));

	
	timeNow = System.currentTimeMillis();
	ll.remove(ll.size()/2);
	System.out.println("Time total with linkedlist remove: " + (System.currentTimeMillis()-timeNow));
    }

    public static void pq(){
	PriorityQueue<String> p1 = new PriorityQueue<>();
	PriorityQueue<String> p2 = new PriorityQueue<>();
	p1.add("George");p1.add("Jim");p1.add("John");p1.add("Blake");p1.add("Kevin");p1.add("Michael");
	p2.add("George");p2.add("Katie");p2.add("Kevin");p2.add("Michelle");p2.add("Ryan");
	PriorityQueue<String> pIntersection = new PriorityQueue<>();
	for (String s: p1){
	    if (p2.contains(s)){
		pIntersection.add(s);
	    }
	}
	System.out.println("intersection:" + pIntersection);
	PriorityQueue<String> pDifference = new PriorityQueue<>();
	for (String s:p1){
	    if (!p2.contains(s)){
		pDifference.add(s);
	    }
	}
	for (String s:p2){
	    if (!p1.contains(s)){
		pDifference.add(s);
	    }
	}
	System.out.println("difference:" + pDifference);
	PriorityQueue<String> pUnion = new PriorityQueue<>();
	for (String s: p1){
	    if (!pUnion.contains(s)){
		pUnion.add(s);
	    }
	}
	for (String s: p2){
	    if (!pUnion.contains(s)){
		pUnion.add(s);
	    }
	}
	System.out.println("union:" + pUnion);
    }
}
