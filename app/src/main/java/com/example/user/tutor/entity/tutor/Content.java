package com.example.user.tutor.entity.tutor;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ZoomControls;

import com.example.user.tutor.R;
import com.example.user.tutor.model.TutorModel;

public class Content extends AppCompatActivity {

    String teksHasil;
    int postHasil;
    ZoomControls simpleZoomControls;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);

        Toast.makeText(this, "Double Klik objek yang ingin diperbesar atau diperkecil !!",Toast.LENGTH_SHORT).show();

        setDataTeks();

        image = (ImageView) findViewById(R.id.imgJamu); // initiate a ImageView
        simpleZoomControls = (ZoomControls) findViewById(R.id.zoomControl); // initiate a ZoomControls
        simpleZoomControls.hide(); // initially hide ZoomControls from the screen
        // perform setOnTouchListener event on ImageView
        image.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // show Zoom Controls on touch of image
                simpleZoomControls.show();
                return false;
            }
        });



        simpleZoomControls.setOnZoomInClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // calculate current scale x and y value of ImageView
                float x = image.getScaleX();
                float y = image.getScaleY();


                // set increased value of scale x and y to perform zoom in functionality
                image.setScaleX((float) (x + 1));
                image.setScaleY((float) (y + 1));
                // display a toast to show Zoom In Message on Screen
                Toast.makeText(getApplicationContext(), "Zoom In", Toast.LENGTH_SHORT).show();
                // hide the ZoomControls from the screen
                simpleZoomControls.hide();
            }
        });
        // perform setOnZoomOutClickListener event on ZoomControls
        simpleZoomControls.setOnZoomOutClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // calculate current scale x and y value of ImageView
                float x = image.getScaleX();
                float y = image.getScaleY();
                // set decreased value of scale x and y to perform zoom out functionality
                image.setScaleX((float) (x - 1));
                image.setScaleY((float) (y - 1));
                // display a toast to show Zoom Out Message on Screen
                Toast.makeText(getApplicationContext(), "Zoom Out", Toast.LENGTH_SHORT).show();
                // hide the ZoomControls from the screen
                simpleZoomControls.hide();
            }
        });


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

            case 2:
                teks.setText(teksHasil);
                imgContent.setImageResource(R.drawable.lidahbuaya);
                break;

            case 3:
                teks.setText(teksHasil);
                imgContent.setImageResource(R.drawable.kumiskucing);
                break;

            case 4:
                teks.setText(teksHasil);
                imgContent.setImageResource(R.drawable.daunjarak);
                break;

            case 5:
                teks.setText(teksHasil);
                imgContent.setImageResource(R.drawable.belutas);
                break;

            case 6:
                teks.setText(teksHasil);
                imgContent.setImageResource(R.drawable.sambiloto);
                break;

            case 7:
                teks.setText(teksHasil);
                imgContent.setImageResource(R.drawable.cincau);
                break;

            case 8:
                teks.setText(teksHasil);
                imgContent.setImageResource(R.drawable.alangalang);
                break;

            case 9:
                teks.setText(teksHasil);
                imgContent.setImageResource(R.drawable.kayumanis);
                break;
        }
    }

    public void onClickKembali(View v) {
        Intent intent = new Intent(this, MainTutor.class);
        startActivity(intent);
    }
}
