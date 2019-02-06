package com.example.a96653.LetsCode;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;
import android.widget.RadioGroup;
import android.widget.TextView;

// i hate git hub
public class firstlevel_6 extends AppCompatActivity {
    Dialog myDialog;
    RadioGroup radioGroup;
    static int res=2;
    MySQLliteHelper mySqliteOpenHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firstlevel_6);
       //inititing INDEX TABLE.
        mySqliteOpenHelper=new MySQLliteHelper(this);
        mySqliteOpenHelper.queryIndexData();
        myDialog = new Dialog(this);

        //HOME BUTTON
        ImageButton homebtn6=(ImageButton)findViewById(R.id.homebtn7);
        homebtn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent HomePage=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(HomePage);
            }
        });

        //for taking the answer of quesion 1 .
        TextView textView = (TextView)findViewById(R.id.quiz_score1_1);
        textView.setText(mySqliteOpenHelper.getChildScore()+"" );

        final RadioButton radio1 = ( RadioButton) findViewById(R.id.radio_one);
        final   RadioButton radio2 = ( RadioButton) findViewById(R.id.radio_two);

        ImageView choice1=(ImageView)findViewById(R.id.choiceOne);
        ImageView choice2=(ImageView)findViewById(R.id.choiceTwo);

      radioGroup = (RadioGroup) findViewById(R.id.group);


        choice1.setOnClickListener( new ImageView.OnClickListener(){

            @Override
            public void onClick(View v) {
                radio1.setChecked(true);

            }
        });


        choice2.setOnClickListener( new ImageView.OnClickListener(){

            @Override
            public void onClick(View v) {
                radio2.setChecked(true);




            }
        });

/////end of taking the answer of question 1.


//NEXT BUTTON METHODS
        ImageView next = (ImageView)findViewById(R.id.next2);
        next.setOnClickListener(
                new ImageView.OnClickListener(){
                    public void onClick(View v){
                        //if(res!=2){

                           // updatedata();

                       // }// else ShowPopupSolve();
                        // openSecondActivity();
                        int radioId = radioGroup.getCheckedRadioButtonId();

                        if(radioId==R.id.radio_one){
                            mySqliteOpenHelper.UpdateQuestionAnswer(1,1);
                            SharedPreferences prefs = getSharedPreferences("pref11", MODE_PRIVATE);
                            boolean firstStart = prefs.getBoolean("firstStart", true);
                            if (firstStart){
                                mySqliteOpenHelper.UpdateNumOfLesson(7,"Ploto");
                                SharedPreferences pref = getSharedPreferences("prefs11", MODE_PRIVATE);
                                SharedPreferences.Editor editor = prefs.edit();
                                editor.putBoolean("firstStart", false);
                                editor.apply();}
                            // mySqliteOpenHelper.updateChildScore(5);
                            openSecondActivity();}
                        if(radioId==R.id.radio_two){
                            mySqliteOpenHelper.UpdateQuestionAnswer(1,0);
                            SharedPreferences prefs = getSharedPreferences("pref11", MODE_PRIVATE);
                            boolean firstStart = prefs.getBoolean("firstStart", true);
                            if (firstStart){
                                mySqliteOpenHelper.UpdateNumOfLesson(7,"Ploto");
                                SharedPreferences pref = getSharedPreferences("prefs11", MODE_PRIVATE);
                                SharedPreferences.Editor editor = prefs.edit();
                                editor.putBoolean("firstStart", false);
                                editor.apply();}
                            openSecondActivity();}
                        if(radioId==-1)  {
                            ShowPopupSolve(); }
                            //check();

                    }

                }

        );

    }

    public void openSecondActivity(){
        Intent intent=new Intent(this,firstlevel_7.class);
        startActivity(intent);
    }



    public void ShowPopup(View v) {

        Button btnClose;
        myDialog.setContentView(R.layout.hint1_1);
        btnClose =(Button) myDialog.findViewById(R.id.okaybtn);


        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }
    public void check(){

        Cursor cursor=mySqliteOpenHelper.returnWrongQuestionIndex();

        if(cursor.getCount()>0){


            cursor.moveToFirst();

            int index=cursor.getColumnIndexOrThrow("Question");
            String name =cursor.getString(index);
            Toast.makeText(firstlevel_6.this, name,
                    Toast.LENGTH_LONG).show();
            if(name.equals("firstlevel_6")){mySqliteOpenHelper.deleteIndexData(name);}
            cursor=mySqliteOpenHelper.returnWrongQuestionIndex();
            if(cursor.getCount()>0){
                try { openPlotoActivity(mySqliteOpenHelper );
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }else {  Intent intent= new Intent(getApplicationContext(),firstlevel_resultsheet.class);
                startActivity(intent);}



        }else {  Intent intent= new Intent(getApplicationContext(),firstlevel_7.class);
            startActivity(intent);}

    }



    public void openPlotoActivity(MySQLliteHelper M ) throws ClassNotFoundException {

        Cursor cursor=mySqliteOpenHelper.returnWrongQuestionIndex();

        if(cursor.getCount()>0){ cursor.moveToFirst();
            int index=cursor.getColumnIndexOrThrow("Question");
            String name =cursor.getString(index);
            Class c;
            try{
                c = Class.forName("com.example.a96653.LetsCode."+name);

                Intent  intent = new Intent(this,c);


                startActivity(intent);}
            catch (Exception e){e.printStackTrace();}}

    }


    public void btn1(View view) {
        res=1;
    }

    public void btn2(View view) {
        res=0;
    }

    public void updatedata() {

        if (res == 0) {
            mySqliteOpenHelper.UpdateQuestionAnswer(1,0);
        }
        else
            mySqliteOpenHelper.UpdateQuestionAnswer(1,1);

        //  getdata();

    }

    public void ShowPopupSolve() {

        Button btnClose;
        myDialog.setContentView(R.layout.solve_it);
        btnClose =(Button) myDialog.findViewById(R.id.okaybtn);

        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }
}
