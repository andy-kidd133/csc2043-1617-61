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
 * updated by Emma
 */

public class CharacterCard extends Card {

    private int health;
    //how many energy cards have to be attached before you can attack
    private int attackCost;
    //the damage that the attack will do to the other players card
    private int attackDamage;
    private CardDepartment cardDepartment;
    private Bitmap cardImage;
    private Strength strength;
    private Weakness weakness;
    private static final int MAXENERGYCARDSATTACHED = 3;
    private int numberEnergiesAttached;

    public CharacterCard(String name, int health, int attackCost, int attackDamage, CardDepartment cardDepartment,
                         Bitmap cardImg,boolean isActive, int numberEnergiesAttached) {
        super(name, cardImg, isActive);
        this.health = health;
        this.attackCost = attackCost;
        this.attackDamage = attackDamage;
        this.cardImage = cardImg;
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


    public int getAttackDamage()
    {
        return attackDamage;

    }


    public int getNumberEnergiesAttached()
    {
        return numberEnergiesAttached;
    }

    //mutators

    public void setHealth(int health) {

        this.health = health;
    }

    public void setAttackCost(int attackCost) {
        this.attackCost = attackCost;
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
     * evolve will change the card on the screen
     * the level 2 card will be in the same position in the
     * level 2 card arrays as its level 1 card in the normal
     * character card arrays
     */

    public void cardEvolve() {
    if(isActive = true) {
        checkEnergyCardsAttached();
        if (numberEnergiesAttached >= 2) {
            Log.e("QUBTIG", "Card can be evolved");
            //switch card from character card array to level 2 character array


        }else{
            Log.e("QUBTIG","Not enough energy attached to evolve card");


        }
    }
    }

    /**
     * check number of energies attached
     * if num>max number of energies you cant attach
     * error message to tell you that you cant add anymore
/     * else increment the number of energy cards attached
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

