package com.example.a96653.practice;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
//svsvbs

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences prefs = getSharedPreferences("prefs", MODE_PRIVATE);
        boolean firstStart = prefs.getBoolean("firstStart", true);

        if (firstStart) {
            launchSecondActivity();
        }

        ImageView ploto = (ImageView)findViewById(R.id.imageView3);

        ploto.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){

                        openPlotoActivity();
                    }

                }
                );
    }



    public void openPlotoActivity() {
        Intent intent = new Intent(this, firstlevel_1.class);
        startActivity(intent);


    }


    public void launchSecondActivity() {

        startActivity(new Intent(MainActivity.this,welcome_1.class));
        SharedPreferences prefs = getSharedPreferences("prefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putBoolean("firstStart", false);
        editor.apply();
    }

}
