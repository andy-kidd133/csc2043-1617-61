package com.example.andrew.ark9studios.fragments;



import android.graphics.Bitmap;
import android.graphics.Rect;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;


import com.example.andrew.ark9studios.Game;
import com.example.andrew.ark9studios.AssetManager;
import com.example.andrew.ark9studios.GameGraphics.Graphics2DInterface;
import com.example.andrew.ark9studios.GameInput.GameTouchEvent;
import com.example.andrew.ark9studios.GameInput.Input;
import com.example.andrew.ark9studios.GameScreen;
import com.example.andrew.ark9studios.gameInfrastructure.ElapsedTime;

import java.util.List;

/**
 * Created by Megan on 23/02/2017.
 */
public class MainMenuScreen extends GameScreen {

    private Rect backgroundBound;
    private Rect menuTemplateBound;
    private Rect playGameButtonBound;


    private Rect optionsButtonBound;

    private Rect rulesButtonBound;

    private Rect scoreboardButtonBound;


    private Rect quitButtonBound;



    private Bitmap backgroundBitmap;
    private Bitmap menuTemplateBitmap;
    private Bitmap playGameBitmap;
    private Bitmap optionsBitmap;
    private Bitmap rulesBitmap;
    private Bitmap scoreBoardBitmap;
    private Bitmap quitBitmap;


   private static final String SCREEN_NAME="MainMenuScreen";



    private static final int BUTTON_WIDTH = 500;

   private static final int BUTTON_HEIGHT = 180;

    private static final int MENU_TEMPLATE_WIDTH =1100;

    private static final int MENU_TEMPLATE_HEIGHT = 1400;



    public MainMenuScreen(Game game){
          super(SCREEN_NAME, game);

        AssetManager assetManager = game.getAssetManager();


        assetManager.emptyAssets();


        assetManager.loadAndAddBitmap("backgroundLayer", "images/qubbg.png");
        assetManager.loadAndAddBitmap("menuTemplate", "images/menuTemplate.png");
        assetManager.loadAndAddBitmap("playgamebutton", "images/button_play_game.png");
        assetManager.loadAndAddBitmap("optionsbutton", "images/option_button.png");
        assetManager.loadAndAddBitmap("rulesbutton", "images/button_rules.png");
        assetManager.loadAndAddBitmap("scoreboardbutton", "images/button_scoreboard.png");
        assetManager.loadAndAddBitmap("quitbutton", "images/button_quit.png");


        this.playGameBitmap = assetManager.getBitmap("playgamebutton");
        this.backgroundBitmap = assetManager.getBitmap("backgroundLayer");
        this.menuTemplateBitmap = assetManager.getBitmap("menuTemplate");
        this.optionsBitmap = assetManager.getBitmap("optionsbutton");
        this.rulesBitmap  = assetManager.getBitmap("rulesbutton");
        this.scoreBoardBitmap = assetManager.getBitmap("scoreboardbutton");
        this.quitBitmap = assetManager.getBitmap("quitbutton");




    }




    @Override
    public void update(ElapsedTime elapsedTime) {

        Input input = game.getInput();

        List<GameTouchEvent> touchEvents = input.getTouchEvents();

        if (touchEvents.size() > 0) {
           GameTouchEvent touchEvent = touchEvents.get(0);
           if(optionsButtonBound.contains((int) touchEvent.x, (int) touchEvent.y)){

                OptionsScreen optionsScreen = new OptionsScreen(game);
                game.changeScreen(this, optionsScreen);

            }
        }
    }

    @Override
    public void draw(ElapsedTime elapsedTime, Graphics2DInterface graphics2DInterface) {


        int verticalSpacer = 190;
        int menuTop=140;
        int menuLeft = 120;

        int buttonLeft =375;
        int playTop = 340;
        int optionTop = playTop + verticalSpacer;
        int rulesTop = optionTop + verticalSpacer;
        int scoreboardTop = rulesTop + verticalSpacer;
        int quitTop = scoreboardTop + verticalSpacer;


        if(playGameButtonBound == null){
            playGameButtonBound = new Rect(buttonLeft, playTop, buttonLeft+BUTTON_WIDTH,
                    playTop + BUTTON_HEIGHT);
        }

         if(optionsButtonBound == null){
            optionsButtonBound = new Rect(buttonLeft, optionTop, buttonLeft+BUTTON_WIDTH,
                     optionTop + BUTTON_HEIGHT);
         }

        if(rulesButtonBound == null){
            rulesButtonBound = new Rect(buttonLeft, rulesTop, buttonLeft+BUTTON_WIDTH,
                    rulesTop + BUTTON_HEIGHT);
        }

        if(scoreboardButtonBound == null){
            scoreboardButtonBound = new Rect(buttonLeft, scoreboardTop, buttonLeft+BUTTON_WIDTH,
                    scoreboardTop + BUTTON_HEIGHT);
        }

        if(quitButtonBound == null){
           quitButtonBound = new Rect(buttonLeft, quitTop, buttonLeft+BUTTON_WIDTH,
                    quitTop + BUTTON_HEIGHT);
        }

        if(backgroundBound == null){
            backgroundBound = new Rect(0, 0, graphics2DInterface.getSurfaceWidth(),
                    graphics2DInterface.getSurfaceHeight());
        }





        if(menuTemplateBound == null){
            menuTemplateBound = new Rect(menuLeft, menuTop , MENU_TEMPLATE_WIDTH,
                    MENU_TEMPLATE_HEIGHT);
        }

        graphics2DInterface.drawBitmap(backgroundBitmap, null, backgroundBound, null);
        graphics2DInterface.drawBitmap(menuTemplateBitmap, null, menuTemplateBound, null);
        graphics2DInterface.drawBitmap(playGameBitmap, null, playGameButtonBound, null);
        graphics2DInterface.drawBitmap(optionsBitmap, null, optionsButtonBound, null);
        graphics2DInterface.drawBitmap(rulesBitmap, null, rulesButtonBound, null);
        graphics2DInterface.drawBitmap(scoreBoardBitmap, null, scoreboardButtonBound, null);
        graphics2DInterface.drawBitmap(quitBitmap, null, quitButtonBound, null);

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