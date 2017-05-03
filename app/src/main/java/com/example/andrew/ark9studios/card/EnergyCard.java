package com.example.andrew.ark9studios.card;

import android.graphics.Bitmap;

import com.example.andrew.ark9studios.card.Card;
import com.example.andrew.ark9studios.card.CardDepartment;

/**
 * Created by Andrew on 13/03/2017.
 * Updated by Emma 20/04/2017
 *
 **/

public class EnergyCard extends Card {

    private String description;
    private CardDepartment cardDepartment;
    private final int ENERGY_VALUE = 1;

    public EnergyCard(String name, Bitmap cardImage, CardDepartment cardDepartment, String description, boolean isActive) {
        super(name, cardImage, isActive);
        this.description = description;
    }


}

