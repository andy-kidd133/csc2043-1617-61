package com.example.andrew.ark9studios.fragments;



import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextPaint;

import com.example.andrew.ark9studios.AssetManager;
import com.example.andrew.ark9studios.Game;
import com.example.andrew.ark9studios.GameGraphics.Graphics2DInterface;
import com.example.andrew.ark9studios.GameScreen;
import com.example.andrew.ark9studios.gameInfrastructure.ElapsedTime;


/**
 * Created by megan on 02/03/2017.
 */

public class OptionsScreen extends GameScreen {


    private Rect backgroundBound;
    private Rect optionsMenuBound;


    private Bitmap backgroundBitmap;
    private Bitmap optionsMenuBitmap;


    private static final String SCREEN_NAME="OptionsScreen";


    private static final int MENU_TEMPLATE_WIDTH =1100;

    private static final int MENU_TEMPLATE_HEIGHT = 1400;




    public OptionsScreen(Game game){
        super(SCREEN_NAME, game);

        AssetManager assetManager = game.getAssetManager();
        assetManager.emptyAssets();

        assetManager.loadAndAddBitmap("backgroundLayer", "images/qubbg.png");
        assetManager.loadAndAddBitmap("optionsmenu", "images/options_menu.png");


        this.backgroundBitmap = assetManager.getBitmap("backgroundLayer");
        this.optionsMenuBitmap = assetManager.getBitmap("optionsmenu");
    }

    @Override
    public void update(ElapsedTime elapsedTime) {

    }

    @Override
    public void draw(ElapsedTime elapsedTime, Graphics2DInterface graphics2DInterface) {




        int optionsMenuTop=140;
        int optionsMenuLeft = 120;




        if(backgroundBound == null){
            backgroundBound = new Rect(0, 0, graphics2DInterface.getSurfaceWidth(),
                    graphics2DInterface.getSurfaceHeight());
        }

        if(optionsMenuBound == null){
            optionsMenuBound = new Rect(optionsMenuLeft, optionsMenuTop , MENU_TEMPLATE_WIDTH,
                    MENU_TEMPLATE_HEIGHT);
        }


        String text = "Music On : ";
        Paint paint = new TextPaint();
        paint.setColor(Color.BLACK);
        paint.setTextSize(40);


        //TODO: ADD BUTTONS FOR MUSIC ON AND OFF

        graphics2DInterface.drawBitmap(backgroundBitmap, null, backgroundBound, null);
        graphics2DInterface.drawBitmap(optionsMenuBitmap, null, optionsMenuBound, null);
        graphics2DInterface.drawText(text, 200, 400, paint );

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
