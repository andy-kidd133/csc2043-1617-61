package com.example.andrew.ark9studios.Screens;




import com.example.andrew.ark9studios.AssetManager;
import android.graphics.Bitmap;
import android.graphics.Rect;

import com.example.andrew.ark9studios.Game;
import com.example.andrew.ark9studios.GameGraphics.Animation;
import com.example.andrew.ark9studios.GameGraphics.Graphics2DInterface;
import com.example.andrew.ark9studios.GameInput.GameTouchEvent;
import com.example.andrew.ark9studios.GameInput.Input;
import com.example.andrew.ark9studios.GameScreen;
import com.example.andrew.ark9studios.Music.Sound;
import com.example.andrew.ark9studios.gameInfrastructure.ElapsedTime;

import java.util.List;

import viewports.LayerViewport;
import viewports.ScreenViewport;

/**
 * Created by megan on 02/03/2017.
 */

/**
 * score board screen
 */

public class ScoreBoardScreen extends GameScreen {


    //////////////////////////////////////
    ///////Variables
    /////////////////////////////////////

    /**
     *Draw Rect for the background bitmap
     */
    private Rect backgroundBound;

    /**
     *Draw Rect for the scoreboard menu bitmap
     */
    private Rect scoreMenuBound;

    /**
     *Draw Rect for the back button bitmap
     */
    private Rect backButtonBound;

    /**
     *Draw Rect for the coin animation bitmap
     */
    private Rect coinSource, coinScreen, coinScreenTwo;



    /**
     *background bitmap
     */
    private Bitmap backgroundBitmap;

    /**
     *scoreboard menu bitmap
     */
    private Bitmap scoreMenuBitmap;

    /**
     *back button bitmap
     */
    private Bitmap backButtonBitmap;

    /**
     *Animation for the coin
     */
    private Animation coinSpinning;


    /**
     *coin bitmap
     */
    private Bitmap coin;



    /**
     * width of screen
     */
    private int screenWidth;

    /**
     *
     */
    private LayerViewport layerViewport;

    /**
     * screen viewport
     */
    private ScreenViewport screenViewport;

    /**
     * name of the screen
     */
    private static final String SCREEN_NAME="ScoreBoardScreen";


    /**
     * width of the menu template
     */
    private static final int MENU_TEMPLATE_WIDTH =1100;

    /**
     * height of the menu template
     */
    private static final int MENU_TEMPLATE_HEIGHT = 1400;


    /**
     * width of the button
     */
    private static final int BUTTON_WIDTH = 150;

    /**
     * height of the button
     */
    private static final int BUTTON_HEIGHT = 150;


    /**
     * hold the top scores as integers
     */
    private int[] highScores;


    /**
     * Holds the bitmaps from the numbers 1 to 5
     */
    private Bitmap[] topScoreNumberBitmap;


    /**
     * draw screen for each of the topscore number bitmaps
     */
    private Rect[] topScoreDrawRects;


    /**
     * Menu select sound to be played
     */
    private Sound menuSelect;

    //getting the asset manager
    AssetManager assetManager = game.getAssetManager();

    //////////////////////////////////////
    ///////Constructor
    /////////////////////////////////////
    /**
     * create a bew score board screen
     * @param game
     */

    public ScoreBoardScreen(Game game){
        super(SCREEN_NAME, game);

        //getting the screen width
        screenWidth = game.getScreenWidth();



        //emptying the assets
        assetManager.emptyAssets();

        /**
         * try loading the bitmaps if, if there is an error print the stack trace
         */
        try {
            assetManager.loadAndAddBitmap("backgroundLayer", "images/qubbg.png");
            assetManager.loadAndAddBitmap("scoreboardmenu", "images/scoreboard_menu.png");
            assetManager.loadAndAddBitmap("backbutton", "images/back_btn.png");
            assetManager.loadAndAddBitmap("coinAnimation", "images/coins.png");
            assetManager.loadAndAddSound("menuSelect", "sfx/menuclick.mp3");
        }catch(Exception e){
            e.printStackTrace();
        }

         //initialising the variables
        this.backgroundBitmap = assetManager.getBitmap("backgroundLayer");
       this.scoreMenuBitmap = assetManager.getBitmap("scoreboardmenu");
        this.backButtonBitmap = assetManager.getBitmap("backbutton");
        this.coin = assetManager.getBitmap("coinAnimation");
        this.menuSelect = assetManager.getSound("menuSelect");




        //loading the coin animation
        coinSpinning = new Animation(coin, 10);
        coinSpinning.play(1.1, true);


        //Draw Rects for the coin animations
        coinSource = new Rect();
        coinScreen = new Rect(1010, 100 , 1060, 200);
        coinScreenTwo = new Rect(170, 100, 220, 200);


    }



    //////////////////////////////////////
    ///////Methods
    /////////////////////////////////////
    /**
     * update method
     * @param elapsedTime- elapsed time info for the frame
     */
    @Override
    public void update(ElapsedTime elapsedTime) {
        //////////////////////////////////////
        ///process touches on the screen
        /////////////////////////////////////

        Input input = game.getInput();
        List<GameTouchEvent> touchEvents = input.getTouchEvents();

        //updating the coin animation
        coinSpinning.update(elapsedTime.stepTime);
        coinSpinning.getSourceRect(coinSource);



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
                MainMenuScreen mainMenuScreen = new MainMenuScreen(this.getmGame());

                //as this is the only added screen then it will become active
                game.getScreenManager().addGameScreen(mainMenuScreen);


            }
        }

    }


    /**
     * the draw method
     */
    @Override
    public void draw(ElapsedTime elapsedTime, Graphics2DInterface graphics2DInterface) {


        /**
         * used to position the scoreboard menu image from the top of the screen
         */
        int scoreMenuTop=140;

        /**
         * used to position the scoreboard menu image from the left of the screen
         */
        int scoreMenuLeft=120;

        /**
         * used to position where the back button will be from the top of
         * the screen
         */
        int backTop= graphics2DInterface.getSurfaceHeight()-155;

        /**
         * used to position where the back button will be from the left of
         * the screen
         */
        int backLeft=20;


        if(backgroundBound == null){
            backgroundBound = new Rect(0, 0, graphics2DInterface.getSurfaceWidth(),
                    graphics2DInterface.getSurfaceHeight());
        }

        if(scoreMenuBound == null){
           scoreMenuBound = new Rect(scoreMenuLeft, scoreMenuTop , MENU_TEMPLATE_WIDTH,
                    MENU_TEMPLATE_HEIGHT);
        }

        if(backButtonBound==null){
            backButtonBound = new Rect(backLeft, backTop, backLeft+BUTTON_WIDTH,
                    backTop+BUTTON_HEIGHT);
        }


        //draw the bitmaps
        graphics2DInterface.drawBitmap(backgroundBitmap, null, backgroundBound, null);
        graphics2DInterface.drawBitmap(scoreMenuBitmap, null, scoreMenuBound, null);
        graphics2DInterface.drawBitmap(backButtonBitmap, null, backButtonBound, null);
        graphics2DInterface.drawBitmap(coin, coinSource, coinScreen, null);
        graphics2DInterface.drawBitmap(coin, coinSource, coinScreenTwo, null);

    }


    /**
     * pause method
     */
    @Override
    public void dispose() {

    }

    /**
     * pause method
     */
    @Override
    public void pause() {

    }

    /**
     * resume method
     */
    @Override
    public void resume() {

    }
}
