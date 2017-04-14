package com.example.andrew.ark9studios.gameInfrastructure;

import com.example.andrew.ark9studios.GameScreen;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Megan on 11/11/2016.
 * edited by Megan 12/04/2017
 */

public class ScreenManager {

    //////////////////////////////////////////////////////////////////
    //Variables
    //////////////////////////////////////////////////////////////////


    /**
     * collection of game screens
     */
    private Map<String, GameScreen> gameScreens;


    /**
     * this is the current game screen
     */
    private GameScreen currentGameScreen;



    //////////////////////////////////////////////////////////////////
    //Constructor
    //////////////////////////////////////////////////////////////////
    /**
     * Constructor for screen manager
     */

    public ScreenManager(){
        this.gameScreens = new HashMap<String, GameScreen>();
        this.currentGameScreen = null;
    }




    //////////////////////////////////////////////////////////////////
    //Methods
    //////////////////////////////////////////////////////////////////

    /**
     * adding game screens to the manager
     * @param screen- name of screen to be addded
     * @return- return true if the screen was added, false if it
     * could'nt be added(name specified already exists)
     * */
    public boolean addGameScreen(GameScreen screen){
        //checking if game screens already contain a
        //screen with the specified name, if not add it
        if(gameScreens.containsKey(screen.getmName())){
            return false;
        }
        gameScreens.put(screen.getmName(), screen);


        //if this screen is the first added, set it as the deault screen
        if(gameScreens.size() == 1){
            currentGameScreen = screen;
        }

        return true;
    }


    /**
     * set the name screen specified as the current game screen
     * @param name - string name reference for the targetted screen
     * @return- ture if the screen could be set as the current
     * false if there was no screen with the specfifed name
     */
    public boolean setAsCurrentScreen(String name){
        GameScreen currentGameScreen = gameScreens.get(name);
        if(currentGameScreen != null){
            this.currentGameScreen = currentGameScreen;
            return true;
        }else{
            return false;
        }
    }


    /**
     * Moving from one screen to the next screen we want to go to
     * @param currentScreen -  the screen we want to move away from
     * @param nextScreen - the screen we want to go to next
     */

    public void transitionScreens(GameScreen currentScreen, GameScreen nextScreen){
        removeScreen(currentScreen.getmName());
        addGameScreen(nextScreen);
    }


    /**
     * Returns the current game screen
     * @return - the current game screen , null if it coult not be found
     */
    public GameScreen getCurrentGameScreen(){
        return this.currentGameScreen;
    }

    /**
     * Returns the named screen specified
     * @param name - String name of the screen we want to return
     * @return - returns the name of the specified screen ,or null if
     * it couldnt be found
     */
    public GameScreen getScreen(String name){

        return this.gameScreens.get(name);
    }


    /**
     * Removes the specified screen
     * @param name- String name of the screen we want to remove
     * @return - screen we want to remove, null if it couldnt be found
     */
    public boolean removeScreen(String name){
        GameScreen gameScreen = gameScreens.remove(name);
        return (gameScreen != null);
    }


    /**
     * Dispose of the screen manager and all game screens stored within the manager
     */
    public void dispose(){
        for(GameScreen gameScreen : gameScreens.values())
            gameScreen.dispose();
    }





}
