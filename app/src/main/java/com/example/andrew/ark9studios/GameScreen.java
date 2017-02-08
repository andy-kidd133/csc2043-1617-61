package com.example.andrew.ark9studios;

/**
 * Created by Andrew on 08/02/2017.
 */

public abstract class GameScreen {

    protected final string mName;
    protected final Game mGame;

    //getters

    public string getmName() {
        return mName;
    }

    public Game getmGame() {
        return mGame;
    }

    //constructor

    public GameScreen(String name, Game game) {
        mName = name;
        mGame = game;
    }

    //update and draw

    public abstract void update(ElapsedTime elapsedTime);

    public abstract void draw(ElapsedTime elapsedTime);

    public void pause() {}

    public void resume() {}

    public void dispose() {}
}
