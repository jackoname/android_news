package com.example.test.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.test.Dao.newDao;
import com.example.test.R;
import com.example.test.adapter.Listbean;
import com.example.test.bean.News;

import java.util.ArrayList;

public class ActivityLook extends AppCompatActivity {
    private ArrayList<News> mdata;
    private ListView mListview;
    private  Listbean listbean;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("小欧新闻");
        setContentView(R.layout.activity_look);
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
                Intent intent =new Intent(ActivityLook.this,MainActivityChan.class);
                String da[]=new  String[4];
                da[0]=mdata.get(i).getTitle();
                da[1]=mdata.get(i).getCla();
                da[2]=mdata.get(i).getMore();
                da[3]=String.valueOf(mdata.get(i).getNewsid());
                intent.putExtra("data",da);
                startActivity(intent);
            }
        });


    }

    private void initData() {
        EditText editText =findViewById(R.id.search3);
        Button button =findViewById(R.id.searbutu1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initView();
                newDao newDao =new newDao(ActivityLook.this);
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
}