package com.example.andrew.ark9studios.fragments;


import android.app.Fragment;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.example.andrew.ark9studios.AssetStore;
import com.example.andrew.ark9studios.CardHelper;
import com.example.andrew.ark9studios.CharacterCard;
import com.example.andrew.ark9studios.Deck;
import com.example.andrew.ark9studios.GameLoop;
import com.example.andrew.ark9studios.GameMusic;
import com.example.andrew.ark9studios.GameViews.PauseGameMenuView;
import com.example.andrew.ark9studios.R;
import com.example.andrew.ark9studios.activities.MainActivity;

import java.util.ArrayList;

import static android.R.attr.bitmap;

/**
 * Created by Megan on 06/03/2017.
 */

public class MainGameFragment extends Fragment {

    private static GameLoop gameLoop;
    private AssetStore myAssetManager;
    private MainActivity mainActivity;
    private static GameMusic gameMusic;
    private PauseGameMenuView pauseMenu;
     private ImageView pause;
    private static boolean paused = false;




    @Override
    public void onCreate (Bundle savedInstanceState) {
       gameLoop = new GameLoop(30) {
           @Override
           public void doDraw() {

           }

           @Override
           public void doUpdate() {

           }
       };


        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_game_frag, container, false);

        pause = (ImageView) view.findViewById(R.id.pauseicon);

            //initialising and hiding the pause menu
            pauseMenu=new PauseGameMenuView(getActivity(),MainGameFragment.this);
            pauseMenu.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            pauseMenu.hide();


        mainActivity = (MainActivity) getActivity();



       gameMusic = new GameMusic(getActivity().getApplicationContext(), R.raw.laser_groove);
       if(mainActivity.getPlayer().isOff()==false){
           mainActivity.getPlayer().stopGameMusic();
          gameMusic.startGameMusic();
        }




        //calling the pause menu method
         setUpPauseMenu();




            return view;

    }



   public void setUpPauseMenu(){

       pause.setOnClickListener(new View.OnClickListener(){


           @Override
           public void onClick(View v) {
               if(gameLoop.isRunning()){
                   onPause();
                   pauseMenu.show();;
                   paused = true;
               }else{
                   onResume();
               }
           }
       });

   }


    @Override
    public void onPause() {
        gameLoop.pause();
        if(gameMusic.hasPlayed()==true){
            gameMusic.pauseGameMusic();
        }

        if(mainActivity.isFinishing()){
            if(gameMusic.hasPlayed()==true){
                gameMusic.destroyGameMusic();
            }
        }
     super.onPause();
    }


    @Override
    public void onResume() {
        gameLoop.resume();
        if(gameMusic.hasPlayed()==true){
            gameMusic.resumeGameMusic();
        }
        paused = false;
        pauseMenu.hide();
        super.onResume();
    }


    /**
     * @return
     *
     * returns the value of the pause flag
     */
    public static boolean isPaused() {
        return paused;
    }
    /**
     * @param npause
     * toggles the value of the pause flag
     */
    public static void setPaused(boolean npause) {
        paused = npause;
    }

    public static GameMusic getGameMusic(){
        return gameMusic;
    }

    public static GameLoop getGameLoop() {
        return gameLoop;
    }


}








