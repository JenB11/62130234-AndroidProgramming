package com.jenb.ntdat.recyclerview;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    LandScapeAdapter LandAdapter;
    ArrayList<LandScape> recyclerViewDatas;
    RecyclerView rcvLand;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewDatas = getDataRecycler();
        rcvLand = findViewById(R.id.rcvLand);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        rcvLand.setLayoutManager(layoutManager);
        LandAdapter = new LandScapeAdapter(this, recyclerViewDatas);
        rcvLand.setAdapter(LandAdapter);
    }

    public ArrayList<LandScape> getDataRecycler(){
        ArrayList<LandScape> dsDuLieu = new ArrayList<LandScape>();
        LandScape landScape1 = new LandScape("land1", "LandScape 1");
        LandScape landScape2 = new LandScape("land2", "LandScape 2");
        LandScape landScape3 = new LandScape("land3", "LandScape 3");

        dsDuLieu.add(landScape1);
        dsDuLieu.add(landScape2);
        dsDuLieu.add(landScape3);
        return dsDuLieu;


    }
}