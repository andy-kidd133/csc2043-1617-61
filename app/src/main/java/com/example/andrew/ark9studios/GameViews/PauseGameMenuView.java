package com.example.andrew.ark9studios.GameViews;

/*
import android.app.Activity;
import android.app.Dialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import com.example.andrew.ark9studios.R;
import com.example.andrew.ark9studios.activities.MainActivity;
import com.example.andrew.ark9studios.fragments.GameFragment;
import com.example.andrew.ark9studios.fragments.MainMenuScreen;
*/


/**
 * Created by Megan on 28/03/2017.
 */

/*public class PauseGameMenuView extends Dialog  implements  android.view.View.OnClickListener  {

    public Activity activity;
    public Fragment nextFragment;
    public ImageView resumeButton, mainMenuButton, pauseQuitButton;
    private MainActivity mainActivity;


    public PauseGameMenuView(Activity activity, Fragment fragment) {
        super(activity);
        this.activity = activity;
        this.nextFragment = fragment;

    }


    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);

        //setting the window up for the pause menu

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.pause_menu);



        //setting the button images to the imageview variables using the id
        resumeButton = (ImageView) findViewById(R.id.resume_button);
        mainMenuButton = (ImageView) findViewById(R.id.menupause_button);
        pauseQuitButton = (ImageView) findViewById(R.id.quit_button);

        //setting on click listeners for each of the pause menu buttons
        resumeButton.setOnClickListener(this);
        mainMenuButton.setOnClickListener(this);
        pauseQuitButton.setOnClickListener(this);
        setCanceledOnTouchOutside(false);
}





    *//**
     * This is a switch case which will be used to go through each pause menu button
     * and do the specific method for each
     * @param v: this is the id of the buttons
     *//*

    @Override
    public void onClick(View v) {
        switch(v.getId())
        {
            case R.id.resume_button:
                dismiss();
                GameFragment.getGameLoop().resume();
                GameFragment.setPaused(false);
                if(GameFragment.getGameMusic().hasPlayed()==true){
                    GameFragment.getGameMusic().startGameMusic();
                }
             break;

            case R.id.menupause_button:
                transitionFragment(new MainMenuScreen());
                dismiss();
              break;

            case R.id.quit_button:
               System.exit(1);
              dismiss();
            default:
                break;

        }
        dismiss();
    }

    *//**
     * The method below will transition through to the next fragment
     *//*
    public void transitionFragment(Fragment frag){

        FragmentManager fragmentManager = activity.getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(nextFragment.getId(), frag);
        fragmentTransaction.commit();
    }*/






































