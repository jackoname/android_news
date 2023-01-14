package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.test.Dao.userDao;
import com.example.test.activity.ActiveNew;
import com.example.test.activity.ActivityHome;
import com.example.test.bean.User;
import com.example.test.database.Database;

public class MainActivity extends AppCompatActivity {
    User user ;
    userDao userDao;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
        super.onCreate(savedInstanceState);
        setTitle("小欧新闻");
        Button button=findViewById(R.id.but1);
        Button button3=findViewById(R.id.but3);

        button.setOnClickListener(new View.OnClickListener() {
            EditText id =findViewById(R.id.showid);
            EditText psw =findViewById(R.id.showpsw);
            CheckBox checkBox = findViewById(R.id.yesido);
            SharedPreferences  sp = MainActivity.this.getSharedPreferences("loginUser", Context.MODE_PRIVATE);

            @Override
            public void onClick(View view) {
                boolean flag=true;
                if(String.valueOf(id.getText()).equals("")||String.valueOf(psw.getText()).equals("")){
                    Toast.makeText(MainActivity.this, "账号密码不能为空~~", Toast.LENGTH_LONG).show();
                    flag = false;
                    return;
                }


                user = new User(Integer.valueOf(String.valueOf(id.getText())), Integer.valueOf(String.valueOf(psw.getText())),0);
               userDao =new userDao(MainActivity.this);
                Intent intent = new Intent(MainActivity.this, ActivityHome.class);

                if(userDao.look(user)&&flag) {
                    if(checkBox.isChecked())
                    startActivity(intent);
                    else
                        Toast.makeText(MainActivity.this, "请勾选同意用户协议~~", Toast.LENGTH_LONG).show();

                }
                else{
                    Toast.makeText(MainActivity.this, "密码或账号错误~~", Toast.LENGTH_LONG).show();
                }
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            EditText id =findViewById(R.id.showid);
            EditText psw =findViewById(R.id.showpsw);
            CheckBox checkBox = findViewById(R.id.yesido);
            SharedPreferences  sp = MainActivity.this.getSharedPreferences("loginUser", Context.MODE_PRIVATE);

            @Override
            public void onClick(View view) {
                boolean flag=true;
                if(String.valueOf(id.getText()).equals("")||String.valueOf(psw.getText()).equals("")){
                    Toast.makeText(MainActivity.this, "账号密码不能为空~~", Toast.LENGTH_LONG).show();
                    flag = false;
                    return;
                }


                user = new User(Integer.valueOf(String.valueOf(id.getText())), Integer.valueOf(String.valueOf(psw.getText())),0);
                //   userDao =new userDao(MainActivity.this);
                Intent intent = new Intent(MainActivity.this, ActivityHome.class);

                if(user.getId()==sp.getInt("user_id", 0)&&user.getPassword()==sp.getInt("user_password",0)&&flag) {
                    if(checkBox.isChecked())
                        startActivity(intent);
                    else
                        Toast.makeText(MainActivity.this, "请勾选同意用户协议~~", Toast.LENGTH_LONG).show();

                }
                else{
                    Toast.makeText(MainActivity.this, "密码或账号错误~~", Toast.LENGTH_LONG).show();
                }
            }
        });
        Button button2=findViewById(R.id.but2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ActiveNew.class);
                startActivity(intent);
            }
        }) ;
        Database database =new Database(this);
        database.getWritableDatabase();
    }

}

