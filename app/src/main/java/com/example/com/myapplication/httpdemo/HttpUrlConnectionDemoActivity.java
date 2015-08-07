package com.example.com.myapplication.httpdemo;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.com.myapplication.R;
import com.example.com.myapplication.http.App;
import com.example.com.myapplication.http.AppAdapter;
import com.example.com.myapplication.http.HotAppsBean;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class HttpUrlConnectionDemoActivity extends ActionBarActivity implements View.OnClickListener {

    public static final String TAG = "HttpUrlConnectionDemo";

    public static final int SHOW_RESPONSE = 0;
    public static final int SHOW_LIST = 1;

    Button mSendRequest;
    TextView mTextView;
    ListView mListView;

    HotAppsBean res = new HotAppsBean();

    List<App> apps = new ArrayList<App>();

    public Handler handler = new Handler() {
        @Override
        public void handleMessage(android.os.Message msg) {
            switch (msg.what) {

                case SHOW_RESPONSE:
                    mTextView.setText(String.valueOf(msg.obj));
                    break;

                case SHOW_LIST:
                    AppAdapter adapter = new AppAdapter(HttpUrlConnectionDemoActivity.this, R.layout.app_item, apps);
                    mListView.setAdapter(adapter);
                    break;

            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_http_url_connection_demo);

        mSendRequest = (Button) findViewById(R.id.http_url_connection_plus_send);
        mSendRequest.setOnClickListener(this);

        mTextView = (TextView) findViewById(R.id.http_url_connection_plus_text_view);

        mListView = (ListView) findViewById(R.id.http_url_connection_plus_list_view);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.http_url_connection_plus_send:
                sendHttpRequest();
                break;
            default:
                break;
        }
    }

    private void sendHttpRequest() {

        HttpUtil.sendHttpRequest("http://api.app.i.sogou.com/27/search/hot", new HttpCallbackListener() {

            @Override
            public void onFinish(String response) {
                Log.e(TAG, "onFinish called");
//                showResponse(response);
                showListView(response);
            }

            @Override
            public void onError(Exception e) {
                Log.e(TAG, "onError called");
                e.printStackTrace();
            }
        });

    }

    private void showResponse(String response) {
        Message message = new Message();
        message.what = SHOW_RESPONSE;
        message.obj = response;
        handler.sendMessage(message);
    }

    private void showListView(String jsonData) {

        Gson gson = new Gson();
        res = gson.fromJson(jsonData, HotAppsBean.class);

        apps = res.getData().getList();

        for (App app : apps) {
            Log.e(TAG, "name:" + app.getName());
            Log.e(TAG, "name:" + app.getPackageName());
            Log.e(TAG, "name:" + app.getAppid());
        }

        Message message = new Message();
        message.what = SHOW_LIST;
        message.obj = apps;
        handler.sendMessage(message);

    }

}
