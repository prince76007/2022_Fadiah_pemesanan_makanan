package com.project.aplikasi.pemesanan_makanan.data_pelanggan;
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

public class data_pelanggan_edit extends AppCompatActivity {

    String validasi;
	Button tombol_update;
    EditText id_pelanggan
    ,nama
    ,alamat
    ,no_telepon
    ,username
    ,password

            ;
    data_pelanggan_apiservice mAPIService;
	loading loading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.data_pelanggan_edit );

        tombol_update = (Button) findViewById(R.id.tombol_update);
		loading = new loading(this);
		
        id_pelanggan = (EditText) findViewById(R.id.id_pelanggan);
        nama = (EditText) findViewById(R.id.nama);
        alamat = (EditText) findViewById(R.id.alamat);
        no_telepon = (EditText) findViewById(R.id.no_telepon);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);


        Bundle bundle = getIntent().getExtras();

        id_pelanggan.setText(bundle.getString("id_pelanggan"));
        nama.setText(bundle.getString("nama"));
        alamat.setText(bundle.getString("alamat"));
        no_telepon.setText(bundle.getString("no_telepon"));
        username.setText(bundle.getString("username"));
        //password.setText(bundle.getString("password"));


        mAPIService = data_pelanggan_apiutils.getAPIService();
		
		config_global.init_inputTypes();


        tombol_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
				loading.showDialog(1,"Please Wait","Proses Update Data..");
				validasi ="berhasil";
                validasiForm((ViewGroup) findViewById(R.id.group));
                if (validasi =="gagal") {
                    loading.hideDialog();
					Toast.makeText( data_pelanggan_edit.this,  "Gagal Proses, Ada data Yang Masih Kosong dan Perlu diinputkan.",
                            Toast.LENGTH_LONG ).show();
					
                }  else {
				
				String token = "Bearer " + new config_global().ambil(data_pelanggan_edit.this);
                mAPIService.proses_update_data_pelanggan(id_pelanggan.getText().toString()
				,nama.getText().toString()
				,alamat.getText().toString()
				,no_telepon.getText().toString()
				,username.getText().toString()
				,password.getText().toString()

				, token
				).enqueue(new Callback<Object>() {
                    @Override
                    public void onResponse(Call<Object> call, Response<Object> response) {
                        Toast.makeText( data_pelanggan_edit.this, "Berhasil Diupdate", Toast.LENGTH_LONG).show();
                        setResult(RESULT_OK);
						loading.hideDialog();
                        finish();
                    }

                    @Override
                    public void onFailure(Call<Object> call, Throwable t) {
                        Toast.makeText( data_pelanggan_edit.this, "Gagal Diupdate", Toast.LENGTH_LONG).show();
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
