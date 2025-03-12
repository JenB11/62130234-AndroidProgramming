package com.jenb.ntdat.listview;

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

public class MainActivity extends AppCompatActivity {

    ListView lvTest;
    ArrayList <String> arrayList;
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        lvTest = findViewById(R.id.lvTest);

        arrayList = new ArrayList<>();

        arrayList.add("Apple");
        arrayList.add("Banana");
        arrayList.add("Cherry");
        arrayList.add("Durian");
        arrayList.add("Elderberry");
        arrayList.add("Fig");
        arrayList.add("Grape");
        arrayList.add("Huckleberry");
        arrayList.add("Iguana");
        arrayList.add("Jackfruit");

        adapter  = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayList);
        lvTest.setAdapter(adapter);

        lvTest.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String value = arrayList.get(i);
                Toast.makeText(getApplicationContext(), value, Toast.LENGTH_LONG).show();

            }
        });
    }
}