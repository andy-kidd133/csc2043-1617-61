package com.example.andrew.ark9studios.fragments;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.view.Display;

import com.example.andrew.ark9studios.AssetManager;
import com.example.andrew.ark9studios.Game;
import com.example.andrew.ark9studios.GameGraphics.Graphics2DInterface;
import com.example.andrew.ark9studios.GameInput.GameTouchEvent;
import com.example.andrew.ark9studios.GameInput.Input;
import com.example.andrew.ark9studios.GameScreen;
import com.example.andrew.ark9studios.gameInfrastructure.ElapsedTime;

import java.util.List;

/**
 * Created by Andy and Karl on 19/04/2017.
 */

public class MainGameScreen extends GameScreen {

    public static final String SCREEN_NAME = "MainGameScreen";

    private Rect card1Bound;
    private Rect backgroundBound;
    private Rect card_deckBound;
    private Rect enemyCard_deckBound;

    private Bitmap card1Bitmap;
    private Bitmap backgroundBitmap;
    private Bitmap card_deckBitmap;
    private Bitmap enemyCard_deckBitmap;

    private static final int CARD_WIDTH = 90;
    private static final int CARD_HEIGHT = 150;

    private static final int CARD_DECK_WIDTH = 1100;
    private static final int CARD_DECK_HEIGHT = 400;



   public MainGameScreen(Game game){
       super(SCREEN_NAME, game);

       AssetManager assetManager = game.getAssetManager();
       assetManager.emptyAssets();

       assetManager.loadAndAddBitmap("card1", "images/card1.png");
       assetManager.loadAndAddBitmap("backgroundLayer", "images/qubbg.png");
       assetManager.loadAndAddBitmap("card_deck", "images/card_deck.png");
       assetManager.loadAndAddBitmap("enemyCard_deck", "images/enemyCard_deck.png");

       this.card1Bitmap = assetManager.getBitmap("card1");
       this.backgroundBitmap = assetManager.getBitmap("backgroundLayer");
       this.card_deckBitmap = assetManager.getBitmap("card_deck");
       this.enemyCard_deckBitmap = assetManager.getBitmap("enemyCard_deck");

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
            card1Bound = new Rect(graphics2DInterface.getSurfaceWidth()/2, graphics2DInterface.getSurfaceHeight()/2 ,(graphics2DInterface.getSurfaceWidth()/2) +CARD_WIDTH,
                    (graphics2DInterface.getSurfaceHeight()/2) + CARD_HEIGHT);
        }

        if(card_deckBound == null){
            card_deckBound = new Rect(30, graphics2DInterface.getSurfaceHeight()-350, graphics2DInterface.getSurfaceWidth()-30,
                    graphics2DInterface.getSurfaceHeight()-50);
        }

        if(enemyCard_deckBound == null){
            enemyCard_deckBound = new Rect(30, 0, graphics2DInterface.getSurfaceWidth()-30, 420);
        }


        graphics2DInterface.drawBitmap(backgroundBitmap, null, backgroundBound, null);
        graphics2DInterface.drawBitmap(card1Bitmap, null, card1Bound, null);
        graphics2DInterface.drawBitmap(card_deckBitmap, null, card_deckBound, null);
        graphics2DInterface.drawBitmap(enemyCard_deckBitmap, null, enemyCard_deckBound, null);

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
