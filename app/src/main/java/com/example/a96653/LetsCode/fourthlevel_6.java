package com.example.a96653.LetsCode;

import android.app.Dialog;
import android.content.ClipData;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class fourthlevel_6 extends AppCompatActivity {

    public static MySQLliteHelper sqLiteHelper;
    TextView target1, target2, target3, target4, textviewwhile, textviewprint, textviewincrment, textviewassign, pinwhile, pinprint, pinincrement, pinassign;
    int res1 = 0, res2 = 0, res3 = 0, res4 = 0, result, CHECK = 0, tt1, tt2, tt3, tt4;
    static int questionResult, tg1 = 0, tg2 = 0, tg3 = 0, tg4 = 0;
    static TextView x1, x2, x3, x4;
    static View vt1, vt2, vt3, vt4;

    Dialog myDialog;
    ImageView next;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourthlevel_6);

        sqLiteHelper = new MySQLliteHelper(this);

        //TO VIEW SCORE ON BOX
        TextView textView = (TextView) findViewById(R.id.scoreBox_fourthlevel_6);
        textView.setText(sqLiteHelper.getChildScore() + "");

        //HOME BUTTON
        ImageButton homebtn3 = (ImageButton) findViewById(R.id.homebtn_fourthlevel6);
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
        tt4 = 0;
        myDialog = new Dialog(this);
        CHECK = 0;

        target1 = (TextView) findViewById(R.id.target1);
        target2 = (TextView) findViewById(R.id.target2);
        target3 = (TextView) findViewById(R.id.target3);
        target4 = (TextView) findViewById(R.id.target4);

        textviewassign = (TextView) findViewById(R.id.assign_statment);
        textviewwhile = (TextView) findViewById(R.id.loop_statment);
        textviewprint = (TextView) findViewById(R.id.print_statment);
        textviewincrment = (TextView) findViewById(R.id.increment_statment);

        //Pin
        pinassign = (TextView) findViewById(R.id.pinassign);
        pinwhile = (TextView) findViewById(R.id.pinloop);
        pinprint = (TextView) findViewById(R.id.pinprint);
        pinincrement = (TextView) findViewById(R.id.pinincrement);


        textviewassign.setOnLongClickListener(longClickListener);
        textviewwhile.setOnLongClickListener(longClickListener);
        textviewprint.setOnLongClickListener(longClickListener);
        textviewincrment.setOnLongClickListener(longClickListener);


        target1.setOnDragListener(dragListener);
        target2.setOnDragListener(dragListener);
        target3.setOnDragListener(dragListener);
        target4.setOnDragListener(dragListener);

        next = (ImageView) findViewById(R.id.fourthlevel_6_next);

        next.setOnClickListener(
                new ImageView.OnClickListener() {
                    public void onClick(View v) {
                        tt1 = 0;
                        tt2 = 0;
                        tt3 = 0;
                        tt4 = 0;
                        if (textviewassign.getX() == target1.getX()) tt1 = 1;
                        if (textviewassign.getX() == target2.getX()) tt1 = 1;
                        if (textviewassign.getX() == target3.getX()) tt1 = 1;
                        if (textviewassign.getX() == target4.getX()) tt1 = 1;


                        if (textviewincrment.getX() == target1.getX()) tt4 = 1;
                        if (textviewincrment.getX() == target2.getX()) tt4 = 1;
                        if (textviewincrment.getX() == target3.getX()) tt4 = 1;
                        if (textviewincrment.getX() == target4.getX()) tt4 = 1;


                        if (textviewwhile.getX() == target1.getX()) tt2 = 1;
                        if (textviewwhile.getX() == target2.getX()) tt2 = 1;
                        if (textviewwhile.getX() == target3.getX()) tt2 = 1;
                        if (textviewwhile.getX() == target4.getX()) tt2 = 1;


                        if (textviewprint.getX() == target1.getX()) tt3 = 1;
                        if (textviewprint.getX() == target2.getX()) tt3 = 1;
                        if (textviewprint.getX() == target3.getX()) tt3 = 1;
                        if (textviewprint.getX() == target4.getX()) tt3 = 1;

                        CHECK = tt1 + tt2 + tt3 + tt4;
                        if (CHECK == 4) {
                            SharedPreferences prefs = getSharedPreferences("pref_forthlevel_6", MODE_PRIVATE);
                            boolean firstStart = prefs.getBoolean("firstStart", true);
                            if (firstStart){
                                sqLiteHelper.UpdateNumOfLesson(60,"Jupiter");
                                SharedPreferences pref = getSharedPreferences("pref_forthlevel_6", MODE_PRIVATE);
                                SharedPreferences.Editor editor = prefs.edit();
                                editor.putBoolean("firstStart", false);
                                editor.apply();}
////
                            ////CLEARING PREFRENCES
                            SharedPreferences preferences = getSharedPreferences("pref_fourthLevel_1", MODE_PRIVATE);
                            SharedPreferences.Editor editor = preferences.edit();
                            editor.clear();
                            editor.commit();
                            finish();
                            ////
                            SharedPreferences preferences2 = getSharedPreferences("fourthLevel_2", MODE_PRIVATE);
                            SharedPreferences.Editor editor2 = preferences2.edit();
                            editor2.clear();
                            editor2.commit();
                            finish();
                            ////
                            SharedPreferences preferences3 = getSharedPreferences("fourthlevel_3", MODE_PRIVATE);
                            SharedPreferences.Editor editor3 = preferences3.edit();
                            editor3.clear();
                            editor3.commit();
                            finish();
                            ////
                            SharedPreferences preferences4 = getSharedPreferences("fourthLevel_video", MODE_PRIVATE);
                            SharedPreferences.Editor editor4 = preferences4.edit();
                            editor4.clear();
                            editor4.commit();
                            finish();
                            ////
                            SharedPreferences preferences5 = getSharedPreferences("pref_forthlevel_4", MODE_PRIVATE);
                            SharedPreferences.Editor editor5 = preferences5.edit();
                            editor5.clear();
                            editor5.commit();
                            finish();
                            ///////////////
                            SharedPreferences preferences6 = getSharedPreferences("pref_forthlevel_5", MODE_PRIVATE);
                            SharedPreferences.Editor editor6 = preferences6.edit();
                            editor6.clear();
                            editor6.commit();
                            finish();
                            /////////////////
                            SharedPreferences preferences7 = getSharedPreferences("pref_forthlevel_6", MODE_PRIVATE);
                            SharedPreferences.Editor editor7 = preferences7.edit();
                            editor7.clear();
                            editor7.commit();
                            finish();


                            updatedata();
                            Intent intent = new Intent(getApplicationContext(), Fourthlevel_resultsheet.class);
                            startActivity(intent);

                        }//end if check==4
                        else {

                            ShowPopupSolve();
                            ////CLEARING PREFRENCES
                            SharedPreferences preferences = getSharedPreferences("pref_fourthLevel_1", MODE_PRIVATE);
                            SharedPreferences.Editor editor = preferences.edit();
                            editor.clear();
                            editor.commit();
                            finish();
                            ////
                            SharedPreferences preferences2 = getSharedPreferences("fourthLevel_2", MODE_PRIVATE);
                            SharedPreferences.Editor editor2 = preferences2.edit();
                            editor2.clear();
                            editor2.commit();
                            finish();
                            ////
                            SharedPreferences preferences3 = getSharedPreferences("pref_forthlevel_3", MODE_PRIVATE);
                            SharedPreferences.Editor editor3 = preferences3.edit();
                            editor3.clear();
                            editor3.commit();
                            finish();
                            ////
                            SharedPreferences preferences4 = getSharedPreferences("fourthLevel_video", MODE_PRIVATE);
                            SharedPreferences.Editor editor4 = preferences4.edit();
                            editor4.clear();
                            editor4.commit();
                            finish();
                            ////
                            SharedPreferences preferences5 = getSharedPreferences("pref_forthlevel_4", MODE_PRIVATE);
                            SharedPreferences.Editor editor5 = preferences5.edit();
                            editor5.clear();
                            editor5.commit();
                            finish();
                            ///////////////
                            SharedPreferences preferences6 = getSharedPreferences("pref_forthlevel_5", MODE_PRIVATE);
                            SharedPreferences.Editor editor6 = preferences6.edit();
                            editor6.clear();
                            editor6.commit();
                            finish();
                            /////////////////
                            SharedPreferences preferences7 = getSharedPreferences("pref_forthlevel_6", MODE_PRIVATE);
                            SharedPreferences.Editor editor7 = preferences7.edit();
                            editor7.clear();
                            editor7.commit();
                            finish();
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
                    if (v.getId() == R.id.target1) {


                        if (v.getId() == R.id.target1 && tg1 > 0) {
                            tg1 = 0;
                            if (vt1.getX() == v.getX()) {
                                vt1.animate().x(x1.getX()).y(x1.getY()).setDuration(80).start();
                            }

                        }

                        if (view.getId() == R.id.assign_statment && v.getId() == R.id.target1 && tg1 == 0) {
                            view.animate().x(target1.getX()).y(target1.getY()).setDuration(80).start();
                            vt1 = view;
                            x1 = pinassign;
                            tg1 = 1;
                            res1 = 1;

                        }
                        if (view.getId() == R.id.loop_statment && v.getId() == R.id.target1 && tg1 == 0) {
                            view.animate().x(target1.getX()).y(target1.getY()).setDuration(80).start();
                            vt1 = view;
                            tg1 = 1;
                            x1 = pinwhile;
                            res1 = 0;

                        }
                        if (view.getId() == R.id.print_statment && v.getId() == R.id.target1 && tg1 == 0) {
                            view.animate().x(target1.getX()).y(target1.getY()).setDuration(80).start();
                            vt1 = view;
                            tg1 = 1;
                            x1 = pinprint;
                            res1 = 0;

                        }
                        if (view.getId() == R.id.increment_statment && v.getId() == R.id.target1 && tg1 == 0) {
                            view.animate().x(target1.getX()).y(target1.getY()).setDuration(80).start();
                            vt1 = view;
                            tg1 = 1;
                            x1 = pinincrement;
                            res1 = 0;

                        }

                    }


                    //start target2

                    else if (v.getId() == R.id.target2) {


                        if (v.getId() == R.id.target2 & tg2 > 0) {
                            tg2 = 0;
                            if (vt2.getX() == v.getX()) {
                                vt2.animate().x(x2.getX()).y(x2.getY()).setDuration(80).start();
                            }

                        }

                        if (view.getId() == R.id.loop_statment && v.getId() == R.id.target2 && tg2 == 0) {
                            view.animate().x(target2.getX()).y(target2.getY()).setDuration(80).start();
                            vt2 = view;
                            tg2 = 1;
                            x2 = pinwhile;
                            res2 = 1;

                        }

                        if (view.getId() == R.id.print_statment && v.getId() == R.id.target2 && tg2 == 0) {
                            view.animate().x(target2.getX()).y(target2.getY()).setDuration(80).start();
                            vt2 = view;
                            tg2 = 1;
                            x2 = pinprint;
                            res2 = 0;


                        }

                        if (view.getId() == R.id.increment_statment && v.getId() == R.id.target2 && tg2 == 0) {
                            view.animate().x(target2.getX()).y(target2.getY()).setDuration(80).start();
                            vt2 = view;
                            tg2 = 1;
                            x2 = pinincrement;
                            res2 = 0;

                        }
                        if (view.getId() == R.id.assign_statment && v.getId() == R.id.target2 && tg2 == 0) {
                            view.animate().x(target2.getX()).y(target2.getY()).setDuration(80).start();
                            vt2 = view;
                            tg2 = 1;
                            x2 = pinassign;
                            res2 = 0;

                        }

                    }


                    //start target3


                    else if (v.getId() == R.id.target3) {


                        if (v.getId() == R.id.target3 & tg3 > 0) {
                            tg3 = 0;
                            if (vt3.getX() == v.getX()) {
                                vt3.animate().x(x3.getX()).y(x3.getY()).setDuration(80).start();
                            }
                        }

                        if (view.getId() == R.id.print_statment && v.getId() == R.id.target3 && tg3 == 0) {
                            view.animate().x(target3.getX()).y(target3.getY()).setDuration(80).start();
                            vt3 = view;
                            tg3 = 1;
                            x3 = pinprint;
                            res3 = 1;

                        }

                        if (view.getId() == R.id.assign_statment && v.getId() == R.id.target3 && tg3 == 0) {
                            view.animate().x(target3.getX()).y(target3.getY()).setDuration(80).start();
                            vt3 = view;
                            tg3 = 1;
                            x3 = pinassign;
                            res3 = 0;
                        }

                        if (view.getId() == R.id.loop_statment && v.getId() == R.id.target3 && tg3 == 0) {
                            view.animate().x(target3.getX()).y(target3.getY()).setDuration(80).start();
                            vt3 = view;
                            tg3 = 1;
                            x3 = pinwhile;
                            res3 = 0;

                        }
                        if (view.getId() == R.id.increment_statment && v.getId() == R.id.target3 && tg3 == 0) {
                            view.animate().x(target3.getX()).y(target3.getY()).setDuration(80).start();
                            vt3 = view;
                            tg3 = 1;
                            x3 = pinincrement;
                            res3 = 0;

                        }

                    }


                    //start target4


                    else if (v.getId() == R.id.target4) {


                        if (v.getId() == R.id.target4 & tg4 > 0) {
                            tg4 = 0;
                            if (vt4.getX() == v.getX()) {
                                vt4.animate().x(x4.getX()).y(x4.getY()).setDuration(80).start();
                            }
                        }

                        if (view.getId() == R.id.increment_statment && v.getId() == R.id.target4 && tg4 == 0) {
                            view.animate().x(target4.getX()).y(target4.getY()).setDuration(80).start();
                            vt4 = view;
                            tg4 = 1;
                            x4 = pinincrement;
                            res4 = 1;

                        }

                        if (view.getId() == R.id.loop_statment && v.getId() == R.id.target4 && tg4 == 0) {
                            view.animate().x(target4.getX()).y(target4.getY()).setDuration(80).start();
                            vt4 = view;
                            tg4 = 1;
                            x4 = pinwhile;
                            res4 = 0;
                        }

                        if (view.getId() == R.id.print_statment && v.getId() == R.id.target4 && tg4 == 0) {
                            view.animate().x(target4.getX()).y(target4.getY()).setDuration(80).start();
                            vt4 = view;
                            tg4 = 1;
                            x4 = pinprint;
                            res4 = 0;

                        }
                        if (view.getId() == R.id.assign_statment && v.getId() == R.id.target4 && tg4 == 0) {
                            view.animate().x(target4.getX()).y(target4.getY()).setDuration(80).start();
                            vt4 = view;
                            tg4 = 1;
                            x4 = pinassign;
                            res4 = 0;


                        }
                    }

            }
            return true;
        }

    };

    public void ShowPopupSolve() {

        Button btnClose;
        myDialog.setContentView(R.layout.solve_it);
        btnClose = (Button) myDialog.findViewById(R.id.okaybtn);


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
        Toast.makeText(fourthlevel_6.this, "result: " + result,
                Toast.LENGTH_SHORT);
        if (result == 4) {
            sqLiteHelper.UpdateQuestionAnswer(15, 1);
        } else {
            sqLiteHelper.UpdateQuestionAnswer(15, 0);
        }


    }

    public void ShowPopup(View v) {

        Button btnClose;
        myDialog.setContentView(R.layout.hint4_3);
        btnClose =(Button) myDialog.findViewById(R.id.okaybtn);


        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }//End of showPop

}//End Class
