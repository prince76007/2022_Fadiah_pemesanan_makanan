package com.project.aplikasi.pemesanan_makanan.data_kategori;

public class data_kategori_apidata {
    private String id_kategori;
      private String kategori;

	
	
	public data_kategori_apidata(String id_kategori
	,String kategori

	) {
        this.id_kategori = id_kategori;
        this.kategori = kategori;

    }

    public String get_id_kategori() {
        return id_kategori;
    }
    public void set_id_kategori(String id_kategori) {
        this.id_kategori = id_kategori;
    }

    public String get_kategori() {
        return kategori;
    }
    public void set_kategori(String kategori) {
        this.kategori = kategori;
    }

}
