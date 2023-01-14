package com.example.test.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.test.R;
import com.example.test.adapter.Listbean;
import com.example.test.bean.News;
import com.example.test.bean.User;
import com.example.test.Dao.newDao;

import java.util.ArrayList;
import java.util.List;

public class ActivityHome extends AppCompatActivity {
    final private int ADD = 1;
    final private int DELE = 2;
    final private int Change = 3;
    final private int Look = 4;
    final private int About= 5;
    private ArrayList<News> mdata;
    private  ListView mListview;
    private  Listbean listbean;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTitle("小欧新闻");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);
     initView();
     initData();
     initEvent();
    }

    private void initEvent() {
      listbean =new Listbean(mdata,this);
      mListview.setAdapter(listbean);

        mListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent =new Intent(ActivityHome.this,MainActivityMore.class);
                String da[]=new  String[3];
                da[0]=mdata.get(i).getTitle();
                da[1]=mdata.get(i).getCla();
                da[2]=mdata.get(i).getMore();
                intent.putExtra("data",da);
               startActivity(intent);

            }
        });


    }

    private void initData() {
        EditText editText =findViewById(R.id.search1);
        Button button =findViewById(R.id.searbut);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initView();

                newDao newDao =new newDao(ActivityHome.this);
                mdata= newDao.lookbykey(String.valueOf(editText.getText()));
                initEvent();
               // Toast.makeText(ActivityHome.this,"点点",Toast.LENGTH_LONG).show();
            }
        });
        newDao newDao =new newDao(this);
        mdata= newDao.look();
    }

    private void initView() {
        mListview =findViewById(R.id.lv);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        menu.add(1,ADD,1,"添加新闻");
        menu.add(2,DELE,2,"删除新闻");
        menu.add(3,Change,3,"修改新闻");
        menu.add(5,About,5,"关于应用");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        switch (id){
            case ADD:
                Intent intent =new Intent(ActivityHome.this, ActiveAdd.class);
                startActivity(intent);
                break;
            case DELE:
                Intent intent1 =new Intent(ActivityHome.this, ActiveDelete.class);
                startActivity(intent1);

                break;
            case Change:
                Intent intent2=new Intent(ActivityHome.this, ActivityLook.class);
                startActivity(intent2);
                break;

            case About:
                Intent intent4 =new Intent(ActivityHome.this, ActivityAbout.class);
                startActivity(intent4);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}