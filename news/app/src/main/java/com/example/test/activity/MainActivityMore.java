package com.example.test.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.test.R;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivityMore extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("小欧新闻");
        setContentView(R.layout.activity_main_more);
        TextView textViewtitle =findViewById(R.id.moretitle);
        TextView textViecla =findViewById(R.id.moretype);
        TextView textViecomtext =findViewById(R.id.morecontext);
        TextView textViecomtext1 =findViewById(R.id.timemore);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日");
        textViecomtext1.setText(dateFormat.format(new Date()));
        Intent intent =getIntent();
        String []data =intent.getStringArrayExtra("data");
        textViewtitle.setText(data[0]);
        textViecla.setText(data[1]);
        textViecomtext.setText(data[2]);
    }
}