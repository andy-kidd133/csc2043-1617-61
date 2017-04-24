package com.example.andrew.ark9studios;


import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.util.Log;

import java.io.IOException;


/**
 * Created by Megan on 06/03/2017.
 */

public class GameMusic implements MediaPlayer.OnCompletionListener {

    /**
     * Media player that will be used to playback this music clip
     */
    private MediaPlayer mediaPlayer;

    /**
     * Flag indicating if playback can commence
     */
    private boolean isPrepared = false;

    /**
     * Asset filename
     */
    private String assetFile;

    /**
     * Create a new music clip
     *
     * @param assetDescriptor
     *            Asset descriptor linked to this audio file
     */
    public GameMusic(AssetFileDescriptor assetDescriptor) {
        this.assetFile = assetDescriptor.getFileDescriptor().toString();

        // Create a new play player linked to the specified music asset
        this.mediaPlayer = new MediaPlayer();
        try {
            // Link the data source
            mediaPlayer.setDataSource(assetDescriptor.getFileDescriptor(),
                    assetDescriptor.getStartOffset(),
                    assetDescriptor.getLength());

            // Prep the audio for playback
            mediaPlayer.prepare();
            this.isPrepared = true;

            // Add an on completion listener for the clip
            mediaPlayer.setOnCompletionListener(this);
        } catch (IOException e) {
            String errorTag = "Quibtig";
            String errorMessage = "Music clip " + assetFile
                    + " cannot be loaded.";
            Log.w(errorTag, errorMessage);
        }
    }

    /**
     * Play the music clip.
     *
     * Note: If the music clip is already playing the play request is ignored.
     */
    public void play() {
        if (mediaPlayer.isPlaying())
            return;
        try {
            synchronized (this) {
                // Start the clip, preparing it if needed
                if (!isPrepared) {
                    mediaPlayer.prepare();
                }
                mediaPlayer.start();
            }
        } catch (Exception e) {
            String errorTag = "Quibtig";
            String errorMessage = "Music clip " + assetFile
                    + " cannot be played.";
            Log.w(errorTag, errorMessage);
        }
    }

    /**
     * Stop the music clip.
     */
    public void stop() {
        mediaPlayer.stop();
        synchronized (this) {
            isPrepared = false;
        }
    }

    /**
     * Pause the music clip.
     */
    public void pause() {
        if (mediaPlayer.isPlaying())
            mediaPlayer.pause();
    }

    /**
     * Determine if the music clip will loop
     *
     * @param looping
     *            Boolean true to loop, false for play once.
     */
    public void setLooping(boolean looping) {
        mediaPlayer.setLooping(looping);
    }

    /**
     * Set the playback volume
     *
     * @param volume
     *            Playback volume (0-1)
     */
    public void setVolume(float volume) {
        mediaPlayer.setVolume(volume, volume);
    }

    /**
     * Set the playback volume
     *
     * @param leftVolume
     *            Left channel playback volume (0-1)
     * @param rightVolume
     *            Right channel playback volume (0-1)
     */
    public void setVolume(float leftVolume, float rightVolume) {
        mediaPlayer.setVolume(leftVolume, rightVolume);
    }

    /**
     * Determine if the music clip is currently playing
     *
     * @return Boolean true if the music clip is currently playing, otherwise
     *         false
     */
    public boolean isPlaying() {
        return mediaPlayer.isPlaying();
    }

    /**
     * Determine if the music clip is set to loop
     *
     * @return Boolean true if the clip is looping, otherwise false
     */
    public boolean isLooping() {
        return mediaPlayer.isLooping();
    }

    /**
     * Dispose of the music clip
     */
    public void dispose() {
        if (mediaPlayer.isPlaying())
            mediaPlayer.stop();
        mediaPlayer.release();
    }

    /***
     * Implementation of OnCompleteListener interface
     */
    public void onCompletion(MediaPlayer player) {
        synchronized (this) {
            isPrepared = false;
        }
    }
}


