package com.example.andrew.ark9studios.Screens;



import android.graphics.Bitmap;
import android.graphics.Rect;

import com.example.andrew.ark9studios.AssetManager;
import com.example.andrew.ark9studios.Game;
import com.example.andrew.ark9studios.GameGraphics.Graphics2DInterface;
import com.example.andrew.ark9studios.GameInput.GameTouchEvent;
import com.example.andrew.ark9studios.GameInput.Input;
import com.example.andrew.ark9studios.GameScreen;
import com.example.andrew.ark9studios.gameInfrastructure.ElapsedTime;

import java.util.List;


/**
 * Created by megan on 02/03/2017.
 */

public class QuitScreen extends GameScreen{

    /**
     * Draw Rect for the background bitmap
     */
    private Rect backgroundBound;

    /**
     * Draw Rect for the quit menu bitmap
     */
    private Rect quitMenuBound;

    /**
     * Draw Rect for the yes button bitmap
     */
    private Rect yesButtonBound;

    /**
     * Draw Rect for the no button bitmap
     */
    private Rect noButtonBound;

    /**
     * background bitmap
     */
    private Bitmap backgroundBitmap;
    /**
     * quit menu bitmap
     */
    private Bitmap quitMenuBitmap;

    /**
     * yes button bitmap
     */
    private Bitmap yesBitmap;

    /**
     * no button bitmap
     */
    private Bitmap noBitmap;

    /**
     * name of screen
     */
    private static final String SCREEN_NAME="QuitScreen";


    /**
     * width of button
     */
    private static final int BUTTON_WIDTH = 500;
    /**
     * height of button
     */
    private static final int BUTTON_HEIGHT = 180;
    /**
     * width of mwnu template
     */
    private static final int MENU_TEMPLATE_WIDTH =1100;
    /**
     * height of menu template
     */
    private static final int MENU_TEMPLATE_HEIGHT = 1400;


    /**
     * create a new quit screen
     * @param game- quit screen belongs to
     */
    public QuitScreen(Game game){
        super(SCREEN_NAME, game);

        AssetManager assetManager = game.getAssetManager();
        assetManager.emptyAssets();
        assetManager.loadAndAddBitmap("backgroundLayer", "images/qubbg.png");
        assetManager.loadAndAddBitmap("quitmenu", "images/quit_menu.png");
        assetManager.loadAndAddBitmap("yesbutton", "images/yes_button.png");
       assetManager.loadAndAddBitmap("nobutton", "images/no_button.png");



        this.backgroundBitmap = assetManager.getBitmap("backgroundLayer");
        this.quitMenuBitmap = assetManager.getBitmap("quitmenu");
        this.yesBitmap = assetManager.getBitmap("yesbutton");
        this.noBitmap = assetManager.getBitmap("nobutton");

    }


    /**
     * quit screen update
     * @param elapsedTime- elapsed time info for the frame
     */
    @Override
    public void update(ElapsedTime elapsedTime) {

     Input input = game.getInput();

        List<GameTouchEvent> touchEvents = input.getTouchEvents();

        if(touchEvents.size() > 0){
                GameTouchEvent touchEvent = touchEvents.get(0);

                if(yesButtonBound.contains((int) touchEvent.x, (int) touchEvent.y)){

                    System.exit(0);

                }

                if (noButtonBound.contains((int) touchEvent.x, (int) touchEvent.y)&& touchEvent.typeOfTouchEvent == GameTouchEvent.TOUCH_DOWN){

                    game.getScreenManager().removeScreen(this.getmName());

                    MainMenuScreen mainScreen = new MainMenuScreen(this.getmGame());
                    game.getScreenManager().addGameScreen(mainScreen);

                }

            }

        }


    /**
     * quit screen draw
     * @param elapsedTime- elapsed time info for the frame
     * @param graphics2DInterface- graphics interface which is used to draw the game screen
     */
    @Override
    public void draw(ElapsedTime elapsedTime, Graphics2DInterface graphics2DInterface) {


        int quitMenuTop=140;
        int quitMenuLeft = 120;
        int verticalSpacer=190;
        int buttonLeft =375;
        int yesButtonTop = 500;
        int noButtonTop = yesButtonTop + verticalSpacer;



        if(backgroundBound == null){
            backgroundBound = new Rect(0, 0, graphics2DInterface.getSurfaceWidth(),
                    graphics2DInterface.getSurfaceHeight());
        }

        if(quitMenuBound == null){
            quitMenuBound = new Rect(quitMenuLeft, quitMenuTop , MENU_TEMPLATE_WIDTH,
                    MENU_TEMPLATE_HEIGHT);
        }

        if(yesButtonBound==null){
            yesButtonBound = new Rect(buttonLeft, yesButtonTop, buttonLeft+BUTTON_WIDTH,
                    yesButtonTop + BUTTON_HEIGHT);
        }

        if(noButtonBound==null){
            noButtonBound = new Rect(buttonLeft, noButtonTop, buttonLeft+BUTTON_WIDTH,
                    noButtonTop + BUTTON_HEIGHT);
        }




        graphics2DInterface.drawBitmap(backgroundBitmap, null, backgroundBound, null);
        graphics2DInterface.drawBitmap(quitMenuBitmap, null, quitMenuBound, null);
        graphics2DInterface.drawBitmap(yesBitmap, null, yesButtonBound, null);
       graphics2DInterface.drawBitmap(noBitmap, null, noButtonBound, null);


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
}
