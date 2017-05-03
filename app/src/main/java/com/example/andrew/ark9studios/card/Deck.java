package com.example.andrew.ark9studios.card;
import android.content.Context;
import android.graphics.Bitmap;

import com.example.andrew.ark9studios.Game;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Andrew
 */

public class Deck {

    private boolean deckEmpty = true;
    private ArrayList<CharacterCard> characterPile = new ArrayList<>();
    private ArrayList<ActionCard> actionPile = new ArrayList<>();
    private ArrayList<EnergyCard> energyPile = new ArrayList<>();

    private CardHelper cardHelper;
    private CardHelperAction cardHelperAction;
    private CardHelperEnergy cardHelperEnergy;

    private ArrayList<Card> deckP1 = new ArrayList<>();

    private Context context;

    //method used to gather all the generated character cards in an ArrayList

    public Deck() {

        cardHelper = new CardHelper(context);
        cardHelperAction = new CardHelperAction(context);
        cardHelperEnergy = new CardHelperEnergy(context);

    }


    public void createCharacterPile(){

        cardHelper.generateCards();
        characterPile.addAll(cardHelper.getCharacterCards());

    }

    //method used to gather all the generated action cards in an ArrayList

    public void createActionPile(){

        cardHelperAction.generateCards();
        actionPile.addAll(cardHelperAction.getActionCards());

    }

    //method used to gather all the generated energy cards in an ArrayList

    public void createEnergyPile(){

        cardHelperEnergy.generateCards();
        energyPile.addAll(cardHelperEnergy.getEnergyCards());

    }

    public void shuffle()
    {
        Collections.shuffle(deckP1);
    }

    //method used to gather all the cards from each of the piles and generate a playable, shuffled deck

    public ArrayList<Card> setUpDeck(){

        createCharacterPile();
        createActionPile();
        createEnergyPile();

        deckP1.addAll(characterPile);
        deckP1.addAll(actionPile);
        deckP1.addAll(energyPile);

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