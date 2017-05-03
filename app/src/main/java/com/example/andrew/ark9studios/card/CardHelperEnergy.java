package com.example.andrew.ark9studios.card;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.andrew.ark9studios.R;

import java.util.ArrayList;

/**
 * Created by Emma on 20/04/2017.
 */

/**
 * This class will hold the info for each of the energy cards within the decks and will
 * pass this info into the ArrayList of the energy cards in the Deck class
 */

public class CardHelperEnergy {

        private static Context context;

        public CardHelperEnergy(Context context){

            this.context = context;
        }


        private static String[] cardNames = {
                "PaintKit","Globe", "Computer", "Controller", "Camera", "Scroll"
        };

        private static String[] description = {
                "Power up your Unimon with this professional Paint Kit",
                "Power up your Unimon with this Globe",
                "Power up your Unimon with this Computer",
                "Power up your Unimon with this Controller",
                "Power up your Unimon with this Camera",
            "Power up your Unimon with this Scroll"
        };


    private static CardDepartment[] cardDepartment = {
                CardDepartment.ART,
                CardDepartment.HUMANITITES,
                CardDepartment.COMPUTING,
                CardDepartment.COMPUTING,
                CardDepartment.ART,
                CardDepartment.HUMANITITES
        };



        private static Bitmap paintKit= BitmapFactory.decodeResource(context.getResources(), R.drawable.card1);
        private static Bitmap globe= BitmapFactory.decodeResource(context.getResources(), R.drawable.card2);
        private static Bitmap computer= BitmapFactory.decodeResource(context.getResources(), R.drawable.card3);
        private static Bitmap controller= BitmapFactory.decodeResource(context.getResources(), R.drawable.card4);
        private static Bitmap camera= BitmapFactory.decodeResource(context.getResources(), R.drawable.card5);
        private static Bitmap scroll = BitmapFactory.decodeResource(context.getResources(), R.drawable.card6);



    private static Bitmap[] cardImages = {

                paintKit, globe, computer, controller, camera, scroll

        };


    private ArrayList<EnergyCard> energyCards = new ArrayList<>();

    public void generateCards() {

        for (int i = 0; i < cardNames.length; i++) {
            energyCards.add(new EnergyCard(cardNames[i], description[i], cardDepartment[i], cardImages[i]));
        }
    }

    public ArrayList<EnergyCard> getEnergyCards() {
        return energyCards;
    }
}

