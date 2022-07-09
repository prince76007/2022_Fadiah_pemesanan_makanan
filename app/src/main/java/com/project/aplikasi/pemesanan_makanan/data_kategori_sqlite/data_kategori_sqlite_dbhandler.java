package com.project.aplikasi.pemesanan_makanan.data_kategori_sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class data_kategori_sqlite_dbhandler extends SQLiteOpenHelper {

    private static final int versi_database = 1;
    private static final String nama_database = "databases_namaaplikasi";
    private static final String nama_tabel = "data_kategori";
    private static final String kolom_id_kategori = "id_kategori";
    private static final String kolom_kategori = "kategori";


    public data_kategori_sqlite_dbhandler(Context context) {
        super(context, nama_database, null, versi_database );
    }

    // BUAT DATABASE
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_USER_TABLE = "CREATE TABLE " + nama_tabel + "("
                + kolom_id_kategori + " TEXT " +
				"," + kolom_kategori + " TEXT" +

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
    public int get_data_kategori_sqlite_count(){
        String countQuery = "SELECT * FROM " + nama_tabel;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();
        return cursor.getCount();
    }

    // TAMPIL DATA 1
    public List<data_kategori_sqlite_data>  get_data_kategori_sqlite(String berdasarkan, String isi, String tanggal1,String tanggal2,int limit,int halaman){
        List<data_kategori_sqlite_data> datalist = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + nama_tabel + " WHERE " + berdasarkan + " LIKE '%" + isi + "%'" ;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()){
            do {
                data_kategori_sqlite_data data_kategori = new data_kategori_sqlite_data(
				cursor.getString(0)
				,cursor.getString(1)

				);
                datalist.add(data_kategori);
            } while (cursor.moveToNext());
        }
        return datalist;
    }

    // TAMPIL DATA
    public List<data_kategori_sqlite_data> get_semua_data_kategori_sqlite(){
        List<data_kategori_sqlite_data> datalist = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + nama_tabel;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()){
            do {
                data_kategori_sqlite_data data_kategori = new data_kategori_sqlite_data(
				cursor.getString(0)
				,cursor.getString(1)

				);
                datalist.add(data_kategori);
            } while (cursor.moveToNext());
        }
        return datalist;
    }

    // TAMBAH DATA
    public void tambah_data_kategori_sqlite(data_kategori_sqlite_data data_kategori){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put( kolom_id_kategori, data_kategori.get_id_kategori());
        values.put( kolom_kategori, data_kategori.get_kategori());

		
        db.insert( nama_tabel, null, values);
        db.close();
    }

    // EDIT DATA
    public int update_data_kategori_sqlite(data_kategori_sqlite_data data_kategori) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put( kolom_kategori, data_kategori.get_kategori());

        return db.update( nama_tabel, values, kolom_id_kategori + " = ?",
                new String[]{String.valueOf(data_kategori.get_id_kategori())});
    }

    // HAPUS DATA
    public void hapus_data_kategori_sqlite(data_kategori_sqlite_data data_kategori) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete( nama_tabel, kolom_id_kategori + " = ?",
                new String[]{String.valueOf(data_kategori.get_id_kategori())});
        db.close();
    }

    // HAPUS SEMUA
    public void hapussemua_data_kategori_sqlite(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM " + nama_tabel );
    }
}




