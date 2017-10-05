import java.util.ArrayList;

public class ShuffleArrayList{

    public static void main(String[]args){
	ArrayList<Integer> a = new ArrayList<>();
	for (int i=0; i<20; i++){
	    a.add(i);
	}
	ShuffleArrayList.shuffle(a);
	System.out.println(a);
    }
    
    public static <E> void shuffle(ArrayList<E> list){
	E temp;
	int switchInd;
	for (int i=0; i<list.size(); i++){
	    switchInd = (int)(Math.random()*list.size());
	    temp = list.get(switchInd);
	    list.set(switchInd, list.get(i));
	    list.set(i, temp);
	}
    }
}
