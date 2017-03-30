package com.example.andrew.ark9studios.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.andrew.ark9studios.R;


/**
 * Created by megan on 02/03/2017.
 * expanded by paul on the 15/03/2017.
 */

public class RulesFragment extends Fragment {

private ImageView gameRules;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.rules_frag, container, false);


        TextView rulesText = (TextView) view.findViewById(R.id.rules_text_view);
        rulesText.setText("Win conditions: \n 1:Opponent runs out of cards to draw. \n 2:Opponent has no Unimon on the field. \n 3:Player collects all their prize cards.\n\n"+
                "Setup:\n Shuffle your deck. Put top three cards face down in the prize cards \n section and draw 6 cards. Check you have at least 1 Unimon card.\n" +
                "If you have no Unimon cards. Place all your cards in your hand  back\n" + " in the deck, reshuffle and draw another 6. Repeat until you have at\n" +
                "least 1 Unimon card in your hand \n\n" + " Turn order:\n 1: Draw 1 card from your deck and place 1 Unimon  card in your active\n" +
                "zone. You may also place up to 3 other Unimon cards in your bench\n" +  "2: Attach an energy card, if you have one to any of your Unimon. You\n" +
                "may also use any action cards you have.\n"+ "3: To evolve a Unimon place the 'evolution' action card on top of it.\n" +
                "4:Check your active Unimon has enough energy to attack and if so\n" +  "deal damage according to the amount displayed on the card.\n" +
                "5:If total damage dealt equals or exceeds the health of the defending\n" + "Unimon it is sent to the discrad pile and the attacker takes  one of\n" +
                " their own prize cards. The turn is then over\n\n"+ "A trainer only has to complete step 1. They can end their turn without\n" +
                " doing anything else. They can also do steps 2-4 in any order but\n" + "but attacking will cause the turn to end and should be done last\n" +
                "Good luck and have fun!"


        );




        return view;

    }
}
