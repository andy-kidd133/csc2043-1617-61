package com.example.andrew.ark9studios.gameInfrastructure;

import android.util.Log;

import com.example.andrew.ark9studios.Game;

/**
 * Created by Megan on 14/11/2016.
 * edited by Megan on 14/04/2017
 */

public class GameLoop implements Runnable {


    //Instance variables

    /**
     * Thread that the game loop will run
     */
    private Thread renderThread = null;

    /**
     * Boolean flag determining if the update and draw threads are running
     */
    private volatile boolean isRunning = false;

    /**
     * ElapsedTime info
     */
    private ElapsedTime elapsedTime;

    /**
     * Records the target number of update/draw iterations (in a one sec
     * interval).
     */
    private int targetFramesPerSecond=30;

    /**
     * Holds the duration of thre target game step period
     * changes to the targetFramesPerSecond will affect this variable
     */
    private long targetStepPeriod;

    /**
     * Instance of the Game class
     */
    private Game game;

    /**
     * The average number of frames per sec
     */
    private float averageFramesPerSecond;

    /**
     * Concurrent boolean lock that can be used to control update and draw
     * inter-thread sequencing.
     */
    class BooleanLock {
        boolean isLocked;

        public BooleanLock(boolean isLocked) {
            this.isLocked = isLocked;
        }
    }

    /**
     * Sequence locks for the update and draw steps
     */
    private volatile BooleanLock update;
    private volatile BooleanLock draw;


    /**
     * Constrcutor for game loop
     * @param game
     * @param targetFramesPerSecond
     */

    public GameLoop(Game game, int targetFramesPerSecond) {
      this.game = game;
        this.targetFramesPerSecond= targetFramesPerSecond;


        //calculating the targetStepPeriod
        setTargetStepPeriod(targetFramesPerSecond);

        //a new timing structure for the game
        this.elapsedTime = new ElapsedTime();

        //creating the update and draw locks
        this.update = new BooleanLock(false);
        this.draw = new BooleanLock(false);

    }



    //getters and setters


    /**
     * Returns the average number of frames per second that the game is achieving
     * @return- average number of frames per second
     */
    public float getAvgFramesPerSecond(){
        return  this.averageFramesPerSecond;
    }

    /**
     * Returns the target number of frames per second
     * @return- target number of frames per second
     */
    public int getTargetFramesPerSecond(){
        return this.targetFramesPerSecond;
    }

    /**
     * Sets the target frames per second
     * @param targetFramesPerSecond
     */
    public void setTargetFramesPerSecond(int targetFramesPerSecond){
        this.targetFramesPerSecond= targetFramesPerSecond;

        setTargetStepPeriod(targetFramesPerSecond);
    }


    /**
     * Calculates the targetStepPeriod for a given targetFramesPerSecond
     * @param targetFramesPerSecond
     */
    public void setTargetStepPeriod(int targetFramesPerSecond){
        this.targetStepPeriod = 1000000000 / targetFramesPerSecond;
    }





    @Override
    public void run() {

        // Ensure that we have a game screen available to update and render
     if (game.getScreenManager().getCurrentGameScreen() == null) {
            String errorTag = "QUIBTIG";
            String errorMessage = "You need to add a game screen to the screen manager, as there are currenrly no screens.";
            Log.e(errorTag, errorMessage);
            throw new RuntimeException(errorTag + errorMessage);
        }


        long startRun;
        long startStep, endStep;
        long sleepTime, overSleepTime, timeBeyondPeriod;


        startRun = System.nanoTime() - targetStepPeriod;
        startStep = startRun;
        overSleepTime = 0L;
        timeBeyondPeriod = 0;

        try {
            while (isRunning) {

                // Update the timing information
                long currentTime = System.nanoTime();
                elapsedTime.totalTime = (currentTime - startRun) / 1000000000.0;
                elapsedTime.stepTime = (currentTime - startStep) / 1000000000.0;
                startStep = currentTime;

                // Weighted average update of the average number of frames
                // per second
                averageFramesPerSecond = 0.85f * averageFramesPerSecond + 0.15f
                        * (1.0f / (float) elapsedTime.stepTime);

                // Trigger an update
                synchronized (update) {
                    update.isLocked = true;
                }
                game.update(elapsedTime);

                // Wait for the update to complete before progressing
                synchronized (update) {
                    if (update.isLocked) {
                        update.wait();
                    }
                }

                // Trigger a draw request
                synchronized (draw) {
                    draw.isLocked = true;
                }
                game.draw(elapsedTime);
                // Wait for the draw to complete before progressing
                // If a plan-update-draw approach was employed the
                // wait for the draw would be tested post plan completion.
                synchronized (draw) {
                    if (draw.isLocked) {
                        draw.wait();
                    }
                }

                // Measure how long the update/draw took to complete and
                // how long to sleep until the next cycle is due. This may
                // be a negative number (we've exceeded the 'available'
                // time).
                endStep = System.nanoTime();
                sleepTime = (targetStepPeriod - (endStep - startStep))
                        - overSleepTime;

                // If needed put the thread to sleep
                if (sleepTime > 0) {
                    Thread.sleep(sleepTime / 1000000L); // Covert ns into ms

                    // Determine how much longer we slept than was
                    // originally requested, we'll correct for this error
                    // next frame
                    overSleepTime = (System.nanoTime() - endStep) - sleepTime;
                } else {
                    // we are not keeping up with the target step period
                    // skip some draws and just update
                    timeBeyondPeriod = timeBeyondPeriod - sleepTime;
                    overSleepTime = 0L;
                    while (timeBeyondPeriod > targetStepPeriod) {
                        // get the elapsed time from the last update
                        currentTime = System.nanoTime();
                        elapsedTime.totalTime = (currentTime - startRun) / 1000000000.0;
                        elapsedTime.stepTime = (currentTime - startStep) / 1000000000.0;
                        startStep = currentTime;

                        // Trigger an update only to catch
                        // up, (i.e don't draw).
                        synchronized (update) {
                            update.isLocked = true;
                        }
                        game.update(elapsedTime);

                        // Wait for the update to complete before progressing
                        synchronized (update) {
                            if (update.isLocked) {
                                update.wait();
                            }
                        }
                        timeBeyondPeriod -= targetStepPeriod;
                    }
                }
            }

        } catch (InterruptedException e) {
            Log.e("Quibtig", Log.getStackTraceString(e));
        }
    }



    public void notifyIfDrawCompleted(){

        synchronized (draw){
            draw.isLocked=false;
            draw.notifyAll();
        }
    }


    public void notifyIfUpdateCompleted() {
        synchronized (update) {
            update.isLocked = false;
            update.notifyAll();
        }
    }

    /**
     *
     * This pause method is used to pause the game loop and can be called from the main
     * game fragment
     * it sets the isRunning to false and removes the other thread
     */
    public void pause() {
    isRunning= false;

        while (true) {
            try {
                renderThread.join(2000);
                return;
            } catch (InterruptedException e) {
                Log.e("Game Loop", "pauing the render thread failed");
            }
        }
    }

    /**
     * The resume method has to create a new instance of the thread because of the way we deal with pausing
     */
    public void resume() {
        isRunning = true;


        draw.isLocked=false;
        update.isLocked=false;

        renderThread = new Thread(this);
        renderThread.start();
    }

    public boolean isRunning() {
        return isRunning;
    }





}























