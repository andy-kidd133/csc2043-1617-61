package com.example.andrew.ark9studios.fragments;




import com.example.andrew.ark9studios.AssetManager;
import android.graphics.Bitmap;
import android.graphics.Rect;

import com.example.andrew.ark9studios.Game;
import com.example.andrew.ark9studios.GameGraphics.Graphics2DInterface;
import com.example.andrew.ark9studios.GameScreen;
import com.example.andrew.ark9studios.gameInfrastructure.ElapsedTime;

/**
 * Created by megan on 02/03/2017.
 */

public class ScoreBoardScreen extends GameScreen {



    private Rect backgroundBound;
    private Rect scoreMenuBound;


    private Bitmap backgroundBitmap;
    private Bitmap scoreMenuBitmap;


    private static final String SCREEN_NAME="ScoreBoardScreen";

    private static final int MENU_TEMPLATE_WIDTH =1100;

    private static final int MENU_TEMPLATE_HEIGHT = 1400;


    public ScoreBoardScreen(Game game){
        super(SCREEN_NAME, game);

        AssetManager assetManager = game.getAssetManager();
        assetManager.emptyAssets();
        assetManager.loadAndAddBitmap("backgroundLayer", "images/qubbg.png");
        assetManager.loadAndAddBitmap("scoreboardmenu", "images/scoreboard_menu.png");


        this.backgroundBitmap = assetManager.getBitmap("backgroundLayer");
       this.scoreMenuBitmap = assetManager.getBitmap("scoreboardmenu");
    }

    @Override
    public void update(ElapsedTime elapsedTime) {

    }

    @Override
    public void draw(ElapsedTime elapsedTime, Graphics2DInterface graphics2DInterface) {

        int scoreMenuTop=140;
        int scoreMenuLeft=120;


        if(backgroundBound == null){
            backgroundBound = new Rect(0, 0, graphics2DInterface.getSurfaceWidth(),
                    graphics2DInterface.getSurfaceHeight());
        }

        if(scoreMenuBound == null){
           scoreMenuBound = new Rect(scoreMenuLeft, scoreMenuTop , MENU_TEMPLATE_WIDTH,
                    MENU_TEMPLATE_HEIGHT);
        }


        graphics2DInterface.drawBitmap(backgroundBitmap, null, backgroundBound, null);
        graphics2DInterface.drawBitmap(scoreMenuBitmap, null, scoreMenuBound, null);

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
