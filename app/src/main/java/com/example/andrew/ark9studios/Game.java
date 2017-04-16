package com.example.andrew.ark9studios;

import android.app.Activity;
import android.media.AudioManager;
import android.util.DisplayMetrics;
import android.view.View;

import com.example.andrew.ark9studios.GameInput.Input;
import com.example.andrew.ark9studios.gameInfrastructure.ScreenManager;
import com.example.andrew.ark9studios.GameGraphics.CanvasRenderSurface;
import com.example.andrew.ark9studios.IO.FileIO;
import com.example.andrew.ark9studios.fragments.GameFragment;
import com.example.andrew.ark9studios.gameInfrastructure.ElapsedTime;
import com.example.andrew.ark9studios.gameInfrastructure.GameLoop;

/**
 * Created by Andrew on 08/02/2017.
 * code added by megan
 */

public class Game  {


        //////////////////////////////////////////////////////////////////
        //Variables
        //////////////////////////////////////////////////////////////////
        private static final int TARGET_GAME_FRAME_RATE=30;
        private AssetManager mAssetManager;
        private ScreenManager mScreenManager;
        private Input input;
        private FileIO mFileIO;
        private CanvasRenderSurface mRenderSurface;
        private GameLoop mLoop;
        private int mScreenWidth = -1;
        private int mScreenHeight = -1;
        private Activity activity;
        //////////////////////////////////////////////////////////////////
        //Getters
        //////////////////////////////////////////////////////////////////
        public FileIO getFileIO() {
            return mFileIO;
        }
        public int getScreenWidth() {
            return mScreenWidth;
        }
        public int getScreenHeight() {
            return mScreenHeight;
        }
        public AssetManager getAssetManager() {
            return mAssetManager;
        }
        public ScreenManager getScreenManager() {
            return mScreenManager;
        }
        public GameLoop getmLoop(){
            return mLoop;
        }
        public Input getInput(){ return input;}
        public Activity getActivity(){
            return  activity;
        }
        //////////////////////////////////////////////////////////////////
        //Constructor
        //////////////////////////////////////////////////////////////////
        public Game(GameFragment mainGameFragment){
            this.activity = mainGameFragment.getActivity();
        }
        //////////////////////////////////////////////////////////////////
        //Methods
        //////////////////////////////////////////////////////////////////
        /***
         * initialises the games key components
         */
        public void initialiseGameComponents(){
            //create a new game loop
            mLoop = new GameLoop(this, TARGET_GAME_FRAME_RATE);
            //create the game IO service
            mFileIO = new FileIO(activity.getApplicationContext());
            //create the game asset manager
            mAssetManager = new AssetManager(mFileIO);
            //create the screen manager
            mScreenManager = new ScreenManager();
            //request control of the phone/tablet volume
            activity.setVolumeControlStream(AudioManager.STREAM_MUSIC);
        }
        /***
         * Creates and returns the render surface the game will be displayed on
         *
         * @return view - game render surface
         */
        public View setUpViewAndReturn(){
            mRenderSurface = new CanvasRenderSurface(this, activity);
            View view = mRenderSurface.getAsView();

            input = new Input(activity, view);

            DisplayMetrics metrics = new DisplayMetrics();
            activity.getWindowManager().getDefaultDisplay().getMetrics(metrics);
            mScreenWidth = metrics.widthPixels;
            mScreenHeight = metrics.heightPixels;

            return view;
        }
        /***
         * This method pauses the game loop and the current game screen
         */
        public void resume(){
            //pauses the current game screen
            if(mScreenManager.getCurrentGameScreen() != null){
                mScreenManager.getCurrentGameScreen().pause();
            }
            mLoop.resume();
        }
        /***
         * Pause of the game that pauses the game loop and the current screen being
         * displayed
         */
        public void pause() {
            // Pause the game loop
            mLoop.pause();
            // If needed, pause the current game screen
            if (mScreenManager.getCurrentGameScreen() != null) {
                mScreenManager.getCurrentGameScreen().pause();
            }
        }
        /***
         * Disposes of any game screens
         */
        public void destroy() {
            // Dispose of any game screens
            mScreenManager.dispose();
        }
        /**
         * Perform the update step
         *
         * @param elapsedTime
         *            Elapsed time information for the current frame
         */
        public void update(ElapsedTime elapsedTime) {
            // Reset accumulators for keys/touch events for the current frame
            input.resetAccumulators();
            // Get and update the current game screen
            GameScreen gameScreen = mScreenManager.getCurrentGameScreen();
            if (gameScreen != null)
                gameScreen.update(elapsedTime);

            // It is assumed that if the update is multi-threaded then the
            // method call will not return until all update processes have
            // completed. Once this happens, notify the game loop.
            notifyIfUpdateCompleted();
        }
        /**
         * Notify the game loop that the update has completed. This method is in
         * invoked automatically once control has returned from the Game update()
         * method.
         */
        public void notifyIfUpdateCompleted() {
            mLoop.notifyIfUpdateCompleted();
        }
        /***
         * Perform the draw step
         *
         * @param elapsedTime
         *            - Elapsed time information for the current frame
         */
        public void draw(ElapsedTime elapsedTime) {
            // Get and draw the current screen. Th e render surface will
            // invoked Game.notifyDrawCompleted when the draw is done.
            GameScreen gameScreen = mScreenManager.getCurrentGameScreen();
            if (gameScreen != null) {
                mRenderSurface.render(elapsedTime, gameScreen);
            }
        }
        /**
         * Notify the game loop that the draw has completed. This method is in
         * invoked automatically by the render surface when the draw has completed.
         */
        public void notifyIfDrawCompleted() {
            mLoop.notifyIfDrawCompleted();
        }
        /***
         * Show this GameScreen upon launch of the application
         *
         * @param gameScreen
         *            - screen to be shown
         */
        public void setupInitialGameScreen(GameScreen gameScreen) {
            mScreenManager.addGameScreen(gameScreen);
        }
        /**
         * Method that is useful for changing from one GameScreen to another.
         *
         * @param fromScreen
         *            - screen coming from
         * @param toScreen
         *            - screen want to change to
         */
        public void changeScreen(GameScreen fromScreen, GameScreen toScreen) {
            mScreenManager.transitionScreens(fromScreen, toScreen);
        }



    }
