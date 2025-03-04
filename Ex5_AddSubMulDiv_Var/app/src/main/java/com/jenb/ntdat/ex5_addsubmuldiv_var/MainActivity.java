package com.jenb.ntdat.ex5_addsubmuldiv_var;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnCong, btnTru, btnNhan, btnChia;
    EditText edtSoThuNhat, edtSoThuHai;
    TextView tvKetQua;

    public void Tim_Dieu_Khien(){
        btnCong = findViewById(R.id.btnCong);
        btnTru = findViewById(R.id.btnTru);
        btnNhan = findViewById(R.id.btnNhan);
        btnChia = findViewById(R.id.btnChia);
        edtSoThuNhat = findViewById(R.id.edtA);
        edtSoThuHai = findViewById(R.id.edtB);
        tvKetQua = findViewById(R.id.tvKQ);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        Tim_Dieu_Khien();

        btnCong.setOnClickListener(XuLyCong);
        btnTru.setOnClickListener(XuLyTru);
        btnNhan.setOnClickListener(XuLyNhan);
        btnChia.setOnClickListener(XuLyChia);
    }

    View.OnClickListener XuLyCong = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String a = edtSoThuNhat.getText().toString();
            String b = edtSoThuHai.getText().toString();
            float soThuNhat = Integer.parseInt(a);
            float soThuHai = Integer.parseInt(b);
            float ketQua = soThuNhat + soThuHai;

            tvKetQua.setText(String.valueOf(ketQua));
        }
    };
    View.OnClickListener XuLyTru = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String a = edtSoThuNhat.getText().toString();
            String b = edtSoThuHai.getText().toString();
            float soThuNhat = Integer.parseInt(a);
            float soThuHai = Integer.parseInt(b);
            float ketQua = soThuNhat - soThuHai;

            tvKetQua.setText(String.valueOf(ketQua));
        }
    };

    View.OnClickListener XuLyNhan = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String a = edtSoThuNhat.getText().toString();
            String b = edtSoThuHai.getText().toString();
            float soThuNhat = Integer.parseInt(a);
            float soThuHai = Integer.parseInt(b);
            float ketQua = soThuNhat * soThuHai;

            tvKetQua.setText(String.valueOf(ketQua));
        }
    };

    View.OnClickListener XuLyChia = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String a = edtSoThuNhat.getText().toString();
            String b = edtSoThuHai.getText().toString();
            float soThuNhat = Integer.parseInt(a);
            float soThuHai = Integer.parseInt(b);
            float ketQua = soThuNhat / soThuHai;

            tvKetQua.setText(String.valueOf(ketQua));
        }
    };


}