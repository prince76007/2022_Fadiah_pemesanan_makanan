package com.project.aplikasi.pemesanan_makanan.data_kategori;

import com.project.aplikasi.pemesanan_makanan.config.config_apiclient;

import static com.project.aplikasi.pemesanan_makanan.config.config_global.BASE_URL;

public class data_kategori_apiutils {


    public static data_kategori_apiservice getAPIService() {
        return config_apiclient.getClient(BASE_URL).create( data_kategori_apiservice.class);
    }
}
