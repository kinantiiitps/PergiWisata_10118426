package com.kinantips.pergiwisata;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 14 Agustus 2021
 10118426
 Kinanti Trimutiara Putri Setiawan
 IF-10
 */
public class detail_wisata extends AppCompatActivity {
    ImageView imageDetail;
    TextView namaWisata, Alamat, Deskripsi, Htm, Jam;
    wisataModel wModel = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_wisata);

        imageDetail = findViewById(R.id.imgWisata);
        namaWisata = findViewById(R.id.txtNamaDetail);
        Alamat = findViewById(R.id.txtAlamatDetail);
        Deskripsi = findViewById(R.id.txtDeskripsiDetail);
        Htm = findViewById(R.id.txtHtmDetail);
        Jam = findViewById(R.id.txtJamDetail);

        final Object object = getIntent().getSerializableExtra("detailData");

        if(object instanceof wisataModel){
            wModel =(wisataModel) object;
        }

        if(wModel != null){
            Picasso.get().load(wModel.getImageWisata()).into(imageDetail);
            namaWisata.setText(wModel.getNamaWisata());
            Alamat.setText(wModel.getAlamat());
            Deskripsi.setText(wModel.getDeskripsi());
            Htm.setText(wModel.getHtm());
            Jam.setText(wModel.getJam());
        } else {
            namaWisata.setText("Kosong");
        }


    }
}