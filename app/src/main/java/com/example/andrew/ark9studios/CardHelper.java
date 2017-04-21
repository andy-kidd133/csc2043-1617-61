package com.example.andrew.ark9studios;

/**
 * Created by Megan on 20/03/2017.
 * updated by Emma 21/4/17
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


    private static String[] cardNames = { "PainterLvl1", "PainterLvl2", "HistoryLvl1", "HistoryLvl2", "GeographyLvl1",
            "GeographyLvl2", "CompSciLvl1","CompSciLvl2","SoftwareEngineerLvl1","SoftwareEngineerLvl2","ProductDesignerLvl1",
            "ProductDesignerLvl2"
    };

    private static int[] health = {3,5,2,5,1,4,2,6,3,8,3,5

    };


    private static int[] attackCost = {3,4,1,3,2,4,2,5,2,5,2,4

    };

    private static int[] attackDamage = {2,4,2,6,3,5,3,7,2,8,1,6

    };


    private static CardDepartment[] cardDepartments = {CardDepartment.ART,CardDepartment.ART, CardDepartment.HUMANITITES,
            CardDepartment.HUMANITITES,CardDepartment.HUMANITITES,CardDepartment.HUMANITITES,
            CardDepartment.COMPUTING, CardDepartment.COMPUTING,CardDepartment.COMPUTING,CardDepartment.COMPUTING,
            CardDepartment.ART,CardDepartment.ART,

    };

    private static Strength[] strength = {Strength.HUMANITIES,Strength.HUMANITIES,Strength.COMPUTING,
            Strength.COMPUTING,Strength.COMPUTING,Strength.COMPUTING, Strength.ART,Strength.ART,Strength.ART
            Strength.ART,Strength.HUMANITIES,Strength.HUMANITIES

    };

    private static Weakness[] weakness = {Weakness.COMPUTING,Weakness.COMPUTING, Weakness.ART,Weakness.ART,
            Weakness.ART,Weakness.ART,Weakness.HUMANITIES,Weakness.HUMANITIES,Weakness.HUMANITIES,Weakness.HUMANITIES,
            Weakness.COMPUTING,Weakness.COMPUTING

    };


    private static Bitmap historyLvl1= BitmapFactory.decodeResource(context.getResources(), R.drawable.card4);


    private static Bitmap[] cardImages = {historyLvl1,

    };


    public static ArrayList<CharacterCard> generateCards(){

        ArrayList<CharacterCard> characterCards = new ArrayList<CharacterCard>();

        for(int i=0; i < cardNames.length; i++){
            characterCards.add(new CharacterCard(cardNames[i], health[i], attackCost[i], attackDamage[i],
                    cardDepartments[i], strength[i], weakness[i], cardImages[i]));
        }

        return characterCards;
    }


}
