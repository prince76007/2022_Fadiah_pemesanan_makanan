package com.project.aplikasi.pemesanan_makanan.data_admin;

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


public class data_admin_adapter extends BaseAdapter {

    Activity activity;
    ArrayList<data_admin_apidata> data;
    TextView id_admin
                 ,nama
                 ,username
                 ,password

            ;
    Button tombol_edit, tombol_hapus;
    protected int REQUEST_CODE_TAMBAH = 3543;

    public data_admin_adapter(Activity activity, ArrayList<data_admin_apidata> data) {
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
            v = vi.inflate( R.layout.data_admin_tampil, null);
        }

        Object p = getItem(position);

        if (p != null) {

            id_admin = (TextView) v.findViewById(R.id.id_admin);
            nama = (TextView) v.findViewById(R.id.nama);
            username = (TextView) v.findViewById(R.id.username);
            password = (TextView) v.findViewById(R.id.password);


            tombol_edit = (Button) v.findViewById(R.id.tombol_edit);
            tombol_hapus = (Button) v.findViewById(R.id.tombol_hapus);

            tombol_edit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Bundle bundle = new Bundle();

                    bundle.putString("", data.get(position).get_id_admin());
                    bundle.putString("nama", data.get(position).get_nama());
                    bundle.putString("username", data.get(position).get_username());
                    bundle.putString("password", data.get(position).get_password());

                    
                    Intent intent = new Intent(activity, data_admin_edit.class);
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
									data_admin_apiservice mAPIService = 
									data_admin_apiutils.getAPIService();
									mAPIService.proses_hapus_data_admin(
											data.get(position).get_id_admin(),
											token
									).enqueue(new Callback<Object>() {			  
										@Override
										public void onResponse(Call<Object> call, Response<Object> response) {
											((data_admin_activity)activity).fetch_data_admin();
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

            id_admin.setText("id_admin "+data.get(position).get_id_admin());
            nama.setText("nama "+data.get(position).get_nama());
            username.setText("username "+data.get(position).get_username());
            password.setText("password "+data.get(position).get_password());


        }

        return v;
    }

    public void updateResults(ArrayList<data_admin_apidata> result) {
        data = result;
        notifyDataSetChanged();
    }
}
