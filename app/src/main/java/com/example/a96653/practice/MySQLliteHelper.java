package com.example.a96653.practice;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
public class MySQLliteHelper extends SQLiteOpenHelper {

    //DB COMPONENTS
    private static final String db_name="LetsCode.db";
    private static final int db_version=1;
    //CHILD TABLE
    private String table_name="Child";
    private String column_1="id";
    private String coulmn_2="name";
    private String coulmn_3="Score";
    //////
    private String create_db_statment= "create table "+ table_name+ "(id integer primary key autoincrement,name text not null ,coulmn_3 text)";


    public MySQLliteHelper(Context context) {
        super(context,db_name,null,db_version);

    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(create_db_statment);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {


    }
}
