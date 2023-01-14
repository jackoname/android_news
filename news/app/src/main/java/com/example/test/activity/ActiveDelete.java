package com.example.test.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.test.Dao.newDao;
import com.example.test.R;
import com.example.test.adapter.Listbean;
import com.example.test.bean.News;

import java.text.BreakIterator;
import java.util.ArrayList;

public class ActiveDelete extends AppCompatActivity {
    private ArrayList<News> mdata;
    private ListView mListview;
    private  Listbean listbean;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTitle("小欧新闻");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_active_delete);
        initView();
        initData();
        initEvent();
    }
    private void initEvent() {
        listbean =new Listbean(mdata,this);
        mListview.setAdapter(listbean);

        mListview.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                AlertDialog.Builder builder =new AlertDialog.Builder(ActiveDelete.this);
                builder.setTitle("确定删除该新闻吗？");
                int postion =i;
                builder.setPositiveButton("确定",new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        newDao newDao = new newDao(ActiveDelete.this);
                        newDao.delete(mdata.get(postion).getNewsid());
                        Intent intent =new Intent(ActiveDelete.this,ActivityHome.class);
                        startActivity(intent);
                    }
                });
                builder.setNegativeButton("取消",null);
                builder.create().show();
                return false;
            }
        });
    }

    private void initData() {

        Button button =findViewById(R.id.searbutd);
       EditText editText =findViewById(R.id.search2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initView();

                newDao newDao =new newDao(ActiveDelete.this);

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