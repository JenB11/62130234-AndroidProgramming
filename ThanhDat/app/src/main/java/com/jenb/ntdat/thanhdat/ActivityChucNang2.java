package com.jenb.ntdat.thanhdat;

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

public class ActivityChucNang2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_chuc_nang2);

        EditText edtNam = findViewById(R.id.edtNam);
        EditText edtNgay = findViewById(R.id.edtNgay);
        EditText edtThang = findViewById(R.id.edtThang);
        Button btnKt= findViewById(R.id.btnKT);
        TextView txKetQua = findViewById(R.id.txKetQua);

        btnKt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int nam = Integer.parseInt(edtNam.getText().toString());
                int ngay = Integer.parseInt(edtNgay.getText().toString());
                int thang = Integer.parseInt(edtThang.getText().toString());

                if (nam == 1945 && ngay == 25 && thang == 12){
                    txKetQua.setText("Đáp án đúng!!");
                }

            }
        });

    }
}