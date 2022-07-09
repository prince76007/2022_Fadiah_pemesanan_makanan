package com.project.aplikasi.pemesanan_makanan.data_detail_pemesanan;

import java.util.ArrayList;

public class data_detail_pemesanan_api {
    private ArrayList<data_detail_pemesanan_apidata> result = null;
	private String status;					  
    public ArrayList<data_detail_pemesanan_apidata> get_data_detail_pemesanan() {
        return result;
    }
    public void set_data_detail_pemesanan(ArrayList<data_detail_pemesanan_apidata> result) {
        this.result = result;
    }
	public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
