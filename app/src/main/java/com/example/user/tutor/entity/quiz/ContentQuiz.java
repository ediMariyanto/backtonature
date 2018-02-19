package com.example.user.tutor.entity.quiz;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.tutor.ProfileUser;
import com.example.user.tutor.R;
import com.example.user.tutor.model.QuizModel;
import com.example.user.tutor.model.UserModel;

import java.io.Serializable;
import java.util.Random;

public class ContentQuiz extends AppCompatActivity {
    String randomPertanyaan;
    String[] question;
    String[] jawaban;
    Button btnInput;
    TextView textSoal, userText;
    RadioGroup rGroup;
    RadioButton rBtn;
    Intent intent;

    QuizModel quizModel;

    final Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_quiz);

        setUser();

        jawaban = getResources().getStringArray(R.array.jawaban);
        question = getResources().getStringArray(R.array.pertanyaan);
        textSoal = (TextView) findViewById(R.id.textQuestion);
        btnInput = (Button) findViewById(R.id.btnSubmitContentQuiz);
        rGroup = (RadioGroup) findViewById(R.id.rbtgAnswer);

        textSoal.setText(question[4]);

        btnInput.setOnClickListener(new View.OnClickListener() {

            int lengthArray = question.length;
            int countArray = 1;

            @Override
            public void onClick(View view) {
                int randomQuestion = new Random().nextInt(lengthArray);
                randomPertanyaan = question[randomQuestion];
                textSoal.setText(randomPertanyaan);
                countArray = countArray + 1;

                int selected = rGroup.getCheckedRadioButtonId();
                rBtn = (RadioButton) findViewById(selected);

                String soal = textSoal.getText().toString();
                String jawab = rBtn.getText().toString();

                if (soal.equals(question[0]) && jawab.equals("Daun")) {
                    Toast.makeText(ContentQuiz.this, "Terimakasih ....",Toast.LENGTH_SHORT).show();
                } else if (soal.equals(question[1]) && jawab.equals("Buah")) {
                    Toast.makeText(ContentQuiz.this, "Terimakasih ....",Toast.LENGTH_SHORT).show();
                } else if (soal.equals(question[2]) && jawab.equals("Akar")) {
                    Toast.makeText(ContentQuiz.this, "Terimakasih ....",Toast.LENGTH_SHORT).show();
                } else if (soal.equals(question[3]) && jawab.equals("Akar")) {
                    Toast.makeText(ContentQuiz.this, "Terimakasih ....",Toast.LENGTH_SHORT).show();
                } else if (soal.equals(question[4]) && jawab.equals("Daun")) {
                    Toast.makeText(ContentQuiz.this, "Terimakasih ....",Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(ContentQuiz.this, "Terimakasih ....",Toast.LENGTH_SHORT).show();
                }

                if (countArray == 5) {
                    btnInput.setText("Submit");
                    btnInput.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            final AlertDialog.Builder alert = new AlertDialog.Builder(context);
                            alert.setTitle("Confirmation");
                            alert.setMessage("Terimakasih atas jawabannya ?").setCancelable(false).
                                    setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialogInterface, int i) {
                                            submitJawaban();
                                            return;
                                        }
                                    });
                            AlertDialog alertDialog = alert.create();
                            alertDialog.show();

                        }
                    });
                }
            }
        });

    }

    private void setUser() {
        Intent getIntent = getIntent();
        userText = (TextView) findViewById(R.id.textUser);
        UserModel userModel = (UserModel) getIntent.getSerializableExtra("user");
        userText.setText(userModel.getNama());
    }

    private void submitJawaban() {

        Intent getIntent = getIntent();
        UserModel userModel = (UserModel) getIntent.getSerializableExtra("user");
//        userModel.setNilai(2);
        intent = new Intent(ContentQuiz.this, ProfileUser.class);
        intent.putExtra("user", (Serializable) userModel);
        startActivity(intent);
    }

}



