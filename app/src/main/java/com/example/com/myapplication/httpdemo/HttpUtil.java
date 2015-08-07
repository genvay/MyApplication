package com.example.com.myapplication.httpdemo;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by majingwei on 2015/8/7.
 */
public class HttpUtil {

    public static void sendHttpRequest(final String address, final HttpCallbackListener listener) {

        new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    URL url = new URL(address);
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("GET");

                    InputStream in = connection.getInputStream();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(in));

                    StringBuilder response = new StringBuilder();
                    String line;

                    while ((line = reader.readLine()) != null) {
                        response.append(line);
                    }

                    if (listener != null) {
                        listener.onFinish(response.toString());
                    }

                } catch (Exception e) {

                    if (listener != null) {
                        listener.onError(e);
                    }

                }

            }
        }).start();

    }

}
