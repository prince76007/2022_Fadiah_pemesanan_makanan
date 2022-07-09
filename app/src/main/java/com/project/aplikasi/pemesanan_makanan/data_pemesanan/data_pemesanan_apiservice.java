package com.project.aplikasi.pemesanan_makanan.data_pemesanan;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface data_pemesanan_apiservice {
    
	@FormUrlEncoded
    @POST("api/app/page/data_pemesanan/tampil.php")
	/* @POST("/data_pemesanan/data_pemesanan") */
    Call<data_pemesanan_api> tampil_data_pemesanan(
            @Field("berdasarkan") String pencarian,
            @Field("isi") String isi,
            @Field("limit") String limit,
            @Field("hal") String hal,
            @Field("dari") String dari,
            @Field("sampai") String sampai,
            @Header("Authorization") String auth
    );

    @FormUrlEncoded
    @POST("api/app/page/data_pemesanan/proses_simpan.php")
	/* @POST("/data_pemesanan/insert") */
    Call<Object> proses_simpan_data_pemesanan(
            @Field("id_pemesanan") String id_pemesanan,
                   @Field("tanggal") String tanggal,
                   @Field("id_pelanggan") String id_pelanggan,
                   @Field("total_bayar") String total_bayar,
                   @Field("lat") String lat,
                   @Field("lng") String lng,
                   @Field("alamat_pengiriman") String alamat_pengiriman,
                   @Field("status") String status,

			@Header("Authorization") String auth							 
    );

    @FormUrlEncoded
    @POST("api/app/page/data_pemesanan/proses_update.php")
	/* @POST("/data_pemesanan/update") */
    Call<Object> proses_update_data_pemesanan(
            @Field("id_pemesanan") String id_pemesanan,
                   @Field("tanggal") String tanggal,
                   @Field("id_pelanggan") String id_pelanggan,
                   @Field("total_bayar") String total_bayar,
                   @Field("lat") String lat,
                   @Field("lng") String lng,
                   @Field("alamat_pengiriman") String alamat_pengiriman,
                   @Field("status") String status,

			@Header("Authorization") String auth								
    );

    @FormUrlEncoded
    @POST("api/app/page/data_pemesanan/proses_hapus.php")
	/* @POST("/data_pemesanan/delete") */
    Call<Object> proses_hapus_data_pemesanan(
            @Field("id_pemesanan") String id_pemesanan,
			@Header("Authorization") String auth
    );


}
