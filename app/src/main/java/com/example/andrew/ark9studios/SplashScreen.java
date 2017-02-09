package com.example.andrew.ark9studios;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;



/**
 * Created by megan on 09/02/2017.
 */

public class SplashScreen extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
          super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.splash_screen);

     /*  We have used a thread and included the code in the run method that we want to run on the thread
       it simply loads the splash screen and though the intent method switches to the MainActivity class
      */
        Thread timer = new Thread(){
            public void run(){
                try{
                    sleep(1000);
                }catch(Exception e){
                    Log.e("SplashScreen Time", "Error with loading");
                }finally{
                    Intent openMainActivity = new Intent(SplashScreen.this, MainActivity.class);
                    startActivity(openMainActivity);
                    finish();
                }
            }
        };
        timer.start();

        }

    @Override
    protected void onPause(){
        super.onPause();
        finish();
    }
}
