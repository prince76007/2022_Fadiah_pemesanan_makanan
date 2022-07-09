package com.project.aplikasi.pemesanan_makanan.data_menu_makanan_sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class data_menu_makanan_sqlite_dbhandler extends SQLiteOpenHelper {

    private static final int versi_database = 1;
    private static final String nama_database = "databases_namaaplikasi";
    private static final String nama_tabel = "data_menu_makanan";
    private static final String kolom_id_menu_makanan = "id_menu_makanan";
    private static final String kolom_nama = "nama";
    private static final String kolom_id_kategori = "id_kategori";
    private static final String kolom_jumlah = "jumlah";
    private static final String kolom_harga = "harga";
    private static final String kolom_foto = "foto";
    private static final String kolom_keterangan = "keterangan";


    public data_menu_makanan_sqlite_dbhandler(Context context) {
        super(context, nama_database, null, versi_database );
    }

    // BUAT DATABASE
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_USER_TABLE = "CREATE TABLE " + nama_tabel + "("
                + kolom_id_menu_makanan + " TEXT " +
				"," + kolom_nama + " TEXT" +
				"," + kolom_id_kategori + " TEXT" +
				"," + kolom_jumlah + " TEXT" +
				"," + kolom_harga + " TEXT" +
				"," + kolom_foto + " TEXT" +
				"," + kolom_keterangan + " TEXT" +

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
    public int get_data_menu_makanan_sqlite_count(){
        String countQuery = "SELECT * FROM " + nama_tabel;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();
        return cursor.getCount();
    }

    // TAMPIL DATA 1
    public List<data_menu_makanan_sqlite_data>  get_data_menu_makanan_sqlite(String berdasarkan, String isi, String tanggal1,String tanggal2,int limit,int halaman){
        List<data_menu_makanan_sqlite_data> datalist = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + nama_tabel + " WHERE " + berdasarkan + " LIKE '%" + isi + "%'" ;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()){
            do {
                data_menu_makanan_sqlite_data data_menu_makanan = new data_menu_makanan_sqlite_data(
				cursor.getString(0)
				,cursor.getString(1)
				,cursor.getString(2)
				,cursor.getString(3)
				,cursor.getString(4)
				,cursor.getString(5)
				,cursor.getString(6)

				);
                datalist.add(data_menu_makanan);
            } while (cursor.moveToNext());
        }
        return datalist;
    }

    // TAMPIL DATA
    public List<data_menu_makanan_sqlite_data> get_semua_data_menu_makanan_sqlite(){
        List<data_menu_makanan_sqlite_data> datalist = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + nama_tabel;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()){
            do {
                data_menu_makanan_sqlite_data data_menu_makanan = new data_menu_makanan_sqlite_data(
				cursor.getString(0)
				,cursor.getString(1)
				,cursor.getString(2)
				,cursor.getString(3)
				,cursor.getString(4)
				,cursor.getString(5)
				,cursor.getString(6)

				);
                datalist.add(data_menu_makanan);
            } while (cursor.moveToNext());
        }
        return datalist;
    }

    // TAMBAH DATA
    public void tambah_data_menu_makanan_sqlite(data_menu_makanan_sqlite_data data_menu_makanan){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put( kolom_id_menu_makanan, data_menu_makanan.get_id_menu_makanan());
        values.put( kolom_nama, data_menu_makanan.get_nama());
        values.put( kolom_id_kategori, data_menu_makanan.get_id_kategori());
        values.put( kolom_jumlah, data_menu_makanan.get_jumlah());
        values.put( kolom_harga, data_menu_makanan.get_harga());
        values.put( kolom_foto, data_menu_makanan.get_foto());
        values.put( kolom_keterangan, data_menu_makanan.get_keterangan());

		
        db.insert( nama_tabel, null, values);
        db.close();
    }

    // EDIT DATA
    public int update_data_menu_makanan_sqlite(data_menu_makanan_sqlite_data data_menu_makanan) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put( kolom_nama, data_menu_makanan.get_nama());
        values.put( kolom_id_kategori, data_menu_makanan.get_id_kategori());
        values.put( kolom_jumlah, data_menu_makanan.get_jumlah());
        values.put( kolom_harga, data_menu_makanan.get_harga());
        values.put( kolom_foto, data_menu_makanan.get_foto());
        values.put( kolom_keterangan, data_menu_makanan.get_keterangan());

        return db.update( nama_tabel, values, kolom_id_menu_makanan + " = ?",
                new String[]{String.valueOf(data_menu_makanan.get_id_menu_makanan())});
    }

    // HAPUS DATA
    public void hapus_data_menu_makanan_sqlite(data_menu_makanan_sqlite_data data_menu_makanan) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete( nama_tabel, kolom_id_menu_makanan + " = ?",
                new String[]{String.valueOf(data_menu_makanan.get_id_menu_makanan())});
        db.close();
    }

    // HAPUS SEMUA
    public void hapussemua_data_menu_makanan_sqlite(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM " + nama_tabel );
    }
}




