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
 * Rules screen
 */

public class RulesScreen extends GameScreen {

    //////////////////////////////////////
    ///////Variables
    /////////////////////////////////////

    /**
     * Draw Rect for the background bitmap
     */
    private Rect backgroundBound;

    /**
     * Draw Rect for the menu1 bitmap
     */
    private Rect rulesMenuBound1;
    /**
     * Draw Rect for the menu2 bitmap
     */
    private Rect rulesMenuBound2;
    /**
     * Draw Rect for the foward button bitmap
     */
    private Rect fowardButton;
    /**
     * Draw Rect for the back button bitmap
     */
    private Rect backButtonBound;

    /**
     * The number of current rules pages
     */
    private int currentRulesPage;

    /**
     * background bitmap
     */
    private Bitmap backgroundBitmap;
    /**
     * rules menu 1 bitmap
     */
    private Bitmap rulesMenuBitmap1;
    /**
     * rules menu 2 bitmap
     */
    private Bitmap rulesMenuBitmap2;
    /**
     * forward button bitmap
     */
    private Bitmap forwardButtonBitmap;
    /**
     * back button bitmap
     */
    private Bitmap backButtonBitmap;

    /**
     * screen name
     */
    private static final String SCREEN_NAME="RulesScreen";
    /**
     * width of menu
     */
    private static final int MENU_TEMPLATE_WIDTH =1100;
    /**
     * height of menu
     */
    private static final int MENU_TEMPLATE_HEIGHT = 1400;
    /**
     * width of button
     */
    private static final int BUTTON_WIDTH = 150;
    /**
     * height of button
     */
    private static final int BUTTON_HEIGHT = 150;

    //getting the asset manager
    AssetManager assetManager = game.getAssetManager();

    //////////////////////////////////////
    ///////Constructor
    /////////////////////////////////////

    /**
     * create a new rules screen
     * @param game
     */
    public RulesScreen(Game game){
        super(SCREEN_NAME, game);




        //emptying the assets
        assetManager.emptyAssets();

        /**
         * try loading the bitmaps if, if there is an error print the stack trace
         */
        try {
            assetManager.loadAndAddBitmap("backgroundLayer", "images/qubbg.png");
            assetManager.loadAndAddBitmap("rulesmenu1", "images/rules_menu1.png");
            assetManager.loadAndAddBitmap("rulesMenu2", "images/rules_menu2.png");
            assetManager.loadAndAddBitmap("backbutton", "images/back_btn.png");
            assetManager.loadAndAddBitmap("forwardButton", "images/foward_btn.png");
        }catch(Exception e){
            e.printStackTrace();
        }

        //initialising the variables
        this.backgroundBitmap = assetManager.getBitmap("backgroundLayer");
        this.rulesMenuBitmap1 = assetManager.getBitmap("rulesmenu1");
        this.rulesMenuBitmap2 = assetManager.getBitmap("rulesMenu2");
        this.forwardButtonBitmap = assetManager.getBitmap("forwardButton");
        this.backButtonBitmap = assetManager.getBitmap("backbutton");

        this.currentRulesPage=0;

    }



    //////////////////////////////////////
    ///////Methods
    /////////////////////////////////////


    /**
     * rules draw method
     * @param elapsedTime- elapsed time info for the frame
     */
    @Override
    public void update(ElapsedTime elapsedTime) {

        //////////////////////////////////////
        ///process touches on the screen
        //////////////////////////////////

        Input input = game.getInput();
        List<GameTouchEvent> touchEvents = input.getTouchEvents();
        if (touchEvents.size() > 0) {

            /**
             * check the first touch event.
             */
            GameTouchEvent touchEvent = touchEvents.get(0);

            /**
             * the touchEvent.typeOfTouchEvent allows us to decide what type of touch we want on the if statement;
             * up, down , dragged
             */
            if (backButtonBound.contains((int) touchEvent.x, (int) touchEvent.y)&& touchEvent.typeOfTouchEvent == GameTouchEvent.TOUCH_UP) {

                //play menu select
                assetManager.getSound("menuSelect").play();

                /**
                 * if the current page equals 0 then
                 * the screens are swapped
                 */
                if (currentRulesPage == 0) {
                    //if the play game area has been touched then swap to the GameLevelOne screen
                    game.getScreenManager().removeScreen(this.getmName());
                    MainMenuScreen mainMenuScreen = new MainMenuScreen(this.getmGame());

                    //as this is the only added screen then it will become active
                    game.getScreenManager().addGameScreen(mainMenuScreen);


                } else {
                    currentRulesPage--;
                }
            }

            if (fowardButton.contains((int) touchEvent.x,
                    (int) touchEvent.y)
                    && touchEvent.typeOfTouchEvent == GameTouchEvent.TOUCH_UP) {

                //play menu select
                assetManager.getSound("menuSelect").play();

                /**
                 * if the current page equals 0
                 * then increment the number of pages
                 */
                if (currentRulesPage == 0) {
                    currentRulesPage++;
                }
            }

        }

    }


    /**
     * rules update method
     * @param elapsedTime- elapsed time info for the frame
     * @param graphics2DInterface- graphics interface which is used to draw the game screen
     */
    @Override
    public void draw(ElapsedTime elapsedTime, Graphics2DInterface graphics2DInterface) {


        /**
         * used to position the rules menu image from the top of the screen
         */
        int rulesMenuTop=140;

        /**
         * used to position the rules menu image from the left of the screen
         */
        int rulesMenuLeft = 120;

        /**
         * used to position where the back and foward button will be from the top of
         * the screen
         */
        int buttonTop= graphics2DInterface.getSurfaceHeight()-155;


        /**
         * used to position where the back button will be from the left of
         * the screen
         */
        int backLeft=20;


        /**
         * used to position where the foward button will be from the left of
         * the screen
         */
        int fowardLeft=190;




        if(backgroundBound == null){
            backgroundBound = new Rect(0, 0, graphics2DInterface.getSurfaceWidth(),
                    graphics2DInterface.getSurfaceHeight());
        }

        if(fowardButton == null){
            fowardButton = new Rect(fowardLeft, buttonTop, fowardLeft+BUTTON_WIDTH, buttonTop+BUTTON_HEIGHT);
        }

        if(rulesMenuBound1 == null){
            rulesMenuBound1 = new Rect(rulesMenuLeft, rulesMenuTop , MENU_TEMPLATE_WIDTH,
                    MENU_TEMPLATE_HEIGHT);
        }

        if(rulesMenuBound2 == null){
            rulesMenuBound2 = new Rect(rulesMenuLeft, rulesMenuTop , MENU_TEMPLATE_WIDTH,
                    MENU_TEMPLATE_HEIGHT);
        }

        if(backButtonBound==null){
            backButtonBound = new Rect(backLeft, buttonTop, backLeft+BUTTON_WIDTH,
                    buttonTop+BUTTON_HEIGHT);
        }


        //drawing the bitmaps out
        graphics2DInterface.drawBitmap(backgroundBitmap, null, backgroundBound, null);
        graphics2DInterface.drawBitmap(backButtonBitmap, null, backButtonBound, null);
        graphics2DInterface.drawBitmap(forwardButtonBitmap, null, fowardButton, null);

        /**
         * if the current number of pages equals 0 then draw the first rules page bitmap
         * if the number of pages equals 1 then draw the second rules page bitmap
         */
        if(currentRulesPage == 0){
            graphics2DInterface.drawBitmap(rulesMenuBitmap1, null, rulesMenuBound1, null);
        }else if (currentRulesPage == 1){
            graphics2DInterface.drawBitmap(rulesMenuBitmap2, null, rulesMenuBound2, null);
        }
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























