package com.example.andrew.ark9studios;

import android.graphics.Bitmap;
import android.graphics.Rect;

import com.example.andrew.ark9studios.GameGraphics.Graphics2DInterface;
//import com.example.andrew.ark9studios.IO.FileIO;
//import com.example.andrew.ark9studios.Fragments.GameFragment;

/**
 * Created by Andrew on 21/04/2017.
 * loads in all permanent bitmaps for the MainGameScreen
 */

public class BoardSetupHelper {

    private Rect backgroundBound;
    private Rect card_deckBound;
    private Rect enemyCard_deckBound;
    private Rect bench_BlueBound;
    private Rect bench_RedBound;
    private Rect p1ActiveLocationBound;
    private Rect p2ActiveLocationBound;


    private Bitmap backgroundBitmap;
    private Bitmap card_deckBitmap;
    private Bitmap enemyCard_deckBitmap;
    private Bitmap bench_BlueBitmap;
    private Bitmap bench_RedBitmap;
    private Bitmap p1activeLocationBitmap;
    private Bitmap p2activeLocationBitmap;


    public BoardSetupHelper(Game game) {

        AssetManager assetManager = game.getAssetManager();
        assetManager.emptyAssets();

        assetManager.loadAndAddBitmap("backgroundLayer", "images/qubbg.png");
        assetManager.loadAndAddBitmap("card_deck", "images/card_deck.png");
        assetManager.loadAndAddBitmap("enemyCard_deck", "images/enemyCard_deck.png");
        assetManager.loadAndAddBitmap("bench_Red", "images/bench_Red.png");
        assetManager.loadAndAddBitmap("bench_Blue", "images/bench_Blue.png");
        assetManager.loadAndAddBitmap("p1activeLocation", "images/card1.png");
        assetManager.loadAndAddBitmap("p2activeLocation", "images/card2.png");


        this.backgroundBitmap = assetManager.getBitmap("backgroundLayer");
        this.card_deckBitmap = assetManager.getBitmap("card_deck");
        this.enemyCard_deckBitmap = assetManager.getBitmap("enemyCard_deck");
        this.bench_RedBitmap = assetManager.getBitmap("bench_Red");
        this.bench_BlueBitmap = assetManager.getBitmap("bench_Blue");
        this.p1activeLocationBitmap = assetManager.getBitmap("p1activeLocation");
        this.p2activeLocationBitmap = assetManager.getBitmap("p2activeLocation");


    }


    public void drawGameSetup(Graphics2DInterface graphics2DInterface) {

        if (backgroundBound == null) {
            backgroundBound = new Rect(0, 0, graphics2DInterface.getSurfaceWidth(),
                    graphics2DInterface.getSurfaceHeight());
        }

        if (card_deckBound == null) {
            card_deckBound = new Rect(30, graphics2DInterface.getSurfaceHeight() - 325, graphics2DInterface.getSurfaceWidth() - 30,
                    graphics2DInterface.getSurfaceHeight() - 25);
        }

        if (enemyCard_deckBound == null) {
            enemyCard_deckBound = new Rect(30, 25, graphics2DInterface.getSurfaceWidth() - 30, 325);
        }

        if (bench_RedBound == null) {
            bench_RedBound = new Rect(327, graphics2DInterface.getSurfaceHeight() - 615, 867, graphics2DInterface.getSurfaceHeight() - 385);
        }

        if (bench_BlueBound == null) {
            bench_BlueBound = new Rect(327, 385, 867, 615);
        }

        if (p1ActiveLocationBound == null) {
            p1ActiveLocationBound = new Rect(522, graphics2DInterface.getSurfaceHeight() - 845, 672, graphics2DInterface.getSurfaceHeight() -655);
        }

        if (p2ActiveLocationBound == null) {
            p2ActiveLocationBound = new Rect(522, 655, 672, 845);
        }

        graphics2DInterface.drawBitmap(backgroundBitmap, null, backgroundBound, null);
        graphics2DInterface.drawBitmap(card_deckBitmap, null, card_deckBound, null);
        graphics2DInterface.drawBitmap(enemyCard_deckBitmap, null, enemyCard_deckBound, null);
        graphics2DInterface.drawBitmap(bench_RedBitmap, null, bench_RedBound, null);
        graphics2DInterface.drawBitmap(bench_BlueBitmap, null, bench_BlueBound, null);
        graphics2DInterface.drawBitmap(p1activeLocationBitmap, null, p1ActiveLocationBound, null);
        graphics2DInterface.drawBitmap(p2activeLocationBitmap, null, p2ActiveLocationBound, null);

    }
}
