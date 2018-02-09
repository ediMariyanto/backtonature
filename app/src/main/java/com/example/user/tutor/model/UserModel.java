package com.example.user.tutor.model;

import java.io.Serializable;

/**
 * Created by user on 09/02/2018.
 */

public class UserModel implements Serializable {

    private String nama;
    private int phone;
    private String email;
    private String pekerjaan;
    private int usia;
    private int beratBadan;
    private int ukuranSepatu;

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPekerjaan() {
        return pekerjaan;
    }

    public void setPekerjaan(String pekerjaan) {
        this.pekerjaan = pekerjaan;
    }

    public int getUsia() {
        return usia;
    }

    public void setUsia(int usia) {
        this.usia = usia;
    }

    public int getBeratBadan() {
        return beratBadan;
    }

    public void setBeratBadan(int beratBadan) {
        this.beratBadan = beratBadan;
    }

    public int getUkuranSepatu() {
        return ukuranSepatu;
    }

    public void setUkuranSepatu(int ukuranSepatu) {
        this.ukuranSepatu = ukuranSepatu;
    }
}
