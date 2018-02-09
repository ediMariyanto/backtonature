package com.example.user.tutor.entity.tutor;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.user.tutor.MainActivity;
import com.example.user.tutor.R;
import com.example.user.tutor.model.TutorModel;

import java.io.Serializable;

public class MainTutor extends AppCompatActivity {

    final Context context = this;

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
                sLidahBuaya = getString(R.string.lidahbuaya);
                sKumisKucing = getString(R.string.kumiskucing);
                sjarak = getString(R.string.daunjarak);
                sBelutas = getString(R.string.daunbelutas);
                sSambiloto = getString(R.string.daunsambiloto);
                sCincau = getString(R.string.dauicincau);
                sAlang = getString(R.string.akaralangalang);
                sKayuManis = getString(R.string.kayumanis);

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

                    case 2:
                        tModel.setPost(post);
                        tModel.setTeks(sLidahBuaya);
                        intent.putExtra("tutor", (Serializable) tModel);
                        startActivity(intent);
                        break;

                    case 3:
                        tModel.setPost(post);
                        tModel.setTeks(sKumisKucing);
                        intent.putExtra("tutor", (Serializable) tModel);
                        startActivity(intent);
                        break;

                    case 4:
                        tModel.setPost(post);
                        tModel.setTeks(sjarak);
                        intent.putExtra("tutor", (Serializable) tModel);
                        startActivity(intent);
                        break;

                    case 5:
                        tModel.setPost(post);
                        tModel.setTeks(sBelutas);
                        intent.putExtra("tutor", (Serializable) tModel);
                        startActivity(intent);
                        break;

                    case 6:
                        tModel.setPost(post);
                        tModel.setTeks(sSambiloto);
                        intent.putExtra("tutor", (Serializable) tModel);
                        startActivity(intent);
                        break;

                    case 7:
                        tModel.setPost(post);
                        tModel.setTeks(sCincau);
                        intent.putExtra("tutor", (Serializable) tModel);
                        startActivity(intent);
                        break;

                    case 8:
                        tModel.setPost(post);
                        tModel.setTeks(sAlang);
                        intent.putExtra("tutor", (Serializable) tModel);
                        startActivity(intent);
                        break;

                    case 9:
                        tModel.setPost(post);
                        tModel.setTeks(sKayuManis);
                        intent.putExtra("tutor", (Serializable) tModel);
                        startActivity(intent);
                        break;
                }
            }
        });
    }

    public void onCLickKembaliMainTutor(View v) {

        final AlertDialog.Builder alert = new AlertDialog.Builder(context);
        alert.setTitle("Confirmation");
        alert.setMessage("Apakah Anda yakin ingin kembali ke menu utama ?").setCancelable(false).
                setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        getIntentMainTutor();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
        AlertDialog alertDialog = alert.create();
        alertDialog.show();
    }

    private void getIntentMainTutor() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


}
