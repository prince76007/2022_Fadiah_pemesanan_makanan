package com.project.aplikasi.pemesanan_makanan.data_pemesanan;

import java.util.ArrayList;

public class data_pemesanan_api {
    private ArrayList<data_pemesanan_apidata> result = null;
	private String status;					  
    public ArrayList<data_pemesanan_apidata> get_data_pemesanan() {
        return result;
    }
    public void set_data_pemesanan(ArrayList<data_pemesanan_apidata> result) {
        this.result = result;
    }
	public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
