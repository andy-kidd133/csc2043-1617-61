package com.example.andrew.ark9studios;

import android.graphics.Bitmap;
import android.support.v4.view.MotionEventCompat;
import android.view.MotionEvent;

import java.util.ArrayList;

import static android.view.MotionEvent.INVALID_POINTER_ID;

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

    public void dragCard()
    {

    }

    public void zoomCard() {

    }




}
