package com.example.andrew.ark9studios.card;

import android.graphics.Bitmap;
import android.graphics.Rect;

import com.example.andrew.ark9studios.BoundingBox;
import com.example.andrew.ark9studios.Vector2;

/**
 * Created by Emma and Megan 09/02/2017.
 */
/*
    Updated by Emma and Andrew 13/4/17
 */
public abstract class Card{


    private String name;                                    //name of the card
    private Bitmap cardBackground;                          //generic card background
    protected Bitmap cardImage;                             //bitmap used to identify card
    public Vector2 position = new Vector2();                //position of this card
    protected BoundingBox Bound = new BoundingBox();        //bounding box for this card

    protected Rect drawSourceRect = new Rect();             //reusable rectangles to draw card
    protected Rect DrawScreenRect = new Rect();

    private static int cardWidth = 75;
    private static int cardHeight = 150;


    //constructor

    public Card(String name, Bitmap cardImg) {
        this.name = name;
        this.cardImage = cardImg;

    }

    /////////////////////////////////////////////////////////////////////
    // methods
    /////////////////////////////////////////////////////////////////////

    public BoundingBox getBound() {
        Bound.x = position.x;
        Bound.y = position.y;
        return Bound;
    }

    public String  getName()
    {
        return name;
    }

    public Bitmap getCardImg(Bitmap bitmap)
    {
        return cardImage;

    }


    /*public void dragCard(final Bitmap cardImage)
    {
        cardImage.setOnTouchListener(new View.OnTouchListener() {


                switch (motionEvent.getAction())
                {
                    case MotionEvent.ACTION_DOWN:
                        break;
                    case MotionEvent.ACTION_MOVE:

                        int x_cord = (int) motionEvent.getRawX();
                        int y_cord = (int) motionEvent.getRawY();

                        if (x_cord > width) {x_cord = width;}
                        if (y_cord > height) {y_cord = height;}

                        layoutParams.leftMargin = x_cord -25;
                        layoutParams.topMargin = y_cord -75;

                        cardImage.setLayoutParams(layoutParams);
                        break;

                    default:
                        break;
                }
                return true;
        });
    }*/

    public void zoomCard() {

    }

    //only active card can attack opponents card
    public void attack(){



    }

    //taking a card back from bench to hand or active to bench
    public void retreat() {

    }

    //moving the card from the hand to bench or bench to active
    public void advance(){

    }

    //when a card is defeated or user can choose to send card to graveyard
    public void sendToGraveyard(){


    }


}
