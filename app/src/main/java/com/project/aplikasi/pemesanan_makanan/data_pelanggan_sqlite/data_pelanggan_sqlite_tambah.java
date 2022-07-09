package com.project.aplikasi.pemesanan_makanan.data_pelanggan_sqlite;

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


public class data_pelanggan_sqlite_tambah extends AppCompatActivity {

    String validasi;
    private EditText id_pelanggan;
    private EditText nama;
    private EditText alamat;
    private EditText no_telepon;
    private EditText username;
    private EditText password;

    
    private Button button_tambahdata;

    private data_pelanggan_sqlite_dbhandler dbHandler;
    private data_pelanggan_sqlite_adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data_pelanggan_tambah );
        dbHandler = new data_pelanggan_sqlite_dbhandler(this);

        button_tambahdata = (Button) findViewById(R.id.tombol_simpan);
        id_pelanggan = (EditText) findViewById(R.id.id_pelanggan);
        nama = (EditText) findViewById(R.id.nama);
        alamat = (EditText) findViewById(R.id.alamat);
        no_telepon = (EditText) findViewById(R.id.no_telepon);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);


        id_pelanggan.setText( config_global.generate_id( data_pelanggan_sqlite_tambah.this,"data_pelanggan") );
		
		config_global.init_inputTypes();


        button_tambahdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showLoading();
                id_pelanggan.setText( config_global.generate_id( data_pelanggan_sqlite_tambah.this,"data_pelanggan") );
                validasi ="berhasil";
                validasiForm((ViewGroup) findViewById(R.id.group));
                if (validasi =="gagal") {
                    Toast.makeText( data_pelanggan_sqlite_tambah.this,  "Gagal Proses, Ada data Yang Masih Kosong dan Perlu diinputkan.",
                            Toast.LENGTH_LONG ).show();
                    hideLoading();
                }  else {
                    //proses simpan
                    dbHandler.tambah_data_pelanggan_sqlite( new data_pelanggan_sqlite_data(
                            id_pelanggan.getText().toString()
                            ,nama.getText().toString()
                            ,alamat.getText().toString()
                            ,no_telepon.getText().toString()
                            ,username.getText().toString()
                            ,password.getText().toString()

                    ) );

                    List<data_pelanggan_sqlite_data> data_pelanggan_sqliteList = dbHandler.get_semua_data_pelanggan_sqlite();
                    adapter = new data_pelanggan_sqlite_adapter( data_pelanggan_sqlite_tambah.this, data_pelanggan_sqliteList );
                    adapter.notifyDataSetChanged();
                    Toast.makeText( data_pelanggan_sqlite_tambah.this, "Berhasil Menambahkan Data", Toast.LENGTH_SHORT ).show();
                    setResult( RESULT_OK );
                    clearForm((ViewGroup) findViewById(R.id.group));
                    id_pelanggan.requestFocus();
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






