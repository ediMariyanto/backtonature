package com.example.user.tutor.model;

import java.io.Serializable;

/**
 * Created by user on 07/02/2018.
 */

public class QuizModel implements Serializable {
    private String user;
    private int nilai;

    public int getNilai() {
        return nilai;
    }

    public void setNilai(int nilai) {
        this.nilai = nilai+1;
    }
}
