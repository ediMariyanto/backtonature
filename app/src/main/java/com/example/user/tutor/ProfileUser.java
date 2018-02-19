package com.example.user.tutor;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.user.tutor.entity.quiz.InputUser;
import com.example.user.tutor.model.UserModel;

public class ProfileUser extends AppCompatActivity {

    TextView nama, beratBadan, ukuranSepatu, email, telepon, pekerjaan, usia, score;
    Context context = this;
    Intent intentKembali, getIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_user);

        setUser();

    }

    private void setUser() {
        getIntent = getIntent();
        nama = (TextView) findViewById(R.id.textNama);
        beratBadan = (TextView) findViewById(R.id.textBeratBadan);
        ukuranSepatu = (TextView) findViewById(R.id.textUkuranSepatu);
        email = (TextView) findViewById(R.id.textEmail);
        telepon = (TextView) findViewById(R.id.textPhone);
        pekerjaan = (TextView) findViewById(R.id.textPekerjaan);
        usia = (TextView) findViewById(R.id.textUsia);
        score = (TextView) findViewById(R.id.textScore);

        UserModel userModel = (UserModel) getIntent.getSerializableExtra("user");

        //String tel = userModel.getPhone();

        nama.setText(userModel.getNama());
        beratBadan.setText(userModel.getBeratBadan());
        ukuranSepatu.setText(userModel.getUkuranSepatu());
        email.setText(userModel.getEmail());
        pekerjaan.setText(userModel.getPekerjaan());
        usia.setText(userModel.getUsia());
        telepon.setText(userModel.getPhone());
        score.setText(userModel.getNilai());
    }

    public void onCLickKembaliMain(View view) {
        intentKembali = new Intent(this, InputUser.class);
        final AlertDialog.Builder alert = new AlertDialog.Builder(context);
        alert.setTitle("Confirmation");
        alert.setMessage("Apakah Anda yakin untuk kembali pada menu input ?").setCancelable(false).

                setPositiveButton("Yes", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        startActivity(intentKembali);

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

}
