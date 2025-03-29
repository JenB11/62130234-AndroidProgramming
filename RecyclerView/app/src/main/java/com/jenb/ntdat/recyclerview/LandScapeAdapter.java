package com.jenb.ntdat.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class LandScapeAdapter extends RecyclerView.Adapter<LandScapeAdapter.ItemLandHolder> {

    Context context;
    ArrayList<LandScape> lstData;
    public LandScapeAdapter(Context context, ArrayList<LandScape> lstData) {
        this.context = context;
        this.lstData = lstData;
    }

    @NonNull
    @Override
    public ItemLandHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View viewItem = inflater.inflate(R.layout.item_land, parent, false);
        ItemLandHolder viewholder = new ItemLandHolder(viewItem);
        return viewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemLandHolder holder, int position) {

        LandScape landScapeHienThi = lstData.get(position);

        String tenFileAnh = landScapeHienThi.getLandImageFileName();
        String caption = landScapeHienThi.getLandCation();

        holder.tvCaption.setText(caption);

            String pakageName = holder.itemView.getContext().getPackageName();
            int imgId = holder.itemView.getResources().getIdentifier(tenFileAnh, "mipmap", pakageName);
        holder.ivLandScape.setImageResource(imgId);
    }

    @Override
    public int getItemCount() {
        return lstData.size();
    }

    class ItemLandHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView tvCaption;
        ImageView ivLandScape;

        public ItemLandHolder(@NonNull View itemView) {
            super(itemView);
            tvCaption = itemView.findViewById(R.id.tvCaption);
            ivLandScape = itemView.findViewById(R.id.ivLandScape);

            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {

            int position = getAdapterPosition();
            LandScape landScapeHienThi = lstData.get(position);
            String tenFileAnh = landScapeHienThi.getLandImageFileName();
            String caption = landScapeHienThi.getLandCation();
            String thongbao = "Ban vua click vao " + caption;
            Toast.makeText(view.getContext(), thongbao, Toast.LENGTH_SHORT).show();
        }
    }

}
