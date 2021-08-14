package com.kinantips.pergiwisata;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;

import java.util.ArrayList;
import java.util.List;

/**
 14 Agustus 2021
 10118426
 Kinanti Trimutiara Putri Setiawan
 IF-10
 */
public class daftar_wisata extends AppCompatActivity implements wisataAdapter.onSelectData {
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    FirebaseStorage firebaseStorage;
    RecyclerView recyclerView;
    wisataAdapter wAdapter;
    List<wisataModel> wModelList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar_wisata);

        BottomNavigationView bottomNavigation = findViewById(R.id.bottomNav);
        bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                Fragment fragment = null;

                //Menantukan halaman Fragment yang akan tampil
                switch (item.getItemId()){
                    case R.id.profileMenu:
                        Intent intent1 = new Intent(daftar_wisata.this,profile.class);
                        startActivity(intent1);
                        break;

                    case R.id.daftarMenu:
                        Intent intent2 = new Intent(daftar_wisata.this,daftar_wisata.class);
                        startActivity(intent2);
                        break;

                    case R.id.infoMenu:
                        Intent intent3 = new Intent(daftar_wisata.this,info.class);
                        startActivity(intent3);
                        break;
                }
                return true;
            }
        });

        firebaseDatabase = FirebaseDatabase.getInstance("https://fir-pergi-wisata-default-rtdb.asia-southeast1.firebasedatabase.app");
        databaseReference = firebaseDatabase.getReference("Wisata");
        firebaseStorage = FirebaseStorage.getInstance();
        recyclerView = findViewById(R.id.wisataList);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        wModelList = new ArrayList<wisataModel>();
        wAdapter = new wisataAdapter(this,wModelList,this);
        recyclerView.setAdapter(wAdapter);

        databaseReference.addValueEventListener(new ValueEventListener() {
            /*@Override
            public void onDataAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                wisataModel wModel = snapshot.getValue(wisataModel.class);
                wModelList.add(wModel);
                wAdapter.notifyDataSetChanged();

            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }*/

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot : snapshot.getChildren()){
                    wisataModel upload = dataSnapshot.getValue(wisataModel.class);
                    wModelList.add(upload);
                }

                //wAdapter = new wisataAdapter(daftar_wisata.this, wModelList);
                wAdapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(daftar_wisata.this, error.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public void onSelected(wisataModel wModel) {
        Intent intent = new Intent(daftar_wisata.this,detail_wisata.class);
        intent.putExtra("detailData", wModel);
        startActivity(intent);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == android.R.id.home){
        finish();
        return true;
        }
        return super.onOptionsItemSelected(item);
    }
}