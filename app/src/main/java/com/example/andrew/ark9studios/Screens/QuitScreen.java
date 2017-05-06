package com.example.andrew.ark9studios.Screens;



import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Rect;

import com.example.andrew.ark9studios.AssetManager;
import com.example.andrew.ark9studios.Game;
import com.example.andrew.ark9studios.GameGraphics.Graphics2DInterface;
import com.example.andrew.ark9studios.GameInput.GameTouchEvent;
import com.example.andrew.ark9studios.GameInput.Input;
import com.example.andrew.ark9studios.GameScreen;
import com.example.andrew.ark9studios.Music.Sound;
import com.example.andrew.ark9studios.activities.ClosingActivity;
import com.example.andrew.ark9studios.gameInfrastructure.ElapsedTime;

import java.util.List;


/**
 * Created by megan on 02/03/2017.
 */

/**
 * Quit Screen
 */
public class QuitScreen extends GameScreen{

    //////////////////////////////////////
    ///////Variables
    /////////////////////////////////////

    /**
     * Draw Rect for the background bitmap
     */
    private Rect backgroundBound;

    /**
     * Draw Rect for the quit menu bitmap
     */
    private Rect quitMenuBound;

    /**
     * Draw Rect for the yes button bitmap
     */
    private Rect yesButtonBound;

    /**
     * Draw Rect for the no button bitmap
     */
    private Rect noButtonBound;

    /**
     * background bitmap
     */
    private Bitmap backgroundBitmap;
    /**
     * quit menu bitmap
     */
    private Bitmap quitMenuBitmap;

    /**
     * yes button bitmap
     */
    private Bitmap yesBitmap;

    /**
     * no button bitmap
     */
    private Bitmap noBitmap;

    /**
     * name of screen
     */
    private static final String SCREEN_NAME="QuitScreen";


    /**
     * width of button
     */
    private static final int BUTTON_WIDTH = 500;
    /**
     * height of button
     */
    private static final int BUTTON_HEIGHT = 180;
    /**
     * width of mwnu template
     */
    private static final int MENU_TEMPLATE_WIDTH =1100;
    /**
     * height of menu template
     */
    private static final int MENU_TEMPLATE_HEIGHT = 1400;


    private MainMenuScreen mainMenuScreen;

    //getting the asset manager
    AssetManager assetManager = game.getAssetManager();

    /**
     * Menu select sound to be played
     */
    private Sound menuSelect;



    //////////////////////////////////////
    ///////Constructor
    /////////////////////////////////////

    /**
     * create a new quit screen
     * @param game- quit screen belongs to
     */
    public QuitScreen(Game game){
        super(SCREEN_NAME, game);

        //emptying the assets
        assetManager.emptyAssets();

        /**
         * try loading the bitmaps if, if there is an error print the stack trace
         */
        try {
            assetManager.loadAndAddBitmap("backgroundLayer", "images/qubbg.png");
            assetManager.loadAndAddBitmap("quitmenu", "images/quit_menu.png");
            assetManager.loadAndAddBitmap("yesbutton", "images/yes_button.png");
            assetManager.loadAndAddBitmap("nobutton", "images/no_button.png");
            assetManager.loadAndAddSound("menuSelect", "sfx/menuclick.mp3");
        }catch(Exception e){
            e.printStackTrace();
        }


        //initialising the variables
        this.backgroundBitmap = assetManager.getBitmap("backgroundLayer");
        this.quitMenuBitmap = assetManager.getBitmap("quitmenu");
        this.yesBitmap = assetManager.getBitmap("yesbutton");
        this.noBitmap = assetManager.getBitmap("nobutton");
        this.menuSelect = assetManager.getSound("menuSelect");


        mainMenuScreen = new MainMenuScreen(game);
        mainMenuScreen.getBackgroundMusic();


    }



    //////////////////////////////////////
    ///////Methods
    /////////////////////////////////////
    /**
     * quit screen update
     * @param elapsedTime- elapsed time info for the frame
     */
    @Override
    public void update(ElapsedTime elapsedTime) {

        //////////////////////////////////////
        ///process touches on the screen
        /////////////////////////////////////


     Input input = game.getInput();

        List<GameTouchEvent> touchEvents = input.getTouchEvents();

        if(touchEvents.size() > 0){
                GameTouchEvent touchEvent = touchEvents.get(0);

                if(yesButtonBound.contains((int) touchEvent.x, (int) touchEvent.y)){


                    /**
                     * Cuurently a Bug as it reloads the welcme activity/screen
                     * if we were to create the game again we wouldnt have included
                     * a quit option
                     */
                   System.exit(0);

                }

                if (noButtonBound.contains((int) touchEvent.x, (int) touchEvent.y)&& touchEvent.typeOfTouchEvent == GameTouchEvent.TOUCH_DOWN){

                    mainMenuScreen.getBackgroundMusic().pause();

                    //play menu select
                    assetManager.getSound("menuSelect").play();
                    //if the quit area has been touched then swap to the quit screen
                    game.getScreenManager().removeScreen(this.getmName());
                    MainMenuScreen mainMenuScreen = new MainMenuScreen(game);

                    //as this is the only added screen then it will become active
                    game.getScreenManager().addGameScreen(mainMenuScreen);

                }

            }

        }


    /**
     * quit screen draw
     * @param elapsedTime- elapsed time info for the frame
     * @param graphics2DInterface- graphics interface which is used to draw the game screen
     */
    @Override
    public void draw(ElapsedTime elapsedTime, Graphics2DInterface graphics2DInterface) {

        /**
         * used to position the quit menu image from the top of the screen
         */
        int quitMenuTop=140;

        /**
         * used to position the quit menu image from the left of the screen
         */
        int quitMenuLeft = 120;

        //vertical spacer for between the buttons
        int verticalSpacer=190;

        /**
         * used to position the buttons from the left of the screen
         */
        int buttonLeft =375;

        /**
         * used to position where the yes button will be from the top of
         * the screen
         */
        int yesButtonTop = 500;

        /**
         * used to position where the no button will be from the top of
         * the screen
         */
        int noButtonTop = yesButtonTop + verticalSpacer;



        if(backgroundBound == null){
            backgroundBound = new Rect(0, 0, graphics2DInterface.getSurfaceWidth(),
                    graphics2DInterface.getSurfaceHeight());
        }

        if(quitMenuBound == null){
            quitMenuBound = new Rect(quitMenuLeft, quitMenuTop , MENU_TEMPLATE_WIDTH,
                    MENU_TEMPLATE_HEIGHT);
        }

        if(yesButtonBound==null){
            yesButtonBound = new Rect(buttonLeft, yesButtonTop, buttonLeft+BUTTON_WIDTH,
                    yesButtonTop + BUTTON_HEIGHT);
        }

        if(noButtonBound==null){
            noButtonBound = new Rect(buttonLeft, noButtonTop, buttonLeft+BUTTON_WIDTH,
                    noButtonTop + BUTTON_HEIGHT);
        }




        //draw the bitmaps
        graphics2DInterface.drawBitmap(backgroundBitmap, null, backgroundBound, null);
        graphics2DInterface.drawBitmap(quitMenuBitmap, null, quitMenuBound, null);
        graphics2DInterface.drawBitmap(yesBitmap, null, yesButtonBound, null);
       graphics2DInterface.drawBitmap(noBitmap, null, noButtonBound, null);


    }

    /**
     * dispose method
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
