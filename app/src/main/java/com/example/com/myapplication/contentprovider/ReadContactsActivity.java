package com.example.com.myapplication.contentprovider;

import android.content.ContentProvider;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.com.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class ReadContactsActivity extends ActionBarActivity {

    private ListView listView;
    private ArrayAdapter<String> adapter;

    private List<String> data = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_contacts);

        listView = (ListView) findViewById(R.id.content_list_view);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data);

        listView.setAdapter(adapter);

        readContacts();
    }

    private void readContacts() {
        Cursor cursor = null;
        try {
            cursor = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, null);
            while (cursor.moveToNext()) {
                String name = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
                String phone = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                data.add(name + "\n" + phone);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (cursor != null)
                cursor.close();
        }
    }
}