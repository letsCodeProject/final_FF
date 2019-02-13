package com.example.a96653.LetsCode;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.content.ContentValues;
import android.database.sqlite.SQLiteConstraintException;
public class MySQLliteHelper extends SQLiteOpenHelper {


    private static final String db_name = "LetsCode2.db";

    private static final int db_version = 1;

    private String table_name = "Child";

    SQLiteDatabase DB;


    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + SchemClass.LetsCode2.TABLE_NAME + " (" +
                    SchemClass.LetsCode2.COLUMN_NAME_ID + " INTEGER PRIMARY KEY autoincrement," +
                    SchemClass.LetsCode2.COLUMN_NAME_ChildName + " TEXT," +
                    SchemClass.LetsCode2.COLUMN_NAME_Score + " INTEGER DEFAULT 0 NOT NULL)";

    private static final String SQL_CREATE_TABLE_LEVEL =
            "CREATE TABLE " + SchemClass.LetsCode2.SECOND_TABLE + "(" +
                    SchemClass.LetsCode2.COLUMN_NAME_LevelName + " TEXT primary key," +
                    SchemClass.LetsCode2.COLUMN_NAME_LessonsPassed + " integer," +
                    SchemClass.LetsCode2.COLUMN_NAME_LEVELSTATUS + " bool)";

    private static final String SQL_CREATE_TABLE_QUIZ =
            "CREATE TABLE " + SchemClass.LetsCode2.Table_Quiz + "(" +
                    SchemClass.LetsCode2.COLUMN_NAME_QUIZID + "  INTEGER primary key autoincrement ," + SchemClass.LetsCode2.COLUMN_NAME_QUIZRESULT + " INTEGER DEFAULT 0 NOT NULL ,"
                    + SchemClass.LetsCode2.COLUMN_NAME_LevelName + " TEXT , " + " FOREIGN KEY " +
                    "(" + SchemClass.LetsCode2.COLUMN_NAME_LevelName + ")" + " REFERENCES " + SchemClass.LetsCode2.SECOND_TABLE +
                    "(" + SchemClass.LetsCode2.COLUMN_NAME_LevelName + "))";

    private static final String SQL_CREATE_TABLE_QUESTION = "CREATE TABLE " + SchemClass.LetsCode2.TABLE_AUESTION + "(" + SchemClass.LetsCode2.COLUMN_NAME_QNUM + " INTEGER primary key autoincrement ,"
            + SchemClass.LetsCode2.COLUMN_NAME_QANSWER + " INTEGER DEFAULT -1 NOT NULL ," + SchemClass.LetsCode2.COLUMN_NAME_QUIZID + " INTEGER, " + " FOREIGN KEY " + "(" + SchemClass.LetsCode2.COLUMN_NAME_QUIZID + ")"
            + " REFERENCES " + SchemClass.LetsCode2.Table_Quiz + "(" + SchemClass.LetsCode2.COLUMN_NAME_QUIZID + ")" + " ON UPDATE SET NULL);";


    private static final String SQL_CREATE_TABLE_LESSON =
            "CREATE TABLE " + SchemClass.LetsCode2.THIRD_TABLE + "(" +
                    SchemClass.LetsCode2.COLUMN_NAME_LESSON_NUM + " INTEGER )";

    private static final String Welcome_Interface_Table =
            "CREATE TABLE " + SchemClass.LetsCode2.WELCOME_TABLE + "(" +
                    SchemClass.LetsCode2.WELCOME_INTERFACE_NAME + " TEXT primary key," +
                    SchemClass.LetsCode2.WELCOME_INTERFACE_STATUS + " TEXT)";

    private static final String SQL_CREATE_TABLE_INDEX =
            "CREATE TABLE IF NOT EXISTS "+ SchemClass.LetsCode2.INDEX_TABLE2+ "(" +
                    SchemClass.LetsCode2.COLUMN_NAME_QUESTION+" TEXT )";


    public MySQLliteHelper(Context context) {
        super(context, db_name, null, db_version);
        DB = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_CREATE_ENTRIES);
        sqLiteDatabase.execSQL(SQL_CREATE_TABLE_LEVEL);
        sqLiteDatabase.execSQL(SQL_CREATE_TABLE_LESSON);
        sqLiteDatabase.execSQL(Welcome_Interface_Table);
        sqLiteDatabase.execSQL(SQL_CREATE_TABLE_QUIZ);
        sqLiteDatabase.execSQL(SQL_CREATE_TABLE_QUESTION);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {


    }

    public void addData(String name, int Score) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(SchemClass.LetsCode2.COLUMN_NAME_ChildName, name);
        contentValues.put(SchemClass.LetsCode2.COLUMN_NAME_Score, Score);

        long result = db.insert(SchemClass.LetsCode2.TABLE_NAME, null, contentValues);

    }


    public void addData() {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues1 = new ContentValues();
        contentValues1.put(SchemClass.LetsCode2.COLUMN_NAME_LevelName, "Ploto");
        contentValues1.put(SchemClass.LetsCode2.COLUMN_NAME_LessonsPassed, 0);
        contentValues1.put(SchemClass.LetsCode2.COLUMN_NAME_LEVELSTATUS, 1);
        long result = db.insert(SchemClass.LetsCode2.SECOND_TABLE, null, contentValues1);

        String[] Planet_Name = new String[4];
        Planet_Name[0] = "Nepton";
        Planet_Name[1] = "Saturn";
        Planet_Name[2] = "Jupiter";
        Planet_Name[3] = "Earth";
        long res = 0;
        ContentValues contentValues2 = new ContentValues();
        for (int i = 0; i <= 3; i++) {
            contentValues2.put(SchemClass.LetsCode2.COLUMN_NAME_LevelName, Planet_Name[i]);
            contentValues2.put(SchemClass.LetsCode2.COLUMN_NAME_LessonsPassed, 0);
            contentValues2.put(SchemClass.LetsCode2.COLUMN_NAME_LEVELSTATUS, 0);
            res = db.insert(SchemClass.LetsCode2.SECOND_TABLE, null, contentValues2);
        }

    }

    public void addData(int id, String content) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(SchemClass.LetsCode2.COLUMN_NAME_LESSON_NUM, id);
        //contentValues.put(SchemClass.LetsCode2.COLUMN_NAME_CONTENT,content);
        long result = db.insert(SchemClass.LetsCode2.THIRD_TABLE, null, contentValues);

    }

    public void fillLessonContent(int num, String cont) {
        // Lesson l1=new Lesson(1);
        //addLesson(l1);

    }

    public void addLesson(Lesson l) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(SchemClass.LetsCode2.COLUMN_NAME_LESSON_NUM, l.getNum());
        //cv.put(SchemClass.LetsCode2.COLUMN_NAME_CONTENT,l.getContent());
        try {
            long result = db.insert(SchemClass.LetsCode2.THIRD_TABLE, null, cv);
        } catch (SQLiteConstraintException e) {
            throw e;
        }
    }

    public void UpdateNumOfLesson(int lnum, String levelName) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(SchemClass.LetsCode2.COLUMN_NAME_LessonsPassed, lnum);
        String[] args = new String[]{levelName};
        try {
            int i = db.update(SchemClass.LetsCode2.SECOND_TABLE, contentValues, SchemClass.LetsCode2.COLUMN_NAME_LevelName + "=?", args);
        } catch (SQLiteConstraintException E) {
            throw E;
        }
    }

    public int getNumOfLessonPassed(String levelName) {
        SQLiteDatabase DB = this.getReadableDatabase();
        //specify the columns to be fetched
        String[] columns = {SchemClass.LetsCode2.COLUMN_NAME_LessonsPassed};
        //Select condition
        String selection = SchemClass.LetsCode2.COLUMN_NAME_LevelName + " = ?";
        //Arguments for selection
        String[] selectionArgs = {levelName};
        Cursor cursor = DB.query(SchemClass.LetsCode2.SECOND_TABLE, columns, selection, selectionArgs, null, null, null);
        int columIndex;
        int lnum = -1;
        if (null != cursor) {
            cursor.moveToFirst();
            columIndex = cursor.getColumnIndexOrThrow(SchemClass.LetsCode2.COLUMN_NAME_LessonsPassed);
            lnum = cursor.getInt(columIndex);
        }
        return lnum;
    }

    //for welcomming

    public String getChildName() {

        String dbString = "";
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT Name FROM Child;";
        Cursor recordSet = db.rawQuery(query, null);
        recordSet.moveToFirst();
        dbString = recordSet.getString(recordSet.getColumnIndex("Name"));

        return dbString;

    }

    public void Fill_Welcoming_Table() {

        SQLiteDatabase db = this.getWritableDatabase();

        String[] Welcome_interfaces_names = new String[9];
        Welcome_interfaces_names[0] = "welcome1";
        Welcome_interfaces_names[1] = "welcome2";
        Welcome_interfaces_names[2] = "welcome3";
        Welcome_interfaces_names[3] = "welcome4";
        Welcome_interfaces_names[4] = "welcome5";
        Welcome_interfaces_names[5] = "welcome6";
        Welcome_interfaces_names[6] = "welcome7";
        Welcome_interfaces_names[7] = "welcome8";
        Welcome_interfaces_names[8] = "main";
        ContentValues contentValues = new ContentValues();
        long res = 0;
        for (int i = 0; i < Welcome_interfaces_names.length; i++) {
            contentValues.put(SchemClass.LetsCode2.WELCOME_INTERFACE_NAME, Welcome_interfaces_names[i]);
            contentValues.put(SchemClass.LetsCode2.WELCOME_INTERFACE_STATUS, 0);
            res = db.insert(SchemClass.LetsCode2.WELCOME_TABLE, null, contentValues);
        }

    }

    public void UpdateWelcomingTable(String Interface_name, int status) {
        SQLiteDatabase db = this.getWritableDatabase();

        db.execSQL("UPDATE Welcome_Progress SET Status='1' WHERE InterfaceName=" + "'" + Interface_name + "'");

    }

    public String databaseToString() {

        String dbString = "";
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT InterfaceName FROM Welcome_Progress" + " WHERE  Status='1';";
        Cursor recordSet = db.rawQuery(query, null);
        recordSet.moveToFirst();
        while (!recordSet.isAfterLast()) {

            dbString = recordSet.getString(recordSet.getColumnIndex("InterfaceName"));
            recordSet.moveToNext();
        }

        db.close();

        if (dbString.equals(""))
            return "welcome1";

        return dbString;

    }

    //how to add in quiz class , it will be called at the
    public void addQuiz() {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues2 = new ContentValues();
        String[] Planets = new String[4];
        Planets[0] = "ploto";
        Planets[1] = "nepton";
        Planets[2] = "Saturn";
        Planets[3] = "Jupiter";
        for (int i = 0; i <= 3; i++) {
            contentValues2.put(SchemClass.LetsCode2.COLUMN_NAME_LevelName, Planets[i]);

            long result = db.insert(SchemClass.LetsCode2.Table_Quiz, null, contentValues2);
        }
    }//End of method add quiz


    public void addQuestion(int quiz_num) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(SchemClass.LetsCode2.COLUMN_NAME_QUIZID, quiz_num);
        long result = db.insert(SchemClass.LetsCode2.TABLE_AUESTION, null, contentValues);


    }



    //update the value of answer
    public void UpdateQuestionAnswer(int questionid, int answer){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(SchemClass.LetsCode2.COLUMN_NAME_QANSWER , answer);

        db.update(SchemClass.LetsCode2.TABLE_AUESTION,cv,SchemClass.LetsCode2.COLUMN_NAME_QNUM +"="+questionid, null);
    }
    //
    public void UnlockNextLevel(String lvlname){
        int num=1;
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(SchemClass.LetsCode2.COLUMN_NAME_LEVELSTATUS,num);
        db.update(SchemClass.LetsCode2.SECOND_TABLE ,cv, SchemClass.LetsCode2.COLUMN_NAME_LevelName +" = '"+lvlname + "'",null );
    }

    //To update the score of the Child.
    public void updateChildScore(int score){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put (SchemClass.LetsCode2.COLUMN_NAME_Score , score);
        db.update(SchemClass.LetsCode2.TABLE_NAME,cv,SchemClass.LetsCode2.COLUMN_NAME_ID +"="+1, null);


    }

    public Cursor returnQuestionAnswer (int Qnum){

        SQLiteDatabase db = this.getReadableDatabase();
        int lnum=100;
        String query = "SELECT "+SchemClass.LetsCode2.COLUMN_NAME_QANSWER +" FROM "+SchemClass.LetsCode2.TABLE_AUESTION +" WHERE "+SchemClass.LetsCode2.COLUMN_NAME_QNUM +" = "+Qnum;
        Cursor recordSet=db.rawQuery(query,null);
        return recordSet ;
    }
    public int getChildScore() {

        int  score = 0;
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT Score FROM Child;";
        Cursor recordSet = db.rawQuery(query, null);
        recordSet.moveToFirst();
        score = recordSet.getInt(recordSet.getColumnIndex("Score"));

        return score ; }
    public boolean getLevelStatus(String levelName) {
        SQLiteDatabase DB = this.getReadableDatabase();
        //specify the columns to be fetched
        String[] columns = {SchemClass.LetsCode2.COLUMN_NAME_LEVELSTATUS};
        //Select condition
        String selection = SchemClass.LetsCode2.COLUMN_NAME_LevelName + " = ?";
        //Arguments for selection
        String[] selectionArgs = {levelName};
        Cursor cursor = DB.query(SchemClass.LetsCode2.SECOND_TABLE, columns, selection, selectionArgs, null, null, null);
        int columIndex;
        boolean b=false;
        if (null != cursor) {
            cursor.moveToFirst();
            columIndex = cursor.getColumnIndexOrThrow(SchemClass.LetsCode2.COLUMN_NAME_LEVELSTATUS);
            if (cursor.isNull( columIndex) || cursor.getShort( columIndex) == 0) {
                b= false;
            } else {
               b= true;
            }
        }
        return b;
    }

    public void queryIndexData( ){
        SQLiteDatabase database=getWritableDatabase();
        database.execSQL(SQL_CREATE_TABLE_INDEX);}

    public void addIndexData( String ActivityName) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(SchemClass.LetsCode2.COLUMN_NAME_QUESTION, ActivityName);
        long result = db.insert(SchemClass.LetsCode2.INDEX_TABLE2, null, contentValues);


    }

    public Cursor returnWrongQuestionIndex ( ){

        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT "+SchemClass.LetsCode2.COLUMN_NAME_QUESTION +" FROM "+SchemClass.LetsCode2.INDEX_TABLE2 ;
        Cursor recordSet=db.rawQuery(query,null);
        return recordSet ;
    }

    public Integer deleteIndexData (String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(SchemClass.LetsCode2.INDEX_TABLE2, " Question = '"+name+"'",null);
    }
    public Cursor returnLevelStatus(String levlname){
        SQLiteDatabase db = this.getReadableDatabase();
        String Query=" SELECT "+SchemClass.LetsCode2.COLUMN_NAME_LEVELSTATUS +" FROM "+SchemClass.LetsCode2.SECOND_TABLE +" WHERE "+SchemClass.LetsCode2.COLUMN_NAME_LevelName+" = '"+levlname+"'";
        Cursor recordSet=db.rawQuery(Query,null);
        return recordSet;
    }

    public void SubmitResultToQuizTable (int id, int total){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(SchemClass.LetsCode2.COLUMN_NAME_QUIZRESULT, total);
        db.update(SchemClass.LetsCode2.Table_Quiz,cv,SchemClass.LetsCode2.COLUMN_NAME_QUIZID +"="+id,null);
    }




}//END OF CLASS