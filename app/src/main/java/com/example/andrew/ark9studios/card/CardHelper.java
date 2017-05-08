package com.example.andrew.ark9studios.card;


/**
 * Created by Megan on 20/03/2017.
 */


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;

import com.example.andrew.ark9studios.Game;
import com.example.andrew.ark9studios.R;

import java.util.ArrayList;


/**
 * This class will store information for each instance variable  of the character card object and
 * will pass this information into the ArrayList of character cards in the Deck class
 */


public class CardHelper {
    public Bitmap card1Bitmap,card2Bitmap,card3Bitmap,card4Bitmap,card5Bitmap,card6Bitmap;
    public Rect card1Bound,card2Bound,card3Bound,card4Bound,card5Bound,card6Bound;
    public static Context context;
    private Game game;
    public CardHelper(Context context) {
        this.context = context;
    }
    private static String[] cardNames = {"PainterL1", "PainterL2", "HistoryL1", "HistoryL2", "GeographyL1", "GeographyL2",
            "cScientistL1", "cScientistL2", "sEngineerL1", "sEngineerL2", };
    private static int[] health = {4, 6, 4, 6, 4, 6, 4, 6, 4, 6,       };
    private static int[] attackCost = {3, 4, 1, 3, 2, 4, 2, 5, 2, 5,     };
    private static int[] attackDamage = {2, 4, 2, 6, 3, 5, 3, 7, 2, 8,         };
    private static CardDepartment[] cardDepartments = {CardDepartment.ART, CardDepartment.ART, CardDepartment.HUMANITITES,
            CardDepartment.HUMANITITES, CardDepartment.HUMANITITES, CardDepartment.HUMANITITES, CardDepartment.COMPUTING,
            CardDepartment.COMPUTING, CardDepartment.COMPUTING, CardDepartment.COMPUTING,  };
    private static Bitmap painterL1 = BitmapFactory.decodeResource(context.getResources(), R.drawable.card1);
    private static Bitmap painterL2 = BitmapFactory.decodeResource(context.getResources(), R.drawable.card2);
    private static Bitmap historyL1 = BitmapFactory.decodeResource(context.getResources(), R.drawable.card4);
    private static Bitmap historyL2 = BitmapFactory.decodeResource(context.getResources(), R.drawable.card5);
    private static Bitmap geographyL1 = BitmapFactory.decodeResource(context.getResources(), R.drawable.card6);
    private static Bitmap geographyL2 = BitmapFactory.decodeResource(context.getResources(), R.drawable.card7);
    private static Bitmap[] cardImages = {painterL1, painterL2, historyL1, historyL2, geographyL1, geographyL2};
    private static boolean[] isActive= {};
    private static int[] numberOfEnergies= {};
    private ArrayList<CharacterCard> characterCards = new ArrayList<>();

    public void generateCards() {
        for (int i = 0; i < cardNames.length; i++) {
            characterCards.add(new CharacterCard(cardNames[i], health[i], attackCost[i], attackDamage[i],
                    cardDepartments[i], cardImages[i],isActive[i], numberOfEnergies[i]));
        }
    }
    public ArrayList<CharacterCard> getCharacterCards() {
        return characterCards;
    }
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
}