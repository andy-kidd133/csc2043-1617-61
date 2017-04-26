package com.example.andrew.ark9studios.Screens;

import android.graphics.Bitmap;
import android.graphics.Rect;

import com.example.andrew.ark9studios.AssetManager;
import com.example.andrew.ark9studios.Game;
import com.example.andrew.ark9studios.GameGraphics.Graphics2DInterface;
import com.example.andrew.ark9studios.GameInput.GameTouchEvent;
import com.example.andrew.ark9studios.GameInput.Input;
import com.example.andrew.ark9studios.GameMusic;
import com.example.andrew.ark9studios.GameScreen;
import com.example.andrew.ark9studios.PauseOverlay;
import com.example.andrew.ark9studios.gameInfrastructure.ElapsedTime;

import java.util.List;

import viewports.LayerViewport;
import viewports.ScreenViewport;

/**
 * Created by megan on 15/04/2017.
 */

public class MainGameScreen extends GameScreen {

    public static final String SCREEN_NAME = "MainGameScreen";

    private Rect card1Bound;

    /**
     * Draw Rect for the background bitmap
     */
    private Rect backgroundBound;

    /**
     * Draw Rect for the pause icon bitmap
     */
    private Rect pauseIconBound;

    /**
     * Draw Rect for the player deck bitmap
     */
    private Rect player1DeckBound;

    /**
     * Draw Rect for the enemy deck bitmap
     */
    private Rect enemyDeckBound;


    private Bitmap card1Bitmap;

    /**
     * background bitmap
     */
    private Bitmap backgroundBitmap;


    /**
     * pause icon bitmap
     */
    private Bitmap pauseIconBitmap;

    /**
     * player  deck bitmap
     */
    private Bitmap player1DeckBitmap;

    /**
     * enemy deck bitmap
     */
    private Bitmap enemyDeckBitmap;

    /**
     * width of the card deck
     */
    private static final int CARD_WIDTH = 150;
    /**
     * card height of the card deck
     */
    private static final int CARD_HEIGHT = 150;

    /**
     * width of the deck
     */
    private static final int DECK_WIDTH = 1100;
    /**
     * height of the deck
     */
    private static final int DECK_HEIGHT = 400;

    /**
     * pause button width
     */
    private static final int PAUSE_BUTTON_WIDTH= 120;

    /**
     * pause button height
     */
    private static final int PAUSE_BUTTON_HEIGHT=130;




    protected enum GameLevelState {
        paused, running
    }

    protected GameLevelState levelState;


    /**
     * create a new main game screen
     * @param game-screen the game belongs to
     */
    public MainGameScreen(Game game){
       super(SCREEN_NAME, game);

       AssetManager assetManager = game.getAssetManager();
       assetManager.emptyAssets();

       assetManager.loadAndAddBitmap("card1", "images/card1.png");
       assetManager.loadAndAddBitmap("backgroundLayer", "images/qubbg.png");
       assetManager.loadAndAddBitmap("pauseIcon", "images/pause_button.png");
       assetManager.loadAndAddBitmap("player1Deck", "images/player1_deck.png");
       assetManager.loadAndAddBitmap("enemyDeck", "images/enemy_deck.png");
       assetManager.loadAndAddBitmap("PauseMenu", "images/pausemenu.png");
      // assetManager.loadAndAddMusic("backgroundMusic", "raw/laser_groove.mp3");

       this.card1Bitmap = assetManager.getBitmap("card1");
       this.backgroundBitmap = assetManager.getBitmap("backgroundLayer");
       this.pauseIconBitmap = assetManager.getBitmap("pauseIcon");
       this.player1DeckBitmap = assetManager.getBitmap("player1Deck");
       this.enemyDeckBitmap = assetManager.getBitmap("enemyDeck");





   }


    /**
     * Draw method
     * @param elapsedTime- elapsed time info for the frame
     */
    @Override
    public void update(ElapsedTime elapsedTime) {
        Input input = game.getInput();
        List<GameTouchEvent> touchEvents = input.getTouchEvents();

        if(touchEvents.size()>0){
            GameTouchEvent touchEvent = touchEvents.get(0);

            if(pauseIconBound.contains((int) touchEvent.x, (int) touchEvent.y)&& touchEvent.typeOfTouchEvent == GameTouchEvent.TOUCH_DOWN){
                this.levelState = levelState.paused;

            }
        }

    }


    /**
     * update method
     * @param elapsedTime- elapsed time info for the frame
     * @param graphics2DInterface- graphics interface which is used to draw the game screen
     */
    @Override
    public void draw(ElapsedTime elapsedTime, Graphics2DInterface graphics2DInterface) {

        int pauseLeft= graphics2DInterface.getSurfaceWidth()-145;
        int pauseTop = graphics2DInterface.getSurfaceHeight()-1750;

        int deckLeft=60;
        int enemyDeckTop=60;




        if(backgroundBound == null){
            backgroundBound = new Rect(0, 0, graphics2DInterface.getSurfaceWidth(),
                    graphics2DInterface.getSurfaceHeight());
        }

        if(pauseIconBound == null){
            pauseIconBound = new Rect(pauseLeft, pauseTop, pauseLeft+PAUSE_BUTTON_WIDTH,
                    pauseTop+PAUSE_BUTTON_HEIGHT);
        }

        if(enemyDeckBound == null){
                enemyDeckBound = new Rect(deckLeft,enemyDeckTop, graphics2DInterface.getSurfaceWidth()-50, 420);
        }


        if(player1DeckBound == null){

           player1DeckBound = new Rect(deckLeft, graphics2DInterface.getSurfaceHeight()-350, graphics2DInterface.getSurfaceWidth()-30,
                    graphics2DInterface.getSurfaceHeight()-30);
        }

        if(card1Bound == null){
            card1Bound = new Rect(20, 20, 20 + CARD_WIDTH,
                    20 + CARD_HEIGHT);
        }

        if(pauseIconBound == null){
            pauseIconBound = new Rect(deckLeft, graphics2DInterface.getSurfaceHeight()-350, graphics2DInterface.getSurfaceWidth()-30,
                    graphics2DInterface.getSurfaceHeight()-30);
        }

        /*if(levelState == levelState.paused){
            pauseOverlay.draw(elapsedTime, graphics2DInterface, layerViewport,
                    screenViewport);
        }*/



        graphics2DInterface.drawBitmap(backgroundBitmap, null, backgroundBound, null);
        graphics2DInterface.drawBitmap(pauseIconBitmap, null, pauseIconBound, null);
        graphics2DInterface.drawBitmap(enemyDeckBitmap, null, enemyDeckBound, null);
        graphics2DInterface.drawBitmap(player1DeckBitmap, null, player1DeckBound, null);
        graphics2DInterface.drawBitmap(pauseIconBitmap, null, pauseIconBound, null);
       // graphics2DInterface.drawBitmap(card1Bitmap, null, card1Bound, null);


    }





    /**
     * game dispose
     */
    @Override
    public void dispose() {
     return;
    }


    /**
     * game pause
     */
    @Override
    public void pause() {

       return;
    }


    /**
     * game resume
     */
    @Override
    public void resume() {
        return;

    }


}

