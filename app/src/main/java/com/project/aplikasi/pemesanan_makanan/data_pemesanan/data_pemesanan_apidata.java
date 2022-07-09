package com.project.aplikasi.pemesanan_makanan.data_pemesanan;

public class data_pemesanan_apidata {
    private String id_pemesanan;
      private String tanggal;
      private String id_pelanggan;
      private String total_bayar;
      private String lat;
      private String lng;
      private String alamat_pengiriman;
      private String status;

	
	
	public data_pemesanan_apidata(String id_pemesanan
	,String tanggal
	,String id_pelanggan
	,String total_bayar
	,String lat
	,String lng
	,String alamat_pengiriman
	,String status

	) {
        this.id_pemesanan = id_pemesanan;
        this.tanggal = tanggal;
        this.id_pelanggan = id_pelanggan;
        this.total_bayar = total_bayar;
        this.lat = lat;
        this.lng = lng;
        this.alamat_pengiriman = alamat_pengiriman;
        this.status = status;

    }

    public String get_id_pemesanan() {
        return id_pemesanan;
    }
    public void set_id_pemesanan(String id_pemesanan) {
        this.id_pemesanan = id_pemesanan;
    }

    public String get_tanggal() {
        return tanggal;
    }
    public void set_tanggal(String tanggal) {
        this.tanggal = tanggal;
    }
    public String get_id_pelanggan() {
        return id_pelanggan;
    }
    public void set_id_pelanggan(String id_pelanggan) {
        this.id_pelanggan = id_pelanggan;
    }
    public String get_total_bayar() {
        return total_bayar;
    }
    public void set_total_bayar(String total_bayar) {
        this.total_bayar = total_bayar;
    }
    public String get_lat() {
        return lat;
    }
    public void set_lat(String lat) {
        this.lat = lat;
    }
    public String get_lng() {
        return lng;
    }
    public void set_lng(String lng) {
        this.lng = lng;
    }
    public String get_alamat_pengiriman() {
        return alamat_pengiriman;
    }
    public void set_alamat_pengiriman(String alamat_pengiriman) {
        this.alamat_pengiriman = alamat_pengiriman;
    }
    public String get_status() {
        return status;
    }
    public void set_status(String status) {
        this.status = status;
    }

}
