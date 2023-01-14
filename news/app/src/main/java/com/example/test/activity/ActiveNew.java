package com.example.test.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.test.Dao.userDao;
import com.example.test.MainActivity;
import com.example.test.R;
import com.example.test.bean.User;

import java.util.Timer;
import java.util.TimerTask;

public class ActiveNew extends AppCompatActivity {
    private User user;
    com.example.test.Dao.userDao userDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTitle("小欧新闻");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_active_new);
        Button button = findViewById(R.id.but10);
        EditText id = findViewById(R.id.show1);
        EditText psw = findViewById(R.id.show);
        RadioGroup sex = findViewById(R.id.gender);
        EditText ensur = findViewById(R.id.ensure);
        CheckBox checkBox = findViewById(R.id.agree);
        Button button1 = findViewById(R.id.but1s);
        button.setOnClickListener(new View.OnClickListener() {
            int sex1 = 0;

            @Override
            public void onClick(View view) {
                if (sex.equals(R.id.male)) sex1 = 1;

                if (String.valueOf(ensur.getText()).equals(String.valueOf(psw.getText()))) {
                    if (checkBox.isChecked()) {
                        user = new User(Integer.valueOf(String.valueOf(id.getText())), Integer.valueOf(String.valueOf(psw.getText())), sex1);
                        Intent intent = new Intent(ActiveNew.this, MainActivity.class);
                        Timer timer = new Timer();
                        TimerTask task = new TimerTask() {
                            @Override
                            public void run() {
                                userDao = new userDao(ActiveNew.this);
                                userDao.insert(user);
                                startActivity(intent);
                            }
                        };
                        timer.schedule(task, 1000);
                    } else
                        Toast.makeText(ActiveNew.this, "请选择同意协议~~", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(ActiveNew.this, "密码不一致~~", Toast.LENGTH_LONG).show();
                }
            }
        });


        button1.setOnClickListener(new View.OnClickListener() {
            int sex1 = 0;

            @Override
            public void onClick(View view) {
                if (sex.equals(R.id.male)) sex1 = 1;

                if (String.valueOf(ensur.getText()).equals(String.valueOf(psw.getText()))) {
                    if (checkBox.isChecked()) {
                        user = new User(Integer.valueOf(String.valueOf(id.getText())), Integer.valueOf(String.valueOf(psw.getText())), sex1);
                        Intent intent = new Intent(ActiveNew.this, MainActivity.class);
                        Timer timer = new Timer();
                        TimerTask task = new TimerTask() {
                            @Override
                            public void run() {
                                //sp键值对存储方式存储用户信息
                                SharedPreferences mSharedPreferences = ActiveNew.this.getSharedPreferences("loginUser", Context.MODE_PRIVATE);
                                SharedPreferences.Editor editor = mSharedPreferences.edit();
                                editor.putInt("user_id", user.getId());
                                editor.putInt("user_password", user.getPassword());
                                editor.putInt("user_sex", user.getSex());
                                editor.commit();
                                startActivity(intent);
                            }
                        };
                        timer.schedule(task, 1000);
                    } else
                        Toast.makeText(ActiveNew.this, "请选择同意协议~~", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(ActiveNew.this, "密码不一致~~", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}


