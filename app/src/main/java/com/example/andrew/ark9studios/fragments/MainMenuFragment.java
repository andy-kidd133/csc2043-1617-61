package com.example.andrew.ark9studios.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.andrew.ark9studios.MainActivity;
import com.example.andrew.ark9studios.R;

/**
 * Created by megan on 10/02/2017.
 */

public class MainMenuFragment extends Fragment {


    private ImageView playGame, options, scoreBoard, rules, quit;
    private MainActivity mainActivity;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.main_menu, container, false);


        //TODO : SET UP ASSETS AND LOAD IN MENU MUSIC
        mainActivity = (MainActivity)getActivity();
        playGame = (ImageView) view.findViewById(R.id.play_button);
        options = (ImageView) view.findViewById(R.id.option_button);
        scoreBoard = (ImageView) view.findViewById(R.id.score_button);
        rules = (ImageView) view.findViewById(R.id.rules_button);
        quit = (ImageView) view.findViewById(R.id.quit_button);

        setupPlayGame();
        setupOptions();
        setupScoreBoard();
        setupRules();
        setupQuit();

        return view;
    }


    //TODO: CREATE A SWITCH CASE FOR MENU BUTTONS
    public void setupPlayGame(){

    }



    public void setupOptions(){

    }


    public void setupScoreBoard(){

    }

    public void setupRules(){


    }


    public void setupQuit(){

    }



}
