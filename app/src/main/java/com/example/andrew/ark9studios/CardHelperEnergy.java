package com.example.andrew.ark9studios;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

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
                "PaintKit","Globe", "Computer"
        };

        private static String[] description = {
                "Power up your Unimon with this professional Paint Kit",
                "Power up your Unimon with this Globe",
                "Power up your Unimon with this Computer"

        };


        private static CardDepartment[] cardDepartment = {
                CardDepartment.ART,
                CardDepartment.HUMANITITES,
                CardDepartment.COMPUTING

        };



        private static Bitmap paintKit= BitmapFactory.decodeResource(context.getResources(), R.drawable.card3);
        private static Bitmap globe= BitmapFactory.decodeResource(context.getResources(), R.drawable.card8);
        private static Bitmap computer= BitmapFactory.decodeResource(context.getResources(), R.drawable.card13);


        private static Bitmap[] cardImages = {

                paintKit, globe, computer
        };


        public static ArrayList<EnergyCard> generateCards(){

            ArrayList<EnergyCard> actionCards = new ArrayList<EnergyCard>();

            for(int i=0; i < cardNames.length; i++){
                actionCards.add(new EnergyCard(cardNames[i], cardImages[i],cardDepartment[i],description[i]));
            }

            return actionCards;
        }


    }
