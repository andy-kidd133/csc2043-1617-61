package com.example.andrew.ark9studios.Screens;

import com.example.andrew.ark9studios.BoardLocation;
import com.example.andrew.ark9studios.BoardSetupHelper;
import com.example.andrew.ark9studios.Game;
import com.example.andrew.ark9studios.GameGraphics.Graphics2DInterface;
import com.example.andrew.ark9studios.GameInput.GameTouchEvent;
import com.example.andrew.ark9studios.GameInput.Input;
import com.example.andrew.ark9studios.GameScreen;
import com.example.andrew.ark9studios.gameInfrastructure.ElapsedTime;
import com.example.andrew.ark9studios.utils.DeckSetup;

import java.util.List;




/**
 * Created by Andrew and Karl on 18/04/2017.
 */
//Test push for "Checkout as new local branch"
public class MainGameScreen extends GameScreen {

    public static final String SCREEN_NAME = "MainGameScreen";

    private BoardSetupHelper boardSetupHelper;
    private BoardLocation boardLocation;
    private DeckSetup deckSetup;

    public MainGameScreen(Game game){
        super(SCREEN_NAME, game);

        boardSetupHelper = new BoardSetupHelper(game);
        boardLocation = new BoardLocation();
        deckSetup = new DeckSetup(game);

    }

    @Override
    public void update(ElapsedTime elapsedTime) {
        Input input = game.getInput();
        List<GameTouchEvent> touchEvents = input.getTouchEvents();


    }

    @Override
    public void draw(ElapsedTime elapsedTime, Graphics2DInterface graphics2DInterface) {

        //deckSetup.initialGamePlay(graphics2DInterface, game);

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

