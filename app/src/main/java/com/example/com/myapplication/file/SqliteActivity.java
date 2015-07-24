package com.example.com.myapplication.file;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.com.myapplication.R;

public class SqliteActivity extends ActionBarActivity implements View.OnClickListener {

    Button mCreateSql, mInsert, mUpdata, mDelete, mSearch, mReset;

    private MyDatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite);

        dbHelper = new MyDatabaseHelper(this, "book.db", null, 1);

        mCreateSql = (Button) findViewById(R.id.sqlite_create_sqlite);
        mCreateSql.setOnClickListener(this);
        mInsert = (Button) findViewById(R.id.sqlite_insert);
        mInsert.setOnClickListener(this);
        mUpdata = (Button) findViewById(R.id.sqlite_update);
        mUpdata.setOnClickListener(this);
        mDelete = (Button) findViewById(R.id.sqlite_delete);
        mDelete.setOnClickListener(this);
        mSearch = (Button) findViewById(R.id.sqlite_search);
        mSearch.setOnClickListener(this);

        mReset = (Button) findViewById(R.id.sqlite_reset);
        mReset.setOnClickListener(this);
    }

    public void onClick(View v) {

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();

        switch (v.getId()) {
            case R.id.sqlite_create_sqlite:

                dbHelper.getReadableDatabase();
                Toast.makeText(SqliteActivity.this, "sqlite_create_sqlite", Toast.LENGTH_SHORT).show();
                break;

            case R.id.sqlite_insert:

                for (int i = 1; i <= 10; i++) {
                    values.clear();
                    values.put("name", "The Da Vinci Code");
                    values.put("author", "Dan Brown");
                    values.put("pages", i);
                    values.put("price", 16.96 * i);
                    db.insert("Book", null, values);
                }

                Toast.makeText(SqliteActivity.this, "sqlite_insert", Toast.LENGTH_SHORT).show();
                break;

            case R.id.sqlite_update:

                values.clear();
                values.put("author", "genvay");
                db.update("Book", values, "name = ?", new String[]{"The Da Vinci Code"});

                values.clear();
                values.put("price", 20);
                db.update("Book", values, "pages = ?", new String[]{"5"});
                Toast.makeText(SqliteActivity.this, "sqlite_update", Toast.LENGTH_SHORT).show();
                break;

            case R.id.sqlite_delete:
                db.delete("Book", "pages < ?", new String[] {"1000"});
                Toast.makeText(SqliteActivity.this, "sqlite_delete", Toast.LENGTH_SHORT).show();
                break;

            case R.id.sqlite_search:
                Cursor cursor = db.query("Book", new String[] {"author","price"}, "pages = ?", new String[] {"6"}, null, null, null);
                if (cursor.moveToFirst()) {
                    do {
                        Log.e("SqliteActivity", cursor.getString(cursor.getColumnIndex("author")));
                        Log.e("SqliteAcitvity", cursor.getString(cursor.getColumnIndex("price")));
                    } while (cursor.moveToNext());

                }
                Toast.makeText(SqliteActivity.this, "sqlite_search", Toast.LENGTH_SHORT).show();
                break;

            case R.id.sqlite_reset:
                db.beginTransaction();

                try {
                    db.delete("book", null ,null);
                    if (true) {
//                        throw new NullPointerException();
                    }

                    ContentValues value = new ContentValues();
                    value.put("price", 10);
                    value.put("pages", 2);
                    value.put("name", "genvay");
                    value.put("author", "author");
                    db.insert("book", null, value);
                    db.setTransactionSuccessful();

                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    db.endTransaction();
                }

            default:
                break;
        }

    }

}
