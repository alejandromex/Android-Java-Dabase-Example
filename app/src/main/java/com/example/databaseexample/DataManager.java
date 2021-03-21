package com.example.databaseexample;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

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
        String query = "INSERT INTO "+TABLE_NAMES_AND_ADDRESS+" ("+
                TABLE_ROW_NAME+", "+TABLE_ROW_AGE+") "+
                "VALUES ('"+name+"', "+"'"+age+"');";
        Log.i("Metodo: INSERT()", query);
        db.execSQL(query);
    }

    public void DeleteAUser(String name)
    {
        String query = "DELETE FROM "+TABLE_NAMES_AND_ADDRESS+" WHERE "+TABLE_ROW_NAME+" = "+"'"+name+"'";
        Log.i("Metodo: DELETE()", query);
        db.execSQL(query);
    }

    public Cursor GetAUser(String name)
    {
        String query = "SELECT * FROM "+TABLE_NAMES_AND_ADDRESS+" WHERE "+TABLE_ROW_NAME+" = "+"'"+name+"'";
        Cursor c = db.rawQuery(query, null);
        return c;
    }

    public Cursor SelectAll()
    {
        String query = "SELECT * FROM "+TABLE_NAMES_AND_ADDRESS;
        Cursor c = db.rawQuery(query, null);
        return c;
    }


    private class MyCustomSQLiteOpenHelper extends SQLiteOpenHelper{

        public MyCustomSQLiteOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            String newTablesQuery = "CREATE TABLE "+
                                    TABLE_NAMES_AND_ADDRESS + " ("+
                                    TABLE_ROW_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, "+
                                    TABLE_ROW_NAME+ " text not null, "+
                                    TABLE_ROW_AGE+ " text not null);";

            db.execSQL(newTablesQuery);

        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            if(oldVersion < newVersion)
            {
                for(int i = oldVersion+1; i<= newVersion; i++)
                {
                    Log.i("UPGRADING database", "Estamos haciendo la actualizacion de nuestro base de dates");
                    updateToVersion(i);
                }
            }
        }

        private void updateToVersion(int versionToUpdate)
        {
            switch(versionToUpdate)
            {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                default:
                    break;
            }
        }
    }

}
