package com.example.andrew.ark9studios;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.ParcelFileDescriptor;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by megan on 13/02/2017.
 */


public class AssetStore {



    // /////////////////////////////////////////////////////////////////////////
    // Properties
    // /////////////////////////////////////////////////////////////////////////

    /**
     * Bitmap asset store
     */
    private HashMap<String, Bitmap> mBitmaps;

    /**
     * Music asset store
     */
    private HashMap<String, GameMusic> mMusic;

    /**
     * Sound asset store
     */
    private HashMap<String, Sound> mSounds;
    private SoundPool mSoundPool;

    /**
     * File IO
     */
    private FileIO mFileIO;

    // /////////////////////////////////////////////////////////////////////////
    // Constructors
    // /////////////////////////////////////////////////////////////////////////

    /**
     * Create a new asset store
     *
     * @param FileIO Context to which this File IO will use
     */
    public AssetStore(FileIO fileIO) {
        mFileIO = fileIO;
        mBitmaps = new HashMap<String, Bitmap>();
        mMusic = new HashMap<String, GameMusic>();
        mSounds = new HashMap<String, Sound>();
        mSoundPool = new SoundPool(Sound.MAX_CONCURRENT_SOUNDS,
                AudioManager.STREAM_MUSIC, 0);
    }

    // /////////////////////////////////////////////////////////////////////////
    // Store //
    // /////////////////////////////////////////////////////////////////////////

    /**
     * Add the specified bitmap asset to the store
     *
     * @param assetName Name given to the asset
     * @param asset     Bitmap asset to add
     * @return boolean true if the asset could be added, false it not (e.g. an
     * asset with the specified name already exists).
     */
    public boolean add(String assetName, Bitmap asset) {
        if (mBitmaps.containsKey(assetName))
            return false;

        mBitmaps.put(assetName, asset);
        return true;
    }


    /**
     * Add the specified sound asset to the store
     *
     * @param assetName Name given to the asset
     * @param asset     Sound asset to add
     * @return boolean true if the asset could be added, false it not (e.g. an
     * asset with the specified name already exists).
     */
    public boolean add(String assetName, Sound asset) {
        if (mSounds.containsKey(assetName))
            return false;

        mSounds.put(assetName, asset);
        return true;
    }

    /**
     * Load and add the specified bitmap asset to the store
     *
     * @param assetName  Name given to the asset
     * @param bitmapFile Location of the bitmap asset
     * @return boolean true if the asset could be loaded and added, false if not
     */
    public boolean loadAndAddBitmap(String assetName, String bitmapFile) {

        boolean success = true;
        try {
            Bitmap bitmap = mFileIO.loadBitmap(bitmapFile, null);
            success = add(assetName, bitmap);
        } catch (IOException e) {
            Log.e("Gage", "AssetStore.loadAndAddBitmap: Cannot load ["
                    + bitmapFile + "]");
            success = false;
        }

        return success;
    }


    /**
     * Load and add the specified sound asset to the store
     *
     * @param assetName Name given to the asset
     * @param soundFile Location of the sound asset
     * @return boolean true if the asset could be loaded and added, false if not
     */
    public boolean loadAndAddSound(String assetName, String soundFile) {
        boolean success = true;
        try {
            Sound sound = mFileIO.loadSound(soundFile, mSoundPool);
            success = add(assetName, sound);
        } catch (IOException e) {
            Log.e("Gage", "AssetStore.loadAndAddSound: Cannot load ["
                    + soundFile + "]");
            success = false;
        }

        return success;
    }

    /**
     * Retrieve the specified bitmap asset from the store
     *
     * @param assetName Name of the asset to retrieve
     * @return Bitmap asset, null if the named asset could not be found
     */
    public Bitmap getBitmap(String assetName) {
        return mBitmaps.get(assetName);
    }

    /**
     * Retrieve the specified music asset from the store
     *
     * @param assetName Name of the asset to retrieve
     * @return Music asset, null if the named asset could not be found
     */
    public GameMusic getMusic(String assetName) {
        return mMusic.get(assetName);
    }

    /**
     * Retrieve the specified sound asset from the store
     *
     * @param assetName Name of the asset to retrieve
     * @return Sound asset, null if the named asset could not be found
     */
    public Sound getSound(String assetName) {
        return mSounds.get(assetName);
    }




}
