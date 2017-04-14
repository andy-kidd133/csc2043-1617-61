package com.example.andrew.ark9studios.IO;

/**
 * Created by Megan on 11/03/2017.
 * edited by Megan 11/04/2017
 */

import android.graphics.Bitmap;
import android.media.SoundPool;

import com.example.andrew.ark9studios.GameMusic;
import com.example.andrew.ark9studios.Sound;

import java.io.IOException;

/**
 * This interface contains methods for loading assets into the game
 */

public interface GameAssetInterface {




    /**
     * Load the specified bitmap using the specified format from the APK file.
     *
     * @param bitmapFileName
     *            Name of the bitmap to be loaded
     * @param format
     *            Bitmap format to be used when loading the bitmap
     * @throws IOException
     *             if the asset cannot be opened or read.
     */

    Bitmap loadBitmap(String bitmapFileName, Bitmap.Config format) throws IOException;


    /**
     * Load in the specified music file.
     *
     * @param musicFileName
     *            Name of the music asset to be loaded
     * @return Loaded Music instance, or null if the effect could not be loaded
     * @throws IOException
     *             if the asset cannot be opened or read.
     */

    GameMusic loadMusic(String musicFileName) throws IOException;

    /**
     * Load in the specified sound effect file.
     *
     * @param soundFileName
     *            Name of the sound asset to be loaded
     * @return Loaded Sound instance, or null if clip could not be loaded
     *   * @throws IOException
     *             if the asset cannot be opened or read.
     */


    Sound loadSound(String soundFileName, SoundPool soundPool) throws IOException;


    /**
     * Load in the specified text file.
     *
     * @param textFileName
     *            Name of the text file to be loaded
     * @return Loaded Text file contents or null if could not be loaded
     *   * @throws IOException
     *             if the asset cannot be opened or read.
     */

    String loadText(String textFileName) throws IOException;


}
