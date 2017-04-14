package com.example.andrew.ark9studios.activities;

/*import android.app.Activity;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.andrew.ark9studios.GameMusic;
import com.example.andrew.ark9studios.R;
import com.example.andrew.ark9studios.fragments.MainMenuScreen;*/

/**
 * Created by Megan on 23/02/2017.
 */
/*

public class MainActivity extends Activity {


    private Session session;
    private ImageView tapToStart, logout;
    private GameMusic backgroundMusic;





    *//*(non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 *
	 * The onCreate method is called by android when the activity is created
     *//*

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


       setVolumeControlStream(AudioManager.STREAM_MUSIC);
        backgroundMusic = new GameMusic(MainActivity.this, R.raw.backgroundmusic);
        if (backgroundMusic.isPlaying() == false) {
            backgroundMusic.startGameMusic();
        }


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
                getFragmentManager().beginTransaction().add(R.id.container, new MainMenuScreen()).commit();
            }
        });



    }



    private void logout(){
        session.setLoggedIn(false);
        finish();
        startActivity(new Intent(MainActivity.this, LoginActivity.class));
    }

    *//**
     * this method returns the background music playter for the activity
     *
     * @return
     *//*

    public GameMusic getPlayer() {
        return backgroundMusic;
    }




    *//* (non-Javadoc)
	 * @see android.app.Activity#onPause()
	 *
	 * This method is called by android when the application is pushed to the background or if it is interrupted
	 * it pauses our game
	 *//*

    @Override
    public void onPause() {
        super.onPause();
        backgroundMusic.pauseGameMusic();
    }

    *//* (non-Javadoc)
  * @see android.app.Activity#onResume()
  *
  * This method is again called by the android when the user brings the application to the front
  * it resumes our game
  *//*
    @Override
    public void onResume() {
        super.onResume();
        backgroundMusic.resumeGameMusic();
    }

    *//* (non-Javadoc)
 * @see android.app.Activity#onDestroy()
 *
 * This method is called when the application is closed fully
 *//*
    @Override
    public void onDestroy() {
        super.onDestroy();
        backgroundMusic.destroyGameMusic();
    }

}*/





