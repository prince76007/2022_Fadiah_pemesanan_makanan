package com.project.aplikasi.pemesanan_makanan.data_pemesanan;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

import com.project.aplikasi.pemesanan_makanan.R;
import com.project.aplikasi.pemesanan_makanan.config.config_global;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class data_pemesanan_adapter extends BaseAdapter {

    Activity activity;
    ArrayList<data_pemesanan_apidata> data;
    TextView id_pemesanan
                 ,tanggal
                 ,id_pelanggan
                 ,total_bayar
                 ,lat
                 ,lng
                 ,alamat_pengiriman
                 ,status

            ;
    Button tombol_edit, tombol_hapus;
    protected int REQUEST_CODE_TAMBAH = 3543;

    public data_pemesanan_adapter(Activity activity, ArrayList<data_pemesanan_apidata> data) {
        this.activity = activity;
        this.data = data;
    }

    @Override
    public int getCount() {
        if (data == null){
            return 0;
        }
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View v = convertView;

        if (v == null) {
            LayoutInflater vi;
            vi = LayoutInflater.from(activity);
            v = vi.inflate( R.layout.data_pemesanan_tampil, null);
        }

        Object p = getItem(position);

        if (p != null) {

            id_pemesanan = (TextView) v.findViewById(R.id.id_pemesanan);
            tanggal = (TextView) v.findViewById(R.id.tanggal);
            id_pelanggan = (TextView) v.findViewById(R.id.id_pelanggan);
            total_bayar = (TextView) v.findViewById(R.id.total_bayar);
            lat = (TextView) v.findViewById(R.id.lat);
            lng = (TextView) v.findViewById(R.id.lng);
            alamat_pengiriman = (TextView) v.findViewById(R.id.alamat_pengiriman);
            status = (TextView) v.findViewById(R.id.status);


            tombol_edit = (Button) v.findViewById(R.id.tombol_edit);
            tombol_hapus = (Button) v.findViewById(R.id.tombol_hapus);

            tombol_edit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Bundle bundle = new Bundle();

                    bundle.putString("", data.get(position).get_id_pemesanan());
                    bundle.putString("tanggal", data.get(position).get_tanggal());
                    bundle.putString("id_pelanggan", data.get(position).get_id_pelanggan());
                    bundle.putString("total_bayar", data.get(position).get_total_bayar());
                    bundle.putString("lat", data.get(position).get_lat());
                    bundle.putString("lng", data.get(position).get_lng());
                    bundle.putString("alamat_pengiriman", data.get(position).get_alamat_pengiriman());
                    bundle.putString("status", data.get(position).get_status());

                    
                    Intent intent = new Intent(activity, data_pemesanan_edit.class);
                    intent.putExtras(bundle);
                    activity.startActivityForResult(intent, REQUEST_CODE_TAMBAH);
                }
            });

            tombol_hapus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
					
					
					AlertDialog.Builder BackAlertDialog = new AlertDialog.Builder(activity);
                    BackAlertDialog.setTitle("Proses Hapus");
                    BackAlertDialog.setMessage("Apakah Anda ingin Menghapus Data?");
                    BackAlertDialog.setPositiveButton("Ya",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    //Proses Hapus
                                    String token = "Bearer " + new config_global().ambil(activity);
									data_pemesanan_apiservice mAPIService = 
									data_pemesanan_apiutils.getAPIService();
									mAPIService.proses_hapus_data_pemesanan(
											data.get(position).get_id_pemesanan(),
											token
									).enqueue(new Callback<Object>() {			  
										@Override
										public void onResponse(Call<Object> call, Response<Object> response) {
											((data_pemesanan_activity)activity).fetch_data_pemesanan();
										}
				
										@Override
										public void onFailure(Call<Object> call, Throwable t) {
											Toast.makeText(activity, "Gagal", Toast.LENGTH_LONG).show();
										}
									});

                                }
                            });

                    BackAlertDialog.setNegativeButton("Tidak",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    //Batal Hapus
                                    dialog.cancel();
                                }
                            });
                    BackAlertDialog.show();
					
                }
            });

            id_pemesanan.setText("id_pemesanan "+data.get(position).get_id_pemesanan());
            tanggal.setText("tanggal "+data.get(position).get_tanggal());
            id_pelanggan.setText("id_pelanggan "+data.get(position).get_id_pelanggan());
            total_bayar.setText("total_bayar "+data.get(position).get_total_bayar());
            lat.setText("lat "+data.get(position).get_lat());
            lng.setText("lng "+data.get(position).get_lng());
            alamat_pengiriman.setText("alamat_pengiriman "+data.get(position).get_alamat_pengiriman());
            status.setText("status "+data.get(position).get_status());


        }

        return v;
    }

    public void updateResults(ArrayList<data_pemesanan_apidata> result) {
        data = result;
        notifyDataSetChanged();
    }
}
