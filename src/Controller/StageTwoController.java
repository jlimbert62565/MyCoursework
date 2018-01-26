package Controller;

import View.StageTwo;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.Optional;
import java.util.Random;

public class StageTwoController {

    public int yourHealth;
    public int enemyHealth;

    public int attackStrength;

    private int firstNumber = 0;
    private int secondNumber = 0;
    private int operator = 0; // 1 +   2 -   3 *
    private String operatorString = "";
    private int answer = 0;

    public StageTwoController() {
        yourHealth = 100;
        enemyHealth = 100;
    }


    // 1 - light
    // 2 - medium
    // 3 - heavy

    public void doAttack(int strength) {

        attackStrength = strength;

        if (operator != 0 || strength < 1 || strength > 3) return;

        Random rnd = new Random(System.currentTimeMillis());

        switch (strength) {
            case 1:
                firstNumber = rnd.nextInt(10) + 1;
                secondNumber = rnd.nextInt(10) + 1;
                operator = rnd.nextInt(2) + 1;
                break;
            case 2:
                firstNumber = rnd.nextInt(10) + 1;
                secondNumber = rnd.nextInt(10) + 1;
                operator = rnd.nextInt(3) + 1;
                break;
            case 3:
                firstNumber = rnd.nextInt(20) + 1;
                secondNumber = rnd.nextInt(20) + 1;
                operator = rnd.nextInt(3) + 1;
                break;
        }

        switch (operator) {
            case 1:
                operatorString = "+";
                answer = firstNumber + secondNumber;
                break;
            case 2:
                operatorString = "-";
                answer = firstNumber - secondNumber;
                break;
            case 3:
                operatorString = "*";
                answer = firstNumber * secondNumber;
                break;
        }

        System.out.println("What is " + firstNumber + " " + operatorString + " " + secondNumber + "?     ANSWER: " + answer);

        StageTwo.question.setText("What is " + firstNumber + " " + operatorString + " " + secondNumber + "?");


    }

    public void submitAnswer(TextField answer, Stage stage) {

        if (answer.getText().equals(Integer.toString(this.answer))) {

            enemyHealth -= attackStrength * 10;
            if (enemyHealth <= 0) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("RESULT");
                alert.setHeaderText("You have won!");
                alert.setContentText("And made it out with " + yourHealth + " health remaining!");

                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK) {
                    stage.close();
                }
            }
            StageTwo.enemyBar.setWidth(3 * enemyHealth);

            answer.setText("");
            StageTwo.question.setText("");
            operator = 0;
        } else {

            StageTwo.healthBar.setWidth(3 * yourHealth);
            yourHealth -= 10;
            if (yourHealth <= 0) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("RESULT");
                alert.setHeaderText("You have died");
                alert.setContentText("But managed to take the enemy down to " + enemyHealth);

                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK) {
                    stage.close();
                }

            }

        }
    }


    public void closeStage(Pane parent) {

        parent.setDisable(false);
    }
}


