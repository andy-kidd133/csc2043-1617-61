package com.example.andrew.ark9studios;

/**
 * Created by Megan on 20/03/2017.
 */


import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.util.ArrayList;

/**
 * This class will store information for each instance variable  of the character card object and
 * will pass this information into the ArrayList of character cards in the Deck class
 */


public class CardHelper {



    private static Context context;

    public CardHelper(Context context){

        this.context = context;
    }


    private static String[] cardNames = { "HistoryLvl1"
    };

    private static int[] health = {8

    };


    private static int[] attackCost = {3

    };

    private static int[] attackDamage = {3

    };


    private static CardDepartment[] cardDepartments = {CardDepartment.HUMANITITES

    };



     private static Bitmap historyLvl1= BitmapFactory.decodeResource(context.getResources(), R.drawable.card5);

    private static Bitmap[] cardImages = {historyLvl1

    };


    public static ArrayList<CharacterCard> generateCards(){

        ArrayList<CharacterCard> characterCards = new ArrayList<CharacterCard>();

        for(int i=0; i < cardNames.length; i++){
            characterCards.add(new CharacterCard(cardNames[i], health[i], attackCost[i], attackDamage[i],
                    cardDepartments[i], cardImages[i]));
        }

        return characterCards;
    }





}
