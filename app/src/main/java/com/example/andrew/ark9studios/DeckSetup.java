package com.example.andrew.ark9studios.utils;

import android.graphics.Bitmap;
import android.graphics.Rect;

import com.example.andrew.ark9studios.AssetManager;
import com.example.andrew.ark9studios.BoardLocation;
import com.example.andrew.ark9studios.Game;
import com.example.andrew.ark9studios.GameGraphics.Graphics2DInterface;
import com.example.andrew.ark9studios.GameInput.GameTouchEvent;
import com.example.andrew.ark9studios.GameInput.Input;
import com.example.andrew.ark9studios.fragments.GameFragment;
import com.example.andrew.ark9studios.fragments.MainGameScreen;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * Created by Karlm on 26/04/2017.
 */

//

public class DeckSetup {


    public Bitmap card1Bitmap,card2Bitmap,card3Bitmap,card4Bitmap,card5Bitmap,card6Bitmap,card7Bitmap,card8Bitmap,
            card9Bitmap,card10Bitmap,card11Bitmap,card12Bitmap,card13Bitmap,card14Bitmap,card15Bitmap,card16Bitmap,
            card17Bitmap,card18Bitmap,card19Bitmap,card20Bitmap,card21Bitmap,card22Bitmap,card23Bitmap,card24Bitmap,
            card25Bitmap,card26Bitmap,card27Bitmap,card28Bitmap, deck_cardBitmap1, deck_cardBitmap2;



    public static Rect card1Bound,card2Bound,card3Bound,card4Bound,card5Bound,card6Bound,card7Bound,card8Bound,card9Bound,
            card10Bound,card11Bound,card12Bound,card13Bound, card14Bound,card15Bound,card16Bound,card17Bound,
            card18Bound,card19Bound,card20Bound,tempBound,  deck_cardBound1, deck_cardBound2;

    public enum cardType{character, action, energy}

    private BoardLocation boardLocation;

    ArrayList<Bitmap> bitmapArrayOriginal = new ArrayList<Bitmap>(28);
    ArrayList<Bitmap> bitmapArrayp1 = new ArrayList<Bitmap>(28);
    ArrayList<Bitmap> bitmapArrayp2 = new ArrayList<Bitmap>(28);


    public ArrayList<Bitmap> getBitmapArrayp1() {
        return bitmapArrayp1;
    }
    public ArrayList<Bitmap> getBitmapArrayp2() {
        return bitmapArrayp2;
    }

    private boolean touchedP1 = false;
    private boolean touchedP2 = false;
    private boolean firstDrawP1 = true;
    private boolean firstDrawP2 = true;
    private boolean enableDragP1 = false;
    private boolean enableDragP2 = false;
    private boolean snapped = false;

    float x1,x2,y1,y2;


    public DeckSetup(Game game) {

        boardLocation = new BoardLocation();

        AssetManager assetManager = game.getAssetManager();
        assetManager.emptyAssets();

        assetManager.loadAndAddBitmap("card1", "images/card1.png");
        assetManager.loadAndAddBitmap("card2", "images/card2.png");
        assetManager.loadAndAddBitmap("card3", "images/card3.png");
        assetManager.loadAndAddBitmap("card4", "images/card4.png");
        assetManager.loadAndAddBitmap("card5", "images/card5.png");
        assetManager.loadAndAddBitmap("card6", "images/card6.png");
        assetManager.loadAndAddBitmap("card7", "images/card7.png");
        assetManager.loadAndAddBitmap("card8", "images/card8.png");
        assetManager.loadAndAddBitmap("card9", "images/card9.png");
        assetManager.loadAndAddBitmap("card10", "images/card10.png");
        assetManager.loadAndAddBitmap("card11", "images/card11.png");
        assetManager.loadAndAddBitmap("card12", "images/card12.png");
        assetManager.loadAndAddBitmap("card13", "images/card13.png");
        assetManager.loadAndAddBitmap("card14", "images/card14.png");
        assetManager.loadAndAddBitmap("card15", "images/card15.png");
        assetManager.loadAndAddBitmap("card16", "images/card16.png");
        assetManager.loadAndAddBitmap("card17", "images/card17.png");
        assetManager.loadAndAddBitmap("card18", "images/card18.png");
        assetManager.loadAndAddBitmap("card19", "images/card19.png");
        assetManager.loadAndAddBitmap("card20", "images/card20.png");
        assetManager.loadAndAddBitmap("card21", "images/card21.png");
        assetManager.loadAndAddBitmap("card22", "images/card22.png");
        assetManager.loadAndAddBitmap("card23", "images/card23.png");
        assetManager.loadAndAddBitmap("card24", "images/card24.png");
        assetManager.loadAndAddBitmap("card25", "images/card25.png");
        assetManager.loadAndAddBitmap("card26", "images/card26.png");
        assetManager.loadAndAddBitmap("card27", "images/card27.png");
        assetManager.loadAndAddBitmap("card28", "images/card28.png");
        assetManager.loadAndAddBitmap("deck_card1", "images/deck_card.png");
        assetManager.loadAndAddBitmap("deck_card2", "images/deck_card.png");

        this.card1Bitmap = assetManager.getBitmap("card1");
        this.card2Bitmap = assetManager.getBitmap("card2");
        this.card3Bitmap = assetManager.getBitmap("card3");
        this.card4Bitmap = assetManager.getBitmap("card4");
        this.card5Bitmap = assetManager.getBitmap("card5");
        this.card6Bitmap = assetManager.getBitmap("card6");
        this.card7Bitmap = assetManager.getBitmap("card7");
        this.card8Bitmap = assetManager.getBitmap("card8");
        this.card9Bitmap = assetManager.getBitmap("card9");
        this.card10Bitmap = assetManager.getBitmap("card10");
        this.card11Bitmap = assetManager.getBitmap("card11");
        this.card12Bitmap = assetManager.getBitmap("card12");
        this.card13Bitmap = assetManager.getBitmap("card13");
        this.card14Bitmap = assetManager.getBitmap("card14");
        this.card15Bitmap = assetManager.getBitmap("card15");
        this.card16Bitmap = assetManager.getBitmap("card16");
        this.card17Bitmap = assetManager.getBitmap("card17");
        this.card18Bitmap = assetManager.getBitmap("card18");
        this.card19Bitmap = assetManager.getBitmap("card19");
        this.card20Bitmap = assetManager.getBitmap("card20");
        this.card21Bitmap = assetManager.getBitmap("card21");
        this.card22Bitmap = assetManager.getBitmap("card22");
        this.card23Bitmap = assetManager.getBitmap("card23");
        this.card24Bitmap = assetManager.getBitmap("card24");
        this.card25Bitmap = assetManager.getBitmap("card25");
        this.card26Bitmap = assetManager.getBitmap("card26");
        this.card27Bitmap = assetManager.getBitmap("card27");
        this.card28Bitmap = assetManager.getBitmap("card28");
        this.deck_cardBitmap1 = assetManager.getBitmap("deck_card1");
        this.deck_cardBitmap2 = assetManager.getBitmap("deck_card2");



    }


    public void addToArray() {
        bitmapArrayOriginal.add(card1Bitmap);
        bitmapArrayOriginal.add(card2Bitmap);
        bitmapArrayOriginal.add(card3Bitmap);
        bitmapArrayOriginal.add(card4Bitmap);
        bitmapArrayOriginal.add(card5Bitmap);
        bitmapArrayOriginal.add(card6Bitmap);
        bitmapArrayOriginal.add(card7Bitmap);
        bitmapArrayOriginal.add(card8Bitmap);
        bitmapArrayOriginal.add(card9Bitmap);
        bitmapArrayOriginal.add(card10Bitmap);
        bitmapArrayOriginal.add(card11Bitmap);
        bitmapArrayOriginal.add(card12Bitmap);
        bitmapArrayOriginal.add(card13Bitmap);
        bitmapArrayOriginal.add(card14Bitmap);
        bitmapArrayOriginal.add(card15Bitmap);
        bitmapArrayOriginal.add(card16Bitmap);
        bitmapArrayOriginal.add(card17Bitmap);
        bitmapArrayOriginal.add(card18Bitmap);
        bitmapArrayOriginal.add(card19Bitmap);
        bitmapArrayOriginal.add(card20Bitmap);
        bitmapArrayOriginal.add(card21Bitmap);
        bitmapArrayOriginal.add(card22Bitmap);
        bitmapArrayOriginal.add(card23Bitmap);
        bitmapArrayOriginal.add(card24Bitmap);
        bitmapArrayOriginal.add(card25Bitmap);
        bitmapArrayOriginal.add(card26Bitmap);
        bitmapArrayOriginal.add(card27Bitmap);
        bitmapArrayOriginal.add(card28Bitmap);
    }



    public void shuffleP1()
    {
        addToArray();
        bitmapArrayp1.addAll(bitmapArrayOriginal);
        Collections.shuffle(bitmapArrayp1);
    }

    public void shuffleP2()
    {
        addToArray();
        bitmapArrayp2.addAll(bitmapArrayOriginal);
        Collections.shuffle(bitmapArrayp2);
    }

    public void p1CardDrag(Graphics2DInterface graphics2DInterface, Game game) //kmccoubrey
    {
        Input input = game.getInput();
        List<GameTouchEvent> touchEvents = input.getTouchEvents();
        GameTouchEvent touchEvent = touchEvents.get(0);
        x1 = touchEvent.x - 55;
        x2 = touchEvent.x + 55;
        y1 = touchEvent.y - 75;
        y2 = touchEvent.y + 75;

        // Collision detection against screen walls.
        if(touchEvent.x < 55){
            x1 = 0;
            x2 = 110;
        }
        if(touchEvent.x > graphics2DInterface.getSurfaceWidth() - 55){
            x1 = graphics2DInterface.getSurfaceWidth() - 110;
            x2 = graphics2DInterface.getSurfaceWidth();
        }
        if(touchEvent.y < 75){
            y1 = 0;
            y2 = 150;
        }
        if(touchEvent.y > graphics2DInterface.getSurfaceHeight() - 75){
            y1 = graphics2DInterface.getSurfaceHeight() - 150;
            y2 = graphics2DInterface.getSurfaceHeight();
        }

        tempBound.set((int) x1 ,(int) y1, (int) x2, (int) y2);
        // graphics2DInterface.drawBitmap(deckSetup.getBitmapArrayp1().get(0), null, deckSetup.card1Bound, null);
        if(tempBound.intersects(DeckSetup.tempBound,DeckSetup.card13Bound) && !snapped){
            tempBound.set(card13Bound);
            snapped = true;
        }
        if(tempBound.intersects(DeckSetup.tempBound,DeckSetup.card14Bound) && !snapped){
            tempBound.set(card14Bound);
            snapped = true;
        }
        if(tempBound.intersects(DeckSetup.tempBound,DeckSetup.card15Bound) && !snapped){
            tempBound.set(card15Bound);
            snapped = true;
        }
        if(tempBound.intersects(DeckSetup.tempBound,DeckSetup.card19Bound) && !snapped){
            tempBound.set(card19Bound);
            snapped = true;
        }

        if( (!tempBound.intersects(DeckSetup.tempBound,DeckSetup.card13Bound)
                && !tempBound.intersects(DeckSetup.tempBound,DeckSetup.card14Bound)
                && !tempBound.intersects(DeckSetup.tempBound,DeckSetup.card15Bound)
                && !tempBound.intersects(DeckSetup.tempBound,DeckSetup.card19Bound))
                && snapped){
            tempBound.set((int) x1 ,(int) y1, (int) x2, (int) y2);
            snapped = false;

        }

    }

    public void p2CardDrag(Graphics2DInterface graphics2DInterface, Game game) //kmccoubrey
    {
        Input input = game.getInput();
        List<GameTouchEvent> touchEvents = input.getTouchEvents();
        GameTouchEvent touchEvent = touchEvents.get(0);
        x1 = touchEvent.x - 55;
        x2 = touchEvent.x + 55;
        y1 = touchEvent.y - 75;
        y2 = touchEvent.y + 75;

        // Collision detection against screen walls.
        if(touchEvent.x < 55){
            x1 = 0;
            x2 = 110;
        }
        if(touchEvent.x > graphics2DInterface.getSurfaceWidth() - 55){
            x1 = graphics2DInterface.getSurfaceWidth() - 110;
            x2 = graphics2DInterface.getSurfaceWidth();
        }
        if(touchEvent.y < 75){
            y1 = 0;
            y2 = 150;
        }
        if(touchEvent.y > graphics2DInterface.getSurfaceHeight() - 75){
            y1 = graphics2DInterface.getSurfaceHeight() - 150;
            y2 = graphics2DInterface.getSurfaceHeight();
        }

        tempBound.set((int) x1 ,(int) y1, (int) x2, (int) y2);
        // graphics2DInterface.drawBitmap(deckSetup.getBitmapArrayp1().get(0), null, deckSetup.card1Bound, null);
        if(tempBound.intersects(DeckSetup.tempBound,DeckSetup.card16Bound) && !snapped){
            tempBound.set(card16Bound);
            snapped = true;
        }
        if(tempBound.intersects(DeckSetup.tempBound,DeckSetup.card17Bound) && !snapped){
            tempBound.set(card17Bound);
            snapped = true;
        }
        if(tempBound.intersects(DeckSetup.tempBound,DeckSetup.card18Bound) && !snapped){
            tempBound.set(card18Bound);
            snapped = true;
        }
        if(tempBound.intersects(DeckSetup.tempBound,DeckSetup.card20Bound) && !snapped){
            tempBound.set(card20Bound);
            snapped = true;
        }

        if( (!tempBound.intersects(DeckSetup.tempBound,DeckSetup.card16Bound)
                && !tempBound.intersects(DeckSetup.tempBound,DeckSetup.card17Bound)
                && !tempBound.intersects(DeckSetup.tempBound,DeckSetup.card18Bound)
                && !tempBound.intersects(DeckSetup.tempBound,DeckSetup.card20Bound))
                && snapped){
            tempBound.set((int) x1 ,(int) y1, (int) x2, (int) y2);
            snapped = false;

        }

    }

    public void initialGamePlay(Graphics2DInterface graphics2DInterface, Game game)
    {
        Input input = game.getInput();
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
            if(firstDrawP1) {

                if (deck_cardBound1.contains((int) touchEvent.x, (int) touchEvent.y)) {
                    shuffleP1();
                    touchedP1 = true;
                    firstDrawP1 = false;
                }
            }
            if(firstDrawP2) {

                if (deck_cardBound2.contains((int) touchEvent.x, (int) touchEvent.y)) {
                    shuffleP2();
                    touchedP2 = true;
                    firstDrawP2 = false;
                }
            }
            if(touchedP1 && enableDragP1) {     // Calls p1cardDrag to allow movement for player1's cards ~KMcC
                if (tempBound == null) {
                    tempBound = new Rect();
                }
                if(card1Bound.contains((int) touchEvent.x, (int) touchEvent.y)){
                    tempBound.set(card1Bound);
                    p1CardDrag(graphics2DInterface,game);
                    card1Bound.set(tempBound);
                }
                if(card2Bound.contains((int) touchEvent.x, (int) touchEvent.y)){
                    tempBound.set(card2Bound);
                    p1CardDrag(graphics2DInterface,game);
                    card2Bound.set(tempBound);
                }
                if(card3Bound.contains((int) touchEvent.x, (int) touchEvent.y)){
                    tempBound.set(card3Bound);
                    p1CardDrag(graphics2DInterface,game);
                    card3Bound.set(tempBound);
                }
                if(card4Bound.contains((int) touchEvent.x, (int) touchEvent.y)){
                    tempBound.set(card4Bound);
                    p1CardDrag(graphics2DInterface,game);
                    card4Bound.set(tempBound);
                }
                if(card5Bound.contains((int) touchEvent.x, (int) touchEvent.y)){
                    tempBound.set(card5Bound);
                    p1CardDrag(graphics2DInterface,game);
                    card5Bound.set(tempBound);
                }
                if(card6Bound.contains((int) touchEvent.x, (int) touchEvent.y)){
                    tempBound.set(card6Bound);
                    p1CardDrag(graphics2DInterface,game);
                    card6Bound.set(tempBound);
                }

            }
            if(touchedP2 && enableDragP2) {     // Calls p2CardDrag to allow movement for player2's cards. ~KMcC
                if (tempBound == null) {
                    tempBound = new Rect();
                }
                if(card7Bound.contains((int) touchEvent.x, (int) touchEvent.y)){
                    tempBound.set(card7Bound);
                    p2CardDrag(graphics2DInterface,game);
                    card7Bound.set(tempBound);
                }
                if(card8Bound.contains((int) touchEvent.x, (int) touchEvent.y)){
                    tempBound.set(card8Bound);
                    p2CardDrag(graphics2DInterface,game);
                    card8Bound.set(tempBound);
                }
                if(card9Bound.contains((int) touchEvent.x, (int) touchEvent.y)){
                    tempBound.set(card9Bound);
                    p2CardDrag(graphics2DInterface,game);
                    card9Bound.set(tempBound);
                }
                if(card10Bound.contains((int) touchEvent.x, (int) touchEvent.y)){
                    tempBound.set(card10Bound);
                    p2CardDrag(graphics2DInterface,game);
                    card10Bound.set(tempBound);
                }
                if(card11Bound.contains((int) touchEvent.x, (int) touchEvent.y)){
                    tempBound.set(card11Bound);
                    p2CardDrag(graphics2DInterface,game);
                    card11Bound.set(tempBound);
                }
                if(card12Bound.contains((int) touchEvent.x, (int) touchEvent.y)){
                    tempBound.set(card12Bound);
                    p2CardDrag(graphics2DInterface,game);
                    card12Bound.set(tempBound);
                }

            }



        }



        if (touchedP1) {
            enableDragP1 = true;

            if (card1Bound == null) {
                card1Bound = new Rect(boardLocation.getP1Hand1Location());
            }
            if (card2Bound == null) {
                card2Bound = new Rect(boardLocation.getP1Hand2Location());
            }
            if (card3Bound == null) {
                card3Bound = new Rect(boardLocation.getP1Hand3Location());
            }
            if (card4Bound == null) {
                card4Bound = new Rect(boardLocation.getP1Hand4Location());
            }
            if (card5Bound == null) {
                card5Bound = new Rect(boardLocation.getP1Hand5Location());
            }
            if (card6Bound == null) {
                card6Bound = new Rect(boardLocation.getP1Hand6Location());
            }
            if (card13Bound == null) {
                card13Bound = new Rect(boardLocation.getP1Bench1Location());
            }
            if (card14Bound == null) {
                card14Bound = new Rect(boardLocation.getP1Bench2Location());
            }
            if (card15Bound == null) {
                card15Bound = new Rect(boardLocation.getP1Bench3Location());
            }
            if (card19Bound == null) {
                card19Bound = new Rect(boardLocation.getP1ActiveLocation());
            }


            graphics2DInterface.drawBitmap(getBitmapArrayp1().get(0), null, card1Bound, null);
            graphics2DInterface.drawBitmap(getBitmapArrayp1().get(1), null, card2Bound, null);
            graphics2DInterface.drawBitmap(getBitmapArrayp1().get(2), null, card3Bound, null);
            graphics2DInterface.drawBitmap(getBitmapArrayp1().get(3), null, card4Bound, null);
            graphics2DInterface.drawBitmap(getBitmapArrayp1().get(4), null, card5Bound, null);
            graphics2DInterface.drawBitmap(getBitmapArrayp1().get(5), null, card6Bound, null);


        }
        if(touchedP2){
            enableDragP2 = true;

            if (card7Bound == null) {
                card7Bound = new Rect(boardLocation.getP2Hand1Location());
            }
            if (card8Bound == null) {
                card8Bound = new Rect(boardLocation.getP2Hand2Location());
            }
            if (card9Bound == null) {
                card9Bound = new Rect(boardLocation.getP2Hand3Location());
            }
            if (card10Bound == null) {
                card10Bound = new Rect(boardLocation.getP2Hand4Location());
            }
            if (card11Bound == null) {
                card11Bound = new Rect(boardLocation.getP2Hand5Location());
            }
            if (card12Bound == null) {
                card12Bound = new Rect(boardLocation.getP2Hand6Location());
            }
            if (card16Bound == null) {
                card16Bound = new Rect(boardLocation.getP2Bench1Location());
            }
            if (card17Bound == null) {
                card17Bound = new Rect(boardLocation.getP2Bench2Location());
            }
            if (card18Bound == null) {
                card18Bound = new Rect(boardLocation.getP2Bench3Location());
            }
            if (card20Bound == null) {
                card20Bound = new Rect(boardLocation.getP2ActiveLocation());
            }

            graphics2DInterface.drawBitmap(getBitmapArrayp2().get(0), null, card7Bound, null);
            graphics2DInterface.drawBitmap(getBitmapArrayp2().get(1), null, card8Bound, null);
            graphics2DInterface.drawBitmap(getBitmapArrayp2().get(2), null, card9Bound, null);
            graphics2DInterface.drawBitmap(getBitmapArrayp2().get(3), null, card10Bound, null);
            graphics2DInterface.drawBitmap(getBitmapArrayp2().get(4), null, card11Bound, null);
            graphics2DInterface.drawBitmap(getBitmapArrayp2().get(5), null, card12Bound, null);

        }
    }



}
