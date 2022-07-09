package com.project.aplikasi.pemesanan_makanan.combobox_data_kategori;

import retrofit2.Call;
import retrofit2.http.POST;

public interface combobox_data_kategori_apiservice {

    @POST("api/include/combobox/data_kategori.php")
    Call<combobox_data_kategori_api> api();
}





