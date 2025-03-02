package com.jenb.ntdat.calculating_perimeter_area_app;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Spinner spHinh, spDonvi;
    ImageView imgHinh;
    TextView tv1, tv2, tv3, tv4,  tv5, tvResult,  tvDonvi1, tvDonvi2, tvDonvi3, tvDonvi4, tvDonvi5;
    EditText edt1, edt2, edt3, edt4, edt5;
    Button btnResult;
    String selectedShape = "";
    String selectedUnit = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        Tim_Dieu_Khien();
        Xu_Ly_Spinner();
    }

    public void XuLyCalculate(View view){
        double value1 = 0, value2 = 0, value3 = 0, value4 = 0, value5 = 0;
        try {
            if (edt1.getVisibility() == View.VISIBLE && !edt1.getText().toString().isEmpty()) {
                value1 = Double.parseDouble(edt1.getText().toString());
            }
            if (edt2.getVisibility() == View.VISIBLE && !edt2.getText().toString().isEmpty()) {
                value2 = Double.parseDouble(edt2.getText().toString());
            }
            if (edt3.getVisibility() == View.VISIBLE && !edt3.getText().toString().isEmpty()) {
                value3 = Double.parseDouble(edt3.getText().toString());
            }
            if (edt4.getVisibility() == View.VISIBLE && !edt4.getText().toString().isEmpty()) {
                value4 = Double.parseDouble(edt4.getText().toString());
            }
            if (edt5.getVisibility() == View.VISIBLE && !edt5.getText().toString().isEmpty()) {
                value5 = Double.parseDouble(edt5.getText().toString());
            }
        } catch (NumberFormatException e) {
            tvResult.setText("Lỗi nhập liệu");
            return;
        }

        double perimeter = 0.0;
        double area = 0.0;

        switch (selectedShape) {
            case "Hình tròn":
                if (value1 > 0) {
                    perimeter = 2 * Math.PI * value1;
                    area = Math.PI * value1 * value1;
                } else {
                    tvResult.setText("Lỗi nhập liệu");
                    return;
                }
                break;
            case "Hình vuông":
                if (value1 > 0) {
                    perimeter = 4 * value1;
                    area = value1 * value1;
                } else {
                    tvResult.setText("Lỗi nhập liệu");
                    return;
                }
                break;
            case "Hình chữ nhật":
                if (value1 > 0 && value2 > 0) {
                    perimeter = 2 * (value1 + value2);
                    area = value1 * value2;
                } else {
                    tvResult.setText("Lỗi nhập liệu");
                    return;
                }
                break;
            case "Hình tam giác":
                if (value1 > 0 && value2 > 0) {
                    perimeter = 3*value1;
                    area = 0.5 * value1 * value2;
                } else {
                    tvResult.setText("Lỗi nhập liệu");
                    return;
                }
                break;
            case "Hình thang":
                if (value1 > 0 && value2 > 0 && value3 > 0) {
                    perimeter = 2*value1+value2+value3;
                    area = 0.5 * (value1 + value3) * value2;
                } else {
                    tvResult.setText("Lỗi nhập liệu");
                    return;
                }
                break;
            case "Hình bình hành":
                if (value1 > 0 && value2 > 0) {
                    perimeter = 2 * (value1 + value1);
                    area = value1 * value2;
                } else {
                    tvResult.setText("Lỗi nhập liệu");
                    return;
                }
                break;
            case "Hình thoi":
                if (value1 > 0 && value2 > 0) {
                    perimeter = 4*value1;
                    area = 0.5 * value1 * value2;
                } else {
                    tvResult.setText("Lỗi nhập liệu");
                    return;
                }
                break;
            case "Hình tứ giác":
                if (value1 > 0 && value2 > 0 && value3 > 0 && value4 > 0) {
                    perimeter = value1 + value2 + value3 + value4;
                    area = 0;
                } else {
                    tvResult.setText("Lỗi nhập liệu");
                    return;
                }
                break;
            default:
                tvResult.setText("Vui lòng chọn hình");
                return;
        }

        // Hiển thị kết quả
        String resultText = "Chu vi: " + String.format("%.2f", perimeter) + " " + selectedUnit + "\n"
                + "Diện tích: " + String.format("%.2f", area) + " " + selectedUnit + "^2";
        tvResult.setText(resultText);
    }

    public void Tim_Dieu_Khien(){
        spHinh = findViewById(R.id.spHinh);
        spDonvi = findViewById(R.id.spDonvi);
        imgHinh = findViewById(R.id.imgHinh);

        tv1 = findViewById(R.id.tv1);
        tv2 = findViewById(R.id.tv2);
        tv3 = findViewById(R.id.tv3);
        tv4 = findViewById(R.id.tv4);
        tv5 = findViewById(R.id.tv5);

        tvResult = findViewById(R.id.tvResult);

        tvDonvi1 = findViewById(R.id.tvDonvi1);
        tvDonvi2 = findViewById(R.id.tvDonvi2);
        tvDonvi3 = findViewById(R.id.tvDonvi3);
        tvDonvi4 = findViewById(R.id.tvDonvi4);
        tvDonvi5 = findViewById(R.id.tvDonvi5);

        edt1 = findViewById(R.id.edt1);
        edt2 = findViewById(R.id.edt2);
        edt3 = findViewById(R.id.edt3);
        edt4 = findViewById(R.id.edt4);
        edt5 = findViewById(R.id.edt5);

        btnResult = findViewById(R.id.btnResult);
    }

    public void Xu_Ly_Spinner(){
        String[] arr1 = {"Hình tròn", "Hình vuông", "Hình tam giác", "Hình chữ nhật", "Hình thang","Hình bình hành","Hình thoi"};
        String[] arr2 = {"mm", "cm", "dm", "m", "km"};

        spHinh.setAdapter(new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, arr1));
        spDonvi.setAdapter(new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, arr2));

        spHinh.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selectedShape = arr1[i];
                Update_Hinh();
                Update_Canh();
                resetEditTexts();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spDonvi.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selectedUnit = arr2[i];
                Update_Donvi();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public void Update_Hinh(){
        switch (selectedShape) {
            case "Hình tròn":
                imgHinh.setImageResource(R.drawable.circle);
                break;
            case "Hình vuông":
                imgHinh.setImageResource(R.drawable.square);
                break;
            case "Hình tam giác":
                imgHinh.setImageResource(R.drawable.triangle);
                break;
            case "Hình chữ nhật":
                imgHinh.setImageResource(R.drawable.rectangle);
                break;
            case "Hình thang":
                imgHinh.setImageResource(R.drawable.trapezoid);
                break;
            case "Hình bình hành":
                imgHinh.setImageResource(R.drawable.parallelogram);
                break;
            case "Hình thoi":
                imgHinh.setImageResource(R.drawable.rhombus);
                break;
            default:
                imgHinh.setImageResource(R.drawable.ic_launcher_foreground);
                break;
        }
    }

    public void Update_Canh(){
        resetCanh();
        switch (selectedShape) {
            case "Hình tròn":
                tv1.setText("Bán kính");
                break;
            case "Hình vuông":
                tv1.setText("Cạnh");
                break;
            case "Hình chữ nhật":
                tv1.setText("Chiều dài");
                tv2.setText("Chiều rộng");
                break;
            case "Hình tam giác":
                tv1.setText("Cạnh a");
                tv2.setText("Cạnh b");
                tv3.setText("Cạnh c");
                tv4.setText("Chiều cao");
                break;
            case "Hình thang":
                tv1.setText("Canh a");
                tv2.setText("Canh b");
                tv3.setText("Cạnh c");
                tv4.setText("Cạnh d");
                tv5.setText("Chiều cao");
                break;
            case "Hình bình hành":
                tv1.setText("Canh a");
                tv2.setText("Canh b");
                tv3.setText("Chiều cao");
                break;
            case "Hình thoi":
                tv1.setText("Canh a");
                tv2.setText("Đường chéo 1");
                tv3.setText("Đường chéo 2");
                break;
        }
    }
    public void resetCanh() {
        tv1.setText("");
        tv2.setText("");
        tv3.setText("");
        tv4.setText("");
        tv5.setText("");
    }
    public void resetEditTexts() {
        edt1.setText("");
        edt2.setText("");
        edt3.setText("");
        edt4.setText("");
    }
    public void Update_Donvi(){
        tvDonvi1.setText(selectedUnit);
        tvDonvi2.setText(selectedUnit);
        tvDonvi3.setText(selectedUnit);
        tvDonvi4.setText(selectedUnit);
        tvDonvi5.setText(selectedUnit);
    }
}