package com.project.aplikasi.pemesanan_makanan.data_menu_makanan;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface data_menu_makanan_apiservice {
    
	@FormUrlEncoded
    @POST("api/app/page/data_menu_makanan/tampil.php")
	/* @POST("/data_menu_makanan/data_menu_makanan") */
    Call<data_menu_makanan_api> tampil_data_menu_makanan(
            @Field("berdasarkan") String pencarian,
            @Field("isi") String isi,
            @Field("limit") String limit,
            @Field("hal") String hal,
            @Field("dari") String dari,
            @Field("sampai") String sampai,
            @Header("Authorization") String auth
    );

    @FormUrlEncoded
    @POST("api/app/page/data_menu_makanan/proses_simpan.php")
	/* @POST("/data_menu_makanan/insert") */
    Call<Object> proses_simpan_data_menu_makanan(
            @Field("id_menu_makanan") String id_menu_makanan,
                   @Field("nama") String nama,
                   @Field("id_kategori") String id_kategori,
                   @Field("jumlah") String jumlah,
                   @Field("harga") String harga,
                   @Field("foto") String foto,
                   @Field("keterangan") String keterangan,

			@Header("Authorization") String auth							 
    );

    @FormUrlEncoded
    @POST("api/app/page/data_menu_makanan/proses_update.php")
	/* @POST("/data_menu_makanan/update") */
    Call<Object> proses_update_data_menu_makanan(
            @Field("id_menu_makanan") String id_menu_makanan,
                   @Field("nama") String nama,
                   @Field("id_kategori") String id_kategori,
                   @Field("jumlah") String jumlah,
                   @Field("harga") String harga,
                   @Field("foto") String foto,
                   @Field("keterangan") String keterangan,

			@Header("Authorization") String auth								
    );

    @FormUrlEncoded
    @POST("api/app/page/data_menu_makanan/proses_hapus.php")
	/* @POST("/data_menu_makanan/delete") */
    Call<Object> proses_hapus_data_menu_makanan(
            @Field("id_menu_makanan") String id_menu_makanan,
			@Header("Authorization") String auth
    );


}
