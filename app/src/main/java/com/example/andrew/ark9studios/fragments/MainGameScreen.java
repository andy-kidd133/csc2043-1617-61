package com.example.andrew.ark9studios.fragments;

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
 * Created by megan on 15/04/2017.
 */

public class MainGameScreen extends GameScreen {

    public static final String SCREEN_NAME = "MainGameScreen";

    private Rect card1Bound;
    private Rect backgroundBound;

    private Bitmap card1Bitmap;
    private Bitmap backgroundBitmap;

    private static final int CARD_WIDTH = 150;
    private static final int CARD_HEIGHT = 150;



   public MainGameScreen(Game game){
       super(SCREEN_NAME, game);

       AssetManager assetManager = game.getAssetManager();
       assetManager.emptyAssets();

       assetManager.loadAndAddBitmap("card1", "drawable/card1.png");
       assetManager.loadAndAddBitmap("backgroundLayer", "images/qubbg.png");

       this.card1Bitmap = assetManager.getBitmap("card1");
       this.backgroundBitmap = assetManager.getBitmap("backgroundLayer");

   }




    @Override
    public void update(ElapsedTime elapsedTime) {
        Input input = game.getInput();
        List<GameTouchEvent> touchEvents = input.getTouchEvents();

    }

    @Override
    public void draw(ElapsedTime elapsedTime, Graphics2DInterface graphics2DInterface) {



        if(backgroundBound == null){
            backgroundBound = new Rect(0, 0, graphics2DInterface.getSurfaceWidth(),
                    graphics2DInterface.getSurfaceHeight());
        }

        if(card1Bound == null){
            card1Bound = new Rect(20, 20, 20 + CARD_WIDTH,
                    20 + CARD_HEIGHT);
        }


        graphics2DInterface.drawBitmap(backgroundBitmap, null, backgroundBound, null);
        graphics2DInterface.drawBitmap(card1Bitmap, null, card1Bound, null);

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
    //TODO: DRAW AND UPDATE THIS SCREEN
}
