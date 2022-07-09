package com.project.aplikasi.pemesanan_makanan.data_kategori;

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

public class data_kategori_activity extends AppCompatActivity {

    ArrayList<data_kategori_apidata> result = new ArrayList<>();
    data_kategori_adapter adapter;
    ListView data_kategori_tampil;
    data_kategori_apiservice mAPIService;
    Button tombol_tambah,tombol_refresh ;
    protected int REQUEST_CODE_TAMBAH = 3543;
	loading loading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.data_kategori_activity );

        data_kategori_tampil = (ListView) findViewById(R.id.data_kategori_tampil);
        tombol_tambah = (Button) findViewById(R.id.tombol_tambah);
		tombol_refresh = (Button) findViewById(R.id.tombol_refresh);
		loading = new loading(this);

        adapter = new data_kategori_adapter(this, result);
        data_kategori_tampil.setAdapter(adapter);
        data_kategori_tampil.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });

        mAPIService = data_kategori_apiutils.getAPIService();
        fetch_data_kategori();

        tombol_tambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( data_kategori_activity.this, data_kategori_tambah.class);
                startActivityForResult(intent, REQUEST_CODE_TAMBAH);
            }
        });
		
		tombol_refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fetch_data_kategori();
				 Toast.makeText(data_kategori_activity.this, "Data Berhasil Diperbarui",
                            Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_TAMBAH){
            if (resultCode == RESULT_OK){
                fetch_data_kategori();
            }
        }

    }

    public void fetch_data_kategori(){
		loading.showDialog(1,"Please Wait","Loading Data..");
		String token = new config_global().ambil(this);
        mAPIService.tampil_data_kategori("", "", "","","","", "Bearer "+token
        ).enqueue(new Callback<data_kategori_api>() {
            @Override
            public void onResponse(Call<data_kategori_api> call, Response<data_kategori_api> response) {
				loading.hideDialog();
                data_kategori_api response_data = response.body();
                Log.d("data", response_data.toString());
                adapter.updateResults(response_data.get_data_kategori());
            }

            @Override
            public void onFailure(Call<data_kategori_api> call, Throwable t) {
				loading.hideDialog();
            }
        });
    }
}
