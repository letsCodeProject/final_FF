package com.example.a96653.LetsCode;

import android.content.ClipData;
import android.content.ClipDescription;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import android.view.DragEvent;
import android.view.View;
import android.widget.LinearLayout;

import android.util.Log;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;


public class firstlevel_3 extends AppCompatActivity {
    ImageView iv_answer;
    LinearLayout inputLayout;
    TextView tv_output;
    Timer timer;

    // Lesson l3=new Lesson(3);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //FOR DRAG AND DROP
        setContentView(R.layout.activity_firstlevel_3);
        tv_output = (TextView) findViewById(R.id.textView41);
        iv_answer = (ImageView) findViewById(R.id.imageView56);
        iv_answer.setTag("Answer");
        // set when user do long click on the answer image
        iv_answer.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                // Create a new ClipData.Item from the ImageView object's tag
                ClipData.Item item = new ClipData.Item((CharSequence) view.getTag());

                // ClipData, and set its MIME type entry to "text/plain"
                String[] mimeTypes = {ClipDescription.MIMETYPE_TEXT_PLAIN};

                ClipData data = new ClipData(view.getTag().toString(), mimeTypes, item);

                View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);

                // Starts the drag
                view.startDrag(data , shadowBuilder,view , 0);


                view.setVisibility(View.INVISIBLE);
                return true;

            }
        });
        inputLayout = (LinearLayout) findViewById(R.id.imageView46);
        // set on dragable to layout
        inputLayout.setOnDragListener(new View.OnDragListener() {
            @Override
            public boolean onDrag(View view, DragEvent event) {

                // Defines a variable to store the action type for the incoming event
                int action = event.getAction();
                // Handles each of the expected events
                switch (action) {
                    case DragEvent.ACTION_DRAG_STARTED:

                        if (event.getClipDescription().hasMimeType(ClipDescription.MIMETYPE_TEXT_PLAIN)) {

                            return true;
                        }

                        return false;

                    case DragEvent.ACTION_DRAG_EXITED:

                        view.getBackground().clearColorFilter();
                        view.invalidate();

                        return true;

                    case DragEvent.ACTION_DROP:
                        ClipData.Item item = event.getClipData().getItemAt(0);

                        String dragData = item.getText().toString();

                        Toast.makeText(firstlevel_3.this, "Dragged data is " + dragData, Toast.LENGTH_SHORT).show();

                        view.getBackground().clearColorFilter();


                        view.invalidate();

                        View v = (View) event.getLocalState();
                        ViewGroup owner = (ViewGroup) v.getParent();
                        owner.removeView(v);//remove the dragged view
                        LinearLayout container = (LinearLayout) view;
                        container.addView(v);//Add the dragged view
                        v.setVisibility(View.VISIBLE);

                        return true;

                    case DragEvent.ACTION_DRAG_ENDED:
                        // Turns off any color tinting
                        view.getBackground().clearColorFilter();
                        view.invalidate();

                        // Does a getResult(), and displays what happened.
                        if (event.getResult()){
                            Toast.makeText(firstlevel_3.this, "The drop was handled.", Toast.LENGTH_SHORT).show();
                            tv_output.setText("أهلاً بدرب التبانة");
                            tv_output.setText("أهلاً بدرب التبانة");
                            tv_output.setTextSize(25);

                            timer=new Timer();
                            timer.schedule(new TimerTask() {
                                @Override
                                public void run() {
                                    Intent inrent=new Intent(firstlevel_3.this,feedback3.class);
                                    startActivity(inrent);
                                    finish();

                                }
                            },5000);

                        }
                        else
                            Toast.makeText(firstlevel_3.this, "The drop didn't work.", Toast.LENGTH_SHORT).show();
                        // returns true; the value is ignored.
                        return true;

                    // An unknown action type was received.
                    default:
                        Log.e("DragDrop Example", "Unknown action type received by OnDragListener.");
                        break;
                }
                return false;
            }
        });//end of drag and drop function





        final MySQLliteHelper m=new MySQLliteHelper(this);
        SharedPreferences prefs = getSharedPreferences("pref6", MODE_PRIVATE);
        boolean firstStart = prefs.getBoolean("firstStart", true);
        if (firstStart){
            // m.addLesson(l3);

            SharedPreferences pref = getSharedPreferences("prefs6", MODE_PRIVATE);
            SharedPreferences.Editor editor = prefs.edit();
            editor.putBoolean("firstStart", false);
            editor.apply();}
        ImageButton homebtn2=(ImageButton)findViewById(R.id.homebtn2);

        homebtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent HomePage=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(HomePage);
            }
        });



        ImageView pre = (ImageView)findViewById(R.id.prebtn);

        pre.setOnClickListener(
                new ImageView.OnClickListener(){
                    public void onClick(View v){

                        openPreviousActivity();
                    }

                }

        );


        //  nextbtn


    }




    public void openPreviousActivity(){

        Intent intent=new Intent(this,firstlevel_2.class);
        startActivity(intent);

    }


    public void openSecondActivity(){
        Intent intent=new Intent(this,feedback3.class);
        startActivity(intent);
    }










}//end of class
