package com.example.a96653.LetsCode;

import android.app.Dialog;
import android.content.ClipData;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;


public class thirdlevel_20_question1 extends AppCompatActivity{

    public static MySQLliteHelper sqLiteHelper;
    TextView target1, target2, target3, false_answer, true_answer2,true_answer1, pintarget1, pintarget2, pintarget3;
    int res1 = 0, res2 = 0, res3 = 0, result, CHECK = 0, tt1, tt2, tt3;
    static int questionResult, tg1 = 0, tg2 = 0, tg3 = 0;
    static TextView x1, x2, x3;
    static View vt1, vt2, vt3;

    Dialog myDialog;
    ImageView next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thirdlevel_20_question1);


        sqLiteHelper = new MySQLliteHelper(this);

        //TO VIEW SCORE ON BOX
        TextView textView = (TextView)findViewById(R.id.scoreBox_thirdlevel_20);
        textView.setText(sqLiteHelper.getChildScore()+"" );

        //HOME BUTTON
        ImageButton homebtn3 = (ImageButton) findViewById(R.id.homebtn_thirdleve20);
        homebtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent HomePage = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(HomePage);
            }
        });






        tt1 = 0;
        tt2 = 0;
        tt3 = 0;
        myDialog = new Dialog(this);
        CHECK = 0;

        target1 = (TextView) findViewById(R.id.target1);
        target2 = (TextView) findViewById(R.id.target2);
        target3 = (TextView) findViewById(R.id.target3);


        false_answer = (TextView) findViewById(R.id.false_answer);
        true_answer1 = (TextView) findViewById(R.id.true_answer1);
        true_answer2 = (TextView) findViewById(R.id.true_ansewr2);


        //Pin
        pintarget1 = (TextView) findViewById(R.id.pintfalse);
        pintarget2 = (TextView) findViewById(R.id.pinttrue);
        pintarget3 = (TextView) findViewById(R.id.pinttrue2);



        false_answer.setOnLongClickListener(longClickListener);
        true_answer1.setOnLongClickListener(longClickListener);
        true_answer2.setOnLongClickListener(longClickListener);


        target1.setOnDragListener(dragListener);
        target2.setOnDragListener(dragListener);
        target3.setOnDragListener(dragListener);


        next = (ImageView) findViewById(R.id.thirdlevel_20_next);

        next.setOnClickListener(
                new ImageView.OnClickListener(){
                    public void onClick(View v){

                        tt1=0;tt2=0;tt3=0;
                        if(false_answer.getX()==target1.getX())  tt1=1;
                        if(false_answer.getX()==target2.getX())  tt1=1;
                        if(false_answer.getX()==target3.getX())  tt1=1;


                        if(true_answer1.getX()==target1.getX())  tt2=1;
                        if(true_answer1.getX()==target2.getX())  tt2=1;
                        if(true_answer1.getX()==target3.getX())  tt2=1;


                        if(true_answer2.getX()==target1.getX())  tt3=1;
                        if(true_answer2.getX()==target2.getX())  tt3=1;
                        if(true_answer2.getX()==target3.getX())  tt3=1;



                        result=res1+res2+res3;
                        CHECK=tt1+tt2+tt3;
                        if(CHECK==3){

                            updatedata();
                            Intent intent = new Intent(getApplicationContext(),thirdlevel_22.class);
                            startActivity(intent);
                            SharedPreferences prefs = getSharedPreferences("pref_thirdLevel_22", MODE_PRIVATE);
                            boolean firstStart = prefs.getBoolean("firstStart", true);
                            if (firstStart){
                                sqLiteHelper.UpdateNumOfLesson(50,"Saturn");
                                SharedPreferences pref = getSharedPreferences("pref_thirdLevel_22", MODE_PRIVATE);
                                SharedPreferences.Editor editor = prefs.edit();
                                editor.putBoolean("firstStart", false);
                                editor.apply();}
                        }


                        else{

                            ShowPopupSolve();
                        }




                    }

                }

        );



    }






    View.OnLongClickListener longClickListener = new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View v) {
            ClipData data = ClipData.newPlainText("", "");
            View.DragShadowBuilder myShadowBuilder = new View.DragShadowBuilder(v);
            v.startDrag(data, myShadowBuilder, v, 0);

            return true;
        }
    };

    View.OnDragListener dragListener = new View.OnDragListener() {
        @Override
        public boolean onDrag(View v, DragEvent event) {
            questionResult = 0;
            int dragEvent = event.getAction();
            final View view = (View) event.getLocalState();

            switch (dragEvent) {//


                case DragEvent.ACTION_DROP:

                    //start target
                    if (v.getId() == R.id. target1) {


                        if (v.getId() == R.id. target1 && tg1 > 0) {
                            tg1 = 0;
                            if (vt1.getX() == v.getX()) {
                                vt1.animate().x(x1.getX()).y(x1.getY()).setDuration(80).start();
                            }

                        }

                        if (view.getId() == R.id.false_answer && v.getId() == R.id.target1 && tg1 == 0) {
                            view.animate().x( target1.getX()).y( target1.getY()).setDuration(80).start();
                            vt1 = view;
                            x1 = pintarget1;
                            tg1 = 1;
                            res1 = 1;

                        }
                        if (view.getId() == R.id.true_answer1 && v.getId() == R.id. target1 && tg1 == 0) {
                            view.animate().x( target1.getX()).y( target1.getY()).setDuration(80).start();
                            vt1 = view;
                            tg1 = 1;
                            x1 =pintarget2;
                            res1 = 0;

                        }
                        if (view.getId() == R.id.true_ansewr2 && v.getId() == R.id.target1 && tg1 == 0) {
                            view.animate().x(target1.getX()).y(target1.getY()).setDuration(80).start();
                            vt1 = view;
                            tg1 = 1;
                            x1 = pintarget3;
                            res1 = 0;

                        }


                    }

                    //start target2

                    else if (v.getId() == R.id.target2) {


                        if (v.getId() == R.id.target2&& tg2 > 0) {
                            tg2 = 0;
                            if (vt2.getX() == v.getX()) {
                                vt2.animate().x(x2.getX()).y(x2.getY()).setDuration(80).start();
                            }

                        }

                        if (view.getId() == R.id.true_answer1 && v.getId() == R.id.target2 && tg2 == 0) {
                            view.animate().x(target2.getX()).y(target2.getY()).setDuration(80).start();
                            vt2 = view;
                            tg2 = 1;
                            x2 = pintarget2;
                            res2 = 1;

                        }

                        if (view.getId() == R.id.false_answer && v.getId() == R.id.target2 && tg2 == 0) {
                            view.animate().x(target2.getX()).y(target2.getY()).setDuration(80).start();
                            vt2 = view;
                            tg2 = 1;
                            x2 = pintarget1;
                            res2 = 0;


                        }

                        if (view.getId() == R.id.true_ansewr2 && v.getId() == R.id.target2 && tg2 == 0) {
                            view.animate().x(target2.getX()).y(target2.getY()).setDuration(80).start();
                            vt2 = view;
                            tg2 = 1;
                            x2 = pintarget3;
                            res2 = 1;

                        }

                    }


                    //start target3


                    else if (v.getId() == R.id.target3) {


                        if (v.getId() == R.id.target3& tg3 > 0) {
                            tg3 = 0;
                            if (vt3.getX() == v.getX()) {
                                vt3.animate().x(x3.getX()).y(x3.getY()).setDuration(80).start();
                            }
                        }

                        if (view.getId() == R.id.true_ansewr2 && v.getId() == R.id.target3&& tg3 == 0) {
                            view.animate().x(target3.getX()).y(target3.getY()).setDuration(80).start();
                            vt3 = view;
                            tg3 = 1;
                            x3 = pintarget3;
                            res3 = 1;

                        }

                        if (view.getId() == R.id.true_answer1 && v.getId() == R.id.target3 && tg3 == 0) {
                            view.animate().x(target3.getX()).y(target3.getY()).setDuration(80).start();
                            vt3 = view;
                            tg3 = 1;
                            x3 = pintarget2;
                            res3 = 1;
                        }

                        if (view.getId() == R.id.false_answer && v.getId() == R.id.target3 && tg3 == 0) {
                            view.animate().x(target3.getX()).y(target3.getY()).setDuration(80).start();
                            vt3 = view;
                            tg3 = 1;
                            x3 = pintarget1;
                            res3 = 0;

                        }

                    }

            }
            return true;
        }

    };


    public void ShowPopup(View v) {

        Button btnClose;
        myDialog.setContentView(R.layout.hint3_1);
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

    public void updatedata() {
        result = res1 + res2 + res3;
        // sqLiteHelper.UpdateQuestionAnswer(1,1);
        if (result == 3) {
            sqLiteHelper.UpdateQuestionAnswer(8,1);
        }
        else
            sqLiteHelper.UpdateQuestionAnswer(8,0);

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

