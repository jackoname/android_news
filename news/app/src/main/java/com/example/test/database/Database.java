package com.example.test.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class Database extends SQLiteOpenHelper {
    private static final String TAG ="Database" ;

    public Database(@Nullable Context context) {
        super(context, constData.DATA_BASENAME, null, constData.VERSION_CODE);
    }



    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
//创建回调
        Log.d(TAG,"创建数据库....");
        String sqlnews= " create table "+ constData.NEWS_TABLE_NAME +"( id integer PRIMARY KEY AUTOINCREMENT, title varch(255), more  varch(255), cla varch(255)) ";
        sqLiteDatabase.execSQL(sqlnews);
        Log.d(TAG,"创建数据库....");
        String sqluser= " create table "+ constData.USER_TABLE_NAME +"(id integer,password integer,sex  integer) ";
        sqLiteDatabase.execSQL(sqluser);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
//升级回调
        Log.d(TAG,"升级数据库....");
    }
}
