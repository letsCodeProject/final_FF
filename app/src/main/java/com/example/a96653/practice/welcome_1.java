/*package com.example.a96653.practice;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class welcome_1 extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_1);

     final   EditText txt=(EditText)findViewById(R.id.editText);

        Button startButton = (Button)findViewById(R.id.button);

        startButton.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){

                        if(txt.getText().toString().isEmpty()){
                           /* AlertDialog.Builder mbuilder=new AlertDialog.Builder(welcome_1.this);
                            View mView=getLayoutInflater().inflate(R.layout.name_exception,null);
                            Button btn = (Button) mView.findViewById(R.id.button5);

                            mbuilder.setView(mView);
                            final  AlertDialog c=mbuilder.create();
                            c.show();
                            btn.setOnClickListener(new View.OnClickListener(){

                                public void onClick(View view){

                                      c.dismiss();*/

//  }




//});




//  }


/*

                        else {openSecondActivity();};


                    }


                } );


    }

public void openSecondActivity(){
      Intent intent=new Intent(this,welcome_2.class);
      startActivity(intent);


}


}
*/
package com.example.a96653.practice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class welcome_1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_1);
        Button button= findViewById(R.id.button);

        final Intent next=new Intent(getApplicationContext(),welcome_2.class);

        button.setOnClickListener(new View.OnClickListener() {

            EditText txt4 = (EditText) findViewById(R.id.editText);
            public String nameContent = String.valueOf(txt4);

            @Override
            public void onClick(View v) {

                if (txt4.getText().toString().isEmpty())
                    txt4.setError(Html.fromHtml("<font color='white'>أدخل إسمك من فضلك</font>"));

                else
                {
                    next.putExtra("com.example.a96653.practice", txt4.getText().toString()+"");
                    startActivity(next);
                }














            }//end of onClick method
        });
    }

   /* public void ebdabtn(View view) {
        EditText name=(EditText) findViewById(R.id.editText);
        Intent myintent=new Intent(this,welcome_2.class);
        Bundle b=new Bundle();
        b.putString("name",name.getText().toString());
       myintent.putExtras(b);
        startActivity(myintent);

    }*/
}
