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


    private static String[] cardNames = { "PainterLvl1",
            "HistoryLvl1",
            "GeographyLvl1",
            "CompSciLvl1",
            "SoftwareEngineerLvl1",
            "ProductDesignerLvl1",
            "PhotographerLvl1",
            "ComputerGameDeveloperLvl1",
            "PoliticianLvl1"
    };

    private static int[] health = {3,2,1,2,3,3,2,3,1

    };


    private static int[] attackCost = {3,1,2,2,2,2,2,1,2

    };

    private static int[] attackDamage = {2,2,3,3,2,1,3,2,2

    };


    private static CardDepartment[] cardDepartments = {
            CardDepartment.ART,
            CardDepartment.HUMANITITES,
            CardDepartment.HUMANITITES,
            CardDepartment.COMPUTING,
            CardDepartment.COMPUTING,
            CardDepartment.ART,
            CardDepartment.ART,
            CardDepartment.COMPUTING,
            CardDepartment.HUMANITITES,

    };

    private static Strength[] strength = {
            Strength.HUMANITIES,
            Strength.COMPUTING,
            Strength.COMPUTING,
            Strength.ART,
            Strength.ART,
            Strength.HUMANITIES,
            Strength.HUMANITIES,
            Strength.ART,
            Strength.COMPUTING

    };

    private static Weakness[] weakness = {
            Weakness.COMPUTING,
            Weakness.ART,
            Weakness.ART,
            Weakness.HUMANITIES,
            Weakness.HUMANITIES,
            Weakness.COMPUTING,
            Weakness.COMPUTING,
            Weakness.HUMANITIES,
            Weakness.ART,

    };


    private static Bitmap painterLvl1= BitmapFactory.decodeResource(context.getResources(), R.drawable.card1);
    private static Bitmap historyLvl1= BitmapFactory.decodeResource(context.getResources(), R.drawable.card4);
    private static Bitmap geographyLvl1= BitmapFactory.decodeResource(context.getResources(), R.drawable.card6);
    private static Bitmap compSciLvl1= BitmapFactory.decodeResource(context.getResources(), R.drawable.card9);
    private static Bitmap softwareEngineerLvl1= BitmapFactory.decodeResource(context.getResources(), R.drawable.card11);
    private static Bitmap productDesignerLvl1= BitmapFactory.decodeResource(context.getResources(), R.drawable.card14);
    private static Bitmap photographerLvl1= BitmapFactory.decodeResource(context.getResources(), R.drawable.card23);
    private static Bitmap compGamesDevLvl1= BitmapFactory.decodeResource(context.getResources(), R.drawable.card25);
    private static Bitmap politicianLvl1= BitmapFactory.decodeResource(context.getResources(), R.drawable.card27);



    private static Bitmap[] cardImages = {
            painterLvl1,
            historyLvl1,
            geographyLvl1,
            compSciLvl1,
            softwareEngineerLvl1,
            productDesignerLvl1,
            photographerLvl1,
            compGamesDevLvl1,
            politicianLvl1

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
