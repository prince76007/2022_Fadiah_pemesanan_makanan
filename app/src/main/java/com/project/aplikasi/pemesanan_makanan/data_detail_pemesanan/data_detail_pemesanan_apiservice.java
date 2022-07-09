package com.project.aplikasi.pemesanan_makanan.data_detail_pemesanan;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface data_detail_pemesanan_apiservice {
    
	@FormUrlEncoded
    @POST("api/app/page/data_detail_pemesanan/tampil.php")
	/* @POST("/data_detail_pemesanan/data_detail_pemesanan") */
    Call<data_detail_pemesanan_api> tampil_data_detail_pemesanan(
            @Field("berdasarkan") String pencarian,
            @Field("isi") String isi,
            @Field("limit") String limit,
            @Field("hal") String hal,
            @Field("dari") String dari,
            @Field("sampai") String sampai,
            @Header("Authorization") String auth
    );

    @FormUrlEncoded
    @POST("api/app/page/data_detail_pemesanan/proses_simpan.php")
	/* @POST("/data_detail_pemesanan/insert") */
    Call<Object> proses_simpan_data_detail_pemesanan(
            @Field("id_detail_pemesanan") String id_detail_pemesanan,
                   @Field("id_pemesanan") String id_pemesanan,
                   @Field("id_menu_makanan") String id_menu_makanan,
                   @Field("jumlah") String jumlah,
                   @Field("harga") String harga,

			@Header("Authorization") String auth							 
    );

    @FormUrlEncoded
    @POST("api/app/page/data_detail_pemesanan/proses_update.php")
	/* @POST("/data_detail_pemesanan/update") */
    Call<Object> proses_update_data_detail_pemesanan(
            @Field("id_detail_pemesanan") String id_detail_pemesanan,
                   @Field("id_pemesanan") String id_pemesanan,
                   @Field("id_menu_makanan") String id_menu_makanan,
                   @Field("jumlah") String jumlah,
                   @Field("harga") String harga,

			@Header("Authorization") String auth								
    );

    @FormUrlEncoded
    @POST("api/app/page/data_detail_pemesanan/proses_hapus.php")
	/* @POST("/data_detail_pemesanan/delete") */
    Call<Object> proses_hapus_data_detail_pemesanan(
            @Field("id_detail_pemesanan") String id_detail_pemesanan,
			@Header("Authorization") String auth
    );


}
