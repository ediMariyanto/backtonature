package com.example.user.tutor.entity.tutor;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.user.tutor.R;
import com.example.user.tutor.model.TutorModel;

import java.io.Serializable;

public class MainTutor extends AppCompatActivity {

    TutorModel tModel = new TutorModel();
    ListView listView;
    ArrayAdapter<String> adapter;

    String sBelimbing, sTemulawak, sLidahBuaya, sKumisKucing, sjarak, sBelutas, sSambiloto, sCincau, sAlang, sKayuManis;


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_tutor);


        listView = (ListView) findViewById(R.id.listMain);
        final String[] listMenu = getResources().getStringArray(R.array.lisMenu);

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listMenu);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                sBelimbing = getString(R.string.belimbing);
                sTemulawak = getString(R.string.temulawak);

                Intent intent = new Intent(MainTutor.this, Content.class);

                int post = position;
                switch (post) {
                    case 0:
                        tModel.setPost(post);
                        tModel.setTeks(sBelimbing);
                        intent.putExtra("tutor", (Serializable) tModel);
                        startActivity(intent);
                        break;
                    case 1:
                        tModel.setPost(post);
                        tModel.setTeks(sTemulawak);
                        intent.putExtra("tutor", (Serializable) tModel);
                        startActivity(intent);
                        break;
                }

            }
        });
    }

}
