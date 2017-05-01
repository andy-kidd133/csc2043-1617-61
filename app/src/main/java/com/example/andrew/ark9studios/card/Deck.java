package com.example.andrew.ark9studios.card;




import android.graphics.Bitmap;
import android.graphics.Rect;


import com.example.andrew.ark9studios.ActionCard;
import com.example.andrew.ark9studios.Game;

import java.util.ArrayList;
import java.util.Collections;



/**
 * Created by megan on 02/03/2017.
 * updated by Emma 20/4/17
 */

public class Deck {

    private boolean deckEmpty = true;
    private Rect deckRect;
    private ArrayList<ActionCard> actionPile = new ArrayList<>();
    private ArrayList<EnergyCard> energyPile = new ArrayList<>();

    CardHelper cardHelper;

    private ArrayList<Card> deckP1 = new ArrayList<>();

    private Game game;

    //method used to gather all the generated character cards in an ArrayList

    private ArrayList<CharacterCard> characterPile = new ArrayList<>();

    public Deck() {
        super();
    }


    public void createCharacterPile(){

        cardHelper.generateCards();
        characterPile.addAll(cardHelper.getCharacterCards());

    }

    //method used to gather all the generated action cards in an ArrayList

    /*public ArrayList<ActionCard> createActionPile(){
        actionPile = CardHelperAction.generateCards();
        return actionPile;
    }*/

    //method used to gather all the generated energy cards in an ArrayList

    /*public ArrayList<EnergyCard> createEnergyPile(){
        energyPile = CardHelperEnergy.generateCards();
        return energyPile;
    }*/

    public void shuffle()
    {
        Collections.shuffle(deckP1);
    }

    //method used to gather all the cards from each of the piles and generate a playable, shuffled deck

    public ArrayList<Card> setUpDeck(){

        createCharacterPile();
        //createActionPile();
        //createEnergyPile();

        deckP1.addAll(characterPile);
        //deckP1.addAll(actionPile);
        //deckP1.addAll(energyPile);

        shuffle();

        deckEmpty = false;

        return deckP1;
    }

    public ArrayList<Card> getDeck() {
        return deckP1;
    }

    public boolean  isDeckEmpty(){
        return deckEmpty;
    }


    public int getSizeofdeck()
    {
        return deckP1.size();
    }


    public Bitmap getCardImage(Bitmap[] cardImages) {


        return null;
    }
}
