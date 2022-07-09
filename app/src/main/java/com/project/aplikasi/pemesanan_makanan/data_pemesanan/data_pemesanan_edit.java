package com.project.aplikasi.pemesanan_makanan.data_pemesanan;
import androidx.appcompat.app.AppCompatActivity;
import android.text.TextUtils;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.project.aplikasi.pemesanan_makanan.R;
import com.project.aplikasi.pemesanan_makanan.config.config_global;
import com.project.aplikasi.pemesanan_makanan.activity.loading;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class data_pemesanan_edit extends AppCompatActivity {

    String validasi;
	Button tombol_update;
    EditText id_pemesanan
    ,tanggal
    ,id_pelanggan
    ,total_bayar
    ,lat
    ,lng
    ,alamat_pengiriman
    ,status

            ;
    data_pemesanan_apiservice mAPIService;
	loading loading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.data_pemesanan_edit );

        tombol_update = (Button) findViewById(R.id.tombol_update);
		loading = new loading(this);
		
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
        tanggal.setVisibility(View.GONE);
        id_pelanggan.setText(bundle.getString("id_pelanggan"));
        id_pelanggan.setVisibility(View.GONE);
        total_bayar.setText(bundle.getString("total_bayar"));
        total_bayar.setVisibility(View.GONE);
        lat.setText(bundle.getString("lat"));
        lat.setVisibility(View.GONE);
        lng.setText(bundle.getString("lng"));
        lng.setVisibility(View.GONE);
        alamat_pengiriman.setText(bundle.getString("alamat_pengiriman"));
        alamat_pengiriman.setVisibility(View.GONE);
        status.setText("Pesanan Telah diterima");
        //status.setEnabled(false);

        mAPIService = data_pemesanan_apiutils.getAPIService();
		
		config_global.init_inputTypes();


        tombol_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
				loading.showDialog(1,"Please Wait","Proses Update Data..");
				validasi ="berhasil";
                //validasiForm((ViewGroup) findViewById(R.id.group));
                if (validasi =="gagal") {
                    loading.hideDialog();
					Toast.makeText( data_pemesanan_edit.this,  "Gagal Proses, Ada data Yang Masih Kosong dan Perlu diinputkan.",
                            Toast.LENGTH_LONG ).show();
					
                }  else {
				
				String token = "Bearer " + new config_global().ambil(data_pemesanan_edit.this);
                mAPIService.proses_update_data_pemesanan(id_pemesanan.getText().toString()
				,tanggal.getText().toString()
				,id_pelanggan.getText().toString()
				,total_bayar.getText().toString()
				,lat.getText().toString()
				,lng.getText().toString()
				,alamat_pengiriman.getText().toString()
				,status.getText().toString()

				, token
				).enqueue(new Callback<Object>() {
                    @Override
                    public void onResponse(Call<Object> call, Response<Object> response) {
                        Toast.makeText( data_pemesanan_edit.this, "Berhasil diproses", Toast.LENGTH_LONG).show();
                        setResult(RESULT_OK);
						loading.hideDialog();
                        finish();
                    }

                    @Override
                    public void onFailure(Call<Object> call, Throwable t) {
                        Toast.makeText( data_pemesanan_edit.this, "Gagal Diupdate", Toast.LENGTH_LONG).show();
						loading.hideDialog();
                    }
                });
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
                }
			  }
                if(view instanceof ViewGroup && (((ViewGroup)view).getChildCount() > 0))
                    validasiForm((ViewGroup)view);
            }
    }
	
}
