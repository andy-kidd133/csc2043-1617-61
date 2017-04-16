package com.example.andrew.ark9studios.GameInput;

import android.content.Context;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by megan on 16/04/2017.
 */

public class Input {


    /**
     * defines the different handlers that are responsible for managing the
     * different types of input
     */
    private GameTouchHandler gameTouchHandler;


    /**
     * creating a new input for the specified content view
     * @param context- content within which this handler will operate
     * @param view- view that this handler will collect input from
     */
    public Input(Context context, View view)

    {
        this.gameTouchHandler = new GameTouchHandler(view);
    }

    /**
     * Determines if there is an ongoing touch event for the pointer id that is
     * specified
     *
     * @param pointerID
     *            Touch pointer ID to test for
     * @return true if there is an ongoing touch event, otherwise false
     */

    public boolean existsTouch(int pointerID){
        return gameTouchHandler.existsTouch(pointerID);
    }


    /***
     *
     * This method returns the touch events that exist for a given type of
     * touch for the current frame
     * @param touchEventType
     *            - GameTouchEvent touchType constant
     * @return a list of touch events that exist for that touch type
     */
    public ArrayList<GameTouchEvent> touchEventsFor(int touchEventType) {
        return gameTouchHandler.touchEvents(touchEventType);
    }

    /**
     * Get the x-coordinate for the pointer ID specified
     *
     * A value of Float.NaN is returned if the pointer ID does not exist
     *
     * @param pointerId
     *            Touch pointer ID to retrieve
     * @return x touch location
     */
    public float getTouchX(int pointerId) {
        return gameTouchHandler.getTouchX(pointerId);
    }

    /**
     * Get the y-coordinate for  the pointer ID specified
     *
     * A value of Float.NaN is returned if the pointer ID does not exist
     *
     * @param pointerId
     *            Touch pointer ID to retrieve
     * @return y touch location
     */
    public float getTouchY(int pointerId) {
        return gameTouchHandler.getTouchY(pointerId);
    }

    /**
     * returns a list of the touch events that occurs for this update tick
     * Return a list of captured touch events occurring for this update tick.
     *
     * @return List of touch events
     */
    public List<GameTouchEvent> getTouchEvents() {
        return gameTouchHandler.getTouchEvents();
    }

    /***
     * setter that allows to change the underlying game touch handler
     *
     * @param touchHandler
     *            - gameTouchHandler to be used for handling touch events
     */
    public void setTouchHandler(GameTouchHandler touchHandler) {
        this.gameTouchHandler = touchHandler;
    }

    /**
     * Resets the touch  accumulators so that al touch events will accumulate
     * since the last accumulator reset are now returned through the
     * getTouchEvents()
     *
     * This method should be invoked once per update tick (ideally as part the
     * standard game loop's update actions).
     */
    public void resetAccumulators() {
        gameTouchHandler.resetAccumulator();
    }



}
