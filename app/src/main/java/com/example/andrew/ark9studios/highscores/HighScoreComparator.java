package com.example.andrew.ark9studios.highscores;

import java.util.Comparator;
/**
 * Created by Emma on 24/04/2017.
 */


// This class will allow us to compare 2 scores (both which are of type Score)

public class HighScoreComparator implements Comparator<Score> {

    public int compare(Score score1, Score score2) {


        int playerscore1 = score1.getScore();

        int playerscore2 = score2.getScore();

        //the following if statement will check whether score 1 is greater than, less than or equal to score 2
        //this will allow us to see wether the score is good enough to make it onto the board
        //-1 means the first score is greater than the 2nd one
        if (playerscore1 > playerscore2) {
            return -1;
            //1 means that the score is smaller
        } else if (playerscore1 < playerscore2) {
            return 1;
            //0 means the scores are equal
        } else {
            return 0;
        }


    }
}