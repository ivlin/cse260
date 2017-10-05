public class MyPoint{
    private double x,y;

    public MyPoint(){
	this(0,0);
    }

    public MyPoint(double setX, double setY){
	x=setX;
	y=setY;
    }

    public double getX(){
	return x;
    }

    public double getY(){
	return y;
    }

    public double distance(MyPoint other){
	return distance(other.getX(),other.getY());
    }

    public double distance(double x1, double y1){
	return Math.sqrt(Math.pow(getX()-x1,2)+Math.pow(getY()-y1,2));
    }
}
