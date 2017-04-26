package com.example.andrew.ark9studios.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
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

public class LoginActivity extends Activity implements View.OnClickListener {

    private ImageView login, register;
    private EditText etUsername, etPassword;
    private DbHelper db;
    private Session session;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        //set the content view
        setContentView(R.layout.activity_login);
        db = new DbHelper(this);
        session = new Session(this);
        login = (ImageView) findViewById(R.id.login_button);
        register = (ImageView) findViewById(R.id.register_button);
        etUsername = (EditText) findViewById(R.id.etUsername);
        etPassword = (EditText) findViewById(R.id.etPass);

        //SETTING ONCLICK LISTENERS
        login.setOnClickListener(this);
        register.setOnClickListener(this);

        if (session.loggedIn()) {
            startActivity(new Intent(LoginActivity.this, WelcomeActivity.class));
            finish();
        }


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.login_button:
                login();
                break;
            case R.id.register_button:
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
                break;

            default:

        }
    }


    private void login() {
        String username = etUsername.getText().toString();
        String pass = etPassword.getText().toString();

        if (db.getUser(username, pass)) {
            session.setLoggedIn(true);
            Intent mainAct = new Intent(LoginActivity.this, WelcomeActivity.class);
            mainAct.putExtra("Username", username);
            startActivity(mainAct);
            finish();
        } else {
            Toast.makeText(getApplicationContext(), "Wrong username/password", Toast.LENGTH_SHORT).show();
        }
    }




}
