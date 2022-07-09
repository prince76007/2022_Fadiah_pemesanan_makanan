
package com.project.aplikasi.pemesanan_makanan.combobox_data_kategori;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class combobox_data_kategori_apidata {

    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("nama")
    @Expose
    private String nama;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }
    public void setNama(String nama) {
        this.nama = nama;
    }

}
