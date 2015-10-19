/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sutton_4_javafxintro;


import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;
public class Sutton_4_JavaFXintro extends Application{

    
    public static void main(String[] args) {
        launch(args);
    }
 
    public void start(Stage primaryStage){
        primaryStage.setTitle("Drawing Operations Test");
        Group root = new Group();
        Canvas canvas = new Canvas(700, 700);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        drawShapes(gc);
        drawJim(gc);
        root.getChildren().add(canvas);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
    private void drawJim(GraphicsContext gc){
        gc.setFill(Color.BISQUE);
        gc.fillText("Wooden Floor", 150, 150);
    }
    private void drawShapes(GraphicsContext gc){
        //IDE Intergrated Developement Environment 

        gc.setFill(Color.SADDLEBROWN);
        gc.setStroke(Color.BROWN);
        gc.setLineWidth(4);
        gc.fillRect(0,12, 700, 688);
        gc.strokeLine(9,10, 9, 700);
        gc.strokeLine(60,10, 60, 700);
        gc.strokeLine(111,10, 111, 700);
        gc.strokeLine(162,10, 162, 700);
        gc.strokeLine(213,10, 213, 700);
        gc.strokeLine(264,10, 264, 700);
        gc.strokeLine(315,10, 315, 700);
        gc.strokeLine(367,10, 367, 700);
        gc.strokeLine(418,10, 418, 700);
        gc.strokeLine(469,10, 469, 700);
        gc.strokeLine(520,10, 520, 700);
        gc.strokeLine(571,10, 571, 700);
        gc.strokeLine(622,10, 622, 700);
        gc.strokeLine(673,10, 673, 700);
        gc.strokeLine(0,10, 700, 10);
        gc.strokeLine(0,700, 700, 700);
        gc.strokeLine(0,10, 700, 10);

    }
}
