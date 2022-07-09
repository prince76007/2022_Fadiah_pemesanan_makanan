package com.project.aplikasi.pemesanan_makanan.data_admin;

import java.util.ArrayList;

public class data_admin_api {
    private ArrayList<data_admin_apidata> result = null;
	private String status;					  
    public ArrayList<data_admin_apidata> get_data_admin() {
        return result;
    }
    public void set_data_admin(ArrayList<data_admin_apidata> result) {
        this.result = result;
    }
	public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
