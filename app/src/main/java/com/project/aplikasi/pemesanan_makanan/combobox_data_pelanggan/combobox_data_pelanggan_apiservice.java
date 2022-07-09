package com.project.aplikasi.pemesanan_makanan.combobox_data_pelanggan;

import retrofit2.Call;
import retrofit2.http.POST;

public interface combobox_data_pelanggan_apiservice {

    @POST("api/include/combobox/data_pelanggan.php")
    Call<combobox_data_pelanggan_api> api();
}





