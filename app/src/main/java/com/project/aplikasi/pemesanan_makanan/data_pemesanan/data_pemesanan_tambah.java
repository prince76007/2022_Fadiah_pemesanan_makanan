package com.project.aplikasi.pemesanan_makanan.data_pemesanan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.project.aplikasi.pemesanan_makanan.R;
import com.project.aplikasi.pemesanan_makanan.config.config_global;
import com.project.aplikasi.pemesanan_makanan.activity.loading;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class data_pemesanan_tambah extends AppCompatActivity {

	String validasi;
    Button tombol_simpan;
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
	loading loading;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView( R.layout.data_pemesanan_tambah );
        tombol_simpan = (Button) findViewById(R.id.tombol_simpan);
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
        mAPIService = data_pemesanan_apiutils.getAPIService();

		config_global.init_inputTypes();


        String token = new config_global().ambil(this);
        tanggal.setVisibility(View.GONE);
        id_pelanggan.setText(token);
        id_pelanggan.setVisibility(View.GONE);
        total_bayar.setVisibility(View.GONE);
        status.setText("pengiriman");
        status.setVisibility(View.GONE);
        persiapan_gps();

        tombol_simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
				
				loading.showDialog(1,"Please Wait","Proses Simpan Data..");
                id_pemesanan.setText( config_global.generate_id(data_pemesanan_tambah.this,"data_pemesanan") );
                validasi ="berhasil";
                //validasiForm((ViewGroup) findViewById(R.id.group));
                if (validasi =="gagal") {
                    loading.hideDialog();
					Toast.makeText( data_pemesanan_tambah.this,  "Gagal Proses, Ada data Yang Masih Kosong dan Perlu diinputkan.",
                            Toast.LENGTH_LONG ).show();
                    
                }  else {
					
				String token = "Bearer " + new config_global().ambil(data_pemesanan_tambah.this);
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
                        Toast.makeText( data_pemesanan_tambah.this, "Berhasil Diproses", Toast.LENGTH_LONG).show();
                        setResult(RESULT_OK);
                        clearForm((ViewGroup) findViewById(R.id.group));
                         id_pemesanan.requestFocus();
                         loading.hideDialog();
                        Bundle bundle = new Bundle();
                        bundle.putString("status", "pengiriman");


                        Intent intent = new Intent(data_pemesanan_tambah.this, data_pemesanan_activity_v2.class);

                        intent.putExtras(bundle);
                        startActivity(intent);
                        finish();
                    }

                    @Override
                    public void onFailure(Call<Object> call, Throwable t) {
                        Toast.makeText( data_pemesanan_tambah.this, "Gagal Disimpan", Toast.LENGTH_LONG).show();
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



    public LocationManager locationManager;
    public LocationListener locationListener = new MyLocationListener();
    private boolean GPS_ENABLE = false;
    private boolean NETWORK_ENABLE = false;
    Geocoder geocoder;
    List<Address> myaddress;

    private void persiapan_gps(){
        locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
        perizinan_gps();
        lokasi_gps();
    }
    private boolean perizinan_gps() {
        int location = ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION);
        int location2 =  ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION);
        List<String> listPermission = new ArrayList<>();
        if(location != PackageManager.PERMISSION_GRANTED || location2 != PackageManager.PERMISSION_GRANTED) {
            listPermission.add(Manifest.permission.ACCESS_FINE_LOCATION);
            listPermission.add(Manifest.permission.ACCESS_FINE_LOCATION);
            //Toast.makeText( data_pemesanan_tambah.this, "Lokasi Gagal Terdeteksi Silahkan Aktifkan Izinkan Lokasi pada aplikasi", Toast.LENGTH_LONG).show();
        }
        else
        {
            loading.showDialog(1,"Loading ","Proses ");
        }
        return true;


    }
    private void lokasi_gps() {
        try {
            GPS_ENABLE = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
        } catch (Exception e) {
        }
        try {
            NETWORK_ENABLE = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
        } catch (Exception e) {
        }
        if (!GPS_ENABLE && !NETWORK_ENABLE) {
            android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(data_pemesanan_tambah. this);
            builder.setTitle("INFORMASI");
            builder.setMessage("Maaf GPS Tidak Aktif");
            builder.create().show();
        }
        if (GPS_ENABLE) {
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

                return;
            }
            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, locationListener);
        }
        if(NETWORK_ENABLE) {
            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, locationListener);
        }
    }
    public class MyLocationListener implements LocationListener {
        @Override
        public void onLocationChanged(Location location) {
            if (location != null){
                locationManager.removeUpdates(locationListener);
                double longitude = location.getLongitude();
                double latitude = location.getLatitude();
                try {
                    myaddress = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1);
                    //String alamat = myaddress.get(0).getAddressLine(0);
                }catch (Exception e) {
                    e.printStackTrace();
                }

                lat.setText(String. valueOf(longitude));
                lng.setText(String. valueOf(latitude));
                loading.hideDialog();
                //Toast.makeText( data_pemesanan_tambah.this, "Lokasi Berhasil Terdeteksi", Toast.LENGTH_LONG).show();

            }
            else
            {
                loading.hideDialog();
            }
        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {
        }

        @Override
        public void onProviderEnabled(String provider) {
        }

        @Override
        public void onProviderDisabled(String provider) {
        }
    }

    
}
