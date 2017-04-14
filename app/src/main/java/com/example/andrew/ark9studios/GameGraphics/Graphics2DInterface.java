package com.example.andrew.ark9studios.GameGraphics;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;

/**
 * Created by Megan on 11/11/2016
 * edited by Megan on 14/04/2017
 */

public interface Graphics2DInterface {


    /**
     * returns the width of the render surfacee
     * @return
     */
    public int getSurfaceWidth();

    /**
     * returns the height of the render surface
     * @return
     */
    public int getSurfaceHeight();

    /**
     * Draw the specified
     * @param rect-rectangle to be rendered
     * @param paint-paint parameters controlling how the bitmap is rendered
     */
    public void drawRectangle(Rect rect, Paint paint);

    /**
     * draw the specfifed path
     * @param path- path to be rendered
     * @param paint- paint parameters controlling how the bitmap is rendered
     */
    public void drawPath(Path path, Paint paint);

    /**
     * draw the specified text string
     * @param text- string of text to be rendered
     * @param x-location of text x-axis
     * @param y-location of text y-axis
     * @param paint- paint parameters controlling text render format
     */
    public void drawText(String text, float x, float y, Paint paint);

    /**
     * Draw the specfied bitmap
     * @param bitmap- bitmap to be rendered
     * @param srcRect- source region to be rendered
     * @param destRect- destination region to be rendered
     * @param paint-paint parameters controlling how the bitmap is rendered
     */
    public void drawBitmap(Bitmap bitmap, Rect srcRect, Rect destRect, Paint paint);

    /**
     * Draw the specfifed bitmap
     * @param bitmap- bitmap to be rendered
     * @param matrix- matrix that defines the bitmap scaling, rotation etc
     * @param paint- paint parmeters controlling how the bitmap is rendered
     */
    public void drawBitmap(Bitmap bitmap, Matrix matrix, Paint paint);


}
