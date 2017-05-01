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
    // private Rect card1Bound;
    // private Rect cardTempBound;


    private Bitmap deck_cardBitmap1;
    private Bitmap deck_cardBitmap2;

    //private static final int CARD_WIDTH = 110;
    //private static final int CARD_HEIGHT = 150;

    //private static final int CARD_DECK_WIDTH = 1100;
    //private static final int CARD_DECK_HEIGHT = 400;

    //BoardSetupHelper boardSetupHelper = new BoardSetupHelper(game);
   // BoardLocation boardLocation = new BoardLocation();
    DeckSetup deckSetup = new DeckSetup(game);
    Deck deck = new Deck();

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

      //  boardSetupHelper.drawGameSetup(graphics2DInterface);

        /*Input input = game.getInput();
        List<GameTouchEvent> touchEvents = input.getTouchEvents();

        if (deck_cardBound1 == null) {
            deck_cardBound1 = new Rect(50, graphics2DInterface.getSurfaceHeight() - 430, 150,
                    graphics2DInterface.getSurfaceHeight() - 300);
        }
        if (deck_cardBound2 == null) {
            deck_cardBound2 = new Rect(1050, 300, 1150, 430);
        }
        graphics2DInterface.drawBitmap(deck_cardBitmap1, null, deck_cardBound1, null);
        graphics2DInterface.drawBitmap(deck_cardBitmap2, null, deck_cardBound2, null);


        if (touchEvents.size() > 0) {
            GameTouchEvent touchEvent = touchEvents.get(0);
            if(firstDrawP1==true) {

                if (deck_cardBound1.contains((int) touchEvent.x, (int) touchEvent.y)) {
                    deck.setUpDeck();
                    touchedP1 = true;
                    firstDrawP1 = false;
                }
            }
            if(firstDrawP2==true) {

                if (deck_cardBound2.contains((int) touchEvent.x, (int) touchEvent.y)) {
                    touchedP2 = true;
                    firstDrawP2 = false;
                }
            }*/
            /*if(touchedP1 == true && enableDragP1 == true) {
                if(deckSetup.card1Bound.contains((int) touchEvent.x, (int) touchEvent.y)){
                    x1 = touchEvent.x - 55;
                    x2 = touchEvent.x + 55;
                    y1 = touchEvent.y - 75;
                    y2 = touchEvent.y + 75;

                    deckSetup.card1Bound.set((int) x1 ,(int) y1, (int) x2, (int) y2);
                   // graphics2DInterface.drawBitmap(deckSetup.getBitmapArrayp1().get(0), null, deckSetup.card1Bound, null);
                    if(deckSetup.card1Bound.intersects(DeckSetup.card1Bound,DeckSetup.card13Bound) && snapped == false){
                        deckSetup.card1Bound.set(deckSetup.card13Bound);
                        snapped = true;
                    }
                    if(!deckSetup.card1Bound.intersects(DeckSetup.card1Bound,DeckSetup.card13Bound) && snapped == true){
                        deckSetup.card1Bound.set((int) x1 ,(int) y1, (int) x2, (int) y2);
                        snapped = false;

                    }

                }
            }*/
        }


/*
        if (touchedP1 == true) {
            enableDragP1 = true;

            if (deckSetup.card1Bound == null) {
                deckSetup.card1Bound = new Rect(boardLocation.getP1Hand1Location());
            }
            if (deckSetup.card2Bound == null) {
                deckSetup.card2Bound = new Rect(boardLocation.getP1Hand2Location());
            }
            if (deckSetup.card3Bound == null) {
                deckSetup.card3Bound = new Rect(boardLocation.getP1Hand3Location());
            }
            if (deckSetup.card4Bound == null) {
                deckSetup.card4Bound = new Rect(boardLocation.getP1Hand4Location());
            }
            if (deckSetup.card5Bound == null) {
                deckSetup.card5Bound = new Rect(boardLocation.getP1Hand5Location());
            }
            if (deckSetup.card6Bound == null) {
                deckSetup.card6Bound = new Rect(boardLocation.getP1Hand6Location());
            }
            if (deckSetup.card13Bound == null) {
                deckSetup.card13Bound = new Rect(boardLocation.getP1Bench1Location());
            }
            if (deckSetup.card14Bound == null) {
                deckSetup.card14Bound = new Rect(boardLocation.getP1Bench2Location());
            }
            if (deckSetup.card15Bound == null) {
                deckSetup.card15Bound = new Rect(boardLocation.getP1Bench3Location());
            }


            graphics2DInterface.drawBitmap(deck.getDeck().get(0).getCardImg(CardHelper.getCardImages(0)), null, deckSetup.card1Bound, null);
//            graphics2DInterface.drawBitmap(deckSetup.getBitmapArrayp1().get(1), null, deckSetup.card2Bound, null);
//            graphics2DInterface.drawBitmap(deckSetup.getBitmapArrayp1().get(2), null, deckSetup.card3Bound, null);
//            graphics2DInterface.drawBitmap(deckSetup.getBitmapArrayp1().get(3), null, deckSetup.card4Bound, null);
//            graphics2DInterface.drawBitmap(deckSetup.getBitmapArrayp1().get(4), null, deckSetup.card5Bound, null);
//            graphics2DInterface.drawBitmap(deckSetup.getBitmapArrayp1().get(5), null, deckSetup.card6Bound, null);


        }*/
       /* if(touchedP2 == true){

            if (deckSetup.card7Bound == null) {
                deckSetup.card7Bound = new Rect(boardLocation.getP2Hand1Location());
            }
            if (deckSetup.card8Bound == null) {
                deckSetup.card8Bound = new Rect(boardLocation.getP2Hand2Location());
            }
            if (deckSetup.card9Bound == null) {
                deckSetup.card9Bound = new Rect(boardLocation.getP2Hand3Location());
            }
            if (deckSetup.card10Bound == null) {
                deckSetup.card10Bound = new Rect(boardLocation.getP2Hand4Location());
            }
            if (deckSetup.card11Bound == null) {
                deckSetup.card11Bound = new Rect(boardLocation.getP2Hand5Location());
            }
            if (deckSetup.card12Bound == null) {
                deckSetup.card12Bound = new Rect(boardLocation.getP2Hand6Location());
            }
            if (deckSetup.card16Bound == null) {
                deckSetup.card16Bound = new Rect(boardLocation.getP2Bench1Location());
            }
            if (deckSetup.card17Bound == null) {
                deckSetup.card17Bound = new Rect(boardLocation.getP2Bench2Location());
            }
            if (deckSetup.card18Bound == null) {
                deckSetup.card18Bound = new Rect(boardLocation.getP2Bench3Location());
            }

            graphics2DInterface.drawBitmap(deckSetup.getBitmapArrayp2().get(0), null, deckSetup.card7Bound, null);
            graphics2DInterface.drawBitmap(deckSetup.getBitmapArrayp2().get(1), null, deckSetup.card8Bound, null);
            graphics2DInterface.drawBitmap(deckSetup.getBitmapArrayp2().get(2), null, deckSetup.card9Bound, null);
            graphics2DInterface.drawBitmap(deckSetup.getBitmapArrayp2().get(3), null, deckSetup.card10Bound, null);
            graphics2DInterface.drawBitmap(deckSetup.getBitmapArrayp2().get(4), null, deckSetup.card11Bound, null);
            graphics2DInterface.drawBitmap(deckSetup.getBitmapArrayp2().get(5), null, deckSetup.card12Bound, null);

        }*/



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

