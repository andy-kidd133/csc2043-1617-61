package com.example.andrew.ark9studios;

/**
 * Created by Andrew on 08/02/2017.
 */

public class GameLoop implements Runnable {

    //instance of game loop
    private GameLoop mLoop;

    //target FPS
    private int mTargetFramesPerSeconds = 5;

    //average FPS
    private float mAverageFramesPerSecond;

    //////////////////////////////////////////////////////////////////
    // Update and Draw methods
    //////////////////////////////////////////////////////////////////

    private void doUpdate(ElapsedTime elapsedTime) {
        //reset accumulators for key/touch events

        //get and update the current game screen

        notifyUpdateCompleted();
    }

    public void notifyUpdateCompleted() {
        mLoop.notifyUpdateCompleted();
    }

    private void doDraw(ElapsedTime elapsedTime) {

        //get and draw the current screen

        notifyDrawCompleted();
    }

    public void notifyDrawCompleted() {
        mLoop.notifyDrawCompleted();
    }

    /////////////////////////////////////////////////////////////////////
    // Properies
    /////////////////////////////////////////////////////////////////////

    // Concurrent lock that can be used to control update and draws inter-thread sequencing

    class BooleanLock {
        boolean isLocked;

        public BooleanLock(boolean isLocked) {
            this.isLocked = isLocked;
        }
    }

    //Sequence locks for update and draw steps

    volatile BooleanLock update;
    volatile BooleanLock draw;

    //thread on which the game loop will run

    Thread renderThread = null;

    ElapsedTime elapsedTime;

    long targetStepPeriod;

    //provides ceiling on the max step size that will be reported to game objects

    double maximumStepPeriodScale = 3.0f;

    /////////////////////////////////////////////////////////////////////
    // Constructor
    /////////////////////////////////////////////////////////////////////

    public GameLoop() {
        //setup the target step period
        targetStepPeriod = 1000000000 / mTargetFramesPerSeconds;
        //create a new time structure
        elapsedTime = new ElapsedTime();
        //create new update and draw locks
        update = new BooleanLock(false);
        draw = new BooleanLock(false);
    }


    ////////////////////////////////////////////////////////////////////////
    // Run method - update and draw loop
    ////////////////////////////////////////////////////////////////////////

    public void run() {

        //insert 'if' statement to ensure there is a game screen available

        long startRun;
        long startStep, endStep;
        long sleepTime, overSleepTime;

        startRun = System.nanoTime() - targetStepPeriod;
        startStep = startRun;
        overSleepTime = 0L;

        //insert try-catch???

        while (running){

            //update the timing info
            long currentTime = System.nanoTime();
            elapsedTime.totalTime = (currentTime - startRun) / 1000000000.0;
            elapsedTime.stepTime = (currentTime - startStep) / 1000000000.0;
            startStep = currentTime;

            //weighted average update of the average FPS
            mAverageFramesPerSecond = 0.85f * mAverageFramesPerSecond
                    + 0.15f * (1.0f / (float) elapsedTime.stepTime);

            //ensure the reported step time is not abnormally large
            if (elapsedTime.stepTime > (targetStepPeriod / 1000000000.0) * maximumStepPeriodScale)
                elapsedTime.stepTime = (targetStepPeriod / 1000000000.0) * maximumStepPeriodScale;

            //trigger an update
            synchronized (update) {
                update.isLocked = true;
            }
            doUpdate(elapsedTime);
            //wait for the update to complete before processing
            synchronized (update) {
                if (update.isLocked) {
                    update.wait();
                }
            }

            //trigger a draw request
            synchronized (draw) {
                draw.isLocked = true;
            }
            doDraw(elapsedTime);
            //wait for the draw to complete before processing
            synchronized (draw) {
                if (draw.isLocked) {
                    draw.wait();
                }
            }

            //measure how long the update/draw took to complete
            //calculate how long to sleep for

            endStep = System.nanoTime();
            sleepTime = (targetStepPeriod - (endStep - startRun))
                    - overSleepTime;

            //if needed put the thread to sleep
            if (sleepTime > 0) {
                Thread.sleep(sleepTime / 1000000L);     //convert ns to ms

                //determine over sleep time
                overSleepTime = (System.nanoTime() -endStep)
                        - sleepTime;
            } else {
                overSleepTime = 0L;
            }
        }


    }
}
