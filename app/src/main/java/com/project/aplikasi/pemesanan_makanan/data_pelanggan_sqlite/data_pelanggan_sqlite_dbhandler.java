package com.project.aplikasi.pemesanan_makanan.data_pelanggan_sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class data_pelanggan_sqlite_dbhandler extends SQLiteOpenHelper {

    private static final int versi_database = 1;
    private static final String nama_database = "databases_namaaplikasi";
    private static final String nama_tabel = "data_pelanggan";
    private static final String kolom_id_pelanggan = "id_pelanggan";
    private static final String kolom_nama = "nama";
    private static final String kolom_alamat = "alamat";
    private static final String kolom_no_telepon = "no_telepon";
    private static final String kolom_username = "username";
    private static final String kolom_password = "password";


    public data_pelanggan_sqlite_dbhandler(Context context) {
        super(context, nama_database, null, versi_database );
    }

    // BUAT DATABASE
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_USER_TABLE = "CREATE TABLE " + nama_tabel + "("
                + kolom_id_pelanggan + " TEXT " +
				"," + kolom_nama + " TEXT" +
				"," + kolom_alamat + " TEXT" +
				"," + kolom_no_telepon + " TEXT" +
				"," + kolom_username + " TEXT" +
				"," + kolom_password + " TEXT" +

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
    public int get_data_pelanggan_sqlite_count(){
        String countQuery = "SELECT * FROM " + nama_tabel;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();
        return cursor.getCount();
    }

    // TAMPIL DATA 1
    public List<data_pelanggan_sqlite_data>  get_data_pelanggan_sqlite(String berdasarkan, String isi, String tanggal1,String tanggal2,int limit,int halaman){
        List<data_pelanggan_sqlite_data> datalist = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + nama_tabel + " WHERE " + berdasarkan + " LIKE '%" + isi + "%'" ;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()){
            do {
                data_pelanggan_sqlite_data data_pelanggan = new data_pelanggan_sqlite_data(
				cursor.getString(0)
				,cursor.getString(1)
				,cursor.getString(2)
				,cursor.getString(3)
				,cursor.getString(4)
				,cursor.getString(5)

				);
                datalist.add(data_pelanggan);
            } while (cursor.moveToNext());
        }
        return datalist;
    }

    // TAMPIL DATA
    public List<data_pelanggan_sqlite_data> get_semua_data_pelanggan_sqlite(){
        List<data_pelanggan_sqlite_data> datalist = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + nama_tabel;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()){
            do {
                data_pelanggan_sqlite_data data_pelanggan = new data_pelanggan_sqlite_data(
				cursor.getString(0)
				,cursor.getString(1)
				,cursor.getString(2)
				,cursor.getString(3)
				,cursor.getString(4)
				,cursor.getString(5)

				);
                datalist.add(data_pelanggan);
            } while (cursor.moveToNext());
        }
        return datalist;
    }

    // TAMBAH DATA
    public void tambah_data_pelanggan_sqlite(data_pelanggan_sqlite_data data_pelanggan){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put( kolom_id_pelanggan, data_pelanggan.get_id_pelanggan());
        values.put( kolom_nama, data_pelanggan.get_nama());
        values.put( kolom_alamat, data_pelanggan.get_alamat());
        values.put( kolom_no_telepon, data_pelanggan.get_no_telepon());
        values.put( kolom_username, data_pelanggan.get_username());
        values.put( kolom_password, data_pelanggan.get_password());

		
        db.insert( nama_tabel, null, values);
        db.close();
    }

    // EDIT DATA
    public int update_data_pelanggan_sqlite(data_pelanggan_sqlite_data data_pelanggan) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put( kolom_nama, data_pelanggan.get_nama());
        values.put( kolom_alamat, data_pelanggan.get_alamat());
        values.put( kolom_no_telepon, data_pelanggan.get_no_telepon());
        values.put( kolom_username, data_pelanggan.get_username());
        values.put( kolom_password, data_pelanggan.get_password());

        return db.update( nama_tabel, values, kolom_id_pelanggan + " = ?",
                new String[]{String.valueOf(data_pelanggan.get_id_pelanggan())});
    }

    // HAPUS DATA
    public void hapus_data_pelanggan_sqlite(data_pelanggan_sqlite_data data_pelanggan) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete( nama_tabel, kolom_id_pelanggan + " = ?",
                new String[]{String.valueOf(data_pelanggan.get_id_pelanggan())});
        db.close();
    }

    // HAPUS SEMUA
    public void hapussemua_data_pelanggan_sqlite(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM " + nama_tabel );
    }
}




