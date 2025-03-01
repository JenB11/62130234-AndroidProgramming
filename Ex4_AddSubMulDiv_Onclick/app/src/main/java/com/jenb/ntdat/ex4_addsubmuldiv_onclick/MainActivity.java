package com.jenb.ntdat.ex4_addsubmuldiv_onclick;

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
    EditText editTextA;
    EditText editTextB;
    EditText editTextKQ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        TimDieuKhien();
    }
    public void TimDieuKhien(){
        editTextA = findViewById(R.id.edtA);
        editTextB = findViewById(R.id.edtB);
        editTextKQ = findViewById(R.id.edtKetQua);
    }

    public void xuLyCong(View view) {
        String strA = editTextA.getText().toString();
        String strB = editTextB.getText().toString();

        float soA = Float.parseFloat(strA);
        float soB = Float.parseFloat(strB);

        float Tong = soA + soB;

        String strKQ = String.valueOf(Tong);

        editTextKQ.setText(strKQ);
    }

    public void xuLyTru(View view) {
        String strA = editTextA.getText().toString();
        String strB = editTextB.getText().toString();

        float soA = Float.parseFloat(strA);
        float soB = Float.parseFloat(strB);

        float Tong = soA - soB;

        String strKQ = String.valueOf(Tong);

        editTextKQ.setText(strKQ);
    }

    public void xuLyNhan(View view) {
        String strA = editTextA.getText().toString();
        String strB = editTextB.getText().toString();

        float soA = Float.parseFloat(strA);
        float soB = Float.parseFloat(strB);

        float Tong = soA * soB;

        String strKQ = String.valueOf(Tong);

        editTextKQ.setText(strKQ);
    }

    public void xuLyChia(View view) {
        String strA = editTextA.getText().toString();
        String strB = editTextB.getText().toString();

        float soA = Float.parseFloat(strA);
        float soB = Float.parseFloat(strB);

        float Tong = soA / soB;

        String strKQ = String.valueOf(Tong);

        editTextKQ.setText(strKQ);
    }

}