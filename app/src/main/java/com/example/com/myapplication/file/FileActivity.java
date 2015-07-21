package com.example.com.myapplication.file;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.com.myapplication.R;

import java.io.BufferedReader;
import java.io.BufferedWriter;
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


    @Override
    protected void onDestroy() {
        super.onDestroy();
        save(fileEditText.getText().toString());
    }
}
