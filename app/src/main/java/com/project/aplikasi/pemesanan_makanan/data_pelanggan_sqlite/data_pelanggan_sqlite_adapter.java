package com.project.aplikasi.pemesanan_makanan.data_pelanggan_sqlite;

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


public class data_pelanggan_sqlite_adapter extends RecyclerView.Adapter<data_pelanggan_sqlite_adapter.data_pelanggan_ViewHolder> {

    Activity activity;
    private List<data_pelanggan_sqlite_data> datalist = new ArrayList<>();
    private data_pelanggan_sqlite_dbhandler dbHandler;
    private data_pelanggan_sqlite_adapter adapter;


    public data_pelanggan_sqlite_adapter(Activity activity,List<data_pelanggan_sqlite_data> datalist) {
        this.activity = activity;
        this.datalist = datalist;
    }

    @Override
    public data_pelanggan_ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.data_pelanggan_tampil_v2, parent, false);
        data_pelanggan_ViewHolder mahasiswaViewHolder = new data_pelanggan_ViewHolder(view);
        return mahasiswaViewHolder;
    }

    @Override
    public void onBindViewHolder(data_pelanggan_ViewHolder holder, int position) {
        holder.txt_result_id_pelanggan.setText("id_pelanggan : " + datalist.get(position).get_id_pelanggan());
       holder.txt_result_nama.setText("Nama  : " + Html.fromHtml(datalist.get(position).get_nama()+ "" ));
       holder.txt_result_alamat.setText("Alamat  : " + Html.fromHtml(datalist.get(position).get_alamat()+ "" ));
       holder.txt_result_no_telepon.setText("No Telepon  : " + Html.fromHtml(datalist.get(position).get_no_telepon()+ "" ));
       holder.txt_result_username.setText("Username  : " + Html.fromHtml(datalist.get(position).get_username()+ "" ));
       holder.txt_result_password.setText("Password  : " + Html.fromHtml(datalist.get(position).get_password()+ "" ));

    }

    @Override
    public int getItemCount() {
        return datalist.size();
    }

    public class data_pelanggan_ViewHolder extends RecyclerView.ViewHolder {
        TextView txt_result_id_pelanggan;
       TextView txt_result_nama;
       TextView txt_result_alamat;
       TextView txt_result_no_telepon;
       TextView txt_result_username;
       TextView txt_result_password;

        LinearLayout linearEdit, linearHapus;
        protected int REQUEST_CODE_TAMBAH = 3543;
        public data_pelanggan_ViewHolder(final View itemView) {
            super(itemView);
            dbHandler = new data_pelanggan_sqlite_dbhandler(activity);
            txt_result_id_pelanggan = (TextView) itemView.findViewById(R.id.id_pelanggan);
           txt_result_nama = (TextView) itemView.findViewById(R.id.nama);
           txt_result_alamat = (TextView) itemView.findViewById(R.id.alamat);
           txt_result_no_telepon = (TextView) itemView.findViewById(R.id.no_telepon);
           txt_result_username = (TextView) itemView.findViewById(R.id.username);
           txt_result_password = (TextView) itemView.findViewById(R.id.password);


            linearEdit = (LinearLayout) itemView.findViewById(R.id.linearEdit);
            linearHapus = (LinearLayout) itemView.findViewById(R.id.linearHapus);

            linearEdit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Bundle bundle = new Bundle();
                    bundle.putString("id_pelanggan", datalist.get(getAdapterPosition()).get_id_pelanggan());
                   bundle.putString("nama", datalist.get(getAdapterPosition()).get_nama());
                   bundle.putString("alamat", datalist.get(getAdapterPosition()).get_alamat());
                   bundle.putString("no_telepon", datalist.get(getAdapterPosition()).get_no_telepon());
                   bundle.putString("username", datalist.get(getAdapterPosition()).get_username());
                   bundle.putString("password", datalist.get(getAdapterPosition()).get_password());



                    Intent intent = new Intent(activity, data_pelanggan_sqlite_edit.class);
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

                                    dbHandler.hapus_data_pelanggan_sqlite( new data_pelanggan_sqlite_data(
                                            datalist.get(getAdapterPosition()).get_id_pelanggan()
                                           ,datalist.get(getAdapterPosition()).get_nama()
                                           ,datalist.get(getAdapterPosition()).get_alamat()
                                           ,datalist.get(getAdapterPosition()).get_no_telepon()
                                           ,datalist.get(getAdapterPosition()).get_username()
                                           ,datalist.get(getAdapterPosition()).get_password()

                                    ) );

                                    List<data_pelanggan_sqlite_data> data_pelanggan_sqliteList = dbHandler.get_semua_data_pelanggan_sqlite();
                                    adapter = new data_pelanggan_sqlite_adapter( activity, data_pelanggan_sqliteList );
                                    adapter.notifyDataSetChanged();
                                    Toast.makeText( activity, "Berhasil Terhapus", Toast.LENGTH_SHORT ).show();
                                    ((data_pelanggan_sqlite_activity)activity).fetch_data_pelanggan_sqlite();
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







