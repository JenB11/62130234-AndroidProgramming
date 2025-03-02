package com.jenb.ntdat.bmicalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    TextView tvKG, tvCM, tvBMI;
    SeekBar sbWeight, sbHeight;
    ImageButton imbtMale, imbtFemale;
    boolean isSelected = false;
    float inBMI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Tim_Dieu_khien();
        init();
        init2();
    }

    public void Tim_Dieu_khien(){
        tvKG = findViewById(R.id.tvKG);
        sbWeight = findViewById(R.id.sbWeight);
        tvCM = findViewById(R.id.tvCM);
        sbHeight = findViewById(R.id.sbHeight);
        tvBMI = findViewById(R.id.tvResult);
        imbtMale = findViewById(R.id.imgMale);
        imbtFemale = findViewById(R.id.imgFemale);
    }

    public void CalculateBMI(View view){
        inBMI = Float.parseFloat(tvKG.getText().toString()) / (Float.parseFloat(tvCM.getText().toString()) / 100 * Float.parseFloat(tvCM.getText().toString()) / 100);

        if (inBMI < 18.5){
            tvBMI.setText("Underweight");
        } else if (inBMI < 22.9){
            tvBMI.setText("Normal");
        } else if (inBMI >= 23 && inBMI <= 24.9){
            tvBMI.setText("Overweight");
        } else if (inBMI >= 25 && inBMI <= 29.9){
            tvBMI.setText("Obese");
        } else if (inBMI >= 30){
            tvBMI.setText("Extremely Obese");
        }
    }

    public void init2() {
        imbtMale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isSelected == true){
                    imbtMale.setImageResource(R.drawable.tick);
                }else {
                    imbtMale.setImageResource(R.drawable.male);
                }
                isSelected = !isSelected;
            }
        });

        imbtFemale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isSelected == true){
                    imbtFemale.setImageResource(R.drawable.tick);
                }
                else {
                    imbtFemale.setImageResource(R.drawable.femenine);
                }
                isSelected = !isSelected;
            }
        });
    }
    public void init(){

        sbWeight.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                tvKG.setText(i + "");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        sbHeight.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                tvCM.setText(i + "");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}