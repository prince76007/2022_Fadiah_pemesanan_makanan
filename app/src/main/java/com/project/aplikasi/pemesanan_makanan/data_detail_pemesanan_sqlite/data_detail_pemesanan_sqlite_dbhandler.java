package com.project.aplikasi.pemesanan_makanan.data_detail_pemesanan_sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class data_detail_pemesanan_sqlite_dbhandler extends SQLiteOpenHelper {

    private static final int versi_database = 1;
    private static final String nama_database = "databases_namaaplikasi";
    private static final String nama_tabel = "data_detail_pemesanan";
    private static final String kolom_id_detail_pemesanan = "id_detail_pemesanan";
    private static final String kolom_id_pemesanan = "id_pemesanan";
    private static final String kolom_id_menu_makanan = "id_menu_makanan";
    private static final String kolom_jumlah = "jumlah";
    private static final String kolom_harga = "harga";


    public data_detail_pemesanan_sqlite_dbhandler(Context context) {
        super(context, nama_database, null, versi_database );
    }

    // BUAT DATABASE
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_USER_TABLE = "CREATE TABLE " + nama_tabel + "("
                + kolom_id_detail_pemesanan + " TEXT " +
				"," + kolom_id_pemesanan + " TEXT" +
				"," + kolom_id_menu_makanan + " TEXT" +
				"," + kolom_jumlah + " TEXT" +
				"," + kolom_harga + " TEXT" +

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
    public int get_data_detail_pemesanan_sqlite_count(){
        String countQuery = "SELECT * FROM " + nama_tabel;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();
        return cursor.getCount();
    }

    // TAMPIL DATA 1
    public List<data_detail_pemesanan_sqlite_data>  get_data_detail_pemesanan_sqlite(String berdasarkan, String isi, String tanggal1,String tanggal2,int limit,int halaman){
        List<data_detail_pemesanan_sqlite_data> datalist = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + nama_tabel + " WHERE " + berdasarkan + " LIKE '%" + isi + "%'" ;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()){
            do {
                data_detail_pemesanan_sqlite_data data_detail_pemesanan = new data_detail_pemesanan_sqlite_data(
				cursor.getString(0)
				,cursor.getString(1)
				,cursor.getString(2)
				,cursor.getString(3)
				,cursor.getString(4)

				);
                datalist.add(data_detail_pemesanan);
            } while (cursor.moveToNext());
        }
        return datalist;
    }

    // TAMPIL DATA
    public List<data_detail_pemesanan_sqlite_data> get_semua_data_detail_pemesanan_sqlite(){
        List<data_detail_pemesanan_sqlite_data> datalist = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + nama_tabel;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()){
            do {
                data_detail_pemesanan_sqlite_data data_detail_pemesanan = new data_detail_pemesanan_sqlite_data(
				cursor.getString(0)
				,cursor.getString(1)
				,cursor.getString(2)
				,cursor.getString(3)
				,cursor.getString(4)

				);
                datalist.add(data_detail_pemesanan);
            } while (cursor.moveToNext());
        }
        return datalist;
    }

    // TAMBAH DATA
    public void tambah_data_detail_pemesanan_sqlite(data_detail_pemesanan_sqlite_data data_detail_pemesanan){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put( kolom_id_detail_pemesanan, data_detail_pemesanan.get_id_detail_pemesanan());
        values.put( kolom_id_pemesanan, data_detail_pemesanan.get_id_pemesanan());
        values.put( kolom_id_menu_makanan, data_detail_pemesanan.get_id_menu_makanan());
        values.put( kolom_jumlah, data_detail_pemesanan.get_jumlah());
        values.put( kolom_harga, data_detail_pemesanan.get_harga());

		
        db.insert( nama_tabel, null, values);
        db.close();
    }

    // EDIT DATA
    public int update_data_detail_pemesanan_sqlite(data_detail_pemesanan_sqlite_data data_detail_pemesanan) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put( kolom_id_pemesanan, data_detail_pemesanan.get_id_pemesanan());
        values.put( kolom_id_menu_makanan, data_detail_pemesanan.get_id_menu_makanan());
        values.put( kolom_jumlah, data_detail_pemesanan.get_jumlah());
        values.put( kolom_harga, data_detail_pemesanan.get_harga());

        return db.update( nama_tabel, values, kolom_id_detail_pemesanan + " = ?",
                new String[]{String.valueOf(data_detail_pemesanan.get_id_detail_pemesanan())});
    }

    // HAPUS DATA
    public void hapus_data_detail_pemesanan_sqlite(data_detail_pemesanan_sqlite_data data_detail_pemesanan) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete( nama_tabel, kolom_id_detail_pemesanan + " = ?",
                new String[]{String.valueOf(data_detail_pemesanan.get_id_detail_pemesanan())});
        db.close();
    }

    // HAPUS SEMUA
    public void hapussemua_data_detail_pemesanan_sqlite(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM " + nama_tabel );
    }
}




