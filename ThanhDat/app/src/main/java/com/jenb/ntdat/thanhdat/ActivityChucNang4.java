package com.jenb.ntdat.thanhdat;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ActivityChucNang4 extends AppCompatActivity {

    ArrayList<ActivityChucNang4_HoatDong> arrHoatDong;
    ActivityChucNang4_Adapter adapter;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_chuc_nang4);

        arrHoatDong = getArrHoatDong();
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new ActivityChucNang4_Adapter(this, arrHoatDong);
        recyclerView.setAdapter(adapter);

    }

    ArrayList<ActivityChucNang4_HoatDong> getArrHoatDong(){
        ArrayList<ActivityChucNang4_HoatDong> arrHoatDong = new ArrayList<>();
        arrHoatDong.add(new ActivityChucNang4_HoatDong("12/2/2002", "hahaha", R.drawable.boy));
        arrHoatDong.add(new ActivityChucNang4_HoatDong("12/2/2002", "hahaha", R.drawable.boy));
        return arrHoatDong;
    }
}