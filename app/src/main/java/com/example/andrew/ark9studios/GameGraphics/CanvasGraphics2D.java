package com.example.andrew.ark9studios.GameGraphics;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;

/**
 * Created by Megan on 13/04/2017.
 */

public class CanvasGraphics2D implements Graphics2DInterface {

    //////////////////////////////////////////////////////////////////
    //Variables
    //////////////////////////////////////////////////////////////////

    //canvas onto which the graphics instance will render
    private Canvas canvas;


    //width and height of the canvas we are renddering onto
    private int width;
    private int height;



    //////////////////////////////////////////////////////////////////
    //Constructor
    //////////////////////////////////////////////////////////////////
    /**
     * constrcutor for the Canvas Graphics
     */
    public CanvasGraphics2D(){

    }





    //////////////////////////////////////////////////////////////////
    //Methods: getters and setters
    //////////////////////////////////////////////////////////////////
    /**
     * set the canvas onto which the graphics instance will render
     * @param canvas
     */
    public void setCanvas(Canvas canvas){
        this.canvas = canvas;
        width = canvas.getWidth();
        height = canvas.getHeight();
    }


    /**
     * returns the wdith of the surface
     * @return
     */
    @Override
    public int getSurfaceWidth() {
        return width;
    }

    /**
     * returns the height of the surfacce
     * @return
     */
    @Override
    public int getSurfaceHeight() {
        return height;
    }


    //////////////////////////////////////////////////////////////////
    //drawing methods
    //////////////////////////////////////////////////////////////////



    @Override
    public void drawRectangle(Rect rect, Paint paint) {
       canvas.drawRect(rect, paint);
    }

    @Override
    public void drawPath(Path path, Paint paint) {
     canvas.drawPath(path,paint);
    }

    @Override
    public void drawText(String text, float x, float y, Paint paint) {
        canvas.drawText(text, x, y, paint);

    }

    @Override
    public void drawBitmap(Bitmap bitmap, Rect srcRect, Rect destRect, Paint paint) {
        canvas.drawBitmap(bitmap, srcRect, destRect, paint);


    }

    @Override
    public void drawBitmap(Bitmap bitmap, Matrix matrix, Paint paint) {
        canvas.drawBitmap(bitmap, matrix, paint);

    }
}
