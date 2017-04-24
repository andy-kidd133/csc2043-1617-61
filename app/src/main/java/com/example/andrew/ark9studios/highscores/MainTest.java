package com.example.andrew.ark9studios.highscores;

/**
 * Created by Emma on 24/04/2017.
 */

//This class will test the code within the highscores package and print out the values below if working

public class MainTest {
    public static void main(String[] args) {
        HighScoreManager highScores = new HighScoreManager();
        highScores.addScore("Emma" ,22);
        highScores.addScore("Andrew",18);

        System.out.print(highScores.getHighscoreString());
    }
}
