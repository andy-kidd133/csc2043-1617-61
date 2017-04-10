package com.example.andrew.ark9studios;


import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by megan on 02/03/2017.
 */

public class Deck {

    private boolean deckEmpty = true;
    private Rect deckRect;
    private static final int SIZEOFDECK=3;
    private ArrayList<CharacterCard> player1Deck;

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
