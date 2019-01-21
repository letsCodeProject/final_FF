package com.example.a96653.practice;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatDialogFragment;

public class example extends AppCompatDialogFragment {

/// shatha can you see
    public Dialog onCreateDialog(Bundle savedInstanceState){

        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        builder.setTitle("information")
        .setMessage("swjfwkvbek")

        .setPositiveButton("ok",new DialogInterface.OnClickListener(){


            public void onClick(DialogInterface dialogInterface,int i){


            }


                }


        )  ;

        return builder.create();

    }
}
