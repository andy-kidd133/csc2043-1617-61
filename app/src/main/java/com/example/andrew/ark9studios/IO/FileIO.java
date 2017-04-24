package com.example.andrew.ark9studios.IO;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.SoundPool;
import android.os.Environment;
import android.preference.PreferenceManager;

import com.example.andrew.ark9studios.GameMusic;
import com.example.andrew.ark9studios.Sound;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by Megan on 20/11/2016
 * edited by Megan on 12/03/2017.
 */

public class FileIO {


// /////////////////////////////////////////////////////////////////////////
    // Properties
    // /////////////////////////////////////////////////////////////////////////

    /**
     * Context for the file IO
     */
    private Context mContext;

    /**
     * Asset manager that will be used
     */
    private AssetManager mAssetManager;

    /**
     * Location of the external storage
     */
    private String mExternalStoragePath;

    /**
     * GameAssetStore loader is used to load in the assets
     */
    private AssetLoader gameAssetLoader;

    // /////////////////////////////////////////////////////////////////////////
    // Constructors
    // /////////////////////////////////////////////////////////////////////////

    /**
     * Create a new File IO service
     *
     * @param context
     *            Context to which this File IO will use
     */
    public FileIO(Context context) {
        mContext = context;
        this.gameAssetLoader = new AssetLoader(context.getAssets());
        mAssetManager = context.getAssets();
        mExternalStoragePath = Environment.getExternalStorageDirectory()
                .getAbsolutePath() + File.separator;
    }

    // /////////////////////////////////////////////////////////////////////////
    // Asset IO //
    // /////////////////////////////////////////////////////////////////////////

    /**
     * Open an input stream to the named asset stored in the APK file.
     *
     * @param assetName
     *            Name of the asset to open for reading
     * @return InputStream that can be used to read the asset
     * @throws IOException
     *             if the asset cannot be opened
     */
    public InputStream readAsset(String assetName) throws IOException {
        return mAssetManager.open(assetName);
    }

    /**
     * Load the specified bitmap using the specified format from the APK file.
     *
     * @param bitmapFile
     *            Name of the bitmap to be loaded
     * @param format
     *            Bitmap format to be used when loading the bitmap
     * @throws IOException
     *             if the asset cannot be opened or read.
     */
    public Bitmap loadBitmap(String bitmapFile, Bitmap.Config format)
            throws IOException {

        return gameAssetLoader.loadBitmap(bitmapFile,format );
    }

    /***
     * Wrapper method to load in a given music file via the GameAssetLoader
     *
     * @param musicFile
     *            - path of the music file that is to be loaded
     * @return Music instance that has been loaded for given music file path
     * @throws IOException
     *             - if the asset cannot be loaded
     */
    public GameMusic loadMusic(String musicFile) throws IOException {
        return gameAssetLoader.loadMusic(musicFile);
    }


    /**
     * Load in the specified sound effect file.
     *
     * @param filename
     *            Name of the sound asset to be loaded
     * @return Loaded Sound instance, or null if clip could not be loaded
     */
    public Sound loadSound(String filename, SoundPool soundPool)
            throws IOException {
           return gameAssetLoader.loadSound(filename, soundPool);
    }


    public String loadText(String textFile) throws IOException{
        return gameAssetLoader.loadText(textFile);
    }


    // /////////////////////////////////////////////////////////////////////////
    // Device Storage IO //
    // /////////////////////////////////////////////////////////////////////////

    /**
     * Open an input stream to the name file in device storage.
     *
     * @param fileName
     *            Name of the file to open for reading
     * @return InputStream that can be used to read the file
     * @throws IOException
     *             if the asset cannot be opened.
     */
    public InputStream readFile(String fileName) throws IOException {
        return new FileInputStream(mExternalStoragePath + fileName);
    }

    /**
     * Open an output stream to the name file in device storage.
     *
     * @param fileName
     *            Name of the file to open for writing
     * @return OutputStream that can be used to write to the file
     * @throws IOException
     *             if the asset cannot be opened for writing
     */
    public OutputStream writeFile(String fileName) throws IOException {
        return new FileOutputStream(mExternalStoragePath + fileName);
    }

    // /////////////////////////////////////////////////////////////////////////
    // Preferences IO //
    // /////////////////////////////////////////////////////////////////////////

    /**
     * Get the shared preferences for the app.
     *
     * @return Shared preferences instance
     */
    public SharedPreferences getPreferences() {
        return PreferenceManager.getDefaultSharedPreferences(mContext);
    }
}
