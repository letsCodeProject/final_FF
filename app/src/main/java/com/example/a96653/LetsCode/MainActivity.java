package com.example.a96653.LetsCode;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import java.lang.Class;

public class MainActivity extends AppCompatActivity {
    ImageView labeb_nepton;
    ImageView labeb_zuhal;
    ImageView labeb_ploto;
    ImageView labeb_almushtari;
    ImageView labeb_Earth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final MySQLliteHelper m=new MySQLliteHelper(this);

        int lnum=0;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //For moving labeb over the planet and change TRANCPERRENCY
        labeb_ploto=(ImageView)findViewById(R.id.labeb_on_ploto);
        labeb_nepton= findViewById(R.id.labebOnnepton);
        labeb_zuhal=(ImageView)findViewById(R.id.labebOnZuhal);
        labeb_almushtari=(ImageView)findViewById(R.id.labebOnALmushtari);
        labeb_Earth=(ImageView)findViewById(R.id.labebOnEarth);
        boolean levelStatus;
        ImageView nepton=(ImageView)findViewById(R.id.imageView9);
        ImageView Saturn=(ImageView)findViewById(R.id.imageView13);
        ImageView Jupiter=(ImageView)findViewById(R.id.imageView17);
        ImageView Earth=(ImageView)findViewById(R.id.imageView);
     if( levelStatus=m.getLevelStatus("Nepton")==true)
         nepton.setAlpha(1000);
     else {
         nepton.setAlpha(100);
         labeb_nepton.setVisibility(View.INVISIBLE);
         labeb_zuhal.setVisibility(View.INVISIBLE);
         labeb_almushtari.setVisibility(View.INVISIBLE);
         labeb_Earth.setVisibility(View.INVISIBLE);
     }


     ImageView g= findViewById(R.id.imageView17);

        g.setOnClickListener(new  ImageView.OnClickListener() {

                                      public void onClick(View v) {


                                          startActivity(new Intent(MainActivity.this,fourthlevel_video.class));
                                      }

                                  }
        );






        if( levelStatus=m.getLevelStatus("Saturn")==true)
            Saturn.setAlpha(1000);
        else {
            Saturn.setAlpha(100);
        }
        if( levelStatus=m.getLevelStatus("Jupiter")==true)
            Jupiter.setAlpha(1000);
        else  Jupiter.setAlpha(100);
        if( levelStatus=m.getLevelStatus("Earth")==true) {
            Earth.setAlpha(1000);
            labeb_nepton.setVisibility(View.INVISIBLE);
            labeb_zuhal.setVisibility(View.INVISIBLE);
            labeb_almushtari.setVisibility(View.INVISIBLE);
            labeb_Earth.setVisibility(View.VISIBLE);
            labeb_ploto.setVisibility(View.INVISIBLE);
        }
        else  Earth.setAlpha(100);
        //////WHEN NEPTON
        if(levelStatus=m.getLevelStatus("Nepton")==true  ){
            if (levelStatus=m.getLevelStatus("Saturn")==false) {
                labeb_nepton.setVisibility(View.VISIBLE);
            labeb_zuhal.setVisibility(View.INVISIBLE);
            labeb_almushtari.setVisibility(View.INVISIBLE);
            labeb_Earth.setVisibility(View.INVISIBLE);
            labeb_ploto.setVisibility(View.INVISIBLE); }
        }
//WHEN ZUHAL
        if(levelStatus=m.getLevelStatus("Saturn")==true  ){
            if (levelStatus=m.getLevelStatus("Jupiter")==false) {
                labeb_nepton.setVisibility(View.INVISIBLE);
                labeb_zuhal.setVisibility(View.VISIBLE);
                labeb_almushtari.setVisibility(View.INVISIBLE);
                labeb_Earth.setVisibility(View.INVISIBLE);
                labeb_ploto.setVisibility(View.INVISIBLE); } }
                //WHEN ALMUSHTARI
            if(levelStatus=m.getLevelStatus("Jupiter")==true  ){
                if (levelStatus=m.getLevelStatus("Earth")==false) {
                    labeb_nepton.setVisibility(View.INVISIBLE);
                    labeb_zuhal.setVisibility(View.INVISIBLE);
                    labeb_almushtari.setVisibility(View.VISIBLE);
                    labeb_Earth.setVisibility(View.INVISIBLE);
                    labeb_ploto.setVisibility(View.INVISIBLE); } }
        //TO VIEW SCORE IN SCORE BOX
        TextView textView = (TextView)findViewById(R.id.ScoreBox_main);
        textView.setText(m.getChildScore()+"" );


//OPENING PLOTO
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
       //OPENING NEPTON LEVEL
        if( levelStatus=m.getLevelStatus("Nepton")==true) {

            nepton.setOnClickListener(new Button.OnClickListener() {

                public void onClick(View v) {


                                               try {
                                                   openNeptonActivity(m, finalLnum);
                                               } catch (ClassNotFoundException e) {
                                                   e.printStackTrace();
                                               }
                                          }

                                      }
            );
        } //END IF

        //OPENING zuhal LEVEL
        if( levelStatus=m.getLevelStatus("Saturn")==true) {

            Saturn.setOnClickListener(new Button.OnClickListener() {

                                          public void onClick(View v) {


                                              try {
                                                  openZuhalActivity(m, finalLnum);
                                              } catch (ClassNotFoundException e) {
                                                  e.printStackTrace();
                                              }
                                          }

                                      }
            );
        } //END IF
        //OPENING JUPITER LEVEL
        if( levelStatus=m.getLevelStatus("Jupiter")==true) {

            Jupiter.setOnClickListener(new Button.OnClickListener() {

                                          public void onClick(View v) {


                                              try {
                                                  openJupiterActivity(m, finalLnum);
                                              } catch (ClassNotFoundException e) {
                                                  e.printStackTrace();
                                              }
                                          }

                                      }
            );
        } //END IF
        //OPENING EARTH LEVEL
        if( levelStatus=m.getLevelStatus("Earth")==true) {

            Earth.setOnClickListener(new Button.OnClickListener() {

                                           public void onClick(View v) {


                                               try {
                                                   openEarthActivity(m, finalLnum);
                                               } catch (ClassNotFoundException e) {
                                                   e.printStackTrace();
                                               }
                                           }

                                       }
            );
        } //END IF




    }//END ONcreate

////


    public void openPlotoActivity(MySQLliteHelper M,int lnum2) throws ClassNotFoundException {
       lnum2=M.getNumOfLessonPassed("Ploto");
       TextView t=(TextView)findViewById(R.id.textView47);
      /* if (){
           M.UpdateNumOfLesson(1,"Ploto");
       }*/
        Lesson l=new Lesson();
        String name=l.getName(M.getNumOfLessonPassed("Ploto"));
        t.setText(name);
        Class c;
        try{
        c = Class.forName("com.example.a96653.LetsCode."+name);

         Intent  intent = new Intent(this,c);
            //Intent  intent = new Intent(this,firstlevel_5.class);

        startActivity(intent);}
        catch (Exception e){e.printStackTrace();}

    }
    //OPENING NEPTON ACTIVITY .
    public void openNeptonActivity(MySQLliteHelper M,int lnum2) throws ClassNotFoundException {
      /*  Intent  intent = new Intent(this,secondlevel_6.class);
        startActivity(intent);*/
        SharedPreferences prefs = getSharedPreferences("FIRSTSTARTOFNEPTON", MODE_PRIVATE);
        boolean firstStart = prefs.getBoolean("firstStart", true);
        if (firstStart){
            M.UpdateNumOfLesson(9,"Nepton");
            SharedPreferences pref = getSharedPreferences("FIRSTSTARTOFNEPTON", MODE_PRIVATE);
            SharedPreferences.Editor editor = prefs.edit();
            editor.putBoolean("firstStart", false);
            editor.apply();}
        lnum2=M.getNumOfLessonPassed("Nepton");
        TextView t=(TextView)findViewById(R.id.textView47);
      /* if (){
           M.UpdateNumOfLesson(1,"Ploto");
       }*/
        Lesson l=new Lesson();
        String name=l.getName(M.getNumOfLessonPassed("Nepton"));
        t.setText(name);
        Class c;
        try{
            c = Class.forName("com.example.a96653.LetsCode."+name);

          Intent  intent = new Intent(this,c);
           //Intent  intent = new Intent(this,secondlevel_20.class);
            startActivity(intent);}
        catch (Exception e){e.printStackTrace();}

    }
    //OPENING ZUHAL ACTIVITY .
    public void openZuhalActivity(MySQLliteHelper M,int lnum2) throws ClassNotFoundException {
      /*  Intent  intent = new Intent(this,secondlevel_6.class);
        startActivity(intent);*/
        SharedPreferences prefs = getSharedPreferences("FIRSTSTARTOFZUHAL", MODE_PRIVATE);
        boolean firstStart = prefs.getBoolean("firstStart", true);
        if (firstStart){
            M.UpdateNumOfLesson(29,"Saturn");//MUST BE CHANGED TO FIRST INTERFACE IN ZUHAL
            SharedPreferences pref = getSharedPreferences("FIRSTSTARTOFZUHAL", MODE_PRIVATE);
            SharedPreferences.Editor editor = prefs.edit();
            editor.putBoolean("firstStart", false);
            editor.apply();}
        lnum2=M.getNumOfLessonPassed("Saturn");
        TextView t=(TextView)findViewById(R.id.textView47);
      /* if (){
           M.UpdateNumOfLesson(1,"Ploto");
       }*/
        Lesson l=new Lesson();
        String name=l.getName(M.getNumOfLessonPassed("Saturn"));
        t.setText(name);
        Class c;
        try{
            c = Class.forName("com.example.a96653.LetsCode."+name);

            Intent  intent = new Intent(this,c);
            //Intent  intent = new Intent(this,certificate.class);
            startActivity(intent);}
        catch (Exception e){e.printStackTrace();}

    }
    //OPENING Jupiter ACTIVITY .
    public void openJupiterActivity(MySQLliteHelper M,int lnum2) throws ClassNotFoundException {

        SharedPreferences prefs = getSharedPreferences("FIRSTSTARTOFJupiter", MODE_PRIVATE);
        boolean firstStart = prefs.getBoolean("firstStart", true);
        if (firstStart){
            M.UpdateNumOfLesson(53,"Jupiter");
            SharedPreferences pref = getSharedPreferences("FIRSTSTARTOFJupiter", MODE_PRIVATE);
            SharedPreferences.Editor editor = prefs.edit();
            editor.putBoolean("firstStart", false);
            editor.apply();}

        lnum2=M.getNumOfLessonPassed("Jupiter");
        TextView t=(TextView)findViewById(R.id.textView47);

        Lesson l=new Lesson();
        String name=l.getName(M.getNumOfLessonPassed("Jupiter"));
        t.setText(name);
        Class c;
        try{
            c = Class.forName("com.example.a96653.LetsCode."+name);

             Intent  intent = new Intent(this,c);
           // Intent  intent = new Intent(this,certificate.class);
            startActivity(intent);}
        catch (Exception e){e.printStackTrace();}

    }

    //OPENING Earth ACTIVITY .
    public void openEarthActivity(MySQLliteHelper M,int lnum2) throws ClassNotFoundException {

       /* SharedPreferences prefs = getSharedPreferences("FIRSTSTARTOFJupiter", MODE_PRIVATE);
        boolean firstStart = prefs.getBoolean("firstStart", true);
        if (firstStart){
            M.UpdateNumOfLesson(53,"Jupiter");
            SharedPreferences pref = getSharedPreferences("FIRSTSTARTOFJupiter", MODE_PRIVATE);
            SharedPreferences.Editor editor = prefs.edit();
            editor.putBoolean("firstStart", false);
            editor.apply();}*/

      /*  lnum2=M.getNumOfLessonPassed("Jupiter");
        TextView t=(TextView)findViewById(R.id.textView47);*/

      //  Lesson l=new Lesson();
       // String name=l.getName(M.getNumOfLessonPassed("Jupiter"));
        //t.setText(name);
        Class c;
        try{
           // c = Class.forName("com.example.a96653.LetsCode."+name);

           // Intent  intent = new Intent(this,c);
            Intent  intent = new Intent(this,certificate.class);
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
