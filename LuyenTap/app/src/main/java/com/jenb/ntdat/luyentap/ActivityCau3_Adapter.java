package com.jenb.ntdat.luyentap;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class ActivityCau3_Adapter extends RecyclerView.Adapter<ActivityCau3_Adapter.ItemViewHolder> {

    Context context;

    ArrayList<ActivityCau3_LandScape> dsItem;
    public ActivityCau3_Adapter(Context context, ArrayList<ActivityCau3_LandScape> dsItem) {
        this.context = context;
        this.dsItem = dsItem;
    }


    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.activity_cau3_item, parent, false);
        ItemViewHolder viewHolder = new ItemViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        ActivityCau3_LandScape item = dsItem.get(position);
        String tenAnh = item.getTenAnh();
        String noiDung = item.getNoiDung();
        holder.tvNoiDung.setText(noiDung);
        String pakageName = holder.itemView.getContext().getPackageName();
        int idimg = holder.itemView.getResources().getIdentifier(tenAnh, "mipmap", pakageName);
        holder.imgAnh.setImageResource(idimg);
    }

    @Override
    public int getItemCount() {
        return dsItem.size();
    }

    class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView tvNoiDung;
        ImageView imgAnh;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNoiDung = itemView.findViewById(R.id.tvNoiDung);
            imgAnh = itemView.findViewById(R.id.imgAnh);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int vitriitem = getAdapterPosition();
            ActivityCau3_LandScape item = dsItem.get(vitriitem);
            String tenAnh = item.getTenAnh();
            String noiDung = item.getNoiDung();

            Toast.makeText(context, noiDung, Toast.LENGTH_SHORT).show();
        }
    }

}
