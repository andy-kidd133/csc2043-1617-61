package com.example.andrew.ark9studios.Screens;

/**
 * Created by Megan on 21/04/2017.
 */


import android.graphics.Bitmap;
import android.graphics.Rect;

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
 * This is the pause overlay object which represents the pause dialog that is shown
 * when the user pauses the game. This allows the user to perform actions such as resume
 * the game, return to the main menu and quit
 */
public class PauseOverlay extends OverlayObject {



    //////////////////////////////////////
    ///////Variables
    /////////////////////////////////////
    /**
     * Resume Button
     */
    private InputControl resumeButton;

    /**
     * Menu Button: takes you back to the menu
     */

    private InputControl menuButton;

    /**
     *sound toggle Button
     */
    private InputControl soundControl;


    /**
     * sound bitmaps
     */
    private Bitmap soundOn, soundOff;



    //////////////////////////////////////
    ///////Constructor
    /////////////////////////////////////
    /***
     * Create a new Pause Overlay
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
  public PauseOverlay(float x, float y, float width, float height,
                      Bitmap bitmap, GameScreen gameScreen){
      super(x, y, width, height, bitmap, gameScreen);

      AssetManager assetManager = gameScreen.getmGame().getAssetManager();


      float buttonWidth =270.0f;
      float buttonHeight = 90.0f;

      float soundButtonWidth=150.0f;
      float soundButtonHeight=150.0f;


      float soundButtonX = bound.getLeft() + 450.0f;
      float menuButtonX= bound.getLeft() + 460.0f;
      float resumeButtonX = bound.getLeft() +460.0f;

      float soundbuttonY =  1020.0f;
      float menubuttonY = 860.0f;
      float resumebuttonY = 660.0f;



      this.soundOn = assetManager.getBitmap("SoundOnButton");
      this.soundOff = assetManager.getBitmap("SoundOnButton");



      if(GameAudioManager.SOUND_ENABLED)
          this.soundControl = new InputControl(soundButtonX, soundbuttonY, soundButtonWidth,
                  soundButtonHeight, soundOn, gameScreen);
      else this.soundControl = new InputControl(soundButtonX, soundbuttonY, soundButtonWidth,
                  soundButtonHeight, soundOff, gameScreen);



     this.resumeButton = new InputControl(resumeButtonX, resumebuttonY,
              buttonWidth, buttonHeight,
              assetManager.getBitmap("ResumeButton"), gameScreen);


     this.menuButton = new InputControl(menuButtonX, menubuttonY, buttonWidth,
              buttonHeight, assetManager.getBitmap("mainMenuButton"), gameScreen);


  }


    //////////////////////////////////////
    ///////Methods
    /////////////////////////////////////

    /**
     * update pauseOverlay
     */
    public void update(ElapsedTime elapsedTime) {


        if (GameAudioManager.SOUND_ENABLED && soundControl.getBitmap() != soundOn) {
            soundControl.setBitmap(soundOn);
        } else if (!GameAudioManager.SOUND_ENABLED && soundControl.getBitmap() != soundOff) {
            soundControl.setBitmap(soundOff);
        }

    }

    /**
     * draw method
     */

    @Override
    public void draw(ElapsedTime elapsedTime, Graphics2DInterface graphics2DInterface,
                     LayerViewport layerViewport, ScreenViewport screenViewport) {
        super.draw(elapsedTime, graphics2DInterface, layerViewport, screenViewport);



        resumeButton.draw(elapsedTime, graphics2DInterface, layerViewport,
                screenViewport);
        menuButton.draw(elapsedTime, graphics2DInterface , layerViewport, screenViewport);
        soundControl.draw(elapsedTime, graphics2DInterface, layerViewport, screenViewport);


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
     * @return boolean indicating whether the sound button has a touch up
     */
    public boolean isSoundToggled() {
        return soundControl.hasTouchUp();
    }


    /***
     *
     * @return boolean indicating whether the menu button has a touch up
     */
    public boolean isMainMenu(){
        return menuButton.hasTouchUp();
    }




































}
