package com.example.com.myapplication.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by majingwei on 2015/7/17.
 */
public class BootCompleteReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "Welcome back, genvay", Toast.LENGTH_LONG).show();
        Log.e("eee","-------------------------");
    }
}
