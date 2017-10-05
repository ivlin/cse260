public class Point implements Comparable<Point>{
    private int x,y;
    public Point(int x, int y){
	this.x = x;
	this.y = y;
    }
    public int compareTo(Point o){
	if (getX()-o.getX()==0){
	    return getY()-o.getY();
	}
	return getX()-o.getX();
    }
    public int getX(){
	return x;
    }
    public int getY(){
	return y;
    }
    public String toString(){
	return "("+getX()+","+getY()+")";
    }
}
