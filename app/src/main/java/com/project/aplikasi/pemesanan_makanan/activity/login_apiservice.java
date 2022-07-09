package com.project.aplikasi.pemesanan_makanan.activity;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface login_apiservice {

    @FormUrlEncoded
    @POST("api/login/login.php")
    Call<login_pegawai_api> login_pegawai(
            @Field("username") String username,
            @Field("password") String password
    );
}





