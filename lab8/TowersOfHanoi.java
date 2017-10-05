import java.util.Stack;
public class TowersOfHanoi{
    
    public static void main(String[]args){
	TowersOfHanoi a = new TowersOfHanoi();
	a.moveDisks(5,new Stack<Integer>(), new Stack<Integer>(), new Stack<Integer>());
    }
    //moves disks from a to c
    public void moveDisks(int disks, Stack<Integer> a, Stack<Integer> b, Stack<Integer> c){
	for (int i=disks-1; i>=0; i--){
	    a.push(i);
	}
	printTowers(disks,a,b,c);

	Stack[] towers = {a,b,c};
	Stack<Integer> toTower = new Stack<>();
	Stack<Integer> fromTower = new Stack<>();
	Stack<Integer> args = new Stack<>();

	int from=0;
	int aux=1;
	int to=2;
	while (a.peek()!=disks-1){
	}
    }

    public void printTowers(int disks, Stack<Integer> a, Stack<Integer> b, Stack<Integer> c){
	for (int i=disks; i>=0; i--){
	    if (i>a.size()){
		System.out.format("%"+disks+"s","");
	    }
	    else if (i==a.size()){
		System.out.format("a%"+disks+"s","");
	    }
	    else{
		System.out.format("%"+(disks-a.get(i))+"s","");
		for (int x=0; x<2*a.get(i); x++){
		    System.out.format("-");
		}
		System.out.format("%"+(disks-a.get(i))+"s","");
	    }
	    if (i>b.size()){
		System.out.format("%"+disks+"s","");		
	    }
	    else if (i==b.size()){
		System.out.format("b%"+disks+"s","");
	    }
	    else{
		System.out.format("%"+(disks-b.get(i))+"s","");
		for (int x=0; x<2*b.get(i); x++){
		    System.out.format("-");
		}
		System.out.format("%"+(disks-b.get(i))+"s","");
	    }
	    if (i>c.size() ){
		System.out.format("%"+disks+"s","");
		
	    }
	    else if (i==c.size()){
		System.out.format("c%"+disks+"s","");
	    }
	    else{
		System.out.format("%"+(disks-c.get(i))+"s","");
		for (int x=0; x<2*c.get(i); x++){
		    System.out.format("-");
		}
		System.out.format("%"+(disks-c.get(i))+"s","");
	    }
	    System.out.println("");
	}
    }
}
