package com.example.user.tutor.model;

import java.io.Serializable;

/**
 * Created by user on 06/02/2018.
 */

public class TutorModel implements Serializable {

    private static final long serialVersionUID = 1L;

    private int post;
    private String teks;

    public String getTeks() {
        return teks;
    }

    public void setTeks(String teks) {
        this.teks = teks;
    }

    public int getPost() {
        return post;
    }

    public void setPost(int post) {
        this.post = post;
    }
}
