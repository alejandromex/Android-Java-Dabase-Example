package com.example.databaseexample;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.Dictionary;

public class DataManager {

    private SQLiteDatabase db;

    public static final String TABLE_ROW_ID = "_id";
    public static final String TABLE_ROW_NAME = "name";
    public static final String TABLE_ROW_AGE = "age";

    private static final String DB_NAME = "AddressBookDB";
    private static final int DB_VERSION = 1;
    private static final String TABLE_NAMES_AND_ADDRESS = "NamesAndAddresses";

    public DataManager(Context context)
    {
        MyCustomSQLiteOpenHelper helper = new MyCustomSQLiteOpenHelper(context, DB_NAME, null, DB_VERSION);
        db = helper.getWritableDatabase();

    }

    public void InsertAUser(String name, String age)
    {

    }

    public void DeleteAUser(String name)
    {

    }

    public Cursor GetAUser(String name)
    {

        return null;
    }

    public Cursor SelectAll()
    {

        return null;
    }


    private class MyCustomSQLiteOpenHelper extends SQLiteOpenHelper{

        public MyCustomSQLiteOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {

        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }

}
