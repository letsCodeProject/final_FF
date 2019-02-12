package com.example.a96653.LetsCode;

import android.app.Dialog;
import android.content.ClipData;
import android.content.Intent;
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

public class secondlevel_26 extends AppCompatActivity {


    public static MySQLliteHelper sqLiteHelper;
    TextView target1,target2,target3,textviewX,textviewY,textviewSum,pinX,pinY,pinSum;
    int  res1=0,res2=0,res3=0 ,result, CHECK=0,tt1,tt2,tt3;
    static int questionResult,tg1=0,tg2=0,tg3=0;
    static TextView x1,x2,x3;
    static View vt1 ,vt2,vt3;

    Dialog myDialog;
    ImageButton next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondlevel_26);
        MySQLliteHelper sqLiteHelper=new MySQLliteHelper(this);

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
        textviewY=(TextView)findViewById(R.id.textviewY);
        textviewSum=(TextView)findViewById(R.id.textviewSum);


        pinX=(TextView)findViewById(R.id.pinX);
        pinY=(TextView)findViewById(R.id.pinY);
        pinSum=(TextView)findViewById(R.id.pinSum);




        textviewX.setOnLongClickListener(longClickListener);
        textviewY.setOnLongClickListener(longClickListener);
        textviewSum.setOnLongClickListener(longClickListener);



        target1.setOnDragListener(dragListener);
        target2.setOnDragListener(dragListener);
        target3.setOnDragListener(dragListener);




        next = (ImageButton)findViewById(R.id.nextBTN);

        next.setOnClickListener(
                new ImageView.OnClickListener(){
                    public void onClick(View v){

                        tt1=0;tt2=0;tt3=0;
                        if(textviewX.getX()==target1.getX())  tt1=1;
                        if(textviewX.getX()==target2.getX())  tt1=1;
                        if(textviewX.getX()==target3.getX())  tt1=1;


                        if(textviewY.getX()==target1.getX())  tt3=1;
                        if(textviewY.getX()==target2.getX())  tt3=1;
                        if(textviewY.getX()==target3.getX())  tt3=1;


                        if(textviewSum.getX()==target1.getX())  tt2=1;
                        if(textviewSum.getX()==target2.getX())  tt2=1;
                        if(textviewSum.getX()==target3.getX())  tt2=1;


                        result=res1+res2+res3;

                        CHECK=tt1+tt2+tt3;
                        if(CHECK==3){



                            Toast.makeText(getApplicationContext(),
                                    Integer.toString(result),
                                    Toast.LENGTH_SHORT).show();


                        }
                        else{

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

    View.OnDragListener dragListener= new View.OnDragListener() {
        @Override
        public boolean onDrag(View v, DragEvent event) {
            questionResult = 0;
            int dragEvent = event.getAction();
            final View view = (View) event.getLocalState();

            switch (dragEvent) {//





                case DragEvent.ACTION_DROP:

                    //start target
                    if (v.getId() == R.id.target1) {


                        if (v.getId() == R.id.target1 && tg1 > 0) {  tg1=0;
                            if(vt1.getX()==v.getX()){
                                vt1.animate().x(x1.getX()).y(x1.getY()).setDuration(80).start();
                            }

                        }

                        if (view.getId() == R.id.textviewX && v.getId() == R.id.target1 && tg1 == 0) {
                            view.animate().x(target1.getX()).y(target1.getY()).setDuration(80).start();
                            vt1 = view;
                            x1 = pinX;
                            tg1=1;
                            res1++;

                        }
                        if (view.getId() == R.id.textviewY && v.getId() == R.id.target1 && tg1 == 0) {
                            view.animate().x(target1.getX()).y(target1.getY()).setDuration(80).start();
                            vt1 = view;
                            tg1=1;
                            x1 = pinY;
                            res1=0;



                        }
                        if (view.getId() == R.id.textviewSum && v.getId() == R.id.target1 && tg1 == 0) {
                            view.animate().x(target1.getX()).y(target1.getY()).setDuration(80).start();
                            vt1 = view;
                            tg1=1;
                            x1 = pinSum;
                            res1=0;

                        }


                    }


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

                        if (view.getId() == R.id.textviewY && v.getId() == R.id.target2 && tg2 == 0) {
                            view.animate().x(target2.getX()).y(target2.getY()).setDuration(80).start();
                            vt2 = view;
                            tg2=1;
                            x2 = pinY;
                            res2=0;




                        }

                        if (view.getId() == R.id.textviewSum && v.getId() == R.id.target2 && tg2 == 0) {
                            view.animate().x(target2.getX()).y(target2.getY()).setDuration(80).start();
                            vt2 = view;
                            tg2=1;
                            x2 = pinSum;
                            res2++;

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

                        if (view.getId() == R.id.textviewY&& v.getId() == R.id.target3 && tg3 == 0) {
                            view.animate().x(target3.getX()).y(target3.getY()).setDuration(80).start();
                            vt3 = view;
                            tg3=1;
                            x3 = pinY;
                            res3++;
                        }

                        if (view.getId() == R.id.textviewSum && v.getId() == R.id.target3 && tg3 == 0) {
                            view.animate().x(target3.getX()).y(target3.getY()).setDuration(80).start();
                            vt3 = view;
                            tg3=1;
                            x3 = pinSum;
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
        textviewY.animate().x(pinY.getX()).y(pinY.getY()).setDuration(100).start();tt2=0;
        textviewSum.animate().x(pinSum.getX()).y(pinSum.getY()).setDuration(100).start();tt3=0;
        res1=0;res2=0;res3=0;




    }

    public void ShowPopup(View v) {

        Button btnClose;
        myDialog.setContentView(R.layout.hint2_5);
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

}
