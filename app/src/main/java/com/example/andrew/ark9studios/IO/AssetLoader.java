package com.example.andrew.ark9studios.IO;


import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.SoundPool;

import com.example.andrew.ark9studios.Music.GameMusic;
import com.example.andrew.ark9studios.Music.Sound;

import android.util.Log;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

    /**
     * Created by Megan on 20/11/2016
     * Edited by Megan on 11/04/2017.
     */

    public class AssetLoader implements GameAssetInterface{


        /**
         * Android AssetManager; an asset loader
         */

        private AssetManager assetManager;



        /***
         * Create new Asset Loader
         *
         * @param assetManager
         *            - android AssetManager; an asset loader
         */

        public AssetLoader(AssetManager assetManager){
            this.assetManager = assetManager;
        }


        /**
         *
         * @param bitmapFileName
         *            Name of the bitmap to be loaded
         * @param format
         *            Bitmap format to be used when loading the bitmap
         * @return
         * @throws IOException
         *           If the asset cannot be opened or read
         */

        @Override
        public Bitmap loadBitmap(String bitmapFileName, Bitmap.Config format) throws IOException {

            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inPreferredConfig = format;
            InputStream in = null;
            Bitmap bitmap = null;
            try{
                in = assetManager.open(bitmapFileName);
                bitmap = BitmapFactory.decodeStream(in);
                if(bitmap == null){
                    String message = "Could not load bitmap [ " + bitmapFileName + "]";
                    throw new IOException(message);
                }
            }catch(IOException e){
                String message = "Could not load bitmap [ " + bitmapFileName + "]";
                throw new IOException(message);
            }finally{
                if(in != null){
                    try{
                        in.close();
                    }catch (IOException e){
                        Log.e("Quibtig",
                                "IO Exception when loaidng bitmap" +  bitmapFileName);
                    }
                }
            }
            return bitmap;
        }


        /**
         * Load in the specified music file.
         *
         * @param filename
         *            Name of the music asset to be loaded
         * @return Loaded Music instance, or null if the effect could not be loaded
         */
        public GameMusic loadMusic(String filename) throws IOException {
            try {
                AssetFileDescriptor assetDescriptor = assetManager.openFd(filename);
                return new GameMusic(assetDescriptor);
            } catch (IOException e) {
                String message = "Could not load music [" + filename + "]";
                throw new IOException(message);
            }
        }

        /**
         * Load in the specified sound effect file.
         * @param soundFileName
         *            Name of the sound asset to be loaded
         * @param soundPool
         * @return
         * @throws IOException
         */

        @Override
        public Sound loadSound(String soundFileName, SoundPool soundPool) throws IOException {
            try {
                AssetFileDescriptor assetDescriptor = assetManager.openFd(soundFileName);
                int soundId = soundPool.load(assetDescriptor, 0);
                return new Sound(soundPool, soundId);
            } catch (IOException e) {
                String message = "Could not load sound [" + soundFileName + "]";
                throw new IOException(message);
            }
        }


        /**
         * Load in the specified text file.
         * @param textFileName
         *            Name of the text file to be loaded
         * @return
         * @throws IOException
         */
        @Override
        public String loadText(String textFileName) throws IOException {
            String text = null;
            InputStream inputStream = null;
            try {
                // Try to open the text file
                inputStream = assetManager.open(textFileName);

                // Load in the text in 4k chunks
                ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
                byte[] chunk = new byte[4096];
                int len = 0;
                while ((len = inputStream.read(chunk)) > 0)
                    byteStream.write(chunk, 0, len);

                // Convert and return as a UFT8 string
                text = new String(byteStream.toByteArray(), "UTF8");
            } catch (IOException e) {
                String message = "Could not load text file [" + textFileName + "]";
                throw new IOException(message);
            } finally {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e) {
                        Log.e("Quibtig",
                                "IO Exception when loading text " + textFileName);
                        return null;
                    }
                }
            }
            return text;
        }
    }


