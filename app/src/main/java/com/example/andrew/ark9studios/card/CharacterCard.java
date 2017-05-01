package com.example.andrew.ark9studios.card;

import android.graphics.Bitmap;

import com.example.andrew.ark9studios.Strength;
import com.example.andrew.ark9studios.Weakness;
import com.example.andrew.ark9studios.card.Card;
import com.example.andrew.ark9studios.card.CardDepartment;

/**
 * Created by Andrew on 13/03/2017.
 */

public class CharacterCard extends Card {

    private int health;
    private int attackCost;
    private int attackDamage;
    private CardDepartment cardDepartment;
    private Bitmap cardImage;
    private Strength strength;
    private Weakness weakness;

    public CharacterCard(String name, int health, int attackCost, int attackDamage, CardDepartment cardDepartment, Bitmap cardImg) {
        super(name, cardImg);
        this.health = health;
        this.attackCost = attackCost;
        this.attackDamage = attackDamage;
        this.cardImage = cardImg;
    }


    //accessors

    public int getHealth()
    {

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


    //mutators


    public void setHealth(int health)
    {

        this.health = health;
    }

    public void setAttackCost(int attackCost)
    {
        this.attackCost = attackCost;
    }

    public void setAttackDamage(int attackDamage)
    {
        this.attackDamage = attackDamage;
    }


    //methods

    public void cardAdvance() {
        //when card moves from hand to bench/active
    }

    public void cardRetreat(){
        //moves from active to bench
    }

    public void cardAttack() {


    }

    public void cardDeath() {
        //send it to graveyard
    }

    public void cardEvolve() {
        //if energy is attached basic character card can be evolved into a higher level card
    }
}
