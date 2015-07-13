package com.example.com.myapplication.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by Administrator on 2015/7/12.
 */
public class BaseActivity extends Activity {

    String Tag = "BaseActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(Tag, getClass().getSimpleName());

        ActivityCollector.addActivity(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(Tag, "onDestroy is called");
        ActivityCollector.removeActivity(this);
    }
}
