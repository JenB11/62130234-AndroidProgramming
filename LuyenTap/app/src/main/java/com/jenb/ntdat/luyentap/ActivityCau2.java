package com.jenb.ntdat.luyentap;

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

public class ActivityCau2 extends AppCompatActivity {

    ListView listView;
    ArrayList<ListViewCuaCaiGiDo> dsItem;
    Adapter_Cau2 adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_cau2);

        listView = findViewById(R.id.lvCau2);

        dsItem = new ArrayList<>();
        dsItem.add(new ListViewCuaCaiGiDo("Name1", "Caption1", R.mipmap.img1));
        dsItem.add(new ListViewCuaCaiGiDo("Name2", "Caption2", R.mipmap.img2));
        dsItem.add(new ListViewCuaCaiGiDo("Name3", "Caption3", R.mipmap.img3));

        adapter = new Adapter_Cau2(ActivityCau2.this,R.layout.custom_item_cau2,dsItem);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String value = dsItem.get(i).getTenItem();
                Toast.makeText(ActivityCau2.this, value, Toast.LENGTH_SHORT).show();
            }
        });
    }
}