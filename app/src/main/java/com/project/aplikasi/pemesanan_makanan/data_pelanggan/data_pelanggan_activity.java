package com.project.aplikasi.pemesanan_makanan.data_pelanggan;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.project.aplikasi.pemesanan_makanan.R;
import com.project.aplikasi.pemesanan_makanan.config.config_global;
import com.project.aplikasi.pemesanan_makanan.activity.loading;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class data_pelanggan_activity extends AppCompatActivity {

    ArrayList<data_pelanggan_apidata> result = new ArrayList<>();
    data_pelanggan_adapter adapter;
    ListView data_pelanggan_tampil;
    data_pelanggan_apiservice mAPIService;
    Button tombol_tambah,tombol_refresh ;
    protected int REQUEST_CODE_TAMBAH = 3543;
	loading loading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.data_pelanggan_activity );

        data_pelanggan_tampil = (ListView) findViewById(R.id.data_pelanggan_tampil);
        tombol_tambah = (Button) findViewById(R.id.tombol_tambah);
		tombol_refresh = (Button) findViewById(R.id.tombol_refresh);
		loading = new loading(this);

        adapter = new data_pelanggan_adapter(this, result);
        data_pelanggan_tampil.setAdapter(adapter);
        data_pelanggan_tampil.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });

        mAPIService = data_pelanggan_apiutils.getAPIService();
        fetch_data_pelanggan();

        tombol_tambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( data_pelanggan_activity.this, data_pelanggan_tambah.class);
                startActivityForResult(intent, REQUEST_CODE_TAMBAH);
            }
        });
		
		tombol_refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fetch_data_pelanggan();
				 Toast.makeText(data_pelanggan_activity.this, "Data Berhasil Diperbarui",
                            Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_TAMBAH){
            if (resultCode == RESULT_OK){
                fetch_data_pelanggan();
            }
        }

    }

    public void fetch_data_pelanggan(){
		loading.showDialog(1,"Please Wait","Loading Data..");
		String token = new config_global().ambil(this);
        mAPIService.tampil_data_pelanggan("", "", "","","","", "Bearer "+token
        ).enqueue(new Callback<data_pelanggan_api>() {
            @Override
            public void onResponse(Call<data_pelanggan_api> call, Response<data_pelanggan_api> response) {
				loading.hideDialog();
                data_pelanggan_api response_data = response.body();
                Log.d("data", response_data.toString());
                adapter.updateResults(response_data.get_data_pelanggan());
            }

            @Override
            public void onFailure(Call<data_pelanggan_api> call, Throwable t) {
				loading.hideDialog();
            }
        });
    }
}
