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

public class RulesScreen extends GameScreen {


    private Rect backgroundBound;
    private Rect rulesMenuBound1;
    private Rect rulesMenuBound2;
    private Rect fowardButton;
    private Rect backButtonBound;

    private int currentRulesPage = 0;



    private Bitmap backgroundBitmap;
    private Bitmap rulesMenuBitmap1;
    private Bitmap rulesMenuBitmap2;
    private Bitmap fowardButtonBitmap;
    private Bitmap backButtonBitmap;

    private static final String SCREEN_NAME="RulesScreen";
    private static final int MENU_TEMPLATE_WIDTH =1100;
    private static final int MENU_TEMPLATE_HEIGHT = 1400;

    private static final int BUTTON_WIDTH = 150;
    private static final int BUTTON_HEIGHT = 150;



    public RulesScreen(Game game){
        super(SCREEN_NAME, game);

        this.currentRulesPage=0;

        AssetManager assetManager = game.getAssetManager();
        assetManager.emptyAssets();

        assetManager.loadAndAddBitmap("backgroundLayer", "images/qubbg.png");
        assetManager.loadAndAddBitmap("rulesmenu1", "images/rules_menu1.png");
        assetManager.loadAndAddBitmap("rulesMenu2", "images/rules_menu2.png");
        assetManager.loadAndAddBitmap("backbutton", "images/back_btn.png");
        assetManager.loadAndAddBitmap("fowardButton", "images/foward_btn.png");

        this.backgroundBitmap = assetManager.getBitmap("backgroundLayer");
        this.rulesMenuBitmap1 = assetManager.getBitmap("rulesmenu1");
        this.rulesMenuBitmap2 = assetManager.getBitmap("rulesMenu2");
        this.fowardButtonBitmap = assetManager.getBitmap("fowardButton");
        this.backButtonBitmap = assetManager.getBitmap("backbutton");

    }






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
        graphics2DInterface.drawBitmap(fowardButtonBitmap, null, fowardButton, null);

        if(currentRulesPage == 0){
            graphics2DInterface.drawBitmap(rulesMenuBitmap1, null, rulesMenuBound1, null);
        }else if (currentRulesPage == 1){
            graphics2DInterface.drawBitmap(rulesMenuBitmap2, null, rulesMenuBound2, null);
        }













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























