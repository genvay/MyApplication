package com.example.com.myapplication.contentprovider;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.com.myapplication.R;

public class ContentActivity extends ActionBarActivity implements View.OnClickListener {

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);

        Button btRead = (Button) findViewById(R.id.content_read_contacts);
        btRead.setOnClickListener(this);

        Button btMyContent = (Button) findViewById(R.id.content_my_content);
        btMyContent.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.content_read_contacts:
                intent = new Intent(ContentActivity.this, ReadContactsActivity.class);
                startActivity(intent);
                break;
            case R.id.content_my_content:
                intent = new Intent(ContentActivity.this, MyContentActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }

    }
}
