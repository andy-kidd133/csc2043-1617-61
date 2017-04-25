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
import com.example.andrew.ark9studios.gameInfrastructure.ElapsedTime;

import java.util.List;

import viewports.LayerViewport;
import viewports.ScreenViewport;

/**
 * Created by megan on 02/03/2017.
 */

public class ScoreBoardScreen extends GameScreen {


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
     * create a bew score board screen
     * @param game
     */

    public ScoreBoardScreen(Game game){
        super(SCREEN_NAME, game);

        screenWidth = game.getScreenWidth();

        AssetManager assetManager = game.getAssetManager();
        assetManager.emptyAssets();
        assetManager.loadAndAddBitmap("backgroundLayer", "images/qubbg.png");
        assetManager.loadAndAddBitmap("scoreboardmenu", "images/scoreboard_menu.png");
        assetManager.loadAndAddBitmap("backbutton", "images/back_btn.png");
        assetManager.loadAndAddBitmap("coinAnimation", "images/coins.png");


        this.backgroundBitmap = assetManager.getBitmap("backgroundLayer");
       this.scoreMenuBitmap = assetManager.getBitmap("scoreboardmenu");
        this.backButtonBitmap = assetManager.getBitmap("backbutton");
        this.coin = assetManager.getBitmap("coinAnimation");




        //loading the card animation
        coinSpinning = new Animation(coin, 10);
        coinSpinning.play(1.1, true);




        coinSource = new Rect();
       coinScreen = new Rect(120, 120, 190, 200);
     coinScreenTwo = new Rect(240, 240, 240, 240);
    }


    /**
     * update method
     * @param elapsedTime- elapsed time info for the frame
     */
    @Override
    public void update(ElapsedTime elapsedTime) {

        Input input = game.getInput();
        List<GameTouchEvent> touchEvents = input.getTouchEvents();

        coinSpinning.update(elapsedTime.stepTime);
        coinSpinning.getSourceRect(coinSource);




        if (touchEvents.size() > 0) {
            GameTouchEvent touchEvent = touchEvents.get(0);
            if (backButtonBound.contains((int) touchEvent.x, (int) touchEvent.y)) {

                game.getScreenManager().removeScreen(this.getmName());

                MainMenuScreen mainMenuScreen = new MainMenuScreen(this.getmGame());
                game.getScreenManager().addGameScreen(mainMenuScreen);


            }
        }

    }


    /**
     * the draw method
     */
    @Override
    public void draw(ElapsedTime elapsedTime, Graphics2DInterface graphics2DInterface) {

        int scoreMenuTop=140;
        int scoreMenuLeft=120;
        int backTop= graphics2DInterface.getSurfaceHeight()-155;
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


        graphics2DInterface.drawBitmap(backgroundBitmap, null, backgroundBound, null);
        graphics2DInterface.drawBitmap(scoreMenuBitmap, null, scoreMenuBound, null);
        graphics2DInterface.drawBitmap(backButtonBitmap, null, backButtonBound, null);
        graphics2DInterface.drawBitmap(coin, coinSource, coinScreen, null);
        graphics2DInterface.drawBitmap(coin, coinSource, coinScreenTwo, null);

    }

    @Override
    public void dispose() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }
}
