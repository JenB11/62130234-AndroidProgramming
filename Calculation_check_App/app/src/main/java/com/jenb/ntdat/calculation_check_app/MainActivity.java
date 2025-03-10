package com.jenb.ntdat.calculation_check_app;

import android.graphics.Color;
import android.os.Handler;
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

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView tvBai;
    EditText edtInput;
    Button btnCheck;
    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0, btnAC;
    String number = null;
    int dapAn = 0;
    public void TimDieuKhien(){
        tvBai = findViewById(R.id.tvBai);
        edtInput = findViewById(R.id.edtInput);
        btnCheck = findViewById(R.id.btnCheck);

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);

        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);

        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);

        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);

        btn9 = findViewById(R.id.btn9);
        btn0 = findViewById(R.id.btn0);

        btnAC = findViewById(R.id.btnAC);
    }

    public void resetBackground(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                edtInput.setBackground(getResources().getDrawable(R.drawable.custom_edt));
            }
        }, 1000);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TimDieuKhien();

        btn0.setOnClickListener(view -> numberclick("0"));
        btn1.setOnClickListener(view -> numberclick("1"));
        btn2.setOnClickListener(view -> numberclick("2"));
        btn3.setOnClickListener(view -> numberclick("3"));
        btn4.setOnClickListener(view -> numberclick("4"));
        btn5.setOnClickListener(view -> numberclick("5"));
        btn6.setOnClickListener(view -> numberclick("6"));
        btn7.setOnClickListener(view -> numberclick("7"));
        btn8.setOnClickListener(view -> numberclick("8"));
        btn9.setOnClickListener(view -> numberclick("9"));
        btnAC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (number != null && number.length() > 0) {
                    number = number.substring(0, number.length() - 1);
                    edtInput.setText(number);
                }
            }
        });

        PhepToanNhan();

        btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String input = edtInput.getText().toString();
                if (!input.isEmpty()) {
                    int inputNum = Integer.parseInt(input);
                    if (inputNum == dapAn) {
                        resetBackground();
                        edtInput.setBackground(getResources().getDrawable(R.drawable.background_yes));
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                PhepToanNhan();
                                number = null;
                                edtInput.setText("");
                            }
                        }, 1000);
                    } else {
                        resetBackground();
                        edtInput.setBackground(getResources().getDrawable(R.drawable.background_no));
                        new Handler().postDelayed(new Runnable() {
                            public void run() {
                                PhepToanNhan();
                                number = null;
                                edtInput.setText("");
                            }
                        }, 1000);
                    }
                } else {
                    resetBackground();
                    edtInput.setBackground(getResources().getDrawable(R.drawable.background_no));
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            number = null;
                            edtInput.setText("");
                        }
                    }, 1000);
                }
            }
        });
    }



    public void PhepToanNhan() {
        Random random = new Random();
        int num1 = random.nextInt(9) + 1; // Số thứ nhất từ 1 đến 9
        int num2 = random.nextInt(9) + 1; // Số thứ hai từ 1 đến 9
        String baiToan = num1 + " x " + num2 + " =";
        dapAn = num1 * num2;
        tvBai.setText(baiToan);
    }

    private void numberclick(String view) {
        if(number == null)
        {
            number = view;
        }
        else {
            number += view;
        }
        edtInput.setText(number);
    }
}