package com.example.andrew.ark9studios.fragments;


import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.andrew.ark9studios.R;
/**
 * Created by Megan on 23/02/2017.
 */
public class PlayGameFragment extends Fragment {
    /* (non-Javadoc)
	 * @see android.app.Fragment#onCreateView(android.view.LayoutInflater, android.view.ViewGroup, android.os.Bundle)
	 *
	 * The onCreate method is called by android when the activity is created
	 */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.start_frag, container,
                false);
        rootView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                FragmentManager fragMan = getFragmentManager();
                FragmentTransaction fragTran = fragMan.beginTransaction().addToBackStack(null);
                MainMenuFragment menu = new MainMenuFragment();
                fragTran.replace(getId(), menu);
                fragTran.commit();
            }
        });
        return rootView;
    }
}