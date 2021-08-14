package com.kinantips.pergiwisata;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

/**
 13 Agustus 2021
 10118426
 Kinanti Trimutiara Putri Setiawan
 IF-10
 */
public class profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        BottomNavigationView bottomNavigation = findViewById(R.id.bottomNav);
        bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                Fragment fragment = null;

                //Menantukan halaman Fragment yang akan tampil
                switch (item.getItemId()){
                    case R.id.profileMenu:
                        Intent intent1 = new Intent(profile.this,profile.class);
                        startActivity(intent1);
                        break;

                    case R.id.daftarMenu:
                        Intent intent2 = new Intent(profile.this,daftar_wisata.class);
                        startActivity(intent2);
                        break;

                    case R.id.infoMenu:
                        Intent intent3 = new Intent(profile.this,info.class);
                        startActivity(intent3);
                        break;
                }
                return true;
            }
        });

    }

    public void pindahMenu(View view) {
        Button btn_pndhMenu = (Button) findViewById(R.id.btnProfile);
        String pndhMenu = btn_pndhMenu.getText().toString();
        Log.d("Main", "Nama : " + pndhMenu);
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}