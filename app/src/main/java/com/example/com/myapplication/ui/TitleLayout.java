package com.example.com.myapplication.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.com.myapplication.R;

import java.util.jar.Attributes;

/**
 * Created by majingwei on 2015/7/14.
 */
public class TitleLayout extends LinearLayout {

    public TitleLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.title, this);

        Button btTitleBack = (Button) findViewById(R.id.title_back);
        btTitleBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "back button is clicked", Toast.LENGTH_SHORT).show();
            }
        });

        Button btTitleEdit = (Button) findViewById(R.id.title_edit);
        btTitleEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "edit button is clicked", Toast.LENGTH_SHORT).show();
            }
        });

    }



}
