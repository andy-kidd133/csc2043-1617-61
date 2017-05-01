package com.example.andrew.ark9studios.Screens;


import android.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.andrew.ark9studios.Game;
import com.example.andrew.ark9studios.GameScreen;

import java.io.IOException;
import java.io.InputStream;
/*import com.example.andrew.ark9studios.gameInfrastructure.GameLoop;
import com.example.andrew.ark9studios.Music.GameMusic;
import com.example.andrew.ark9studios.GameViews.PauseGameMenuView;
import com.example.andrew.ark9studios.R;
import com.example.andrew.ark9studios.activities.WelcomeActivity;*/



/**
 * Created by Megan on 06/03/2017.
 */

public class GameFragment extends Fragment {


    /***
     * Game
     */
    protected Game game;

    /*
     * (non-Javadoc)
     *
     * @see android.app.Fragment#onCreate(android.os.Bundle)
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // instantiate a new game object
        this.game = new Game(this);
        game.initialiseGameComponents();
    }

    /*
     * (non-Javadoc)
     *
     * @see android.app.Fragment#onCreateView(android.view.LayoutInflater,
     * android.view.ViewGroup, android.os.Bundle)
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // return the game surface
        return game.setUpViewAndReturn();
    }

    /*
     * (non-Javadoc)
     *
     * @see android.app.Fragment#onResume()
     */
    @Override
    public void onResume() {
        game.resume();
        super.onResume();

    }

    /*
     * (non-Javadoc)
     *
     * @see android.app.Fragment#onPause()
     */
    @Override
    public void onPause() {
        game.pause();
        super.onPause();
    }

    /*
     * (non-Javadoc)
     *
     * @see android.app.Fragment#onDestroy()
     */
    @Override
    public void onDestroy() {
        game.destroy();
        super.onDestroy();
    }

    /***
     *
     * Used to setup a GameScreen that will be initially shown on launch of the
     * game.
     *
     * @param gameScreen
     *            - screen to display on game startup
     */
    public void setupStartScreen(GameScreen gameScreen) {
        game.setupInitialGameScreen(gameScreen);
    }

    //Json file loader

    public String loadJSONFile() {
        String json = null;
        try {
            InputStream is = getActivity().getAssets().open("CardList.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }



}








