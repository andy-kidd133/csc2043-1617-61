package com.example.andrew.ark9studios;

import android.graphics.Bitmap;
import java.util.ArrayList;

/**
 * Created by Emma on 20/04/2017.
 */

public class ActionCard extends Card {

    private String description;
    private CardDepartment cardDepartment;
    private Bitmap cardImage;

    public ActionCard(String name, String description, CardDepartment cardDepartment, Bitmap cardImg) {
        super(name, cardImg);
        this.cardImage = cardImg;
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

