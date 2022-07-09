package com.project.aplikasi.pemesanan_makanan.data_pemesanan;

import com.project.aplikasi.pemesanan_makanan.config.config_apiclient;

import static com.project.aplikasi.pemesanan_makanan.config.config_global.BASE_URL;

public class data_pemesanan_apiutils {


    public static data_pemesanan_apiservice getAPIService() {
        return config_apiclient.getClient(BASE_URL).create( data_pemesanan_apiservice.class);
    }
}
