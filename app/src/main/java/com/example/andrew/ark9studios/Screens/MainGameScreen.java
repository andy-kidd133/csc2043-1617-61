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
    private Rect backgroundBound;
    private Rect pauseIconBound;
    private Rect player1DeckBound;
    private Rect enemyDeckBound;


    private Bitmap card1Bitmap;
    private Bitmap backgroundBitmap;
    private Bitmap pauseIconBitmap;
    private Bitmap player1DeckBitmap;
    private Bitmap enemyDeckBitmap;


    private static final int CARD_WIDTH = 150;
    private static final int CARD_HEIGHT = 150;

    private static final int DECK_WIDTH = 1100;
    private static final int DECK_HEIGHT = 400;


    private static final int PAUSE_BUTTON_WIDTH= 120;
    private static final int PAUSE_BUTTON_HEIGHT=130;

    protected PauseOverlay pauseOverlay;
    protected ScreenViewport screenViewport;
    protected LayerViewport layerViewport;


    //private GameMusic gameMusic;

    AssetManager assetManager = game.getAssetManager();

    protected enum GameLevelState {
        paused, running
    }

    protected GameLevelState levelState;

   public MainGameScreen(Game game){
       super(SCREEN_NAME, game);


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

        this.levelState = levelState.running;

       setUpPause();
       setupViewports();
     //  startBackgroundMusic();

   }




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


  /*  protected void startBackgroundMusic(){
        gameMusic = assetManager.getMusic("backgroundMusic");
        gameMusic.setLooping(true);
        gameMusic.startGameMusic();
    }
*/

    protected void setupViewports() {
        // Create the view ports
        layerViewport = new LayerViewport(600.0f, 400.0f, 600.0f, 400.0f);
        screenViewport = new ScreenViewport();
    }

    protected void setUpPause(){


        int width = 800;
        int height=800;
        float x = 500.0f;
        float y = 1000.0f;


        pauseOverlay = new PauseOverlay(x, y, width, height, assetManager.getBitmap("PauseMenu"), this);

    }


    /**
     * game dispose
     */
    @Override
    public void dispose() {
     //gameMusic.destroyGameMusic();
        assetManager.emptyAssets();
    }


    /**
     * game pause
     */
    @Override
    public void pause() {

        levelState = GameLevelState.paused;
        //gameMusic.pause();
    }


    /**
     * game resume
     */
    @Override
    public void resume() {
        //gameMusic.play();

    }


}

