package com.project.aplikasi.pemesanan_makanan.data_pelanggan;

import com.project.aplikasi.pemesanan_makanan.config.config_apiclient;

import static com.project.aplikasi.pemesanan_makanan.config.config_global.BASE_URL;

public class data_pelanggan_apiutils {


    public static data_pelanggan_apiservice getAPIService() {
        return config_apiclient.getClient(BASE_URL).create( data_pelanggan_apiservice.class);
    }
}
