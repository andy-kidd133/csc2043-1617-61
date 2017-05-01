package com.example.andrew.ark9studios.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

import com.example.andrew.ark9studios.R;


/**
 * Created by megan on 09/02/2017.
 */


/**
 * This is the splash screen, the user will be met by this screen when they open the application
 */
public class SplashScreen extends Activity {


    /*(non-Javadoc)
   * @see android.app.Activity#onCreate(android.os.Bundle)
   *
   * The onCreate method is called by android when the activity is created
   */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
          super.onCreate(savedInstanceState);


        setupScreenWindow();

        setContentView(R.layout.splash_screen);

     /*  We have used a thread and included the code in the run method that we want to run on the thread
       it simply loads the splash screen and through the intent method switches to the LoginActivity class
      */
        Thread timer = new Thread(){
            public void run(){
                try{
                    sleep(5000);
                }catch(Exception e){
                    Log.e("SplashScreen Time", "Error with loading");
                }finally{
                    Intent openLoginActivity = new Intent(SplashScreen.this, LoginActivity.class);
                    startActivity(openLoginActivity);
                    finish();
                }
            }
        };
        timer.start();

        }


    /**
     * This method is called by android when the activity is paused
     *
     */
    @Override
    public void onPause(){
        super.onPause();
        finish();
    }



    /***
     * This method sets up the splash screen window to be full screen , to
     * hide the title and keep the back light on
     */
    private void setupScreenWindow() {
        Window window = getWindow();
        window.requestFeature(Window.FEATURE_NO_TITLE);
        window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
    }
}
