package com.example.andrew.ark9studios.card;

import android.graphics.Bitmap;

/**
 * Created by Andrew on 13/03/2017.
 */


public class ActionCard extends Card {
    private String description;
    private CardDepartment cardDepartment;
    private Bitmap cardImage;
    public ActionCard(String name, String description, CardDepartment cardDepartment, Bitmap cardImg, boolean isActive) {
        super(name, cardImg, isActive);
        this.cardImage = cardImg;
    }
}

