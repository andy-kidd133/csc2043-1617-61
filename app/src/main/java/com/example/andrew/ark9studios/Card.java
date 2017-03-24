package com.example.andrew.ark9studios;

import android.graphics.Bitmap;

import java.util.ArrayList;

/**
 * Created by Emma and Megan 09/02/2017.
 */

public abstract class Card {


    private String name;
    private Bitmap cardImage;


    //constructor

    public Card(String name, Bitmap cardImg) {
        this.name = name;
        this.cardImage = cardImg;

    }



    public String  getName()
    {
        return name;
    }


    public Bitmap getCardImg()
    {
        return cardImage;

    }

    public void zoomCard() {

    }




}
