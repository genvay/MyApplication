package com.example.com.myapplication.http;


import com.google.gson.annotations.SerializedName;

/**
 * Created by majingwei on 2015/8/3.
 */
public class App {

    private String type;
    private String name;
    private int appid;
    private String icon;
    private String packagemd5;

    @SerializedName("package")
    private String packageName;

    private String packagesize;
    private String packagelink;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAppid() {
        return appid;
    }

    public void setAppid(int appid) {
        this.appid = appid;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getPackagemd5() {
        return packagemd5;
    }

    public void setPackagemd5(String packagemd5) {
        this.packagemd5 = packagemd5;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getPackagesize() {
        return packagesize;
    }

    public void setPackagesize(String packagesize) {
        this.packagesize = packagesize;
    }

    public String getPackagelink() {
        return packagelink;
    }

    public void setPackagelink(String packagelink) {
        this.packagelink = packagelink;
    }
}
