package com.project.aplikasi.pemesanan_makanan.data_pelanggan;

import android.app.Activity;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;

import com.project.aplikasi.pemesanan_makanan.R;
import com.project.aplikasi.pemesanan_makanan.config.config_global;
import com.project.aplikasi.pemesanan_makanan.activity.loading;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class data_pelanggan_tambah_v2_adapter extends BaseAdapter {

    Activity activity;
    ArrayList<data_pelanggan_apidata> data;
    TextView id_pelanggan
    ,nama
    ,alamat
    ,no_telepon
    ,username
    ,password
;
    Button tombol_hapus;
	data_pelanggan_apiservice mAPIService;
	loading loading;

    public data_pelanggan_tambah_v2_adapter(Activity activity, ArrayList<data_pelanggan_apidata> data) {
        this.activity = activity;
        this.data = data;
		mAPIService = data_pelanggan_apiutils.getAPIService();
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
            v = vi.inflate( R.layout.data_pelanggan_tambah_v2_tampil, null);
        }

        Object p = getItem(position);

        if (p != null) {

            id_pelanggan = (TextView) v.findViewById(R.id.id_pelanggan);
            nama = (TextView) v.findViewById(R.id.nama);
            alamat = (TextView) v.findViewById(R.id.alamat);
            no_telepon = (TextView) v.findViewById(R.id.no_telepon);
            username = (TextView) v.findViewById(R.id.username);
            password = (TextView) v.findViewById(R.id.password);

            tombol_hapus = (Button) v.findViewById(R.id.tombol_hapus);
			loading = new loading((data_pelanggan_tambah_v2)activity);

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
									loading.showDialog(1,"Please Wait","Proses Hapus Data..");
									  data_pelanggan_apiservice mAPIService =
                                            data_pelanggan_apiutils.getAPIService();
                                    String token = "Bearer " + new config_global().ambil(activity);
                                    mAPIService.proses_hapus_data_pelanggan(
                                            data.get(position).get_id_pelanggan(),
                                            token
                                    ).enqueue(new Callback<Object>() {
                                        @Override
                                        public void onResponse(Call<Object> call, Response<Object> response) {
                                            if (new config_global().checkTokenOlineIsValid(activity,
                                                    response.code())){
                                                data.remove(position);
                                                 notifyDataSetChanged();
                                            }
                                            loading.hideDialog();
                                        }

                                        @Override
                                        public void onFailure(Call<Object> call, Throwable t) {
                                            loading.hideDialog();
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

            id_pelanggan.setText(""+data.get(position).get_id_pelanggan());
            nama.setText(""+data.get(position).get_nama());
            alamat.setText(""+data.get(position).get_alamat());
            no_telepon.setText(""+data.get(position).get_no_telepon());
            username.setText(""+data.get(position).get_username());
            password.setText(""+data.get(position).get_password());


        }

        return v;
    }

    public void updateResults(ArrayList<data_pelanggan_apidata> result) {
        data = result;
        notifyDataSetChanged();
    }
}
