package View;

import Controller.StageTwoController;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class StageTwo {

    public static Label question;

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
        scene.getStylesheets().add("Resources/stylesheet.css");

        /* creating the health bar */

        VBox topPane= new VBox(10);
        root.setTop(topPane);


        BorderPane centrePane = new BorderPane();
        root.setCenter(centrePane);

        HBox questionSpace = new HBox();
        questionSpace.setPadding(new Insets(30));
        questionSpace.setAlignment(Pos.CENTER);
        question = new Label();
        questionSpace.getChildren().add(question);
        centrePane.setTop(questionSpace);

        HBox answerSpace = new HBox();
        final TextField answer = new TextField();
        Button submitAnswer = new Button("OK");
        answerSpace.setPadding(new Insets(40));
        answerSpace.setAlignment(Pos.CENTER);
        answerSpace.getChildren().add(answer);
        answerSpace.getChildren().add(submitAnswer);
        centrePane.setBottom(answerSpace);

        submitAnswer.setOnAction((ae) -> stc.submitAnswer(answer));

        /* creating the question bar */

        HBox bottomPane = new HBox(10);

        Button ButtonEasy = new Button("Light Attack");
        ButtonEasy.getStyleClass().add("easy_button");
        ButtonEasy.setPrefSize(335, 50);
        ButtonEasy.setOnAction((ActionEvent ae) -> stc.doAttack(1));

        Button ButtonMedium = new Button("Medium Attack");
        ButtonMedium.getStyleClass().add("medium_button");
        ButtonMedium.setPrefSize(335, 50);
        ButtonMedium.setOnAction((ActionEvent ae) -> stc.doAttack(2));

        Button ButtonHard = new Button("Heavy Attack");
        ButtonHard.getStyleClass().add("hard_button");
        ButtonHard.setPrefSize(335, 50);
        ButtonHard.setOnAction((ActionEvent ae) -> stc.doAttack(3));

        bottomPane.getChildren().addAll(ButtonEasy, ButtonMedium, ButtonHard);


        root.setBottom(bottomPane);




    }



}