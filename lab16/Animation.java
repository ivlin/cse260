import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class Animation{

    public static void main(String[]args){
	launch(args);
    }
    
    public void drawSine(int x, int y, int, wavelength, int amplitude){
	Polyline polyline = new Polyline();
	ObservableList list = polyline.getPoints();
	double scaleFactor = 50;
	for (int x = -170; x <= 170; x++) {
	    list.add(x + 200.0);
	    list.add(100 – 50 * Math.sin((x / 100.0) * 2 * Math.PI));
	}
    }
}
