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

        String strA = editTextA.getText().toString();
        String strB = editTextB.getText().toString();

        int soA = Integer.parseInt(strA);
        int soB = Integer.parseInt(strB);

        int Tong = soA + soB;

        String strKQ = String.valueOf(Tong);

        editTextKQ.setText(strKQ);

    }

    public void nutTru(View view){
        EditText editTextA = findViewById(R.id.edtA);
        EditText editTextB = findViewById(R.id.edtB);
        EditText editTextKQ = findViewById(R.id.edtKQ);

        String strA = editTextA.getText().toString();
        String strB = editTextB.getText().toString();

        int soA = Integer.parseInt(strA);
        int soB = Integer.parseInt(strB);

        int Hieu = soA - soB;

        String strKQ = String.valueOf(Hieu);

        editTextKQ.setText(strKQ);
    }

    public void nutNhan(View view){
        EditText editTextA = findViewById(R.id.edtA);
        EditText editTextB = findViewById(R.id.edtB);
        EditText editTextKQ = findViewById(R.id.edtKQ);

        String strA = editTextA.getText().toString();
        String strB = editTextB.getText().toString();

        int soA = Integer.parseInt(strA);
        int soB = Integer.parseInt(strB);

        int Tich = soA * soB;

        String strKQ = String.valueOf(Tich);

        editTextKQ.setText(strKQ);
    }

    public void nutChia(View view){
        EditText editTextA = findViewById(R.id.edtA);
        EditText editTextB = findViewById(R.id.edtB);
        EditText editTextKQ = findViewById(R.id.edtKQ);

        String strA = editTextA.getText().toString();
        String strB = editTextB.getText().toString();


        int soA = Integer.parseInt(strA);
        int soB = Integer.parseInt(strB);

        int Thuong = soA / soB;

        String strKQ = String.valueOf(Thuong);

        editTextKQ.setText(strKQ);
    }


}