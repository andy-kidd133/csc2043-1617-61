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


    private static String[] cardNames = { "Paintbox"
    };

    private static String[] description = {"paintbox does...."

    };

    private static CardDepartment[] cardDepartments = {CardDepartment.HUMANITITES

    };


    private static Bitmap paintbox= BitmapFactory.decodeResource(context.getResources(), R.drawable.card9);

    private static Bitmap[] cardImages = {paintbox

    };


    public static ArrayList<ActionCard> generateCards(){

        ArrayList<ActionCard> actionCards = new ArrayList<ActionCard>();

        for(int i=0; i < cardNames.length; i++){
            actionCards.add(new ActionCard(cardNames[i], description[i],
                    cardDepartments[i], cardImages[i]));
        }

        return actionCards;
    }





}