package com.project.aplikasi.pemesanan_makanan.data_menu_makanan;
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

public class data_menu_makanan_edit extends AppCompatActivity {

    String validasi;
	Button tombol_update;
    EditText id_menu_makanan
    ,nama
    ,id_kategori
    ,jumlah
    ,harga
    ,foto
    ,keterangan

            ;
    data_menu_makanan_apiservice mAPIService;
	loading loading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.data_menu_makanan_edit );

        tombol_update = (Button) findViewById(R.id.tombol_update);
		loading = new loading(this);
		
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


        mAPIService = data_menu_makanan_apiutils.getAPIService();
		
		config_global.init_inputTypes();


        tombol_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
				loading.showDialog(1,"Please Wait","Proses Update Data..");
				validasi ="berhasil";
                validasiForm((ViewGroup) findViewById(R.id.group));
                if (validasi =="gagal") {
                    loading.hideDialog();
					Toast.makeText( data_menu_makanan_edit.this,  "Gagal Proses, Ada data Yang Masih Kosong dan Perlu diinputkan.",
                            Toast.LENGTH_LONG ).show();
					
                }  else {
				
				String token = "Bearer " + new config_global().ambil(data_menu_makanan_edit.this);
                mAPIService.proses_update_data_menu_makanan(id_menu_makanan.getText().toString()
				,nama.getText().toString()
				,id_kategori.getText().toString()
				,jumlah.getText().toString()
				,harga.getText().toString()
				,foto.getText().toString()
				,keterangan.getText().toString()

				, token
				).enqueue(new Callback<Object>() {
                    @Override
                    public void onResponse(Call<Object> call, Response<Object> response) {
                        Toast.makeText( data_menu_makanan_edit.this, "Berhasil Diupdate", Toast.LENGTH_LONG).show();
                        setResult(RESULT_OK);
						loading.hideDialog();
                        finish();
                    }

                    @Override
                    public void onFailure(Call<Object> call, Throwable t) {
                        Toast.makeText( data_menu_makanan_edit.this, "Gagal Diupdate", Toast.LENGTH_LONG).show();
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
