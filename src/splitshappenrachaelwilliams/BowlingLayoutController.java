/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package splitshappenrachaelwilliams;

import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author Rachael
 */
public class BowlingLayoutController implements Initializable {
    
    @FXML
    private Label calculatedScore;
    @FXML
    private TextField rollInput;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        int[] rollsArray = new int[21];
        int score = 0;
        
        //get user input from TextField
        if ((rollInput.getText() != null && !rollInput.getText().isEmpty())){
            String rolls = rollInput.getText();
            System.out.println("Calculating your score!");
            rollsArray = rollsToArray(rolls);
            System.out.println(Arrays.toString(rollsArray));
            
            //apply scoring logic
            BowlingScore gameScore = new BowlingScore(rollsArray);
            score = gameScore.calculateScore();
            
            //print total score to UI
            System.out.println(String.valueOf(score));
            calculatedScore.setText(String.valueOf(score));
        }
        else{
            calculatedScore.setText("no input");
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    public int[] rollsToArray(String rolls) {
        //splits individual rolls
        String[] rollString = rolls.split("");
        int[] rollInt = new int[rollString.length];

        //parse rolls, convert strikes and spares
        //store in array as int
        for (int i = 0; i<rollString.length; i++){
            if (rollString[i].contentEquals("X")){
                rollInt[i] = 10;
            } else if(rollString[i].contentEquals("/")){
                rollInt[i] = (int)(10 - rollInt[i-1]);
            } else if(rollString[i].contentEquals("-")){
                rollInt[i] = 0;
            } else rollInt[i] = Integer.parseInt(rollString[i]);
        }
        return rollInt;
    }
    
}
