package com.example.a96653.LetsCode;

import android.Manifest;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.StrictMode;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.graphics.Bitmap;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Calendar;
import java.text.SimpleDateFormat;
public class certificate extends AppCompatActivity {
    TextView t ;
    ImageButton homebtn9;
    ImageView SHARE_certificate;
    static MySQLliteHelper mySqliteOpenHelper;
    static Bitmap bm , bmp2;
    ImageView imageView2 ;
    Dialog mydialog ;
    Context mcontex;


    public static Intent shareintent2=new Intent (Intent.ACTION_SEND);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_certificate);
        mySqliteOpenHelper=new MySQLliteHelper(this);
        mcontex=getApplication();


        //HOME BUTTON
        homebtn9=(ImageButton)findViewById(R.id.homebtn_certificate);
        homebtn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gohome=new Intent (getApplicationContext(),MainActivity.class);
                startActivity(gohome);
            }
        });
        //TAKING CHILD'S NAME FROM DB
        TextView nameView=(TextView) findViewById(R.id.childName);
        nameView.setText(  mySqliteOpenHelper. getChildName());
        if (getIntent().hasExtra("com.example.a96653.LetsCode")){
            String t=getIntent().getExtras().getString("com.example.a96653.LetsCode");
            nameView.setText(t);
        }
        //GET CHILD'S SCORE
        TextView textView = (TextView)findViewById(R.id.CHILD_SCORE);
        textView.setText(mySqliteOpenHelper.getChildScore()+"" );
        //CHANGING DATE
        Date c = Calendar.getInstance().getTime();
        System.out.println("Current time => " + c);
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        String formattedDate = df.format(c);
        TextView date = (TextView)findViewById(R.id.date);
        date.setText(formattedDate );

        //CREATING TABLE FOR PICTURE .
        String sql="CREATE TABLE IF NOT EXISTS PIC( pic MEDIUMBLOB )";
        mySqliteOpenHelper.queryData(sql);
        //TAKING SCREENSHOT .
        SHARE_certificate=findViewById(R.id.SHARE_certificate);
        final View layout= findViewById(R.id.root_content);
        layout.setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY| View.SYSTEM_UI_FLAG_FULLSCREEN );
        imageView2 = (ImageView) findViewById(R.id.stamp);

        layout.post(new Runnable() {
            @Override
            public void run() {
                //TO REMOVE SYSTEM BORDERS
                layout.setBackgroundColor(Color.TRANSPARENT);
                homebtn9.setVisibility(View.INVISIBLE);
                SHARE_certificate.setVisibility(View.INVISIBLE);
                SharedPreferences prefs = getSharedPreferences("TakingScreenShot", MODE_PRIVATE);
                boolean firstStart = prefs.getBoolean("firstStart", true);
                if (firstStart){
                    bm=getScreenShot(layout);
                    SharedPreferences pref = getSharedPreferences("TakingScreenShot", MODE_PRIVATE);
                    SharedPreferences.Editor editor = prefs.edit();
                    editor.putBoolean("firstStart", false);
                    editor.apply();}
                homebtn9.setVisibility(View.VISIBLE);
                SHARE_certificate.setVisibility(View.VISIBLE);
                layout.setSystemUiVisibility(View.VISIBLE);
                layout.setBackgroundResource(R.drawable.back);
              /*  if (bm != null) {
                    retrieveImage( );//show bitmap over imageview
                }*/

            }
        });



        mydialog = new Dialog(this);
        SHARE_certificate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mydialog.setContentView(R.layout.optiondialog);

                mydialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                mydialog.show();
                Button save=(Button)mydialog.findViewById(R.id.savebutton);
                Button sharebtn =(Button)mydialog.findViewById(R.id.sharebutton);
                Button back =(Button)mydialog.findViewById(R.id.backbutton);
                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && checkCallingOrSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED) {
                    requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 0);
                }

                //Save will be added .
                save.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        retrieveImage();

                        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && checkCallingOrSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)== PackageManager.PERMISSION_GRANTED) {
                            double random1 = Math.random() * 7;
                            double random2 = Math.random() * 4;
                            store(bmp2,"certificate"+random1+"_"+random2+".png");}






                    }
                });

//__________________________________Share____________________________________________________________________
                sharebtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && checkCallingOrSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {

//_________________ to detect memory leak in android
                            StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
                            StrictMode.setVmPolicy(builder.build());
//_________________ retrive certificate from DB
                            Cursor cursor = mySqliteOpenHelper.getData();
                            cursor.moveToLast();
                            byte[] image = cursor.getBlob(cursor.getColumnIndex("pic"));

//_________________ convert from Byte to bitmap
                            Bitmap bmp = BitmapFactory.decodeByteArray(image, 0, image.length);

//_________________ identify an intent and set the type to image/ipg
                            Intent shareintent = new Intent(Intent.ACTION_SEND);
                            shareintent.setType("image/jpg");

//_________________ identify arrayoutputstream
                            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

//_________________Write a compressed version of the bitmap to the specified outputstream.
                            bmp.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);

//_________________identify file to write in the ByteArrayOutputStream
                            File file = new File(Environment.getExternalStorageDirectory() + File.separator + "ImageDemo.jpg");

                            try {
                                file.createNewFile();
                                FileOutputStream fileOutputStream = new FileOutputStream(file);
                                fileOutputStream.write(byteArrayOutputStream.toByteArray());
                                bmp.compress(Bitmap.CompressFormat.JPEG, 90, fileOutputStream);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
//____________________put text in share intent along with the certificate when processing the share option
                            shareintent.putExtra(Intent.EXTRA_TEXT, "لقد أتممت جميع مهماتي مع تطبيق هيا نبرمج   @Letscode_App.");

//____________________put the certificate in the share intent
                            shareintent.putExtra(Intent.EXTRA_STREAM, Uri.parse("file://" + file.getAbsolutePath()));

//____________________Ensure of Share permition
                            shareintent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                            shareintent.addFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
                            //____________________start the share intent
                            startActivity(Intent.createChooser(shareintent, "مشاركة الشهادة مع : "));
                        }//if
                    }//View
                });

                back.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mydialog.dismiss();
                    }
                });
                mydialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                mydialog.show();
            }//Parent button
        });//Parent


        //Onclick for Share



    }//end of onCreate .

    /*  Show screenshot Bitmap */
    private void retrieveImage( ) {
        try{

            Cursor cursor=mySqliteOpenHelper.getData();
            cursor.moveToLast();
            byte[] image= cursor.getBlob(cursor.getColumnIndex("pic"));

            Bitmap bmp = BitmapFactory.decodeByteArray(image, 0, image.length);
            bmp2=bmp;
            //  imageView2.setImageBitmap(bmp);


        }catch (Exception e){e.printStackTrace();   Toast.makeText(getApplicationContext(),"not added",Toast.LENGTH_SHORT).show();}




    }




    public static Bitmap getScreenShot(View view){
        View screenView=view.getRootView();
        screenView.setDrawingCacheEnabled(true);
        Bitmap bitmap=Bitmap.createBitmap(screenView.getDrawingCache());
        screenView.setDrawingCacheEnabled(false);

        bm=bitmap;
        try{mySqliteOpenHelper.insertData(ImageToByte());

        } catch (Exception e){e.printStackTrace();}
        return bitmap;

    }


    private static byte[] ImageToByte(){


        Bitmap icon = bm;

        ByteArrayOutputStream stream= new ByteArrayOutputStream();
        icon.compress(Bitmap.CompressFormat.PNG,100,stream);
        byte[] byteArray=stream.toByteArray();
        return byteArray;
    }


    public void store(Bitmap bm,String filename){

        String dirPath= Environment.getExternalStorageDirectory().getAbsolutePath()+"/LetsCode";
        File dir=new File(dirPath);
        if(!dir.exists()){
            dir.mkdir();
        }
        File file=new File(dirPath,filename);
        try {
            FileOutputStream fos=new FileOutputStream(file);
            bm.compress(Bitmap.CompressFormat.PNG,100,fos);
            fos.flush();
            fos.close();
            Toast.makeText(getApplicationContext(),"تم حفظ الشهادة",Toast.LENGTH_SHORT).show();




        }catch (Exception e){
            e.printStackTrace();
            Toast.makeText(this," theres an error",Toast.LENGTH_SHORT).show();

        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode==0){
            if(grantResults[0]==PackageManager.PERMISSION_GRANTED){

            }else{
                Toast.makeText(this,"premission granted",Toast.LENGTH_SHORT).show();
                //finish();
            }
        }
    }

}
