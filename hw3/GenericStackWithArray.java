public class GenericStackWithArray<E> {

    public static void main(String[]args){
	GenericStackWithArray<String> stack = new GenericStackWithArray<>();
	System.out.println("HI");
	System.out.println(stack.peek());
	System.out.println(stack.getSize());
	stack.push("ABC");
	stack.push("XYZ");
	stack.push("123");
	System.out.println(stack.getSize());
	System.out.println(stack.peek());
	String s = (String)stack.pop();
	System.out.println(s);
	System.out.println(stack.peek());
	System.out.println(stack.getSize());
	stack.pop();
	stack.pop();
	stack.pop();
	stack.pop();
	for (int i=0; i<500; i++){
	    stack.push(""+i);
	}
	System.out.println(stack.peek());
	System.out.println(stack.getSize());
    }
    
    private Object[] list = new Object[10];
    private int size=0;
    
    public int getSize() {
	return size;
    }
    public E peek() {
	return getSize()>0?(E)list[getSize()-1]:null;
    }
    public void push(E o) {
	list[getSize()] = o;
	size++;
	if (getSize() >= list.length){
	    resize(2*list.length);
	}
    }
    public E pop() {
	if (getSize()<=0){
	    return null;
	}
	Object o = peek();
	size--;
	if (getSize() <= list.length/4){
	    resize(list.length/2);
	}
	return (E)o;
    }
    public boolean isEmpty() {
	return size==0;
    }
    @Override // Java annotation: also used at compile time to
    public String toString() { // detect override errors
	String str = "";
	for (int i=0; i<getSize(); i++){
	    str += list[i].toString() + ", ";
	}
	str += peek().toString();
	return "stack: " + str;
    }

    /** Private Methods **/
    private void resize(int newLength){
	Object[] newList = new Object[newLength];
	for (int i=0; i<list.length && i<newList.length; i++){
	    newList[i] = list[i];
	}
	list = newList;
    }
}
