package com.example.andrew.ark9studios.card;

import android.graphics.Bitmap;

/**
 * Created by Andrew on 13/03/2017.
 */


public class ActionCard extends Card {

    private String description;

    public ActionCard(String name, String description, Bitmap cardImage) {
        super(name);
        this.description = description;
    }
}

