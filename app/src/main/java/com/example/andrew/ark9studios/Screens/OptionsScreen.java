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


    /**
     * instance of the main menu screen
     */
    private MainMenuScreen mainMenuScreen;


    //getting the asset manager
    AssetManager assetManager = game.getAssetManager();


    //////////////////////////////////////
    ///////Constructor
    /////////////////////////////////////

    /**
     * create a new options screen
     * @param game- game options screen belongs
     */
    public OptionsScreen(Game game) {
        super(SCREEN_NAME, game);



        //emptying the assets
        assetManager.emptyAssets();

        /**
         * try loading the bitmaps if, if there is an error print the stack trace
         */
        try {
            assetManager.loadAndAddBitmap("backgroundLayer", "images/qubbg.png");
            assetManager.loadAndAddBitmap("optionsmenu", "images/option_menu.png");
            assetManager.loadAndAddBitmap("backbutton", "images/back_btn.png");
            assetManager.loadAndAddBitmap("musicOn", "images/music_on.png");
            assetManager.loadAndAddBitmap("musicOff", "images/music_off.png");
            assetManager.loadAndAddBitmap("musicText", "images/music_text.png");
            assetManager.loadAndAddBitmap("facebookButton", "images/facebook.png");
        }catch(Exception e){
            e.printStackTrace();
        }

        //initialising the variables
        this.backgroundBitmap = assetManager.getBitmap("backgroundLayer");
        this.optionsMenuBitmap = assetManager.getBitmap("optionsmenu");
        this.backButtonBitmap = assetManager.getBitmap("backbutton");
        this.musicOn = assetManager.getBitmap("musicOn");
        this.musicOff = assetManager.getBitmap("musicOff");
        this.musicTextBitmap = assetManager.getBitmap("musicText");
        this.facebookBitmap = assetManager.getBitmap("facebookButton");


        //getting the background music
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

        //////////////////////////////////////
        ///process touches on the screen
        /////////////////////////////////////

        Input input = game.getInput();
        List<GameTouchEvent> touchEvents = input.getTouchEvents();
        if (touchEvents.size() > 0) {

            /**
             * check the first touch event.
             */
            GameTouchEvent touchEvent = touchEvents.get(0);
            if (backButtonBound.contains((int) touchEvent.x, (int) touchEvent.y)) {


                //play menu select
                assetManager.getSound("menuSelect").play();
                //if the quit area has been touched then swap to the quit screen
                game.getScreenManager().removeScreen(this.getmName());
                MainMenuScreen mainMenuScreen = new MainMenuScreen(game);

                //as this is the only added screen then it will become active
                game.getScreenManager().addGameScreen(mainMenuScreen);

            }


           if (soundButtonBound.contains((int) touchEvent.x,
                    (int) touchEvent.y)
                    && touchEvent.typeOfTouchEvent == GameTouchEvent.TOUCH_UP) {

               /**
                *  if the background music is currently playing then pause it
                */

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


        /**
         * used to position the options menu image from the top of the screen
         */
        int optionsMenuTop = 140;


        /**
         * used to position the options menu image from the left of the screen
         */
        int optionsMenuLeft = 120;

        /**
         * used to position where the back button will be from the top of
         * the screen
         */
        int backTop = graphics2DInterface.getSurfaceHeight() - 155;

        /**
         * used to position where the back button will be from the left of
         * the screen
         */
        int backLeft = 20;

        /**
         * used to position where the music text will be from the left of
         * the screen
         */
        int musicTextLeft = 520;

        /**
         * used to position where the music text will be from the top of
         * the screen
         */
        int musicTextTop = 360;

        /**
         * used to position where the sound button will be from the left of
         * the screen
         */
        int soundLeft = 530;

        /**
         * used to position where the sound button will be from the top of
         * the screen
         */
        int soundTop = 490;

        /**
         * used to position where the facebook button will be from the left of
         * the screen
         */
        int facebookLeft=320;


        /**
         * used to position where the facebook button will be from the top of
         * the screen
         */
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
            musicTextBound = new Rect(musicTextLeft, musicTextTop, musicTextLeft + TEXT_WIDTH, musicTextTop + TEXT_HEIGHT);
        }

        if (soundButtonBound == null) {
            soundButtonBound = new Rect(soundLeft, soundTop, soundLeft + BUTTON_WIDTH, soundTop + BUTTON_HEIGHT);

        }

        if(facebookBound==null){
            facebookBound = new Rect(facebookLeft, facebookTop, facebookLeft+FACEBOOK_WIDTH, facebookTop+FACEBOOK_HEIGHT);
        }




        //draw the bitmaps out
        graphics2DInterface.drawBitmap(backgroundBitmap, null, backgroundBound, null);
        graphics2DInterface.drawBitmap(optionsMenuBitmap, null, optionsMenuBound, null);
        graphics2DInterface.drawBitmap(backButtonBitmap, null, backButtonBound, null);
        graphics2DInterface.drawBitmap(musicTextBitmap, null, musicTextBound, null);
        graphics2DInterface.drawBitmap(facebookBitmap, null, facebookBound, null);


        /**
         * if the background music is playing the draw the musicOn image else
         * draw the musicOff image
         */
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
