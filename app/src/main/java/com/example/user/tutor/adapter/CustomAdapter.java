package com.example.user.tutor.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.user.tutor.R;

import java.util.ArrayList;

/**
 * Created by user on 09/02/2018.
 */

public class CustomAdapter extends BaseAdapter {

    Context context;
    String[] questionsList;
    LayoutInflater inflter;
    public static ArrayList<String> selectedAnswers;

    public CustomAdapter(Context applicationContext, String[] questionsList) {
        this.context = context;
        this.questionsList = questionsList;

        selectedAnswers = new ArrayList<>();
        for (int i = 0; i < questionsList.length; i++) {
            selectedAnswers.add("Tidak Memilih");
        }
        inflter = (LayoutInflater.from(applicationContext));
    }

    @Override
    public int getCount() {
        return questionsList.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        view = inflter.inflate(R.layout.list_content_quiz, null);

        TextView question = (TextView) view.findViewById(R.id.txtQuestion);
        RadioButton a = (RadioButton) view.findViewById(R.id.rbtA);
        RadioButton b = (RadioButton) view.findViewById(R.id.rbtB);
        RadioButton c = (RadioButton) view.findViewById(R.id.rbtC);
        RadioButton d = (RadioButton) view.findViewById(R.id.rbtD);


        a.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) selectedAnswers.set(i, "Batang");
            }
        });
        b.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) selectedAnswers.set(i, "Daun");

            }
        });
        c.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                    selectedAnswers.set(i, "Akar");

            }
        });

        d.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                    selectedAnswers.set(i, "Buah");

            }
        });


        question.setText(questionsList[i]);
        return view;
    }

}
