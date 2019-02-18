package com.example.a96653.LetsCode;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.app.Dialog;
import android.content.ClipData;
import android.content.ClipDescription;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.DragEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;


public class secondlevel_18_quiz extends AppCompatActivity implements View.OnDragListener,
        View.OnLongClickListener {
    Button btn_string1, btn_String2, btn_string3;
    Button int_1, int_2;
    LinearLayout layout_strings, layout_integers;
    ImageView iv_next;
    Dialog myDialog;

    public static MySQLliteHelper m;
    private static final String IMAGE_STRING_TAG1 = "String 1";
    private static final String IMAGE_STRING_TAG2 = "String 2";
    private static final String IMAGE_STRING_TAG3 = "String 3";

    private static final String IMAGE_int_TAG1 = "Integer 1";
    private static final String IMAGE_int_TAG2 = "Integer 2";

    private LinearLayout linearLayout1;
    private LinearLayout linearLayout2;

    int counter= 0;

    private static final String TEXT_VIEW_TAG = "DRAG TEXT";

    View mview;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondlevel_18_quiz);
         m=new MySQLliteHelper(this);
        //TO VIEW SCORE ON BOX
        TextView textView = (TextView)findViewById(R.id.scoreBox_secondleve_l8);
        textView.setText(m.getChildScore()+"" );


        //HOME BUTTON
        ImageButton homebtn3=(ImageButton)findViewById(R.id.secondlevel_18_homebtn8);
        homebtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent HomePage=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(HomePage);
            }
        });
        //NEXT BUTTON
        iv_next = (ImageView) findViewById(R.id.next);
        iv_next.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                m.UpdateQuestionAnswer(3,1);
                SharedPreferences prefs = getSharedPreferences("pref_secondLevel_18", MODE_PRIVATE);
                boolean firstStart = prefs.getBoolean("firstStart", true);
                if (firstStart){
                    m.UpdateNumOfLesson(24,"Nepton");
                    SharedPreferences pref = getSharedPreferences("pref_secondLevel_18", MODE_PRIVATE);
                    SharedPreferences.Editor editor = prefs.edit();
                    editor.putBoolean("firstStart", false);
                    editor.apply();}
                openSecondActivity();
            }
        });
        iv_next.setVisibility(View.INVISIBLE);

        btn_string1 = (Button) findViewById(R.id.string1_button13);
        btn_string1.setTag(IMAGE_STRING_TAG1);

        btn_String2 = (Button) findViewById(R.id.string2_button14);
        btn_String2.setTag(IMAGE_STRING_TAG2);

        btn_string3 = (Button) findViewById(R.id.string3_button17);
        btn_string3.setTag(IMAGE_STRING_TAG3);


        int_1 = (Button) findViewById(R.id.integer1_button15);
        int_1.setTag(IMAGE_int_TAG1);

        int_2 = (Button) findViewById(R.id.integer2_button16);
        int_2.setTag(IMAGE_int_TAG2);


        btn_string1.setOnLongClickListener(this);
        btn_String2.setOnLongClickListener(this);
        btn_string3.setOnLongClickListener(this);

        int_1.setOnLongClickListener(this);
        int_2.setOnLongClickListener(this);
        myDialog = new Dialog(this);


        findViewById(R.id.string_box).setOnDragListener(this);
        findViewById(R.id.integerbox_5_100).setOnDragListener(this);

    }
    @Override
    public boolean onLongClick(View view) {

        ClipData.Item item = new ClipData.Item((CharSequence) view.getTag());

        String[] mimeTypes = {ClipDescription.MIMETYPE_TEXT_PLAIN};

        ClipData data = new ClipData(view.getTag().toString(), mimeTypes, item);

        View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);

        // Starts the drag
        view.startDrag(data , shadowBuilder, view , 0);


        view.setVisibility(View.INVISIBLE);
        mview = view;

        return true;
    }//OnLong Click method


    @Override
    public boolean onDrag(View view, DragEvent event) {

        int linear_id = view.getId();
        int action = event.getAction();

        switch (linear_id) {
            case R.id.string_box:

                // Handles each of the expected events

                switch (action) {
                    case DragEvent.ACTION_DRAG_STARTED:
                        // Determines if this View can accept the dragged data
                        if (event.getClipDescription().hasMimeType(ClipDescription.MIMETYPE_TEXT_PLAIN)) {

                            return true;

                        }

                        return false;


                    case DragEvent.ACTION_DRAG_EXITED:

                        view.getBackground().clearColorFilter();

                        view.invalidate();

                        return true;

                    case DragEvent.ACTION_DROP:

                        String mimType = event.getClipDescription().toString();
                        // String mimType = item.getText().toString();
                        Log.d("Type ***", mimType);

                        if (mimType.contains(IMAGE_STRING_TAG1) | mimType.contains(IMAGE_STRING_TAG2) | mimType.contains(IMAGE_STRING_TAG3)) {

                            // Gets the item containing the dragged data
                            ClipData.Item item = event.getClipData().getItemAt(0);

                            // Gets the text data from the item.
                            String dragData = item.getText().toString();

                            Toast.makeText(this, "Dragged data is " + dragData, Toast.LENGTH_SHORT);

                            view.getBackground().clearColorFilter();

                            view.invalidate();

                            View v = (View) event.getLocalState();
                            ViewGroup owner = (ViewGroup) v.getParent();
                            owner.removeView(v);//remove the dragged view
                            LinearLayout container = (LinearLayout) view;//caste the view into LinearLayout as our drag acceptable layout is LinearLayout

                            // set next view visible
                            counter ++;
                            if(counter == 5) {
                                iv_next.setVisibility(View.VISIBLE);

                            }

                            return true;

                        }
                        else
                        {
                            Toast.makeText(secondlevel_18_quiz.this, "This image is not in this layout !!", Toast.LENGTH_SHORT);

                            mview.setVisibility(View.VISIBLE);
                            return false;

                        }



                    case DragEvent.ACTION_DRAG_ENDED:

                        view.getBackground().clearColorFilter();

                        view.invalidate();

                        // Does a getResult(), and displays what happened.
                        if (event.getResult())
                            Toast.makeText(this, "The drop was handled.",Toast.LENGTH_SHORT);


                        else
                            Toast.makeText(this, "The drop didn't work.", Toast.LENGTH_SHORT);
                        mview.setVisibility(View.VISIBLE);
                        // returns true; the value is ignored.
                        return true;


                }

                break;

            case R.id.integerbox_5_100:

                // Handles each of the expected events

                switch (action) {
                    case DragEvent.ACTION_DRAG_STARTED:
                        // Determines if this View can accept the dragged data
                        if (event.getClipDescription().hasMimeType(ClipDescription.MIMETYPE_TEXT_PLAIN)) {


                            return true;

                        }

                        return false;



                    case DragEvent.ACTION_DRAG_EXITED:

                        view.getBackground().clearColorFilter();

                        view.invalidate();

                        return true;

                    case DragEvent.ACTION_DROP:

                        String mimType = event.getClipDescription().toString();
                        // String mimType = item.getText().toString();
                        Log.d("Type ***", mimType);

                        if (mimType.contains(IMAGE_int_TAG1) | mimType.contains(IMAGE_int_TAG2)) {

                            // Gets the item containing the dragged data
                            ClipData.Item item = event.getClipData().getItemAt(0);

                            // Gets the text data from the item.
                            String dragData = item.getText().toString();

                            // Displays a message containing the dragged data.
                            Toast.makeText(secondlevel_18_quiz.this, "Dragged data is " + dragData, Toast.LENGTH_SHORT);


                            view.getBackground().clearColorFilter();

                            view.invalidate();

                            View v = (View) event.getLocalState();
                            ViewGroup owner = (ViewGroup) v.getParent();
                            owner.removeView(v);//remove the dragged view
                            LinearLayout container = (LinearLayout) view;//caste the view into LinearLayout as our drag acceptable layout is LinearLayout

                            counter ++;
                            if(counter == 5) {
                                iv_next.setVisibility(View.VISIBLE);
                                // set next view visible
                            }

                            return true;

                        }
                        else
                        {
                            Toast.makeText(this, "This image is not in this layout !!", Toast.LENGTH_SHORT);
                            mview.setVisibility(View.VISIBLE);
                            return false;

                        }
                        // Returns true. DragEvent.getResult() will return true.

                    case DragEvent.ACTION_DRAG_ENDED:
                        view.getBackground().clearColorFilter();

                        view.invalidate();

                        // Does a getResult(), and displays what happened.
                        if (event.getResult())
                            Toast.makeText(secondlevel_18_quiz.this,"The drop was handled. ",Toast.LENGTH_SHORT);

                        else
                            Toast.makeText(secondlevel_18_quiz.this, "The drop didn't work.", Toast.LENGTH_SHORT);
                        mview.setVisibility(View.VISIBLE);
                        // returns true; the value is ignored.
                        return true;

                }
                break;

            default:

                break;
        }//switch

        return false;

    }//End of OnDrag method

    public void ShowPopup(View v) {

        Button btnClose;
        myDialog.setContentView(R.layout.hint2_1);
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
    public void openSecondActivity() {


            // sqLiteHelper.UpdateQuestionAnswer(1,1);


        Intent intent = new Intent(this, secondlevel_20.class);
        startActivity(intent);


    }



}
