package com.example.a96653.LetsCode;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.TextView;


public class MainActivity_Loading extends AppCompatActivity {

    ProgressBar progressBar;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        progressBar =findViewById(R.id.progress_bar);
        textView=findViewById(R.id.precentageTextView);

        progressBar.setMax(100);
        progressBar.setScaleY(3f);

        progressBarAnimation();}

    public void progressBarAnimation(){
        progressBar anim =new progressBar(this,progressBar,textView,0f,100f);
        anim.setDuration(8000);
        progressBar.setAnimation(anim);

    }



}

