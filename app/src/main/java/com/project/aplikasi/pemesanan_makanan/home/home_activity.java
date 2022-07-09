package com.project.aplikasi.pemesanan_makanan.home;

import android.content.Intent;
import android.os.Bundle;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;
import com.project.aplikasi.pemesanan_makanan.R;
import com.project.aplikasi.pemesanan_makanan.activity.login_activity;
import com.project.aplikasi.pemesanan_makanan.activity.webview_activity;
import com.project.aplikasi.pemesanan_makanan.config.config_sessionmanager;
import com.project.aplikasi.pemesanan_makanan.data_admin.data_admin_activity_v2;
import com.project.aplikasi.pemesanan_makanan.data_menu_makanan.data_menu_makanan_activity_v2;
import com.project.aplikasi.pemesanan_makanan.data_pelanggan.data_pelanggan_activity_v2;
import com.project.aplikasi.pemesanan_makanan.data_pemesanan.data_pemesanan_activity_v2;

import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.view.View;

import static com.project.aplikasi.pemesanan_makanan.config.config_global.BASE_URL;

public class home_activity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.home_activity );
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        mAppBarConfiguration = new AppBarConfiguration.Builder(R.id.nav_home

        )
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
	
	 public void open_webview(String url, String judul, String deskripsi)
    {
        Intent intent = new Intent(home_activity.this, webview_activity.class);
        intent.putExtra("url", url);
        intent.putExtra("judul", judul);
        intent.putExtra("deskripsi", deskripsi);
        startActivity(intent);
    }

    public void id_tombol_1(View view) {
        Intent intent = new Intent(home_activity.this, data_menu_makanan_activity_v2.class);
        startActivity(intent);
    }

    public void id_tombol_2(View view) {
        Intent intent = new Intent(home_activity.this, data_pemesanan_activity_v2.class);
        config_sessionmanager config_sessionmanager;
        config_sessionmanager = new config_sessionmanager(home_activity.this);
        String id_pelanggan = config_sessionmanager.getSPId();

        intent.putExtra("id_pelanggan", id_pelanggan);
        intent.putExtra("status", "pengiriman");
        startActivity(intent);
    }

    public void id_tombol_3(View view) {



        Intent intent = new Intent(home_activity.this, data_pemesanan_activity_v2.class);
        config_sessionmanager config_sessionmanager;
        config_sessionmanager = new config_sessionmanager(home_activity.this);
        String id_pelanggan = config_sessionmanager.getSPId();

        if (id_pelanggan.equals("admin"))
        {
            intent.putExtra("id_pelanggan", id_pelanggan);
            intent.putExtra("status", "pengiriman");
            startActivity(intent);
        }
        else
        {
            intent.putExtra("id_pelanggan", id_pelanggan);
            intent.putExtra("status", "selesai");
            startActivity(intent);
        }

    }

    public void id_tombol_4(View view) {


        config_sessionmanager config_sessionmanager;
        config_sessionmanager = new config_sessionmanager(home_activity.this);
        String id_pelanggan = config_sessionmanager.getSPId();

        if (id_pelanggan.equals("admin"))
        {
            Intent intent = new Intent(home_activity.this, data_admin_activity_v2.class);
            intent.putExtra("id_pelanggan", id_pelanggan);
            startActivity(intent);
        }
        else
        {
            Intent intent = new Intent(home_activity.this, data_pelanggan_activity_v2.class);
            intent.putExtra("id_pelanggan", id_pelanggan);
            startActivity(intent);
        }

    }

    public void id_tombol_5(View view) {
        open_webview(BASE_URL + "/frame/app/page/panduan.php","","");
    }

    public void id_tombol_6(View view) {
        Intent intent = new Intent(home_activity.this, login_activity.class);
        startActivity(intent);
    }

    public void id_tombol_profil(View view) {

    }


}
