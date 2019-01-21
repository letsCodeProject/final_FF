package com.example.a96653.practice;

import android.content.Context;
import android.content.Intent;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.ProgressBar;
import android.widget.TextView;
        import android.content.Context;
        import android.content.Intent;
        import android.view.animation.Animation;
        import android.view.animation.Transformation;
        import android.widget.ProgressBar;
        import android.widget.TextView;

        //just try

public class progressBar extends Animation {
    private Context context;
    private TextView textView;
    private ProgressBar progressBar;
    private float from ;
    private float to;

    public progressBar (Context context,ProgressBar progressBar,TextView textView,Float from,Float to){
        this.context=context;
        this.progressBar=progressBar;
        this.textView=textView;
        this.from=from;
        this.to=to;
    }

    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        super.applyTransformation(interpolatedTime, t);
        float value = from+ (to-from)*interpolatedTime;
        progressBar.setProgress((int)value);
        textView.setText((int)value+" %");
        if(value==to){
            context.startActivity(new Intent(context,welcome_1.class));
        }
    }
}
