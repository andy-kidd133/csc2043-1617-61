package com.example.andrew.ark9studios.Screens;



import android.graphics.Bitmap;
import android.graphics.Rect;

import com.example.andrew.ark9studios.AssetManager;
import com.example.andrew.ark9studios.Game;
import com.example.andrew.ark9studios.GameGraphics.Graphics2DInterface;
import com.example.andrew.ark9studios.GameInput.GameTouchEvent;
import com.example.andrew.ark9studios.GameInput.Input;
import com.example.andrew.ark9studios.GameScreen;
import com.example.andrew.ark9studios.gameInfrastructure.ElapsedTime;

import java.util.List;


/**
 * Created by megan on 02/03/2017.
 */

/**
 * Option screen
 */

public class OptionsScreen extends GameScreen {

    //////////////////////////////////////
    ///////Variables
    /////////////////////////////////////

    /**
     * Draw Rect for background bitmap
     */
    private Rect backgroundBound;

    /**
     * Draw Rect for options menu bitmap
     */
    private Rect optionsMenuBound;

    /**
     * Draw Rect for back button bitmap
     */
    private Rect backButtonBound;

    /**
     *Draw Rect for the sound button bitmap
     */
    private Rect soundButtonBound;

    /**
     * Draw Rect for music text bitmap
     */
    private Rect musicTextBound;

    /**
     * Draw Rect for facebook text bitmap
     */
    private Rect facebookBound;

    /**
     * background bitmap
     */
    private Bitmap backgroundBitmap;
    /**
     * options menu bitmap
     */
    private Bitmap optionsMenuBitmap;

    /**
     * back button bitmap
     */
    private Bitmap backButtonBitmap;
    /**
     * music on bitmap
     */
    private Bitmap musicOn;

    /**
     * music off bitmap
     */
    private Bitmap musicOff;

    /**
     * music text bitmap
     */
    private Bitmap musicTextBitmap;

    /**
     * facebook bitmap
     */
    private Bitmap facebookBitmap;


    /**
     * name of the screen
     */
    private static final String SCREEN_NAME="OptionsScreen";

    /**
     * menu width
     */
    private static final int MENU_TEMPLATE_WIDTH =1100;
    /**
     * menu height
     */
    private static final int MENU_TEMPLATE_HEIGHT = 1400;
    /**
     * button width
     */
    private static final int BUTTON_WIDTH = 150;
    /**
     * button height
     */
    private static final int BUTTON_HEIGHT = 150;

    /**
     * text width
     */
    private static final int TEXT_WIDTH=180;

    /**
     * text height
     */
    private static final int TEXT_HEIGHT=100;

    /**
     * facebook width
     */
    private static final int FACEBOOK_WIDTH=600;

    /**
     * facebook height
     */
    private static final int FACEBOOK_HEIGHT=120;


    private MainMenuScreen mainMenuScreen;



    //////////////////////////////////////
    ///////Constructor
    /////////////////////////////////////
    /**
     * create a new options screen
     * @param game- game options screen belongs
     */
    public OptionsScreen(Game game) {
        super(SCREEN_NAME, game);

        AssetManager assetManager = game.getAssetManager();
        assetManager.emptyAssets();

        assetManager.loadAndAddBitmap("backgroundLayer", "images/qubbg.png");
        assetManager.loadAndAddBitmap("optionsmenu", "images/option_menu.png");
        assetManager.loadAndAddBitmap("backbutton", "images/back_btn.png");
        assetManager.loadAndAddBitmap("musicOn", "images/music_on.png");
        assetManager.loadAndAddBitmap("musicOff", "images/music_off.png");
        assetManager.loadAndAddBitmap("musicText", "images/music_text.png");
        assetManager.loadAndAddBitmap("facebookButton", "images/facebook.png");

        this.backgroundBitmap = assetManager.getBitmap("backgroundLayer");
        this.optionsMenuBitmap = assetManager.getBitmap("optionsmenu");
        this.backButtonBitmap = assetManager.getBitmap("backbutton");
        this.musicOn = assetManager.getBitmap("musicOn");
        this.musicOff = assetManager.getBitmap("musicOff");
        this.musicTextBitmap = assetManager.getBitmap("musicText");
        this.facebookBitmap = assetManager.getBitmap("facebookButton");


        mainMenuScreen = new MainMenuScreen(game);
        mainMenuScreen.getBackgroundMusic();

    }


    //////////////////////////////////////
    ///////Methods
    /////////////////////////////////////
    /**
     * options update
     * @param elapsedTime- elapsed time info for the frame
     */
    @Override
    public void update(ElapsedTime elapsedTime) {

        Input input = game.getInput();
        List<GameTouchEvent> touchEvents = input.getTouchEvents();
        if (touchEvents.size() > 0) {
            GameTouchEvent touchEvent = touchEvents.get(0);
            if (backButtonBound.contains((int) touchEvent.x, (int) touchEvent.y)) {

                MainMenuScreen mainMenuScreen = new MainMenuScreen(game);
                game.changeScreen(this, mainMenuScreen);


            }


           if (soundButtonBound.contains((int) touchEvent.x,
                    (int) touchEvent.y)
                    && touchEvent.typeOfTouchEvent == GameTouchEvent.TOUCH_UP) {
                if(mainMenuScreen.getBackgroundMusic().isPlaying()){
                    mainMenuScreen.getBackgroundMusic().pause();
                }else{
                    mainMenuScreen.getBackgroundMusic().play();
                }


            }
        }
    }


    /**
     * options screen draw
     * @param elapsedTime- elapsed time info for the frame
     * @param graphics2DInterface- graphics interface which is used to draw the game screen
     */

    @Override
    public void draw(ElapsedTime elapsedTime, Graphics2DInterface graphics2DInterface) {


        int optionsMenuTop = 140;
        int optionsMenuLeft = 120;
        int backTop = graphics2DInterface.getSurfaceHeight() - 155;
        int backLeft = 20;
        int musicLeft = 520;
        int musicTop = 360;
        int soundLeft = 530;
        int soundTop = 490;
        int facebookLeft=320;
        int facebookTop=700;


        if (backgroundBound == null) {
            backgroundBound = new Rect(0, 0, graphics2DInterface.getSurfaceWidth(),
                    graphics2DInterface.getSurfaceHeight());
        }

        if (optionsMenuBound == null) {
            optionsMenuBound = new Rect(optionsMenuLeft, optionsMenuTop, MENU_TEMPLATE_WIDTH,
                    MENU_TEMPLATE_HEIGHT);
        }

        if (backButtonBound == null) {
            backButtonBound = new Rect(backLeft, backTop, backLeft + BUTTON_WIDTH,
                    backTop + BUTTON_HEIGHT);
        }

        if (musicTextBound == null) {
            musicTextBound = new Rect(musicLeft, musicTop, musicLeft + TEXT_WIDTH, musicTop + TEXT_HEIGHT);
        }

        if (soundButtonBound == null) {
            soundButtonBound = new Rect(soundLeft, soundTop, soundLeft + BUTTON_WIDTH, soundTop + BUTTON_HEIGHT);

        }

        if(facebookBound==null){
            facebookBound = new Rect(facebookLeft, facebookTop, facebookLeft+FACEBOOK_WIDTH, facebookTop+FACEBOOK_HEIGHT);
        }




        graphics2DInterface.drawBitmap(backgroundBitmap, null, backgroundBound, null);
        graphics2DInterface.drawBitmap(optionsMenuBitmap, null, optionsMenuBound, null);
        graphics2DInterface.drawBitmap(backButtonBitmap, null, backButtonBound, null);
        graphics2DInterface.drawBitmap(musicTextBitmap, null, musicTextBound, null);
        graphics2DInterface.drawBitmap(facebookBitmap, null, facebookBound, null);

       if (mainMenuScreen.getBackgroundMusic().isPlaying()) {
            graphics2DInterface.drawBitmap(musicOn, null, soundButtonBound, null);
        } else if (!mainMenuScreen.getBackgroundMusic().isPlaying()) {
            graphics2DInterface.drawBitmap(musicOff, null, soundButtonBound, null);
        }
        }



    @Override
    public void dispose() {

        return;
    }

    @Override
    public void pause() {

        return;
    }

    @Override
    public void resume() {
       return;
    }
}
