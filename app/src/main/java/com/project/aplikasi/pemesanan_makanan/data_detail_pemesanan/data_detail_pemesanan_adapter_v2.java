package com.project.aplikasi.pemesanan_makanan.data_detail_pemesanan;

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
import com.squareup.picasso.Picasso;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import static com.project.aplikasi.pemesanan_makanan.config.config_global.BASE_URL;

public class data_detail_pemesanan_adapter_v2 extends RecyclerView.Adapter<data_detail_pemesanan_adapter_v2.data_detail_pemesanan_adapter_v2_view_holder> {
    private ArrayList<data_detail_pemesanan_apidata> dataList;
    private Activity activity;

    public data_detail_pemesanan_adapter_v2(ArrayList<data_detail_pemesanan_apidata> dataList, Activity activity) {
        this.dataList = dataList;
        this.activity = activity;
    }

    @NonNull
    @Override
    public data_detail_pemesanan_adapter_v2_view_holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.data_detail_pemesanan_tampil_v2, parent, false);
        return new data_detail_pemesanan_adapter_v2_view_holder(view);
    }

    @Override
    public void onBindViewHolder(data_detail_pemesanan_adapter_v2_view_holder holder, int position) {
        
        //holder.nomor.setText(String.format("%d", position + 1));
        holder.id_detail_pemesanan.setText(""+dataList.get(position).get_id_detail_pemesanan());
		holder.id_detail_pemesanan.setVisibility( View.GONE );
        holder.id_pemesanan.setText(Html.fromHtml("Pemesanan  : "+dataList.get(position).get_id_pemesanan()+""));
        holder.id_pemesanan.setVisibility(View.GONE);
        holder.id_menu_makanan.setText(Html.fromHtml("<b>"+dataList.get(position).get_id_menu_makanan()+"</b>"));
        holder.jumlah.setText(Html.fromHtml(""+dataList.get(position).get_jumlah()+""));
        holder.harga.setText(Html.fromHtml(""+dataList.get(position).get_harga()+""));




        if (dataList.get(position).get_id_detail_pemesanan().equals("total"))
        {
            hapus(holder,"Hapus",false);
            thumb(holder,BASE_URL +"/admin/upload/" + dataList.get(position).get_id_detail_pemesanan(),false);
        }
        else if (dataList.get(position).get_id_detail_pemesanan().equals("detail"))
        {
            hapus(holder,"Hapus",false);
            thumb(holder,BASE_URL +"/admin/upload/" + dataList.get(position).get_id_pemesanan(),true);

        }
        else
        {
            hapus(holder,"Hapus",true);
            thumb(holder,BASE_URL +"/admin/upload/" + dataList.get(position).get_id_detail_pemesanan(),true);
        }

        edit(holder,"Edit",false);

    }

     private void thumb(data_detail_pemesanan_adapter_v2_view_holder holder,String url_gambar,Boolean visible)
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

    private void edit(data_detail_pemesanan_adapter_v2_view_holder holder,String nama_tombol,Boolean visible)
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

    private void hapus(data_detail_pemesanan_adapter_v2_view_holder holder,String nama_tombol,Boolean visible)
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

    public class data_detail_pemesanan_adapter_v2_view_holder extends RecyclerView.ViewHolder {
        TextView id_detail_pemesanan
        ,id_pemesanan
        ,id_menu_makanan
        ,jumlah
        ,harga

				,nomor;
        TextView tombol_edit,tombol_hapus;
        private LinearLayout linearNomor;
        LinearLayout linearEdit, linearHapus,linearBaris;
        protected int REQUEST_CODE_TAMBAH = 3543;
        ImageView image;


        public data_detail_pemesanan_adapter_v2_view_holder(final View itemView) {
            super(itemView);
            linearNomor = (LinearLayout) itemView.findViewById(R.id.linearNomor);
            id_detail_pemesanan = (TextView) itemView.findViewById(R.id.id_detail_pemesanan);
            id_pemesanan = (TextView) itemView.findViewById(R.id.id_pemesanan);
            id_menu_makanan = (TextView) itemView.findViewById(R.id.id_menu_makanan);
            jumlah = (TextView) itemView.findViewById(R.id.jumlah);
            harga = (TextView) itemView.findViewById(R.id.harga);

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
                                    data_detail_pemesanan_apiservice mAPIService = 
									data_detail_pemesanan_apiutils.getAPIService();
									String token = "Bearer " + new config_global().ambil(activity);
									Log.d("POSITION", Integer.toString(getAdapterPosition()));
									mAPIService.proses_hapus_data_detail_pemesanan(
											dataList.get(getAdapterPosition()).get_id_detail_pemesanan(),
											token
									).enqueue(new Callback<Object>() {						  
										@Override
										public void onResponse(Call<Object> call, Response<Object> response) {
											((data_detail_pemesanan_activity_v2)activity).fetch_data_detail_pemesanan();
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

                    bundle.putString("id_detail_pemesanan", dataList.get(getAdapterPosition()).get_id_detail_pemesanan());
                    bundle.putString("id_pemesanan", dataList.get(getAdapterPosition()).get_id_pemesanan());
                    bundle.putString("id_menu_makanan", dataList.get(getAdapterPosition()).get_id_menu_makanan());
                    bundle.putString("jumlah", dataList.get(getAdapterPosition()).get_jumlah());
                    bundle.putString("harga", dataList.get(getAdapterPosition()).get_harga());
;

                    Intent intent = new Intent(activity, data_detail_pemesanan_edit.class);
                    intent.putExtras(bundle);
                    activity.startActivityForResult(intent, REQUEST_CODE_TAMBAH);
                }
            });

            linearBaris.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Bundle bundle = new Bundle();

                    bundle.putString("id_detail_pemesanan", dataList.get(getAdapterPosition()).get_id_detail_pemesanan());
					                    bundle.putString("id_pemesanan", dataList.get(getAdapterPosition()).get_id_pemesanan());
                    bundle.putString("id_menu_makanan", dataList.get(getAdapterPosition()).get_id_menu_makanan());
                    bundle.putString("jumlah", dataList.get(getAdapterPosition()).get_jumlah());
                    bundle.putString("harga", dataList.get(getAdapterPosition()).get_harga());
;

                }
            });
        }
    }

    public void updateResults(ArrayList<data_detail_pemesanan_apidata> result) {
        dataList = result;
        notifyDataSetChanged();
    }
}
