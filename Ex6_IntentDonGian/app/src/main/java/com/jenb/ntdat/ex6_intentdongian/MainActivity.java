package com.jenb.ntdat.ex6_intentdongian;

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

    Button btnMH2, btnMH3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        TimDieuKhien();

        btnMH2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intMH2 = new Intent(MainActivity.this, MH2Activity.class);
                startActivity(intMH2);
            }
        });

        btnMH3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intMH3 = new Intent(MainActivity.this, MH3Activity.class);
                startActivity(intMH3);
            }
        });
    }

    public void TimDieuKhien(){
        btnMH2 = (Button) findViewById(R.id.btnMH2);
        btnMH3 = (Button) findViewById(R.id.btnMH3);
    }
}