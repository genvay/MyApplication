package com.example.com.myapplication.http;

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
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HttpClientActivity extends ActionBarActivity implements View.OnClickListener {

    private static final String TAG = "HttpClientActivity";

    public static final int SHOW_MESSAGE = 0;
    public static final int SHOW_APPS = 1;

    Button mSendButton, mShowAppsBt;
    TextView mTextView;
    ListView mListView;

    List<App> apps;

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case SHOW_MESSAGE:
                    mTextView.setText(String.valueOf(msg.obj));
                    break;
                case SHOW_APPS:
                    AppAdapter adapter = new AppAdapter(HttpClientActivity.this, R.layout.app_item, apps);
                    mListView.setAdapter(adapter);
                    break;
            }
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_http_client);

        mSendButton = (Button) findViewById(R.id.net_send_http_client);
        mSendButton.setOnClickListener(this);
        mTextView = (TextView) findViewById(R.id.net_http_client_web_view);

        mShowAppsBt = (Button) findViewById(R.id.apps_show_button);
        mShowAppsBt.setOnClickListener(this);
        mListView = (ListView) findViewById(R.id.apps_list_view);
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.net_send_http_client) {
            sendRequestWithHttpClient();
        } else if (v.getId() == R.id.apps_show_button) {
            parseHotApps();
        }
    }

    private void sendRequestWithHttpClient() {

        new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    HttpClient httpClient = new DefaultHttpClient();
//                    HttpGet httpGet = new HttpGet("http://www.weather.com.cn/data/list3/city.xml");
//                    HttpGet httpGet = new HttpGet("http://api.app.i.sogou.com/30/list/richrcmd/1?page=1");
                    HttpGet httpGet = new HttpGet("http://api.app.i.sogou.com/27/search/hot");
                    HttpResponse httpResponse = httpClient.execute(httpGet);

                    if (httpResponse.getStatusLine().getStatusCode() == 200) {
                        HttpEntity httpEntity = httpResponse.getEntity();
                        String response = EntityUtils.toString(httpEntity, "utf-8");

//                        parseJSONWithJSONObject(response);
                        parseJSONWithGSON(response);

                        Message message = new Message();
                        message.what = SHOW_MESSAGE;
                        message.obj = response;
                        handler.sendMessage(message);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

        }).start();
    }

    private void parseJSONWithJSONObject(String jsonData) {

        try {
            JSONObject jsonObject = new JSONObject(jsonData);
            String status = jsonObject.getString("status");
            String data = jsonObject.getString("data");
            Log.e(TAG, "status: " + status);
            Log.e(TAG, "data: " + data);

            JSONObject jsonObj = new JSONObject(data);
            String list = jsonObj.getString("list");
            Log.e(TAG, "list: " + list);

            JSONArray jsonArray = new JSONArray(list);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject obj = jsonArray.getJSONObject(i);
                String app = obj.getString("app");
                Log.e(TAG, "app: " + app);

                JSONObject o = new JSONObject(app);
                String name = o.getString("name");
                String packageName = o.getString("package");
                Log.e(TAG, "name: " + name);
                Log.e(TAG, "packageName: " + packageName);

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    private void parseJSONWithGSON(String jsonData) {

        String data = null;
        try {
            JSONObject obj = new JSONObject(jsonData);
            data = obj.getString("data");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        String list = null;
        try {
            JSONObject o = new JSONObject(data);
            list = o.getString("list");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        Gson gson = new Gson();
        List<App> apps = gson.fromJson(list, new TypeToken<List<App>>() {
        }.getType());

        for (App app : apps) {
            Log.e(TAG, "name: " + app.getName());
            Log.e(TAG, "package: " + app.getPackageName());
            Log.e(TAG, "appid: " + app.getAppid());
        }

    }

    private void parseHotApps() {

        Log.e(TAG, "HttpClientActivity.parseHotApps is called");

        new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    HttpClient httpClient = new DefaultHttpClient();
                    HttpGet httpGet = new HttpGet("http://api.app.i.sogou.com/27/search/hot");
                    HttpResponse httpResponse = httpClient.execute(httpGet);

                    if (httpResponse.getStatusLine().getStatusCode() == 200) {

                        HttpEntity httpEntity = httpResponse.getEntity();
                        String response = EntityUtils.toString(httpEntity, "utf-8");

                        Gson gson = new Gson();
                        HotAppsBean hotApps = gson.fromJson(response, HotAppsBean.class);

                        apps = new ArrayList<App>();
                        for (int i = 0; i < hotApps.getData().getList().size(); i++) {
                            apps.add(hotApps.getData().getList().get(i));
                        }

                        Message message = new Message();
                        message.what = SHOW_APPS;
                        handler.sendMessage(message);

                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }).start();

    }

}