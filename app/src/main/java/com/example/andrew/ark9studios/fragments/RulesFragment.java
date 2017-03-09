package com.example.andrew.ark9studios.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.andrew.ark9studios.R;


/**
 * Created by megan on 02/03/2017.
 */

public class RulesFragment extends Fragment {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.rules_frag, container, false);


      TextView title = (TextView) view.findViewById(R.id.rules_title);
        title.setText("The Rules Of Unimon");

        TextView rulesText = (TextView) view.findViewById(R.id.rules_text_view);
        rulesText.setText("");

        return view;

    }
}
