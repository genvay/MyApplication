package com.example.com.myapplication.http;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.com.myapplication.R;

import java.util.List;

/**
 * Created by majingwei on 2015/8/4.
 */
public class AppAdapter extends ArrayAdapter<App> {

    private int resourceId;

    public AppAdapter(Context context, int textViewSourceId, List<App> objects) {
        super(context, textViewSourceId, objects);
        resourceId = textViewSourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        App app = getItem(position);

        View view;
        ViewHolder viewHolder;

        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(resourceId, null);
            viewHolder = new ViewHolder();
            viewHolder.name = (TextView) view.findViewById(R.id.app_name);
            viewHolder.pacakge = (TextView) view.findViewById(R.id.app_pacakge);
            viewHolder.appid = (TextView) view.findViewById(R.id.app_appid);
            view.setTag(viewHolder);
        } else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }

        viewHolder.name.setText(app.getName());
        viewHolder.pacakge.setText(app.getPackageName());
        viewHolder.appid.setText(String.valueOf(app.getAppid()));

        return view;
    }

    class ViewHolder {
        TextView name;
        TextView pacakge;
        TextView appid;
    }

}
