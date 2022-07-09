package com.project.aplikasi.pemesanan_makanan.data_menu_makanan;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.text.Html;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.project.aplikasi.pemesanan_makanan.R;
import com.project.aplikasi.pemesanan_makanan.config.config_global;
import com.project.aplikasi.pemesanan_makanan.data_detail_pemesanan.data_detail_pemesanan_tambah;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import static com.project.aplikasi.pemesanan_makanan.config.config_global.BASE_URL;

public class data_menu_makanan_adapter_v2 extends RecyclerView.Adapter<data_menu_makanan_adapter_v2.data_menu_makanan_adapter_v2_view_holder> {
    private ArrayList<data_menu_makanan_apidata> dataList;
    private Activity activity;

    public data_menu_makanan_adapter_v2(ArrayList<data_menu_makanan_apidata> dataList, Activity activity) {
        this.dataList = dataList;
        this.activity = activity;
    }

    @NonNull
    @Override
    public data_menu_makanan_adapter_v2_view_holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.data_menu_makanan_tampil_v2, parent, false);
        return new data_menu_makanan_adapter_v2_view_holder(view);
    }

    @Override
    public void onBindViewHolder(data_menu_makanan_adapter_v2_view_holder holder, int position) {
        
        //holder.nomor.setText(String.format("%d", position + 1));
        holder.id_menu_makanan.setText(""+dataList.get(position).get_id_menu_makanan());
		holder.id_menu_makanan.setVisibility( View.GONE );
        holder.nama.setText(Html.fromHtml("<b>"+dataList.get(position).get_nama()+"</b>"));
        holder.id_kategori.setText(Html.fromHtml("Kategori  : "+dataList.get(position).get_id_kategori()+""));
        holder.jumlah.setText(Html.fromHtml("Jumlah  : "+dataList.get(position).get_jumlah()+""));
        holder.jumlah.setVisibility(View.GONE);
        holder.harga.setVisibility(View.GONE);
        holder.harga.setText(Html.fromHtml("Harga  : "+dataList.get(position).get_harga()+""));
        holder.foto.setText(Html.fromHtml("Foto  : "+dataList.get(position).get_foto()+""));
        holder.foto.setVisibility(View.GONE);
        holder.keterangan.setText(Html.fromHtml(""+dataList.get(position).get_keterangan()+""));


        thumb(holder,BASE_URL +"/admin/upload/" + dataList.get(position).get_foto(),true);
        edit(holder,"Edit",false);
        hapus(holder,"Hapus",false);
    }

     private void thumb(data_menu_makanan_adapter_v2_view_holder holder,String url_gambar,Boolean visible)
    {
        if (visible==true) {
            holder.image.setVisibility( View.VISIBLE );
            Picasso.get().load( url_gambar ).into( holder.image );
        }
        else
        {
            holder.image.setVisibility( View.GONE );
        }
    }

    private void edit(data_menu_makanan_adapter_v2_view_holder holder,String nama_tombol,Boolean visible)
    {
        holder.tombol_edit.setText(nama_tombol);
        if (visible==true) {
            holder.linearEdit.setVisibility( View.VISIBLE );
        }
        else
        {
            holder.linearEdit.setVisibility( View.GONE );
        }
    }

    private void hapus(data_menu_makanan_adapter_v2_view_holder holder,String nama_tombol,Boolean visible)
    {
        holder.tombol_hapus.setText(nama_tombol);
        if (visible==true) {
            holder.linearHapus.setVisibility( View.VISIBLE );
        }
        else
        {
            holder.linearHapus.setVisibility( View.GONE );
        }
    }

    @Override
    public int getItemCount() {
        return (dataList != null) ? dataList.size() : 0;
    }

    public class data_menu_makanan_adapter_v2_view_holder extends RecyclerView.ViewHolder {
        TextView id_menu_makanan
        ,nama
        ,id_kategori
        ,jumlah
        ,harga
        ,foto
        ,keterangan

				,nomor;
        TextView tombol_edit,tombol_hapus;
        private LinearLayout linearNomor;
        LinearLayout linearEdit, linearHapus,linearBaris;
        protected int REQUEST_CODE_TAMBAH = 3543;
        ImageView image;


        public data_menu_makanan_adapter_v2_view_holder(final View itemView) {
            super(itemView);
            linearNomor = (LinearLayout) itemView.findViewById(R.id.linearNomor);
            id_menu_makanan = (TextView) itemView.findViewById(R.id.id_menu_makanan);
            nama = (TextView) itemView.findViewById(R.id.nama);
            id_kategori = (TextView) itemView.findViewById(R.id.id_kategori);
            jumlah = (TextView) itemView.findViewById(R.id.jumlah);
            harga = (TextView) itemView.findViewById(R.id.harga);
            foto = (TextView) itemView.findViewById(R.id.foto);
            keterangan = (TextView) itemView.findViewById(R.id.keterangan);

            nomor = (TextView) itemView.findViewById(R.id.txt_nomor);
            linearEdit = (LinearLayout) itemView.findViewById(R.id.linearEdit);
            tombol_edit = (TextView) itemView.findViewById(R.id.tombol_edit);
            linearHapus = (LinearLayout) itemView.findViewById(R.id.linearHapus);
            tombol_hapus = (TextView) itemView.findViewById(R.id.tombol_hapus);  
            linearBaris = (LinearLayout) itemView.findViewById(R.id.linearBaris);
            image = (ImageView) itemView.findViewById(R.id.img);

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
                                    data_menu_makanan_apiservice mAPIService = 
									data_menu_makanan_apiutils.getAPIService();
									String token = "Bearer " + new config_global().ambil(activity);
									Log.d("POSITION", Integer.toString(getAdapterPosition()));
									mAPIService.proses_hapus_data_menu_makanan(
											dataList.get(getAdapterPosition()).get_id_menu_makanan(),
											token
									).enqueue(new Callback<Object>() {						  
										@Override
										public void onResponse(Call<Object> call, Response<Object> response) {
											((data_menu_makanan_activity_v2)activity).fetch_data_menu_makanan();
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

            linearEdit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Bundle bundle = new Bundle();

                    bundle.putString("id_menu_makanan", dataList.get(getAdapterPosition()).get_id_menu_makanan());
                    bundle.putString("nama", dataList.get(getAdapterPosition()).get_nama());
                    bundle.putString("id_kategori", dataList.get(getAdapterPosition()).get_id_kategori());
                    bundle.putString("jumlah", dataList.get(getAdapterPosition()).get_jumlah());
                    bundle.putString("harga", dataList.get(getAdapterPosition()).get_harga());
                    bundle.putString("foto", dataList.get(getAdapterPosition()).get_foto());
                    bundle.putString("keterangan", dataList.get(getAdapterPosition()).get_keterangan());
;

                    Intent intent = new Intent(activity, data_menu_makanan_edit.class);
                    intent.putExtras(bundle);
                    activity.startActivityForResult(intent, REQUEST_CODE_TAMBAH);
                }
            });

            linearBaris.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Bundle bundle = new Bundle();

                    bundle.putString("id_menu_makanan", dataList.get(getAdapterPosition()).get_id_menu_makanan());
					                    bundle.putString("nama", dataList.get(getAdapterPosition()).get_nama());
                    bundle.putString("id_kategori", dataList.get(getAdapterPosition()).get_id_kategori());
                    bundle.putString("jumlah", dataList.get(getAdapterPosition()).get_jumlah());
                    bundle.putString("harga", dataList.get(getAdapterPosition()).get_harga());
                    bundle.putString("foto", dataList.get(getAdapterPosition()).get_foto());
                    bundle.putString("keterangan", dataList.get(getAdapterPosition()).get_keterangan());


                    Intent intent = new Intent(activity, data_detail_pemesanan_tambah.class);
                    intent.putExtras(bundle);
                    activity.startActivityForResult(intent, REQUEST_CODE_TAMBAH);


                }
            });
        }
    }

    public void updateResults(ArrayList<data_menu_makanan_apidata> result) {
        dataList = result;
        notifyDataSetChanged();
    }
}
