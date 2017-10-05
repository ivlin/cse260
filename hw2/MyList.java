/* Ivan Lin
 * 111020797
 * CSE260
 * Homework #2
 */

public class MyList{

    private Object[] arr;
    private int size;
    
    public MyList(){
	this(10);
    }

    public MyList(int size){
	arr = new Object[size];
	this.size = 0;
    }

    public Object get(int index){
	return index>=0&&index<size()?arr[index]:null;
    }
    
    public void set(Object item, int index){
	arr[index]=item;
    }

    public void push(Object item){
	push(item, size());
    }

    public void push(Object item, int index){
	for (int i=size; i>index; i++){
	    arr[i]=arr[i-1];
	}
	set(item, index);
	size++;
	if (size >= arr.length){
	    resize(arr.length*2);
	}
    }    

    public Object remove(int index){
	Object removed = get(index);
	for (int i = index; i < size()-1; i++){
	    set(get(i+1),i);
	}
	size--;
	if (size < arr.length/4){
	    resize(arr.length/2);
	}
	return removed;
    }

    public Object pop(){
	return remove(size()-1);
    }

    public int size(){
	return size;
    }

    private void resize(int newSize){
	Object[] newArr = new Object[newSize];
	for (int i=0; i< newArr.length && i<arr.length; i++){
	    newArr[i]=arr[i];
	}
	arr = newArr;
    }

    public String toString(){
	String str = "[";
	for (int i=0; i<size()-1; i++){
	    str+=arr[i].toString()+",";
	}
	if (size()>0){
	    str += arr[size()-1];
	}
	return str+"]";
    }
}
