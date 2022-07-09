package com.project.aplikasi.pemesanan_makanan.data_pelanggan_sqlite;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.project.aplikasi.pemesanan_makanan.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class data_pelanggan_sqlite_activity extends AppCompatActivity {

    private RecyclerView data_pelanggan_tampil;
    RecyclerView.LayoutManager layoutManager;
    private data_pelanggan_sqlite_adapter adapter;
    private data_pelanggan_sqlite_dbhandler dbHandler;
    private List<data_pelanggan_sqlite_data> datalist = new ArrayList<>();
    Button tombol_tambah,tombol_refresh,tombol_cari ;
    protected int REQUEST_CODE_TAMBAH = 3543;
    protected int REQUEST_CODE_EDIT = 3544;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data_pelanggan_activity_v2);

        tombol_tambah = (Button) findViewById(R.id.tombol_tambah);
        tombol_refresh = (Button) findViewById(R.id.tombol_refresh);
        tombol_cari = (Button) findViewById(R.id.tombol_cari);

        data_pelanggan_tampil = (RecyclerView) findViewById(R.id.data_pelanggan_tampil);
        data_pelanggan_tampil.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(data_pelanggan_sqlite_activity.this);
        data_pelanggan_tampil.setLayoutManager(layoutManager);
        fetch_data_pelanggan_sqlite();

        tombol_tambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Tambah
                Intent intent = new Intent( data_pelanggan_sqlite_activity.this, data_pelanggan_sqlite_tambah.class);
                startActivityForResult(intent, REQUEST_CODE_TAMBAH);
            }
        });

        tombol_refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Refresh
                fetch_data_pelanggan_sqlite();
                Toast.makeText(data_pelanggan_sqlite_activity.this, "Data Berhasil Diperbarui",
                        Toast.LENGTH_SHORT).show();
            }
        });

        tombol_cari.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Cari
                DialogPencarian();
            }
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_TAMBAH){
            if (resultCode == RESULT_OK){
                fetch_data_pelanggan_sqlite();
            }
        }
    }

    public void fetch_data_pelanggan_sqlite(){
        dbHandler = new data_pelanggan_sqlite_dbhandler( data_pelanggan_sqlite_activity.this);
        datalist = dbHandler.get_semua_data_pelanggan_sqlite();
        adapter = new data_pelanggan_sqlite_adapter(data_pelanggan_sqlite_activity.this, datalist );
        data_pelanggan_tampil.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        if (adapter.getItemCount() == 0){

            data_pelanggan_tampil.setVisibility(View.GONE);
        } else {

            data_pelanggan_tampil.setVisibility(View.VISIBLE);
            data_pelanggan_tampil.addOnItemTouchListener(
                    new data_pelanggan_sqlite_recyclerclick(getApplicationContext(), new data_pelanggan_sqlite_recyclerclick.OnItemClickListener() {
                        @Override public void onItemClick(View view, int position) {
                            data_pelanggan_sqlite_data mhs = datalist.get(position);

                        }
                    })
            );


        }
    }

    AlertDialog.Builder dialog;
    LayoutInflater inflater;
    View dialogView;
    Spinner spinnerPencarian;
    private DatePickerDialog datePickerDialog;
    private SimpleDateFormat dateFormatter;
    private TextView tvDateResult;
    private Button btDatePicker;
    private TextView tvDateResult1;
    private Button btDatePicker1;
    private EditText editPencarian;
    private String[] spinnerArray = {
            ""
            ,"id_pelanggan"
            ,"nama"
            ,"alamat"
            ,"no_telepon"
            ,"username"
            ,"password"

    };
     private void DialogPencarian() {
        dialog = new AlertDialog.Builder(data_pelanggan_sqlite_activity.this);
        inflater = getLayoutInflater();
        dialogView = inflater.inflate(R.layout.data_pelanggan_pencarian, null);
        dateFormatter = new SimpleDateFormat("dd-MM-yyyy", Locale.US);
        dialog.setView(dialogView);
        dialog.setCancelable(false);
        editPencarian = (EditText) dialogView.findViewById(R.id.editPencarian);

        final ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_dropdown_item_1line, spinnerArray);


        spinnerPencarian = (Spinner) dialogView.findViewById(R.id.spinnerPencarian);
        spinnerPencarian.setAdapter(adapter);

        tvDateResult = (TextView) dialogView.findViewById(R.id.tv_dateresult);
        tvDateResult1 = (TextView) dialogView.findViewById(R.id.tv_dateresult1);
        btDatePicker = (Button) dialogView.findViewById(R.id.bt_datepicker);
        btDatePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar newCalendar = Calendar.getInstance();
                datePickerDialog = new DatePickerDialog(data_pelanggan_sqlite_activity.this,
                    new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        Calendar newDate = Calendar.getInstance();
                        newDate.set(year, monthOfYear, dayOfMonth);
                        tvDateResult.setText(dateFormatter.format(newDate.getTime()));
                    }

                },newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

                datePickerDialog.show();
            }
        });

        btDatePicker1 = (Button) dialogView.findViewById(R.id.bt_datepicker1);
        btDatePicker1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar newCalendar = Calendar.getInstance();
                datePickerDialog = new DatePickerDialog(data_pelanggan_sqlite_activity.this,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                Calendar newDate = Calendar.getInstance();
                                newDate.set(year, monthOfYear, dayOfMonth);
                                tvDateResult1.setText(dateFormatter.format(newDate.getTime()));
                            }

                        },newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

                datePickerDialog.show();
            }
        });

        dialog.setPositiveButton("Cari", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                fetch_cari();
                dialog.dismiss();
            }
        });

        dialog.setNegativeButton("Batal", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }

    private void fetch_cari()
    {
        String berdasarkan = spinnerPencarian.getSelectedItem().toString();
        String isi = editPencarian.getText().toString();
        int limit = 7;
        int halaman = 1;
        String tanggal1 = tvDateResult.getText().toString();
        String tanggal2 = tvDateResult1.getText().toString();

        dbHandler = new data_pelanggan_sqlite_dbhandler( data_pelanggan_sqlite_activity.this);
        datalist = dbHandler.get_data_pelanggan_sqlite(berdasarkan,isi,tanggal1,tanggal2,limit,halaman);
        adapter = new data_pelanggan_sqlite_adapter(data_pelanggan_sqlite_activity.this, datalist );
        data_pelanggan_tampil.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }



}


