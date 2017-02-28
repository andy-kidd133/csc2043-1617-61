package com.example.andrew.ark9studios;

import android.app.Fragment;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.andrew.ark9studios.CoreServices.ScreenManager;

/**
 * Created by Andrew on 08/02/2017.
 */

public abstract class Game extends Fragment {

   /* //core game services
    protected AssetStore mAssetManager;
    protected ScreenManager mScreenManager;
    protected ScriptGroup.Input mInput;
    protected FileIO mFileIO;
    protected RenderSurface mRenderSurface;

    private GameLoop mLoop;
    private int mScreenWidth = -1;
    private int mScreenHeight = -1;

    //getters
    public ScriptGroup.Input getInput() {
        return mInput;
    }

    public FileIO getFileIO() {
        return mFileIO;
    }

    public int getScreenWidth() {
        return mScreenWidth;
    }

    public int getScreenHeight() {
        return mScreenHeight;
    }

    public AssetStore getAssetManager() {

        return mAssetManager;
    }

    public ScreenManager getScreenManager() {
        return mScreenManager;
    }

    @Override
    public void onCreate(Bundle savedInstaceState) {
        super.onCreate(savedInstaceState);

        //create instance of game loop

        //create instances of the core game services
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        //create output view and associated renderer

        //get our input from the created view

        //store the size of the window we're using


        return ;
    }

    @Override
    public void onResume() {
        super.onResume();

        //if needed, resume the loop
    }

    @Override
    public void onPause(){
        super.onPause();

        //if needed pause the current screen
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        //dispose of any game screens
    }

    //////////////////////////////////////////////////////////////////
    // Update and Draw methods
    //////////////////////////////////////////////////////////////////

    public void doUpdate(ElapsedTime elapsedTime) {
        //reset accumulators for key/touch events

        //get and update the current game screen

        notifyUpdateCompleted();
    }

    public void notifyUpdateCompleted() {
        mLoop.notifyUpdateCompleted();
    }



    public void doDraw(ElapsedTime elapsedTime) {

        //get and draw the current screen

        notifyDrawCompleted();
    }

    public void notifyDrawCompleted() {
        mLoop.notifyDrawCompleted();
    }

*/
}
