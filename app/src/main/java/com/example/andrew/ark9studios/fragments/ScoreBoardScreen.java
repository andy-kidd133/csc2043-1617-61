package com.example.andrew.ark9studios.fragments;




import com.example.andrew.ark9studios.AssetManager;
import android.graphics.Bitmap;
import android.graphics.Rect;

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

public class ScoreBoardScreen extends GameScreen {



    private Rect backgroundBound;
    private Rect scoreMenuBound;
    private Rect backButtonBound;


    private Bitmap backgroundBitmap;
    private Bitmap scoreMenuBitmap;
    private Bitmap backButtonBitmap;


    private static final String SCREEN_NAME="ScoreBoardScreen";

    private static final int MENU_TEMPLATE_WIDTH =1100;

    private static final int MENU_TEMPLATE_HEIGHT = 1400;

    private static final int BUTTON_WIDTH = 150;
    private static final int BUTTON_HEIGHT = 150;


    public ScoreBoardScreen(Game game){
        super(SCREEN_NAME, game);

        AssetManager assetManager = game.getAssetManager();
        assetManager.emptyAssets();
        assetManager.loadAndAddBitmap("backgroundLayer", "images/qubbg.png");
        assetManager.loadAndAddBitmap("scoreboardmenu", "images/scoreboard_menu.png");
        assetManager.loadAndAddBitmap("backbutton", "images/back_btn.png");


        this.backgroundBitmap = assetManager.getBitmap("backgroundLayer");
       this.scoreMenuBitmap = assetManager.getBitmap("scoreboardmenu");
        this.backButtonBitmap = assetManager.getBitmap("backbutton");
    }

    @Override
    public void update(ElapsedTime elapsedTime) {

        Input input = game.getInput();
        List<GameTouchEvent> touchEvents = input.getTouchEvents();
        if (touchEvents.size() > 0) {
            GameTouchEvent touchEvent = touchEvents.get(0);
            if (backButtonBound.contains((int) touchEvent.x, (int) touchEvent.y)) {

                game.getScreenManager().removeScreen(this.getmName());

                MainMenuScreen mainMenuScreen = new MainMenuScreen(this.getmGame());
                game.getScreenManager().addGameScreen(mainMenuScreen);


            }
        }

    }

    @Override
    public void draw(ElapsedTime elapsedTime, Graphics2DInterface graphics2DInterface) {

        int scoreMenuTop=140;
        int scoreMenuLeft=120;
        int backTop= graphics2DInterface.getSurfaceHeight()-155;
        int backLeft=20;


        if(backgroundBound == null){
            backgroundBound = new Rect(0, 0, graphics2DInterface.getSurfaceWidth(),
                    graphics2DInterface.getSurfaceHeight());
        }

        if(scoreMenuBound == null){
           scoreMenuBound = new Rect(scoreMenuLeft, scoreMenuTop , MENU_TEMPLATE_WIDTH,
                    MENU_TEMPLATE_HEIGHT);
        }

        if(backButtonBound==null){
            backButtonBound = new Rect(backLeft, backTop, backLeft+BUTTON_WIDTH,
                    backTop+BUTTON_HEIGHT);
        }


        graphics2DInterface.drawBitmap(backgroundBitmap, null, backgroundBound, null);
        graphics2DInterface.drawBitmap(scoreMenuBitmap, null, scoreMenuBound, null);
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
