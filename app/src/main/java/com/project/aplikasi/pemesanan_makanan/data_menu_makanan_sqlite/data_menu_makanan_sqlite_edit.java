package com.project.aplikasi.pemesanan_makanan.data_menu_makanan_sqlite;

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


public class data_menu_makanan_sqlite_edit extends AppCompatActivity {

    String validasi;
    private EditText id_menu_makanan;
    private EditText nama;
    private EditText id_kategori;
    private EditText jumlah;
    private EditText harga;
    private EditText foto;
    private EditText keterangan;

    
    private Button button_editdata;

    private data_menu_makanan_sqlite_dbhandler dbHandler;
    private data_menu_makanan_sqlite_adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data_menu_makanan_edit );
        dbHandler = new data_menu_makanan_sqlite_dbhandler(this);

        button_editdata = (Button) findViewById(R.id.tombol_update);
        id_menu_makanan = (EditText) findViewById(R.id.id_menu_makanan);
        nama = (EditText) findViewById(R.id.nama);
        id_kategori = (EditText) findViewById(R.id.id_kategori);
        jumlah = (EditText) findViewById(R.id.jumlah);
        harga = (EditText) findViewById(R.id.harga);
        foto = (EditText) findViewById(R.id.foto);
        keterangan = (EditText) findViewById(R.id.keterangan);


        Bundle bundle = getIntent().getExtras();
        id_menu_makanan.setText(bundle.getString("id_menu_makanan"));
        nama.setText(bundle.getString("nama"));
        id_kategori.setText(bundle.getString("id_kategori"));
        jumlah.setText(bundle.getString("jumlah"));
        harga.setText(bundle.getString("harga"));
        foto.setText(bundle.getString("foto"));
        keterangan.setText(bundle.getString("keterangan"));


		config_global.init_inputTypes();



        button_editdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showLoading();

                validasi ="berhasil";
                validasiForm((ViewGroup) findViewById(R.id.group));
                if (validasi =="gagal") {
                    Toast.makeText( data_menu_makanan_sqlite_edit.this,  "Gagal Proses, Ada data Yang Masih Kosong dan Perlu diinputkan.",
                            Toast.LENGTH_LONG ).show();
                    hideLoading();
                }  else {
                    //proses simpan
                    dbHandler.update_data_menu_makanan_sqlite( new data_menu_makanan_sqlite_data(
                            id_menu_makanan.getText().toString()
                            ,nama.getText().toString()
                            ,id_kategori.getText().toString()
                            ,jumlah.getText().toString()
                            ,harga.getText().toString()
                            ,foto.getText().toString()
                            ,keterangan.getText().toString()

                    ) );

                    List<data_menu_makanan_sqlite_data> data_menu_makanan_sqliteList = dbHandler.get_semua_data_menu_makanan_sqlite();
                    adapter = new data_menu_makanan_sqlite_adapter( data_menu_makanan_sqlite_edit.this, data_menu_makanan_sqliteList );
                    adapter.notifyDataSetChanged();
                    Toast.makeText( data_menu_makanan_sqlite_edit.this, "Berhasil Mengupdate Data", Toast.LENGTH_SHORT ).show();
                    setResult( RESULT_OK );
                    clearForm((ViewGroup) findViewById(R.id.group));
                    id_menu_makanan.requestFocus();
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






