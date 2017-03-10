package com.example.andrew.ark9studios;

import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by Christopher Burns on 02/03/2017.
 */

//Card_Amount is the amount of cards the user has in their deck
//card is the enum for the cards being stored
//It should only need an array called deck that contains cards and the amount of cards in the array to work

/*
public class ShuffleCard extends Card extends Deck {
    void shuffle(int Card_Amount){
        for(int i = 0; i < Card_Amount; i++){
            //Finds the card at position i
            card Current = Deck[i];

            //Generares a random number to find a random location within the deck
            Random rand = new Random();
            int CardPos = rand.nextInt(Card_Amount) + 0;

            //Copies the card from the random location to a temporary variable
            card Temp = Deck[CardPos];

            //Swaps the position of the two cards
            Deck[CardPos] = Current;
            Deck[i] = Temp;
        }
    }
}*/
