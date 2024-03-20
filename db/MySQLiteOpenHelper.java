package com.example.myapplication.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.myapplication.MainActivity;

public class MySQLiteOpenHelper extends SQLiteOpenHelper {

    public static String CREATE_USER = "create table user (" +
            "Student_id integer primary key autoincrement," +
            "password text)";

    public static String CREATE_ANOTHER_TABLE = "create table Course_table (" +
            "id integer primary key autoincrement," +
            "course_name text," +
            "teacher_name text)";

    Context mContext;

    public MySQLiteOpenHelper(@Nullable Context context, String dbName) {
        super(context, dbName, null, 4);
        this.mContext = context;
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_USER);
        sqLiteDatabase.execSQL(CREATE_ANOTHER_TABLE);
        Toast.makeText(mContext, "数据库首次创建成功！", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        //可以多次操作，更新数据库的方法
    }

    public void addUser(String password) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("password", password);

        long result = db.insert("user", null, values);
        if (result == -1) {
            // 添加数据失败
        } else {
            // 添加数据成功
        }

        db.close();
    }

    // 向 Course_table 表添加数据
    public void addCourse(String courseName, String teacherName) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("course_name", courseName);
        values.put("teacher_name", teacherName);

        long result = db.insert("Course_table", null, values);
        if (result == -1) {
            // 添加数据失败
        } else {
            // 添加数据成功
        }

        db.close();
    }
}
