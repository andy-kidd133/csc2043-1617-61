package com.example.andrew.ark9studios.GameInput;

/**
 * Created by megan on 15/04/2017.
 */

public class GameTouchEvent {


    /**
     * Touch events for the game: these are constant
     */

    public static final int TOUCH_DOWN=0;
    public static final int TOUCH_UP=1;
    public static final int TOUCH_DRAGGED=2;


    /**
     * The type of touch event that has occured
     * Touch down, up or dragged
     */

    public int typeOfTouchEvent;


    /**
     * the position on the screen at which the touch event occured
     */

    public float x;
    public float y;


    /**
     * The pointer ID associated with the touch event
     */

    public int pointer_ID;












}
