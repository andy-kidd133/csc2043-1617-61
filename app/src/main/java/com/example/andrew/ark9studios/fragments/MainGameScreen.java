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
    private Rect pauseIconBound;
    private Rect player1DeckBound;
    private Rect enemyDeckBound;

    private Bitmap card1Bitmap;
    private Bitmap backgroundBitmap;
    private Bitmap pauseIconBitmap;
    private Bitmap player1DeckBitmap;
    private Bitmap enemyDeckBitmap;

    private static final int CARD_WIDTH = 150;
    private static final int CARD_HEIGHT = 150;

    private static final int DECK_WIDTH = 1100;
    private static final int DECK_HEIGHT = 400;


    private static final int PAUSE_BUTTON_WIDTH= 120;
    private static final int PAUSE_BUTTON_HEIGHT=130;


   public MainGameScreen(Game game){
       super(SCREEN_NAME, game);

       AssetManager assetManager = game.getAssetManager();
       assetManager.emptyAssets();

       assetManager.loadAndAddBitmap("card1", "images/card1.png");
       assetManager.loadAndAddBitmap("backgroundLayer", "images/qubbg.png");
       assetManager.loadAndAddBitmap("pauseIcon", "images/pause_button.png");
       assetManager.loadAndAddBitmap("player1Deck", "images/player1_deck.png");
       assetManager.loadAndAddBitmap("enemyDeck", "images/enemy_deck.png");

       this.card1Bitmap = assetManager.getBitmap("card1");
       this.backgroundBitmap = assetManager.getBitmap("backgroundLayer");
       this.pauseIconBitmap = assetManager.getBitmap("pauseIcon");
       this.player1DeckBitmap = assetManager.getBitmap("player1Deck");
       this.enemyDeckBitmap = assetManager.getBitmap("enemyDeck");



   }




    @Override
    public void update(ElapsedTime elapsedTime) {
        Input input = game.getInput();
        List<GameTouchEvent> touchEvents = input.getTouchEvents();

        if(touchEvents.size()>0){
            GameTouchEvent touchEvent = touchEvents.get(0);

            if(pauseIconBound.contains((int) touchEvent.x, (int) touchEvent.y)){


            }
        }

    }

    @Override
    public void draw(ElapsedTime elapsedTime, Graphics2DInterface graphics2DInterface) {

          int pauseLeft= graphics2DInterface.getSurfaceWidth()-145;
          int pauseTop = graphics2DInterface.getSurfaceHeight()-1750;

        int deckLeft=100;
        int enemyDeckTop=130;




        if(backgroundBound == null){
            backgroundBound = new Rect(0, 0, graphics2DInterface.getSurfaceWidth(),
                    graphics2DInterface.getSurfaceHeight());
        }

        if(pauseIconBound == null){
            pauseIconBound = new Rect(pauseLeft, pauseTop, pauseLeft+PAUSE_BUTTON_WIDTH,
                    pauseTop+PAUSE_BUTTON_HEIGHT);
        }

        if(enemyDeckBound == null){
                enemyDeckBound = new Rect(deckLeft, enemyDeckTop,  DECK_WIDTH,
                      DECK_HEIGHT);
        }



        if(card1Bound == null){
            card1Bound = new Rect(20, 20, 20 + CARD_WIDTH,
                    20 + CARD_HEIGHT);
        }


        graphics2DInterface.drawBitmap(backgroundBitmap, null, backgroundBound, null);
        graphics2DInterface.drawBitmap(pauseIconBitmap, null, pauseIconBound, null);
        graphics2DInterface.drawBitmap(enemyDeckBitmap, null, enemyDeckBound, null);
        graphics2DInterface.drawBitmap(player1DeckBitmap, null, player1DeckBound, null);
       // graphics2DInterface.drawBitmap(card1Bitmap, null, card1Bound, null);

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
