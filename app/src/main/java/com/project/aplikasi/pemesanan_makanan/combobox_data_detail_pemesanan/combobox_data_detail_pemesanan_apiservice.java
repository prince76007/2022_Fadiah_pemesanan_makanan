package com.project.aplikasi.pemesanan_makanan.combobox_data_detail_pemesanan;

import retrofit2.Call;
import retrofit2.http.POST;

public interface combobox_data_detail_pemesanan_apiservice {

    @POST("api/include/combobox/data_detail_pemesanan.php")
    Call<combobox_data_detail_pemesanan_api> api();
}





