package com.example.a96653.LetsCode;


import android.app.Dialog;
import android.content.ClipData;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
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


public class firstlevel_7 extends AppCompatActivity {

    public static MySQLliteHelper sqLiteHelper;
    TextView target1,target2,target3,target4,textRight,textLeft,print,pinRight,pinLeft,pinPrint,pinPluto,check;
    ImageView goodbyepluto;
    static View vt1 ,vt2,vt3,vt4,pg=null,rg=null,lg=null,gg=null;
    float VX1=0,VX2=0,VX3=0;
    static TextView x1,x2,x3,x4;
    int  res1=0,res2=0,res3=0,res4=0 ,result,CH1=0,CH2=0,CH3=0,CH4=0,CHECK=0,p=0,g=0,l=0,r=0,FINAL=0;
    static int questionResult,tg1=0,tg2=0,tg3=0,tg4=0;
    Dialog myDialog;
    ImageButton next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firstlevel_7  );
        sqLiteHelper = new MySQLliteHelper(this);


        myDialog = new Dialog(this);

        target1=(TextView)findViewById(R.id.target1);
        target2=(TextView)findViewById(R.id.target2);
        target3=(TextView)findViewById(R.id.target3);
        target4=(TextView)findViewById(R.id.target4);


        textRight=(TextView)findViewById(R.id.textright);
        textLeft=(TextView)findViewById(R.id.textleft);
        print=(TextView)findViewById(R.id.print);
        goodbyepluto=(ImageView)findViewById(R.id.goodbyepluto);



        pinRight=(TextView)findViewById(R.id.pinRight);
        pinLeft=(TextView)findViewById(R.id.pinLeft);
        pinPrint=(TextView)findViewById(R.id.pinPrint);
        pinPluto=(TextView)findViewById(R.id.pinPluto);

        textRight.setOnLongClickListener(longClickListener);
        textLeft.setOnLongClickListener(longClickListener);
        print.setOnLongClickListener(longClickListener);
        goodbyepluto.setOnLongClickListener(longClickListener);


        target1.setOnDragListener(dragListener);
        target2.setOnDragListener(dragListener);
        target3.setOnDragListener(dragListener);
        target4.setOnDragListener(dragListener);


        next = (ImageButton)findViewById(R.id.nextBTN);

        next.setOnClickListener(
                new ImageView.OnClickListener(){
                    public void onClick(View v){

                        SharedPreferences prefs = getSharedPreferences("pref12", MODE_PRIVATE);
                        boolean firstStart = prefs.getBoolean("firstStart", true);
                        if (firstStart){
                            sqLiteHelper.UpdateNumOfLesson(7,"Ploto");
                            SharedPreferences pref = getSharedPreferences("prefs12", MODE_PRIVATE);
                            SharedPreferences.Editor editor = prefs.edit();
                            editor.putBoolean("firstStart", false);
                            editor.apply();}

                       /* Toast.makeText(firstlevel_7.this, Integer.toString(result)  ,
                                Toast.LENGTH_LONG).show();*/
                        updatedata();
                        Intent intent= new Intent(getApplicationContext(),firstlevel_resultsheet.class);
                        startActivity(intent);


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

                case DragEvent.ACTION_DRAG_ENTERED:


                    break;



                case DragEvent.ACTION_DROP:

                    //start target
                    if (v.getId() == R.id.target1) {


                        if (v.getId() == R.id.target1 && tg1 > 0) {  tg1=0;
                            if(vt1.getX()==v.getX()){
                                vt1.animate().x(x1.getX()).y(x1.getY()).setDuration(150).start();



                                if(vt1.getId() == R.id.textright ){CH1=0; }


                                else if(vt1.getId() == R.id.print ){CH2=0; }

                                else if(vt1.getId() == R.id.goodbyepluto ){CH3=0;  }

                                else if(vt1.getId() == R.id.textleft ){CH4=0;  }}

                        }

                        if (view.getId() == R.id.textright && v.getId() == R.id.target1 && tg1 == 0) {
                            view.animate().x(target1.getX()).y(target1.getY()).setDuration(150).start();
                            vt1 = view;VX1=v.getX();VX2=view.getX();
                            x1 = pinRight;CH1=1;
                            tg1=1;

                            rg=v;


                        }
                        if (view.getId() == R.id.print && v.getId() == R.id.target1 && tg1 == 0) {
                            view.animate().x(target1.getX()).y(target1.getY()).setDuration(150).start();
                            vt1 = view;
                            tg1=1;CH2=1;
                            x1 = pinPrint;
                            res1++;

                            pg=v;

                        }
                        if (view.getId() == R.id.goodbyepluto && v.getId() == R.id.target1 && tg1 == 0) {
                            view.animate().x(target1.getX()).y(target1.getY()).setDuration(150).start();
                            vt1 = view;
                            tg1=1;CH3=1;
                            x1 = pinPluto;
                            res1=0;

                            gg=v;


                        }
                        if (view.getId() == R.id.textleft && v.getId() == R.id.target1 && tg1 == 0) {
                            view.animate().x(target1.getX()).y(target1.getY()).setDuration(150).start();
                            vt1 = view;
                            tg1=1;CH4=1;
                            x1 = pinLeft;
                            res1=0;

                            lg=v;

                        }


                    }


                    //start target2

                    else if (v.getId() == R.id.target2) {


                        if (v.getId() == R.id.target2 & tg2 > 0) {  tg2=0;
                            if( vt2.getX()==v.getX()){
                                vt2.animate().x(x2.getX()).y(x2.getY()).setDuration(150).start();



                                if(vt2.getId() == R.id.textright ){CH1=0; }

                                else if(vt2.getId() == R.id.print ){CH2=0; }

                                else if(vt2.getId() == R.id.goodbyepluto ){CH3=0; }

                                else if(vt2.getId() == R.id.textleft ){CH4=0; }}

                        }

                        if (view.getId() == R.id.textright && v.getId() == R.id.target2 && tg2 == 0) {
                            view.animate().x(target2.getX()).y(target2.getY()).setDuration(150).start();
                            vt2 = view;
                            tg2=1;CH1=1;
                            x2 = pinRight;
                            res2++;
                            rg=v;
                        }

                        if (view.getId() == R.id.print && v.getId() == R.id.target2 && tg2 == 0) {
                            view.animate().x(target2.getX()).y(target2.getY()).setDuration(150).start();
                            vt2 = view;VX3=view.getX();
                            tg2=1;CH2=1;
                            x2 = pinPrint;
                            res2=0;
                            pg=v;



                        }

                        if (view.getId() == R.id.goodbyepluto && v.getId() == R.id.target2 && tg2 == 0) {
                            view.animate().x(target2.getX()).y(target2.getY()).setDuration(150).start();
                            vt2 = view;
                            tg2=1;CH3=1;
                            x2 = pinPluto;
                            res2=0;

                            gg=v;

                        }

                        if (view.getId() == R.id.textleft && v.getId() == R.id.target2 && tg2 == 0) {
                            view.animate().x(target2.getX()).y(target2.getY()).setDuration(150).start();
                            vt2 = view;
                            tg2=1;CH4=1;
                            x2 = pinLeft;
                            res2=0;

                            lg=v;


                        }
                    }


                    //start target3


                    else if (v.getId() == R.id.target3) {


                        if (v.getId() == R.id.target3 & tg3 > 0) {tg3=0;
                            if(vt3.getX()==v.getX()){
                                vt3.animate().x(x3.getX()).y(x3.getY()).setDuration(150).start();



                                if(vt3.getId() == R.id.textright ){CH1=0;}

                                else if(vt3.getId() == R.id.print ){CH2=0; }

                                else if(vt3.getId() == R.id.goodbyepluto ){CH3=0;FINAL=0;}
                                else if(vt3.getId() == R.id.textleft )CH4=0;}
                        }

                        if (view.getId() == R.id.textright && v.getId() == R.id.target3 && tg3 == 0) {
                            view.animate().x(target3.getX()).y(target3.getY()).setDuration(150).start();
                            vt3 = view;
                            tg3=1;CH1=1;
                            x3 = pinRight;

                            res3=0;rg=v;

                        }

                        if (view.getId() == R.id.print && v.getId() == R.id.target3 && tg3 == 0) {
                            view.animate().x(target3.getX()).y(target3.getY()).setDuration(150).start();
                            vt3 = view;
                            tg3=1;CH2=1;
                            x3 = pinPrint;

                            res3=0;pg=v;
                        }

                        if (view.getId() == R.id.goodbyepluto && v.getId() == R.id.target3 && tg3 == 0) {
                            view.animate().x(target3.getX()).y(target3.getY()).setDuration(150).start();
                            vt3 = view;
                            tg3=1;CH3=1;
                            x3 = pinPluto;

                            res3=0;gg=v;

                        }

                        if (view.getId() == R.id.textleft && v.getId() == R.id.target3 && tg3 == 0) {
                            view.animate().x(target3.getX()).y(target3.getY()).setDuration(150).start();
                            vt3 = view;
                            tg3=1;CH4=1;
                            x3 = pinLeft;

                            lg=v;


                            res3++;

                        }
                    }


                    //start target4


                    else   if (v.getId() == R.id.target4) {

                        if (v.getId() == R.id.target4 & tg4 > 0) { tg4=0;
                            if( vt4.getX()==v.getX()){
                                vt4.animate().x(x4.getX()).y(x4.getY()).setDuration(150).start();


                                if(vt4.getId() == R.id.textright )CH1=0;
                                else if(vt4.getId() == R.id.print )CH2=0;
                                else if(vt4.getId() == R.id.goodbyepluto ){CH3=0;FINAL=0;}
                                else if(vt4.getId() == R.id.textleft )CH4=0;}
                        }

                        if (view.getId() == R.id.textright && v.getId() == R.id.target4 && tg4 == 0) {
                            view.animate().x(target4.getX()).y(target4.getY()).setDuration(150).start();
                            vt4 = view;
                            tg4=1;CH1=1;
                            x4 = pinRight;

                            rg=v;
                            res4=0;

                        }

                        if (view.getId() == R.id.print && v.getId() == R.id.target4 && tg4 == 0) {
                            view.animate().x(target4.getX()).y(target4.getY()).setDuration(150).start();
                            vt4 = view;
                            tg4=1;CH2=1;
                            x4 = pinPrint;

                            pg=v;
                            res4=0;

                        }

                        if (view.getId() == R.id.goodbyepluto && v.getId() == R.id.target4 && tg4 == 0) {
                            view.animate().x(target4.getX()).y(target4.getY()).setDuration(150).start();
                            vt4 = view;
                            tg4=1;CH3=1;
                            x4 = pinPluto;

                            gg=v;
                            g=1;
                            res4++;


                        }

                        if (view.getId() == R.id.textleft && v.getId() == R.id.target4 && tg4 == 0) {
                            view.animate().x(target4.getX()).y(target4.getY()).setDuration(150).start();
                            vt4 = view;
                            tg4=1;CH4=1;
                            x4 = pinLeft;

                            lg=v;
                            res4=0;

                        }
                    }








            }CHECK=CH1+CH2+CH3+CH4;

            if(CHECK==4 ) {next.setVisibility(View.VISIBLE); }else next.setVisibility(View.INVISIBLE);
            return true;
        }
    };


    public void btnHome(View view) {


        Intent HomePage=new Intent(getApplicationContext(),MainActivity.class);
        startActivity(HomePage);

    }

    public void ShowPopup(View v) {

        Button btnClose;
        myDialog.setContentView(R.layout.hint1_2);
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
        result = res1 + res2 + res3 + res4;
        sqLiteHelper.UpdateQuestionAnswer(1,1);
        if (result == 4) {
            sqLiteHelper.UpdateQuestionAnswer(2,1);
        }
        else
            sqLiteHelper.UpdateQuestionAnswer(2,0);

            //  getdata();

        }

        public void getdata () {

            //  Cursor cursor=sqLiteHelper.getAnswerData(2);
            //  cursor.moveToFirst();

            // int index = cursor.getColumnIndexOrThrow("Answer");
            //int answer = cursor.getInt(index);


        }


    }