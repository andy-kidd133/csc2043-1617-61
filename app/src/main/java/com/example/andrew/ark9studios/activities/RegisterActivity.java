package com.example.andrew.ark9studios.activities;

/*
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.andrew.ark9studios.R;

public class RegisterActivity extends Activity implements  View.OnClickListener {


    private ImageView reg, goToLogin;
    private EditText etUsername, etPass;
    private DbHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

         db = new DbHelper(this);
        reg = (ImageView) findViewById(R.id.register_button);
        goToLogin = (ImageView) findViewById(R.id.goToLogin_button);
        etUsername = (EditText) findViewById(R.id.etUsername);
        etPass = (EditText) findViewById(R.id.etPass);


        reg.setOnClickListener(this);
        goToLogin.setOnClickListener(this);



    }

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


    private void displayToast(String message) {

        Toast.makeText(getApplicationContext(),message, Toast.LENGTH_SHORT ).show();


    }
}
*/
