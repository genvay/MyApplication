package com.example.com.myapplication.file;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.com.myapplication.R;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class FileActivity extends ActionBarActivity {

    EditText fileEditText, keyEditText, valueEditText;
    Button saveFileButton, getFileButton, saveSharedPreference, getSharedPreference;
    TextView fileContent, sharedPreferenceValue;

    EditText mUsername;
    EditText mPassword;
    CheckBox mIsRememberPassword;
    Button mLoginBt;

    Button mSqlite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file);

        fileEditText = (EditText) findViewById(R.id.file_input);
        saveFileButton = (Button) findViewById(R.id.file_save_file);
        getFileButton = (Button) findViewById(R.id.file_get_file);
        fileContent = (TextView) findViewById(R.id.file_text_view);

        fileEditText.setText(load());

        saveFileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save(fileEditText.getText().toString());
            }
        });

        getFileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fileContent.setText(load());
            }
        });

        keyEditText = (EditText) findViewById(R.id.shared_preference_input_key);
        valueEditText = (EditText) findViewById(R.id.shared_preference_input_value);
        saveSharedPreference = (Button) findViewById(R.id.shared_preference_save_button);
        getSharedPreference = (Button) findViewById(R.id.shared_preference_get_button);
        sharedPreferenceValue = (TextView) findViewById(R.id.shared_preference_key_value);

        saveSharedPreference.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = getSharedPreferences("spf", MODE_PRIVATE).edit();
                editor.putString(keyEditText.getText().toString(), valueEditText.getText().toString());
                editor.commit();
            }
        });

        getSharedPreference.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences spf = getSharedPreferences("spf", MODE_PRIVATE);
                String value = spf.getString("key", "value");
                sharedPreferenceValue.setText("key: " + value);
            }
        });

        // login demo
        mUsername = (EditText) findViewById(R.id.login_demo_username_input);
        mPassword = (EditText) findViewById(R.id.login_demo_password_input);
        mIsRememberPassword = (CheckBox) findViewById(R.id.login_demo_remember_password);
        mLoginBt = (Button) findViewById(R.id.login_demo_login_button);

        if (getIsRememberPass()) {
            mUsername.setText("genvay");
            mPassword.setText("password");
            mIsRememberPassword.setChecked(true);
        }

        mLoginBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username = mUsername.getText().toString();
                String password = mPassword.getText().toString();

                if (null == username || "".equals(username) || null == password || "".equals(password)) {
                    Toast.makeText(FileActivity.this, "username or password is null", Toast.LENGTH_SHORT).show();
                }

                if ("genvay".equals(username) && "password".equals(password)) {

                    if (mIsRememberPassword.isChecked()) {
                        savePassToSpf();
                    } else {
                        clearPassSpf();
                    }

                    Intent intent = new Intent(FileActivity.this, LoginResultActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(FileActivity.this, "username or password is wrong", Toast.LENGTH_SHORT).show();
                }
            }
        });


        mSqlite = (Button) findViewById(R.id.to_sqlite);
        mSqlite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(FileActivity.this, SqliteActivity.class);
                startActivity(intent);
            }
        });


    }

    private void save(String input) {

        FileOutputStream fileOutputStream;
        Writer writer = null;

        try {
            fileOutputStream = openFileOutput("data", MODE_PRIVATE);
            writer = new BufferedWriter(new OutputStreamWriter(fileOutputStream));
            writer.write(input);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    private String load() {

        FileInputStream fileInputStream;
        BufferedReader reader = null;
        StringBuilder content = new StringBuilder();

        try {
            fileInputStream = openFileInput("data");
            reader = new BufferedReader(new InputStreamReader(fileInputStream));

            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return content.toString();

    }

    protected boolean getIsRememberPass() {
        boolean flag;
        SharedPreferences spf = getSharedPreferences("data", MODE_PRIVATE);
        flag = spf.getBoolean("isRememberPass", false);
        return flag;
    }

    private void savePassToSpf() {

        SharedPreferences.Editor editor = getSharedPreferences("data", MODE_PRIVATE).edit();
        editor.putBoolean("isRememberPass", true);
        editor.putString("username", "genvay");
        editor.putString("password", "password");
        editor.commit();

    }

    private void clearPassSpf() {

        SharedPreferences.Editor editor = getSharedPreferences("data", MODE_PRIVATE).edit();
        editor.clear();
        editor.commit();

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        save(fileEditText.getText().toString());
    }
}
