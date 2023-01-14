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

public class newDao {
    private static final String TAG = "dao";
    private Database database ;
    public newDao(Context context) {
        database = new Database(context);
    }

    public void insert(News news){
        SQLiteDatabase db= database.getWritableDatabase();
        String sql="insert into "+ constData.NEWS_TABLE_NAME+" (title,more,cla) values (?,?,?)";
        db.execSQL(sql,new Object[]{news.getTitle(),news.getMore(),news.getCla()});
        db.close();
    }
    public void upadte(News news){
        SQLiteDatabase db= database.getWritableDatabase();
        String sql=" update " + constData.NEWS_TABLE_NAME + " set title=? , more =? , cla=? where id = "+news.getNewsid();
        db.execSQL(sql,new Object[]{news.getTitle(),news.getMore(),news.getCla()});
        db.close();
    }
    public void delete(int pot){
        SQLiteDatabase db= database.getWritableDatabase();
        String sql=" delete from  "+ constData.NEWS_TABLE_NAME+ " where id=?";
        db.execSQL(sql,new Object[]{pot});
        db.close();
    }
    public void update(){
        SQLiteDatabase db= database.getWritableDatabase();
        String sql=" update "+ constData.DATA_BASENAME+" set id=? and password=? and sex =?";
        db.execSQL(sql,new Object[]{1,2,3});
        db.close();
    }
    public ArrayList<News> look(){
        SQLiteDatabase db= database.getWritableDatabase();
        String sql="select * from " + constData.NEWS_TABLE_NAME;
        Cursor cursor =db.rawQuery(sql,null);
        ArrayList <News> news = new ArrayList<News>();
        while(cursor.moveToNext()){
            int index1=cursor.getColumnIndex("id");
            int index2 =cursor.getColumnIndex("title");
            int index3 =cursor.getColumnIndex("more");
            int index4 =cursor.getColumnIndex("cla");
            int id = cursor.getInt(index1);
            String title =cursor.getString(index2);
            String more =cursor.getString(index3);
            String cla =cursor.getString(index4);
            news.add(new News(id,more,cla,title));
            }
        db.close();
        return news;
    }//name LIKE '%" + temp + "%'"
    public ArrayList<News> lookbykey(String val){
        SQLiteDatabase db= database.getWritableDatabase();
        String sql="select * from " + constData.NEWS_TABLE_NAME+" where title  LIKE '%" + val + "%'"
                +" or   more  LIKE '% " + val + "%'" ;
        Cursor cursor =db.rawQuery(sql,null);
        ArrayList <News> news = new ArrayList<News>();
        while(cursor.moveToNext()){
            int index1=cursor.getColumnIndex("id");
            int index2 =cursor.getColumnIndex("title");
            int index3 =cursor.getColumnIndex("more");
            int index4 =cursor.getColumnIndex("cla");
            int id = cursor.getInt(index1);
            String title =cursor.getString(index2);
            String more =cursor.getString(index3);
            String cla =cursor.getString(index4);
            news.add(new News(id,more,cla,title));
        }
        db.close();
        return news;
    }
}
