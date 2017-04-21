package com.example.andrew.ark9studios.CoreServices;

/**
 * Created by Emma on 21/03/2017.
 */

public class ScoreBoardManager {


        //number of scores to be stored in the high score board
        private final int NUM_HIGH_SCORES = 5;

        //set up array of high scores
        private int highScores[] = new int[NUM_HIGH_SCORES];


    public int[] getHighScores() {
        loadTopScores();
        return highScores;
    }

    private void loadTopScores() {
        //load top 5 scores from array of saved high scores
    }
}




