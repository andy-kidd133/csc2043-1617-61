package com.example.andrew.ark9studios.card;

/**
 * Created by Emma on 20/04/2017.
 */
    import android.content.Context;
    import android.content.res.Resources;
    import android.graphics.Bitmap;
    import android.graphics.BitmapFactory;

    import com.example.andrew.ark9studios.R;

    import java.util.ArrayList;


/**
 * this class will contain the information for each of the different action cards within the deck
 * and will pass this information into the ArrayList of the action cards in the Deck class
 **/


public class CardHelperAction {


    private static Context context;

    public CardHelperAction(Context context){

        this.context = context;
    }


    private static String[] cardNames = {
            "Revive", "HealthRefill", "GrimReaper", "LoseATurn"
    };


    private static String[] description = {
        "Bring one card back from the graveyard!",
            "Refill one of your Unimon's health",
            "Send one of your opponents Unimon to the graveyard",
            "Use this card and your opponent will miss a go"

    };


    private static Bitmap revive= BitmapFactory.decodeResource(context.getResources(), R.drawable.card3);
    private static Bitmap healthRefill = BitmapFactory.decodeResource(context.getResources(), R.drawable.card8);
    private static Bitmap grimReaper = BitmapFactory.decodeResource(context.getResources(), R.drawable.card13);
    private static Bitmap loseATurn = BitmapFactory.decodeResource(context.getResources(),R.drawable.card19);


    private static Bitmap[] cardImages = {revive, healthRefill, grimReaper, loseATurn

    };


    private ArrayList<ActionCard> actionCards = new ArrayList<>();


    public void generateCards() {

        for (int i = 0; i < cardNames.length; i++) {
            actionCards.add(new ActionCard(cardNames[i], description[i], cardImages[i]));
        }
    }

    public ArrayList<ActionCard> getActionCards() {
        return actionCards;
    }

}
