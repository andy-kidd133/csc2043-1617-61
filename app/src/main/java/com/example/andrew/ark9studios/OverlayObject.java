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

public abstract class OverlayObject extends GameObjects {


    /**
     * create a new overlay object
     * @param x- the starting x coordinate
     * @param y- the starting y coordinate
     * @param width- the wdith of the overlay object
     * @param height- the height of the overlay object
     * @param bitmap- the bitmap to be drawn
     * @param gameScreen- gameSCreen overlayObject being rendered to
     */

    public OverlayObject(float x, float y, float width, float height,
                         Bitmap bitmap, GameScreen gameScreen){
        super(x, y, width, height, bitmap, gameScreen);
    }


    /***
     * Create a new Overlay Object
     * @param x - starting x coordinate
     * @param y - starting y coordinate
     * @param width - width of overlay object
     * @param height - height of overlay object
     * @param bitmap - bitmap to be drawn
     * @param gameScreen - gameScreen overlayObject being rendered to
     * @param drawRectSource - specific rectangle from source to be rendered
     */
    public OverlayObject(float x, float y, float width, float height,
                         Bitmap bitmap, GameScreen gameScreen, Rect drawRectSource) {
        super(x, y, width, height, bitmap, gameScreen, drawRectSource);
    }




    /***
     * Update Overlay
     */
    @Override
    public void update(ElapsedTime elapsedTime) {
    }

    /***
     * Draw Overlay
     */
    @Override
    public void draw(ElapsedTime elapsedTime, Graphics2DInterface graphics2DInterface,
                     LayerViewport layerViewport, ScreenViewport screenViewport) {

        drawScreenRect.set((int) (position.x - bound.halfWidth),
                (int) (position.y - bound.halfWidth),
                (int) (position.x + bound.halfWidth),
                (int) (position.y + bound.halfHeight));

        // draw
        graphics2DInterface.drawBitmap(bitmap, null, drawScreenRect, null);

    }

































}
