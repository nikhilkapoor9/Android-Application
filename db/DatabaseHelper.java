package com.example.form.db;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.EditText;

import androidx.annotation.Nullable;

import static androidx.core.content.ContextCompat.startActivity;

public class DatabaseHelper extends SQLiteOpenHelper {
    SQLiteDatabase db;
    public static final String Database_name = "Signup.db";
    public static final String Table_name = "Studenttable";
    public static final String Col_1 = "FIRSTNAME";
    public static final String Col_2 = "LASTNAME";
    public static final String Col_3 = "EMAILID";
    public static final String Col_4 = "PASSWORD";
    public static final String Col_5 = "StudentID";


    public DatabaseHelper(@Nullable Context context) {
        super(context, Database_name, null, 1);
//        SQLiteDatabase db=this.getWritableDatabase();

    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE "+Table_name+" (FIRSTNAME TEXT, LASTNAME TEXT, EMAILID TEXT PRIMARY KEY, PASSWORD TEXT, StudentID INTEGER PRIMARY KEY AUTOINCREMENT) ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Table_name);
        onCreate(db);
    }

    public boolean insertData(String fname, String lname, String email, String pass) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(Col_1, fname);
        contentValues.put(Col_2, lname);
        contentValues.put(Col_3, email);
        contentValues.put(Col_4, pass);

        long result = db.insert(Table_name, null, contentValues);
        if (result == -1) {
            return false;
        } else {
            return true;

        }
    }
    //  method to fetch user email and password from database

    public boolean fetch(String email, String password) {

         String fetcheduserid=null;
         String fetcheduserpswrd=null;
        SQLiteDatabase db = this.getReadableDatabase();
        Log.i("info database", "now inside database helper file");
        Cursor userid = db.rawQuery("select " + Col_3 + " from Studenttable where "+Col_3+" = '" + email + "' ", null);
        Cursor userpsrd=db.rawQuery("select " +Col_4+ " from Studenttable where "+Col_4+"=  ' "+password+" '  ",null);

        userid.moveToFirst();
        while (userid.isAfterLast()==false){
                       Log.e("fetched email id is ", userid.getString(userid.getColumnIndex(Col_3)));
            fetcheduserid=userid.getString(userid.getColumnIndex(Col_3));
                     userid.moveToNext();
        }

        userpsrd.moveToFirst();
        while(userpsrd.isAfterLast()==false){
            Log.i("fetched paswword id =>",userpsrd.getString(userpsrd.getColumnIndex(Col_4)));
            fetcheduserpswrd=userpsrd.getString(userpsrd.getColumnIndex(Col_4));
            userpsrd.moveToNext();
        }

        ////////////////////        validation for user email and password
        if ( fetcheduserid != null  &&  fetcheduserid.equals(email) ) {

            Log.i("info","email  matches");
            return true;
        }
        else{
            Log.i("info","email id dosen't matches");
            return  false;
        }
    }


//    public void fetch() {
//
//        SQLiteDatabase db = this.getReadableDatabase();
//
//        Cursor res = db.rawQuery("select * from Studenttable", null);
//
//        res.moveToFirst();
////        Log.e("value lname is ", res.getString(res.getColumnIndex(Col_2)));
//
//
//        while (res.isAfterLast() == false) {
//            Log.e("Value fname is ", res.getString(res.getColumnIndex(Col_3)));
//            res.moveToNext();
//        }
//    }


}


