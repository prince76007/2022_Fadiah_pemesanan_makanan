package com.project.aplikasi.pemesanan_makanan.data_pemesanan_sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class data_pemesanan_sqlite_dbhandler extends SQLiteOpenHelper {

    private static final int versi_database = 1;
    private static final String nama_database = "databases_namaaplikasi";
    private static final String nama_tabel = "data_pemesanan";
    private static final String kolom_id_pemesanan = "id_pemesanan";
    private static final String kolom_tanggal = "tanggal";
    private static final String kolom_id_pelanggan = "id_pelanggan";
    private static final String kolom_total_bayar = "total_bayar";
    private static final String kolom_lat = "lat";
    private static final String kolom_lng = "lng";
    private static final String kolom_alamat_pengiriman = "alamat_pengiriman";
    private static final String kolom_status = "status";


    public data_pemesanan_sqlite_dbhandler(Context context) {
        super(context, nama_database, null, versi_database );
    }

    // BUAT DATABASE
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_USER_TABLE = "CREATE TABLE " + nama_tabel + "("
                + kolom_id_pemesanan + " TEXT " +
				"," + kolom_tanggal + " TEXT" +
				"," + kolom_id_pelanggan + " TEXT" +
				"," + kolom_total_bayar + " TEXT" +
				"," + kolom_lat + " TEXT" +
				"," + kolom_lng + " TEXT" +
				"," + kolom_alamat_pengiriman + " TEXT" +
				"," + kolom_status + " TEXT" +

                ")";
        db.execSQL(CREATE_USER_TABLE);
    }

    // CEK DATA
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + nama_tabel );
        onCreate(db);
    }

    // HITUNG DATA
    public int get_data_pemesanan_sqlite_count(){
        String countQuery = "SELECT * FROM " + nama_tabel;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();
        return cursor.getCount();
    }

    // TAMPIL DATA 1
    public List<data_pemesanan_sqlite_data>  get_data_pemesanan_sqlite(String berdasarkan, String isi, String tanggal1,String tanggal2,int limit,int halaman){
        List<data_pemesanan_sqlite_data> datalist = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + nama_tabel + " WHERE " + berdasarkan + " LIKE '%" + isi + "%'" ;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()){
            do {
                data_pemesanan_sqlite_data data_pemesanan = new data_pemesanan_sqlite_data(
				cursor.getString(0)
				,cursor.getString(1)
				,cursor.getString(2)
				,cursor.getString(3)
				,cursor.getString(4)
				,cursor.getString(5)
				,cursor.getString(6)
				,cursor.getString(7)

				);
                datalist.add(data_pemesanan);
            } while (cursor.moveToNext());
        }
        return datalist;
    }

    // TAMPIL DATA
    public List<data_pemesanan_sqlite_data> get_semua_data_pemesanan_sqlite(){
        List<data_pemesanan_sqlite_data> datalist = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + nama_tabel;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()){
            do {
                data_pemesanan_sqlite_data data_pemesanan = new data_pemesanan_sqlite_data(
				cursor.getString(0)
				,cursor.getString(1)
				,cursor.getString(2)
				,cursor.getString(3)
				,cursor.getString(4)
				,cursor.getString(5)
				,cursor.getString(6)
				,cursor.getString(7)

				);
                datalist.add(data_pemesanan);
            } while (cursor.moveToNext());
        }
        return datalist;
    }

    // TAMBAH DATA
    public void tambah_data_pemesanan_sqlite(data_pemesanan_sqlite_data data_pemesanan){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put( kolom_id_pemesanan, data_pemesanan.get_id_pemesanan());
        values.put( kolom_tanggal, data_pemesanan.get_tanggal());
        values.put( kolom_id_pelanggan, data_pemesanan.get_id_pelanggan());
        values.put( kolom_total_bayar, data_pemesanan.get_total_bayar());
        values.put( kolom_lat, data_pemesanan.get_lat());
        values.put( kolom_lng, data_pemesanan.get_lng());
        values.put( kolom_alamat_pengiriman, data_pemesanan.get_alamat_pengiriman());
        values.put( kolom_status, data_pemesanan.get_status());

		
        db.insert( nama_tabel, null, values);
        db.close();
    }

    // EDIT DATA
    public int update_data_pemesanan_sqlite(data_pemesanan_sqlite_data data_pemesanan) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put( kolom_tanggal, data_pemesanan.get_tanggal());
        values.put( kolom_id_pelanggan, data_pemesanan.get_id_pelanggan());
        values.put( kolom_total_bayar, data_pemesanan.get_total_bayar());
        values.put( kolom_lat, data_pemesanan.get_lat());
        values.put( kolom_lng, data_pemesanan.get_lng());
        values.put( kolom_alamat_pengiriman, data_pemesanan.get_alamat_pengiriman());
        values.put( kolom_status, data_pemesanan.get_status());

        return db.update( nama_tabel, values, kolom_id_pemesanan + " = ?",
                new String[]{String.valueOf(data_pemesanan.get_id_pemesanan())});
    }

    // HAPUS DATA
    public void hapus_data_pemesanan_sqlite(data_pemesanan_sqlite_data data_pemesanan) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete( nama_tabel, kolom_id_pemesanan + " = ?",
                new String[]{String.valueOf(data_pemesanan.get_id_pemesanan())});
        db.close();
    }

    // HAPUS SEMUA
    public void hapussemua_data_pemesanan_sqlite(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM " + nama_tabel );
    }
}




