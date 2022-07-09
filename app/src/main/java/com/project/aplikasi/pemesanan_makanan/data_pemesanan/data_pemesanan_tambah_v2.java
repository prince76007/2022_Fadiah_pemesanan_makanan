package com.project.aplikasi.pemesanan_makanan.data_pemesanan;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import com.project.aplikasi.pemesanan_makanan.R;
import com.project.aplikasi.pemesanan_makanan.config.config_global;
import com.project.aplikasi.pemesanan_makanan.activity.loading;
import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class data_pemesanan_tambah_v2 extends AppCompatActivity {

	String validasi;
    Button tombol_simpan, tombol_tambah;
    data_pemesanan_apiservice mAPIService;
    EditText id_pemesanan
    ,tanggal
    ,id_pelanggan
    ,total_bayar
    ,lat
    ,lng
    ,alamat_pengiriman
    ,status
;

    data_pemesanan_tambah_v2_adapter adapter;
    ListView data_pemesanan_tampil;
	loading loading;

    ArrayList<data_pemesanan_apidata> result = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.data_pemesanan_tambah_v2 );
        tombol_simpan = (Button) findViewById(R.id.tombol_simpan);
        tombol_tambah = (Button) findViewById(R.id.btnTambah);
		loading = new loading(this);
		
        id_pemesanan = (EditText) findViewById(R.id.id_pemesanan);
        tanggal = (EditText) findViewById(R.id.tanggal);
        id_pelanggan = (EditText) findViewById(R.id.id_pelanggan);
        total_bayar = (EditText) findViewById(R.id.total_bayar);
        lat = (EditText) findViewById(R.id.lat);
        lng = (EditText) findViewById(R.id.lng);
        alamat_pengiriman = (EditText) findViewById(R.id.alamat_pengiriman);
        status = (EditText) findViewById(R.id.status);


		id_pemesanan.setText( config_global.generate_id(this,"data_pemesanan") );
		
        data_pemesanan_tampil = (ListView) findViewById(R.id.cvdata_pemesanan);

        adapter = new data_pemesanan_tambah_v2_adapter(this, result);
        data_pemesanan_tampil.setAdapter(adapter);

        mAPIService = data_pemesanan_apiutils.getAPIService();
		
		config_global.init_inputTypes();


        tombol_tambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
				loading.showDialog(1,"Please Wait","Proses Simpan Data..");
				id_pemesanan.setText( config_global.generate_id(data_pemesanan_tambah_v2.this,"data_pemesanan") );
				validasi ="berhasil";
                validasiForm((ViewGroup) findViewById(R.id.group));
                if (validasi =="gagal") {
                    loading.hideDialog();
					Toast.makeText( data_pemesanan_tambah_v2.this,  "Gagal Proses, Ada data Yang Masih Kosong dan Perlu diinputkan.",
                            Toast.LENGTH_LONG ).show();
					
                }  else {
					String token = "Bearer " + new config_global().ambil(data_pemesanan_tambah_v2.this);
					mAPIService.proses_simpan_data_pemesanan(id_pemesanan.getText().toString()
							,tanggal.getText().toString()
							,id_pelanggan.getText().toString()
							,total_bayar.getText().toString()
							,lat.getText().toString()
							,lng.getText().toString()
							,alamat_pengiriman.getText().toString()
							,status.getText().toString()

							,token
					).enqueue(new Callback<Object>() {
						@Override
						public void onResponse(Call<Object> call, Response<Object> response) {
							Toast.makeText( data_pemesanan_tambah_v2.this, "Berhasil Disimpan",
									Toast.LENGTH_LONG).show();
							result.add(new data_pemesanan_apidata(
									id_pemesanan.getText().toString()
									,tanggal.getText().toString()
									,id_pelanggan.getText().toString()
									,total_bayar.getText().toString()
									,lat.getText().toString()
									,lng.getText().toString()
									,alamat_pengiriman.getText().toString()
									,status.getText().toString()

							));
							adapter.updateResults(result);
							clearForm((ViewGroup) findViewById(R.id.group));
							id_pemesanan.requestFocus();
							loading.hideDialog();
						}
	
						@Override
						public void onFailure(Call<Object> call, Throwable t) {
							Toast.makeText( data_pemesanan_tambah_v2.this, "Gagal Disimpan",
									Toast.LENGTH_LONG).show();
									loading.hideDialog();
						}
					});
				}
            }
        });


        tombol_simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                setResult(RESULT_OK);
                finish();



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
	
	
	
}
