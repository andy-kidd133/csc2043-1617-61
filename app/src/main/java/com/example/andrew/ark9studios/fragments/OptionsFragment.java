package com.example.andrew.ark9studios.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.TextView;

import com.example.andrew.ark9studios.R;
import com.example.andrew.ark9studios.activities.MainActivity;

/**
 * Created by megan on 02/03/2017.
 */

public class OptionsFragment extends Fragment {


    private TextView musicText;
    private Switch musicSwitch;
    private MainActivity mainActivity;

    //TODO : CREATE METHOD FOR RADIO BUTTONS WHEN MUSIC IS IMPLEMENTED


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

    View view = inflater.inflate(R.layout.options_frag, container, false);

        mainActivity = (MainActivity)getActivity();
        musicText = (TextView) view.findViewById(R.id.music_txt);
        musicSwitch = (Switch) view.findViewById(R.id.musicswitch);
        musicSwitch.setChecked(!mainActivity.getPlayer().isOff());

        addListenerToMusic();
        return view;


    }


    /**
     * Functionality added to the on/off music switch button
     * Used Android documentation to understand compound button
     * http://developer.android.com/reference/android/widget/CompoundButton.OnCheckedChangeListener.html
     */
  public void addListenerToMusic(){
      musicSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
          @Override
          public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
              if(isChecked){
                  musicText.setText("Music On");
                  mainActivity.getPlayer().startGameMusic();
                  mainActivity.getPlayer().turnOn();

              }else{
                  musicText.setText("Music Off");
                  mainActivity.getPlayer().stopGameMusic();
                  mainActivity.getPlayer().turnOff();
              }
          }
      });
  }



}
