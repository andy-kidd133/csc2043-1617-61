package com.example.andrew.ark9studios;


import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.widget.ImageView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by megan on 02/03/2017.
 * updated by Emma 20/4/17
 */

public class Deck {

    private boolean deckEmpty = true;
    private Rect deckRect;
    private static final int SIZEOFDECK=3;
    private ArrayList<CharacterCard> player1Deck;
    private ArrayList<ActionCard> player2Deck;
    private ArrayList<EnergyCard> player3Deck;


    //constructor
    public Deck() {
        deckRect = null;
    }







    //methods for the deck class


    public void shuffle()
    {
        Collections.shuffle(player1Deck);
    }


    public void addCardsToDeck(ArrayList<CharacterCard> p1Deck){

      p1Deck = CardHelper.generateCards();

    }

    public void addActionCardsToDeck(ArrayList<ActionCard> player2Deck){

        player2Deck = CardHelperAction.generateCards();

    }


    public void addEnergyCardsToDeck(ArrayList<EnergyCard> player3Deck){

        player3Deck = CardHelperEnergy.generateCards();

    }

    public void createAIDeck(){}





    public boolean setUpDeck(){
        return deckEmpty;
    }




    public boolean  isDeckEmpty(){
        return deckEmpty;
    }


    public int getSizeofdeck()
    {
        return player1Deck.size();
    }















}
