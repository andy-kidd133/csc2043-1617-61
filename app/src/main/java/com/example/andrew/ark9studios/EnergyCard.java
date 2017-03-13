package com.example.andrew.ark9studios;

/**
 * Created by Andrew on 13/03/2017.
 */

public class EnergyCard extends Card {

    private String description;
    private final int ENERGY_VALUE = 1;

    public EnergyCard(String name, float posX, float posY, String description) {
        super(name, posX, posY);
        this.description = description;
    }
}
