package com.example.andrew.ark9studios.Databases;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by megan on 09/04/2017.
 */


public class Session {
    SharedPreferences prefs;
    SharedPreferences.Editor editor;
    Context context;

    public Session(Context context){
        this.context = context;
        prefs = context.getSharedPreferences("quibtig", Context.MODE_PRIVATE);
        editor = prefs.edit();
    }


    public void setLoggedIn(boolean loggedIn){
        editor.putBoolean("loggedInmode", loggedIn);
        editor.commit();
    }

    public boolean loggedIn(){
        return prefs.getBoolean("loggedInmode", false);
    }
}

