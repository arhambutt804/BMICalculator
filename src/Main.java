import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Random;

public class Main extends Application {
    static int count = 0;
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {

        ArrayList<Circle> circles = new ArrayList<Circle>();


        Random random = new Random();
        int numberOfCircles = 100;

        for(int i = 1; i<=numberOfCircles;i++){
            circles.add(new Circle(100,100,random.nextDouble(10,150),
                    Color.rgb(random.nextInt(0,255), random.nextInt(0,255), random.nextInt(0,255) )));
        }


        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setVgap(10);
        gridPane.setHgap(10);

        Label search = new Label("Search by ID (1-100)");
        TextField textField = new TextField();
        Button run =  new Button("Create");

        HBox circleBox = new HBox();
        circleBox.setAlignment(Pos.CENTER);
        HBox hBox = new HBox(search,textField,run);
        hBox.setSpacing(15);

        run.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                circles.get(0).setRadius(circles.get(count++).getRadius());
                circles.get(0).setFill(circles.get(count++).getFill());
                if(count<numberOfCircles){
                    count++;
                }
                else {
                    count=0;
                }
            }
        });
        textField.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                int id = Integer.parseInt(textField.getText());
                circles.get(0).setRadius(circles.get(id).getRadius());
                circles.get(0).setFill(circles.get(id).getFill());
            }
        });
        circleBox.getChildren().add(circles.get(0));

        gridPane.add(circleBox,0,5);
        gridPane.add(hBox,0,10);

        Scene scene =  new Scene(gridPane,500,400);
        stage.setScene(scene);

        stage.show();
    }
}
