import javafx.application.Application;
import javafx.embed.swing.JFXPanel;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import static java.awt.SystemColor.text;

public class Main extends Application {

        public static GraphicsContext gc;

        @Override
        public void start(Stage stage) throws Exception {

            BorderPane root = new BorderPane();
            Scene scene = new Scene(root);

            stage.setTitle("Joe");
            stage.setResizable(false);
            stage.setWidth(1024);
            stage.setHeight(768);
            stage.setScene(scene);
            stage.show();

            /* THIS IS THE TOP BIT */

            VBox topPane = new VBox(10);

            TextField name = new TextField();
            name.setText("enter name");

            topPane.getChildren().add(name);

            TextField school = new TextField();
            school.setText("enter school");

            topPane.getChildren().add(school);

            Button myButton = new Button("Confirm name and school");
            myButton.setPrefSize(200, 50);
            myButton.setOnAction((ActionEvent ae) -> doSomething(ae));

            topPane.getChildren().add(myButton);

            root.setTop(topPane);

            /* THIS IS THE BOTTOM BIT */

            VBox bottomPane = new VBox(10);

            /* Choosing shape*/
            RadioButton radioButton1 = new RadioButton("Choose Square");
            RadioButton radioButton2 = new RadioButton("Choose Circle");
            RadioButton radioButton3 = new RadioButton("Choose Triangle");

            ToggleGroup radioGroup = new ToggleGroup();

            radioButton1.setToggleGroup(radioGroup);
            radioButton2.setToggleGroup(radioGroup);
            radioButton3.setToggleGroup(radioGroup);

            HBox hbox = new HBox(300);
            hbox.setPadding(new Insets(20));

            hbox.getChildren().addAll(radioButton1, radioButton2, radioButton3);

            bottomPane.getChildren().add(hbox);

            Button myButton2 = new Button("Confirm shape choice");
            myButton2.setPrefSize(200, 50);
            myButton2.setOnAction((ActionEvent ae) -> doSomething(ae));

            bottomPane.getChildren().add(myButton2);



            root.setBottom(bottomPane);


        }

    public static void doSomething(ActionEvent ae) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Confirmed!");
        alert.showAndWait();
    }

    }