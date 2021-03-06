package com.example.andrew.ark9studios.Screens;




import android.graphics.Bitmap;
import android.graphics.Rect;

import com.example.andrew.ark9studios.Game;
import com.example.andrew.ark9studios.AssetManager;
import com.example.andrew.ark9studios.GameGraphics.Animation;
import com.example.andrew.ark9studios.GameGraphics.Graphics2DInterface;
import com.example.andrew.ark9studios.GameInput.GameTouchEvent;
import com.example.andrew.ark9studios.GameInput.Input;
import com.example.andrew.ark9studios.Music.GameMusic;
import com.example.andrew.ark9studios.GameScreen;
import com.example.andrew.ark9studios.Music.Sound;
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
     *Draw Rect for the coin animation bitmap
     */
    private Rect cardSource, cardScreen, cardScreenTwo;



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
     *Animation for the coin
     */
    private Animation cardRotating;

    /**
     *coin bitmap
     */
    private Bitmap card;


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

    /**
     * Menu select sound to be played
     */
    private Sound menuSelect;




    //////////////////////////////////////
    ///////Constructor
    /////////////////////////////////////

    /**
     * Create a new MenuScreen
     * @param game - game menu screen belongs to
     */

    public MainMenuScreen(Game game){
          super(SCREEN_NAME, game);

        //getting the asset manager
        AssetManager assetManager = game.getAssetManager();

        //emptying the assets
        assetManager.emptyAssets();


        /**
         * try loading the bitmaps if, if there is an error print the stack trace
         */
        try {

            assetManager.loadAndAddBitmap("backgroundLayer", "images/qubbg.png");
            assetManager.loadAndAddBitmap("menuTemplate", "images/menuTemplate.png");
            assetManager.loadAndAddBitmap("playgamebutton", "images/button_play_game.png");
            assetManager.loadAndAddBitmap("optionsbutton", "images/option_button.png");
            assetManager.loadAndAddBitmap("rulesbutton", "images/button_rules.png");
            assetManager.loadAndAddBitmap("scoreboardbutton", "images/button_scoreboard.png");
            assetManager.loadAndAddBitmap("quitbutton", "images/button_quit.png");
            assetManager.loadAndAddMusic("backgroundMusic", "raw/backgroundmusic.mp3");
            assetManager.loadAndAddSound("menuSelect", "sfx/menuclick.mp3");
            assetManager.loadAndAddBitmap("cardAnimation", "images/cardanimation.png");
        }catch(Exception e){
            e.printStackTrace();
        }


        //initialising the variables
        this.playGameBitmap = assetManager.getBitmap("playgamebutton");
        this.backgroundBitmap = assetManager.getBitmap("backgroundLayer");
        this.menuTemplateBitmap = assetManager.getBitmap("menuTemplate");
        this.optionsBitmap = assetManager.getBitmap("optionsbutton");
        this.rulesBitmap  = assetManager.getBitmap("rulesbutton");
        this.scoreBoardBitmap = assetManager.getBitmap("scoreboardbutton");
        this.quitBitmap = assetManager.getBitmap("quitbutton");
        this.backgroundMusic = assetManager.getMusic("backgroundMusic");
        this.menuSelect = assetManager.getSound("menuSelect");
        this.card = assetManager.getBitmap("cardAnimation");


        //loading the card animation
        cardRotating = new Animation(card, 12);
        cardRotating.play(1.9, true);


        //Draw Rects for the cardanimations
        cardSource = new Rect();
        cardScreen = new Rect(1010, 100 , 1130, 200);
        cardScreenTwo = new Rect(170, 100, 290, 200);

            //setting the music to play
            backgroundMusic.play();



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

        //////////////////////////////////////
        ///process touches on the screen
        /////////////////////////////////////


        Input input = game.getInput();

        List<GameTouchEvent> touchEvents = input.getTouchEvents();

        //updating the card animation
        cardRotating.update(elapsedTime.stepTime);
        cardRotating.getSourceRect(cardSource);

        if (touchEvents.size() > 0) {

            /**
            * check the first touch event.
            */
            GameTouchEvent touchEvent = touchEvents.get(0);

            /**
             * the touchEvent.typeOfTouchEvent allows us to decide what type of touch we want on the if statement;
             * up, down , dragged
             */

            if (playGameButtonBound.contains((int) touchEvent.x, (int) touchEvent.y)&& touchEvent.typeOfTouchEvent == GameTouchEvent.TOUCH_DOWN) {


                //play menu select
                menuSelect.play();
                //music paused
                backgroundMusic.pause();

                //if the play game area has been touched then swap to the GameLevelOne screen
                game.getScreenManager().removeScreen(this.getmName());
               GameLevelOne  gameLevelOne = new GameLevelOne(this.getmGame());

                //as this is the only added screen then it will become active
                game.getScreenManager().addGameScreen(gameLevelOne);


            }
            if (optionsButtonBound.contains((int) touchEvent.x, (int) touchEvent.y)&& touchEvent.typeOfTouchEvent == GameTouchEvent.TOUCH_UP) {


                //play menu select
                menuSelect.play();

                //pause the music
                backgroundMusic.pause();


                //if the options area has been touched then swap to the Options  screen
                game.getScreenManager().removeScreen(this.getmName());
                OptionsScreen optionsScreen = new OptionsScreen(this.getmGame());

                //as this is the only added screen then it will become active
                game.getScreenManager().addGameScreen(optionsScreen);

            }

            if (rulesButtonBound.contains((int) touchEvent.x, (int) touchEvent.y)&& touchEvent.typeOfTouchEvent == GameTouchEvent.TOUCH_DOWN) {

                //play menu select
                menuSelect.play();

                //if the rules area has been touched then swap to the Rules screen
                game.getScreenManager().removeScreen(this.getmName());
                RulesScreen rulesScreen = new RulesScreen(this.getmGame());

                //as this is the only added screen then it will become active
                game.getScreenManager().addGameScreen(rulesScreen);



            }

            if (scoreboardButtonBound.contains((int) touchEvent.x, (int) touchEvent.y)&& touchEvent.typeOfTouchEvent == GameTouchEvent.TOUCH_UP) {

                //play menu select
                menuSelect.play();

                //if the scoreboard area has been touched then swap to the scoreboard screen
                game.getScreenManager().removeScreen(this.getmName());
                ScoreBoardScreen scoreBoardScreen = new ScoreBoardScreen(this.getmGame());


                //as this is the only added screen then it will become active
                game.getScreenManager().addGameScreen(scoreBoardScreen);


            }

            if (quitButtonBound.contains((int) touchEvent.x, (int) touchEvent.y)&& touchEvent.typeOfTouchEvent == GameTouchEvent.TOUCH_DOWN) {

                //play menu select
                menuSelect.play();

                //if the quit area has been touched then swap to the quit screen
                game.getScreenManager().removeScreen(this.getmName());
                QuitScreen quitScreen = new QuitScreen(this.getmGame());

                //as this is the only added screen then it will become active
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


        //the space between each menu button
        int verticalSpacer = 190;

        /**
         * used to position the menu image from the top of the screen
         */
        int menuTop = 140;

        /**
         * used to position the menu image from the left of the screen
         */
        int menuLeft = 120;

        /**
         * used to position the buttons from the left of the screen
         */
        int buttonLeft = 375;

        /**
         * used to position where the play button will be from the top of
         * the screen
         */
        int playTop = 340;

        /**
         * used to position where the options button will be from the top of
         * the screen
         */
        int optionTop = playTop + verticalSpacer;
        /**
         * used to position where the rules button will be from the top of
         * the screen
         */
        int rulesTop = optionTop + verticalSpacer;

        /**
         * used to position where the scoreboard button will be from the top of
         * the screen
         */
        int scoreboardTop = rulesTop + verticalSpacer;

        /**
         * used to position where the quit button will be from the top of
         * the screen
         */
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





            //drawing the bitmaps out
            graphics2DInterface.drawBitmap(backgroundBitmap, null, backgroundBound, null);
            graphics2DInterface.drawBitmap(menuTemplateBitmap, null, menuTemplateBound, null);
            graphics2DInterface.drawBitmap(playGameBitmap, null, playGameButtonBound, null);
            graphics2DInterface.drawBitmap(optionsBitmap, null, optionsButtonBound, null);
            graphics2DInterface.drawBitmap(rulesBitmap, null, rulesButtonBound, null);
            graphics2DInterface.drawBitmap(scoreBoardBitmap, null, scoreboardButtonBound, null);
            graphics2DInterface.drawBitmap(quitBitmap, null, quitButtonBound, null);
            graphics2DInterface.drawBitmap(card, cardSource, cardScreen, null);
            graphics2DInterface.drawBitmap(card, cardSource, cardScreenTwo, null);


    }


    /**
     * return the game music
     * @return
     */

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
