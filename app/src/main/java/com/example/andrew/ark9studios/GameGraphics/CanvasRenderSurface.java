package com.example.andrew.ark9studios.GameGraphics;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;

import com.example.andrew.ark9studios.gameInfrastructure.ElapsedTime;
import com.example.andrew.ark9studios.Game;
import com.example.andrew.ark9studios.GameScreen;

/**
 * Created by Megan on 13/04/2017.
 */

public class CanvasRenderSurface extends View implements RenderSurfaceInterface {


    //////////////////////////////////////////////////////////////////
    //Variables
    //////////////////////////////////////////////////////////////////

    private CanvasGraphics2D canvasGraphics2D;


    protected Game game;


    protected Context context;


    protected GameScreen gameScreenToRender;


    protected ElapsedTime elapsedTime;


    //////////////////////////////////////////////////////////////////
    //Constructor
    //////////////////////////////////////////////////////////////////

    /**
     * Creates a new canvas render surface specified by the game
     * @param game
     * @param context
     */

    public CanvasRenderSurface(Game game, Context context) {
        super(context);

        // Storing the game and context
        this.context = context;
        this.game = game;

        // Creating a bew canvas graphics 2D instance for drawing onto this render surface
        this.canvasGraphics2D = new CanvasGraphics2D();
    }


    /**
     * Render CanvasViewSurface
     * @param elapsedTime- the render requests timing info
     * @param gameScreenToRender-game screen to be rendered
     */

    @Override
    public void render(ElapsedTime elapsedTime, GameScreen gameScreenToRender) {

        // Store render target + time info
        this.elapsedTime = elapsedTime;
        this.gameScreenToRender = gameScreenToRender;

        // posts invalidate message to the user interface thread
        //the onDraw method is then called by this UI thread
        postInvalidate();
    }


    /**
     * returns the canvas render surface as a view obj
     * @return
     */

    @Override
    public View getAsView() {
        return this;
    }


    /**
     * CanvasRenderSurface on draw method
     * @param canvas
     */

    @Override
    protected void onDraw(Canvas canvas) {
        //the game renders itself to this screen
        //using a canvasGraphics2D instance
        canvasGraphics2D.setCanvas(canvas);
        gameScreenToRender.draw(elapsedTime, canvasGraphics2D);


        //it notifies the game that the render is completed
        game.notifyIfDrawCompleted();
    }
}
