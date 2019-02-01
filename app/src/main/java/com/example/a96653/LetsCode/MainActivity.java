package com.example.a96653.LetsCode;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import java.lang.Class;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final MySQLliteHelper m=new MySQLliteHelper(this);
        int lnum=0;
      //lnum=m.getNumOfLessonPassed("بلوتو");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //SharedPreferences prefs = getSharedPreferences("prefs", MODE_PRIVATE);
       // boolean firstStart = prefs.getBoolean("firstStart", true);

        //if (firstStart) {
           // launchSecondActivity();
       // }

        ImageView ploto = (ImageView)findViewById(R.id.imageView3);

        final int finalLnum = lnum;
        ploto.setOnClickListener(

                new Button.OnClickListener(){


                    public void onClick(View v){

                        try {
                            openPlotoActivity(m, finalLnum);
                        } catch (ClassNotFoundException e) {
                            e.printStackTrace();
                        }
                    }

                }
                );

    }

////


    public void openPlotoActivity(MySQLliteHelper M,int lnum2) throws ClassNotFoundException {
       lnum2=M.getNumOfLessonPassed("Ploto");
        TextView t=(TextView)findViewById(R.id.textView47);
        //NEXT SESSION STARTS HERE .
        Lesson l=new Lesson();
        String name=l.getName(M.getNumOfLessonPassed("Ploto"));
        t.setText(name);
        Class c;
        try{
        c = Class.forName("com.example.a96653.LetsCode."+name);

         Intent  intent = new Intent(this,c);


        startActivity(intent);}
        catch (Exception e){e.printStackTrace();}

    }


    public void launchSecondActivity() {
       MySQLliteHelper mySqliteOpenHelper=new MySQLliteHelper(this);
        mySqliteOpenHelper.addData();
        startActivity(new Intent(MainActivity.this,welcome_1.class));
        SharedPreferences prefs = getSharedPreferences("prefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putBoolean("firstStart", false);
        editor.apply();
    }

}
