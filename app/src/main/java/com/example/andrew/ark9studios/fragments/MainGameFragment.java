package com.example.andrew.ark9studios.fragments;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;


import com.example.andrew.ark9studios.AssetStore;
import com.example.andrew.ark9studios.CardHelper;
import com.example.andrew.ark9studios.CharacterCard;
import com.example.andrew.ark9studios.Deck;
import com.example.andrew.ark9studios.GameLoop;
import com.example.andrew.ark9studios.GameMusic;
import com.example.andrew.ark9studios.R;
import com.example.andrew.ark9studios.activities.MainActivity;

import java.util.ArrayList;

import static android.R.attr.bitmap;

/**
 * Created by Megan on 06/03/2017.
 */

public class MainGameFragment extends Fragment {

    private static GameLoop gameLoop;
    private AssetStore assetStore;
    private MainActivity mainActivity;
    private static GameMusic gameMusic;
    private Deck deck = new Deck();
    private ImageView card1, shuffleButton;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_game_frag, container, false);




        mainActivity = (MainActivity) getActivity();

        gameMusic = new GameMusic(getActivity().getApplicationContext(), R.raw.laser_groove);

        card1 = (ImageView) view.findViewById(R.id.card1);
        shuffleButton = (ImageView) view.findViewById(R.id.shuffle_deck);

        card1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                 
            }
        });

        return view;

    }


}








