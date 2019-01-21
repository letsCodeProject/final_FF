package com.example.a96653.practice;

import android.database.sqlite.SQLiteDatabase;

import android.database.sqlite.SQLiteOpenHelper;

import android.database.Cursor;

import android.content.Context;

import android.content.ContentValues;

public class MyDBHandler extends SQLiteOpenHelper {


    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_NAME = "letsCode.db";

    public static final String TABLE_CHILD = "child";

    public static final String COLUMN_NAME = "_name";
    public static final String COLUMN_SCORE = "score";

    public static final String COLUMN_PRODUCTNAME = "productname";

    public MyDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {

        super(context, DATABASE_NAME, factory, DATABASE_VERSION);

    }

    public void onCreate(SQLiteDatabase db) {

        String query = "CREATE TABLE " + TABLE_CHILD + "(" +

                COLUMN_NAME + "TEXT PRIMARY KEY, " +

                COLUMN_SCORE  + " INTEGER " +

                ");";

        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CHILD);
        onCreate(db);
    }
    public void addChild(Child ch){

        ContentValues values = new ContentValues();

        values.put(COLUMN_PRODUCTNAME, ch.getUsername());
        values.put(COLUMN_SCORE , ch.getScore());
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_CHILD, null, values);
        db.close();

    }
    public String databaseToString(){

        String dbString = "";

        SQLiteDatabase db = getWritableDatabase();

        String query = "SELECT * FROM " +TABLE_CHILD+ " WHERE 1";



        Cursor recordSet = db.rawQuery(query, null);

        //Move to the first row in your results

        recordSet.moveToFirst();



        //Position after the last row means the end of the results

        while (!recordSet.isAfterLast()) {

            // null could happen if we used our empty constructor

            if (recordSet.getString(recordSet.getColumnIndex("com.child name")) != null) {

                dbString += recordSet.getString(recordSet.getColumnIndex("productname"));

                dbString += "\n";

            }

            recordSet.moveToNext();

        }

        db.close();

        return dbString;

    }


}
