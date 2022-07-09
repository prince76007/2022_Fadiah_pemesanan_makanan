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


public class data_pemesanan_sqlite_edit extends AppCompatActivity {

    String validasi;
    private EditText id_pemesanan;
    private EditText tanggal;
    private EditText id_pelanggan;
    private EditText total_bayar;
    private EditText lat;
    private EditText lng;
    private EditText alamat_pengiriman;
    private EditText status;

    
    private Button button_editdata;

    private data_pemesanan_sqlite_dbhandler dbHandler;
    private data_pemesanan_sqlite_adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data_pemesanan_edit );
        dbHandler = new data_pemesanan_sqlite_dbhandler(this);

        button_editdata = (Button) findViewById(R.id.tombol_update);
        id_pemesanan = (EditText) findViewById(R.id.id_pemesanan);
        tanggal = (EditText) findViewById(R.id.tanggal);
        id_pelanggan = (EditText) findViewById(R.id.id_pelanggan);
        total_bayar = (EditText) findViewById(R.id.total_bayar);
        lat = (EditText) findViewById(R.id.lat);
        lng = (EditText) findViewById(R.id.lng);
        alamat_pengiriman = (EditText) findViewById(R.id.alamat_pengiriman);
        status = (EditText) findViewById(R.id.status);


        Bundle bundle = getIntent().getExtras();
        id_pemesanan.setText(bundle.getString("id_pemesanan"));
        tanggal.setText(bundle.getString("tanggal"));
        id_pelanggan.setText(bundle.getString("id_pelanggan"));
        total_bayar.setText(bundle.getString("total_bayar"));
        lat.setText(bundle.getString("lat"));
        lng.setText(bundle.getString("lng"));
        alamat_pengiriman.setText(bundle.getString("alamat_pengiriman"));
        status.setText(bundle.getString("status"));


		config_global.init_inputTypes();



        button_editdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showLoading();

                validasi ="berhasil";
                validasiForm((ViewGroup) findViewById(R.id.group));
                if (validasi =="gagal") {
                    Toast.makeText( data_pemesanan_sqlite_edit.this,  "Gagal Proses, Ada data Yang Masih Kosong dan Perlu diinputkan.",
                            Toast.LENGTH_LONG ).show();
                    hideLoading();
                }  else {
                    //proses simpan
                    dbHandler.update_data_pemesanan_sqlite( new data_pemesanan_sqlite_data(
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
                    adapter = new data_pemesanan_sqlite_adapter( data_pemesanan_sqlite_edit.this, data_pemesanan_sqliteList );
                    adapter.notifyDataSetChanged();
                    Toast.makeText( data_pemesanan_sqlite_edit.this, "Berhasil Mengupdate Data", Toast.LENGTH_SHORT ).show();
                    setResult( RESULT_OK );
                    clearForm((ViewGroup) findViewById(R.id.group));
                    id_pemesanan.requestFocus();
                    hideLoading();
                    finish();
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
                .setMessage("Mengupdate Data ...")
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






