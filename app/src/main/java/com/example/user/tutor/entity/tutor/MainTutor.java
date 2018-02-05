package com.example.user.tutor.entity.tutor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.user.tutor.R;

public class MainTutor extends AppCompatActivity {

    ListView listView;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_tutor);

        listView = (ListView) findViewById(R.id.listMain);
        String [] listMenu = getResources().getStringArray(R.array.lisMenu);

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listMenu);
        listView.setAdapter(adapter);
    }
}
