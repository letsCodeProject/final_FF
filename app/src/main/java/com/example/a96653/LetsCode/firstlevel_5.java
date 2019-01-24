package com.example.a96653.LetsCode;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
// i hate it too -shyom
public class firstlevel_5 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firstlevel_5);

        ImageView previous = (ImageView)findViewById(R.id.previous2);

        previous .setOnClickListener(
                new ImageView.OnClickListener(){
                    public void onClick(View v){

                        openPreviousActivity();
                    }

                }

        );





    }



    public void openPreviousActivity(){

        Intent intent=new Intent(this,firstlevel_4.class);
        startActivity(intent);

    }



}
