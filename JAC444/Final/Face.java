package Final;


import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;

public class Face extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        Group group = new Group();

        Circle circle = new Circle();

        circle.setCenterX(150.0f);
        circle.setCenterY(150.0f);
        circle.setRadius(120.0f);
        circle.setFill(Color.WHITE);
        circle.setStroke(Color.BLACK);

        Ellipse leye = new Ellipse();
        leye.setRadiusX(25.0f);
        leye.setRadiusY(20.0f);
        leye.setCenterX(100.0f);
        leye.setCenterY(100.0f);
        leye.setFill(Color.WHITE);
        leye.setStroke(Color.BLACK);

        Circle lcir = new Circle();
        lcir.setCenterX(100.0f);
        lcir.setCenterY(100.0f);
        lcir.setRadius(15.0f);
        lcir.setFill(Color.BLACK);

        Ellipse reye = new Ellipse();
        reye.setRadiusX(25.0f);
        reye.setRadiusY(20.0f);
        reye.setCenterX(200.0f);
        reye.setCenterY(100.0f);
        reye.setFill(Color.WHITE);
        reye.setStroke(Color.BLACK);

        Circle rcir = new Circle();
        rcir.setCenterX(200.0f);
        rcir.setCenterY(100.0f);
        rcir.setRadius(15.0f);
        rcir.setFill(Color.BLACK);

        //nose
        Polygon triangle = new Polygon();
        triangle.getPoints().addAll(35.0, 0.0,0.0, 70.0,70.0, 70.0);

        triangle.setLayoutX(115);
        triangle.setLayoutY(110);
        triangle.setFill(Color.WHITE);
        triangle.setStroke(Color.BLACK);

        //mouse
        Arc mouth = new Arc(150, 190, 60, 25, 0, -180);
        mouth.setFill(null);

        mouth.setStroke(Color.BLACK);
        mouth.setStrokeWidth(1.0);
        mouth.setType(ArcType.OPEN);


        group.getChildren().addAll(circle,leye,lcir,reye,rcir,triangle,mouth);


        Scene s =  new Scene(group,300,300);


        primaryStage.setScene(s);

        primaryStage.show();
    }
}
