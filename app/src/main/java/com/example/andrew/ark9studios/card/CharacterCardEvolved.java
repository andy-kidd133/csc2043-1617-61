package com.example.andrew.ark9studios.card;

/**
 * Created by Emma on 24/04/2017.
 */

import android.graphics.Bitmap;

import com.example.andrew.ark9studios.Strength;
import com.example.andrew.ark9studios.Weakness;
import com.example.andrew.ark9studios.card.Card;
import com.example.andrew.ark9studios.card.CardDepartment;

/**
 * This class will contain all the evolved versions of the basic character cards
 * it will allow them to be saved in an array in the same position as their basic card
 * without having to add them to the deck so that they cannot be drawn into the hand
 * by using inheritance it makes it easier if wanted to implement extra levels for example
 * level 3 and level 4 cards
 */

public class CharacterCardEvolved extends CharacterCard {


    public CharacterCardEvolved(String name, int health, int attackCost, int attackDamage, CardDepartment cardDepartment, Bitmap cardImg, boolean isActive, int numberEnergiesAttached) {
        super(name, health, attackCost, attackDamage, cardDepartment, cardImg);
    }
}



