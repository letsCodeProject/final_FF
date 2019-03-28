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
import android.widget.Toast;

public class secondlevel_20 extends AppCompatActivity {
    public  static  MySQLliteHelper sqLiteHelper;
    TextView target1,target2,target3,textviewX,textview18,textviewEqual,pinX,pin18,pinEqual;
    int  res1=0,res2=0,res3=0 ,result, CHECK=0,tt1,tt2,tt3;
    static int questionResult,tg1=0,tg2=0,tg3=0;
    static TextView x1,x2,x3;
    static View vt1 ,vt2,vt3;

    Dialog myDialog;
    ImageButton next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondlevel_20);
        sqLiteHelper=new MySQLliteHelper(this);

        //TO VIEW SCORE ON BOX
        TextView textView = (TextView)findViewById(R.id.ScoreBox_secondlevel_21);
        textView.setText(sqLiteHelper.getChildScore()+"" );


        tt1=0;tt2=0;tt3=0;
        myDialog = new Dialog(this);
        CHECK=0;
        target1=(TextView)findViewById(R.id.target1);
        target2=(TextView)findViewById(R.id.target2);
        target3=(TextView)findViewById(R.id.target3);

        textviewX=(TextView)findViewById(R.id.textviewX);
        textviewEqual=(TextView)findViewById(R.id.textviewEqual);
        textview18=(TextView)findViewById(R.id.textview18);

        pinX=(TextView)findViewById(R.id.pinX);
        pinEqual=(TextView)findViewById(R.id.pinEqual);
        pin18=(TextView)findViewById(R.id.pin18);



        textviewX.setOnLongClickListener(longClickListener);
        textviewEqual.setOnLongClickListener(longClickListener);
        textview18.setOnLongClickListener(longClickListener);


        target1.setOnDragListener(dragListener);
        target2.setOnDragListener(dragListener);
        target3.setOnDragListener(dragListener);

//________________________________________ DRAG AND DROP ____________________________________________

//___________Go to the next Question
        next = (ImageButton)findViewById(R.id.nextBTN_secondlevel_20);

        next.setOnClickListener(
                new ImageView.OnClickListener(){
                    public void onClick(View v){

//___________ Ensure all of the Blocks are in place
//________________ Ensure Block X is being placed in one of 3 targets .
                        tt1=0;tt2=0;tt3=0;
                        if(textviewX.getX()==target1.getX())  tt1=1;
                        if(textviewX.getX()==target2.getX())  tt1=1;
                        if(textviewX.getX()==target3.getX())  tt1=1;
//________________ Ensure Block 18 is being placed in one of 3 targets .
                        if(textview18.getX()==target1.getX())  tt3=1;
                        if(textview18.getX()==target2.getX())  tt3=1;
                        if(textview18.getX()==target3.getX())  tt3=1;
//________________ Ensure Block 18 is being placed in one of 3 targets
                        if(textviewEqual.getX()==target1.getX())  tt2=1;
                        if(textviewEqual.getX()==target2.getX())  tt2=1;
                        if(textviewEqual.getX()==target3.getX())  tt2=1;

//________________ Ensure the question is solved
                        result=res1+res2+res3;
                        CHECK=tt1+tt2+tt3;

                        if(CHECK==3){
//________________ Shared Preferences
                            SharedPreferences prefs = getSharedPreferences("pref_secondlevel_20", MODE_PRIVATE);
                            boolean firstStart = prefs.getBoolean("firstStart", true);
                            if (firstStart) {
                                sqLiteHelper.UpdateNumOfLesson(25, "Nepton");
                                SharedPreferences pref = getSharedPreferences("pref_secondlevel_20", MODE_PRIVATE);
                                SharedPreferences.Editor editor = prefs.edit();
                                editor.putBoolean("firstStart", false);
                                editor.apply(); }

                            updatedata();
                            Intent  intent = new Intent(getApplicationContext(),secondlevel_22.class);


                            startActivity(intent);

                        }
                        else{
//________________ if the question is not complete Show error message
                            ShowPopupSolve();
                        }




                    }

                }

        );






    }


    View.OnLongClickListener  longClickListener= new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View v) {
            ClipData data=ClipData.newPlainText("","");
            View.DragShadowBuilder myShadowBuilder=new  View.DragShadowBuilder(v);
            v.startDrag(data,myShadowBuilder,v,0);

            return true;
        }};
//________________________________________ DRAG AND DROP ___________________________________________
    View.OnDragListener dragListener= new View.OnDragListener() {
        @Override
        public boolean onDrag(View v, DragEvent event) {
            questionResult = 0;
            int dragEvent = event.getAction();
            final View view = (View) event.getLocalState();
            switch (dragEvent) {
                case DragEvent.ACTION_DROP:
//________________ Check target 1

                    if (v.getId() == R.id.target1) {

//___If target already has a block and child is attempting to drag another block in the same target.
//return the first block back
                        if (v.getId() == R.id.target1 && tg1 > 0) {  tg1=0;
                            if(vt1.getX()==v.getX()){
                                vt1.animate().x(x1.getX()).y(x1.getY()).setDuration(80).start(); }}
//___If the block is dragged to the right target assign result to 1 .
                        if (view.getId() == R.id.textviewX && v.getId() == R.id.target1 && tg1 == 0) {
                            view.animate().x(target1.getX()).y(target1.getY()).setDuration(80).start();
                            vt1 = view;
                            x1 = pinX;
                            tg1=1;
                            res1=1;}
//___If the block is dragged to the wrong target assign result to 0 .
                        if (view.getId() == R.id.textview18 && v.getId() == R.id.target1 && tg1 == 0) {
                            view.animate().x(target1.getX()).y(target1.getY()).setDuration(80).start();
                            vt1 = view;
                            tg1=1;
                            x1 = pin18;
                            res1=0; }
//___If the block is dragged to the wrong target assign result to 0 .
                        if (view.getId() == R.id.textviewEqual && v.getId() == R.id.target1 && tg1 == 0) {
                            view.animate().x(target1.getX()).y(target1.getY()).setDuration(80).start();
                            vt1 = view;
                            tg1=1;
                            x1 = pinEqual;
                            res1=0; } }


                    //start target2

                    else if (v.getId() == R.id.target2) {


                        if (v.getId() == R.id.target2 & tg2 > 0) {  tg2=0;
                            if( vt2.getX()==v.getX()){
                                vt2.animate().x(x2.getX()).y(x2.getY()).setDuration(80).start();
                            }

                        }

                        if (view.getId() == R.id.textviewX && v.getId() == R.id.target2 && tg2 == 0) {
                            view.animate().x(target2.getX()).y(target2.getY()).setDuration(80).start();
                            vt2 = view;
                            tg2=1;
                            x2 = pinX;
                            res2=0;

                        }

                        if (view.getId() == R.id.textview18 && v.getId() == R.id.target2 && tg2 == 0) {
                            view.animate().x(target2.getX()).y(target2.getY()).setDuration(80).start();
                            vt2 = view;
                            tg2=1;
                            x2 = pin18;
                            res2=0;




                        }

                        if (view.getId() == R.id.textviewEqual && v.getId() == R.id.target2 && tg2 == 0) {
                            view.animate().x(target2.getX()).y(target2.getY()).setDuration(80).start();
                            vt2 = view;
                            tg2=1;
                            x2 = pinEqual;
                            res2=1;

                        }

                    }


                    //start target3


                    else if (v.getId() == R.id.target3) {


                        if (v.getId() == R.id.target3 & tg3 > 0) {tg3=0;
                            if(vt3.getX()==v.getX()){
                                vt3.animate().x(x3.getX()).y(x3.getY()).setDuration(80).start();
                            }
                        }

                        if (view.getId() == R.id.textviewX && v.getId() == R.id.target3 && tg3 == 0) {
                            view.animate().x(target3.getX()).y(target3.getY()).setDuration(80).start();
                            vt3 = view;
                            tg3=1;
                            x3 = pinX;
                            res3=0;

                        }

                        if (view.getId() == R.id.textview18 && v.getId() == R.id.target3 && tg3 == 0) {
                            view.animate().x(target3.getX()).y(target3.getY()).setDuration(80).start();
                            vt3 = view;
                            tg3=1;
                            x3 = pin18;
                            res3=1;
                        }

                        if (view.getId() == R.id.textviewEqual && v.getId() == R.id.target3 && tg3 == 0) {
                            view.animate().x(target3.getX()).y(target3.getY()).setDuration(80).start();
                            vt3 = view;
                            tg3=1;
                            x3 = pinEqual;
                            res3=0;

                        }
                    }

            }
            return true;
        }
    };



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


    public void reOrder(View view) {
        textviewX.animate().x(pinX.getX()).y(pinX.getY()).setDuration(100).start();tt1=0;
        textview18.animate().x(pin18.getX()).y(pin18.getY()).setDuration(100).start();tt2=0;
        textviewEqual.animate().x(pinEqual.getX()).y(pinEqual.getY()).setDuration(100).start();tt3=0;
        res1=0;res2=0;res3=0;




    }

    public void ShowPopup(View v) {

        Button btnClose;
        myDialog.setContentView(R.layout.hint2_2);
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
    public void btnHome(View view) {


        Intent HomePage=new Intent(getApplicationContext(),MainActivity.class);
        startActivity(HomePage);

    }
    public void updatedata() {
        result = res1 + res2 + res3 ;
        // sqLiteHelper.UpdateQuestionAnswer(1,1);
        if (result == 3) {
            sqLiteHelper.UpdateQuestionAnswer(4,1);
        }
        else
            sqLiteHelper.UpdateQuestionAnswer(4,0);


    }

}

