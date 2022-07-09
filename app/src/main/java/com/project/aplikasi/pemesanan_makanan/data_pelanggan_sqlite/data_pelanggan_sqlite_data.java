package com.project.aplikasi.pemesanan_makanan.data_pelanggan_sqlite;

public class data_pelanggan_sqlite_data {
    private String id_pelanggan;
    private String nama;
    private String alamat;
    private String no_telepon;
    private String username;
    private String password;


    public data_pelanggan_sqlite_data() {
    }

    public data_pelanggan_sqlite_data(String id_pelanggan
    ,String nama
    ,String alamat
    ,String no_telepon
    ,String username
    ,String password

	
	) {
        this.id_pelanggan = id_pelanggan;
        this.nama = nama;
        this.alamat = alamat;
        this.no_telepon = no_telepon;
        this.username = username;
        this.password = password;

        
    }

    public String get_id_pelanggan() {
        return id_pelanggan;
    }
    public void set_id_pelanggan(String id_pelanggan) {
        this.id_pelanggan = id_pelanggan;
    }

public String get_nama() {
    return nama;
}
public void set_nama(String nama) {
    this.nama = nama;
}
public String get_alamat() {
    return alamat;
}
public void set_alamat(String alamat) {
    this.alamat = alamat;
}
public String get_no_telepon() {
    return no_telepon;
}
public void set_no_telepon(String no_telepon) {
    this.no_telepon = no_telepon;
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

    
    
}







