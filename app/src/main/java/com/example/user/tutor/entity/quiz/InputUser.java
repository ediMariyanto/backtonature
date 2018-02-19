package com.example.user.tutor.entity.quiz;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.tutor.MainActivity;
import com.example.user.tutor.R;
import com.example.user.tutor.model.UserModel;

import java.io.Serializable;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputUser extends AppCompatActivity {

    UserModel userModel = new UserModel();
    EditText nama, nomorTelepon;
    TextView tUsia, tBeratBadan, tUkuranSepatu;
    Spinner pekerjaan;
    CheckBox check;


    int ukuranSepatu = 35;
    int usia = 20;
    int beratBadan = 45;

    final Context context = this;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_user);
        setPekerjaan();
        displayTextUsia(20);
        displayTextBeratBadan(45);
        displayTextUkuranSepatu(35);

    }


    public void displayTextUsia(int nilai) {
        TextView nilaiView = (TextView) findViewById(R.id.textUsia);
        nilaiView.setText("" + nilai);
    }

    public void incrementUsia(View v) {
        if (usia >= 90) {
            Toast.makeText(this, "Usia Terlalu Tua", Toast.LENGTH_LONG).show();
            return;
        } else {
            usia = usia + 1;
            displayTextUsia(usia);
        }
    }

    public void DecrementUsia(View v) {
        if (usia <= 10) {
            Toast.makeText(this, "Usia Terlalu Muda", Toast.LENGTH_LONG).show();
            return;
        } else {
            usia = usia - 1;
            displayTextUsia(usia);
        }
    }

    public void displayTextBeratBadan(int nilai) {
        TextView nilaiView = (TextView) findViewById(R.id.textBeratBadan);
        nilaiView.setText("" + nilai);
    }

    public void incrementBeratBadan(View v) {
        if (beratBadan >= 150) {
            Toast.makeText(this, "Berat Badan Terlalu Besar", Toast.LENGTH_LONG).show();
            return;
        } else {
            beratBadan = beratBadan + 1;
            displayTextBeratBadan(beratBadan);
        }
    }

    public void decrementBeratBadan(View v) {
        if (beratBadan <= 20) {
            Toast.makeText(this, "Berat Badan Terlalu Kecil", Toast.LENGTH_LONG).show();
            return;
        } else {
            beratBadan = beratBadan - 1;
            displayTextBeratBadan(beratBadan);
        }
    }

    public void displayTextUkuranSepatu(int nilai) {
        TextView nilaiView = (TextView) findViewById(R.id.textUkuranSepatu);
        nilaiView.setText("" + nilai);
    }

    public void incrementUkuranSepatu(View v) {
        if (ukuranSepatu >= 50) {
            Toast.makeText(this, "Ukuran Sepatu Terlalu Besar", Toast.LENGTH_LONG).show();
            return;
        } else {
            ukuranSepatu = ukuranSepatu + 1;
            displayTextUkuranSepatu(ukuranSepatu);
        }
    }

    public void decrementUkuranSepatu(View v) {
        if (ukuranSepatu <= 30) {
            Toast.makeText(this, "Ukuran Sepatu Terlalu Kecil", Toast.LENGTH_LONG).show();
            return;
        } else {
            ukuranSepatu = ukuranSepatu - 1;
            displayTextUkuranSepatu(ukuranSepatu);
        }
    }

    private void setPekerjaan() {
        String[] arraySpinner = new String[]{
                "Karyawan Swasta", "Wiraswasta", "Pelajar", "Pegawai Negeri", "Lain-lain"
        };
        Spinner s = (Spinner) findViewById(R.id.spPekerjaan);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, arraySpinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s.setAdapter(adapter);

    }

    public void onClickKembaliMenuQuiz(View v) {

        final AlertDialog.Builder alert = new AlertDialog.Builder(context);
        alert.setTitle("Confirmation");
        alert.setMessage("Apakah Anda yakin ingin kembali ke menu utama ?").setCancelable(false).
                setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        getIntentMainQuiz();
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

    private void getIntentMainQuiz() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public static boolean isEmailValid(String email) {
        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public void onCLickSubmit(View v) {

        nama = (EditText) findViewById(R.id.textNama);
        nomorTelepon = (EditText) findViewById(R.id.textNomorTelepon);
        EditText email = (EditText) findViewById(R.id.textEmail);
        pekerjaan = (Spinner) findViewById(R.id.spPekerjaan);
        tUsia = (TextView) findViewById(R.id.textUsia);
        tBeratBadan = (TextView) findViewById(R.id.textBeratBadan);
        tUkuranSepatu = (TextView) findViewById(R.id.textUkuranSepatu);
        check = (CheckBox) findViewById(R.id.chkPeraturan);

        String cekPekerjaan = pekerjaan.getSelectedItem().toString();
        String cekNama = nama.getText().toString();
        String cekNomorTelepon = nomorTelepon.getText().toString();
        String cekEmail = email.getText().toString();
        String usia = tUsia.getText().toString();
        String beratBadan = tBeratBadan.getText().toString();
        String ukuranSepatu = tUkuranSepatu.getText().toString();
        String[] nilai = {"2","4","6","8","10"};
        Random r = new Random();
        int number = r.nextInt(nilai.length);
        String a = nilai[number];

        boolean cekCheckbox = check.isChecked();

        if (cekNama.matches("")) {
            Toast.makeText(this, "Field Nama tidak boleh kosong", Toast.LENGTH_SHORT).show();
            nama.setFocusable(true);
            return;
        } else if (cekNomorTelepon.matches("")) {
            Toast.makeText(this, "Field Nomor Telepon tidak boleh kosong", Toast.LENGTH_SHORT).show();
            nomorTelepon.setFocusable(true);
            return;
        } else if (cekEmail.matches("")) {
            Toast.makeText(this, "Field Email tidak boleh kosong", Toast.LENGTH_SHORT).show();
            return;
        } else if (cekCheckbox == false) {
            Toast.makeText(this, "Harap ceklist dan baca aturannya terlebih dahulu", Toast.LENGTH_SHORT).show();
            return;
        } else {

            if (isEmailValid(cekEmail) == false) {
                Toast.makeText(this, "Email tidak valid", Toast.LENGTH_SHORT).show();
                email.setFocusable(true);
                return;
            } else {
                Toast.makeText(this, "Penginputan User Berhasil", Toast.LENGTH_SHORT).show();
                userModel.setNama(cekNama);
                userModel.setPhone(cekNomorTelepon);
                userModel.setEmail(cekEmail);
                userModel.setPekerjaan(cekPekerjaan);
                userModel.setUsia(usia);
                userModel.setBeratBadan(beratBadan);
                userModel.setUkuranSepatu(ukuranSepatu);
                userModel.setNilai(a);

                Intent intent = new Intent(this, ContentQuiz.class);
                intent.putExtra("user", (Serializable) userModel);
                startActivity(intent);
            }
            nama.setText("");
            email.setText("");
            check.setText("");
            nomorTelepon.setText("");
        }

    }

    public void showPeraturan(View v){

        final AlertDialog.Builder alert = new AlertDialog.Builder(context);
        alert.setTitle("Confirmation");
        alert.setMessage(R.string.peraturan_quiz).setCancelable(false).
                setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        check = (CheckBox) findViewById(R.id.chkPeraturan);
                        check.setChecked(true);
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
