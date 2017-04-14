package com.example.andrew.ark9studios.GameGraphics;

import android.view.View;

import com.example.andrew.ark9studios.gameInfrastructure.ElapsedTime;
import com.example.andrew.ark9studios.GameScreen;

/**
 * Created by Megan on 13/02/2017.
 * edited by Megan on 14/04/2017
 */


/**
 * Render interface which includes methods need by each game screen
 * the game screen will render using a 2d graphics instance supplied by this interface
 */
public interface RenderSurfaceInterface {

    /**
     * Render the specified game screen on this render surface
     * @param elapsedTime- the render requests timing info
     * @param gameScreenToRender-game screen to be rendered
     */
    public void render(ElapsedTime elapsedTime, GameScreen gameScreenToRender);

    /**
     * return the android view that is associated with this render surface
     * @return
     */
    public View getAsView();





}
