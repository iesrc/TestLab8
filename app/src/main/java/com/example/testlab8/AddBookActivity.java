package com.example.testlab8;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AddBookActivity extends AppCompatActivity {

    private MyDatabaseHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_book);
        dbHelper = new MyDatabaseHelper(this,"Library.db",null,2);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        //开始组装第一条数据
        values.put("category_name","经济类");
        values.put("category_code",1);
        db.insert("Category",null,values);//插入第一条数据
        values.clear();
        //开始组装第二条数据
        values.put("category_name","技术类");
        values.put("category_code",2);
        db.insert("Category",null,values);//插入第二条数据

        Button addData = (Button) findViewById(R.id.add_data);
        addData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                ContentValues values = new ContentValues();
                //开始组装第一条数据

                values.put("author","orwell");
                values.put("price","55.96");
                values.put("pages","490");
                values.put("name","1984");
                values.put("category_id",2);
                db.insert("Book",null,values);//插入一条数据
                values.clear();

            }
        });

    }
}