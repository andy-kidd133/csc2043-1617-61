package com.example.andrew.ark9studios.card;


/**
 * Created by Megan on 20/03/2017.
 *
 */


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;

import com.example.andrew.ark9studios.Game;
import com.example.andrew.ark9studios.R;
import com.example.andrew.ark9studios.Strength;
import com.example.andrew.ark9studios.Weakness;

import java.util.ArrayList;


/**
 * This class will store information for each instance variable  of the character card object and
 * will pass this information into the ArrayList of character cards in the Deck class
 */


public class CardHelper {


    /**
     * Bitmaps for the cards and Draw Rects
     */
    public Bitmap card1Bitmap,card2Bitmap,card3Bitmap,card4Bitmap,card5Bitmap,card6Bitmap;
    public Rect card1Bound,card2Bound,card3Bound,card4Bound,card5Bound,card6Bound;

    public static Context context;
    private Game game;

    public CardHelper(Context context) {
        this.context = context;

    }


    /**
     * the card names
     */
    private static String[] cardNames = {"PainterL1", "PainterL2", "HistoryL1", "HistoryL2", "GeographyL1", "GeographyL2",
            "cScientistL1", "cScientistL2", "sEngineerL1", "sEngineerL2", };

    /**
     * card healths
     */
    private static int[] health = {4, 6, 4, 6, 4, 6, 4, 6, 4, 6,       };

    /**
     * card attack costs
     */
    private static int[] attackCost = {3, 4, 1, 3, 2, 4, 2, 5, 2, 5,     };


    /**
     * card attack damages
     */
    private static int[] attackDamage = {2, 4, 2, 6, 3, 5, 3, 7, 2, 8,         };

    /**
     * card departments
     */
    private static CardDepartment[] cardDepartments = {CardDepartment.ART, CardDepartment.ART, CardDepartment.HUMANITITES,
            CardDepartment.HUMANITITES, CardDepartment.HUMANITITES, CardDepartment.HUMANITITES, CardDepartment.COMPUTING,
            CardDepartment.COMPUTING, CardDepartment.COMPUTING, CardDepartment.COMPUTING,  };


    /**
     * gettings card bitmaps
     */
    private static Bitmap painterL1 = BitmapFactory.decodeResource(context.getResources(), R.drawable.card1);
    private static Bitmap painterL2 = BitmapFactory.decodeResource(context.getResources(), R.drawable.card2);
    private static Bitmap historyL1 = BitmapFactory.decodeResource(context.getResources(), R.drawable.card4);
    private static Bitmap historyL2 = BitmapFactory.decodeResource(context.getResources(), R.drawable.card5);
    private static Bitmap geographyL1 = BitmapFactory.decodeResource(context.getResources(), R.drawable.card6);
    private static Bitmap geographyL2 = BitmapFactory.decodeResource(context.getResources(), R.drawable.card7);


    /**
     * if the card is active
     */
    private static Boolean[] isActive = {false,false,false,false,false,false,false};


    /**
     * energies attached to each card
     */
    private static int [] energiesAttached ={0,0,0,0,0,0,0};

    /**
     * card bitmaps
     */
    private static Bitmap[] cardImages = {painterL1, painterL2, historyL1, historyL2, geographyL1, geographyL2};

    /**
     * card strengths
     */
    private static Strength[] strength = {

    };

    /**
     * card weaknesses
     */
    private static Weakness[] weakness = {

    };

    /**
     * array of character cards
     */
    private ArrayList<CharacterCard> characterCards = new ArrayList<>();


    /**
     * method to generate array of cards
     */
    public void generateCards() {

        for (int i = 0; i < cardNames.length; i++) {
            characterCards.add(new CharacterCard(cardNames[i], health[i], attackCost[i], attackDamage[i],
                    cardDepartments[i], cardImages[i],strength[i], weakness[i], isActive[i],energiesAttached[i]));
        }
    }

    public ArrayList<CharacterCard> getCharacterCards() {
        return characterCards;
    }



    //getters

    public static String[] getCardNames() {
        return cardNames;
    }

    public static int[] getHealth() {
        return health;
    }

    public static int[] getAttackCost() {
        return attackCost;
    }

    public static int[] getAttackDamage() {
        return attackDamage;
    }

    public static CardDepartment[] getCardDepartments() {
        return cardDepartments;
    }

    public static Bitmap getCardImages(int i) {
        return cardImages[i];
    }

    public static Boolean isActive(boolean isActive) { return isActive;}

    public static int[] energiesAttached() {return energiesAttached;}
}