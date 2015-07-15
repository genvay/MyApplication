package com.example.com.myapplication.listview;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.com.myapplication.R;
import com.example.com.myapplication.model.Fruit;

import java.util.ArrayList;
import java.util.List;

public class ListviewActivity extends ActionBarActivity {

    private String[] data = {"Apple", "Banana", "Orange", "Watermelon", "Pear", "Grape", "Pineapple", "Strawberry", "Cherry", "Mango", "Apple1", "Banana1", "Orange1", "Watermelon1", "Pear1", "Grape1", "Pineapple1", "Strawberry1", "Cherry1", "Mango1"};

    private List<Fruit> fruitList = new ArrayList<Fruit>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);

/*        ArrayAdapter<String> adapter = new ArrayAdapter<String>(ListviewActivity.this, android.R.layout.simple_list_item_1, data);
        ListView listview = (ListView) findViewById(R.id.listview_list);
        listview.setAdapter(adapter);*/

        initFruit();
        FruitAdapter adapter = new FruitAdapter(ListviewActivity.this, R.layout.fruit_item, fruitList);

        ListView listView = (ListView) findViewById(R.id.listview_list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Fruit fruit = fruitList.get(position);
                Toast.makeText(ListviewActivity.this, fruit.getName(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void initFruit() {
        Fruit apple = new Fruit("Apple", R.drawable.abc_ic_search);
        fruitList.add(apple);
        Fruit banana = new Fruit("Banana", R.drawable.abc_ic_voice_search);
        fruitList.add(banana);
        Fruit orange = new Fruit("Orange", R.drawable.abc_ic_search);
        fruitList.add(orange);
        Fruit watermelon = new Fruit("Watermelon", R.drawable.abc_ic_voice_search);
        fruitList.add(watermelon);
        Fruit pear = new Fruit("Pear", R.drawable.abc_ic_search);
        fruitList.add(pear);
        Fruit grape = new Fruit("Grape", R.drawable.abc_ic_search);
        fruitList.add(grape);
        Fruit pineapple = new Fruit("Pineapple", R.drawable.abc_ic_search);
        fruitList.add(pineapple);
        Fruit strawberry = new Fruit("Strawberry", R.drawable.abc_ic_search);
        fruitList.add(strawberry);
        Fruit cherry = new Fruit("Cherry", R.drawable.abc_ic_search);
        fruitList.add(cherry);
        Fruit mango = new Fruit("Mango", R.drawable.abc_ic_search);
        fruitList.add(mango);
        Fruit apple1 = new Fruit("Apple1", R.drawable.abc_ic_voice_search);
        fruitList.add(apple1);
        Fruit banana1 = new Fruit("Banana1", R.drawable.abc_ic_voice_search);
        fruitList.add(banana1);
        Fruit orange1 = new Fruit("Orange1", R.drawable.abc_ic_voice_search);
        fruitList.add(orange1);
        Fruit watermelon1 = new Fruit("Watermelon1", R.drawable.abc_ic_voice_search);
        fruitList.add(watermelon1);
        Fruit pear1 = new Fruit("Pear1", R.drawable.abc_ic_voice_search);
        fruitList.add(pear1);
        Fruit grape1 = new Fruit("Grape1", R.drawable.abc_ic_voice_search);
        fruitList.add(grape1);
        Fruit pineapple1 = new Fruit("Pineapple1", R.drawable.abc_ic_voice_search);
        fruitList.add(pineapple1);
        Fruit strawberry1 = new Fruit("Strawberry1", R.drawable.abc_ic_voice_search);
        fruitList.add(strawberry1);
        Fruit cherry1 = new Fruit("Cherry1", R.drawable.abc_ic_voice_search);
        fruitList.add(cherry1);
        Fruit mango1 = new Fruit("Mango1", R.drawable.abc_ic_voice_search);
        fruitList.add(mango1);
        Fruit apple2 = new Fruit("Apple2", R.drawable.abc_ic_voice_search);
        fruitList.add(apple2);
        Fruit banana2 = new Fruit("Banana2", R.drawable.abc_ic_voice_search);
        fruitList.add(banana2);
        Fruit orange2 = new Fruit("Orange2", R.drawable.abc_ic_voice_search);
        fruitList.add(orange2);
        Fruit watermelon2 = new Fruit("Watermelon2", R.drawable.abc_ic_voice_search);
        fruitList.add(watermelon2);
        Fruit pear2 = new Fruit("Pear2", R.drawable.abc_ic_voice_search);
        fruitList.add(pear2);
        Fruit grape2 = new Fruit("Grape2", R.drawable.abc_ic_voice_search);
        fruitList.add(grape2);
        Fruit pineapple2 = new Fruit("Pineapple2", R.drawable.abc_ic_voice_search);
        fruitList.add(pineapple2);
        Fruit strawberry2 = new Fruit("Strawberry2", R.drawable.abc_ic_voice_search);
        fruitList.add(strawberry2);
        Fruit cherry2 = new Fruit("Cherry2", R.drawable.abc_ic_voice_search);
        fruitList.add(cherry2);
        Fruit mango2 = new Fruit("Mango2", R.drawable.abc_ic_voice_search);
        fruitList.add(mango2);
    }

}
