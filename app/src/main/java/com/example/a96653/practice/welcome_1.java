
package com.example.a96653.practice;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.TextView;

public class welcome_1 extends AppCompatActivity {

    //for db
    ContentValues values = new ContentValues();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
    final   MySQLliteHelper mySqliteOpenHelper=new MySQLliteHelper(this);
        //SQLiteDatabase mDatabase=mySqliteOpenHelper.getWritableDatabase();
       // values.put(SchemClass.LetsCode2.COLUMN_NAME_Score, 0);
       // mySqliteOpenHelper.addData("nooor",7);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_1);
        Button button= findViewById(R.id.button);

       /* EditText   txt5 = (EditText) findViewById(R.id.editText);
        if (!txt5.getText().toString().isEmpty()) {
            values.put(SchemClass.LetsCode2.COLUMN_NAME_ChildName,txt5.getText().toString());
            long newRowId = mDatabase.insert(SchemClass.LetsCode2.TABLE_NAME, null, values);}
        else {
            values.put(SchemClass.LetsCode2.COLUMN_NAME_ChildName,"EMPTY");
            long newRowId = mDatabase.insert(SchemClass.LetsCode2.TABLE_NAME, null, values);
        }*/

        final Intent next=new Intent(getApplicationContext(),welcome_2.class);

        button.setOnClickListener(new View.OnClickListener() {

            public   EditText   txt4 = (EditText) findViewById(R.id.editText);

            public  String nameContent = String.valueOf(txt4);


            @Override
            public void onClick(View v) {

                if (txt4.getText().toString().isEmpty())
                    txt4.setError(Html.fromHtml("<font color='white'>أدخل إسمك من فضلك</font>"));


                else
                {
                    mySqliteOpenHelper.addData(txt4.getText().toString(),0);
                    next.putExtra("com.example.a96653.practice", txt4.getText().toString()+"");
                    startActivity(next);
                }//end else

            }//end of onClick method
        }//end of inner class
                 );



        }



    }



