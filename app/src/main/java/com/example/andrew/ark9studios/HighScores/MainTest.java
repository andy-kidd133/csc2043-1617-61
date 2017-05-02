package com.example.andrew.ark9studios.HighScores;

/**
 * Created by Emma on 26/04/2017.
 */
//This class will test the code within the highscores package and print out the value below if working
public class MainTest {

        public static void main(String[] args) {
            HighscoreManager highScores = new HighscoreManager();
            highScores.addScore("Emma" ,22);
            highScores.addScore("Andrew",18);
            highScores.addScore("Megan", 21);
            highScores.addScore("Karl",17);
            highScores.addScore("Emily",15);

            System.out.print(highScores.getHighscoreString());
        }
    }
