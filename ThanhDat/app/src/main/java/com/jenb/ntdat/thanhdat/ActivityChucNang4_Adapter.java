package com.jenb.ntdat.thanhdat;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ActivityChucNang4_Adapter extends RecyclerView.Adapter<ActivityChucNang4_Adapter.ViewHolder> {
    Context  context;
    ArrayList<ActivityChucNang4_HoatDong> arrHoatDong;

    public ActivityChucNang4_Adapter(Context context, ArrayList<ActivityChucNang4_HoatDong> arrHoatDong) {
        this.context = context;
        this.arrHoatDong = arrHoatDong;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.activity_custom_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ActivityChucNang4_HoatDong hoatDong = arrHoatDong.get(position);
        String thoiGian = hoatDong.getThoiGian();
        String tenTieuDe = hoatDong.getTenTieuDe();
        holder.tvThoiGian.setText(thoiGian);
        holder.tvTieuDe.setText(tenTieuDe);
        holder.imgAnh.setImageResource(hoatDong.getHinhAnh());

    }

    @Override
    public int getItemCount() {
        return arrHoatDong.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tvTieuDe, tvThoiGian;
        ImageView imgAnh;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTieuDe = itemView.findViewById(R.id.tvNoiDung);
            tvThoiGian = itemView.findViewById(R.id.tvThoiGian);
            imgAnh = itemView.findViewById(R.id.imgAnh);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            ActivityChucNang4_HoatDong hoatDong = arrHoatDong.get(position);
            String tenTieuDe = hoatDong.getTenTieuDe();
            Toast.makeText(context, tenTieuDe, Toast.LENGTH_SHORT).show();
        }
    }
}
