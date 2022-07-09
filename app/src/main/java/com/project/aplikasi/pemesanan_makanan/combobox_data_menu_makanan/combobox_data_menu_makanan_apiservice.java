package com.project.aplikasi.pemesanan_makanan.combobox_data_menu_makanan;

import retrofit2.Call;
import retrofit2.http.POST;

public interface combobox_data_menu_makanan_apiservice {

    @POST("api/include/combobox/data_menu_makanan.php")
    Call<combobox_data_menu_makanan_api> api();
}





