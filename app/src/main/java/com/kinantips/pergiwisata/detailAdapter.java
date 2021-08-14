package com.kinantips.pergiwisata;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class detailAdapter extends RecyclerView.Adapter<detailAdapter.ViewHolder> {

    Context context;
    List<detailModel> detailModelList;
    detailAdapter.onSelectData selectData;

    public interface onSelectData {
        void onSelected(detailModel dModel);
    }

    public detailAdapter(Context context, List<detailModel> detailModelList, onSelectData selectData) {
        this.context = context;
        this.detailModelList = detailModelList;
        this.selectData = selectData;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_detail,parent,false);
        return new ViewHolder(v);
    }



    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final detailModel data = detailModelList.get(position);

        Picasso.get().load(data.getImageWisata()).into(holder.imageDetail);
        holder.namaWisata.setText(data.getNamaWisata());
        holder.Alamat.setText(data.getAlamat());
        holder.Deskripsi.setText(data.getDeskripsi());
        holder.Htm.setText(data.getHtm());
        holder.Jam.setText(data.getJam());
        holder.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        holder.cvItemDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectData.onSelected(data);
            }
        });
    }

    @Override
    public int getItemCount() {
        return 0;
    }





    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageDetail;
        TextView namaWisata, Alamat, Deskripsi, Htm, Jam;
        CardView cvItemDetail;
        Button btn;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            cvItemDetail = (CardView) itemView.findViewById(R.id.cvItemDetail);
            imageDetail = itemView.findViewById(R.id.imgWisata);
            namaWisata = itemView.findViewById(R.id.txtNamaDetail);
            Alamat = itemView.findViewById(R.id.txtAlamatDetail);
            Deskripsi = itemView.findViewById(R.id.txtDeskripsiDetail);
            Htm = itemView.findViewById(R.id.txtHtmDetail);
            Jam = itemView.findViewById(R.id.txtJamDetail);
            btn = itemView.findViewById(R.id.btnMaps);

        }
    }
}
