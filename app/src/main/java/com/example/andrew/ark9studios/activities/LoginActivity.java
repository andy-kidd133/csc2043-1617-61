package com.example.andrew.ark9studios.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.andrew.ark9studios.Databases.DbHelper;
import com.example.andrew.ark9studios.Databases.Session;
import com.example.andrew.ark9studios.R;


/**
 * Created by megan on 09/04/2017.
 */

/**
 * This is the login screen, where the user can enter their username and password
 */

public class LoginActivity extends Activity implements View.OnTouchListener {

    //////////////////////////////////////
    ///////Variables
    /////////////////////////////////////

    /**
     * An imageview of the login and register button
     */
    private ImageView login, register;

    /**
     * Edit text of the username and password
     */
    private EditText etUsername, etPassword;

    /**
     * instance of the database helper class
     */
    private DbHelper db;
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
        setContentView(R.layout.activity_login);

        //creating an instance of the database and session
        db = new DbHelper(this);
        session = new Session(this);

        //setting the imageviews and edit texts to their buttons
        login = (ImageView) findViewById(R.id.login_button);
        register = (ImageView) findViewById(R.id.register_button);
        etUsername = (EditText) findViewById(R.id.etUsername);
        etPassword = (EditText) findViewById(R.id.etPass);

        //SETTING ONCLICK LISTENERS
        login.setOnTouchListener(this);
        register.setOnTouchListener(this);


        /**
         * if the session is logged in then this will take the user
         * to the welcome screen/activity
         */
        if (session.loggedIn()) {
            startActivity(new Intent(LoginActivity.this, WelcomeActivity.class));
            finish();
        }


    }


    /**
     * This is the OnTouch method which is overrided
     * If the login button is clicked on then the login method is triggered
     * if the register button is touched then we move from this activity to the
     * register screen
     *
     * @param v
     */
    @Override
    public boolean onTouch(View v, MotionEvent event) {

        switch (v.getId()) {

            case R.id.login_button:
                login();
                break;
            case R.id.register_button:
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
                break;

            default:

        }
        return false;
    }


    /**
     * This is the login method
     * The username and password the user enters is stored into the variables username and password
     * An if statement is used to check if the database has that user stored, if so then the session is
     * set to logged in and it switches from this screen to the welcome screen
     * else an error is displayed to the user
     */

    private void login() {
        String username = etUsername.getText().toString();
        String pass = etPassword.getText().toString();

        if (db.getUser(username, pass)) {
            session.setLoggedIn(true);
            Intent welcomeAct = new Intent(LoginActivity.this, WelcomeActivity.class);
            startActivity(welcomeAct);
            finish();
        } else {
            Toast.makeText(getApplicationContext(), "Wrong username/password", Toast.LENGTH_SHORT).show();
        }
    }
}
