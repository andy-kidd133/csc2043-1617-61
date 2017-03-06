package com.example.andrew.ark9studios;

import android.content.Context;
import android.media.MediaPlayer;

/**
 * Created by Megan on 06/03/2017.
 */

public class GameMusic extends MediaPlayer {


    private MediaPlayer backgroundMusic;
    private int currentPos;
    private boolean played, musicOff, isGamePlaying;

    public GameMusic(Context context, int resid){
        backgroundMusic = MediaPlayer.create(context, resid);
        backgroundMusic.setLooping(true);
        played = false;
        musicOff= false;
        isGamePlaying=false;

    }



    public void startGameMusic(){
        backgroundMusic.start();
        played=true;
    }

    public void pauseGameMusic(){
        currentPos=backgroundMusic.getCurrentPosition();
        backgroundMusic.pause();
    }


    public void resumeGameMusic(){
        if(musicOff == false && isGamePlaying==false){
            backgroundMusic.start();
            backgroundMusic.seekTo(currentPos);
        }
    }

    public void stopGameMusic(){
        backgroundMusic.pause();
        currentPos=0;
    }

    public void destroyGameMusic(){
        backgroundMusic.stop();
        backgroundMusic.release();
    }



    //setters

    public void turnOnMusic() {
        musicOff = false;
    }

    public void turnOffMusic(){
        musicOff=true;
    }

    public void setIsGamePlaying(boolean m){
        isGamePlaying=m;
    }





    public boolean isMusicOff(){
        return musicOff;
    }

    public boolean isGamePlaying(){
        return isGamePlaying;
    }


    public boolean hasPlayed(){
        return played;
    }



}
