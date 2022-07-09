package com.project.aplikasi.pemesanan_makanan.data_pemesanan;

import android.Manifest;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
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
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.project.aplikasi.pemesanan_makanan.R;
import com.project.aplikasi.pemesanan_makanan.config.config_global;
import com.project.aplikasi.pemesanan_makanan.data_detail_pemesanan.data_detail_pemesanan_activity_v2;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import static com.project.aplikasi.pemesanan_makanan.config.config_global.BASE_URL;

public class data_pemesanan_adapter_v2 extends RecyclerView.Adapter<data_pemesanan_adapter_v2.data_pemesanan_adapter_v2_view_holder> {
    private ArrayList<data_pemesanan_apidata> dataList;
    private Activity activity;

    public data_pemesanan_adapter_v2(ArrayList<data_pemesanan_apidata> dataList, Activity activity) {
        this.dataList = dataList;
        this.activity = activity;
    }

    @NonNull
    @Override
    public data_pemesanan_adapter_v2_view_holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.data_pemesanan_tampil_v2, parent, false);
        return new data_pemesanan_adapter_v2_view_holder(view);
    }

    @Override
    public void onBindViewHolder(data_pemesanan_adapter_v2_view_holder holder, int position) {
        
        //holder.nomor.setText(String.format("%d", position + 1));
        holder.id_pemesanan.setText(""+dataList.get(position).get_id_pemesanan());
		holder.id_pemesanan.setVisibility( View.GONE );
        holder.tanggal.setText(Html.fromHtml("Tanggal  : "+dataList.get(position).get_tanggal()+""));
        holder.id_pelanggan.setText(Html.fromHtml("Pelayan  : "+dataList.get(position).get_id_pelanggan()+""));
        holder.total_bayar.setText(Html.fromHtml("Total Bayar  : "+dataList.get(position).get_total_bayar()+""));
        holder.lat.setText(Html.fromHtml("Lat  : "+dataList.get(position).get_lat()+""));
        holder.lat.setVisibility(View.GONE);
        holder.lng.setText(Html.fromHtml("Lng  : "+dataList.get(position).get_lng()+""));
        holder.lng.setVisibility(View.GONE);
        holder.alamat_pengiriman.setText(Html.fromHtml("Nomor Meja  : "+dataList.get(position).get_alamat_pengiriman()+""));
        holder.status.setText(Html.fromHtml("Status  : "+dataList.get(position).get_status()+""));


        thumb(holder,BASE_URL +"api/data/image/list/gambar1.png",false);
        edit(holder,"Edit",false);
        hapus(holder,"Hapus",false);
    }

     private void thumb(data_pemesanan_adapter_v2_view_holder holder,String url_gambar,Boolean visible)
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

    private void edit(data_pemesanan_adapter_v2_view_holder holder,String nama_tombol,Boolean visible)
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

    private void hapus(data_pemesanan_adapter_v2_view_holder holder,String nama_tombol,Boolean visible)
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

    public class data_pemesanan_adapter_v2_view_holder extends RecyclerView.ViewHolder {
        TextView id_pemesanan
        ,tanggal
        ,id_pelanggan
        ,total_bayar
        ,lat
        ,lng
        ,alamat_pengiriman
        ,status

				,nomor;
        TextView tombol_edit,tombol_hapus;
        private LinearLayout linearNomor;
        LinearLayout linearEdit, linearHapus,linearBaris;
        protected int REQUEST_CODE_TAMBAH = 3543;
        ImageView image;
        private ImageView detail,telepon,map,wa;


        public data_pemesanan_adapter_v2_view_holder(final View itemView) {
            super(itemView);
            linearNomor = (LinearLayout) itemView.findViewById(R.id.linearNomor);
            id_pemesanan = (TextView) itemView.findViewById(R.id.id_pemesanan);
            tanggal = (TextView) itemView.findViewById(R.id.tanggal);
            id_pelanggan = (TextView) itemView.findViewById(R.id.id_pelanggan);
            total_bayar = (TextView) itemView.findViewById(R.id.total_bayar);
            lat = (TextView) itemView.findViewById(R.id.lat);
            lng = (TextView) itemView.findViewById(R.id.lng);
            alamat_pengiriman = (TextView) itemView.findViewById(R.id.alamat_pengiriman);
            status = (TextView) itemView.findViewById(R.id.status);

            nomor = (TextView) itemView.findViewById(R.id.txt_nomor);
            linearEdit = (LinearLayout) itemView.findViewById(R.id.linearEdit);
            tombol_edit = (TextView) itemView.findViewById(R.id.tombol_edit);
            linearHapus = (LinearLayout) itemView.findViewById(R.id.linearHapus);
            tombol_hapus = (TextView) itemView.findViewById(R.id.tombol_hapus);  
            linearBaris = (LinearLayout) itemView.findViewById(R.id.linearBaris);
            image = (ImageView) itemView.findViewById(R.id.img);

            detail = (ImageView)  itemView.findViewById(R.id.detail );
            map = (ImageView)  itemView.findViewById(R.id.map );
            wa = (ImageView)  itemView.findViewById(R.id.wa );
            telepon = (ImageView)  itemView.findViewById(R.id.telepon );

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
                                    data_pemesanan_apiservice mAPIService = 
									data_pemesanan_apiutils.getAPIService();
									String token = "Bearer " + new config_global().ambil(activity);
									Log.d("POSITION", Integer.toString(getAdapterPosition()));
									mAPIService.proses_hapus_data_pemesanan(
											dataList.get(getAdapterPosition()).get_id_pemesanan(),
											token
									).enqueue(new Callback<Object>() {						  
										@Override
										public void onResponse(Call<Object> call, Response<Object> response) {
											((data_pemesanan_activity_v2)activity).fetch_data_pemesanan();
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

                    bundle.putString("id_pemesanan", dataList.get(getAdapterPosition()).get_id_pemesanan());
                    bundle.putString("tanggal", dataList.get(getAdapterPosition()).get_tanggal());
                    bundle.putString("id_pelanggan", dataList.get(getAdapterPosition()).get_id_pelanggan());
                    bundle.putString("total_bayar", dataList.get(getAdapterPosition()).get_total_bayar());
                    bundle.putString("lat", dataList.get(getAdapterPosition()).get_lat());
                    bundle.putString("lng", dataList.get(getAdapterPosition()).get_lng());
                    bundle.putString("alamat_pengiriman", dataList.get(getAdapterPosition()).get_alamat_pengiriman());
                    bundle.putString("status", dataList.get(getAdapterPosition()).get_status());
;

                    Intent intent = new Intent(activity, data_pemesanan_edit.class);
                    intent.putExtras(bundle);
                    activity.startActivityForResult(intent, REQUEST_CODE_TAMBAH);
                }
            });

            if (data_pemesanan_activity_v2.tokennya.equals("admin"))
            {

                detail.setVisibility(View.VISIBLE);
                wa.setVisibility(View.VISIBLE);
                telepon.setVisibility(View.VISIBLE);
                map.setVisibility(View.VISIBLE);
            }
            else
            {

                linearBaris.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Bundle bundle = new Bundle();

                        bundle.putString("id_pemesanan", dataList.get(getAdapterPosition()).get_id_pemesanan());
                        bundle.putString("tanggal", dataList.get(getAdapterPosition()).get_tanggal());
                        bundle.putString("id_pelanggan", dataList.get(getAdapterPosition()).get_id_pelanggan());
                        bundle.putString("total_bayar", dataList.get(getAdapterPosition()).get_total_bayar());
                        bundle.putString("Koordinat", dataList.get(getAdapterPosition()).get_lat());
                        bundle.putString("Telepon", dataList.get(getAdapterPosition()).get_lng());
                        bundle.putString("alamat_pengiriman", dataList.get(getAdapterPosition()).get_alamat_pengiriman());
                        bundle.putString("status", dataList.get(getAdapterPosition()).get_status());
                        Intent intent = new Intent( activity,
                                data_detail_pemesanan_activity_v2.class);
                        intent.putExtra("id_pemesanan", dataList.get(getAdapterPosition()).get_id_pemesanan());
                        activity.startActivityForResult(intent, REQUEST_CODE_TAMBAH);

                    }
                });


                detail.setVisibility(View.GONE);
                wa.setVisibility(View.GONE);
                telepon.setVisibility(View.GONE);
                map.setVisibility(View.GONE);
            }

            detail.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Bundle bundle = new Bundle();

                    bundle.putString("id_pemesanan", dataList.get(getAdapterPosition()).get_id_pemesanan());
					                    bundle.putString("tanggal", dataList.get(getAdapterPosition()).get_tanggal());
                    bundle.putString("id_pelanggan", dataList.get(getAdapterPosition()).get_id_pelanggan());
                    bundle.putString("total_bayar", dataList.get(getAdapterPosition()).get_total_bayar());
                    bundle.putString("Koordinat", dataList.get(getAdapterPosition()).get_lat());
                    bundle.putString("Telepon", dataList.get(getAdapterPosition()).get_lng());
                    bundle.putString("alamat_pengiriman", dataList.get(getAdapterPosition()).get_alamat_pengiriman());
                    bundle.putString("status", dataList.get(getAdapterPosition()).get_status());
                    Intent intent = new Intent( activity,
                            data_detail_pemesanan_activity_v2.class);
                    intent.putExtra("id_pemesanan", dataList.get(getAdapterPosition()).get_id_pemesanan());
                    activity.startActivityForResult(intent, REQUEST_CODE_TAMBAH);

                }
            });


            telepon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intentCall = new Intent(Intent.ACTION_CALL);
                    intentCall.setData(Uri.parse("tel:" +  dataList.get(getAdapterPosition()).get_lng()));
                    if (ContextCompat.checkSelfPermission(activity,
                            Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {

                        ActivityCompat.requestPermissions(activity,
                                new String[]{Manifest.permission.CALL_PHONE}, 234);
                    } else {

                        activity.startActivity(intentCall);
                    }

                }
            });

            map.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    String uri = "http://maps.google.com/maps?daddr=" + dataList.get(getAdapterPosition()).get_lat();
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                    intent.setPackage("com.google.android.apps.maps");
                    activity.startActivity(intent);

                }
            });

            wa.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    String tlp =dataList.get(getAdapterPosition()).get_lng();
                    tlp = tlp.replace("085","6285");

                    String url = "https://api.whatsapp.com/send?phone=" +  tlp ;
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    activity.startActivity(i);

                }
            });




        }
    }

    public void updateResults(ArrayList<data_pemesanan_apidata> result) {
        dataList = result;
        notifyDataSetChanged();
    }
}
