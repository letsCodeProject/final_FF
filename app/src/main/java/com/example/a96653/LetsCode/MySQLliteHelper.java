package com.example.a96653.LetsCode;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.content.ContentValues;
public class MySQLliteHelper extends SQLiteOpenHelper {


    private static final String db_name = "LetsCode2.db";

    private static final int db_version =1;

    private String table_name = "Child";

    SQLiteDatabase DB;


    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + SchemClass.LetsCode2.TABLE_NAME + " (" +
                    SchemClass.LetsCode2.COLUMN_NAME_ID + " INTEGER PRIMARY KEY autoincrement," +
                    SchemClass.LetsCode2.COLUMN_NAME_ChildName + " TEXT," +
                    SchemClass.LetsCode2.COLUMN_NAME_Score + " INTEGER DEFAULT 0 NOT NULL)";

    private static final String SQL_CREATE_TABLE_LEVEL =
            "CREATE TABLE "+ SchemClass.LetsCode2.SECOND_TABLE+ "(" +
              SchemClass.LetsCode2.COLUMN_NAME_LevelName+" TEXT primary key,"+
              SchemClass.LetsCode2.COLUMN_NAME_LessonsPassed+" integer,"+
              SchemClass.LetsCode2.COLUMN_NAME_LEVELSTATUS+" bool)";


    public MySQLliteHelper(Context context) {
        super(context, db_name, null, db_version);
        DB = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_CREATE_ENTRIES);
        sqLiteDatabase.execSQL(SQL_CREATE_TABLE_LEVEL);

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


    public void addData(){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues1 = new ContentValues();
        contentValues1.put(SchemClass.LetsCode2.COLUMN_NAME_LevelName,"بلوتو");
        contentValues1.put(SchemClass.LetsCode2.COLUMN_NAME_LessonsPassed,0);
        contentValues1.put(SchemClass.LetsCode2.COLUMN_NAME_LEVELSTATUS,1);
        long result=db.insert(SchemClass.LetsCode2.SECOND_TABLE,null,contentValues1);

        String []Planet_Name=new String [4];
        Planet_Name[0]="نيبتون";
        Planet_Name[1]="زحل";
        Planet_Name[2]="المشتري";
        Planet_Name[3]="الارض";
        long res=0;
        ContentValues contentValues2 = new ContentValues();
        for ( int i=0;i<=3;i++){
            contentValues2.put(SchemClass.LetsCode2.COLUMN_NAME_LevelName, Planet_Name[i]);
            contentValues2.put(SchemClass.LetsCode2.COLUMN_NAME_LessonsPassed,0);
            contentValues2.put(SchemClass.LetsCode2.COLUMN_NAME_LEVELSTATUS,0);
            res=db.insert(SchemClass.LetsCode2.SECOND_TABLE,null,contentValues2);
        }

    }

}