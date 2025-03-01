package com.jenb.ntdat.ex3_calculateapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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
    }

    public void nutCong(View view){
        EditText editTextA = findViewById(R.id.edtA);
        EditText editTextB = findViewById(R.id.edtB);
        EditText editTextKQ = findViewById(R.id.edtKQ);
        

    }

}