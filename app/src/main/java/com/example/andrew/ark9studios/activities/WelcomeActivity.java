package com.example.andrew.ark9studios.activities;


/*
public class WelcomeActivity extends Activity {

    private Button btnLoggedOut;
    private Session session;
    private ImageView tapToStart;
    private GameMusic backgroundMusic;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);








        String username = getIntent().getStringExtra("Username");
        TextView tvUsername = (TextView) findViewById(R.id.welcomeTxt);
        tvUsername.setText(username);

        session = new Session(this);
        if(!session.loggedIn()){
            logout();
        }
        btnLoggedOut= (Button) findViewById(R.id.logoutBtn);
        tapToStart=(ImageView) findViewById(R.id.startgame_button);


        btnLoggedOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logout();
            }
        });




        setContentView(R.layout.activity_welcome);

    }

    private void logout(){
        session.setLoggedIn(false);
        finish();
        startActivity(new Intent(WelcomeActivity.this, LoginActivity.class));
    }



    */
/**
     * this method returns the background music playter for the activity
     *
     * @return
     *//*


    public GameMusic getPlayer() {
        return backgroundMusic;
    }




    */
/* (non-Javadoc)
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

    */
/* (non-Javadoc)
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

    */
/* (non-Javadoc)
 * @see android.app.Activity#onDestroy()
 *
 * This method is called when the application is closed fully
 *//*

    @Override
    public void onDestroy() {
        super.onDestroy();
        backgroundMusic.destroyGameMusic();
    }



}
*/
