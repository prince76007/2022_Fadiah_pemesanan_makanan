package com.project.aplikasi.pemesanan_makanan.data_kategori;

import java.util.ArrayList;

public class data_kategori_api {
    private ArrayList<data_kategori_apidata> result = null;
	private String status;					  
    public ArrayList<data_kategori_apidata> get_data_kategori() {
        return result;
    }
    public void set_data_kategori(ArrayList<data_kategori_apidata> result) {
        this.result = result;
    }
	public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
