package com.jenb.ntdat.thanhdat;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class ActivityChucNang3 extends AppCompatActivity {

    ListView lvNhac;
    ArrayList<String> arrNhac;

    ArrayAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_chuc_nang3);

        lvNhac = findViewById(R.id.lvBaiHat);
        arrNhac = new ArrayList<>();
        arrNhac.add("Tiến về Sài Gòn");
        arrNhac.add("Giải phóng Miền Nam");
        arrNhac.add("Đất nước trọn niềm vui");
        arrNhac.add("Bài ca thống nhất");
        arrNhac.add("Mùa xuân trên thành phố HCM");

        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arrNhac);
        lvNhac.setAdapter(adapter);

        lvNhac.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String value = arrNhac.get(i);
                Toast.makeText(ActivityChucNang3.this, value, Toast.LENGTH_SHORT).show();
            }
        });

    }
}