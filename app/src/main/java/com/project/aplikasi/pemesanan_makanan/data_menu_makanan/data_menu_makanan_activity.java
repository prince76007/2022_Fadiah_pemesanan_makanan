package com.project.aplikasi.pemesanan_makanan.data_menu_makanan;

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

public class data_menu_makanan_activity extends AppCompatActivity {

    ArrayList<data_menu_makanan_apidata> result = new ArrayList<>();
    data_menu_makanan_adapter adapter;
    ListView data_menu_makanan_tampil;
    data_menu_makanan_apiservice mAPIService;
    Button tombol_tambah,tombol_refresh ;
    protected int REQUEST_CODE_TAMBAH = 3543;
	loading loading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.data_menu_makanan_activity );

        data_menu_makanan_tampil = (ListView) findViewById(R.id.data_menu_makanan_tampil);
        tombol_tambah = (Button) findViewById(R.id.tombol_tambah);
		tombol_refresh = (Button) findViewById(R.id.tombol_refresh);
		loading = new loading(this);

        adapter = new data_menu_makanan_adapter(this, result);
        data_menu_makanan_tampil.setAdapter(adapter);
        data_menu_makanan_tampil.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });

        mAPIService = data_menu_makanan_apiutils.getAPIService();
        fetch_data_menu_makanan();

        tombol_tambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( data_menu_makanan_activity.this, data_menu_makanan_tambah.class);
                startActivityForResult(intent, REQUEST_CODE_TAMBAH);
            }
        });
		
		tombol_refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fetch_data_menu_makanan();
				 Toast.makeText(data_menu_makanan_activity.this, "Data Berhasil Diperbarui",
                            Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_TAMBAH){
            if (resultCode == RESULT_OK){
                fetch_data_menu_makanan();
            }
        }

    }

    public void fetch_data_menu_makanan(){
		loading.showDialog(1,"Please Wait","Loading Data..");
		String token = new config_global().ambil(this);
        mAPIService.tampil_data_menu_makanan("", "", "","","","", "Bearer "+token
        ).enqueue(new Callback<data_menu_makanan_api>() {
            @Override
            public void onResponse(Call<data_menu_makanan_api> call, Response<data_menu_makanan_api> response) {
				loading.hideDialog();
                data_menu_makanan_api response_data = response.body();
                Log.d("data", response_data.toString());
                adapter.updateResults(response_data.get_data_menu_makanan());
            }

            @Override
            public void onFailure(Call<data_menu_makanan_api> call, Throwable t) {
				loading.hideDialog();
            }
        });
    }
}
