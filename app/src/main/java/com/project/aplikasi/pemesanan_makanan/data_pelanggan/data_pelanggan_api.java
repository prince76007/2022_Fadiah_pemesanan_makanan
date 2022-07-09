package com.project.aplikasi.pemesanan_makanan.data_pelanggan;

import java.util.ArrayList;

public class data_pelanggan_api {
    private ArrayList<data_pelanggan_apidata> result = null;
	private String status;					  
    public ArrayList<data_pelanggan_apidata> get_data_pelanggan() {
        return result;
    }
    public void set_data_pelanggan(ArrayList<data_pelanggan_apidata> result) {
        this.result = result;
    }
	public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
