package com.example.user.tutor.entity.tutor;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.user.tutor.MainActivity;
import com.example.user.tutor.R;
import com.example.user.tutor.model.TutorModel;

import java.io.Serializable;
import java.util.Locale;

public class MainTutor extends AppCompatActivity {

    final Context context = this;

    TutorModel tModel = new TutorModel();
    ListView listView;
    ArrayAdapter<String> adapter;

    EditText editSearch;

    String sBelimbing, sTemulawak, sLidahBuaya, sKumisKucing, sjarak, sBelutas, sSambiloto, sCincau, sAlang, sKayuManis;


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_tutor);

        editSearch = (EditText) findViewById(R.id.editSearch);
        listView = (ListView) findViewById(R.id.listMain);
        final String[] listMenu = getResources().getStringArray(R.array.lisMenu);

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listMenu);
        listView.setAdapter(adapter);


        editSearch.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
                // When user changed the Text
//                MainTutor.this.adapter.getFilter().filter(cs);
            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
                                          int arg3) {
                // TODO Auto-generated method stub

            }

            @Override
            public void afterTextChanged(Editable arg0) {
                String text = editSearch.getText().toString().toLowerCase(Locale.getDefault());
                adapter.getFilter().filter(text);
            }
        });


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


//                Toast.makeText(MainTutor.this, ll, Toast.LENGTH_SHORT).show();

                String listPilih = ((TextView) view).getText().toString();
                switch (listPilih) {
                    case "BELIMBING WULUH":
                        tModel.setPost(0);
                        tModel.setTeks(sBelimbing);
                        intent.putExtra("tutor", (Serializable) tModel);
                        startActivity(intent);
                        break;

                    case "TEMULAWAK":
                        tModel.setPost(1);
                        tModel.setTeks(sTemulawak);
                        intent.putExtra("tutor", (Serializable) tModel);
                        startActivity(intent);
                        break;

                    case "LIDAH BUAYA":
                        tModel.setPost(2);
                        tModel.setTeks(sLidahBuaya);
                        intent.putExtra("tutor", (Serializable) tModel);
                        startActivity(intent);
                        break;

                    case "TANAMAN KUMIS KUCING":
                        tModel.setPost(3);
                        tModel.setTeks(sKumisKucing);
                        intent.putExtra("tutor", (Serializable) tModel);
                        startActivity(intent);
                        break;

                    case "DAUN JARAK":
                        tModel.setPost(4);
                        tModel.setTeks(sjarak);
                        intent.putExtra("tutor", (Serializable) tModel);
                        startActivity(intent);
                        break;

                    case "DAUN BELUTAS":
                        tModel.setPost(5);
                        tModel.setTeks(sBelutas);
                        intent.putExtra("tutor", (Serializable) tModel);
                        startActivity(intent);
                        break;

                    case "DAUN SAMBILOTO":
                        tModel.setPost(6);
                        tModel.setTeks(sSambiloto);
                        intent.putExtra("tutor", (Serializable) tModel);
                        startActivity(intent);
                        break;

                    case "DAUN CINCAU":
                        tModel.setPost(7);
                        tModel.setTeks(sCincau);
                        intent.putExtra("tutor", (Serializable) tModel);
                        startActivity(intent);
                        break;

                    case "AKAR ALANG ALANG":
                        tModel.setPost(8);
                        tModel.setTeks(sAlang);
                        intent.putExtra("tutor", (Serializable) tModel);
                        startActivity(intent);
                        break;

                    case "AKAR KAYU MANIS":
                        tModel.setPost(9);
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
