package com.example.com.myapplication.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.com.myapplication.R;
import com.example.com.myapplication.model.Fruit;

import java.util.List;

/**
 * Created by majingwei on 2015/7/14.
 */
public class FruitAdapter extends ArrayAdapter<Fruit> {

    private int resourceId;

    public FruitAdapter(Context context, int textViewSourceId, List<Fruit> objects) {
        super(context, textViewSourceId, objects);
        resourceId = textViewSourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Fruit fruit = getItem(position);

        View view;
        ViewHolder viewHolder;
        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(resourceId, null);
            viewHolder = new ViewHolder();
            viewHolder.fruitImage = (ImageView) view.findViewById(R.id.listview_fruit_img);
            viewHolder.fruitName = (TextView) view.findViewById(R.id.listview_fruit_name);
            view.setTag(viewHolder);
        } else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }

        //ImageView fruitImage = (ImageView) view.findViewById(R.id.listview_fruit_img);
        //TextView fruitName = (TextView) view.findViewById(R.id.listview_fruit_name);
        viewHolder.fruitImage.setImageResource(fruit.getImgId());
        viewHolder.fruitName.setText(fruit.getName());
        return view;
    }

    class ViewHolder {
        ImageView fruitImage;
        TextView fruitName;
    }
}
