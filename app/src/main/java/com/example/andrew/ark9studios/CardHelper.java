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


    private static String[] cardNames = { "PainterLvl1", "PainterLvl2",
            "HistoryLvl1", "HistoryLvl2",
            "GeographyLvl1", "GeographyLvl2",
            "CompSciLvl1","CompSciLvl2",
            "SoftwareEngineerLvl1","SoftwareEngineerLvl2",
            "ProductDesignerLvl1", "ProductDesignerLvl2",
            "PhotographerLvl1", "PhotographerLvl2",
            "ComputerGameDeveloperLvl1", "ComputerGameDeveloperLvl2",
            "PoliticianLvl1", "PoliticianLvl2"
    };

    private static int[] health = {3,5,2,5,1,4,2,6,3,8,3,5,2,4,3,5,1,4

    };


    private static int[] attackCost = {3,4,1,3,2,4,2,5,2,5,2,4,2,3,1,4,2,5

    };

    private static int[] attackDamage = {2,4,2,6,3,5,3,7,2,8,1,6,3,4,2,4,2,8

    };


    private static CardDepartment[] cardDepartments = {
            CardDepartment.ART,CardDepartment.ART,
            CardDepartment.HUMANITITES, CardDepartment.HUMANITITES,
            CardDepartment.HUMANITITES,CardDepartment.HUMANITITES,
            CardDepartment.COMPUTING, CardDepartment.COMPUTING,
            CardDepartment.COMPUTING,CardDepartment.COMPUTING,
            CardDepartment.ART,CardDepartment.ART,
            CardDepartment.ART, CardDepartment.ART,
            CardDepartment.COMPUTING, CardDepartment.COMPUTING,
            CardDepartment.HUMANITITES, CardDepartment.HUMANITITES

    };

    private static Strength[] strength = {
            Strength.HUMANITIES,Strength.HUMANITIES,
            Strength.COMPUTING, Strength.COMPUTING,
            Strength.COMPUTING,Strength.COMPUTING,
            Strength.ART,Strength.ART,
            Strength.ART, Strength.ART,
            Strength.HUMANITIES,Strength.HUMANITIES,
            Strength.HUMANITIES, Strength.HUMANITIES,
            Strength.ART, Strength.ART,
            Strength.COMPUTING, Strength.COMPUTING

    };

    private static Weakness[] weakness = {
            Weakness.COMPUTING,Weakness.COMPUTING,
            Weakness.ART,Weakness.ART,
            Weakness.ART,Weakness.ART,
            Weakness.HUMANITIES,Weakness.HUMANITIES,
            Weakness.HUMANITIES,Weakness.HUMANITIES,
            Weakness.COMPUTING,Weakness.COMPUTING,
            Weakness.COMPUTING, Weakness.COMPUTING,
            Weakness.HUMANITIES,Weakness.HUMANITIES,
            Weakness.ART, Weakness.ART,

    };


    private static Bitmap painterLvl1= BitmapFactory.decodeResource(context.getResources(), R.drawable.card1);
    private static Bitmap painterLvl2= BitmapFactory.decodeResource(context.getResources(), R.drawable.card2);
    private static Bitmap historyLvl1= BitmapFactory.decodeResource(context.getResources(), R.drawable.card4);
    private static Bitmap historyLvl2= BitmapFactory.decodeResource(context.getResources(), R.drawable.card5);
    private static Bitmap geographyLvl1= BitmapFactory.decodeResource(context.getResources(), R.drawable.card6);
    private static Bitmap geographyLvl2= BitmapFactory.decodeResource(context.getResources(), R.drawable.card7);
    private static Bitmap compSciLvl1= BitmapFactory.decodeResource(context.getResources(), R.drawable.card9);
    private static Bitmap compSciLvl2= BitmapFactory.decodeResource(context.getResources(), R.drawable.card10);
    private static Bitmap softwareEngineerLvl1= BitmapFactory.decodeResource(context.getResources(), R.drawable.card11);
    private static Bitmap softwareEngineerLvl2= BitmapFactory.decodeResource(context.getResources(), R.drawable.card12);
    private static Bitmap productDesignerLvl1= BitmapFactory.decodeResource(context.getResources(), R.drawable.card14);
    private static Bitmap productDesignerLvl2= BitmapFactory.decodeResource(context.getResources(), R.drawable.card15);
    private static Bitmap photographerLvl1= BitmapFactory.decodeResource(context.getResources(), R.drawable.card23);
    private static Bitmap photographerLvl2= BitmapFactory.decodeResource(context.getResources(), R.drawable.card24);
    private static Bitmap compGamesDevLvl1= BitmapFactory.decodeResource(context.getResources(), R.drawable.card25);
    private static Bitmap compGamesDevLvl2= BitmapFactory.decodeResource(context.getResources(), R.drawable.card26);
    private static Bitmap politicianLvl1= BitmapFactory.decodeResource(context.getResources(), R.drawable.card27);
    private static Bitmap politicanLvl2= BitmapFactory.decodeResource(context.getResources(), R.drawable.card28);



    private static Bitmap[] cardImages = {painterLvl1,painterLvl2,
            historyLvl1,historyLvl2,
            geographyLvl1,geographyLvl2,
            compSciLvl1, compSciLvl2,
            softwareEngineerLvl1,softwareEngineerLvl2,
            productDesignerLvl1,productDesignerLvl2,
            photographerLvl1,photographerLvl2,
            compGamesDevLvl1,compGamesDevLvl2,
            politicianLvl1,politicanLvl2

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
