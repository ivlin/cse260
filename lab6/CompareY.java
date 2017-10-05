import java.util.Comparator;
public class CompareY implements Comparator<Point>{

    public int compare(Point p1, Point p2){
	if (p2.getY()-p1.getY()==0){
	    return p1.getX()-p2.getX();
	}
	return p1.getY()-p2.getY();
    }
    
}
