package com.example.andrew.ark9studios.Databases;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Megan on 09/04/2017.
 */

public class Session {


    //////////////////////////////////////
    ///////Variables
    /////////////////////////////////////

    /**
     * instance of the shared perferences
     */
    SharedPreferences prefs;

    /**
     * instance of the shared perferences editor
     */
    SharedPreferences.Editor editor;

    /**
     * Instance of context
     */
    Context context;


    //////////////////////////////////////
    ///////Constructor
    /////////////////////////////////////

    /**
     * create a new session
     * @param context
     */
    public Session(Context context){
        this.context = context;
        prefs = context.getSharedPreferences("quibtig", Context.MODE_PRIVATE);
        editor = prefs.edit();
    }



    //////////////////////////////////////
    ///////Methods
    /////////////////////////////////////
    /**
     * changes the logged in boolean
     * @param loggedIn
     */
    public void setLoggedIn(boolean loggedIn){
        editor.putBoolean("loggedInmode", loggedIn);
        editor.commit();
    }


    /**
     * logged in boolean
     * @return
     */

    public boolean loggedIn(){
        return prefs.getBoolean("loggedInmode", false);
    }




}
