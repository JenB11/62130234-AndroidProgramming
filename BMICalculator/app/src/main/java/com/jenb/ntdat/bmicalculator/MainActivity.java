package com.jenb.ntdat.bmicalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
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
    ImageView imgKQ;
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
        imgKQ = findViewById(R.id.imgKQ);
    }

    public void CalculateBMI(View view){
        inBMI = Float.parseFloat(tvKG.getText().toString()) / (Float.parseFloat(tvCM.getText().toString()) / 100 * Float.parseFloat(tvCM.getText().toString()) / 100);
        String result = String.format("%.2f", inBMI);
        if (inBMI < 18.5){
            tvBMI.setText( result + "\nUnderweight");
            tvBMI.setTextColor( getResources().getColor(R.color.red));
            imgKQ.setImageResource(R.drawable.delete);
        } else if (inBMI < 22.9){
            tvBMI.setText(result + "\nNormal");
            imgKQ.setImageResource(R.drawable.check);
        } else if (inBMI >= 23 && inBMI <= 24.9){
            tvBMI.setText(result + "\nOverweight");
            imgKQ.setImageResource(R.drawable.check);
        } else if (inBMI >= 25 && inBMI <= 29.9){
            tvBMI.setText(result + "\nObese");
            tvBMI.setTextColor( getResources().getColor(R.color.red));
            imgKQ.setImageResource(R.drawable.delete);
        } else if (inBMI >= 30){
            tvBMI.setText(result + "\nExtremely Obese");
            tvBMI.setTextColor( getResources().getColor(R.color.red));
            imgKQ.setImageResource(R.drawable.delete);
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