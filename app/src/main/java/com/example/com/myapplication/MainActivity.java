package com.example.com.myapplication;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.com.myapplication.broadcast.BroadcastActivity;
import com.example.com.myapplication.fragmentdemo.FragmentDemoActivity;
import com.example.com.myapplication.helloworld.FirstActivity;
import com.example.com.myapplication.listview.ListviewActivity;
import com.example.com.myapplication.newsdemo.NewsDemoActivity;
import com.example.com.myapplication.talkdemo.TalkActivity;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("MainActivity", "OnCreate is running");

        Button btShowToast = (Button) findViewById(R.id.show_toast_button);

        btShowToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Click button", Toast.LENGTH_SHORT).show();
            }
        });

        Button btToSecondActivity = (Button) findViewById(R.id.hello_button);
        btToSecondActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, FirstActivity.class);
                startActivity(intent);
            }
        });

        Button btActivity = (Button) findViewById(R.id.activity_button);
        btActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, com.example.com.myapplication.activity.FirstActivity.class);
                startActivity(intent);
            }
        });

        Button btUI = (Button) findViewById(R.id.ui_button);
        btUI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, com.example.com.myapplication.ui.FirstActivity.class);
                startActivity(intent);
            }
        });

        Button btListView = (Button) findViewById(R.id.list_view_button);
        btListView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ListviewActivity.class);
                startActivity(intent);
            }
        });

        Button btTalkDemo = (Button) findViewById(R.id.talk_demo_button);
        btTalkDemo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TalkActivity.class);
                startActivity(intent);
            }
        });

        Button btFragment = (Button) findViewById(R.id.fragment_button);
        btFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FragmentDemoActivity.class);
                startActivity(intent);
            }
        });

        Button btNewsDemo = (Button) findViewById(R.id.news_demo_button);
        btNewsDemo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NewsDemoActivity.class);
                startActivity(intent);
            }
        });

        Button btBroadCast = (Button) findViewById(R.id.broadcast_button);
        btBroadCast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, BroadcastActivity.class);
                startActivity(intent);
            }
        });


    }

}
