package com.project.aplikasi.pemesanan_makanan.combobox_data_kategori;

import android.app.Activity;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class combobox_data_kategori {
    private Spinner spinner;
    private Activity activity;
    private List<String> comboItems = new ArrayList<String>();
    private ArrayAdapter<String> adapter;

    public combobox_data_kategori(Spinner spinner, Activity activity) {
        this.spinner = spinner;
        this.activity = activity;

        adapter = new ArrayAdapter<>(activity,
                android.R.layout.simple_dropdown_item_1line, comboItems);
        spinner.setAdapter(adapter);
    }

    public List<String> getComboItems() {
        return comboItems;
    }

    public void setComboItems(List<String> comboItems) {
        this.comboItems = comboItems;
        this.adapter.notifyDataSetChanged();
    }

    public void add(String item){
        comboItems.add(item);
        adapter.notifyDataSetChanged();
    }

    public void clearAll(){
        comboItems.clear();
        adapter.notifyDataSetChanged();
    }
}


//Combobox
   /* private Spinner combobox_data_kategori_spinner;
    private combobox_data_kategori combobox_data_kategori;
    private combobox_data_kategori_apiservice combobox_data_kategori_mAPIService;
    private List<combobox_data_kategori_apidata> combobox_data_kategori_data;
    public void tampil_combobox_data_kategori()
    {
        data_kategori.setVisibility(View.GONE);
        combobox_data_kategori_spinner = (Spinner) findViewById(R.id.combo_data_kategori);
        combobox_data_kategori = new combobox_data_kategori(combobox_data_kategori_spinner, this);
        combobox_data_kategori_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                //Toast.makeText(detail_rencana_pemeliharaan_tambah.this, "Selected "+ combobox_data_kategori_data.get(i).getNama() + " ", Toast.LENGTH_SHORT).show();
                if (i == 0)
                {
                    data_kategori.setText("");
                }
                else {
                    data_kategori.setText(combobox_data_kategori_data.get(i).getId());
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        combobox_data_kategori_mAPIService = combobox_data_kategori_apiutils.getAPIService();
        combobox_data_kategori_mAPIService.api().enqueue(new Callback<combobox_data_kategori_api>() {
            @Override
            public void onResponse(Call<combobox_data_kategori_api> call, Response<combobox_data_kategori_api> response) {
                if (response.code() == 200){
                    if (response.body() != null) {
                        combobox_data_kategori.clearAll();
                        combobox_data_kategori_data = response.body().getComboBoxApiData();
                        for (int i=0; i < combobox_data_kategori_data.size(); i++){
                            combobox_data_kategori.add(combobox_data_kategori_data.get(i).getNama());
                        }
                    }

                }
            }

            @Override
            public void onFailure(Call<combobox_data_kategori_api> call, Throwable t) {

            }
        });
    }

*/
