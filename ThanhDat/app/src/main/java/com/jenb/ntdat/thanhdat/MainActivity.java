package com.jenb.ntdat.thanhdat;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        Button btnCN2 = findViewById(R.id.btnCN2);
        Button btnCN3 = findViewById(R.id.btnCN3);
        Button btnCN4 = findViewById(R.id.btnCN4);
        Button btnMe = findViewById(R.id.btnMe);

        btnCN2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ActivityChucNang2.class);
                startActivity(intent);
            }
        });

        btnCN3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ActivityChucNang3.class);
                startActivity(intent);
            }
        });

        btnCN4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ActivityChucNang4.class);
                startActivity(intent);
            }
        });

        btnMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ActivityAboutMe.class);
                startActivity(intent);
            }
        });
    }
}