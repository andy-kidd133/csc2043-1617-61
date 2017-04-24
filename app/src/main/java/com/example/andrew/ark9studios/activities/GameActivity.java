package com.example.andrew.ark9studios.activities;

import android.app.Activity;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.andrew.ark9studios.Databases.Session;
import com.example.andrew.ark9studios.GameMusic;
import com.example.andrew.ark9studios.QuibtigFragment;
import com.example.andrew.ark9studios.R;

/**
 * Created by Megan on 23/02/2017.
 */


public class GameActivity extends Activity {


    private Session session;
    private ImageView tapToStart, logout;







    /*(non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 *
	 * The onCreate method is called by android when the activity is created
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);






        String username = getIntent().getStringExtra("Username");
        TextView tvUsername = (TextView) findViewById(R.id.welcomeTxt);
        tvUsername.setText(username);

        session = new Session(this);
        if(!session.loggedIn()){
            logout();
        }
        logout= (ImageView) findViewById(R.id.logout_button);
        tapToStart=(ImageView) findViewById(R.id.startgame_button);


        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logout();
            }
        });

       tapToStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().add(R.id.container,  new QuibtigFragment()).commit();
            }
        });



    }


    /**
     * logout method
     */
    private void logout(){
        session.setLoggedIn(false);
        finish();
        startActivity(new Intent(GameActivity.this, LoginActivity.class));
    }


/*
    public void onBackPressed(){
        if(!quibtigFragment.isBackPressed()){
            super.onBackPressed();
        }
    }*/

}





