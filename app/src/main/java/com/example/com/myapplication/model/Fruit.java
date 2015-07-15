package com.example.com.myapplication.model;

/**
 * Created by majingwei on 2015/7/14.
 */
public class Fruit {

    private String name;

    private int imgId;

    public Fruit(String name, int imgId) {
        this.name = name;
        this.imgId = imgId;
    }

    public int getImgId() {
        return imgId;
    }

    public String getName() {
        return name;
    }

}
