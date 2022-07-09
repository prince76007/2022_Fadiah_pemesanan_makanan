package com.project.aplikasi.pemesanan_makanan.data_kategori;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface data_kategori_apiservice {
    
	@FormUrlEncoded
    @POST("api/app/page/data_kategori/tampil.php")
	/* @POST("/data_kategori/data_kategori") */
    Call<data_kategori_api> tampil_data_kategori(
            @Field("berdasarkan") String pencarian,
            @Field("isi") String isi,
            @Field("limit") String limit,
            @Field("hal") String hal,
            @Field("dari") String dari,
            @Field("sampai") String sampai,
            @Header("Authorization") String auth
    );

    @FormUrlEncoded
    @POST("api/app/page/data_kategori/proses_simpan.php")
	/* @POST("/data_kategori/insert") */
    Call<Object> proses_simpan_data_kategori(
            @Field("id_kategori") String id_kategori,
                   @Field("kategori") String kategori,

			@Header("Authorization") String auth							 
    );

    @FormUrlEncoded
    @POST("api/app/page/data_kategori/proses_update.php")
	/* @POST("/data_kategori/update") */
    Call<Object> proses_update_data_kategori(
            @Field("id_kategori") String id_kategori,
                   @Field("kategori") String kategori,

			@Header("Authorization") String auth								
    );

    @FormUrlEncoded
    @POST("api/app/page/data_kategori/proses_hapus.php")
	/* @POST("/data_kategori/delete") */
    Call<Object> proses_hapus_data_kategori(
            @Field("id_kategori") String id_kategori,
			@Header("Authorization") String auth
    );


}
