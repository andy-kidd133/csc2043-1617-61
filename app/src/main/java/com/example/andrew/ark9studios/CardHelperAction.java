package com.example.andrew.ark9studios;

/**
 * Created by Emma on 20/04/2017.
 */
    import android.content.Context;
    import android.content.res.Resources;
    import android.graphics.Bitmap;
    import android.graphics.BitmapFactory;

    import java.util.ArrayList;


/**
 * this class will contain the information for each of the different action cards within the deck
 * and will pass this information into the ArrayList of the action cards in the Deck class
 */

public class CardHelperAction {



    private static Context context;

    public CardHelperAction(Context context){

        this.context = context;
    }


    private static String[] cardNames = {
            "Revive", "HealthRefill", "GrimReaper"
    };


    private static String[] description = {
        "Bring one card back from the graveyard!",
            "Refill one of your Unimon's health",
            "Send one of your opponents Unimon to the graveyard"

    };


    private static Bitmap revive= BitmapFactory.decodeResource(context.getResources(), R.drawable.card3);
    private static Bitmap healthRefill = BitmapFactory.decodeResource(context.getResources(), R.drawable.card8);
    private static Bitmap grimReaper = BitmapFactory.decodeResource(context.getResources(),R.drawable.card13);


    private static Bitmap[] cardImages = {revive, healthRefill, grimReaper

    };


    public static ArrayList<ActionCard> generateCards(){

        ArrayList<ActionCard> actionCards = new ArrayList<ActionCard>();

        for(int i=0; i < cardNames.length; i++){
            actionCards.add(new ActionCard(cardNames[i], description[i],cardImages[i]));
        }

        return actionCards;
    }





}