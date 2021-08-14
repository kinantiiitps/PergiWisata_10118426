package com.kinantips.pergiwisata;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
/**
 13 Agustus 2021
 10118426
 Kinanti Trimutiara Putri Setiawan
 IF-10
 */
public class MainActivity extends AppCompatActivity {
    String[] daftar;
    ListView ListView01;
    Menu menu;
    protected Cursor cursor;
    //DataHelper dbcenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        BottomNavigationView bottomNavigation = findViewById(R.id.bottomNav);
        bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                Fragment fragment = null;

                //Menantukan halaman Fragment yang akan tampil
                switch (item.getItemId()){
                    case R.id.profileMenu:
                        Intent intent1 = new Intent(MainActivity.this,profile.class);
                        startActivity(intent1);
                        break;

                    case R.id.daftarMenu:
                        Intent intent2 = new Intent(MainActivity.this,daftar_wisata.class);
                        startActivity(intent2);
                        break;

                    case R.id.infoMenu:
                        Intent intent3 = new Intent(MainActivity.this,info.class);
                        startActivity(intent3);
                        break;
                }
                return true;
            }
        });
    }

    //Menampilkan halaman Fragment
    private boolean getFragmentPage(Fragment fragment){
        if (fragment != null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.pageContainer, fragment)
                    .commit();
            return true;
        } return false;
    }

}