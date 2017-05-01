package com.example.andrew.ark9studios.Databases;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by megan on 09/04/2017.
 */

/**
 * Thia is the database helper class
 */


public class DbHelper extends SQLiteOpenHelper {

    //////////////////////////////////////
    ///////Variables
    /////////////////////////////////////

    private static final String TAG = DbHelper.class.getSimpleName();

    /**
     * name of the database
     */
    private static final String DB_NAME="quibtig.db";

    /**
     * the version of the database
     */
    private static final int DB_VERSION = 1;

    /**
     * instance of the SQL database
     */
    SQLiteDatabase db;


    private static final String USER_TABLE = "users";
    private static final String COLUMN_ID = "ID";
    private static final String COLUMN_USERNAME = "USERNAME";
    private static final String COLUMN_PASS = "PASSWORD";



    //////////////////////////////////////
    ///////Constructor
    /////////////////////////////////////

    public DbHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }


    /**
     * SQL on create method
     * @param db- name of the sql database to be created
     */
    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table " + USER_TABLE + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, USERNAME TEXT, PASSWORD TEXT)");
    }


    /**
     * upgrade database method
     * @param db- name of the database
     * @param oldVersion- number of the old version
     * @param newVersion- number of the new version
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP IF EXISTS " + USER_TABLE );
        onCreate(db);
    }



     /**
     *
     * storing user details in database
     */
    public void addUser(String username, String password){
       db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_USERNAME, username);
        values.put(COLUMN_PASS, password);

        long id = db.insert(USER_TABLE, null, values);
        db.close();

        Log.d(TAG, "user inserted" + id);

    }

    /**
     * Returns the user that has the username and password entered
     * @param username
     * @param pass
     * @return
     */

    public boolean getUser(String username, String pass){
        //HashMap<String, String> user = new HashMap<String, String>();
        String selectQuery = "select * from " + USER_TABLE + " where " +
                COLUMN_USERNAME + " = " + "'" + username + "'" + " and " + COLUMN_PASS + " = " + "'" +pass+"'";

        db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        //move cursor to first row
        cursor.moveToFirst();
        if(cursor.getCount() > 0){


            return true;
        }
        cursor.close();
        db.close();

        return false;

    }






}


