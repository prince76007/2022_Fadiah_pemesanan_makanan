package com.project.aplikasi.pemesanan_makanan.data_detail_pemesanan;

public class data_detail_pemesanan_apidata {
    private String id_detail_pemesanan;
      private String id_pemesanan;
      private String id_menu_makanan;
      private String jumlah;
      private String harga;

	
	
	public data_detail_pemesanan_apidata(String id_detail_pemesanan
	,String id_pemesanan
	,String id_menu_makanan
	,String jumlah
	,String harga

	) {
        this.id_detail_pemesanan = id_detail_pemesanan;
        this.id_pemesanan = id_pemesanan;
        this.id_menu_makanan = id_menu_makanan;
        this.jumlah = jumlah;
        this.harga = harga;

    }

    public String get_id_detail_pemesanan() {
        return id_detail_pemesanan;
    }
    public void set_id_detail_pemesanan(String id_detail_pemesanan) {
        this.id_detail_pemesanan = id_detail_pemesanan;
    }

    public String get_id_pemesanan() {
        return id_pemesanan;
    }
    public void set_id_pemesanan(String id_pemesanan) {
        this.id_pemesanan = id_pemesanan;
    }
    public String get_id_menu_makanan() {
        return id_menu_makanan;
    }
    public void set_id_menu_makanan(String id_menu_makanan) {
        this.id_menu_makanan = id_menu_makanan;
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

}
