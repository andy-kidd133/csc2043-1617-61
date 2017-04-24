package com.example.andrew.ark9studios;

/**
 * Created by Megan on 21/04/2017.
 */


import android.graphics.Bitmap;
import android.graphics.Rect;

import com.example.andrew.ark9studios.GameGraphics.Graphics2DInterface;
import com.example.andrew.ark9studios.gameInfrastructure.ElapsedTime;

import viewports.LayerViewport;
import viewports.ScreenViewport;

/**
 * This is the pause overlay object which represents the pause dialog that is shown
 * when the user pauses the game. This allows the user to perform actions such as resume
 * the game, return to the main menu and quit
 */
public class PauseOverlay extends OverlayObject {


    /**
     * The bitmap for the Overlay frame
     */
    private Bitmap pausedBitmap;

    /**
     * Rectangle for draw of pausedBitmap
     */
    private Rect pausedRect;


    /**
     * Resume Button
     */
    private InputControl resumeButton;

    /**
     * Menu Button: takes you back to the menu
     */

    private InputControl menuButton;

    /**
     * Quit Button
     */
    private InputControl quitButton;


    /**
     * Sound Button Bitmaps
     */
    private Bitmap soundOnBitmap, soundOffBitmap;






  public PauseOverlay(float x, float y, float width, float height,
                      Bitmap bitmap, GameScreen gameScreen){
      super(x, y, width, height, bitmap, gameScreen);

      AssetManager assetManager = gameScreen.getmGame().getAssetManager();

      this.pausedBitmap = assetManager.getBitmap("pauseIcon");


      int pausedWidth = 600;
      int pausedTop = (int) (y - 500.0f);


      int pausedHeight = 80;
      int pausedBottom = pausedTop + pausedHeight;

      int pausedX = (int) ((gameScreen.getmGame().getScreenWidth()/2.0f)
      - (pausedWidth / 2.0f) + 50.0f);


      this.pausedRect = new Rect(pausedX, pausedTop, pausedX + pausedWidth, pausedBottom);


      float buttonWidth = 150.0f;
      float buttonHeight = 100.0f;

      float buttonY = pausedBottom + 200.0f;

      float thirdWidth = width / 3.0f;
      float quitButtonX = bound.getLeft() + thirdWidth;
      float resumeButtonX = bound.getRight() - thirdWidth;


      this.resumeButton = new InputControl(resumeButtonX, buttonY,
              buttonWidth, buttonHeight,
              assetManager.getBitmap("ResumeButton"), gameScreen);

      this.soundOnBitmap = assetManager.getBitmap("SoundButtonOn");
      this.soundOffBitmap = assetManager.getBitmap("SoundButtonOff");

      this.quitButton = new InputControl(quitButtonX, buttonY, buttonWidth,
              buttonHeight, assetManager.getBitmap("QuitButton"), gameScreen);

  }

    public void update(ElapsedTime elapsedTime){

    }

    @Override
    public void draw(ElapsedTime elapsedTime, Graphics2DInterface graphics2DInterface,
                     LayerViewport layerViewport, ScreenViewport screenViewport) {
        super.draw(elapsedTime, graphics2DInterface, layerViewport, screenViewport);

        graphics2DInterface.drawBitmap(pausedBitmap, null, pausedRect, null);

        resumeButton.draw(elapsedTime, graphics2DInterface, layerViewport,
                screenViewport);
        quitButton.draw(elapsedTime, graphics2DInterface, layerViewport, screenViewport);


    }


    /***
     *
     * @return boolean indicating whether the resume button has a touch up
     */
    public boolean isResumed() {
        return resumeButton.hasTouchUp();
    }

    /***
     *
     * @return boolean indicating whether the exit button has a touch up
     */
    public boolean isExited() {
        return quitButton.hasTouchUp();
    }




































}
