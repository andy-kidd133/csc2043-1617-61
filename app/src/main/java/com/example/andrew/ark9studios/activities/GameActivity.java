package com.example.andrew.ark9studios.activities;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.example.andrew.ark9studios.QuibtigFragment;
import com.example.andrew.ark9studios.R;


/**
 * Created by Megan on 09/04/2017.
 */

/**
 * this activity holds a reference of the quibtig fragment
 * which navigates the user to the main menu
 */
public class GameActivity extends Activity {


    /**
     * Holds reference to the Fragment that we will render our view on
     */

    private QuibtigFragment quibtigFragment;



    /*(non-Javadoc)
   * @see android.app.Activity#onCreate(android.os.Bundle)
   *
   * The onCreate method is called by android when the activity is created
   */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        //setting up the screen window
        Window window = getWindow();
        window.requestFeature(Window.FEATURE_NO_TITLE);
        window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);


        //setting the content
        setContentView(R.layout.activity_game2);


        //navigating to the quibitig fragment
        if(savedInstanceState == null){
            this.quibtigFragment = new QuibtigFragment();
            getFragmentManager().beginTransaction().add(R.id.container, quibtigFragment).commit();
        }
    }
}
