package com.example.tarun.auxilium;


/*package net.simplifiedcoding.androidtablayout;
*/
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.graphics.drawable.AnimationDrawable;
import android.widget.Toast;

/**
 * Created by Belal on 2/3/2016.
 */

//Our class extending fragment
public class Tab1 extends Fragment
{
    private View v;

    //Overriden method onCreateView
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, final Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.tab1, container, false);
        AnimationDrawable animation = new AnimationDrawable();
        ImageView image_view =(ImageView) v.findViewById(R.id.imageView);

        animation.addFrame(getResources().getDrawable(R.drawable.h1), 2000);
        animation.addFrame(getResources().getDrawable(R.drawable.h2), 2000);
        animation.addFrame(getResources().getDrawable(R.drawable.h3), 2000);
        animation.addFrame(getResources().getDrawable(R.drawable.h4), 2000);

        animation.setOneShot(false);
        image_view.setBackgroundDrawable(animation);

        animation.start();

        ImageButton btn_clicked=(ImageButton)v.findViewById(R.id.imageButton);
        ImageButton relief_btn_clicked=(ImageButton)v.findViewById(R.id.imageButton2);
        btn_clicked.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                    toSendEmergencyMessageMethod();
            }
        });
        relief_btn_clicked.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toSendReliefMessageMethod();
            }
        });
        return v;
    }

    public void toSendEmergencyMessageMethod()
    {
        AlertDialog.Builder ab =new AlertDialog.Builder(getActivity());
        ab.setMessage("Do you want to send the Message")
                .setCancelable(false).setPositiveButton("yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                Intent intent=new Intent(getActivity(),SendingEmergencyMessage.class);
                startActivity(intent);
            }
        }).setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                dialog.cancel();
            }
        });
        AlertDialog alert=ab.create();
        alert.setTitle("DELETION CONFIRMATION");
        alert.show();
    }

    public void toSendReliefMessageMethod()
    {
        AlertDialog.Builder ab =new AlertDialog.Builder(getActivity());
        ab.setMessage("Do you want to send the Message")
                .setCancelable(false).setPositiveButton("yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                Intent intent=new Intent(getActivity(),SendingReliefMessage.class);
                startActivity(intent);
            }
        }).setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                dialog.cancel();
            }
        });
        AlertDialog alert=ab.create();
        alert.setTitle("DELETION CONFIRMATION");
        alert.show();
    }

}






