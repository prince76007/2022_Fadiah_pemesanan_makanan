package com.project.aplikasi.pemesanan_makanan.data_menu_makanan_sqlite;

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


public class data_menu_makanan_sqlite_adapter extends RecyclerView.Adapter<data_menu_makanan_sqlite_adapter.data_menu_makanan_ViewHolder> {

    Activity activity;
    private List<data_menu_makanan_sqlite_data> datalist = new ArrayList<>();
    private data_menu_makanan_sqlite_dbhandler dbHandler;
    private data_menu_makanan_sqlite_adapter adapter;


    public data_menu_makanan_sqlite_adapter(Activity activity,List<data_menu_makanan_sqlite_data> datalist) {
        this.activity = activity;
        this.datalist = datalist;
    }

    @Override
    public data_menu_makanan_ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.data_menu_makanan_tampil_v2, parent, false);
        data_menu_makanan_ViewHolder mahasiswaViewHolder = new data_menu_makanan_ViewHolder(view);
        return mahasiswaViewHolder;
    }

    @Override
    public void onBindViewHolder(data_menu_makanan_ViewHolder holder, int position) {
        holder.txt_result_id_menu_makanan.setText("id_menu_makanan : " + datalist.get(position).get_id_menu_makanan());
       holder.txt_result_nama.setText("Nama  : " + Html.fromHtml(datalist.get(position).get_nama()+ "" ));
       holder.txt_result_id_kategori.setText("Id Kategori  : " + Html.fromHtml(datalist.get(position).get_id_kategori()+ "" ));
       holder.txt_result_jumlah.setText("Jumlah  : " + Html.fromHtml(datalist.get(position).get_jumlah()+ "" ));
       holder.txt_result_harga.setText("Harga  : " + Html.fromHtml(datalist.get(position).get_harga()+ "" ));
       holder.txt_result_foto.setText("Foto  : " + Html.fromHtml(datalist.get(position).get_foto()+ "" ));
       holder.txt_result_keterangan.setText("Keterangan  : " + Html.fromHtml(datalist.get(position).get_keterangan()+ "" ));

    }

    @Override
    public int getItemCount() {
        return datalist.size();
    }

    public class data_menu_makanan_ViewHolder extends RecyclerView.ViewHolder {
        TextView txt_result_id_menu_makanan;
       TextView txt_result_nama;
       TextView txt_result_id_kategori;
       TextView txt_result_jumlah;
       TextView txt_result_harga;
       TextView txt_result_foto;
       TextView txt_result_keterangan;

        LinearLayout linearEdit, linearHapus;
        protected int REQUEST_CODE_TAMBAH = 3543;
        public data_menu_makanan_ViewHolder(final View itemView) {
            super(itemView);
            dbHandler = new data_menu_makanan_sqlite_dbhandler(activity);
            txt_result_id_menu_makanan = (TextView) itemView.findViewById(R.id.id_menu_makanan);
           txt_result_nama = (TextView) itemView.findViewById(R.id.nama);
           txt_result_id_kategori = (TextView) itemView.findViewById(R.id.id_kategori);
           txt_result_jumlah = (TextView) itemView.findViewById(R.id.jumlah);
           txt_result_harga = (TextView) itemView.findViewById(R.id.harga);
           txt_result_foto = (TextView) itemView.findViewById(R.id.foto);
           txt_result_keterangan = (TextView) itemView.findViewById(R.id.keterangan);


            linearEdit = (LinearLayout) itemView.findViewById(R.id.linearEdit);
            linearHapus = (LinearLayout) itemView.findViewById(R.id.linearHapus);

            linearEdit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Bundle bundle = new Bundle();
                    bundle.putString("id_menu_makanan", datalist.get(getAdapterPosition()).get_id_menu_makanan());
                   bundle.putString("nama", datalist.get(getAdapterPosition()).get_nama());
                   bundle.putString("id_kategori", datalist.get(getAdapterPosition()).get_id_kategori());
                   bundle.putString("jumlah", datalist.get(getAdapterPosition()).get_jumlah());
                   bundle.putString("harga", datalist.get(getAdapterPosition()).get_harga());
                   bundle.putString("foto", datalist.get(getAdapterPosition()).get_foto());
                   bundle.putString("keterangan", datalist.get(getAdapterPosition()).get_keterangan());



                    Intent intent = new Intent(activity, data_menu_makanan_sqlite_edit.class);
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

                                    dbHandler.hapus_data_menu_makanan_sqlite( new data_menu_makanan_sqlite_data(
                                            datalist.get(getAdapterPosition()).get_id_menu_makanan()
                                           ,datalist.get(getAdapterPosition()).get_nama()
                                           ,datalist.get(getAdapterPosition()).get_id_kategori()
                                           ,datalist.get(getAdapterPosition()).get_jumlah()
                                           ,datalist.get(getAdapterPosition()).get_harga()
                                           ,datalist.get(getAdapterPosition()).get_foto()
                                           ,datalist.get(getAdapterPosition()).get_keterangan()

                                    ) );

                                    List<data_menu_makanan_sqlite_data> data_menu_makanan_sqliteList = dbHandler.get_semua_data_menu_makanan_sqlite();
                                    adapter = new data_menu_makanan_sqlite_adapter( activity, data_menu_makanan_sqliteList );
                                    adapter.notifyDataSetChanged();
                                    Toast.makeText( activity, "Berhasil Terhapus", Toast.LENGTH_SHORT ).show();
                                    ((data_menu_makanan_sqlite_activity)activity).fetch_data_menu_makanan_sqlite();
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







