package com.project.aplikasi.pemesanan_makanan.combobox_data_pemesanan;

import retrofit2.Call;
import retrofit2.http.POST;

public interface combobox_data_pemesanan_apiservice {

    @POST("api/include/combobox/data_pemesanan.php")
    Call<combobox_data_pemesanan_api> api();
}





