package com.example.a96653.LetsCode;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

public class thirdlevel_24 extends AppCompatActivity {

    MySQLliteHelper mySqliteOpenHelper;
    Dialog myDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thirdlevel_24);

        mySqliteOpenHelper=new MySQLliteHelper(this);

        TextView scoreBox=(TextView )findViewById(R.id.scorebox);


        scoreBox.setText( mySqliteOpenHelper.getChildScore()+"");

        ImageButton home=(ImageButton)findViewById(R.id.homebtn_secondLeve);

        home.setOnClickListener( new ImageButton.OnClickListener(){

            @Override
            public void onClick(View v) {
                startActivity(new Intent(thirdlevel_24.this,MainActivity.class));

            }
        });


        ImageView help1=(ImageView)findViewById(R.id.help3);
        help1.setOnClickListener( new ImageView.OnClickListener(){

            @Override
            public void onClick(View v) {

                ShowPopup();

            }
        });

        ImageView help2=(ImageView)findViewById(R.id.help);

        help2.setOnClickListener( new ImageView.OnClickListener(){

            @Override
            public void onClick(View v) {

                ShowPopup();

            }
        });


        final RadioButton radio1 = ( RadioButton) findViewById(R.id.radio1);
        final RadioButton radio2 = ( RadioButton) findViewById(R.id.radio2);

        radio1.setOnClickListener(new RadioButton.OnClickListener(){

                                      public void onClick(View v){

                                          radio1.setChecked(true);
                                          radio2.setChecked(false);


                                      }
                                  }

        );


        radio2.setOnClickListener(new RadioButton.OnClickListener(){

                                      public void onClick(View v){

                                          radio2.setChecked(true);
                                          radio1.setChecked(false);


                                      }
                                  }

        );

        ImageView choice1=(ImageView)findViewById(R.id.choiceOne);
        ImageView choice2=(ImageView)findViewById(R.id.choiceTwo);


        choice1.setOnClickListener( new ImageView.OnClickListener(){

            @Override
            public void onClick(View v) {
                radio1.setChecked(true);
                radio2.setChecked(false);



            }
        });

        choice2.setOnClickListener( new ImageView.OnClickListener(){

            @Override
            public void onClick(View v) {

                radio2.setChecked(true);
                radio1.setChecked(false);



            }
        });

        ImageView next=(ImageView)findViewById(R.id.nextquiz3_);


        next.setOnClickListener( new ImageView.OnClickListener(){

            @Override
            public void onClick(View v) {

                if(radio1.isChecked()) {
                    SharedPreferences prefs = getSharedPreferences("pref_thirdLevel_24", MODE_PRIVATE);
                    boolean firstStart = prefs.getBoolean("firstStart", true);
                    if (firstStart){
                        mySqliteOpenHelper.UpdateNumOfLesson(52,"Saturn");
                        SharedPreferences pref = getSharedPreferences("pref_thirdLevel_24", MODE_PRIVATE);
                        SharedPreferences.Editor editor = prefs.edit();
                        editor.putBoolean("firstStart", false);
                        editor.apply();}
                    startActivity(new Intent(thirdlevel_24.this,thirdlevel_resultsheet.class));
                    mySqliteOpenHelper.UpdateQuestionAnswer(12, 0);

                }
                if(radio2.isChecked()){
                    SharedPreferences prefs = getSharedPreferences("pref_thirdLevel_24", MODE_PRIVATE);
                    boolean firstStart = prefs.getBoolean("firstStart", true);
                    if (firstStart){
                        mySqliteOpenHelper.UpdateNumOfLesson(52,"Saturn");
                        SharedPreferences pref = getSharedPreferences("pref_thirdLevel_24", MODE_PRIVATE);
                        SharedPreferences.Editor editor = prefs.edit();
                        editor.putBoolean("firstStart", false);
                        editor.apply();}
                    mySqliteOpenHelper.UpdateQuestionAnswer(12,1);
                    startActivity(new Intent(thirdlevel_24.this,thirdlevel_resultsheet.class));
                }

                if(radio2.isChecked() || radio1.isChecked() ) {
                    ////CLEARING PREFRENCES
                    SharedPreferences preferences = getSharedPreferences("pref_thirdLevel_1", MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.clear();
                    editor.commit();
                    finish();
                    //////
                    SharedPreferences preferences2 = getSharedPreferences("pref_thirdLevel_2", MODE_PRIVATE);
                    SharedPreferences.Editor editor2 = preferences2.edit();
                    editor2.clear();
                    editor2.commit();
                    finish();
                    //////////
                    SharedPreferences preferences3 = getSharedPreferences("pref_thirdLevel_3", MODE_PRIVATE);
                    SharedPreferences.Editor editor3 = preferences3.edit();
                    editor3.clear();
                    editor3.commit();
                    finish();
                    ////////
                    SharedPreferences preferences4 = getSharedPreferences("pref_thirdLevel_4", MODE_PRIVATE);
                    SharedPreferences.Editor editor4 = preferences4.edit();
                    editor4.clear();
                    editor4.commit();
                    finish();
                    /////
                    SharedPreferences preferences5 = getSharedPreferences("pref_thirdLevel_5", MODE_PRIVATE);
                    SharedPreferences.Editor editor5 = preferences5.edit();
                    editor5.clear();
                    editor5.commit();
                    finish();

                    /////
                    SharedPreferences preferences6 = getSharedPreferences("pref_thirdLevel_6", MODE_PRIVATE);
                    SharedPreferences.Editor editor6 = preferences6.edit();
                    editor6.clear();
                    editor6.commit();
                    finish();
                    /////
                    SharedPreferences preferences7 = getSharedPreferences("pref_thirdLevel_7", MODE_PRIVATE);
                    SharedPreferences.Editor editor7 = preferences7.edit();
                    editor7.clear();
                    editor7.commit();
                    finish();
                    /////
                    SharedPreferences preferences8 = getSharedPreferences("pref_thirdLevel_8", MODE_PRIVATE);
                    SharedPreferences.Editor editor8 = preferences8.edit();
                    editor8.clear();
                    editor8.commit();
                    finish();
                    /////
                    SharedPreferences preferences9 = getSharedPreferences("pref_thirdLevel_9", MODE_PRIVATE);
                    SharedPreferences.Editor editor9 = preferences9.edit();
                    editor9.clear();
                    editor9.commit();
                    finish();

                    //////
                    SharedPreferences preferences10 = getSharedPreferences("pref_thirdLevel_10", MODE_PRIVATE);
                    SharedPreferences.Editor editor10 = preferences10.edit();
                    editor10.clear();
                    editor10.commit();
                    finish();
                    //////
                    SharedPreferences preferences11 = getSharedPreferences("pref_thirdLevel_11", MODE_PRIVATE);
                    SharedPreferences.Editor editor11 = preferences11.edit();
                    editor11.clear();
                    editor11.commit();
                    finish();
                    //////
                    //////
                    SharedPreferences preferences12 = getSharedPreferences("pref_thirdLevel_12", MODE_PRIVATE);
                    SharedPreferences.Editor editor12 = preferences12.edit();
                    editor12.clear();
                    editor12.commit();
                    finish();
                    //////
                    //////
                    SharedPreferences preferences13 = getSharedPreferences("pref_thirdLevel_13", MODE_PRIVATE);
                    SharedPreferences.Editor editor13 = preferences13.edit();
                    editor13.clear();
                    editor13.commit();
                    finish();
                    //////
                    //////
                    SharedPreferences preferences14 = getSharedPreferences("pref_thirdLevel_14", MODE_PRIVATE);
                    SharedPreferences.Editor editor14 = preferences14.edit();
                    editor14.clear();
                    editor14.commit();
                    finish();
                    //////
                    SharedPreferences preferences15 = getSharedPreferences("pref_thirdLevel_15", MODE_PRIVATE);
                    SharedPreferences.Editor editor15 = preferences15.edit();
                    editor15.clear();
                    editor15.commit();
                    finish();
                    //////
                    //////
                    SharedPreferences preferences16 = getSharedPreferences("pref_thirdLevel_16", MODE_PRIVATE);
                    SharedPreferences.Editor editor16 = preferences16.edit();
                    editor16.clear();
                    editor16.commit();
                    finish();
                    //////
                    SharedPreferences preferences17 = getSharedPreferences("pref_thirdLevel_17", MODE_PRIVATE);
                    SharedPreferences.Editor editor17 = preferences17.edit();
                    editor17.clear();
                    editor17.commit();
                    finish();
                    //////
                    //////
                    SharedPreferences preferences18 = getSharedPreferences("pref_thirdLevel_18", MODE_PRIVATE);
                    SharedPreferences.Editor editor18 = preferences18.edit();
                    editor18.clear();
                    editor18.commit();
                    finish();
                    //////
                    //////
                    SharedPreferences preferences20 = getSharedPreferences("pref_thirdLevel_19", MODE_PRIVATE);
                    SharedPreferences.Editor editor20 = preferences20.edit();
                    editor20.clear();
                    editor20.commit();
                    finish();
                    //////
                    //////
                    SharedPreferences preferences22 = getSharedPreferences("pref_thirdLevel_20", MODE_PRIVATE);
                    SharedPreferences.Editor editor22 = preferences22.edit();
                    editor22.clear();
                    editor22.commit();
                    finish();
                    //////
                    //////
                    SharedPreferences preferences24 = getSharedPreferences("pref_thirdLevel_21", MODE_PRIVATE);
                    SharedPreferences.Editor editor24 = preferences24.edit();
                    editor24.clear();
                    editor24.commit();
                    finish();
                    //////
                    //////
                    SharedPreferences preferences26 = getSharedPreferences("pref_thirdLevel_22", MODE_PRIVATE);
                    SharedPreferences.Editor editor26 = preferences26.edit();
                    editor26.clear();
                    editor26.commit();
                    finish();
                    //////
                    //////
                    SharedPreferences preferences_third = getSharedPreferences("pref_thirdLevel_23", MODE_PRIVATE);
                    SharedPreferences.Editor editor_third = preferences_third.edit();
                    editor_third.clear();
                    editor_third.commit();
                    finish();
                    //////
                    //////
                    SharedPreferences preferences_third24 = getSharedPreferences("pref_thirdLevel_24", MODE_PRIVATE);
                    SharedPreferences.Editor editor_third24 = preferences_third24.edit();
                    editor_third24.clear();
                    editor_third24.commit();
                    finish();
                    //////
                }//END IF FOR SHARED PREFRENCES

                if(!radio1.isChecked()&&!radio2.isChecked()){
                    ShowPopupSolve();}




            }
        });

    }











    public void ShowPopup() {
        myDialog = new Dialog(this);
        Button btnClose;
        myDialog.setContentView(R.layout.hint3_5);
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

    public void ShowPopupSolve() {
        myDialog = new Dialog(this);
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