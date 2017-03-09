package com.example.andrew.ark9studios;


import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by megan on 02/03/2017.
 */

public class Deck {

    private boolean deckEmpty = true;

    private static final int SIZEOFDECK=7;

    private ArrayList<Card> playersDeck = new ArrayList<>();

    //methods for the deck class


    public void shuffle(){
        Collections.shuffle(playersDeck);
    }

    public void addCardsToDeck(){}


    public void createAIDeck(){}





    public boolean setUpDeck(){
        return deckEmpty;
    }




    public boolean  isDeckEmpty(){
        return deckEmpty;
    }


    public int getSizeofdeck()
    {
        return playersDeck.size();
    }















}
