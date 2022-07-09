package com.project.aplikasi.pemesanan_makanan.data_detail_pemesanan;

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

public class data_detail_pemesanan_activity extends AppCompatActivity {

    ArrayList<data_detail_pemesanan_apidata> result = new ArrayList<>();
    data_detail_pemesanan_adapter adapter;
    ListView data_detail_pemesanan_tampil;
    data_detail_pemesanan_apiservice mAPIService;
    Button tombol_tambah,tombol_refresh ;
    protected int REQUEST_CODE_TAMBAH = 3543;
	loading loading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.data_detail_pemesanan_activity );

        data_detail_pemesanan_tampil = (ListView) findViewById(R.id.data_detail_pemesanan_tampil);
        tombol_tambah = (Button) findViewById(R.id.tombol_tambah);
		tombol_refresh = (Button) findViewById(R.id.tombol_refresh);
		loading = new loading(this);

        adapter = new data_detail_pemesanan_adapter(this, result);
        data_detail_pemesanan_tampil.setAdapter(adapter);
        data_detail_pemesanan_tampil.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });

        mAPIService = data_detail_pemesanan_apiutils.getAPIService();
        fetch_data_detail_pemesanan();

        tombol_tambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( data_detail_pemesanan_activity.this, data_detail_pemesanan_tambah.class);
                startActivityForResult(intent, REQUEST_CODE_TAMBAH);
            }
        });
		
		tombol_refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fetch_data_detail_pemesanan();
				 Toast.makeText(data_detail_pemesanan_activity.this, "Data Berhasil Diperbarui",
                            Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_TAMBAH){
            if (resultCode == RESULT_OK){
                fetch_data_detail_pemesanan();
            }
        }

    }

    public void fetch_data_detail_pemesanan(){
		loading.showDialog(1,"Please Wait","Loading Data..");
		String token = new config_global().ambil(this);
        mAPIService.tampil_data_detail_pemesanan("", "", "","","","", "Bearer "+token
        ).enqueue(new Callback<data_detail_pemesanan_api>() {
            @Override
            public void onResponse(Call<data_detail_pemesanan_api> call, Response<data_detail_pemesanan_api> response) {
				loading.hideDialog();
                data_detail_pemesanan_api response_data = response.body();
                Log.d("data", response_data.toString());
                adapter.updateResults(response_data.get_data_detail_pemesanan());
            }

            @Override
            public void onFailure(Call<data_detail_pemesanan_api> call, Throwable t) {
				loading.hideDialog();
            }
        });
    }
}
