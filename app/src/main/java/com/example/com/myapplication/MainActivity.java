package com.example.com.myapplication;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.com.myapplication.broadcast.BroadcastActivity;
import com.example.com.myapplication.contentprovider.ContentActivity;
import com.example.com.myapplication.file.FileActivity;
import com.example.com.myapplication.fragmentdemo.FragmentDemoActivity;
import com.example.com.myapplication.helloworld.FirstActivity;
import com.example.com.myapplication.http.NetActivity;
import com.example.com.myapplication.listview.ListviewActivity;
import com.example.com.myapplication.newsdemo.NewsDemoActivity;
import com.example.com.myapplication.talkdemo.TalkActivity;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("MainActivity", "OnCreate is running");

        Button btShowToast = (Button) findViewById(R.id.show_toast_button);
        btShowToast.setOnClickListener(this);

        Button btToSecondActivity = (Button) findViewById(R.id.hello_button);
        btToSecondActivity.setOnClickListener(this);

        Button btActivity = (Button) findViewById(R.id.activity_button);
        btActivity.setOnClickListener(this);

        Button btUI = (Button) findViewById(R.id.ui_button);
        btUI.setOnClickListener(this);

        Button btListView = (Button) findViewById(R.id.list_view_button);
        btListView.setOnClickListener(this);

        Button btTalkDemo = (Button) findViewById(R.id.talk_demo_button);
        btTalkDemo.setOnClickListener(this);

        Button btFragment = (Button) findViewById(R.id.fragment_button);
        btFragment.setOnClickListener(this);

        Button btNewsDemo = (Button) findViewById(R.id.news_demo_button);
        btNewsDemo.setOnClickListener(this);

        Button btBroadCast = (Button) findViewById(R.id.broadcast_button);
        btBroadCast.setOnClickListener(this);

        Button btFile = (Button) findViewById(R.id.file_button);
        btFile.setOnClickListener(this);

        Button btContentProvider = (Button) findViewById(R.id.content_provider_button);
        btContentProvider.setOnClickListener(this);

        Button btHttp = (Button) findViewById(R.id.network_button);
        btHttp.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.show_toast_button:
                Toast.makeText(MainActivity.this, "Click button", Toast.LENGTH_SHORT).show();
                break;
            case R.id.hello_button:
                intent = new Intent(MainActivity.this, FirstActivity.class);
                startActivity(intent);
                break;
            case R.id.activity_button:
                intent = new Intent(MainActivity.this, com.example.com.myapplication.activity.FirstActivity.class);
                startActivity(intent);
                break;
            case R.id.ui_button:
                intent = new Intent(MainActivity.this, com.example.com.myapplication.ui.FirstActivity.class);
                startActivity(intent);
                break;
            case R.id.list_view_button:
                intent = new Intent(MainActivity.this, ListviewActivity.class);
                startActivity(intent);
                break;
            case R.id.talk_demo_button:
                intent = new Intent(MainActivity.this, TalkActivity.class);
                startActivity(intent);
                break;
            case R.id.fragment_button:
                intent = new Intent(MainActivity.this, FragmentDemoActivity.class);
                startActivity(intent);
                break;
            case R.id.news_demo_button:
                intent = new Intent(MainActivity.this, NewsDemoActivity.class);
                startActivity(intent);
                break;
            case R.id.broadcast_button:
                intent = new Intent(MainActivity.this, BroadcastActivity.class);
                startActivity(intent);
                break;
            case R.id.file_button:
                intent = new Intent(MainActivity.this, FileActivity.class);
                startActivity(intent);
                break;
            case R.id.content_provider_button:
                intent = new Intent(MainActivity.this, ContentActivity.class);
                startActivity(intent);
                break;
            case R.id.network_button:
                Intent intent = new Intent(MainActivity.this, NetActivity.class);
                startActivity(intent);
                break;

            default:
                break;
        }

    }
}
