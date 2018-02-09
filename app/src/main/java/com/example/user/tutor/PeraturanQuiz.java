package com.example.user.tutor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.user.tutor.entity.quiz.InputUser;

public class PeraturanQuiz extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_peraturan_quiz);
    }

    public void onClickKembaliQuiz(View view){
        Intent intent = new Intent(this, InputUser.class);
        startActivity(intent);
    }
}
