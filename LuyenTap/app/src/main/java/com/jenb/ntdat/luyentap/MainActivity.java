package com.jenb.ntdat.luyentap;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button btnCau1, btnCau2, btnCau3, btnCau4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        btnCau4 =  findViewById(R.id.btnCau4);
        btnCau4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ActivityCau4.class);
                startActivity(intent);
            }
        });

        btnCau1 = findViewById(R.id.btnCau1);
        btnCau1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ActivityCau1.class);
                startActivity(intent);
            }
        });

        btnCau2 = findViewById(R.id.btnCau2);
        btnCau2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ActivityCau2.class);
                startActivity(intent);
            }
        });

        btnCau3 = findViewById(R.id.btnCau3);
        btnCau3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ActivityCau3.class);
                startActivity(intent);
            }
        });

    }
}