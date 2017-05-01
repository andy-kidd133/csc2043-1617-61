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



    //////////////////////////////////////
    ///////Constructor
    /////////////////////////////////////

    /**
     * create a new rules screen
     * @param game
     */
    public RulesScreen(Game game){
        super(SCREEN_NAME, game);

        this.currentRulesPage=0;

        AssetManager assetManager = game.getAssetManager();
        assetManager.emptyAssets();

        assetManager.loadAndAddBitmap("backgroundLayer", "images/qubbg.png");
        assetManager.loadAndAddBitmap("rulesmenu1", "images/rules_menu1.png");
        assetManager.loadAndAddBitmap("rulesMenu2", "images/rules_menu2.png");
        assetManager.loadAndAddBitmap("backbutton", "images/back_btn.png");
        assetManager.loadAndAddBitmap("forwardButton", "images/foward_btn.png");

        this.backgroundBitmap = assetManager.getBitmap("backgroundLayer");
        this.rulesMenuBitmap1 = assetManager.getBitmap("rulesmenu1");
        this.rulesMenuBitmap2 = assetManager.getBitmap("rulesMenu2");
        this.forwardButtonBitmap = assetManager.getBitmap("forwardButton");
        this.backButtonBitmap = assetManager.getBitmap("backbutton");

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

        Input input = game.getInput();
        List<GameTouchEvent> touchEvents = input.getTouchEvents();
        if (touchEvents.size() > 0) {
            GameTouchEvent touchEvent = touchEvents.get(0);

            if (backButtonBound.contains((int) touchEvent.x, (int) touchEvent.y)&& touchEvent.typeOfTouchEvent == GameTouchEvent.TOUCH_UP) {

                if (currentRulesPage == 0) {
                    game.getScreenManager().removeScreen(this.getmName());
                    MainMenuScreen mainMenuScreen = new MainMenuScreen(this.getmGame());
                    game.getScreenManager().addGameScreen(mainMenuScreen);


                } else {
                    currentRulesPage--;
                }
            }

            if (fowardButton.contains((int) touchEvent.x,
                    (int) touchEvent.y)
                    && touchEvent.typeOfTouchEvent == GameTouchEvent.TOUCH_UP) {
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

        int rulesMenuTop=140;
        int rulesMenuLeft = 120;
        int backTop= graphics2DInterface.getSurfaceHeight()-155;
        int backLeft=20;
        int fowardLeft=190;




        if(backgroundBound == null){
            backgroundBound = new Rect(0, 0, graphics2DInterface.getSurfaceWidth(),
                    graphics2DInterface.getSurfaceHeight());
        }

        if(fowardButton == null){
            fowardButton = new Rect(fowardLeft, backTop, fowardLeft+BUTTON_WIDTH, backTop+BUTTON_HEIGHT);
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
            backButtonBound = new Rect(backLeft, backTop, backLeft+BUTTON_WIDTH,
                    backTop+BUTTON_HEIGHT);
        }


        graphics2DInterface.drawBitmap(backgroundBitmap, null, backgroundBound, null);

        graphics2DInterface.drawBitmap(backButtonBitmap, null, backButtonBound, null);
        graphics2DInterface.drawBitmap(forwardButtonBitmap, null, fowardButton, null);

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























