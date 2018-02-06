package com.example.user.tutor.entity.tutor;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.tutor.R;
import com.example.user.tutor.model.TutorModel;

public class Content extends AppCompatActivity {

    String teksHasil;
    int postHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);

        setDataTeks();
    }

    private void setDataTeks() {

        Intent intent = getIntent();

        TextView teks = (TextView) findViewById(R.id.textContent);
        ImageView imgContent = (ImageView) findViewById(R.id.imgJamu);

        TutorModel tModel = (TutorModel) intent.getSerializableExtra("tutor");

        teksHasil = tModel.getTeks();
        postHasil = tModel.getPost();

        switch (postHasil) {
            case 0:
                teks.setText(teksHasil);
                imgContent.setImageResource(R.drawable.belimbing);
                break;

            case 1:
                teks.setText(teksHasil);
                imgContent.setImageResource(R.drawable.temulawak);
                break;
        }
    }

    public void onClickKembali(View v) {
        Intent intent = new Intent(this, MainTutor.class);
        startActivity(intent);
    }
}
