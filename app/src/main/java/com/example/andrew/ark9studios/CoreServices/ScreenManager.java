package com.example.andrew.ark9studios.CoreServices;

import com.example.andrew.ark9studios.GameScreen;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Andrew on 10/02/2017.
 */

    //Stores available screens within the game
    //Screens can be added or removed to reflect the game

public class ScreenManager {

    //hash map for the collection of available game screens
    private Map<String, GameScreen> mGameScreens;

    //current game screen
    private GameScreen mCurrentScreen;

    //constructor
    public ScreenManager() {
        mGameScreens = new HashMap<String, GameScreen>();
        mCurrentScreen = null;
    }

    ////////////////////////////////////////////////////////////////////
    //Methods
    ////////////////////////////////////////////////////////////////////

    //Add the specified game screen to the manager

    public boolean addScreen(GameScreen screen) {

        //add the game screen if the specified name isnt already added
        if (mGameScreens.containsKey(screen.getmName()))
            return false;
        mGameScreens.put(screen.getmName(), screen);

        //if this is the first screen added then set it as the default screen
        if (mGameScreens.size() == 1)
            mCurrentScreen = screen;

        return true;
    }

    //Set the named game screen as the current screen

    public boolean setAsCurrentScreen(String name) {
        GameScreen currentScreen = mGameScreens.get(name);
        if (currentScreen != null) {
            mCurrentScreen = currentScreen;
            return true;
        } else
            return false;
    }

    //Getters

    public GameScreen getCurrentScreen() {
        return mCurrentScreen;
    }

    public GameScreen getScreen (String name) {
        return mGameScreens.get(name);
    }

    //Remove the specified game screen from the manager

    public boolean removeScreen(String name) {
        GameScreen gameScreen = mGameScreens.remove(name);
        return (gameScreen != null);
    }

    //Dispose of the manager and all game screens stored within the manager

    public void dispose() {
        for (GameScreen gameScreen : mGameScreens.values())
            gameScreen.dispose();
    }
}
