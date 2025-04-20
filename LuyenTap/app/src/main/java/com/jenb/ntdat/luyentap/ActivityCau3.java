package com.jenb.ntdat.luyentap;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ActivityCau3 extends AppCompatActivity {

    ActivityCau3_Adapter adapter;
    ArrayList<ActivityCau3_LandScape> dsItem;

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_cau3);

        dsItem = getDSItem();

        recyclerView = findViewById(R.id.recyclerLand);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new ActivityCau3_Adapter(this, dsItem);
        recyclerView.setAdapter(adapter);

    }

    ArrayList<ActivityCau3_LandScape> getDSItem(){
        ArrayList<ActivityCau3_LandScape> dsItem = new ArrayList<ActivityCau3_LandScape>();
        dsItem.add(new ActivityCau3_LandScape("img1", "TextView"));
        dsItem.add(new ActivityCau3_LandScape("img2", "TextView"));
        dsItem.add(new ActivityCau3_LandScape("img3", "TextView"));
        return dsItem;
    }
}