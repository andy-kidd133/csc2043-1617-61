package com.example.andrew.ark9studios.Screens;

import android.graphics.Bitmap;
import android.graphics.Rect;

import com.example.andrew.ark9studios.AssetManager;
import com.example.andrew.ark9studios.BoundingBox;
import com.example.andrew.ark9studios.Game;
import com.example.andrew.ark9studios.GameGraphics.Graphics2DInterface;
import com.example.andrew.ark9studios.GameGraphics.GraphicsHelper;
import com.example.andrew.ark9studios.GameInput.GameTouchEvent;
import com.example.andrew.ark9studios.GameInput.Input;
import com.example.andrew.ark9studios.GameMusic;
import com.example.andrew.ark9studios.GameObjectFactory;
import com.example.andrew.ark9studios.GameScreen;
import com.example.andrew.ark9studios.InputControl;
import com.example.andrew.ark9studios.PauseOverlay;
import com.example.andrew.ark9studios.gameInfrastructure.ElapsedTime;

import java.util.List;

import viewports.LayerViewport;
import viewports.ScreenViewport;

/**
 * Created by Megan on 25/04/2017.
 */

public abstract class GameLevel extends GameScreen {


    protected final float levelWidth;

    protected final float levelHeight;



    protected AssetManager assetManager;

    protected GameMusic gameMusic;


    protected ScreenViewport screenViewport;

    protected LayerViewport layerViewport;


    protected InputControl pauseButton;


    protected  enum gameLvlState{
        Running, mainMenu, Paused, Exited, Over, Finishing, Complete
    }


    protected gameLvlState gameLvlState;


    protected PauseOverlay pauseOverlay;

    private Rect backgroundBound;
    private Bitmap background;




    public GameLevel(String name, Game game, float levelWidth, float levelHeight){
        super(name, game);

        this.levelWidth = levelWidth;
        this.levelHeight=levelHeight;
        this.assetManager= game.getAssetManager();
        this.gameLvlState= gameLvlState.Running;

    }


    public void canFinish(){
        gameLvlState = gameLvlState.Finishing;
    }






    @Override
    public void update(ElapsedTime elapsedTime) {


        if(gameLvlState == gameLvlState.Running) {
            if (pauseButton.hasTouchUp()) {
                gameLvlState = gameLvlState.Paused;
            }

        }

        if(gameLvlState == gameLvlState.Paused){
            pauseOverlay.update(elapsedTime);

            if(pauseOverlay.isResumed()){
                gameLvlState = gameLvlState.Running;
            }else if(pauseOverlay.isExited()){
                gameLvlState = gameLvlState.Exited;
            }else if(pauseOverlay.isMainMenu()){
                gameLvlState =gameLvlState.mainMenu;
            }

        }else if (gameLvlState == gameLvlState.Exited) {
            exitLevel();
        }else if(gameLvlState == gameLvlState.mainMenu){
            backToMenu();
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

    @Override
    public void draw(ElapsedTime elapsedTime, Graphics2DInterface graphics2DInterface) {


        if(gameLvlState == gameLvlState.Running || gameLvlState ==
             gameLvlState.Finishing){

            if (backgroundBound == null) {
                backgroundBound = new Rect(0, 0, graphics2DInterface.getSurfaceWidth(),
                        graphics2DInterface.getSurfaceHeight());
            }


            graphics2DInterface.drawBitmap(background, null, backgroundBound, null);

            pauseButton.draw(elapsedTime, graphics2DInterface, layerViewport,
                    screenViewport);
        }


        if(gameLvlState == gameLvlState.Paused){

            //draw the paused screen
            pauseOverlay.draw(elapsedTime,graphics2DInterface, layerViewport, screenViewport);
        }
    }


    /***
     * Functionality to run upon level exit
     */
    public abstract void exitLevel();



    /***
     * Functionality to run upon back to menu
     */
    public abstract void backToMenu();




    public void loadLevelAssets(){
      assetManager.emptyAssets();

        assetManager.loadAndAddBitmap("pauseButton", "images/pause_button.png");
        assetManager.loadAndAddBitmap("ResumeButton", "images/pauseresume.png");
        assetManager.loadAndAddBitmap("pauseMenu", "images/pausemenu.png");
        assetManager.loadAndAddBitmap("QuitButton", "images/pausequit.png");
        assetManager.loadAndAddBitmap("mainMenuButton", "images/pausemainmenu.png");
        assetManager.loadAndAddBitmap("Background", "images/qubbg.png");
        this.background = assetManager.getBitmap("Background");


    }




    public void setUpLevel(){

        setupViewports();

        setupInputControls();
        setupPauseOverlay();

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
        int screenHeight = game.getScreenHeight();


        pauseButton = GameObjectFactory.createInputControl(
                screenWidth - 100.0f, 65.0f,
                assetManager.getBitmap("pauseButton"), 70.0f, 70.0f, this);
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
    @Override
    public void dispose() {
    assetManager.emptyAssets();
    }

    @Override
    public void pause() {

        gameLvlState = gameLvlState.Paused;

    }

    @Override
    public void resume() {

    }
}
