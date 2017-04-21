package com.example.andrew.ark9studios;

import android.graphics.Bitmap;

import java.util.ArrayList;

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

    public CharacterCard(String name, int health, int attackCost, int attackDamage, CardDepartment cardDepartment,
                         Strength strength, Weakness weakness, Bitmap cardImg) {
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
}
