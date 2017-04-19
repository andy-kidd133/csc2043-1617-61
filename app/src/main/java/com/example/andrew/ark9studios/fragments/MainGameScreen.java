package com.example.andrew.ark9studios.fragments;

import com.example.andrew.ark9studios.AssetManager;
import com.example.andrew.ark9studios.Game;
import com.example.andrew.ark9studios.GameGraphics.Graphics2DInterface;
import com.example.andrew.ark9studios.GameScreen;
import com.example.andrew.ark9studios.gameInfrastructure.ElapsedTime;

/**
 * Created by megan on 15/04/2017.
 */

public class MainGameScreen extends GameScreen {

    public static final String SCREEN_NAME = "MainGameScreen";


   public MainGameScreen(Game game){
       super(SCREEN_NAME, game);

       AssetManager assetManager = game.getAssetManager();
       assetManager.emptyAssets();


   }




    @Override
    public void update(ElapsedTime elapsedTime) {

    }

    @Override
    public void draw(ElapsedTime elapsedTime, Graphics2DInterface graphics2DInterface) {

    }

    @Override
    public void dispose() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }
    //TODO: DRAW AND UPDATE THIS SCREEN
}
