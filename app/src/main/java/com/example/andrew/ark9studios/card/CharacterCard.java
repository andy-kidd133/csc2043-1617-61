package com.example.andrew.ark9studios.card;

import android.graphics.Bitmap;
import android.util.Log;
import android.widget.Toast;

import com.example.andrew.ark9studios.Strength;
import com.example.andrew.ark9studios.Weakness;
import com.example.andrew.ark9studios.card.Card;
import com.example.andrew.ark9studios.card.CardDepartment;

/**
 * Created by Andrew on 13/03/2017.
 */

public abstract class CharacterCard extends Card {

    private int health;
    private int attackCost;
    private int attackDamage;
    private CardDepartment cardDepartment;
    private Bitmap cardImage;
    private Strength strength;
    private Weakness weakness;
    private boolean isActive;
    private static final int MAXENERGYCARDSATTACHED = 3;
    private int numberEnergiesAttached;

    public CharacterCard(String name, int health, int attackCost, int attackDamage, CardDepartment cardDepartment,
                         Bitmap cardImg, boolean isActive, int numberEnergiesAttached) {
        super(name, cardImg);
        this.health = health;
        this.attackCost = attackCost;
        this.attackDamage = attackDamage;
        this.cardImage = cardImg;
        //every card should be inactive unless made active
        this.isActive = false;
        this.numberEnergiesAttached = 0;
    }


    //accessors

    public int getHealth() {

        return health;
    }


    public int getAttackCost()

    {
        return attackCost;
    }


    public int getAttackDamage() {
        return attackDamage;

    }

    public boolean isActive() {
        return isActive;
    }

    public int getNumberEnergiesAttached() {
        return numberEnergiesAttached;
    }
    //mutators


    public void setHealth(int health) {

        this.health = health;
    }

    public void setAttackCost(int attackCost) {
        this.attackCost = attackCost;
    }

    public void isActive(boolean isActive) {

        this.isActive = isActive;
    }


    public void setAttackDamage(int attackDamage) {
        this.attackDamage = attackDamage;
    }

    public void setNumberEnergiesAttached(int numberEnergiesAttached) {
        this.numberEnergiesAttached = numberEnergiesAttached;
    }

    /**if energy is attached basic character card can be evolved into a higher level card
     **   only applies to a level 1 character card
     **  position of evolved card will be the same position in its array
     **   as the basic level 1 card and when evolved will change from the original level 1 card
     ** to the level 2 card from the other array
     **/


    /**
     * first check if that card is active
     * if not advance it and retreat active card
     * then check if there is enough energy attached to evolve
     */

    public void cardEvolve() {

        checkEnergyCardsAttached();
        if(numberEnergiesAttached>=2){


        }

    }

    /**
     * check number of energies attached
     * if num>max number of energies you cant attach
     * error message to tell you that you cant add anymore
     * else increment the number of energy cards attached
     * message saying another energy card has been attached
     * return number of energies attached
     */
    public int checkEnergyCardsAttached() {
        if (numberEnergiesAttached > MAXENERGYCARDSATTACHED) {
            Log.e("QUBTIG", "You cannot attach any more energy cards");
        }
        else {
            numberEnergiesAttached++;
            Log.e("QUBTIG", "Energy card attached");
        }
        return numberEnergiesAttached;
    }


}

