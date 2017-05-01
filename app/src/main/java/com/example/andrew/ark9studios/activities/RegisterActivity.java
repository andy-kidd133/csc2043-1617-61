package com.example.andrew.ark9studios.activities;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import android.widget.Toast;

import com.example.andrew.ark9studios.Databases.DbHelper;
import com.example.andrew.ark9studios.R;
/**
 * Created by megan on 09/04/2017.
 */

/**
 * This is the register screen, where the user can enter their username and password
 */

public class RegisterActivity extends Activity implements  View.OnClickListener {

    //////////////////////////////////////
    ///////Variables
    /////////////////////////////////////


    /**
     * An imageview of the go to login and register button
     */
    private ImageView reg, goToLogin;

    /**
     * Edit text of the username and password
     */
    private EditText etUsername, etPass;

    /**
     * instance of the database helper class
     */
    private DbHelper db;



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
        setContentView(R.layout.activity_register);

        //creating an instance of the database
         db = new DbHelper(this);

        //setting the imageviews and edit texts to their buttons
        reg = (ImageView) findViewById(R.id.register_button);
        goToLogin = (ImageView) findViewById(R.id.goToLogin_button);
        etUsername = (EditText) findViewById(R.id.etUsername);
        etPass = (EditText) findViewById(R.id.etPass);


        //setting on click listeners
        reg.setOnClickListener(this);
        goToLogin.setOnClickListener(this);


    }

    /**
     * This is the OnClick method which is overrrided
     *
     * @param v
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.register_button:
                register();
                break;
            case R.id.goToLogin_button:
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                finish();
                break;

            default:

        }
    }


    /**
     * This is the register method
     * it sets what the user has typed in into the
     * username and password variables
     *
     * It uses an if statement; if the username and password field is empty then an error message is
     * displayed
     *
     */
    public void register() {
       String username = etUsername.getText().toString();
        String pass = etPass.getText().toString();

        if (username.isEmpty() && pass.isEmpty()) {
            displayToast("Username/password field is empty");
        } else {
            db.addUser(username, pass);
            displayToast("User registered");
            finish();
        }
    }


    /*
    *this method displays the string of text
     */
    private void displayToast(String message) {

        Toast.makeText(getApplicationContext(),message, Toast.LENGTH_SHORT ).show();


    }
}

