package Controller;

import View.StageTwo;
import javafx.scene.control.Alert;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MainController {

    public void openNewStage(String name, String school, ToggleGroup shapeChoice, Pane parent, Stage startStage) {

        String shape = ((RadioButton) shapeChoice.getSelectedToggle()).getText().replace("Choose ", "");

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText("Your choices...");
        alert.setContentText("Name: " + name + " School: " + school + " Shape: " + shape);
        alert.showAndWait();



        StageTwo newStage = new StageTwo(parent);
        startStage.close();

    }

}
