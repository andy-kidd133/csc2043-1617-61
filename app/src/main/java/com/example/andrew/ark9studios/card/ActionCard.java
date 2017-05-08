package com.example.andrew.ark9studios.card;
import android.graphics.Bitmap;

import java.util.ArrayList;

/**
 * Created by Emma on 20/04/2017.
 */

public class ActionCard extends Card {


        private String description;

        private Bitmap cardImage;

    public ActionCard(String name, Bitmap cardImg, boolean isActive, String description) {
        super(name, cardImg, isActive);
    }
}




