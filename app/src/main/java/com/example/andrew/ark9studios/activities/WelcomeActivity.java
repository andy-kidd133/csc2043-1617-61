package com.example.andrew.ark9studios.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.andrew.ark9studios.Databases.Session;
import com.example.andrew.ark9studios.R;

/**
 * Created by Megan on 23/02/2017.
 */

/**
 * this is the welcome screen that the user is redirected to when they login
 */
public class WelcomeActivity extends Activity implements View.OnTouchListener {

    //////////////////////////////////////
    ///////Variables
    /////////////////////////////////////

    /**
     * An imageview of the tap to start and logout button
     */
    private ImageView tapToStart, logout;

    /**
     * instance of the session class
     */
    private Session session;



    //////////////////////////////////////
    ///////Methods
    /////////////////////////////////////


    /*(non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 *
	 * The onCreate method is called by android when the activity is created
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //set the content view
        setContentView(R.layout.activity_main);

        //setting the session
        /**
         * if the session is logged in, then logout
         */
        session = new Session(this);
        if (!session.loggedIn()) {
            logout();
        }

        //setting the logout and tap to start to their buttons
        logout = (ImageView) findViewById(R.id.logout_button);
        tapToStart = (ImageView) findViewById(R.id.startgame_button);


        logout.setOnTouchListener(this);

        tapToStart.setOnTouchListener(this);



    }

    /**
     * This is the OnTouch method which is overrided
     * If the logout button is tocuhed then the logout method is triggered
     * if the start game button is touched then we move from this activity to the
     *gamescreen
     */
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (v.getId()) {

            case R.id.logout_button:
                logout();
                break;
            case R.id.startgame_button:
                startActivity(new Intent(WelcomeActivity.this, GameActivity.class));
                finish();
                break;

            default:

        }
        return false;
    }


    /**
     * logout method
     * sets the logged in to false
     * finishes this activity and goes back to the login screen
     */
    private void logout() {
        session.setLoggedIn(false);
        finish();
        startActivity(new Intent(WelcomeActivity.this, LoginActivity.class));


    }



}




