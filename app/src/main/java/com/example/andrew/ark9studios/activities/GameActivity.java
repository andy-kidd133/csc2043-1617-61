package com.example.andrew.ark9studios.activities;

import android.app.Activity;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.example.andrew.ark9studios.R;


public class GameActivity extends Activity {

    private QuibtigFragment quibtigFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        Window window = getWindow();
        window.requestFeature(Window.FEATURE_NO_TITLE);
        window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);


        setContentView(R.layout.activity_game);

        if(savedInstanceState == null){
            this.quibtigFragment = new QuibtigFragment();
            getFragmentManager().beginTransaction()
                    .add(R.id.container, quibtigFragment).commit();
    }

    }
}
