package com.example.a96653.LetsCode;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
// i hate it too -shyom
public class firstlevel_5 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firstlevel_5);

        //homebtn5
        ImageButton homebtn5=(ImageButton)findViewById(R.id.homebtn5);

        homebtn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent HomePage=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(HomePage);
            }
        });

        ImageView previous = (ImageView)findViewById(R.id.previous2);
        Button Go=(Button) findViewById(R.id.button6);

        Go.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){

                        openQuiz();
                    }

                }

        );



    }





    public void openQuiz(){

        Intent intent=new Intent(this,firstlevel_6.class);
        startActivity(intent);

    }


    public void openPreviousActivity(){

        Intent intent=new Intent(this,firstlevel_4.class);
        startActivity(intent);

    }



}
