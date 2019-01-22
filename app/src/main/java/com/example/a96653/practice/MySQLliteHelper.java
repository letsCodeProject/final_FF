package com.example.a96653.practice;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.content.ContentValues;
public class MySQLliteHelper extends SQLiteOpenHelper {

    //DB COMPONENTS
    private static final String db_name = "LetsCode2.db";
    private static final int db_version = 1;
    //CHILD TABLE
    private String table_name = "Child";

    SQLiteDatabase DB;
    //////
    //private String create_db_statement = "create table "+ table_name+ "(" +column_1+" integer primary key autoincrement,"+coulmn_2+" text,"+coulmn_3+" integer)";
    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + SchemClass.LetsCode2.TABLE_NAME + " (" +
                    SchemClass.LetsCode2.COLUMN_NAME_ID + " INTEGER PRIMARY KEY autoincrement," +
                    SchemClass.LetsCode2.COLUMN_NAME_ChildName + " TEXT," +
                    SchemClass.LetsCode2.COLUMN_NAME_Score + " INTEGER DEFAULT 0 NOT NULL)";

    public MySQLliteHelper(Context context) {
        super(context, db_name, null, db_version);
        DB = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void addData(String name, int Score) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(SchemClass.LetsCode2.COLUMN_NAME_ChildName, name);
        contentValues.put(SchemClass.LetsCode2.COLUMN_NAME_Score, Score);
        long result  = db.insert(SchemClass.LetsCode2.TABLE_NAME, null, contentValues);

    }
}