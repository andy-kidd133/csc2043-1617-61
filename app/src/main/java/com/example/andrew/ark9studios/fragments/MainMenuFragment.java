package com.example.andrew.ark9studios.fragments;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.example.andrew.ark9studios.R;
import com.example.andrew.ark9studios.activities.MainActivity;

/**
 * Created by Megan on 23/02/2017.
 */
public class MainMenuFragment extends Fragment {


    //variables for our menu buttons and an instance of our main activity class
    private ImageView playGame, options, rules, scoreBoard, quit;
    private MainActivity mainActivity;




    /* (non-Javadoc)
	 * @see android.app.Fragment#onCreateView(android.view.LayoutInflater, android.view.ViewGroup, android.os.Bundle)
	 *
	 *
	 * This method will deal with the view in the UI and the view variables get intialised here
	 */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.main_menu, container, false);
        mainActivity = (MainActivity)getActivity();
        playGame = (ImageView) view.findViewById(R.id.play_button);
        options = (ImageView) view.findViewById(R.id.options_button);
        rules = (ImageView) view.findViewById(R.id.rules_button);
        scoreBoard = (ImageView) view.findViewById(R.id.scoreboard_button);
        quit = (ImageView) view.findViewById(R.id.quit_button);
        setUpPlayGame();
        setUpOptions();
        setUpRules();
        setUpScoreBoard();
        setUpQuit();
        return view;
    }





    /**
     * The method below will transition through to the next fragment and will
     * keep the main menu on backstack
     */
    public void transitionFragment(Fragment fragment){
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction().addToBackStack(null);
        fragmentTransaction.replace(getId(), fragment);
        fragmentTransaction.commit();
    }



    public void setUpPlayGame(){
        playGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            MainGameFragment mainGame = new MainGameFragment();
                transitionFragment(mainGame);            }
        });
    }


    public void setUpOptions(){
        options.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OptionsFragment options = new OptionsFragment();
                transitionFragment(options);
            }
        });
    }


    public void setUpRules(){
        rules.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RulesFragment rules = new RulesFragment();
                transitionFragment(rules);
            }
        });
    }



    public void setUpScoreBoard(){
        scoreBoard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ScoreBoardFragment scoreBoardFrag = new ScoreBoardFragment();
                transitionFragment(scoreBoardFrag);
            }
        });
    }


    public void setUpQuit(){
        quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                QuitFragment quitFrag = new QuitFragment();
                transitionFragment(quitFrag);
            }
        });
    }




    /* (non-Javadoc)
         * @see android.app.Fragment#onPause()
         *
         *  The android pause method
         */
    @Override
    public void onPause() {
        super.onPause();
    }
}