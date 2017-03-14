package com.example.andrew.ark9studios;

import android.util.Log;

/**
 * Created by Megan on 14/11/2016.
 */

public abstract class GameLoop implements Runnable {


    //Instance variables

    private int targetFramesPerSecond;
    private Thread renderThread = null;
    private volatile boolean isRunning = false;
    private long targetUpdatePeriod;


    /**
     * This is the constructor for the game loop
     *
     * @param targetFPS this is the frames per second that we want our app to run at
     */

    public GameLoop(int targetFPS) {
        targetFramesPerSecond = targetFPS;
        targetUpdatePeriod = 1000000000 / targetFramesPerSecond;
        run();
    }


    @Override
    public void run() {
        long startTime, endTime;
        long sleepTime, overSleepTime;
        long timeBeyondPeriod;


        startTime = System.nanoTime() - targetUpdatePeriod;

        overSleepTime = 0;
        timeBeyondPeriod = 0;


        //the main loop that deals with FPS
        try {
            while (isRunning) {
                startTime = System.nanoTime();

                doUpdate();
                doDraw();

                endTime = System.nanoTime();
                sleepTime = (targetUpdatePeriod - (startTime - endTime)) - overSleepTime;


                if (sleepTime > 0) {
                    Thread.sleep(sleepTime / 10000000L);

                    overSleepTime = (System.nanoTime() - endTime) - sleepTime;
                } else {

                    timeBeyondPeriod = timeBeyondPeriod - sleepTime;
                    overSleepTime = 0;

                    while (timeBeyondPeriod > targetUpdatePeriod) {
                        //doUpdate();
                        timeBeyondPeriod = -targetUpdatePeriod;
                    }
                }
            }
        } catch (InterruptedException e) {
            Log.w("Loop", "Interrupt has occured");
        }
    }




    /**
     * This is the abstract draw method which will get overridden in the main game fragment
     */
    public abstract void doDraw();

    /**
     * This is the abstract update method which will get overridden in the main game fragment
     */
    public abstract void doUpdate();

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
                renderThread.join();
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

        renderThread = new Thread(this);
        renderThread.start();
    }

    public boolean isRunning() {
        return isRunning;
    }





}























