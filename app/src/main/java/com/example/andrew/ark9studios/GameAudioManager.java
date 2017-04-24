package com.example.andrew.ark9studios;

import android.content.Context;
import android.media.AudioManager;

/**
 * Created by Megan on 24/04/2017.
 */

public class GameAudioManager {



    /***
     * Android Audio Manager
     */
    private AudioManager audioManager;

    /***
     * Whether Sound is enabled in the game
     */
    public static boolean SOUND_ENABLED;

    /***
     * Create a new GameAudioManager
     *
     * @param context
     *            - Android Application Context
     */
    public GameAudioManager(Context context) {
        // retrieve android audio manager
        this.audioManager = (AudioManager) context
                .getSystemService(Context.AUDIO_SERVICE);
        // set sound enabled to true
        SOUND_ENABLED = true;
    }

    /***
     * Mute all Sound in the Game
     */
    public void muteSound() {
        audioManager.setStreamMute(AudioManager.STREAM_NOTIFICATION, true);
        audioManager.setStreamMute(AudioManager.STREAM_ALARM, true);
        audioManager.setStreamMute(AudioManager.STREAM_MUSIC, true);
        audioManager.setStreamMute(AudioManager.STREAM_RING, true);
        audioManager.setStreamMute(AudioManager.STREAM_SYSTEM, true);

        SOUND_ENABLED = false;
    }

    /***
     * Unmute all sound in the game.
     */
    public void unmuteSound() {
        audioManager.setStreamMute(AudioManager.STREAM_NOTIFICATION, false);
        audioManager.setStreamMute(AudioManager.STREAM_ALARM, false);
        audioManager.setStreamMute(AudioManager.STREAM_MUSIC, false);
        audioManager.setStreamMute(AudioManager.STREAM_RING, false);
        audioManager.setStreamMute(AudioManager.STREAM_SYSTEM, false);

        SOUND_ENABLED = true;
    }



















}
