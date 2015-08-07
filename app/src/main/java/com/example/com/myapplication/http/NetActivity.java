package com.example.com.myapplication.http;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.com.myapplication.R;
import com.example.com.myapplication.httpdemo.HttpUrlConnectionDemoActivity;

/**
 * Created by Administrator on 2015/8/2.
 */
public class NetActivity extends Activity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net);

        Button bt1 = (Button) findViewById(R.id.net_web_view_demo);
        bt1.setOnClickListener(this);

        Button bt2 = (Button) findViewById(R.id.http_url_connection);
        bt2.setOnClickListener(this);

        Button bt3 = (Button) findViewById(R.id.net_http_client);
        bt3.setOnClickListener(this);

        Button bt4 = (Button) findViewById(R.id.http_url_connection_plus);
        bt4.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        Intent intent;

        switch (v.getId()) {
            case R.id.net_web_view_demo:
                intent = new Intent(NetActivity.this, NetWebViewActivity.class);
                startActivity(intent);
                break;
            case R.id.http_url_connection:
                intent = new Intent(NetActivity.this, HttpUrlConnectionActivity.class);
                startActivity(intent);
                break;
            case R.id.net_http_client:
                intent = new Intent(NetActivity.this, HttpClientActivity.class);
                startActivity(intent);
                break;
            case R.id.http_url_connection_plus:
                intent = new Intent(NetActivity.this, HttpUrlConnectionDemoActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
