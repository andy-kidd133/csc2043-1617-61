package com.example.andrew.ark9studios;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class GameActivity extends Activity {


    /**
     * Holds reference to the Fragment that we will render our view on
     */

    private QuibtigFragment quibtigFragment;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        Window window = getWindow();
        window.requestFeature(Window.FEATURE_NO_TITLE);
        window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);


        setContentView(R.layout.activity_game2);


        if(savedInstanceState == null){
            this.quibtigFragment = new QuibtigFragment();
            getFragmentManager().beginTransaction().add(R.id.container, quibtigFragment).commit();
        }
    }
}
