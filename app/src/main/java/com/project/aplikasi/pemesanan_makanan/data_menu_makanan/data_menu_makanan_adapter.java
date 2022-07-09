package com.project.aplikasi.pemesanan_makanan.data_menu_makanan;

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


public class data_menu_makanan_adapter extends BaseAdapter {

    Activity activity;
    ArrayList<data_menu_makanan_apidata> data;
    TextView id_menu_makanan
                 ,nama
                 ,id_kategori
                 ,jumlah
                 ,harga
                 ,foto
                 ,keterangan

            ;
    Button tombol_edit, tombol_hapus;
    protected int REQUEST_CODE_TAMBAH = 3543;

    public data_menu_makanan_adapter(Activity activity, ArrayList<data_menu_makanan_apidata> data) {
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
            v = vi.inflate( R.layout.data_menu_makanan_tampil, null);
        }

        Object p = getItem(position);

        if (p != null) {

            id_menu_makanan = (TextView) v.findViewById(R.id.id_menu_makanan);
            nama = (TextView) v.findViewById(R.id.nama);
            id_kategori = (TextView) v.findViewById(R.id.id_kategori);
            jumlah = (TextView) v.findViewById(R.id.jumlah);
            harga = (TextView) v.findViewById(R.id.harga);
            foto = (TextView) v.findViewById(R.id.foto);
            keterangan = (TextView) v.findViewById(R.id.keterangan);


            tombol_edit = (Button) v.findViewById(R.id.tombol_edit);
            tombol_hapus = (Button) v.findViewById(R.id.tombol_hapus);

            tombol_edit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Bundle bundle = new Bundle();

                    bundle.putString("", data.get(position).get_id_menu_makanan());
                    bundle.putString("nama", data.get(position).get_nama());
                    bundle.putString("id_kategori", data.get(position).get_id_kategori());
                    bundle.putString("jumlah", data.get(position).get_jumlah());
                    bundle.putString("harga", data.get(position).get_harga());
                    bundle.putString("foto", data.get(position).get_foto());
                    bundle.putString("keterangan", data.get(position).get_keterangan());

                    
                    Intent intent = new Intent(activity, data_menu_makanan_edit.class);
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
									data_menu_makanan_apiservice mAPIService = 
									data_menu_makanan_apiutils.getAPIService();
									mAPIService.proses_hapus_data_menu_makanan(
											data.get(position).get_id_menu_makanan(),
											token
									).enqueue(new Callback<Object>() {			  
										@Override
										public void onResponse(Call<Object> call, Response<Object> response) {
											((data_menu_makanan_activity)activity).fetch_data_menu_makanan();
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

            id_menu_makanan.setText("id_menu_makanan "+data.get(position).get_id_menu_makanan());
            nama.setText("nama "+data.get(position).get_nama());
            id_kategori.setText("id_kategori "+data.get(position).get_id_kategori());
            jumlah.setText("jumlah "+data.get(position).get_jumlah());
            harga.setText("harga "+data.get(position).get_harga());
            foto.setText("foto "+data.get(position).get_foto());
            keterangan.setText("keterangan "+data.get(position).get_keterangan());


        }

        return v;
    }

    public void updateResults(ArrayList<data_menu_makanan_apidata> result) {
        data = result;
        notifyDataSetChanged();
    }
}
