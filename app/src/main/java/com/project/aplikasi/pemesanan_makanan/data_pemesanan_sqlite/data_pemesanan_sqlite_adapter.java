package com.project.aplikasi.pemesanan_makanan.data_pemesanan_sqlite;

import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.text.Html;

import com.project.aplikasi.pemesanan_makanan.R;

import java.util.ArrayList;
import java.util.List;


public class data_pemesanan_sqlite_adapter extends RecyclerView.Adapter<data_pemesanan_sqlite_adapter.data_pemesanan_ViewHolder> {

    Activity activity;
    private List<data_pemesanan_sqlite_data> datalist = new ArrayList<>();
    private data_pemesanan_sqlite_dbhandler dbHandler;
    private data_pemesanan_sqlite_adapter adapter;


    public data_pemesanan_sqlite_adapter(Activity activity,List<data_pemesanan_sqlite_data> datalist) {
        this.activity = activity;
        this.datalist = datalist;
    }

    @Override
    public data_pemesanan_ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.data_pemesanan_tampil_v2, parent, false);
        data_pemesanan_ViewHolder mahasiswaViewHolder = new data_pemesanan_ViewHolder(view);
        return mahasiswaViewHolder;
    }

    @Override
    public void onBindViewHolder(data_pemesanan_ViewHolder holder, int position) {
        holder.txt_result_id_pemesanan.setText("id_pemesanan : " + datalist.get(position).get_id_pemesanan());
       holder.txt_result_tanggal.setText("Tanggal  : " + Html.fromHtml(datalist.get(position).get_tanggal()+ "" ));
       holder.txt_result_id_pelanggan.setText("Id Pelanggan  : " + Html.fromHtml(datalist.get(position).get_id_pelanggan()+ "" ));
       holder.txt_result_total_bayar.setText("Total Bayar  : " + Html.fromHtml(datalist.get(position).get_total_bayar()+ "" ));
       holder.txt_result_lat.setText("Lat  : " + Html.fromHtml(datalist.get(position).get_lat()+ "" ));
       holder.txt_result_lng.setText("Lng  : " + Html.fromHtml(datalist.get(position).get_lng()+ "" ));
       holder.txt_result_alamat_pengiriman.setText("Alamat Pengiriman  : " + Html.fromHtml(datalist.get(position).get_alamat_pengiriman()+ "" ));
       holder.txt_result_status.setText("Status  : " + Html.fromHtml(datalist.get(position).get_status()+ "" ));

    }

    @Override
    public int getItemCount() {
        return datalist.size();
    }

    public class data_pemesanan_ViewHolder extends RecyclerView.ViewHolder {
        TextView txt_result_id_pemesanan;
       TextView txt_result_tanggal;
       TextView txt_result_id_pelanggan;
       TextView txt_result_total_bayar;
       TextView txt_result_lat;
       TextView txt_result_lng;
       TextView txt_result_alamat_pengiriman;
       TextView txt_result_status;

        LinearLayout linearEdit, linearHapus;
        protected int REQUEST_CODE_TAMBAH = 3543;
        public data_pemesanan_ViewHolder(final View itemView) {
            super(itemView);
            dbHandler = new data_pemesanan_sqlite_dbhandler(activity);
            txt_result_id_pemesanan = (TextView) itemView.findViewById(R.id.id_pemesanan);
           txt_result_tanggal = (TextView) itemView.findViewById(R.id.tanggal);
           txt_result_id_pelanggan = (TextView) itemView.findViewById(R.id.id_pelanggan);
           txt_result_total_bayar = (TextView) itemView.findViewById(R.id.total_bayar);
           txt_result_lat = (TextView) itemView.findViewById(R.id.lat);
           txt_result_lng = (TextView) itemView.findViewById(R.id.lng);
           txt_result_alamat_pengiriman = (TextView) itemView.findViewById(R.id.alamat_pengiriman);
           txt_result_status = (TextView) itemView.findViewById(R.id.status);


            linearEdit = (LinearLayout) itemView.findViewById(R.id.linearEdit);
            linearHapus = (LinearLayout) itemView.findViewById(R.id.linearHapus);

            linearEdit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Bundle bundle = new Bundle();
                    bundle.putString("id_pemesanan", datalist.get(getAdapterPosition()).get_id_pemesanan());
                   bundle.putString("tanggal", datalist.get(getAdapterPosition()).get_tanggal());
                   bundle.putString("id_pelanggan", datalist.get(getAdapterPosition()).get_id_pelanggan());
                   bundle.putString("total_bayar", datalist.get(getAdapterPosition()).get_total_bayar());
                   bundle.putString("lat", datalist.get(getAdapterPosition()).get_lat());
                   bundle.putString("lng", datalist.get(getAdapterPosition()).get_lng());
                   bundle.putString("alamat_pengiriman", datalist.get(getAdapterPosition()).get_alamat_pengiriman());
                   bundle.putString("status", datalist.get(getAdapterPosition()).get_status());



                    Intent intent = new Intent(activity, data_pemesanan_sqlite_edit.class);
                    intent.putExtras(bundle);
                    activity.startActivityForResult(intent, REQUEST_CODE_TAMBAH);

                }
            });


            linearHapus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    AlertDialog.Builder BackAlertDialog = new AlertDialog.Builder(activity);
                    BackAlertDialog.setTitle("Proses Hapus");
                    BackAlertDialog.setMessage("Apakah Anda ingin Menghapus Data?");
                    BackAlertDialog.setPositiveButton("Ya",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    //Proses Hapus

                                    dbHandler.hapus_data_pemesanan_sqlite( new data_pemesanan_sqlite_data(
                                            datalist.get(getAdapterPosition()).get_id_pemesanan()
                                           ,datalist.get(getAdapterPosition()).get_tanggal()
                                           ,datalist.get(getAdapterPosition()).get_id_pelanggan()
                                           ,datalist.get(getAdapterPosition()).get_total_bayar()
                                           ,datalist.get(getAdapterPosition()).get_lat()
                                           ,datalist.get(getAdapterPosition()).get_lng()
                                           ,datalist.get(getAdapterPosition()).get_alamat_pengiriman()
                                           ,datalist.get(getAdapterPosition()).get_status()

                                    ) );

                                    List<data_pemesanan_sqlite_data> data_pemesanan_sqliteList = dbHandler.get_semua_data_pemesanan_sqlite();
                                    adapter = new data_pemesanan_sqlite_adapter( activity, data_pemesanan_sqliteList );
                                    adapter.notifyDataSetChanged();
                                    Toast.makeText( activity, "Berhasil Terhapus", Toast.LENGTH_SHORT ).show();
                                    ((data_pemesanan_sqlite_activity)activity).fetch_data_pemesanan_sqlite();
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



        }
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}







