package com.project.aplikasi.pemesanan_makanan.data_detail_pemesanan;

import com.project.aplikasi.pemesanan_makanan.config.config_apiclient;

import static com.project.aplikasi.pemesanan_makanan.config.config_global.BASE_URL;

public class data_detail_pemesanan_apiutils {


    public static data_detail_pemesanan_apiservice getAPIService() {
        return config_apiclient.getClient(BASE_URL).create( data_detail_pemesanan_apiservice.class);
    }
}
