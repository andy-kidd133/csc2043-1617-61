package com.example.andrew.ark9studios;

import android.graphics.Bitmap;

/**
 * Created by Andrew on 13/03/2017.
 */

public class EnergyCard extends Card {

    private String description;
    private final int ENERGY_VALUE = 1;

    public EnergyCard(String name, Bitmap bitmap, String description) {
        super(name, bitmap);
        this.description = description;
    }
}
