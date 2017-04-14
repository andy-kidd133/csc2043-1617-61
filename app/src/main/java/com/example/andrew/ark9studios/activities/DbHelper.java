package com.example.andrew.ark9studios.activities;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by megan on 09/04/2017.
 */



/*
public class DbHelper extends SQLiteOpenHelper {

    //variables

    private static final String TAG = DbHelper.class.getSimpleName();
    private static final String DB_NAME="quibtig.db";
    private static final int DB_VERSION = 1;
    SQLiteDatabase db;


    private static final String USER_TABLE = "users";
    private static final String COLUMN_ID = "ID";
    private static final String COLUMN_USERNAME = "USERNAME";
    private static final String COLUMN_PASS = "PASSWORD";



*/
/**
     * create table users{
     *     id integer primary key autoincrement
     *     username text,
     *     password text);
     * }
     *//*



*/
/*    public static final String CREATE_TABLE_USERS = "CREATE TABLE" + USER_TABLE + "("
            + COLUMN_ID + "INTEGER PRIMARY KEY AUTOINCREMENT,"
            + COLUMN_USERNAME + "TEXT, "
            + COLUMN_PASS  + "TEXT);";*//*





    //constructor

    public DbHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table " + USER_TABLE + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, USERNAME TEXT, PASSWORD TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP IF EXISTS " + USER_TABLE );
        onCreate(db);
    }


*/
/**
     *
     * storing user details in database
     *//*



    public void addUser(String username, String password){
       db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_USERNAME, username);
        values.put(COLUMN_PASS, password);

        long id = db.insert(USER_TABLE, null, values);
        db.close();

        Log.d(TAG, "user inserted" + id);

    }

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
*/

