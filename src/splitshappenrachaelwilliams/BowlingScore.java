/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package splitshappenrachaelwilliams;

/**
 *
 * @author Rachael
 */
public class BowlingScore {

    private int[] rollsArray;
    
    BowlingScore(){};
    BowlingScore(int[] rollsArray){
        this.rollsArray = rollsArray;
    }
    
    public int calculateScore(){
        int rollIndex = 0;
        int score = 0;
        
        //calculate scores for first 9 frames
        for (int frame = 0; frame<9; frame++){
            if (rolledStrike(rollIndex)){
                score += 10 + strikeExtra(rollIndex);
                rollIndex++;
            } else if (rolledSpare(rollIndex)){
                score += 10 + spareExtra(rollIndex);
                rollIndex += 2;
            } else {
                score += rollsArray[rollIndex] + rollsArray[rollIndex + 1];
                rollIndex += 2;
            }
        }
        //adds score for 10th frame
        return score + scoreLastFrame(rollIndex);
    }

    //checks the last frame for strike or spare
    //allows for bonus rolls in these cases
    private int scoreLastFrame(int rollIndex) {
        int frameScore = 0;
        if (rollsArray[rollIndex] == 10){
            frameScore += 10 + rollsArray[rollIndex + 1] + rollsArray[rollIndex + 2];
        } else if (rollsArray[rollIndex] + rollsArray[rollIndex + 1] == 10){
            frameScore += 10 + rollsArray[rollIndex + 2];
        } else{
            frameScore += rollsArray[rollIndex] + rollsArray[rollIndex + 1];
        }
        return frameScore;
    }

    //checks for strike
    private boolean rolledStrike(int rollIndex) {
        return rollsArray[rollIndex] == 10;
    }

    //calculates strike bonus points
    private int strikeExtra(int rollIndex) {
        return rollsArray[rollIndex + 1] + rollsArray[rollIndex + 2];
    }

    //checks for spare
    private boolean rolledSpare(int rollIndex) {
        return rollsArray[rollIndex] + rollsArray[rollIndex + 1] == 10;
    }

    //calculates spare bonus points
    private int spareExtra(int rollIndex) {
        return rollsArray[rollIndex + 2];
    }
}
