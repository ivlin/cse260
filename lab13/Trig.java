import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Polyline;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.collections.ObservableList;

public class Trig extends Application {
    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {	
	int w=500;
	int h=500;
	
	Polyline polyline = new Polyline();
	ObservableList<Double> list = polyline.getPoints();
	double scaleFactor = 50.0;
	for (int x = -170; x <= 170; x++) {
	    list.add(((double)x) + 200.0);
	    list.add(0.3*h+ 100.0 - 50.0 * Math.sin((((double)x) / 100.0) * 2.0 * Math.PI));
	}
	
	Line x = new Line();
	x.setStartX(0); x.setStartY(0.5*h);
	x.setEndX(w); x.setEndY(0.5*h);
	Line y = new Line();
	y.setStartX(0.5*w); y.setStartY(0);
	y.setEndX(0.5*w); y.setEndY(h);
	
	// Create a pane to hold the circle
	Pane pane = new Pane();
	pane.getChildren().add(polyline);
	pane.getChildren().add(x);
	pane.getChildren().add(y);
	// Create a scene and place it in the stage
	Scene scene = new Scene(pane, w, h);
	primaryStage.setTitle("ShowCircle"); // Set the stage title
	primaryStage.setScene(scene); // Place the scene in the stage
	primaryStage.show(); // Display the stage
    }

    /**
     * The main method is only needed for the IDE with limited
     * JavaFX support. Not needed for running from the command line.
     */
    public static void main(String[] args) {
	launch(args);
    }
}
