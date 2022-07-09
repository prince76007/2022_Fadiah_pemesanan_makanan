package com.project.aplikasi.pemesanan_makanan.data_menu_makanan_sqlite;

public class data_menu_makanan_sqlite_data {
    private String id_menu_makanan;
    private String nama;
    private String id_kategori;
    private String jumlah;
    private String harga;
    private String foto;
    private String keterangan;


    public data_menu_makanan_sqlite_data() {
    }

    public data_menu_makanan_sqlite_data(String id_menu_makanan
    ,String nama
    ,String id_kategori
    ,String jumlah
    ,String harga
    ,String foto
    ,String keterangan

	
	) {
        this.id_menu_makanan = id_menu_makanan;
        this.nama = nama;
        this.id_kategori = id_kategori;
        this.jumlah = jumlah;
        this.harga = harga;
        this.foto = foto;
        this.keterangan = keterangan;

        
    }

    public String get_id_menu_makanan() {
        return id_menu_makanan;
    }
    public void set_id_menu_makanan(String id_menu_makanan) {
        this.id_menu_makanan = id_menu_makanan;
    }

public String get_nama() {
    return nama;
}
public void set_nama(String nama) {
    this.nama = nama;
}
public String get_id_kategori() {
    return id_kategori;
}
public void set_id_kategori(String id_kategori) {
    this.id_kategori = id_kategori;
}
public String get_jumlah() {
    return jumlah;
}
public void set_jumlah(String jumlah) {
    this.jumlah = jumlah;
}
public String get_harga() {
    return harga;
}
public void set_harga(String harga) {
    this.harga = harga;
}
public String get_foto() {
    return foto;
}
public void set_foto(String foto) {
    this.foto = foto;
}
public String get_keterangan() {
    return keterangan;
}
public void set_keterangan(String keterangan) {
    this.keterangan = keterangan;
}

    
    
}







