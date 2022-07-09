package com.project.aplikasi.pemesanan_makanan.data_menu_makanan;

import java.util.ArrayList;

public class data_menu_makanan_api {
    private ArrayList<data_menu_makanan_apidata> result = null;
	private String status;					  
    public ArrayList<data_menu_makanan_apidata> get_data_menu_makanan() {
        return result;
    }
    public void set_data_menu_makanan(ArrayList<data_menu_makanan_apidata> result) {
        this.result = result;
    }
	public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
