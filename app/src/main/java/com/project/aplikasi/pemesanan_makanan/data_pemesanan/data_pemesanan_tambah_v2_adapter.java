package com.project.aplikasi.pemesanan_makanan.data_pemesanan;

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


public class data_pemesanan_tambah_v2_adapter extends BaseAdapter {

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
    Button tombol_hapus;
	data_pemesanan_apiservice mAPIService;
	loading loading;

    public data_pemesanan_tambah_v2_adapter(Activity activity, ArrayList<data_pemesanan_apidata> data) {
        this.activity = activity;
        this.data = data;
		mAPIService = data_pemesanan_apiutils.getAPIService();
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
            v = vi.inflate( R.layout.data_pemesanan_tambah_v2_tampil, null);
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

            tombol_hapus = (Button) v.findViewById(R.id.tombol_hapus);
			loading = new loading((data_pemesanan_tambah_v2)activity);

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
									  data_pemesanan_apiservice mAPIService =
                                            data_pemesanan_apiutils.getAPIService();
                                    String token = "Bearer " + new config_global().ambil(activity);
                                    mAPIService.proses_hapus_data_pemesanan(
                                            data.get(position).get_id_pemesanan(),
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

            id_pemesanan.setText(""+data.get(position).get_id_pemesanan());
            tanggal.setText(""+data.get(position).get_tanggal());
            id_pelanggan.setText(""+data.get(position).get_id_pelanggan());
            total_bayar.setText(""+data.get(position).get_total_bayar());
            lat.setText(""+data.get(position).get_lat());
            lng.setText(""+data.get(position).get_lng());
            alamat_pengiriman.setText(""+data.get(position).get_alamat_pengiriman());
            status.setText(""+data.get(position).get_status());


        }

        return v;
    }

    public void updateResults(ArrayList<data_pemesanan_apidata> result) {
        data = result;
        notifyDataSetChanged();
    }
}
