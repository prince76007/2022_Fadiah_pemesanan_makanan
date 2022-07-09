package com.project.aplikasi.pemesanan_makanan.data_kategori_sqlite;

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


public class data_kategori_sqlite_adapter extends RecyclerView.Adapter<data_kategori_sqlite_adapter.data_kategori_ViewHolder> {

    Activity activity;
    private List<data_kategori_sqlite_data> datalist = new ArrayList<>();
    private data_kategori_sqlite_dbhandler dbHandler;
    private data_kategori_sqlite_adapter adapter;


    public data_kategori_sqlite_adapter(Activity activity,List<data_kategori_sqlite_data> datalist) {
        this.activity = activity;
        this.datalist = datalist;
    }

    @Override
    public data_kategori_ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.data_kategori_tampil_v2, parent, false);
        data_kategori_ViewHolder mahasiswaViewHolder = new data_kategori_ViewHolder(view);
        return mahasiswaViewHolder;
    }

    @Override
    public void onBindViewHolder(data_kategori_ViewHolder holder, int position) {
        holder.txt_result_id_kategori.setText("id_kategori : " + datalist.get(position).get_id_kategori());
       holder.txt_result_kategori.setText("Kategori  : " + Html.fromHtml(datalist.get(position).get_kategori()+ "" ));

    }

    @Override
    public int getItemCount() {
        return datalist.size();
    }

    public class data_kategori_ViewHolder extends RecyclerView.ViewHolder {
        TextView txt_result_id_kategori;
       TextView txt_result_kategori;

        LinearLayout linearEdit, linearHapus;
        protected int REQUEST_CODE_TAMBAH = 3543;
        public data_kategori_ViewHolder(final View itemView) {
            super(itemView);
            dbHandler = new data_kategori_sqlite_dbhandler(activity);
            txt_result_id_kategori = (TextView) itemView.findViewById(R.id.id_kategori);
           txt_result_kategori = (TextView) itemView.findViewById(R.id.kategori);


            linearEdit = (LinearLayout) itemView.findViewById(R.id.linearEdit);
            linearHapus = (LinearLayout) itemView.findViewById(R.id.linearHapus);

            linearEdit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Bundle bundle = new Bundle();
                    bundle.putString("id_kategori", datalist.get(getAdapterPosition()).get_id_kategori());
                   bundle.putString("kategori", datalist.get(getAdapterPosition()).get_kategori());



                    Intent intent = new Intent(activity, data_kategori_sqlite_edit.class);
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

                                    dbHandler.hapus_data_kategori_sqlite( new data_kategori_sqlite_data(
                                            datalist.get(getAdapterPosition()).get_id_kategori()
                                           ,datalist.get(getAdapterPosition()).get_kategori()

                                    ) );

                                    List<data_kategori_sqlite_data> data_kategori_sqliteList = dbHandler.get_semua_data_kategori_sqlite();
                                    adapter = new data_kategori_sqlite_adapter( activity, data_kategori_sqliteList );
                                    adapter.notifyDataSetChanged();
                                    Toast.makeText( activity, "Berhasil Terhapus", Toast.LENGTH_SHORT ).show();
                                    ((data_kategori_sqlite_activity)activity).fetch_data_kategori_sqlite();
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







