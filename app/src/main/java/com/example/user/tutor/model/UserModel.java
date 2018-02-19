package com.example.user.tutor.model;

import java.io.Serializable;

/**
 * Created by user on 09/02/2018.
 */

public class UserModel implements Serializable {

    private static final long serialVersionUID = 1L;

    private String nama;
    private String phone;
    private String email;
    private String pekerjaan;
    private String usia;
    private String beratBadan;
    private String ukuranSepatu;
    private String nilai;

    public String getNilai() {
        return nilai;
    }

    public void setNilai(String nilai) {
        this.nilai = nilai;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
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

    public String getUsia() {
        return usia;
    }

    public void setUsia(String usia) {
        this.usia = usia;
    }

    public String getBeratBadan() {
        return beratBadan;
    }

    public void setBeratBadan(String beratBadan) {
        this.beratBadan = beratBadan;
    }

    public String getUkuranSepatu() {
        return ukuranSepatu;
    }

    public void setUkuranSepatu(String ukuranSepatu) {
        this.ukuranSepatu = ukuranSepatu;
    }
}
