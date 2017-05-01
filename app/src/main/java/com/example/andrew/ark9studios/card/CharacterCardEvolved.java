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
 */

public class CharacterCardEvolved extends Card {


        private int health;
        private int attackCost;
        private int attackDamage;
        private CardDepartment cardDepartment;
        private Bitmap cardImage;
        private Strength strength;
        private Weakness weakness;

        public CharacterCardEvolved(String name, int health, int attackCost,
        int attackDamage, CardDepartment cardDepartment,
                Strength strength, Weakness weakness, Bitmap cardImg){
            super(name, cardImg);
            this.health = health;
            this.attackCost = attackCost;
            this.attackDamage = attackDamage;
            this.cardImage = cardImg;
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


    //methods
    public void cardAdvance() {
        //when card moves from hand to bench/active
    }
    public void cardRetreat() {
        //moves from active to bench
    }
    public void cardAttack() {
    }
    public void cardDeath() {
        //send it to graveyard
    }


}



