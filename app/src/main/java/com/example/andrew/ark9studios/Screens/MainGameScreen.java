package com.example.andrew.ark9studios.Screens;


import android.graphics.Bitmap;
import android.graphics.Rect;


import com.example.andrew.ark9studios.AssetManager;

import com.example.andrew.ark9studios.DeckSetup;
import com.example.andrew.ark9studios.Game;
import com.example.andrew.ark9studios.GameGraphics.Graphics2DInterface;
import com.example.andrew.ark9studios.GameInput.GameTouchEvent;
import com.example.andrew.ark9studios.GameInput.Input;
import com.example.andrew.ark9studios.GameScreen;
import com.example.andrew.ark9studios.card.CardHelper;
import com.example.andrew.ark9studios.card.Deck;
import com.example.andrew.ark9studios.gameInfrastructure.ElapsedTime;
import java.util.List;




/**
 * Created by Andrew and Karl on 18/04/2017.
 */
//Test push for "Checkout as new local branch"
public class MainGameScreen extends GameScreen {

    public static final String SCREEN_NAME = "MainGameScreen";

    private Rect deck_cardBound1;
    private Rect deck_cardBound2;

    private Bitmap deck_cardBitmap1;
    private Bitmap deck_cardBitmap2;



    boolean touchedP1 = false;
    boolean touchedP2 = false;
    boolean firstDrawP1 = true;
    boolean firstDrawP2 = true;
    boolean enableDragP1 = false;
    boolean enableDragP2 = false;
    boolean snapped = false;

    float x1,x2,y1,y2;

    //ArrayList<Bitmap> bitmapArrayOriginal = new ArrayList<Bitmap>();
    // ArrayList<Bitmap> bitmapArrayp1 = new ArrayList<Bitmap>();

    public MainGameScreen(Game game){
        super(SCREEN_NAME, game);

        AssetManager assetManager = game.getAssetManager();
        assetManager.emptyAssets();

        assetManager.loadAndAddBitmap("deck_card1", "images/deck_card1.png");
        assetManager.loadAndAddBitmap("deck_card2", "images/deck_card1.png");

        this.deck_cardBitmap1 = assetManager.getBitmap("deck_card1");
        this.deck_cardBitmap2 = assetManager.getBitmap("deck_card2");

    }

    @Override
    public void update(ElapsedTime elapsedTime) {
        Input input = game.getInput();
        List<GameTouchEvent> touchEvents = input.getTouchEvents();


    }

    @Override
    public void draw(ElapsedTime elapsedTime, Graphics2DInterface graphics2DInterface) {

        boardSetupHelper.drawGameSetup(graphics2DInterface);


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

