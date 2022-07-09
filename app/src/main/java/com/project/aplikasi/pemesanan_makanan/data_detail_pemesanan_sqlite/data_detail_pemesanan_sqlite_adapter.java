package com.project.aplikasi.pemesanan_makanan.data_detail_pemesanan_sqlite;

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


public class data_detail_pemesanan_sqlite_adapter extends RecyclerView.Adapter<data_detail_pemesanan_sqlite_adapter.data_detail_pemesanan_ViewHolder> {

    Activity activity;
    private List<data_detail_pemesanan_sqlite_data> datalist = new ArrayList<>();
    private data_detail_pemesanan_sqlite_dbhandler dbHandler;
    private data_detail_pemesanan_sqlite_adapter adapter;


    public data_detail_pemesanan_sqlite_adapter(Activity activity,List<data_detail_pemesanan_sqlite_data> datalist) {
        this.activity = activity;
        this.datalist = datalist;
    }

    @Override
    public data_detail_pemesanan_ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.data_detail_pemesanan_tampil_v2, parent, false);
        data_detail_pemesanan_ViewHolder mahasiswaViewHolder = new data_detail_pemesanan_ViewHolder(view);
        return mahasiswaViewHolder;
    }

    @Override
    public void onBindViewHolder(data_detail_pemesanan_ViewHolder holder, int position) {
        holder.txt_result_id_detail_pemesanan.setText("id_detail_pemesanan : " + datalist.get(position).get_id_detail_pemesanan());
       holder.txt_result_id_pemesanan.setText("Id Pemesanan  : " + Html.fromHtml(datalist.get(position).get_id_pemesanan()+ "" ));
       holder.txt_result_id_menu_makanan.setText("Id Menu Makanan  : " + Html.fromHtml(datalist.get(position).get_id_menu_makanan()+ "" ));
       holder.txt_result_jumlah.setText("Jumlah  : " + Html.fromHtml(datalist.get(position).get_jumlah()+ "" ));
       holder.txt_result_harga.setText("Harga  : " + Html.fromHtml(datalist.get(position).get_harga()+ "" ));

    }

    @Override
    public int getItemCount() {
        return datalist.size();
    }

    public class data_detail_pemesanan_ViewHolder extends RecyclerView.ViewHolder {
        TextView txt_result_id_detail_pemesanan;
       TextView txt_result_id_pemesanan;
       TextView txt_result_id_menu_makanan;
       TextView txt_result_jumlah;
       TextView txt_result_harga;

        LinearLayout linearEdit, linearHapus;
        protected int REQUEST_CODE_TAMBAH = 3543;
        public data_detail_pemesanan_ViewHolder(final View itemView) {
            super(itemView);
            dbHandler = new data_detail_pemesanan_sqlite_dbhandler(activity);
            txt_result_id_detail_pemesanan = (TextView) itemView.findViewById(R.id.id_detail_pemesanan);
           txt_result_id_pemesanan = (TextView) itemView.findViewById(R.id.id_pemesanan);
           txt_result_id_menu_makanan = (TextView) itemView.findViewById(R.id.id_menu_makanan);
           txt_result_jumlah = (TextView) itemView.findViewById(R.id.jumlah);
           txt_result_harga = (TextView) itemView.findViewById(R.id.harga);


            linearEdit = (LinearLayout) itemView.findViewById(R.id.linearEdit);
            linearHapus = (LinearLayout) itemView.findViewById(R.id.linearHapus);

            linearEdit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Bundle bundle = new Bundle();
                    bundle.putString("id_detail_pemesanan", datalist.get(getAdapterPosition()).get_id_detail_pemesanan());
                   bundle.putString("id_pemesanan", datalist.get(getAdapterPosition()).get_id_pemesanan());
                   bundle.putString("id_menu_makanan", datalist.get(getAdapterPosition()).get_id_menu_makanan());
                   bundle.putString("jumlah", datalist.get(getAdapterPosition()).get_jumlah());
                   bundle.putString("harga", datalist.get(getAdapterPosition()).get_harga());



                    Intent intent = new Intent(activity, data_detail_pemesanan_sqlite_edit.class);
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

                                    dbHandler.hapus_data_detail_pemesanan_sqlite( new data_detail_pemesanan_sqlite_data(
                                            datalist.get(getAdapterPosition()).get_id_detail_pemesanan()
                                           ,datalist.get(getAdapterPosition()).get_id_pemesanan()
                                           ,datalist.get(getAdapterPosition()).get_id_menu_makanan()
                                           ,datalist.get(getAdapterPosition()).get_jumlah()
                                           ,datalist.get(getAdapterPosition()).get_harga()

                                    ) );

                                    List<data_detail_pemesanan_sqlite_data> data_detail_pemesanan_sqliteList = dbHandler.get_semua_data_detail_pemesanan_sqlite();
                                    adapter = new data_detail_pemesanan_sqlite_adapter( activity, data_detail_pemesanan_sqliteList );
                                    adapter.notifyDataSetChanged();
                                    Toast.makeText( activity, "Berhasil Terhapus", Toast.LENGTH_SHORT ).show();
                                    ((data_detail_pemesanan_sqlite_activity)activity).fetch_data_detail_pemesanan_sqlite();
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







