package com.project.aplikasi.pemesanan_makanan.combobox_data_pemesanan;

import com.project.aplikasi.pemesanan_makanan.config.config_apiclient;
import static com.project.aplikasi.pemesanan_makanan.config.config_global.BASE_URL;

public class combobox_data_pemesanan_apiutils {
    public static combobox_data_pemesanan_apiservice getAPIService() {
        return config_apiclient.getClient(BASE_URL).create(combobox_data_pemesanan_apiservice.class);
    }
}


