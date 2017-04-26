package com.example.andrew.ark9studios;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.provider.Settings;

import com.example.andrew.ark9studios.GameGraphics.Graphics2DInterface;
import com.example.andrew.ark9studios.Screens.GameLevel;
import com.example.andrew.ark9studios.Screens.MainMenuScreen;
import com.example.andrew.ark9studios.gameInfrastructure.ElapsedTime;

/**
 * Created by Megan on 26/04/2017.
 */

public class GameLevelOne extends GameLevel {







    public GameLevelOne(Game game) {
        super("Game Level One", game, 800.0f, 4000.0f);

        setUpLevel();


    }


    @Override
    public void setUpLevel() {

        loadLevelAssets();
        super.setUpLevel();
    }


    @Override
    public void update(ElapsedTime elapsedTime) {
        super.update(elapsedTime);
    }


    @Override
    public void draw(ElapsedTime elapsedTime, Graphics2DInterface graphics2DInterface) {
        super.draw(elapsedTime, graphics2DInterface);



    }

    public void loadLevelAssets() {
        super.loadLevelAssets();


    }


    @Override
    public void exitLevel() {

        System.exit(1);
    }


    @Override
    public void backToMenu() {


        game.getScreenManager().removeScreen(this.getmName());
        MainMenuScreen mainMenuScreen = new MainMenuScreen(this.getmGame());
        game.getScreenManager().addGameScreen(mainMenuScreen);

    }
}
