package View;

import Controller.StageTwoController;
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
import javafx.stage.WindowEvent;

public class StageTwo {

    static Pane parent;

    public StageTwo(Pane theParent) {

        Stage stage = new Stage();
        parent = theParent;
        parent.setDisable(true);
        start(stage);
    }

    public void start(Stage stage) {

        StageTwoController stc = new StageTwoController();

        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 1024, 768);
        stage.setTitle("Quiz");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setOnCloseRequest((WindowEvent we) -> stc.closeStage(parent));
        stage.show();
        scene.getStylesheets().add("stylesheet.css");

        /* creating the health bar */

        VBox topPane= new VBox(10);
        root.setTop(topPane);

        /* creating the question bar */

        HBox bottomPane = new HBox(10);

        Button ButtonEasy = new Button("Light Attack");
        ButtonEasy.getStyleClass().add("easy_button");
        ButtonEasy.setPrefSize(335, 50);
        ButtonEasy.setOnAction((ActionEvent ae) ->
                System.out.println("This feature does not yet exist :)")
                /*controller.openNewStage(name.getText(), school.getText(), radioGroup, root, startStage)); */
        );

        Button ButtonMedium = new Button("Medium Attack");
        ButtonMedium.getStyleClass().add("medium_button");
        ButtonMedium.setPrefSize(335, 50);
        ButtonMedium.setOnAction((ActionEvent ae) ->
                        System.out.println("This feature does not yet exist :)")
                /*controller.openNewStage(name.getText(), school.getText(), radioGroup, root, startStage)); */
        );

        Button ButtonHard = new Button("Heavy Attack");
        ButtonHard.getStyleClass().add("hard_button");
        ButtonHard.setPrefSize(335, 50);
        ButtonHard.setOnAction((ActionEvent ae) ->
                        System.out.println("This feature does not yet exist :)")
                /*controller.openNewStage(name.getText(), school.getText(), radioGroup, root, startStage)); */
        );

        bottomPane.getChildren().addAll(ButtonEasy, ButtonMedium, ButtonHard);


        root.setBottom(bottomPane);




    }



}