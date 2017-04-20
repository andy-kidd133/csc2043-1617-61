package com.example.andrew.ark9studios.GameInput;



import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

import com.example.andrew.ark9studios.utils.Pool;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by megan on 15/04/2017.
 */

public class GameTouchHandler implements OnTouchListener {


//////////////////////////////////////////////////////////
    ///PROPERTIES////
    /////////////////////////////////////////////////////


    /**
     * This is the number of touch events that can be supported
     */
    public static final int MAX_NO_TOUCHPOINTS=10;


    /**
     * the number of touch events and position for the supported number
     */

    private boolean[] existsTouch = new boolean[MAX_NO_TOUCHPOINTS];
    private float touchX[] = new float[MAX_NO_TOUCHPOINTS];
    private float touchY[] = new float[MAX_NO_TOUCHPOINTS];


    /**
     * The Game Touch Event Pool and the list of the current and unconsumed
     * touch events
     */
    private Pool<GameTouchEvent> objPool;
    private List<GameTouchEvent> objTouchEvents = new ArrayList<GameTouchEvent>();
    private List<GameTouchEvent> objUnconsumedTouchEvents = new ArrayList<GameTouchEvent>();


    /**
     * The axis scale values- can be used to scale the input range
     */
    private float objScaleX;
    private float objScaleY;

    /**
     * define the max number of touch events that can be retained in the touch store
     */
    private final int TOUCH_POOL_SIZE=100;




//////////////////////////////////////////////////////////
    ///CONSTRUCTORS////
    /////////////////////////////////////////////////////


  public GameTouchHandler(View view)
  {
      objPool = new Pool<GameTouchEvent>(new Pool.ObjectFactory<GameTouchEvent>(){
          public GameTouchEvent createObject()
          {
              return new GameTouchEvent();
          }


      }, TOUCH_POOL_SIZE);

      view.setOnTouchListener(this);


      objScaleX=1.0f;
      objScaleY=1.0f;

  }


//////////////////////////////////////////////////////////
    ///CONFIG////
    /////////////////////////////////////////////////////


    /**
     * setting the scaling factor that is applied along the x-axis
     * @param scaleX
     */
    public void setScaleX(float scaleX)
    {
        objScaleX = scaleX;
    }

    /**
     * setting the scaling factor that is applied along the y-axis
     * @param scaleY
     */
    public void setObjScaleY(float scaleY)
    {
        objScaleY= scaleY;
    }



//////////////////////////////////////////////////////////
    ///TOUCH EVENTS////
    /////////////////////////////////////////////////////


    @Override
    public boolean onTouch(View v, MotionEvent event) {


        //updating the locations of all occurring touch points
        for(int ptrIdx=0; ptrIdx< event.getPointerCount(); ptrIdx++)
        {
            //update the relevant touch point location
            int pointerID = event.getPointerId(ptrIdx);
            touchX[pointerID] = event.getX(pointerID) * objScaleX;
            touchY[pointerID]= event.getY(pointerID) * objScaleY;
        }

        //extract the details of this event

        int eventType = event.getActionMasked();
        int pointerID = event.getPointerId(event.getActionIndex());


        //retrieve and populate a touch event
        GameTouchEvent gameTouchEvent = objPool.get();
        gameTouchEvent.pointer_ID = pointerID;
        gameTouchEvent.x = touchX[pointerID];
        gameTouchEvent.y = touchY[pointerID];


        switch(eventType)
        {

            case MotionEvent.ACTION_DOWN:
                case MotionEvent.ACTION_POINTER_DOWN:
                    gameTouchEvent.typeOfTouchEvent = GameTouchEvent.TOUCH_DOWN;
                    existsTouch[pointerID] =true;
                    break;

            case MotionEvent.ACTION_MOVE:
                gameTouchEvent.typeOfTouchEvent = GameTouchEvent.TOUCH_DRAGGED;
                existsTouch[pointerID]= false;

            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_POINTER_UP:
                gameTouchEvent.typeOfTouchEvent = GameTouchEvent.TOUCH_UP;
                existsTouch[pointerID] = false;
                break;
        }


      synchronized (this){
          objUnconsumedTouchEvents.add(gameTouchEvent);
      }


        return true;
    }

    /**
     * This determines if the touch event exists for the specified pointer
     * @param pointerID
     * @return - true if there is a touch event, false if there is not
     */
    public boolean existsTouch(int pointerID){

        synchronized (this){
            return existsTouch[pointerID];
        }
    }


    /**
     * Get the (scaled) x- location of the specified pointer ID
     * @param pointerID
     * @return- x- touch location of the specified pointer ID or Float.NAN if
     * the pointer ID does not currently exist
     */
    public float getTouchX(int pointerID){

        synchronized (this){
            //this assumes that the user will ensure correct range checking- for speed
            if(existsTouch[pointerID]){
                return touchX[pointerID];
            }else{
                return Float.NaN;
            }
        }
    }

    /**
     * Get the (scaled) y-location of the specified pointer ID
     *
     * @param pointerId
     * @return y-touch location of the specified pointer ID, or Float.NAN if the
     *         pointer ID does not currently exist
     */
    public float getTouchY(int pointerId)
    {
        synchronized (this)
        {
            // Assumes the user will ensure correct range checking - for speed
            if (existsTouch[pointerId])
                return touchY[pointerId];
            else
                return Float.NaN;
        }
    }




    //////////////////////////////////////////////////////////
    ///EVENT ACCUMULATION////
    /////////////////////////////////////////////////////


    /**
     * Return the list of touch events accumulated for the current frame.
     *
     * @return List of touch events accumulated for the current frame
     */
    public List<GameTouchEvent> getTouchEvents()
    {
        synchronized (this)
        {
            return objTouchEvents;
        }
    }

    /**
     * Reset the accumulator - update the current set of frame touch events to
     * those accumulated since the last time the accumulator was reset.
     *
     * Note: It is assumed that this method will be called once per frame.
     */
    public void resetAccumulator()
    {
        synchronized (this)
        {
            // Release all existing touch events
            int length = objTouchEvents.size();
            for (int i = 0; i < length; i++)
                objPool.add(objTouchEvents.get(i));
            objTouchEvents.clear();
            // Copy across accumulated events
            objTouchEvents.addAll(objUnconsumedTouchEvents);
            objUnconsumedTouchEvents.clear();
        }
    }

    /**
     * Return the list of touch events accumulated for the current frame for a
     * given TouchEvent touchType constant.
     *
     * IMPORTANT: A shared list of touch events is returned. The list should be
     * considered read only.
     *
     * @return List of touch events accumulated for the current frame for a
     *         given touchEventType
     */
    public ArrayList<GameTouchEvent> touchEvents(int touchEventType) {
        synchronized (this) {
            ArrayList<GameTouchEvent> specificTouchEvents = new ArrayList<GameTouchEvent>();
            for (GameTouchEvent touchEvent : objTouchEvents) {
                if (touchEvent.typeOfTouchEvent == touchEventType) {
                    specificTouchEvents.add(touchEvent);
                }
            }
            return specificTouchEvents;
        }
    }


}
