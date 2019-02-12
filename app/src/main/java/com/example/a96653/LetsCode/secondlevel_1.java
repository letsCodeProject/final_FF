package com.example.a96653.LetsCode;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class secondlevel_1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondlevel_1);
        //NEXT BUTTON
        final MySQLliteHelper m=new MySQLliteHelper(this);
    Button goButton=(Button) findViewById(R.id.talibutton);

      goButton.setOnClickListener(
              new Button.OnClickListener(){
        public void onClick(View v){
            openSecondActivity();
            SharedPreferences prefs = getSharedPreferences("pref_secondLevel_1", MODE_PRIVATE);
            boolean firstStart = prefs.getBoolean("firstStart", true);
            if (firstStart){
                m.UpdateNumOfLesson(10,"Nepton");
                SharedPreferences pref = getSharedPreferences("pref_secondLevel_1", MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putBoolean("firstStart", false);
                editor.apply();}
        }//end onClick

    }//end onClickListner

        );

}//end onCreate

    public void openSecondActivity() {

        Intent intent = new Intent(this, secondlevel_2.class);
        startActivity(intent);

    }
}//end class
