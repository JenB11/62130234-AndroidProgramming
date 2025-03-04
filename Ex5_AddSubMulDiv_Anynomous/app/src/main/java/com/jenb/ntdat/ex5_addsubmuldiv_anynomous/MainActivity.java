package com.jenb.ntdat.ex5_addsubmuldiv_anynomous;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button btnCong, btnTru, btnNhan, btnChia;
    EditText edtSoThuNhat, edtSoThuHai;
    TextView tvKetQua;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        Tim_Dieu_Khien();
        Event();
    }
    public void Event(){
        btnCong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Xu_Ly_Cong();
            }
        });
        btnTru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Xu_Ly_Tru();
            }
        });
        btnNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Xu_Ly_Nhan();
            }
        });
        btnChia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Xu_Ly_Chia();
            }
        });
    }
    public void Tim_Dieu_Khien(){
        btnCong = findViewById(R.id.btnCong);
        btnTru = findViewById(R.id.btnTru);
        btnNhan = findViewById(R.id.btnNhan);
        btnChia = findViewById(R.id.btnChia);
        edtSoThuNhat = findViewById(R.id.edtA);
        edtSoThuHai = findViewById(R.id.edtB);
        tvKetQua = findViewById(R.id.tvKQ);
    }

    public void Xu_Ly_Cong(){
        String a = edtSoThuNhat.getText().toString();
        String b = edtSoThuHai.getText().toString();
        float soThuNhat = Integer.parseInt(a);
        float soThuHai = Integer.parseInt(b);
        float ketQua = soThuNhat + soThuHai;

        tvKetQua.setText(String.valueOf(ketQua));
    }
    public void Xu_Ly_Tru(){
        String a = edtSoThuNhat.getText().toString();
        String b = edtSoThuHai.getText().toString();
        float soThuNhat = Integer.parseInt(a);
        float soThuHai = Integer.parseInt(b);
        float ketQua = soThuNhat - soThuHai;

        tvKetQua.setText(String.valueOf(ketQua));
    }
    public void Xu_Ly_Nhan(){
        String a = edtSoThuNhat.getText().toString();
        String b = edtSoThuHai.getText().toString();
        float soThuNhat = Integer.parseInt(a);
        float soThuHai = Integer.parseInt(b);
        float ketQua = soThuNhat * soThuHai;

        tvKetQua.setText(String.valueOf(ketQua));
    }
    public void Xu_Ly_Chia() {
        String a = edtSoThuNhat.getText().toString();
        String b = edtSoThuHai.getText().toString();
        float soThuNhat = Integer.parseInt(a);
        float soThuHai = Integer.parseInt(b);
        float ketQua = soThuNhat / soThuHai;

        tvKetQua.setText(String.format("%.2f", ketQua));
    }
}