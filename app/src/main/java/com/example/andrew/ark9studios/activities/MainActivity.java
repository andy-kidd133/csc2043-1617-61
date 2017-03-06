package com.example.andrew.ark9studios.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import com.example.andrew.ark9studios.R;
import com.example.andrew.ark9studios.fragments.PlayGameFragment;

/**
 * Created by Megan on 23/02/2017.
 */


public class MainActivity extends Activity {


    //TODO: CREATE MUSIC CLASS AND ADD INSTANCE OF VARIABLE


    /*(non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 *
	 * The onCreate method is called by android when the activity is created
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Window window = getWindow();
        window.requestFeature(Window.FEATURE_NO_TITLE);
        window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);


        setContentView(R.layout.activity_main);
        if(savedInstanceState==null){
            getFragmentManager().beginTransaction().add(R.id.container, new PlayGameFragment()).commit();
        }


    }


    /* (non-Javadoc)
	 * @see android.app.Activity#onPause()
	 *
	 * This method is called by android when the application is pushed to the background or if it is interrupted
	 * it pauses our game
	 */

    @Override
    protected void onPause() {
        super.onPause();
    }

    /* (non-Javadoc)
 * @see android.app.Activity#onResume()
 *
 * This method is again called by the android when the user brings the application to the front
 * it resumes our game
 */
    @Override
    public void onResume(){
        super.onResume();

    }

    /* (non-Javadoc)
 * @see android.app.Activity#onDestroy()
 *
 * This method is called when the application is closed fully
 */
    @Override
    public void onDestroy() {
        super.onDestroy();
    }

}


