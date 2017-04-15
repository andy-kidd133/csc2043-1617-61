package com.example.andrew.ark9studios.fragments;

import android.graphics.Bitmap;
import android.graphics.Rect;

import com.example.andrew.ark9studios.AssetManager;
import com.example.andrew.ark9studios.Game;
import com.example.andrew.ark9studios.GameGraphics.Graphics2DInterface;
import com.example.andrew.ark9studios.GameScreen;
import com.example.andrew.ark9studios.gameInfrastructure.ElapsedTime;


/**
 * Created by megan on 02/03/2017.
 */

public class RulesScreen extends GameScreen {


    private Rect backgroundBound;
    private Rect rulesMenuBound;


    private Bitmap backgroundBitmap;
    private Bitmap rulesMenuBitmap;

    private static final String SCREEN_NAME="RulesScreen";
    private static final int MENU_TEMPLATE_WIDTH =1100;
    private static final int MENU_TEMPLATE_HEIGHT = 1400;



    public RulesScreen(Game game){
        super(SCREEN_NAME, game);

        AssetManager assetManager = game.getAssetManager();
        assetManager.emptyAssets();

        assetManager.loadAndAddBitmap("backgroundLayer", "images/qubbg.png");
        assetManager.loadAndAddBitmap("rulesmenu", "images/rules_menu.png");

        this.backgroundBitmap = assetManager.getBitmap("backgroundLayer");
        this.rulesMenuBitmap = assetManager.getBitmap("rulesmenu");

    }






    @Override
    public void update(ElapsedTime elapsedTime) {

    }

    @Override
    public void draw(ElapsedTime elapsedTime, Graphics2DInterface graphics2DInterface) {

        int rulesMenuTop=140;
        int rulesMenuLeft = 120;



        if(backgroundBound == null){
            backgroundBound = new Rect(0, 0, graphics2DInterface.getSurfaceWidth(),
                    graphics2DInterface.getSurfaceHeight());
        }

        if(rulesMenuBound == null){
            rulesMenuBound = new Rect(rulesMenuLeft, rulesMenuTop , MENU_TEMPLATE_WIDTH,
                    MENU_TEMPLATE_HEIGHT);
        }





       //TODO: ADD RULES ONTO THE SCREEN
        graphics2DInterface.drawBitmap(backgroundBitmap, null, backgroundBound, null);
        graphics2DInterface.drawBitmap(rulesMenuBitmap, null, rulesMenuBound, null);










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























