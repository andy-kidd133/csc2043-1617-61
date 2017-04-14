package com.example.andrew.ark9studios.activities;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.andrew.ark9studios.fragments.GameFragment;
import com.example.andrew.ark9studios.fragments.MainMenuFragment;

/**
 * Created by Megan on 13/04/2017.
 */

public class QuibtigFragment extends GameFragment {







    /***
     * Fragment Android Application LifeCycle Override
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = super.onCreateView(inflater, container, savedInstanceState);
        // set up the main screen to be the screen that is shown

        setupStartScreen(new MainMenuFragment(game));

        return view;
    }











}