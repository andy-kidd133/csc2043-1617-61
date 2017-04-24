package com.example.andrew.ark9studios.highscores;

import java.io.Serializable;

/**
 * Created by Emma on 24/04/2017.
 */

//The score class allows us to be able to make an object - in this case an array list
    //of the type "Score" which will contain the name of the player and their score

public class Score implements Serializable {


    private int score;
    private String name;


    public int getScore() {
        return score;
    }


    public String getName() {
        return name;
    }


    public Score(String name, int score) {
        this.score = score;
        this.name = name;
    }




}
