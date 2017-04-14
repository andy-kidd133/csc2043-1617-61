package com.example.andrew.ark9studios;


import java.io.IOException;
import java.util.HashMap;

import android.graphics.Bitmap;
import android.media.AudioManager;
import android.media.SoundPool;
import android.media.SoundPool.OnLoadCompleteListener;
import android.util.Log;

import com.example.andrew.ark9studios.IO.FileIO;


/**
 * Asset dictionary for holding loaded assets.
 *
 */
public class AssetManager {

    /**
     * Bitmap asset dictionary
     */
    private HashMap<String, Bitmap> bitmaps;

    /**
     * Music asset dictionary
     */
    private HashMap<String, GameMusic> music;

    /**
     * Sound asset dictionary
     */
    private HashMap<String, Sound> sounds;

    /**
     * Text file asset dictionary
     */
    private HashMap<String, String> text;

    /***
     * Sound Pool used for loading sounds
     */
    private SoundPool soundPool;

    /***
     * Keep track of wheter current sound has loaded
     */
    private boolean soundLoaded = false;

    /**
     * Game IO
     */
    private FileIO  gameIO;

    /**
     * Create a new asset dictionary
     *
     * @param
     */
    public AssetManager(FileIO gameIO) {
        this.gameIO = gameIO;
        this.bitmaps = new HashMap<String, Bitmap>();
        this.music = new HashMap<String, GameMusic>();
        this.sounds = new HashMap<String, Sound>();
        this.text = new HashMap<String, String>();
        this.soundPool = new SoundPool(Sound.MAX_CONCURRENT_SOUNDS,
                AudioManager.STREAM_MUSIC, 0);
        // on each sound load into the sound pool, on finish
        // loading, then update soundLoaded
        this.soundPool.setOnLoadCompleteListener(new OnLoadCompleteListener() {

            @Override
            public void onLoadComplete(SoundPool soundPool, int sampleId,
                                       int status) {
                soundLoaded = true;
            }
        });
    }

    /**
     * Add the specified bitmap asset to the dictionary
     *
     * @param assetName Name given to the asset
     * @param asset     Bitmap asset to add
     * @return boolean true if the asset could be added, false it not (e.g. an
     * asset with the specified name already exists).
     */
    private boolean add(String assetName, Bitmap asset) {
        if (bitmaps.containsKey(assetName)) {
            return false;
        }
        bitmaps.put(assetName, asset);
        return true;
    }



    /**
     * Add the specified sound asset to the dictionary
     *
     * @param assetName Name given to the asset
     * @param asset     Sound asset to add
     * @return boolean true if the asset could be added, false it not (e.g. an
     * asset with the specified name already exists).
     */
    private boolean add(String assetName, String asset) {
        if (text.containsKey(assetName)) {
            return false;
        }
        text.put(assetName, asset);
        return true;
    }

    /**
     * Add the specified text asset to the dictionary
     *
     * @param assetName Name given to the asset
     * @param asset     Text asset to add
     * @return boolean true if the asset could be added, false it not (e.g. an
     * asset with the specified name already exists).
     */
    private boolean add(String assetName, Sound asset) {
        if (sounds.containsKey(assetName)) {
            return false;
        }
        sounds.put(assetName, asset);
        return true;
    }

    /**
     * Load and add the specified bitmap asset to the dictionary
     *
     * @param assetName  Name given to the asset
     * @param bitmapFile Location of the bitmap asset
     * @return boolean true if the asset could be loaded and added, false if not
     */
    public boolean loadAndAddBitmap(String assetName, String bitmapFile) {

        boolean success = true;
        try {
            Bitmap bitmap = gameIO.loadBitmap(bitmapFile, null);
            success = add(assetName, bitmap);
        } catch (IOException e) {
            Log.e("TribalHunter",
                    "Assetdictionary.loadAndAddBitmap: Cannot load ["
                            + bitmapFile + "]");
            success = false;
        }

        return success;
    }



    /**
     * Load and add the specified sound asset to the dictionary
     *
     * @param assetName Name given to the asset
     * @param soundFile Location of the sound asset
     * @return boolean true if the asset could be loaded and added, false if not
     */
    public boolean loadAndAddSound(String assetName, String soundFile) {
        soundLoaded = false;
        boolean success = true;
        try {
            Sound sound = gameIO.loadSound(soundFile, soundPool);
            while (soundLoaded == false) {
                Log.d("TribalHunter", "Loading Sound : " + soundFile);
            }
            success = add(assetName, sound);
        } catch (IOException e) {
            Log.e("TribalHunter",
                    "Assetdictionary.loadAndAddSound: Cannot load ["
                            + soundFile + "]");
            success = false;
        }

        return success;
    }

    /**
     * Allows the user to specify a list of assets to be loaded, as a dictionary
     * containing the asset names and asset file paths.
     * <p>
     * Determies the type of each file based on the folder path, i.e. an asset
     * from the folder path assets/sfx will be assumed to be a sound effect.
     *
     * @param assetsDictionary - hashmap of assets names and asset file paths
     * @return boolean value indicating whether all assets where added
     */
    public boolean loadMultipleAssets(HashMap<String, String> assetsDictionary) {
        boolean hasAddedAllAssets = true;
        for (String assetKey : assetsDictionary.keySet()) {
            String assetFilePath = assetsDictionary.get(assetKey);
            // get index of first '/'
            int firstForwardSlashCharacterIndex = assetFilePath.indexOf('/');
            // if can't find first forward slash, can't load this asset,
            // so stop trying to load all the assets
            if (firstForwardSlashCharacterIndex == -1) {
                hasAddedAllAssets = false;
                break;
            }
            // get substring up to first forward slash to indicate which
            // folder the asset is referencing
            String folderString = assetFilePath.substring(0,
                    firstForwardSlashCharacterIndex);
            if (folderString.equals("assets/images")) {
                loadAndAddBitmap(assetKey, assetFilePath);
            } else if (folderString.equals("assets/sfx")) {
                loadAndAddSound(assetKey, assetFilePath);
            } else if (folderString.equals("assets/txt")) {
                loadAndAddText(assetKey, assetFilePath);
            } else {
                hasAddedAllAssets = false;
            }
        }
        return hasAddedAllAssets;
    }

    /**
     * Load and add the specified text file asset to the dictionary
     *
     * @param assetName Name given to the asset
     * @param textFile  Location of the text file asset
     * @return boolean true if the asset could be loaded and added, false if not
     */
    public boolean loadAndAddText(String assetName, String textFile) {
        boolean success = true;
        try {
            String text = gameIO.loadText(textFile);
            success = add(assetName, text);
        } catch (IOException e) {
            Log.e("TribalHunter",
                    "Assetdictionary.loadAndAddSound: Cannot load [" + textFile
                            + "]");
            success = false;
        }

        return success;
    }

    /**
     * Retrieve the specified bitmap asset from the dictionary
     *
     * @param assetName Name of the asset to retrieve
     * @return Bitmap asset, null if the named asset could not be found
     */
    public Bitmap getBitmap(String assetName) {
        return bitmaps.get(assetName);
    }


    /**
     * Retrieve the specified sound asset from the dictionary
     *
     * @param assetName Name of the asset to retrieve
     * @return Sound asset, null if the named asset could not be found
     */
    public Sound getSound(String assetName) {
        return sounds.get(assetName);
    }

    /**
     * Retrieve the specified text file asset from the dictionary
     *
     * @param assetName Name of the asset to retrieve
     * @return Text file asset, null if the named asset could not be found
     */
    public String getText(String assetName) {
        return text.get(assetName);
    }

    /**
     * Reinitialises the assets to empty
     */
    public void emptyAssets() {
        bitmaps = new HashMap<String, Bitmap>();
        text = new HashMap<String, String>();
        sounds = new HashMap<String, Sound>();

    }

}





