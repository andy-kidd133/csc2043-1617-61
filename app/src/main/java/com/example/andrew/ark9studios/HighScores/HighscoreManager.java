package com.example.andrew.ark9studios.HighScores;

import java.util.*;
import java.io.*;
/**
 * Created by Emma on 26/04/2017.
 * based on online tutorial
 */

public class HighscoreManager {


        //creating an array of the type "score"
        private ArrayList<Score> scores;

        // name of the file where high score values will be kept
        private static final String HIGHSCORE_FILE = "scores.dat";


        //Initialise an in and output stream for working with a file
        ObjectOutputStream outputStream = null;
        ObjectInputStream inputStream = null;

        public HighscoreManager() {
            //initialising the scores-array list
            scores = new ArrayList<Score>();
        }


        //this will return an arraylist with the scores in it
        public ArrayList<Score> getScores() {
            //load score and sort will ensure you have the scores from the high score file
            // and it will ensure that they are in a sorted order
            loadScoreFile();
            sort();
            return scores;
        }

        public void sort() {
            HighscoreComparator comparator = new HighscoreComparator();
            Collections.sort(scores, comparator);
        }


        //this method loads the scores that are already in the high score file into the scores array list
        //it then adds the new score and updates the high score file with the new scores
        public void addScore(String playerName, int score) {
            loadScoreFile();
            scores.add(new Score(playerName, score));
            updateScoreFile();
        }


        //loads the array list that is in the high score file and will put it in the scores arraylist
        //the try catch just deals with the errors that may occur if program crashes
        public void loadScoreFile() {
            try {
                inputStream = new ObjectInputStream(new FileInputStream(HIGHSCORE_FILE));
                scores = (ArrayList<Score>) inputStream.readObject();
            } catch (FileNotFoundException e) {
                System.out.println("[loadScores] File Not Found Error: " + e.getMessage());
            } catch (IOException e) {
                System.out.println("[loadScores]Input/Output Error: " + e.getMessage());
            } catch (ClassNotFoundException e) {
                System.out.println("[loadScores]Class Not Found Error: " + e.getMessage());
            } finally {
                try {
                    if (outputStream != null) {
                        outputStream.flush();
                        outputStream.close();
                    }
                } catch (IOException e) {
                    System.out.println("[loadScores]Input/Output Error: " + e.getMessage());
                }
            }
        }

        //same idea as load score file only instead of reading it is writing the score arraylist to the file
        public void updateScoreFile() {
            try {
                outputStream = new ObjectOutputStream(new FileOutputStream(HIGHSCORE_FILE));
                outputStream.writeObject(scores);
            } catch (FileNotFoundException e) {
                System.out.println("[updateScores] File Not Found Error: " + e.getMessage() + ", the program will try and make a new file");
            } catch (IOException e) {
                System.out.println("[updateScores] Input/Output Error: " + e.getMessage());
            } finally {
                try {
                    if (outputStream != null) {
                        outputStream.flush();
                        outputStream.close();
                    }
                } catch (IOException e) {
                    System.out.println("[updateScores] Error: " + e.getMessage());
                }
            }
        }


        //set it to show a maximum of 5 high scores on the high score board
        public String getHighscoreString() {
            String highscoreString = "";
            final int max = 5;

            ArrayList<Score> scores;
            scores = getScores();

            int i = 0;
            int x = scores.size();
            if (x > max) {
                x = max;
            }
            while (i < x) {
                highscoreString += (i + 1) + ".\t" + scores.get(i).getName() + "\t\t" + scores.get(i).getScore() + "\n";
                i++;
            }
            return highscoreString;

        }


    }
