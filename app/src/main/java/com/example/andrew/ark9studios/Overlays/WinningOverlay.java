package com.example.andrew.ark9studios.Overlays;

import android.graphics.Bitmap;

import com.example.andrew.ark9studios.AssetManager;
import com.example.andrew.ark9studios.GameAudioManager;
import com.example.andrew.ark9studios.GameGraphics.Graphics2DInterface;
import com.example.andrew.ark9studios.GameScreen;
import com.example.andrew.ark9studios.InputControl;
import com.example.andrew.ark9studios.OverlayObject;
import com.example.andrew.ark9studios.gameInfrastructure.ElapsedTime;

import viewports.LayerViewport;
import viewports.ScreenViewport;

/**
 * Created by megan on 05/05/2017.
 */

/**
 * This screen is not currently used as the complete game was not complete, however
 * it can be easily incorporated into the game
 * This is the winning screen, it can be triggered to be drawn over the game screen
 * if the player has won e.g all their cards have been played
 * it simply lets the user know they have won and completed that level
 */

public class WinningOverlay extends OverlayObject {


    //////////////////////////////////////
    ///////Variables
    /////////////////////////////////////


    /**
     * complete star bitmaps
     */
    private Bitmap star1;
    private Bitmap star2;
    private Bitmap star3;



    /**
     * dim star bitmaps
     */
    private Bitmap dimStar1;
    private Bitmap dimStar2;
    private Bitmap dimStar3;

    private InputControl restartButton;







    //////////////////////////////////////
    ///////Constructor
    /////////////////////////////////////
    /***
     * Create a new Winning Overlay
     *
     * @param x
     *            - starting x coordinate
     * @param y
     *            - starting y coordinate
     * @param width
     *            - width of overlay object
     * @param height
     *            - height of overlay object
     * @param bitmap
     *            - bitmap to be drawn
     * @param gameScreen
     *            - gameScreen overlayObject being rendered to
     */
    public WinningOverlay(float x, float y, float width, float height,
                        Bitmap bitmap, GameScreen gameScreen) {
        super(x, y, width, height, bitmap, gameScreen);

        AssetManager assetManager = gameScreen.getmGame().getAssetManager();



        //width and height of the star buttons
        float buttonWidth =150.0f;
        float buttonHeight = 150.0f;


        //buttons X coordinate (left)
        float restartButtonX = bound.getLeft() + 450.0f;


        //buttons Y coordinate (top)
        float restartButtonY = 660.0f;




        this.star1 = assetManager.getBitmap("star1");

        this.restartButton = new InputControl(restartButtonX, restartButtonY, buttonWidth,
                buttonHeight, assetManager.getBitmap("restartButton"), gameScreen);






    }




    //////////////////////////////////////
    ///////Methods
    /////////////////////////////////////

    /**
     * update winningOverlay
     */
    public void update(ElapsedTime elapsedTime) {


    }

    /**
     * draw method
     */

    @Override
    public void draw(ElapsedTime elapsedTime, Graphics2DInterface graphics2DInterface,
                     LayerViewport layerViewport, ScreenViewport screenViewport) {
        super.draw(elapsedTime, graphics2DInterface, layerViewport, screenViewport);




        restartButton.draw(elapsedTime,graphics2DInterface, layerViewport, screenViewport);


    }





}
