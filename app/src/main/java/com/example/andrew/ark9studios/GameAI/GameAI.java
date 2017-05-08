package com.example.andrew.ark9studios.GameAI;

import com.example.andrew.ark9studios.Screens.GameLevel;
import com.example.andrew.ark9studios.card.CharacterCard;
import com.example.andrew.ark9studios.gameLvlState;


import java.util.Random;

/**
 * Created by Megan on 03/05/2017.
 */

/**
 * Draft of AI code, would have been able to expand if we have a more developed game
 */

public class GameAI {


    /**
     * instance of the game level class
     */
    private GameLevel gameLevel;

    /**
     * Current game state
     */
    private gameLvlState gameLvlState;


    /**
     * the enemys health
     * temporary: should get health from the actual Enemys class
     * if i had time to create
     */
    private int enemyHealth;

    /**
     * boolean to check if it is the users
     */
    private boolean isUsersTurn;

    /**
     * instance of Random obj
     */
    Random rand = new Random();

    /**
     * random array - set of 10 possible values from 0 - 9
     * Used to make events random and the game turns less predictable
     */
    private int[] randArray = new int[10];

    /**
     * temp enemyDeck - I would have created an instance of the enemyDeck using the enemy class if we had time if the game was further developed:
     *
     */
    private int[] enemyDeck = new int[6];

    /**
     * Attack Damage Array - this array contains a range of possible basic attack values from 10 - 15
     * Used to make attack damages more random and less predictable so each turn is different
     *
     */
    private int[] attackArray = new int[6];

    /**
     * Critical Hit Damage Array - this array contains a range of possible critical hit damage values from 5 - 10
     * This makes critical hits more and less predictable - it means the enemy will not always strike the same critical hit
     *
     */
    private int[] attackCritical = new int[6];

    /**
     * Instance of Character Card - allows us to access Users health and evolve methods
     */
    private CharacterCard characterCard;


    //Constructor
    GameAI(){

        //setting the game state to running
        this.gameLvlState = gameLevel.getGameLvlState();



    }

    //Method for enemy turn
    public void enemyTurn() {

        //TEMP VARIABLES - REAL VARIABLES WOULD BE USED HERE - USED FOR TESTING
        boolean usedHealth = false;
        int enemyHealth = 100;
        enemyDeck = new int[]{1, 2, 3, 4, 5, 6,};
        int enemyCardLevel = 1;
        boolean usedRun = false;

        //CHECK IF GAME IS RUNNING
        if (gameLvlState == gameLvlState.Running) {

            //CHECK IF ITS THE ENEMYS TURN
            if (!isUsersTurn) {
                //CHECK THE ENEMY HEALTH - IF HEALTH IS BELOW 60 THEN THERE IS A CHANCE THE ENEMY CAN REGEN
                if (enemyHealth < 60) {
                    randArray = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
                    int selectedNum = rand.nextInt(randArray.length);

                    //30% CHANCE ENEMY CAN REGEN HEALTH - IF NUMBERS BELOW ARE SELECTED THEN ADD HEALTH
                    if (selectedNum == 3 || selectedNum == 7 || selectedNum == 9) {
                        if (usedHealth == false) {
                            //enemy.addHealth();
                        }
                    }else {
                        //IF ENEMY HELATH IS BELOW 30 THEN THEY HAVE A CHANCE TO REATREAT
                        if (enemyHealth < 30) {

                            int retreatNum = rand.nextInt(randArray.length);
                            //30% CHANCE ENEMY WILL RETREAT - IF NUMBER IS SELECTED THEN RETREAT
                            if (retreatNum == 3 || retreatNum == 7 || retreatNum == 9){
                                if(usedRun == false){
                                    //enemyCard.Retreat();
                                }

                    } else {

                        /**
                         * IF ENEMY DOESNT NEED TO REGEN HEALTH - CHECK IF THEY CAN LEVEL UP
                         * GO THROUGH EACH CARD AND CHECK LEVEL - IF CARD IS LEVEL 1 THERE S A RANDOM CHANCE IT CAN LEVEL UP
                         *
                         */

                        for (int i = 0; i < enemyDeck.length; i++) {
                            int cardID = enemyDeck[i];

                            //CHECK IF ENEMY HAS REACHED MAX ENERGIES ATTACHED
                            //if (enemyCard.getNumberEnergiesAttached() != 3) {
                                int cardLevel = enemyCardLevel;
                                if (cardLevel == 1) {
                                    int evolveNum = rand.nextInt(randArray.length);

                                    //30% CHANCE ENEMY WILL EVOLVE
                                    if (evolveNum == 3 || evolveNum == 7 || evolveNum == 9) {

                                        characterCard.cardEvolve();

                                    } else {

                                        enemyAttack();

                                    }
                                }
                            }
                        }
                    }


                }
                }
            }
        }
    }





                //ENEMY ATTACK AI
    public void enemyAttack(){

        //TEMP VARIABLES - TESTING - SHOULD BE REPLACED
        int enemyCardLevel = 1;

        //GET CARD LEVEL
        int cardLevel = enemyCardLevel; //enemyDeck.getLevel();

        //GET ATTACK DAMAGE
        int attackDmg; //enemyDeck.getAttackDamager();

        //GET USERS HEALTH
        int usersHealth = characterCard.getHealth();

        //SET UP RAND ARRAY
        randArray = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        if (cardLevel == 1){
        //CARD LEVEL 1 CAN DO BETWEEN 10-15 HP DAMAGE - PICKS RANDOM AMOUNT TO MAKE GAME LESS
        //PREDICTABLE
            attackArray = new int[]{10,11,12,13,14,15};
            attackDmg = rand.nextInt(attackArray.length);
        }else{
            //IF CARD IS NOT LEVEL 1 THEN IT IS LEVEL 25
            //LEVEL 2 CARDS CAN ATTACK BETWEEN 15 TO 20
            attackArray = new int[]{15,16,17,18,19,20};
            attackDmg = rand.nextInt(attackArray.length);
        }

        //CHANCE ENEMY CAN STRIKE A CRITCAL HIT - ADDS MORE DAMAGE TO CURRENT ATTACKDMG - RANGES FROM 5 TO 10 - MAKES GAME LESS PREDICTABLE
        int selectedCritical = rand.nextInt(randArray.length);
        //30% CHANCE CRITICAL HIT CAN HAPPEN
        if (selectedCritical == 3 || selectedCritical == 7 || selectedCritical == 9){
            attackCritical = new int[] {5,6,7,8,9,10};
            int selectedCAttack = rand.nextInt(attackCritical.length);
            attackDmg = attackDmg + selectedCAttack;
        }

        //ATTACK DMG WILL TAKE AWAY FROMS USERSHEALTH - MAX DAMAGE OF 25 HP POSSIBLE - FOR LEVEL 1 CARD
        usersHealth = usersHealth - attackDmg;


    }



    }




