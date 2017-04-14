package com.example.andrew.ark9studios;

import android.graphics.Bitmap;
import android.graphics.Rect;

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

    public Bitmap getCardImg()
    {
        return cardImage;

    }

    /*
    public void dragCard(final Bitmap cardImage)
    {
        cardImage.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) cardImage.getLayoutParams();

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
            }
        });
    }*/

    public void zoomCard() {

    }

}
