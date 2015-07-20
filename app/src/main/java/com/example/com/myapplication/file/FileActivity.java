package com.example.com.myapplication.file;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.com.myapplication.R;

public class FileActivity extends ActionBarActivity {

    EditText fileEditText, keyEditText, valueEditText;
    Button saveFileButton, getFileButton, saveSharedPreference, getSharedPreference;
    TextView fileContent, sharedPreferenceValue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file);












    }

}
