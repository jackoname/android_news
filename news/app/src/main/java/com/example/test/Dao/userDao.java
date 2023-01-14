package com.example.test.Dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.test.bean.News;
import com.example.test.bean.User;
import com.example.test.database.Database;
import com.example.test.database.constData;

import java.util.ArrayList;

public class userDao {
    private static final String TAG = "dao";
    private Database database ;
    public userDao(Context context) {
        database = new Database(context);
    }

    public void insert(User user){
        SQLiteDatabase db= database.getWritableDatabase();
        String sql="insert into "+ constData.USER_TABLE_NAME+" (id,password,sex) values (?,?,?)";
        db.execSQL(sql,new Object[]{user.getId(),user.getPassword(),user.getSex()});
        db.close();
    }

    public boolean look(User user){
        SQLiteDatabase db= database.getWritableDatabase();
        String sql=" select * from " + constData.USER_TABLE_NAME +" where  id= " + user.getId()+ " and password= " +user.getPassword();
        Cursor cursor =db.rawQuery(sql,null);
       boolean flag =false;
        if (cursor.getCount()!=0) {
            flag = true;
        }
        Log.d(TAG," 数"+String.valueOf(cursor.getCount()));
        db.close();
        cursor.close();
        return flag;
    }
}
