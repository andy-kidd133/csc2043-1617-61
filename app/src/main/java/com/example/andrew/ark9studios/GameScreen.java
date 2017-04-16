package com.example.andrew.ark9studios;

import com.example.andrew.ark9studios.GameGraphics.Graphics2DInterface;
import com.example.andrew.ark9studios.gameInfrastructure.ElapsedTime;

/**
 * Created by Andrew on 08/02/2017.
 * code added by Megan 12/03/2017
 */

public abstract class GameScreen {


    //////////////////////////////////////////////////////////////////
    //Variables
    //////////////////////////////////////////////////////////////////


    protected final String name;
    protected final Game game;

    //////////////////////////////////////////////////////////////////
    //Getters
    //////////////////////////////////////////////////////////////////

    public String getmName() {
        return name;
    }

    public Game getmGame() {
        return game;
    }

    //constructor

    public GameScreen(String name, Game game) {
        this.name = name;
        this.game = game;
    }

    //////////////////////////////////////////////////////////////////
    //Update and Draw methods
    //////////////////////////////////////////////////////////////////


    /**
     * This method updates the game screen
     * @param elapsedTime- elapsed time info for the frame
     */
    public abstract void update(ElapsedTime elapsedTime);


    /**
     * This method draws the game screen
     * @param elapsedTime- elapsed time info for the frame
     * @param graphics2DInterface- graphics interface which is used to draw the game screen
     */
    public abstract void draw(ElapsedTime elapsedTime, Graphics2DInterface graphics2DInterface);


    public abstract void dispose();


    public abstract void pause();



    public abstract void resume();
}
