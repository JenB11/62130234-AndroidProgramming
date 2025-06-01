package com.jenb.ntdat.appdoctruyen;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TruyenAdapter extends RecyclerView.Adapter<TruyenAdapter.TruyenViewHolder> {

    private Context context;
    private List<TruyenItem> truyenList;
    private OnItemClickListener listener;
    private String serverBaseUrl;


    public interface OnItemClickListener {
        void onItemClick(TruyenItem truyenItem);
    }
    public TruyenAdapter(Context context, List<TruyenItem> truyenList, OnItemClickListener listener , String serverBaseUrl) {
        this.context = context;
        this.truyenList = truyenList;
        this.listener = listener;
        this.serverBaseUrl = serverBaseUrl;
    }

    @NonNull
    @Override
    public TruyenViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_truyen, parent, false);
        return new TruyenViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TruyenViewHolder holder, int position) {
        TruyenItem truyen = truyenList.get(position);

        holder.txtTenTruyen.setText(truyen.getTitle());
        holder.txtChap.setText(truyen.getLastChapter());
        holder.txtTime.setText(" • " + truyen.getTime());
        String serverBaseUrl = "http://10.0.2.2:8080/";
        String imageUrl = serverBaseUrl + truyen.getThumbnailPath();
        Glide.with(context)
                .load(imageUrl)
                .placeholder(R.drawable.nen1)
                .into(holder.imgTruyen);

        holder.itemView.setOnClickListener(v -> {
            if (listener != null) {
                listener.onItemClick(truyen);
            }
        });
    }

    @Override
    public int getItemCount() {
        return truyenList.size();
    }

    public static class TruyenViewHolder extends RecyclerView.ViewHolder {

        ImageView imgTruyen;
        TextView txtTenTruyen, txtChap, txtTime;

        public TruyenViewHolder(@NonNull View itemView) {
            super(itemView);
            imgTruyen = itemView.findViewById(R.id.imgTruyen);
            txtTenTruyen = itemView.findViewById(R.id.txtTenTruyen);
            txtChap = itemView.findViewById(R.id.txtChap);
            txtTime = itemView.findViewById(R.id.txtTime);
        }

    }
}

