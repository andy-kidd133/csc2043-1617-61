package com.example.andrew.ark9studios;

import android.graphics.Bitmap;
import android.util.Log;

import com.example.andrew.ark9studios.CoreServices.FileIO;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

/**
 * Created by megan on 13/02/2017.
 */


public class AssetStore {


  //Properties


    private HashMap<String, Bitmap> aBitmaps;

    private HashMap<String , GameMusic> aMusic;

    private FileIO aFileIO;


    //constructors

    public AssetStore(FileIO fileIO){
        aFileIO = fileIO;
        aBitmaps = new HashMap<String, Bitmap>();
        aMusic = new HashMap<String, GameMusic>();

    }


   //Store


    /**
     * Adding the specfied bitmap asset to the assest store
     *
     * @param assetName name given to the asset
     * @param asset Bitmap to be added
     * @return true if the asset could be added, false if not i.e. an
     * asset with the specficied name already exists
     */

    public boolean add(String assetName, Bitmap asset){
        if(aBitmaps.containsKey(assetName))
            return false;

        aBitmaps.put(assetName, asset);
        return true;
    }


    /**
     * Adding the specfied bitmap asset to the assest store
     *
     * @param assetName name given to the asset
     * @param asset Bitmap to be added
     * @return true if the asset could be added, false if not i.e. an
     * asset with the specficied name already exists
     */

    public boolean add(String assetName, GameMusic asset){
        if(aMusic.containsKey(assetName))
            return false;

        aMusic.put(assetName, asset);
        return true;
    }








    /**
     * Retrieve the specified bitmap asset from the store
     *
     * @param assetName Name of the asset to retrieve
     * @return Bitmap asset, null if the named asset could not be found
     */
    public Bitmap getBitmap(String assetName) {
        return aBitmaps.get(assetName);
    }

    /**
     * Retrieve the specified music asset from the store
     *
     * @param assetName Name of the asset to retrieve
     * @return Music asset, null if the named asset could not be found
     */
    public GameMusic getMusic(String assetName) {
        return aMusic.get(assetName);
    }




}
