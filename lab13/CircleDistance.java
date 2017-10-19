import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

public class CircleDistance extends Application {
    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {	
	double h = 200;
	double w = 200;
	
	// Create a circle and set its properties
	double x1,y1,x2,y2;
	Circle circle1 = new Circle();
	circle1.setCenterX((x1=Math.random()*w));
	circle1.setCenterY((y1=Math.random()*h));
	circle1.setRadius(50);
	circle1.setStroke(Color.BLACK);
	circle1.setFill(null);
	Circle circle2 = new Circle();
	circle2.setCenterX((x2=Math.random()*w));
	circle2.setCenterY((y2=Math.random()*h));
	circle2.setRadius(50);
	circle2.setStroke(Color.BLACK);
	circle2.setFill(null);
	//Line
	Line line = new Line();
	line.setStartX(x1);
	line.setStartY(y1);
	line.setEndX(x2);
	line.setEndY(y2);
	line.setStroke(Color.BLACK);
	line.setFill(null);
	// Create a pane to hold the circle
	Pane pane = new Pane();
	pane.getChildren().add(circle1);
	pane.getChildren().add(circle2);
	pane.getChildren().add(line);
	pane.getChildren().add(new Text((x1+x2)/2,(y1+y2)/2,""+Math.sqrt(Math.pow(x1-x2,2)+Math.pow(y1-y2,2))));
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
