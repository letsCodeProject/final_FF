
package com.example.a96653.LetsCode;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.ContentValues;

public class welcome_1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
    final   MySQLliteHelper mySqliteOpenHelper=new MySQLliteHelper(this);

       mySqliteOpenHelper.addData();
       mySqliteOpenHelper.Fill_Welcoming_Table();
       mySqliteOpenHelper.addQuiz();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_1);
        Button button= findViewById(R.id.button);


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
                    next.putExtra("com.example.a96653.LetsCode", txt4.getText().toString()+"");
                    startActivity(next);
                    mySqliteOpenHelper.UpdateWelcomingTable("welcome2",1);
                }

            }
        }
                 );



        }



    }



