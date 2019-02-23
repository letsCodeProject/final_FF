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

public class thirdlevel_22 extends AppCompatActivity {
    public static MySQLliteHelper sqLiteHelper;
    TextView target1,target2,target3,target4,target5,textviewCemicolon,textviewIf,textviewLessThen,textview2,textview5,pinCemicolon,pinIf,pinLessThen,pin2,pin5;
    int  res1=0,res2=0,res3=0 ,res4=0,res5=0,result, CHECK=0,tt1,tt2,tt3,tt4,tt5;
    static int questionResult,tg1=0,tg2=0,tg3=0,tg4=0,tg5=0;
    static TextView x1,x2,x3,x4,x5;
    static View vt1 ,vt2,vt3,vt4,vt5;

    Dialog myDialog;
    ImageButton next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thirdlevel_22);
        sqLiteHelper=new MySQLliteHelper(this);

        //TO VIEW SCORE ON BOX
        TextView textView = (TextView)findViewById(R.id.scoreBox_thirdlevel_22);
        textView.setText(sqLiteHelper.getChildScore()+"" );

        tt1=0;tt2=0;tt3=0;tt4=0;tt5=0;
        myDialog = new Dialog(this);
        CHECK=0;

        target1=(TextView)findViewById(R.id.target1);
        target2=(TextView)findViewById(R.id.target2);
        target3=(TextView)findViewById(R.id.target3);
        target4=(TextView)findViewById(R.id.target4);
        target5=(TextView)findViewById(R.id.target5);


        textviewCemicolon=(TextView)findViewById(R.id.textViewCemicolon);
        textviewIf=(TextView)findViewById(R.id.textViewIf);
        textviewLessThen=(TextView)findViewById(R.id.textViewLessThen);
        textview2 =(TextView)findViewById(R.id.textView2);
        textview5=(TextView)findViewById(R.id.textView5);

        pinCemicolon=(TextView)findViewById(R.id.pinCemicolon);
        pinIf=(TextView)findViewById(R.id.pinIf);
        pinLessThen=(TextView)findViewById(R.id.pinLessThen);
        pin2=(TextView)findViewById(R.id.pin2);
        pin5=(TextView)findViewById(R.id.pin5);


        textviewCemicolon.setOnLongClickListener(longClickListener);
        textviewIf.setOnLongClickListener(longClickListener);
        textviewLessThen.setOnLongClickListener(longClickListener);
        textview2.setOnLongClickListener(longClickListener);
        textview5.setOnLongClickListener(longClickListener);



        target1.setOnDragListener(dragListener);
        target2.setOnDragListener(dragListener);
        target3.setOnDragListener(dragListener);
        target4.setOnDragListener(dragListener);
        target5.setOnDragListener(dragListener);


        next = (ImageButton)findViewById(R.id.nextBTN_thirdlevel_22);

        next.setOnClickListener(
                new ImageView.OnClickListener(){
                    public void onClick(View v){

                        tt1=0;tt2=0;tt3=0;tt4=0;tt5=0;
                        if(textviewCemicolon.getX()==target1.getX())  tt5=1;
                        if(textviewCemicolon.getX()==target2.getX())  tt5=1;
                        if(textviewCemicolon.getX()==target3.getX())  tt5=1;
                        if(textviewCemicolon.getX()==target4.getX())  tt5=1;
                        if(textviewCemicolon.getX()==target5.getX())  tt5=1;


                        if(textviewIf.getX()==target1.getX())  tt1=1;
                        if(textviewIf.getX()==target2.getX())  tt1=1;
                        if(textviewIf.getX()==target3.getX())  tt1=1;
                        if(textviewIf.getX()==target4.getX())  tt1=1;
                        if(textviewIf.getX()==target5.getX())  tt1=1;


                        if(textviewLessThen.getX()==target1.getX())  tt3=1;
                        if(textviewLessThen.getX()==target2.getX())  tt3=1;
                        if(textviewLessThen.getX()==target3.getX())  tt3=1;
                        if(textviewLessThen.getX()==target4.getX())  tt3=1;
                        if(textviewLessThen.getX()==target5.getX())  tt3=1;

                        if(textview2.getX()==target1.getX())  tt2=1;
                        if(textview2.getX()==target2.getX())  tt2=1;
                        if(textview2.getX()==target3.getX())  tt2=1;
                        if(textview2.getX()==target4.getX())  tt2=1;
                        if(textview2.getX()==target5.getX())  tt2=1;

                        if(textview5.getX()==target1.getX())  tt4=1;
                        if(textview5.getX()==target2.getX())  tt4=1;
                        if(textview5.getX()==target3.getX())  tt4=1;
                        if(textview5.getX()==target4.getX())  tt4=1;
                        if(textview5.getX()==target5.getX())  tt4=1;


                        result=res1+res2+res3+res4+res5;

                        CHECK=tt1+tt2+tt3+tt4+tt5;
                        if(CHECK==5){



                            Toast.makeText(getApplicationContext(),
                                    Integer.toString(result),
                                    Toast.LENGTH_SHORT).show();
                            //updatedata();
                            Intent  intent = new Intent(getApplicationContext(),thirdlevel_23.class);


                            startActivity(intent);
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

                        if (view.getId() == R.id.textViewCemicolon && v.getId() == R.id.target1 && tg1 == 0) {
                            view.animate().x(target1.getX()).y(target1.getY()).setDuration(80).start();
                            vt1 = view;
                            x1 = pinCemicolon;
                            tg1=1;
                            res1=0;

                        }
                        if (view.getId() == R.id.textViewIf && v.getId() == R.id.target1 && tg1 == 0) {
                            view.animate().x(target1.getX()).y(target1.getY()).setDuration(80).start();
                            vt1 = view;
                            tg1=1;
                            x1 = pinIf;
                            res1=1;

                        }
                        if (view.getId() == R.id.textViewLessThen&& v.getId() == R.id.target1 && tg1 == 0) {
                            view.animate().x(target1.getX()).y(target1.getY()).setDuration(80).start();
                            vt1 = view;
                            tg1=1;
                            x1 = pinLessThen;
                            res1=0;

                        }
                        if (view.getId() == R.id.textView2&& v.getId() == R.id.target1 && tg1 == 0) {
                            view.animate().x(target1.getX()).y(target1.getY()).setDuration(80).start();
                            vt1 = view;
                            tg1=1;
                            x1 = pin2;
                            res1=0;

                        }
                        if (view.getId() == R.id.textView5&& v.getId() == R.id.target1 && tg1 == 0) {
                            view.animate().x(target1.getX()).y(target1.getY()).setDuration(80).start();
                            vt1 = view;
                            tg1=1;
                            x1 = pin5;
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

                        if (view.getId() == R.id.textViewCemicolon&& v.getId() == R.id.target2 && tg2 == 0) {
                            view.animate().x(target2.getX()).y(target2.getY()).setDuration(80).start();
                            vt2 = view;
                            tg2=1;
                            x2 = pinCemicolon;
                            res2=0;

                        }

                        if (view.getId() == R.id.textViewIf && v.getId() == R.id.target2 && tg2 == 0) {
                            view.animate().x(target2.getX()).y(target2.getY()).setDuration(80).start();
                            vt2 = view;
                            tg2=1;
                            x2 = pinIf;
                            res2=0;




                        }

                        if (view.getId() == R.id.textViewLessThen && v.getId() == R.id.target2 && tg2 == 0) {
                            view.animate().x(target2.getX()).y(target2.getY()).setDuration(80).start();
                            vt2 = view;
                            tg2=1;
                            x2 = pinLessThen;
                            res2=0;

                        }
                        if (view.getId() == R.id.textView2 && v.getId() == R.id.target2 && tg2 == 0) {
                            view.animate().x(target2.getX()).y(target2.getY()).setDuration(80).start();
                            vt2 = view;
                            tg2=1;
                            x2 = pin2;
                            res2=1;

                        }
                        if (view.getId() == R.id.textView5 && v.getId() == R.id.target2 && tg2 == 0) {
                            view.animate().x(target2.getX()).y(target2.getY()).setDuration(80).start();
                            vt2 = view;
                            tg2=1;
                            x2 = pin5;
                            res2=0;

                        }

                    }


                    //start target3


                    else if (v.getId() == R.id.target3) {


                        if (v.getId() == R.id.target3 & tg3 > 0) {tg3=0;
                            if(vt3.getX()==v.getX()){
                                vt3.animate().x(x3.getX()).y(x3.getY()).setDuration(80).start();
                            }
                        }

                        if (view.getId() == R.id.textViewCemicolon && v.getId() == R.id.target3 && tg3 == 0) {
                            view.animate().x(target3.getX()).y(target3.getY()).setDuration(80).start();
                            vt3 = view;
                            tg3=1;
                            x3 = pinCemicolon;
                            res3=0;

                        }

                        if (view.getId() == R.id.textViewIf&& v.getId() == R.id.target3 && tg3 == 0) {
                            view.animate().x(target3.getX()).y(target3.getY()).setDuration(80).start();
                            vt3 = view;
                            tg3=1;
                            x3 = pinIf;
                            res3=0;
                        }

                        if (view.getId() == R.id.textViewLessThen&& v.getId() == R.id.target3 && tg3 == 0) {
                            view.animate().x(target3.getX()).y(target3.getY()).setDuration(80).start();
                            vt3 = view;
                            tg3=1;
                            x3 = pinLessThen;
                            res3=1;

                        }
                        if (view.getId() == R.id.textView2&& v.getId() == R.id.target3 && tg3 == 0) {
                            view.animate().x(target3.getX()).y(target3.getY()).setDuration(80).start();
                            vt3 = view;
                            tg3=1;
                            x3 = pin2;
                            res3=0;

                        }
                        if (view.getId() == R.id.textView5&& v.getId() == R.id.target3 && tg3 == 0) {
                            view.animate().x(target3.getX()).y(target3.getY()).setDuration(80).start();
                            vt3 = view;
                            tg3=1;
                            x3 = pin5;
                            res3=0;

                        }
                    }


                    //start target4


                    else if (v.getId() == R.id.target4) {


                        if (v.getId() == R.id.target4 & tg4 > 0) {tg4=0;
                            if(vt4.getX()==v.getX()){
                                vt4.animate().x(x4.getX()).y(x4.getY()).setDuration(80).start();
                            }
                        }

                        if (view.getId() == R.id.textViewCemicolon && v.getId() == R.id.target4 && tg4 == 0) {
                            view.animate().x(target4.getX()).y(target4.getY()).setDuration(80).start();
                            vt4 = view;
                            tg4=1;
                            x4 = pinCemicolon;
                            res4=0;

                        }

                        if (view.getId() == R.id.textViewIf&& v.getId() == R.id.target4 && tg4 == 0) {
                            view.animate().x(target4.getX()).y(target4.getY()).setDuration(80).start();
                            vt4= view;
                            tg4=1;
                            x4 = pinIf;
                            res4=0;
                        }

                        if (view.getId() == R.id.textViewLessThen&& v.getId() == R.id.target4 && tg4 == 0) {
                            view.animate().x(target4.getX()).y(target4.getY()).setDuration(80).start();
                            vt4 = view;
                            tg4=1;
                            x4 = pinLessThen;
                            res4=0;

                        }
                        if (view.getId() == R.id.textView2&& v.getId() == R.id.target4 && tg4 == 0) {
                            view.animate().x(target4.getX()).y(target4.getY()).setDuration(80).start();
                            vt4 = view;
                            tg4=1;
                            x4 = pin2;
                            res4=0;

                        }
                        if (view.getId() == R.id.textView5&& v.getId() == R.id.target4 && tg4 == 0) {
                            view.animate().x(target4.getX()).y(target4.getY()).setDuration(80).start();
                            vt4 = view;
                            tg4=1;
                            x4= pin5;
                            res4=1;

                        }
                    }

                    //start target5


                    else if (v.getId() == R.id.target5) {


                        if (v.getId() == R.id.target5 & tg5 > 0) {tg5=0;
                            if(vt5.getX()==v.getX()){
                                vt5.animate().x(x5.getX()).y(x5.getY()).setDuration(80).start();
                            }
                        }

                        if (view.getId() == R.id.textViewCemicolon && v.getId() == R.id.target5 && tg5 == 0) {
                            view.animate().x(target5.getX()).y(target5.getY()).setDuration(80).start();
                            vt5 = view;
                            tg5=1;
                            x5= pinCemicolon;
                            res5=1;

                        }

                        if (view.getId() == R.id.textViewIf&& v.getId() == R.id.target5 && tg5 == 0) {
                            view.animate().x(target5.getX()).y(target5.getY()).setDuration(80).start();
                            vt5 = view;
                            tg5=1;
                            x5 = pinIf;
                            res5=0;
                        }

                        if (view.getId() == R.id.textViewLessThen&& v.getId() == R.id.target5 && tg5 == 0) {
                            view.animate().x(target5.getX()).y(target5.getY()).setDuration(80).start();
                            vt5 = view;
                            tg5=1;
                            x5 = pinLessThen;
                            res5=1;

                        }
                        if (view.getId() == R.id.textView2&& v.getId() == R.id.target5 && tg5 == 0) {
                            view.animate().x(target5.getX()).y(target5.getY()).setDuration(80).start();
                            vt5 = view;
                            tg5=1;
                            x5 = pin2;
                            res5=0;

                        }
                        if (view.getId() == R.id.textView5&& v.getId() == R.id.target5 && tg5 == 0) {
                            view.animate().x(target5.getX()).y(target5.getY()).setDuration(80).start();
                            vt5 = view;
                            tg5=1;
                            x5 = pin5;
                            res5=0;

                        }
                    }
            }
            return true;
        }
    };


    public void reOrder(View view) {
        textviewCemicolon.animate().x(pinCemicolon.getX()).y(pinCemicolon.getY()).setDuration(100).start();tt1=0;
        textviewIf.animate().x(pinIf.getX()).y(pinIf.getY()).setDuration(100).start();tt2=0;
        textviewLessThen.animate().x(pinLessThen.getX()).y(pinLessThen.getY()).setDuration(100).start();tt3=0;
        textview2.animate().x(pin2.getX()).y(pin2.getY()).setDuration(100).start();tt4=0;
        textview5.animate().x(pin5.getX()).y(pin5.getY()).setDuration(100).start();tt5=0;

        res1=0;res2=0;res3=0;res4=0;res5=0;




    }
    public void ShowPopup(View v) {

        Button btnClose;
        myDialog.setContentView(R.layout.hint3_3);
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
   /* public void updatedata() {
        result = res1 + res2 + res3+res4+res5 ;
        // sqLiteHelper.UpdateQuestionAnswer(1,1);
        if (result == 5) {
            sqLiteHelper.UpdateQuestionAnswer(10,1);
        }
        else
            sqLiteHelper.UpdateQuestionAnswer(10,0);


    }*/

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


