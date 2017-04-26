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



  public PauseOverlay(float x, float y, float width, float height,
                      Bitmap bitmap, GameScreen gameScreen){
      super(x, y, width, height, bitmap, gameScreen);

      AssetManager assetManager = gameScreen.getmGame().getAssetManager();




      float buttonWidth =250.0f;
      float buttonHeight = 110.0f;


      float quitButtonX = bound.getLeft() + 460.0f;
      float menuButtonX= bound.getLeft() + 460.0f;
      float resumeButtonX = bound.getLeft() +460.0f;

      float quitbuttonY =  1060.0f;
      float menubuttonY = 860.0f;
      float resumebuttonY = 660.0f;




     this.resumeButton = new InputControl(resumeButtonX, resumebuttonY,
              buttonWidth, buttonHeight,
              assetManager.getBitmap("ResumeButton"), gameScreen);


     this.menuButton = new InputControl(menuButtonX, menubuttonY, buttonWidth,
              buttonHeight, assetManager.getBitmap("mainMenuButton"), gameScreen);

      this.quitButton = new InputControl(quitButtonX, quitbuttonY, buttonWidth,
              buttonHeight, assetManager.getBitmap("QuitButton"), gameScreen);

  }

    public void update(ElapsedTime elapsedTime){

    }

    @Override
    public void draw(ElapsedTime elapsedTime, Graphics2DInterface graphics2DInterface,
                     LayerViewport layerViewport, ScreenViewport screenViewport) {
        super.draw(elapsedTime, graphics2DInterface, layerViewport, screenViewport);



        resumeButton.draw(elapsedTime, graphics2DInterface, layerViewport,
                screenViewport);
        menuButton.draw(elapsedTime, graphics2DInterface , layerViewport, screenViewport);
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


    public boolean isMainMenu(){
        return menuButton.hasTouchUp();
    }




































}
