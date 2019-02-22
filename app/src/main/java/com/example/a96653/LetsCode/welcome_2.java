/*package com.example.a96653.practice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class welcome_2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_2);

        TextView NameDisplaytextView=(TextView) findViewById(R.id.NameDisplaytextView);

        Button goButton = (Button)findViewById(R.id.button2);

        goButton.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){

                        openSecondActivity();
                    }

                }

        );
        if (getIntent().hasExtra("com.example.a96653.practice.Something")){
            String t=getIntent().getExtras().getString("com.example..a96653.practice.Something");
            NameDisplaytextView.setText(t);

        }

    }

    public void openSecondActivity(){
        Intent intent=new Intent(this,welcome_3.class);
        startActivity(intent);


}}*/

package com.example.a96653.LetsCode;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class welcome_2 extends AppCompatActivity {
    //dfgmsrbg

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_2);
        TextView nameView=(TextView) findViewById(R.id.NameDisplaytextView);
        final MySQLliteHelper mySqliteOpenHelper=new MySQLliteHelper(this);
      //  Bundle b=getIntent().getExtras();
      //  String name=b.getString("name");
       // nameView.setText(name);
        Button intalqbtn=(Button) findViewById(R.id.button2);
        intalqbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent next2=new Intent(getApplicationContext(),welcome_3.class);
                startActivity(next2);
                mySqliteOpenHelper.UpdateWelcomingTable("welcome3",1);
            }
        });

        nameView.setText(  mySqliteOpenHelper. getChildName());
       if (getIntent().hasExtra("com.example.a96653.LetsCode")){
            String t=getIntent().getExtras().getString("com.example.a96653.LetsCode");
            nameView.setText(t);


        }


    }
}
