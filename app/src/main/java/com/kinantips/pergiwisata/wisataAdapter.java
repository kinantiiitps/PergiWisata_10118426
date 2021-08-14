package com.kinantips.pergiwisata;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class wisataAdapter extends RecyclerView.Adapter<wisataAdapter.ViewHolder> {

    Context context;
    List<wisataModel> wisataModelList;
    wisataAdapter.onSelectData onSelectData;

    public interface onSelectData {
        void onSelected(wisataModel wModel);
    }

    public wisataAdapter(Context context, List<wisataModel> wisataModelList, wisataAdapter.onSelectData selectData) {
        this.context = context;
        this.wisataModelList = wisataModelList;
        this.onSelectData = selectData;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        wisataModel wisataModel = wisataModelList.get(position);
        holder.txtNamaWisata.setText("" + wisataModel.getNamaWisata());
        holder.txtHtm.setText("" + wisataModel.getHtm());
        holder.txtDesc.setText("" + wisataModel.getDeskripsi());
        holder.txtAlamat.setText("Alamat : " + wisataModel.getAlamat());
        holder.txtJam.setText("Jam Buka : " + wisataModel.getJam());
        holder.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onSelectData.onSelected(wisataModel);
            }
        });

        String imageUri = null;
        imageUri = wisataModel.getImageWisata();
        Picasso.get().load(imageUri).into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return wisataModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView txtNamaWisata,txtHtm,txtDesc,txtAlamat,txtJam;
        Button btn;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imgWisata);
            txtNamaWisata = itemView.findViewById(R.id.txtWisata);
            txtHtm = itemView.findViewById(R.id.txtHtm);
            txtDesc = itemView.findViewById(R.id.txtDesc);
            txtAlamat = itemView.findViewById(R.id.txtAlamat);
            txtJam = itemView.findViewById(R.id.txtJam);
            btn = itemView.findViewById(R.id.btnMaps);

        }
    }
}
