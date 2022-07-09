package com.project.aplikasi.pemesanan_makanan.data_pemesanan_sqlite;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.project.aplikasi.pemesanan_makanan.R;
import com.project.aplikasi.pemesanan_makanan.config.config_global;
import java.util.List;


public class data_pemesanan_sqlite_tambah extends AppCompatActivity {

    String validasi;
    private EditText id_pemesanan;
    private EditText tanggal;
    private EditText id_pelanggan;
    private EditText total_bayar;
    private EditText lat;
    private EditText lng;
    private EditText alamat_pengiriman;
    private EditText status;

    
    private Button button_tambahdata;

    private data_pemesanan_sqlite_dbhandler dbHandler;
    private data_pemesanan_sqlite_adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data_pemesanan_tambah );
        dbHandler = new data_pemesanan_sqlite_dbhandler(this);

        button_tambahdata = (Button) findViewById(R.id.tombol_simpan);
        id_pemesanan = (EditText) findViewById(R.id.id_pemesanan);
        tanggal = (EditText) findViewById(R.id.tanggal);
        id_pelanggan = (EditText) findViewById(R.id.id_pelanggan);
        total_bayar = (EditText) findViewById(R.id.total_bayar);
        lat = (EditText) findViewById(R.id.lat);
        lng = (EditText) findViewById(R.id.lng);
        alamat_pengiriman = (EditText) findViewById(R.id.alamat_pengiriman);
        status = (EditText) findViewById(R.id.status);


        id_pemesanan.setText( config_global.generate_id( data_pemesanan_sqlite_tambah.this,"data_pemesanan") );
		
		config_global.init_inputTypes();


        button_tambahdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showLoading();
                id_pemesanan.setText( config_global.generate_id( data_pemesanan_sqlite_tambah.this,"data_pemesanan") );
                validasi ="berhasil";
                validasiForm((ViewGroup) findViewById(R.id.group));
                if (validasi =="gagal") {
                    Toast.makeText( data_pemesanan_sqlite_tambah.this,  "Gagal Proses, Ada data Yang Masih Kosong dan Perlu diinputkan.",
                            Toast.LENGTH_LONG ).show();
                    hideLoading();
                }  else {
                    //proses simpan
                    dbHandler.tambah_data_pemesanan_sqlite( new data_pemesanan_sqlite_data(
                            id_pemesanan.getText().toString()
                            ,tanggal.getText().toString()
                            ,id_pelanggan.getText().toString()
                            ,total_bayar.getText().toString()
                            ,lat.getText().toString()
                            ,lng.getText().toString()
                            ,alamat_pengiriman.getText().toString()
                            ,status.getText().toString()

                    ) );

                    List<data_pemesanan_sqlite_data> data_pemesanan_sqliteList = dbHandler.get_semua_data_pemesanan_sqlite();
                    adapter = new data_pemesanan_sqlite_adapter( data_pemesanan_sqlite_tambah.this, data_pemesanan_sqliteList );
                    adapter.notifyDataSetChanged();
                    Toast.makeText( data_pemesanan_sqlite_tambah.this, "Berhasil Menambahkan Data", Toast.LENGTH_SHORT ).show();
                    setResult( RESULT_OK );
                    clearForm((ViewGroup) findViewById(R.id.group));
                    id_pemesanan.requestFocus();
                    hideLoading();
                }
            }
        });
    }


    public void validasiForm(ViewGroup group) {
        for (int i = 0, count = group.getChildCount(); i < count; ++i) {
            View view = group.getChildAt(i);
            if (view instanceof EditText) {
                if(!TextUtils.isEmpty(((EditText)view).getText().toString()))  {
                }  else  {
                    validasi = "gagal";
                    ((EditText)view).setError("Silahkan Input Terlebih Dahulu");
                    ((EditText)view).requestFocus();
                }
            }
            if(view instanceof ViewGroup && (((ViewGroup)view).getChildCount() > 0))
                validasiForm((ViewGroup)view);
        }
    }

    private void clearForm(ViewGroup group) {
        for (int i = 0, count = group.getChildCount(); i < count; ++i) {
            View view = group.getChildAt(i);
            if (view instanceof EditText) {
                ((EditText)view).setText("");
            }
            if(view instanceof ViewGroup && (((ViewGroup)view).getChildCount() > 0))
                clearForm((ViewGroup)view);
        }
    }

    AlertDialog alertDialog;
    public void showLoading(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder
                .setMessage("Menyimpan Data ...")
                .setIcon(R.mipmap.ic_launcher)
                .setCancelable(false);
        alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    public void hideLoading(){
        if (alertDialog != null){
            alertDialog.dismiss();
        }
    }

}






