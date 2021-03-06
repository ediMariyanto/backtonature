package com.example.user.tutor;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.user.tutor.entity.quiz.InputUser;
import com.example.user.tutor.entity.tutor.MainTutor;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onclickToHerbal(View v){
        Intent intent = new Intent(this, MainTutor.class);
        startActivity(intent);
    }

    public void onClickToQuiz(View v){
        Intent intent = new Intent(this, InputUser.class);
        startActivity(intent);
    }
}
