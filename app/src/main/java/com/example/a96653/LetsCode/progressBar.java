package com.example.a96653.LetsCode;

import android.content.Context;
import android.content.Intent;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.ProgressBar;
import android.widget.TextView;



public class progressBar extends Animation {
    private Context context;
    private TextView textView;
    private ProgressBar progressBar;
    private float from ;
    private float to;
    MySQLliteHelper mySqliteOpenHelper;

    public progressBar (Context context,ProgressBar progressBar,TextView textView,Float from,Float to){

        this.context=context;
        this.progressBar=progressBar;
        this.textView=textView;
        this.from=from;
        this.to=to;
        mySqliteOpenHelper=new MySQLliteHelper(context);

    }

    @Override
    /*protected void applyTransformation(float interpolatedTime, Transformation t) {
        super.applyTransformation(interpolatedTime, t);
        float value = from+ (to-from)*interpolatedTime;
        progressBar.setProgress((int)value);
        textView.setText((int)value+" %");
        if(value==to){
            context.startActivity(new Intent(context,MainActivity.class));
        }
    }*/


    protected void applyTransformation(float interpolatedTime, Transformation t) {
        super.applyTransformation(interpolatedTime, t);
        float value = from + (to - from) * interpolatedTime;
        progressBar.setProgress((int) value);
        textView.setText((int) value + " %");
        if (value == to) {

            String str = mySqliteOpenHelper.databaseToString();

            if (str.equals("welcome1"))
                context.startActivity(new Intent(context, welcome_1.class));
            if (str.equals("welcome2"))
                context.startActivity(new Intent(context, welcome_2.class));
            if (str.equals("welcome3"))
                context.startActivity(new Intent(context, welcome_3.class));
            if (str.equals("welcome4"))
                context.startActivity(new Intent(context, welcome_4.class));
            if (str.equals("welcome5"))
                context.startActivity(new Intent(context, welcome_5.class));
            if (str.equals("welcome6"))
                context.startActivity(new Intent(context, welcome_6.class));
            if (str.equals("welcome7"))
                context.startActivity(new Intent(context, welcome_7.class));
            if (str.equals("main"))
                context.startActivity(new Intent(context, MainActivity.class));

        }
    }
    }