package com.kinantips.pergiwisata;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class info extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        BottomNavigationView bottomNavigation = findViewById(R.id.bottomNav);
        bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                Fragment fragment = null;

                //Menantukan halaman Fragment yang akan tampil
                switch (item.getItemId()){
                    case R.id.profileMenu:
                        Intent intent1 = new Intent(info.this,profile.class);
                        startActivity(intent1);
                        break;

                    case R.id.daftarMenu:
                        Intent intent2 = new Intent(info.this,daftar_wisata.class);
                        startActivity(intent2);
                        break;

                    case R.id.infoMenu:
                        Intent intent3 = new Intent(info.this,info.class);
                        startActivity(intent3);
                        break;
                }
                return true;
            }
        });
    }
}