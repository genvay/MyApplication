package com.example.com.myapplication.http;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by majingwei on 2015/8/4.
 */
public class GsonTest {

    public static final String TAG = "GsonTest";

    public static void main(String[] args) {

        //gsonDemo();

    }

    public static void gsonDemo() {
        List<App> apps = new ArrayList<App>();

        App app1 = new App();

        app1.setName("appmall");
        app1.setAppid(1);
        app1.setIcon("http://icon.png");
        app1.setPackagelink("http://packagelink.apk");
        app1.setPackagesize("123456");
        app1.setPackagemd5("846564684646");
        app1.setType("abcd");
        app1.setPackageName("com.sogou.appmall");

        apps.add(app1);

        App app2 = new App();

        app2.setName("appmall2");
        app2.setAppid(2);
        app2.setIcon("http://icon2.png");
        app2.setPackagelink("http://2packagelink.apk");
        app2.setPackagesize("2123456");
        app2.setPackagemd5("2846564684646");
        app2.setType("2abcd");
        app2.setPackageName("2com.sogou.appmall");

        apps.add(app2);

        Gson gson = new Gson();
        String str = gson.toJson(apps);
        System.out.println(str);

        List<App> aps = gson.fromJson(str, new TypeToken<List<App>>() {
        }.getType());
//        System.out.println(new TypeToken<List<App>>(){}.getType());
        App ap1 = aps.get(0);
        System.out.println(ap1.getAppid());
        System.out.println(ap1.getName());
        System.out.println(ap1.getIcon());

        App ap2 = aps.get(1);
        System.out.println(ap2.getAppid());
        System.out.println(ap2.getName());
        System.out.println(ap2.getIcon());
    }


    public static void parseHotApps() {

        new Thread(new Runnable() {
            @Override
            public void run() {

                try {

                    HttpClient httpClient = new DefaultHttpClient();
                    HttpGet httpGet = new HttpGet("http://api.app.i.sogou.com/27/search/hot");
                    HttpResponse httpResponse = httpClient.execute(httpGet);

                    if (httpResponse.getStatusLine().getStatusCode() == 200) {

                        HttpEntity httpEntity = httpResponse.getEntity();
                        String response = EntityUtils.toString(httpEntity);

                        Gson gson = new Gson();
                        HotAppsBean hotApps = gson.fromJson(response, HotAppsBean.class);

                        int code = hotApps.getStatus().getCode();
                        String ver = hotApps.getStatus().getVer();
                        Log.e(TAG, "code:" + code);
                        Log.e(TAG, "ver:" + ver);

                        int listnum = hotApps.getData().getListnum();
                        Log.e(TAG, "listnum:" + listnum);

                        List<App> apps = hotApps.getData().getList();
                        for (int i = 0; i < apps.size(); i++) {
                            String name = apps.get(i).getName();
                            String packageName = apps.get(i).getPackageName();
                            int appid = apps.get(i).getAppid();
                            String packagelink = apps.get(i).getPackagelink();

                            Log.e(TAG, "name:" + name);
                            Log.e(TAG, "package:" + packageName);
                            Log.e(TAG, "appid:" + appid);
                            Log.e(TAG, "packagelink:" + packagelink);

                        }

                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }
}
