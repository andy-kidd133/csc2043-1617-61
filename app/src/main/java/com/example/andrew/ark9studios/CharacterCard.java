package com.example.andrew.ark9studios;

/**
 * Created by Andrew on 13/03/2017.
 */

public class CharacterCard extends Card {

    private int health;
    private int attackCost;
    private int attackDamage;
    private CardDepartment cardDepartment;

    public CharacterCard(String name, float posX, float posY, int health, int attackCost, int attackDamage, CardDepartment cardDepartment) {
        super(name, posX, posY);
        this.health = health;
        this.attackCost = attackCost;
        this.attackDamage = attackDamage;
    }

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
