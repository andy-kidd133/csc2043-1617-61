package com.example.andrew.ark9studios.Screens;




import android.graphics.Bitmap;
import android.graphics.Rect;

import com.example.andrew.ark9studios.Game;
import com.example.andrew.ark9studios.AssetManager;
import com.example.andrew.ark9studios.GameGraphics.Graphics2DInterface;
import com.example.andrew.ark9studios.GameInput.GameTouchEvent;
import com.example.andrew.ark9studios.GameInput.Input;
import com.example.andrew.ark9studios.GameLevelOne;
import com.example.andrew.ark9studios.Music.GameMusic;
import com.example.andrew.ark9studios.GameScreen;
import com.example.andrew.ark9studios.gameInfrastructure.ElapsedTime;

import java.util.List;

/**
 * Created by Megan on 23/02/2017.
 */

/**
 * This is the main menu screen and it will provide the user with 5 options: play game, options, rules, scoreboard and
 * quit
 */
public class MainMenuScreen extends GameScreen {

    //////////////////////////////////////
    ///////Variables
    /////////////////////////////////////

    /**
     * Draw Rect for the background bitmap
     */
    private Rect backgroundBound;

    /**
     * Draw Rect for the menu bitmap
     */
    private Rect menuTemplateBound;

    /**
     * Draw Rect for the play game button bitmap
     */
    private Rect playGameButtonBound;

    /**
     * Draw Rect for the options button bitmap
     */
    private Rect optionsButtonBound;

    /**
     * Draw Rect for the rules button bitmap
     */
    private Rect rulesButtonBound;

    /**
     * Draw Rect for the score board button bitmap
     */
    private Rect scoreboardButtonBound;

    /**
     * Draw Rect for the quit button bitmap
     */
    private Rect quitButtonBound;



    /**
     * Background bitmap
     */
    private Bitmap backgroundBitmap;

    /**
     * menu bitmap
     */
    private Bitmap menuTemplateBitmap;

    /**
     * play game bitmap
     */
    private Bitmap playGameBitmap;

    /**
     * options button bitmap
     */
    private Bitmap optionsBitmap;

    /**
     * rules button bitmap
     */
    private Bitmap rulesBitmap;

    /**
     * score board button bitmap
     */
    private Bitmap scoreBoardBitmap;

    /**
     * quit button bitmap
     */
    private Bitmap quitBitmap;


    /**
     * Menu screen name
     */
   private static final String SCREEN_NAME="MainMenuScreen";


    /**
     * button width
     */
    private static final int BUTTON_WIDTH = 500;

    /**
     * button height
     */
   private static final int BUTTON_HEIGHT = 180;

    /**
     * menu width
     */
    private static final int MENU_TEMPLATE_WIDTH =1100;

    /**
     * menu height
     */
    private static final int MENU_TEMPLATE_HEIGHT = 1400;


    /**
     * The background music that is to be played
     */
    private GameMusic backgroundMusic;



    //////////////////////////////////////
    ///////Constructor
    /////////////////////////////////////

    /**
     * Create a new MenuScreen
     * @param game - game menu screen belongs to
     */

    public MainMenuScreen(Game game){
          super(SCREEN_NAME, game);

        AssetManager assetManager = game.getAssetManager();


        assetManager.emptyAssets();


        assetManager.loadAndAddBitmap("backgroundLayer", "images/qubbg.png");
        assetManager.loadAndAddBitmap("menuTemplate", "images/menuTemplate.png");
        assetManager.loadAndAddBitmap("playgamebutton", "images/button_play_game.png");
        assetManager.loadAndAddBitmap("optionsbutton", "images/option_button.png");
        assetManager.loadAndAddBitmap("rulesbutton", "images/button_rules.png");
        assetManager.loadAndAddBitmap("scoreboardbutton", "images/button_scoreboard.png");
        assetManager.loadAndAddBitmap("quitbutton", "images/button_quit.png");
        assetManager.loadAndAddMusic("backgroundMusic", "raw/backgroundmusic.mp3");




        this.playGameBitmap = assetManager.getBitmap("playgamebutton");
        this.backgroundBitmap = assetManager.getBitmap("backgroundLayer");
        this.menuTemplateBitmap = assetManager.getBitmap("menuTemplate");
        this.optionsBitmap = assetManager.getBitmap("optionsbutton");
        this.rulesBitmap  = assetManager.getBitmap("rulesbutton");
        this.scoreBoardBitmap = assetManager.getBitmap("scoreboardbutton");
        this.quitBitmap = assetManager.getBitmap("quitbutton");
        this.backgroundMusic = assetManager.getMusic("backgroundMusic");



            backgroundMusic.play();
            backgroundMusic.setLooping(true);

    }



    //////////////////////////////////////
    ///////Methods
    /////////////////////////////////////


    /**
     * Main Menu update
     * @param elapsedTime- elapsed time info for the frame
     */

    @Override
    public void update(ElapsedTime elapsedTime) {

        Input input = game.getInput();

        List<GameTouchEvent> touchEvents = input.getTouchEvents();

        if (touchEvents.size() > 0) {
            GameTouchEvent touchEvent = touchEvents.get(0);

            if (playGameButtonBound.contains((int) touchEvent.x, (int) touchEvent.y)&& touchEvent.typeOfTouchEvent == GameTouchEvent.TOUCH_DOWN) {

                game.getScreenManager().removeScreen(this.getmName());
               GameLevelOne  gameLevelOne = new GameLevelOne(this.getmGame());
                game.getScreenManager().addGameScreen(gameLevelOne);

                backgroundMusic.stop();



            }
            if (optionsButtonBound.contains((int) touchEvent.x, (int) touchEvent.y)&& touchEvent.typeOfTouchEvent == GameTouchEvent.TOUCH_UP) {

                game.getScreenManager().removeScreen(this.getmName());
                OptionsScreen optionsScreen = new OptionsScreen(this.getmGame());
                game.getScreenManager().addGameScreen(optionsScreen);

                backgroundMusic.stop();
                backgroundMusic.setLooping(false);

            }

            if (rulesButtonBound.contains((int) touchEvent.x, (int) touchEvent.y)&& touchEvent.typeOfTouchEvent == GameTouchEvent.TOUCH_DOWN) {
                game.getScreenManager().removeScreen(this.getmName());

                RulesScreen rulesScreen = new RulesScreen(this.getmGame());
                game.getScreenManager().addGameScreen(rulesScreen);

            }

            if (scoreboardButtonBound.contains((int) touchEvent.x, (int) touchEvent.y)&& touchEvent.typeOfTouchEvent == GameTouchEvent.TOUCH_UP) {
                game.getScreenManager().removeScreen(this.getmName());

                ScoreBoardScreen scoreBoardScreen = new ScoreBoardScreen(this.getmGame());
                game.getScreenManager().addGameScreen(scoreBoardScreen);


            }

            if (quitButtonBound.contains((int) touchEvent.x, (int) touchEvent.y)&& touchEvent.typeOfTouchEvent == GameTouchEvent.TOUCH_DOWN) {
                game.getScreenManager().removeScreen(this.getmName());

                QuitScreen quitScreen = new QuitScreen(this.getmGame());
                game.getScreenManager().addGameScreen(quitScreen);


            }




        }

    }


    /**
     * Main Menu draw method
     * @param elapsedTime- elapsed time info for the frame
     * @param graphics2DInterface- graphics interface which is used to draw the game screen
     */
    @Override
    public void draw(ElapsedTime elapsedTime, Graphics2DInterface graphics2DInterface) {


        int verticalSpacer = 190;
        int menuTop = 140;
        int menuLeft = 120;

        int buttonLeft = 375;
        int playTop = 340;
        int optionTop = playTop + verticalSpacer;
        int rulesTop = optionTop + verticalSpacer;
        int scoreboardTop = rulesTop + verticalSpacer;
        int quitTop = scoreboardTop + verticalSpacer;




        if (playGameButtonBound == null) {
            playGameButtonBound = new Rect(buttonLeft, playTop, buttonLeft + BUTTON_WIDTH,
                    playTop + BUTTON_HEIGHT);
        }

        if (optionsButtonBound == null) {
            optionsButtonBound = new Rect(buttonLeft, optionTop, buttonLeft + BUTTON_WIDTH,
                    optionTop + BUTTON_HEIGHT);
        }

        if (rulesButtonBound == null) {
            rulesButtonBound = new Rect(buttonLeft, rulesTop, buttonLeft + BUTTON_WIDTH,
                    rulesTop + BUTTON_HEIGHT);
        }

        if (scoreboardButtonBound == null) {
            scoreboardButtonBound = new Rect(buttonLeft, scoreboardTop, buttonLeft + BUTTON_WIDTH,
                    scoreboardTop + BUTTON_HEIGHT);
        }

        if (quitButtonBound == null) {
            quitButtonBound = new Rect(buttonLeft, quitTop, buttonLeft + BUTTON_WIDTH,
                    quitTop + BUTTON_HEIGHT);
        }


        if (backgroundBound == null) {
            backgroundBound = new Rect(0, 0, graphics2DInterface.getSurfaceWidth(),
                    graphics2DInterface.getSurfaceHeight());
        }


        if (menuTemplateBound == null) {
            menuTemplateBound = new Rect(menuLeft, menuTop, MENU_TEMPLATE_WIDTH,
                    MENU_TEMPLATE_HEIGHT);
        }





            graphics2DInterface.drawBitmap(backgroundBitmap, null, backgroundBound, null);
            graphics2DInterface.drawBitmap(menuTemplateBitmap, null, menuTemplateBound, null);
            graphics2DInterface.drawBitmap(playGameBitmap, null, playGameButtonBound, null);
            graphics2DInterface.drawBitmap(optionsBitmap, null, optionsButtonBound, null);
            graphics2DInterface.drawBitmap(rulesBitmap, null, rulesButtonBound, null);
            graphics2DInterface.drawBitmap(scoreBoardBitmap, null, scoreboardButtonBound, null);
            graphics2DInterface.drawBitmap(quitBitmap, null, quitButtonBound, null);



    }



    public GameMusic getBackgroundMusic(){
        return backgroundMusic;
    }

    /**
     * Menu dispose
     */
    @Override
    public void dispose() {
    backgroundMusic.dispose();
    }


    /**
     * Menu pause
     */
    @Override
    public void pause() {
        backgroundMusic.pause();

    }


    /**
     * Menu resume
     */
    @Override
    public void resume() {

        backgroundMusic.play();
    }


}
