package com.example.andrew.ark9studios;

import android.graphics.Bitmap;

/**
 * Created by Emma and Megan 09/02/2017.
 */

public abstract class Card {
    private String name;
    private Bitmap cardImage;
    private int health;
    private String cardDescription;
    private CardDepartment cardDeparment;
    private CardLevel cardLevel;

    public Card(String name, int health, String cardDescription,
                CardDepartment cardDeparment, CardLevel cardLevel, float posX, float posY) {
        this.name = name;
        this.health = health;
        this.cardDescription = cardDescription;
        this.cardDeparment = cardDeparment;
        this.cardLevel = cardLevel;
    }




}
