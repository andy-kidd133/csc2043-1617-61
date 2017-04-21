package com.example.andrew.ark9studios;

import android.graphics.Bitmap;
import android.graphics.Rect;

import com.example.andrew.ark9studios.GameGraphics.Graphics2DInterface;
import com.example.andrew.ark9studios.gameInfrastructure.ElapsedTime;

import viewports.LayerViewport;
import viewports.ScreenViewport;

/**
 * Created by Megan on 21/04/2017.
 */

public class GameObjects {



    protected GameScreen gameScreen;


    public void setGameScreen(GameScreen gameScreen){
        this.gameScreen = gameScreen;
    }

    protected Bitmap bitmap;

    public Vector2 position = new Vector2();

    protected BoundingBox bound = new BoundingBox();

    protected Rect drawRectSource = new Rect();
    protected Rect drawScreenRect = new Rect();



    public Rect getDrawScreenRect(){
        return drawScreenRect;
    }




    public GameObjects(GameScreen gameScreen){
        this.gameScreen = gameScreen;
    }





    public GameObjects(float x, float y, Bitmap bitmap, GameScreen gameScreen){

        this.gameScreen = gameScreen;

        this.position.x = x;
        this.position.y = y;
        this.bitmap = bitmap;


        this.bound.x = x;
        this.bound.y = y;
        this.bound.halfWidth = bitmap.getWidth()/2.0f;
        this.bound.halfHeight = bitmap.getHeight()/2.0f;
    }




    public GameObjects(float x, float y, float width, float height,
                     Bitmap bitmap, GameScreen gameScreen) {
        this.gameScreen = gameScreen;

        this.position.x = x;
        this.position.y = y;
        this.bitmap = bitmap;

        this.bound.x = x;
        this.bound.y = y;
        this.bound.halfWidth = width / 2.0f;
        this.bound.halfHeight = height / 2.0f;
    }



    public GameObjects(float x, float y, float width, float height,
                      Bitmap bitmap, GameScreen gameScreen, Rect drawRectSource) {
        this.gameScreen = gameScreen;

        this.position.x = x;
        this.position.y = y;
        this.bitmap = bitmap;

        this.bound.x = x;
        this.bound.y = y;
        this.bound.halfWidth = width / 2.0f;
        this.bound.halfHeight = height / 2.0f;
        this.drawRectSource = drawRectSource;
    }


    /***
     * Return the bounding box for this game object.
     *
     * Note: The values within the bounding box should not be modified.
     *
     * @return bounding box for this Game Object
     */
    public BoundingBox getBound() {
        // Ensure the bound is centred on the sprite's current location
        this.bound.x = position.x;
        this.bound.y = position.y;
        return bound;
    }



    /**
     * Return the bitmap used for this game object.
     *
     * @return Bitmap associated with this sprite.
     */
    public Bitmap getBitmap() {
        return bitmap;
    }

    /***
     * Mutator to set the bitmap for a given Game Object
     *
     * @param bitmap
     *            - new bitmap to be set
     */
    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    /***
     * Accessor for GameObject current position
     *
     * @return position - (x,y) coordinate of game object position
     */
    public Vector2 getPosition() {
        return position;
    }

    /**
     * Set the position of the game object
     *
     * @param x
     *            x-location of the game object
     * @param y
     *            y-location of the game object
     */
    public void setPosition(float x, float y) {
        this.bound.x = position.x = x;
        this.bound.y = position.y = y;
    }

    /**
     * Update the game object
     *
     * @param elapsedTime
     *            Elapsed time information
     */
    public void update(ElapsedTime elapsedTime) {

    }

    /**
     * Draw the game object
     *
     * @param elapsedTime
     *            Elapsed time information
     * @param graphics2DInterface
     *            Graphics instance
     * @param layerViewport
     *            Game layer viewport
     * @param screenViewport
     *            Screen viewport
     */
    public void draw(ElapsedTime elapsedTime, Graphics2DInterface graphics2DInterface,
                     LayerViewport layerViewport, ScreenViewport screenViewport) {
       /* if (GraphicsHelper.getClippedSourceAndScreenRect(this, layerViewport,
                screenViewport, drawRectSource, drawScreenRect)) {
         graphics2DInterface.drawBitmap(bitmap, drawRectSource, drawScreenRect, null);
        }*/
    }








}
