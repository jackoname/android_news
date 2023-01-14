package com.example.test.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.test.R;
import com.example.test.bean.News;
import com.example.test.bean.User;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Listbean extends BaseAdapter {
    private ArrayList<News> mBean;
    private  LayoutInflater layoutInflater;
    private Context context;

    public Listbean(ArrayList<News> mBean, Context context) {
        this.mBean = mBean;
        this.context = context;
        layoutInflater =LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return mBean.size();
    }

    @Override
    public Object getItem(int i) {
        return mBean.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view=layoutInflater.inflate(R.layout.listview,viewGroup,false);
        TextView textView1 =view.findViewById(R.id.newsid);
        TextView textView2=view.findViewById(R.id.ntitle);
        TextView textView3=view.findViewById(R.id.type);
        ImageView imageView = view.findViewById(R.id.newsicon);
        imageView.setImageResource(R.drawable.test);
        TextView textView4=view.findViewById(R.id.Time);
        News news = mBean.get(i);
        textView1.setText(String.valueOf(news.getNewsid()));
        textView2.setText(String.valueOf(news.getTitle()));
        textView3.setText(String.valueOf(news.getCla()));
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日");
        textView4.setText(dateFormat.format(new Date()));
        return view;
    }
}
