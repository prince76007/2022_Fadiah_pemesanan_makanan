package com.project.aplikasi.pemesanan_makanan.activity;

public class login_pegawai_apidata {
    private String username;
    private String password;
    private String nama_pegawai;
    private String jabatan;
    private String tkn;


    public login_pegawai_apidata(String username
            , String password
            , String nama_pegawai
            , String jabatan
            , String tkn

    ) {
        this.username = username;
        this.password = password;
        this.nama_pegawai = nama_pegawai;
        this.jabatan = jabatan;
        this.tkn = tkn;

    }

    public String get_username() {
        return username;
    }

    public void set_username(String username) {
        this.username = username;
    }

    public String get_password() {
        return password;
    }

    public void set_password(String password) {
        this.password = password;
    }

    public String get_nama_pegawai() {
        return nama_pegawai;
    }

    public void set_nama_pegawai(String nama_pegawai) {
        this.nama_pegawai = nama_pegawai;
    }

    public String get_jabatan() {
        return jabatan;
    }

    public void set_jabatan(String jabatan) {
        this.jabatan = jabatan;
    }

    public String get_tkn() {
        return tkn;
    }

    public void set_tkn(String tkn) {
        this.tkn = tkn;
    }

}







