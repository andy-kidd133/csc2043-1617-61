package com.example.andrew.ark9studios.fragments;



import android.content.Intent;
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
import com.example.andrew.ark9studios.activities.GameActivity;
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
    private Rect backButtonBound;




    private Bitmap backgroundBitmap;
    private Bitmap menuTemplateBitmap;
    private Bitmap playGameBitmap;
    private Bitmap optionsBitmap;
    private Bitmap rulesBitmap;
    private Bitmap scoreBoardBitmap;
    private Bitmap quitBitmap;
    private Bitmap backButtonBitmap;



   private static final String SCREEN_NAME="MainMenuScreen";



    private static final int BUTTON_WIDTH = 500;

   private static final int BUTTON_HEIGHT = 180;

    private static final int MENU_TEMPLATE_WIDTH =1100;

    private static final int MENU_TEMPLATE_HEIGHT = 1400;

    private static final int BACK_BUTTON_WIDTH = 150;
    private static final int BACK_BUTTON_HEIGHT = 150;



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
        assetManager.loadAndAddBitmap("backbutton", "images/back_btn.png");



        this.playGameBitmap = assetManager.getBitmap("playgamebutton");
        this.backgroundBitmap = assetManager.getBitmap("backgroundLayer");
        this.menuTemplateBitmap = assetManager.getBitmap("menuTemplate");
        this.optionsBitmap = assetManager.getBitmap("optionsbutton");
        this.rulesBitmap  = assetManager.getBitmap("rulesbutton");
        this.scoreBoardBitmap = assetManager.getBitmap("scoreboardbutton");
        this.quitBitmap = assetManager.getBitmap("quitbutton");
        this.backButtonBitmap = assetManager.getBitmap("backbutton");





    }




    @Override
    public void update(ElapsedTime elapsedTime) {

        Input input = game.getInput();

        List<GameTouchEvent> touchEvents = input.getTouchEvents();

        if (touchEvents.size() > 0) {
            GameTouchEvent touchEvent = touchEvents.get(0);
            if (optionsButtonBound.contains((int) touchEvent.x, (int) touchEvent.y)) {

                OptionsScreen optionsScreen = new OptionsScreen(game);
                game.changeScreen(this, optionsScreen);

            } else if (rulesButtonBound.contains((int) touchEvent.x, (int) touchEvent.y)) {

                RulesScreen rulesScreen = new RulesScreen(game);
                game.changeScreen(this, rulesScreen);

            } else if (scoreboardButtonBound.contains((int) touchEvent.x, (int) touchEvent.y)){

                ScoreBoardScreen scoreBoardScreen = new ScoreBoardScreen(game);
                game.changeScreen(this, scoreBoardScreen);
            }else if(quitButtonBound.contains((int) touchEvent.x, (int) touchEvent.y)){

                QuitScreen quitScreen = new QuitScreen(game);
                game.changeScreen(this, quitScreen);
            }else if(backButtonBound.contains((int) touchEvent.x , (int) touchEvent.y)){



            }else if(playGameButtonBound.contains((int) touchEvent.x , (int) touchEvent.y)){

                MainGameScreen mainGameScreen = new MainGameScreen(game);
                game.changeScreen(this, mainGameScreen);


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

        int backTop= graphics2DInterface.getSurfaceHeight()-155;
        int backLeft=20;



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


        if(backButtonBound==null){
            backButtonBound = new Rect(backLeft, backTop, backLeft+BACK_BUTTON_WIDTH,
                    backTop+BACK_BUTTON_HEIGHT);
        }

        graphics2DInterface.drawBitmap(backgroundBitmap, null, backgroundBound, null);
        graphics2DInterface.drawBitmap(menuTemplateBitmap, null, menuTemplateBound, null);
        graphics2DInterface.drawBitmap(playGameBitmap, null, playGameButtonBound, null);
        graphics2DInterface.drawBitmap(optionsBitmap, null, optionsButtonBound, null);
        graphics2DInterface.drawBitmap(rulesBitmap, null, rulesButtonBound, null);
        graphics2DInterface.drawBitmap(scoreBoardBitmap, null, scoreboardButtonBound, null);
        graphics2DInterface.drawBitmap(quitBitmap, null, quitButtonBound, null);
        graphics2DInterface.drawBitmap(backButtonBitmap, null, backButtonBound, null);


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