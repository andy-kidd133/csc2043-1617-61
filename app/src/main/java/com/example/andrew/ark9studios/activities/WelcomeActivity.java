package com.example.andrew.ark9studios.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
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
public class WelcomeActivity extends Activity {

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




        String username = getIntent().getStringExtra("Username");
        TextView tvUsername = (TextView) findViewById(R.id.welcomeTxt);
        tvUsername.setText(username);

        session = new Session(this);
        if (!session.loggedIn()) {
            logout();
        }
        logout = (ImageView) findViewById(R.id.logout_button);
        tapToStart = (ImageView) findViewById(R.id.startgame_button);


        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logout();
            }
        });

        tapToStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WelcomeActivity.this, GameActivity.class);
                startActivity(intent);
            }
        });


    }


    /**
     * logout method
     */
    private void logout() {
        session.setLoggedIn(false);
        finish();
        startActivity(new Intent(WelcomeActivity.this, LoginActivity.class));


    }


}




