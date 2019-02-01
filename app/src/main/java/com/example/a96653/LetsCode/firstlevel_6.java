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



// i hate git hub
public class firstlevel_6 extends AppCompatActivity {
    Dialog myDialog;
    MySQLliteHelper mySqliteOpenHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firstlevel_6);
        //FOR HINT
        myDialog = new Dialog(this);
        ImageButton homebtn6=(ImageButton)findViewById(R.id.homebtn7);

        homebtn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent HomePage=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(HomePage);
            }
        });

      //  next2
         mySqliteOpenHelper=new MySQLliteHelper(this);

        ImageView next = (ImageView)findViewById(R.id.next2);

        next.setOnClickListener(
                new ImageView.OnClickListener(){
                    public void onClick(View v){
                        SharedPreferences prefs = getSharedPreferences("pref11", MODE_PRIVATE);
                        boolean firstStart = prefs.getBoolean("firstStart", true);
                        if (firstStart){
                            mySqliteOpenHelper.UpdateNumOfLesson(7,"Ploto");
                            SharedPreferences pref = getSharedPreferences("prefs11", MODE_PRIVATE);
                            SharedPreferences.Editor editor = prefs.edit();
                            editor.putBoolean("firstStart", false);
                            editor.apply();}

                        openSecondActivity();
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





}
