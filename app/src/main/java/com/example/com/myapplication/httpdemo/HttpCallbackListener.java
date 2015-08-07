package com.example.com.myapplication.httpdemo;

/**
 * Created by majingwei on 2015/8/7.
 */
public interface HttpCallbackListener {

    void onFinish(String string);

    void onError(Exception exception);

}
