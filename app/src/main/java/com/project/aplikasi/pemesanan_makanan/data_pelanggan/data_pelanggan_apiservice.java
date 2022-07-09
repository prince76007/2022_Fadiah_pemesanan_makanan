package com.project.aplikasi.pemesanan_makanan.data_pelanggan;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface data_pelanggan_apiservice {
    
	@FormUrlEncoded
    @POST("api/app/page/data_pelanggan/tampil.php")
	/* @POST("/data_pelanggan/data_pelanggan") */
    Call<data_pelanggan_api> tampil_data_pelanggan(
            @Field("berdasarkan") String pencarian,
            @Field("isi") String isi,
            @Field("limit") String limit,
            @Field("hal") String hal,
            @Field("dari") String dari,
            @Field("sampai") String sampai,
            @Header("Authorization") String auth
    );

    @FormUrlEncoded
    @POST("api/app/page/data_pelanggan/proses_simpan.php")
	/* @POST("/data_pelanggan/insert") */
    Call<Object> proses_simpan_data_pelanggan(
            @Field("id_pelanggan") String id_pelanggan,
                   @Field("nama") String nama,
                   @Field("alamat") String alamat,
                   @Field("no_telepon") String no_telepon,
                   @Field("username") String username,
                   @Field("password") String password,

			@Header("Authorization") String auth							 
    );

    @FormUrlEncoded
    @POST("api/app/page/data_pelanggan/proses_update.php")
	/* @POST("/data_pelanggan/update") */
    Call<Object> proses_update_data_pelanggan(
            @Field("id_pelanggan") String id_pelanggan,
                   @Field("nama") String nama,
                   @Field("alamat") String alamat,
                   @Field("no_telepon") String no_telepon,
                   @Field("username") String username,
                   @Field("password") String password,

			@Header("Authorization") String auth								
    );

    @FormUrlEncoded
    @POST("api/app/page/data_pelanggan/proses_hapus.php")
	/* @POST("/data_pelanggan/delete") */
    Call<Object> proses_hapus_data_pelanggan(
            @Field("id_pelanggan") String id_pelanggan,
			@Header("Authorization") String auth
    );


}
