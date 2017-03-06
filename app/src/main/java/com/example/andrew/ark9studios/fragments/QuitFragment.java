package com.example.andrew.ark9studios.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.andrew.ark9studios.R;

/**
 * Created by megan on 02/03/2017.
 */

public class QuitFragment extends MainMenuFragment  {

    private ImageView quitYes, quitNo;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.quit_frag, container, false);


        TextView quitTitle = (TextView) view.findViewById(R.id.quit_title);
        quitTitle.setText("Are You Sure You Want To Quit?");


        quitYes = (ImageView) view.findViewById(R.id.yes_button);
        quitNo = (ImageView) view.findViewById(R.id.no_button);



        setUpYes();
        setUpNo();
        return view;

    }




    public void setUpYes(){
        quitYes.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                System.exit(1);
            }
        });
    }

    public void setUpNo(){
        quitNo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                MainMenuFragment menu = new MainMenuFragment();
               QuitFragment.super.transitionFragment(menu);
        }
        });
    }



}
