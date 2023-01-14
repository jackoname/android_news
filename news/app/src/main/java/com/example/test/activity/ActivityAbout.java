package com.example.test.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.test.R;

public class ActivityAbout extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("小欧新闻");
        setContentView(R.layout.activity_about);
    }
}