//完整代码
package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.example.myapplication.db.MySQLiteOpenHelper;

public class MainActivity extends AppCompatActivity {

    private MySQLiteOpenHelper mySQLiteOpenHelper;

    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();
    }

    private void initData() {
        mySQLiteOpenHelper = new MySQLiteOpenHelper(this,"Database");
        db = mySQLiteOpenHelper.getWritableDatabase();
        ContentValues userValues = new ContentValues();
        userValues.put("password", "123456");
        long userResult = db.insert("user", null, userValues);

        ContentValues courseValues = new ContentValues();
        courseValues.put("course_name", "COMP7506 Smart phone apps development [Section 2A, 2023]");
        courseValues.put("teacher_name", "Dr. T.W. Chim");
        long courseResult = db.insert("Course_table", null, courseValues);
    }
}