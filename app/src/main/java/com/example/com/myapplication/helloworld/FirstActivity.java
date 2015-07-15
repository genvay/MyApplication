package com.example.com.myapplication.helloworld;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.com.myapplication.R;


public class FirstActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        Button bt = (Button) findViewById(R.id.first_activity_button);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                intent.putExtra("text", "FromFirstActivity");
                startActivity(intent);
            }
        });

        Button btToWeb = (Button) findViewById(R.id.to_web_button);
        btToWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://app.sogou.com"));
                startActivity(intent);
            }
        });


    }

}
