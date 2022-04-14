package com.example.testlab8;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.testlab8.AddBookActivity;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    private MyDatabaseHelper dbHelper;

    @SuppressLint("Range")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbHelper = new MyDatabaseHelper(this,"Library.db",null,2);


        SQLiteDatabase db = dbHelper.getWritableDatabase();
        //查询Book表中所有的数据
        Cursor cursor = db.query("Book", null, null, null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                //遍历Cursor对象，取出数据并打印
                String name = cursor.getString(cursor.getColumnIndex("name"));
                //String author = cursor.getString(cursor.getColumnIndex("author"));
                //int pages = cursor.getInt(cursor.getColumnIndex("pages"));
                float price =  cursor.getFloat(cursor.getColumnIndex("price"));
                int id = cursor.getInt(cursor.getColumnIndex("category_id"));
                Log.d("MainActivity", "book name is " + name);
                //Log.d("MainActivity", "book author is " + author);
                Log.d("MainActivity", "book category_id is " + id);
                Log.d("MainActivity", "book price is " + price);

            } while (cursor.moveToNext());
        }
        cursor.close();


        Button add = (Button) findViewById(R.id.add_activity);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddBookActivity.class);
                startActivity(intent);
            }
        });
    }
}
