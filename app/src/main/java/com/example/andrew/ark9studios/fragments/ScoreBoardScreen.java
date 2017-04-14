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
    private Rect menuTemplateBound;


    private Bitmap backgroundBitmap;
    private Bitmap menuTemplateBitmap;


    private static final String SCORE_SCREEN_NAME="ScoreBoardScreen";

    private static final int MENU_TEMPLATE_WIDTH =1100;

    private static final int MENU_TEMPLATE_HEIGHT = 1400;


    public ScoreBoardScreen(Game game){
        super(SCORE_SCREEN_NAME, game);

        AssetManager assetManager = game.getAssetManager();

        assetManager.loadAndAddBitmap("backgroundLayer", "images/qubbg.png");
        assetManager.loadAndAddBitmap("menuTemplate", "images/scoreboard_menu.png");


        this.backgroundBitmap = assetManager.getBitmap("backgroundLayer");
        this.menuTemplateBitmap = assetManager.getBitmap("menuTemplate");
    }

    @Override
    public void update(ElapsedTime elapsedTime) {

    }

    @Override
    public void draw(ElapsedTime elapsedTime, Graphics2DInterface graphics2DInterface) {

        int menuTop=140;
        int menuLeft=120;


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
