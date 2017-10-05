public class TestMyPoint{
    public static void main(String[]args){
	MyPoint one = new MyPoint(0,0);
	MyPoint two = new MyPoint(10,30.5);

	System.out.println("Coordinates are (0,0) and (10,30.5)");
	System.out.printf("Testing distance between two mypoints: %f\n",one.distance(two));
	System.out.printf("Testing distance between mypoint and coords: %f\n",one.distance(10,30.5));
						   	
    }
}
