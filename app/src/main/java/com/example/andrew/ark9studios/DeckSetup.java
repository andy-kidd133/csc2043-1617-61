package com.example.andrew.ark9studios;
import android.graphics.Bitmap;
import android.graphics.Rect;

import com.example.andrew.ark9studios.AssetManager;
import com.example.andrew.ark9studios.Game;

import java.util.ArrayList;
import java.util.Collections;


/**
 * Created by Karlm on 26/04/2017.
 */

//

public class DeckSetup {


    public Bitmap card1Bitmap,card2Bitmap,card3Bitmap,card4Bitmap,card5Bitmap,card6Bitmap,card7Bitmap,card8Bitmap,
            card9Bitmap,card10Bitmap,card11Bitmap,card12Bitmap,card13Bitmap,card14Bitmap,card15Bitmap,card16Bitmap,
            card17Bitmap,card18Bitmap,card19Bitmap,card20Bitmap,card21Bitmap,card22Bitmap,card23Bitmap,card24Bitmap,
            card25Bitmap,card26Bitmap,card27Bitmap,card28Bitmap;



    public static Rect card1Bound,card2Bound,card3Bound,card4Bound,card5Bound,card6Bound,card7Bound,card8Bound,card9Bound,
            card10Bound,card11Bound,card12Bound,card13Bound, card14Bound,card15Bound,card16Bound,card17Bound,
            card18Bound;

    public enum cardType{character, action, energy}



    ArrayList<Bitmap> bitmapArrayOriginal = new ArrayList<Bitmap>(28);
    ArrayList<Bitmap> bitmapArrayp1 = new ArrayList<Bitmap>(28);
    ArrayList<Bitmap> bitmapArrayp2 = new ArrayList<Bitmap>(28);


    public ArrayList<Bitmap> getBitmapArrayp1() {
        return bitmapArrayp1;
    }
    public ArrayList<Bitmap> getBitmapArrayp2() {
        return bitmapArrayp2;
    }


    public DeckSetup(Game game) {

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

}
