package com.example.test.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.test.Dao.newDao;
import com.example.test.R;
import com.example.test.bean.News;

public class ActiveAdd extends AppCompatActivity {
    News news;
    newDao newDao;
    String cla="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("小欧新闻");
        setContentView(R.layout.activity_active_add);
        EditText editTextTitle = findViewById(R.id.adshow1);
        EditText editTextMore = findViewById(R.id.adshow2);

        Button button1 = findViewById(R.id.addyes);
        button1.setOnClickListener(view -> {
            news = new News(String.valueOf(editTextTitle.getText()), String.valueOf(editTextMore.getText()), cla);
            newDao = new newDao(ActiveAdd.this);
            newDao.insert(news);
            Intent intent = new Intent(ActiveAdd.this, ActivityHome.class);
            intent.setAction("添加成功");
            startActivity(intent);
        });

        // 获取控件
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        // 要添加到下拉列表框中的数据
        String[] array = new String[]{"type1", "type2", "type3", "type4", "type5"};
        // 创建适配器
        final ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(ActiveAdd.this, R.layout.spinner_item, array);
        dataAdapter.setDropDownViewResource(R.layout.spinner_item);
        // 为下拉列表框设置适配器
        spinner.setAdapter(dataAdapter);

        // spinner的选项被选中的监听事件
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String value = dataAdapter.getItem(position).toString();// 获取被选中的下拉列表框项的值
              //  Toast.makeText(ActiveAdd.this, "你选中了：" + value, Toast.LENGTH_SHORT).show();
                cla =value;
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // 没有任何被选中的处理事件
            }
        });

    }

}