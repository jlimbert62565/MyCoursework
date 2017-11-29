import Controller.MainController;
import Model.DatabaseConnection;
import javafx.application.Application;
import javafx.embed.swing.JFXPanel;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {

    public static GraphicsContext gc;
    private static Stage startStage;
    private static DatabaseConnection database;

    @Override
    public void start(Stage stage) throws Exception {

        database = new DatabaseConnection("Inventory.db");

        MainController controller = new MainController();


        startStage = stage;

        BorderPane root = new BorderPane();
        Scene scene = new Scene(root);
        stage.setTitle("Maths Quiz");
        stage.setResizable(false);
        stage.setWidth(780);
        stage.setHeight(799);
        stage.setScene(scene);
        stage.show();
        scene.getStylesheets().add("stylesheet.css");

            /* THIS IS THE TOP BIT */

        VBox topPane = new VBox(10);

        TextField name = new TextField();
        name.setPromptText("enter name");

        topPane.getChildren().add(name);

        TextField school = new TextField();
        school.setPromptText("enter school");
        school.setPrefWidth(80);

        topPane.getChildren().add(school);

        root.setTop(topPane);

        Image background = new Image("background.png");
        ImageView backgroundImage = new ImageView(background);
        Pane backgroundPane = new Pane();
        backgroundPane.getChildren().add(backgroundImage);
        root.setCenter(backgroundPane);


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

        HBox hbox = new HBox(200);
        hbox.setPadding(new Insets(20));

        hbox.getChildren().addAll(radioButton1, radioButton2, radioButton3);

        bottomPane.getChildren().add(hbox);

        Button myButton2 = new Button("Confirm name, school and shape choice");
        myButton2.setPrefSize(500, 50);
        myButton2.setOnAction((ActionEvent ae) -> controller.openNewStage(name.getText(), school.getText(), radioGroup, root, startStage));
        myButton2.getStyleClass().add("start_screen_button");

        bottomPane.getChildren().add(myButton2);


        root.setBottom(bottomPane);





    }



}

