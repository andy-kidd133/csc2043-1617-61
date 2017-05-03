package com.example.andrew.ark9studios.card;
import android.graphics.Bitmap;

import java.util.ArrayList;

/**
 * Created by Emma on 20/04/2017.
 */

public class ActionCard extends Card {


        private String description;
        private CardDepartment cardDepartment;
        private Bitmap cardImage;

        public ActionCard(String name, String description, CardDepartment cardDepartment, Bitmap cardImg, boolean isActive) {
            super(name, cardImg, isActive);
            this.cardImage = cardImg;
        }

    }


