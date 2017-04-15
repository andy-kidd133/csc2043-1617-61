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

public class QuitScreen extends GameScreen{


    private Rect backgroundBound;
    private Rect quitMenuBound;
    private Rect yesButtonBound;
    private Rect noButtonBound;


    private Bitmap backgroundBitmap;
    private Bitmap quitMenuBitmap;
    private Bitmap yesBitmap;
    private Bitmap noBitmap;





    private static final String SCREEN_NAME="QuitScreen";



    private static final int BUTTON_WIDTH = 500;

    private static final int BUTTON_HEIGHT = 180;

    private static final int MENU_TEMPLATE_WIDTH =1100;

    private static final int MENU_TEMPLATE_HEIGHT = 1400;





    public QuitScreen(Game game){
        super(SCREEN_NAME, game);

        AssetManager assetManager = game.getAssetManager();
        assetManager.emptyAssets();
        assetManager.loadAndAddBitmap("backgroundLayer", "images/qubbg.png");
        assetManager.loadAndAddBitmap("quitmenu", "images/quit_menu.png");
        assetManager.loadAndAddBitmap("yesbutton", "images/yes_button.png");
        assetManager.loadAndAddBitmap("nobutton", "images/no_button.png");



        this.backgroundBitmap = assetManager.getBitmap("backgroundLayer");
        this.quitMenuBitmap = assetManager.getBitmap("quitmenu");
        this.yesBitmap = assetManager.getBitmap("yesbutton");
        this.noBitmap = assetManager.getBitmap("nobutton");

    }







    @Override
    public void update(ElapsedTime elapsedTime) {

    }

    @Override
    public void draw(ElapsedTime elapsedTime, Graphics2DInterface graphics2DInterface) {


        int quitMenuTop=140;
        int quitMenuLeft = 120;
        int verticalSpacer=190;
        int buttonLeft =375;
        int yesButtonTop = 500;
        int noButtonTop = yesButtonTop + verticalSpacer;



        if(backgroundBound == null){
            backgroundBound = new Rect(0, 0, graphics2DInterface.getSurfaceWidth(),
                    graphics2DInterface.getSurfaceHeight());
        }

        if(quitMenuBound == null){
            quitMenuBound = new Rect(quitMenuLeft, quitMenuTop , MENU_TEMPLATE_WIDTH,
                    MENU_TEMPLATE_HEIGHT);
        }

        if(yesButtonBound==null){
            yesButtonBound = new Rect(buttonLeft, yesButtonTop, buttonLeft+BUTTON_WIDTH,
                    yesButtonTop + BUTTON_HEIGHT);
        }

        if(noButtonBound==null){
            noButtonBound = new Rect(buttonLeft, noButtonTop, buttonLeft+BUTTON_WIDTH,
                    noButtonTop + BUTTON_HEIGHT);
        }

        String text = "Are you sure you want to quit?";
        Paint paint = new TextPaint();
        paint.setColor(Color.BLACK);
        paint.setTextSize(60);


        graphics2DInterface.drawBitmap(backgroundBitmap, null, backgroundBound, null);
        graphics2DInterface.drawBitmap(quitMenuBitmap, null, quitMenuBound, null);
        graphics2DInterface.drawBitmap(yesBitmap, null, yesButtonBound, null);
        graphics2DInterface.drawBitmap(noBitmap, null, noButtonBound, null);
        graphics2DInterface.drawText(text, 200, 370, paint );

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
