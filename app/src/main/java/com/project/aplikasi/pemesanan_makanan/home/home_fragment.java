package com.project.aplikasi.pemesanan_makanan.home;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.gridlayout.widget.GridLayout;
import android.widget.TextView;
import com.project.aplikasi.pemesanan_makanan.config.config_global;
import com.project.aplikasi.pemesanan_makanan.config.config_sessionmanager;

import com.project.aplikasi.pemesanan_makanan.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class home_fragment extends Fragment {

    TextView judul_a,judul_b,menu_pesanan;
    GridLayout menu_awal;

    public home_fragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.home_fragment, container, false);

        config_sessionmanager config_sessionmanager;
        config_sessionmanager = new config_sessionmanager(getActivity());
        String id_pelanggan = config_sessionmanager.getSPId();

        judul_a = (TextView) v.findViewById(R.id.a) ;
        judul_b = (TextView) v.findViewById(R.id.b) ;
        menu_pesanan = (TextView) v.findViewById(R.id.menu_pesanan) ;
        menu_awal = (GridLayout) v.findViewById(R.id.menu_awal) ;


		judul_a.setText("Assalamu'alaikum");
        judul_b.setText(new config_global().capitalize(config_sessionmanager.getSPNama()));

        if (config_sessionmanager.getSPId().equals("admin"))
        {
            menu_awal.setVisibility(View.GONE);
            menu_pesanan.setText("Pesanan");
        }
        else
        {
            menu_awal.setVisibility(View.VISIBLE);
            menu_pesanan.setText("Riwayat Pesanan");
        }

        return v;
    }



}
