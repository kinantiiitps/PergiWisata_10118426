package com.kinantips.pergiwisata;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
/**
 12 Agustus 2021
 10118426
 Kinanti Trimutiara Putri Setiawan
 IF-10
 */
public class walkthrough extends AppCompatActivity {

    ViewPager viewPager;
    LinearLayout layoutTitik;

    slider_adapter slider_adapter;
    TextView[] titik;

    Button cobain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_walkthrough);

        //hooks
        viewPager = findViewById(R.id.slider);
        layoutTitik = findViewById(R.id.titik);
        cobain = findViewById(R.id.btnWalkthrough);

        //panggil adapter
        slider_adapter= new slider_adapter(this);
        viewPager.setAdapter(slider_adapter);

        addTitik(0);
        viewPager.addOnPageChangeListener(changeListener);
    }

    private void addTitik(int position){
        titik = new TextView[3];
        layoutTitik.removeAllViews();

        for(int i=0; i<titik.length; i++){
            titik[i] = new TextView(this);
            titik[i].setText(Html.fromHtml("&#8226;"));
            titik[i].setTextSize(35);

            layoutTitik.addView(titik[i]);
        }

        if(titik.length > 0){
            titik[position].setTextColor(getResources().getColor(R.color.base));
        }

    }

    ViewPager.OnPageChangeListener changeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            addTitik(position);

            if(position == 0){
                cobain.setVisibility(View.INVISIBLE);

            } else if (position == 1) {
                cobain.setVisibility(View.INVISIBLE);
            } else {
                cobain.setVisibility(View.VISIBLE);

            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    public void pindahProfil(View view) {
        Button btn_pndhProfil = (Button) findViewById(R.id.btnWalkthrough);
        String pndhProfil = btn_pndhProfil.getText().toString();
        Log.d("Main", "Nama : " + pndhProfil);
        Intent intent = new Intent(this, profile.class);
        startActivity(intent);
    }
}