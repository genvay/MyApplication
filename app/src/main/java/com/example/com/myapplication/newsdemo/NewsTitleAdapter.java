package com.example.com.myapplication.newsdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


import com.example.com.myapplication.R;

import java.util.List;

/**
 * Created by majingwei on 2015/7/15.
 */
public class NewsTitleAdapter extends ArrayAdapter<News> {

    private int resourceId;

    public NewsTitleAdapter(Context context, int textViewResourceId, List<News> objects) {
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        News news = getItem(position);
        View view;

        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(resourceId, null);
        } else {
            view = convertView;
        }
        TextView newsTitle = (TextView) view.findViewById(R.id.news_title);
        newsTitle.setText(news.getTitle());

        return view;
    }
}
