package com.example.andrew.ark9studios;


import android.content.Intent;

import com.example.andrew.ark9studios.GameGraphics.Graphics2DInterface;
import com.example.andrew.ark9studios.Screens.GameLevel;
import com.example.andrew.ark9studios.Screens.MainMenuScreen;
import com.example.andrew.ark9studios.gameInfrastructure.ElapsedTime;
import com.example.andrew.ark9studios.utils.DeckSetup;

/**
 * Created by Megan on 20/04/2017.
 */


/**
 * First level in the game
 */
public class GameLevelOne extends GameLevel {

    private DeckSetup deckSetup;


    /**
     * create a new game level one
     * @param game - level the game belongs to
     */

    public GameLevelOne(Game game) {
        super("Game Level One", game, 800.0f, 4000.0f);

        deckSetup = new DeckSetup(game);

        setUpLevel();
    }

    /**
     * set up game level one
     */
    @Override
    public void setUpLevel() {

        //load in assets used in this game
        loadLevelAssets();
        super.setUpLevel();
    }


    /**
     * update level one
     * @param elapsedTime- elapsed time info for the frame
     */
    @Override
    public void update(ElapsedTime elapsedTime) {
        super.update(elapsedTime);
    }


    /**
     * draw level one
     * @param elapsedTime- elapsed time info for the frame
     * @param graphics2DInterface- graphics interface which is used to draw the game screen
     */

    @Override
    public void draw(ElapsedTime elapsedTime, Graphics2DInterface graphics2DInterface) {
        super.draw(elapsedTime, graphics2DInterface);

        deckSetup.initialGamePlay(graphics2DInterface, game);

    }



    public void loadLevelAssets() {
        super.loadLevelAssets();

    }


    @Override
    public void backToMenu() {

        super.backToMenu();

        game.getScreenManager().removeScreen(this.getmName());
        MainMenuScreen mainMenuScreen = new MainMenuScreen(this.getmGame());
        game.getScreenManager().addGameScreen(mainMenuScreen);

    }
}
