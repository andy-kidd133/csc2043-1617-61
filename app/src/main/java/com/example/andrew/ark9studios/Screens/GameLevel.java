package com.example.andrew.ark9studios.Screens;


import android.graphics.Bitmap;
import android.graphics.Rect;

import com.example.andrew.ark9studios.AssetManager;
import com.example.andrew.ark9studios.BoardSetupHelper;
import com.example.andrew.ark9studios.BoundingBox;
import com.example.andrew.ark9studios.Game;
import com.example.andrew.ark9studios.GameGraphics.Graphics2DInterface;
import com.example.andrew.ark9studios.GameGraphics.GraphicsHelper;
import com.example.andrew.ark9studios.GameInput.GameTouchEvent;
import com.example.andrew.ark9studios.GameInput.Input;
import com.example.andrew.ark9studios.Music.GameMusic;
import com.example.andrew.ark9studios.GameObjectFactory;
import com.example.andrew.ark9studios.GameScreen;
import com.example.andrew.ark9studios.InputControl;
import com.example.andrew.ark9studios.card.Deck;
import com.example.andrew.ark9studios.gameInfrastructure.ElapsedTime;

import java.util.List;

import viewports.LayerViewport;
import viewports.ScreenViewport;

/**
 * Created by Megan on 25/04/2017.
 */

/**
 * this is an abstract class that provides the common functionality that is available  to a game level
 */

public abstract class GameLevel extends GameScreen {


    /**
     * Width of the Level in the Game
     */
    protected final float levelWidth;

    /**
     * Height of the Level in the game
     */
    protected final float levelHeight;

    /**
     * AssetManager used to access games assets
     */
    protected AssetManager assetManager;

    /**
     * game music
     */
    protected GameMusic gameMusic;

    /***
     * Screen window
     */
    protected ScreenViewport screenViewport;


    /***
     * Window into GameWorld
     */
    protected LayerViewport layerViewport;

    /**
     * User input controls for managing the game
     */
    protected InputControl pauseButton;


    /***
     *
     * Enum that describes possible level states
     *
     */
    protected  enum gameLvlState{
        Running, mainMenu, Paused, Finishing
    }

    /**
     * Current game state
     */
    protected gameLvlState gameLvlState;


    /***
     * PauseOverlay Object shown on Pause
     */
    protected PauseOverlay pauseOverlay;

    /**
     * Draw Rect for the background bitmap
     */
    private Rect backgroundBound;

    /**
     * Draw Rect for the card bitmap
     */
    private Rect enemyBench_Bound;
    /**
     * Draw Rect for the enemy deck
     */
    private Rect player1BenchBound;


    /**
     * Draw rect for the deck 1
     */
    private Rect deck_cardBound1;

    /**
     * Draw Rect for the deck 2
     */
    private Rect deck_cardBound2;


    /**
     * Bitmap for the background
     */
    private Bitmap background;


    /**
     * Bitmap for the enemydeck
     */
    private Bitmap enemyBenchBitmap;
    /**
     * Bitmap for the player 1 deck
     */
    private Bitmap player1BenchBitmap;

    /**
     * Bitmap for deck card 1
     */
    private Bitmap deck_cardBitmap1;

    /**
     * Bitmap for deck card 2
     */
    private Bitmap deck_cardBitmap2;

    private BoardSetupHelper boardSetupHelper;


    /**
     * create a new game level
     * @param name- name of the gameScreen
     * @param game- game instance of the game level
     * @param levelWidth- width of the level
     * @param levelHeight- height of the level
     */
    public GameLevel(String name, Game game, float levelWidth, float levelHeight){
        super(name, game);

        this.levelWidth = levelWidth;
        this.levelHeight=levelHeight;
        this.assetManager= game.getAssetManager();
        this.gameLvlState= gameLvlState.Running;

        boardSetupHelper = new BoardSetupHelper(game);

    }


    /**
     * Update the game level
     * @param elapsedTime- elapsed time info for the frame
     */

    @Override
    public void update(ElapsedTime elapsedTime) {


        if(gameLvlState == gameLvlState.Running) {
            if (pauseButton.hasTouchUp()) {
                gameLvlState = gameLvlState.Paused;
            }

        }else if(gameLvlState == gameLvlState.Paused){
            pauseOverlay.update(elapsedTime);
            if(pauseOverlay.isResumed()){
                gameLvlState = gameLvlState.Running;
            }else if(pauseOverlay.isMainMenu()){
                backToMenu();
            }

            if(pauseOverlay.isSoundToggled()){
                game.toggleSound();
            }

        }



        // Ensure the viewport cannot leave the confines of the world
        if (layerViewport.getLeft() < 0) {
            layerViewport.x -= layerViewport.getLeft();
        } else if (layerViewport.getRight() > levelWidth) {
            layerViewport.x -= (layerViewport.getRight() - levelWidth);
        }
        if (layerViewport.getBottom() < 0) {
            layerViewport.y -= layerViewport.getBottom();
        } else if (layerViewport.getTop() > levelHeight) {
            layerViewport.y -= (layerViewport.getTop() - levelHeight);
        }
    }


    /**
     * draw game level
     * @param elapsedTime- elapsed time info for the frame
     * @param graphics2DInterface- graphics interface which is used to draw the game screen
     */
    @Override
    public void draw(ElapsedTime elapsedTime, Graphics2DInterface graphics2DInterface) {

        boardSetupHelper.drawGameSetup(graphics2DInterface);

        if(gameLvlState == gameLvlState.Running || gameLvlState ==
             gameLvlState.Finishing){

            pauseButton.draw(elapsedTime, graphics2DInterface, layerViewport,
                    screenViewport);
        } else  if(gameLvlState == gameLvlState.Paused){

            //draw the paused screen
            pauseOverlay.draw(elapsedTime,graphics2DInterface, layerViewport, screenViewport);
        }


    }






    /***
     * Functionality to run upon back to menu
     */
    public void backToMenu(){
        gameMusic.stop();
    }


    /**
     * load common bitmaps
     */
    public void loadLevelAssets(){
      assetManager.emptyAssets();

       assetManager.loadAndAddBitmap("Background", "images/qubbg.png");
        assetManager.loadAndAddBitmap("pauseButton", "images/pause_button.png");
        assetManager.loadAndAddBitmap("backgroundLayer", "images/qubbg.png");
        assetManager.loadAndAddBitmap("player1_bench", "images/player1bench.png");
        assetManager.loadAndAddBitmap("enemy_bench", "images/enemy_bench.png");
        assetManager.loadAndAddBitmap("deck_card1", "images/deck_card1.png");
        assetManager.loadAndAddBitmap("deck_card2", "images/deck_card2.png");
        assetManager.loadAndAddBitmap("ResumeButton", "images/pauseresume.png");
        assetManager.loadAndAddBitmap("pauseMenu", "images/pausemenu.png");
        assetManager.loadAndAddBitmap("SoundOnButton", "images/music_on.png");
        assetManager.loadAndAddBitmap("SoundOff", "images/music_off.png");
        assetManager.loadAndAddBitmap("mainMenuButton", "images/pausemainmenu.png");
        assetManager.loadAndAddMusic("playGameMusic", "raw/laser_groove.mp3");


        this.background =   assetManager.getBitmap("Background");
        this.player1BenchBitmap = assetManager.getBitmap("player1_bench");
        this.enemyBenchBitmap = assetManager.getBitmap("enemy_bench");
        this.deck_cardBitmap1 = assetManager.getBitmap("deck_card1");
        this.deck_cardBitmap2 = assetManager.getBitmap("deck_card2");

    }


    /**
     * set up the common game level objects
     */
    public void setUpLevel(){

        setupViewports();
        setupInputControls();
        startBackgroundMusic();
        setupPauseOverlay();

    }


    /**
     * game level disposed
     */
    @Override
    public void dispose() {
        gameMusic.dispose();
        assetManager.emptyAssets();

    }

    /**
     * game level paused
     */
    @Override
    public void pause() {
        gameLvlState = gameLvlState.Paused;
        gameMusic.pause();

    }

    /**
     * game level resumed
     */

    @Override
    public void resume() {

        gameMusic.play();
    }




    /***
     * Setup and instantiate the desired position of the PauseOverlay
     */
    protected void setupPauseOverlay() {
        int width = 900;
        int height = 700;
        float x = 600.0f;
        float y = 800.0f;
        pauseOverlay = new PauseOverlay(x, y, width, height,
                assetManager.getBitmap("pauseMenu"), this);
    }



    /***
     * Setup LayerViewport and ScreenViewport
     */
    protected void setupViewports() {
        // Create the view ports
        layerViewport = new LayerViewport(600.0f, 400.0f, 600.0f, 400.0f);
        screenViewport = new ScreenViewport();
        GraphicsHelper
                .create3To2AspectRatioScreenViewport(game, screenViewport);
        // stretch the viewport to fill horizontal
        GraphicsHelper.stretchScreenViewportToFillHorizontal(game,
                screenViewport);
    }


    /***
     * Create the User Interface controls
     */
    protected void setupInputControls() {
        // Create the touch controls
        int screenWidth = game.getScreenWidth();



        pauseButton = GameObjectFactory.createInputControl(
                screenWidth - 50.0f, 65.0f,
                assetManager.getBitmap("pauseButton"), 70.0f, 70.0f, this);
    }


    /***
     * start game music
     */
    protected void startBackgroundMusic() {
        this.gameMusic = assetManager.getMusic("playGameMusic");
        gameMusic.setLooping(true);
        gameMusic.play();
    }

    /***
     * Check whether only the screen has been tapped. If input controls have
     * been tapped then return false as we want the input control to fire and
     * not a screen tap.
     *
     * @return whether the screen only has been tapped
     */
    private boolean isScreenTapped() {
        // Consider any touch events occurring in this update
        Input input = game.getInput();


        BoundingBox pauseButtonBound = pauseButton.getBound();

        List<GameTouchEvent> touchUpEvents = input
                .touchEventsFor(GameTouchEvent.TOUCH_UP);
        for (GameTouchEvent touchUpEvent : touchUpEvents) {
            float x = touchUpEvent.x;
            float y = touchUpEvent.y;
            if ( !pauseButtonBound.contains(x, y)) {
                return true;
            }

        }
        return false;
    }


}
