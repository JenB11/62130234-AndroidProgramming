package com.jenb.ntdat.appdoctruyen;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TruyenAdapter extends RecyclerView.Adapter<TruyenAdapter.TruyenViewHolder> {

    private Context context;
    private List<TruyenItem> truyenList;
    private AdapterView.OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(Truyen truyen);
    }
    public TruyenAdapter(Context context, List<TruyenItem> truyenList) {
        this.context = context;
        this.truyenList = truyenList;
        this.listener = listener;
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

        Glide.with(context)
                .load(truyen.getThumbnailUrl())
                .placeholder(R.drawable.nen1)
                .into(holder.imgTruyen);

        // Badge "NEW" nếu thời gian chứa từ "phút", "giờ", "vài giây", hoặc dưới 1 ngày
        String timeStr = truyen.getTime().toLowerCase();
        if (timeStr.contains("phút") || timeStr.contains("giờ") || timeStr.contains("giây") || timeStr.contains("hôm nay")) {
            holder.badgeNew.setVisibility(View.VISIBLE);
        } else {
            holder.badgeNew.setVisibility(View.GONE);
        }

        // Bắt sự kiện click mở chi tiết
        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, ChiTietTruyen.class);
            intent.putExtra("truyen_url", truyen.getThumbnailUrl());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return truyenList.size();
    }

    public static class TruyenViewHolder extends RecyclerView.ViewHolder {

        ImageView imgTruyen;
        TextView txtTenTruyen, txtChap, txtTime, badgeFull, badgeNew;

        public TruyenViewHolder(@NonNull View itemView) {
            super(itemView);
            imgTruyen = itemView.findViewById(R.id.imgTruyen);
            txtTenTruyen = itemView.findViewById(R.id.txtTenTruyen);
            txtChap = itemView.findViewById(R.id.txtChap);
            txtTime = itemView.findViewById(R.id.txtTime);
            badgeFull = itemView.findViewById(R.id.badgeFull);
            badgeNew = itemView.findViewById(R.id.badgeNew);
        }

        public void bind(Truyen truyen, OnItemClickListener listener) {
            txtTenTruyen.setText(truyen.getTenTruyen());
            txtChap.setText("Chap " + truyen.getLastChapter());
            txtTime.setText(truyen.getTimeUpdate());

            Glide.with(itemView.getContext()).load(truyen.getAnh()).into(imgTruyen);

            itemView.setOnClickListener(v -> listener.onItemClick(truyen));
        }
    }
}

