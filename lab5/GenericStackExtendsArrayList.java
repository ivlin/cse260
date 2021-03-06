import java.util.ArrayList;
public class GenericStackExtendsArrayList<E> extends ArrayList<E>{

    public static void main(String[]args){
	GenericStackExtendsArrayList<String> stack = new GenericStackExtendsArrayList<>();
	System.out.println("HI");
	System.out.println(stack.peek());
	System.out.println(stack.getSize());
	stack.push("ABC");
	stack.push("XYZ");
	stack.push("123");
	System.out.println(stack.getSize());
	System.out.println(stack.peek());
	String s = stack.pop();
	System.out.println(s);
	System.out.println(stack.peek());
	System.out.println(stack.getSize());
	stack.pop();
	stack.pop();
	stack.pop();
	stack.pop();
	for (int i=1j; i<500; i++){
	    stack.push(""+i);
	}
	System.out.println(stack.peek());
	System.out.println(stack.getSize());
    }
    
    public int getSize() {
	return size();
    }
    public E peek() {
	return size()>0?get(size()-1):null;
    }
    public void push(E o) {
	add(o);
    }
    public E pop() {
	return size()>0?remove(size()-1):null;
    }
}
