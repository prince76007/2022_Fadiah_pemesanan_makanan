package com.project.aplikasi.pemesanan_makanan.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.project.aplikasi.pemesanan_makanan.R;
import com.project.aplikasi.pemesanan_makanan.config.config_sessionmanager;
import com.project.aplikasi.pemesanan_makanan.data_pelanggan.data_pelanggan_tambah;
import com.project.aplikasi.pemesanan_makanan.home.home_activity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.project.aplikasi.pemesanan_makanan.config.config_global.BASE_URL;

public class login_activity extends AppCompatActivity {
    config_sessionmanager config_sessionmanager;
    login_apiservice mAPIService;
    AutoCompleteTextView username;
    EditText password;
	loading loading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        config_sessionmanager = new config_sessionmanager(this);
        config_sessionmanager.saveSPBoolean(config_sessionmanager.SP_SUDAH_LOGIN, false);
        mAPIService = login_apiutils.getAPIService();

        username = (AutoCompleteTextView) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);

        // logout (delete data session manager)
        new config_sessionmanager(this).logOut();
		loading = new loading(this);
    }
	

    public void login(View view) {
		loading.showDialog(1,"Please Wait","Loading..");
        mAPIService.login_pegawai(username.getText().toString(), password.getText().toString()).enqueue(new Callback<login_pegawai_api>() {
            @Override
            public void onResponse(Call<login_pegawai_api> call, Response<login_pegawai_api> response) {
                if (response.code() == 200){
					loading.hideDialog();
                    login_pegawai_api res = response.body();
                    try {
                        if (res.getStatus().equals("success")){
                            Toast.makeText(login_activity.this, "Login Berhasil", Toast.LENGTH_SHORT).show();
                            config_sessionmanager.saveSPString(config_sessionmanager.SP_TOKEN,
                                    res.getResult().get_tkn());

                            config_sessionmanager.saveSPString(config_sessionmanager.SP_ID,
                                    res.getResult().get_tkn());

                            config_sessionmanager.saveSPString(com.project.aplikasi.pemesanan_makanan.config.config_sessionmanager.SP_NAMA, res.getResult().get_nama_pegawai());
                            config_sessionmanager.saveSPBoolean(config_sessionmanager.SP_SUDAH_LOGIN, true);
                            
                            Intent intent = new Intent(login_activity.this, home_activity.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            startActivity(intent);
                            
                        } else {
                            Toast.makeText(login_activity.this, "Login Gagal", Toast.LENGTH_SHORT).show();
                        }
                    } catch (NullPointerException ex){
                        Toast.makeText(login_activity.this, "Login Gagal", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Log.d("login_res", call.toString()+" - "+response.body().toString());
                    Toast.makeText(login_activity.this, "Koneksi Error", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<login_pegawai_api> call, Throwable t) {
				loading.hideDialog();
                Log.d("login_res", call.toString()+" - "+t.toString());
                Toast.makeText(login_activity.this, "Koneksi Error", Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void batal(View view) {


        Intent intent = new Intent(login_activity.this, data_pelanggan_tambah.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);

    }
    
     @Override
    public void onBackPressed() {
        finish();
    }


    public void reset(View view) {

        Intent intent = new Intent(login_activity.this, webview_activity.class);
        intent.putExtra("url", BASE_URL + "/frame/app/page/lupapassword.php");
        intent.putExtra("judul", "Reset Password");
        intent.putExtra("deskripsi", "Silahkan Masukkan Email Anda");
        startActivity(intent);
    }
}
