package com.jenb.ntdat.unit_converter_app;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText input;
    Spinner unit;
    TextView km, m, cm, mm, ft, in, mc, nm, mile, yard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        Tim_Dieu_Khien();

        String[] arr = {"km", "m", "cm", "mm", "ft", "in", "mc", "nm", "mile", "yard"};
        unit.setAdapter(new ArrayAdapter(MainActivity.this, android.R.layout.simple_spinner_item, arr));

        unit.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Update();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        input.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                Update();
            }
        });
    }

    public void Tim_Dieu_Khien(){
        input = findViewById(R.id.input);
        unit = findViewById(R.id.unit);
        km = findViewById(R.id.km);
        m = findViewById(R.id.m);
        cm = findViewById(R.id.cm);
        mm = findViewById(R.id.mm);
        ft = findViewById(R.id.foot);
        in = findViewById(R.id.inch);
        mc = findViewById(R.id.micro);
        nm = findViewById(R.id.nm);
        mile = findViewById(R.id.mile);
        yard = findViewById(R.id.yard);
    }

    public void Update() {
        if (!input.getText().toString().equals("")&& !unit.getSelectedItem().toString().equals("")){
            double in = Double.parseDouble(input.getText().toString());
            switch (unit.getSelectedItem().toString()){
                case "km":
                    setkm(in);
                    break;
                case "m":
                    setkm(in/1000);
                    break;
                case "cm":
                    setkm(in/100000);
                    break;
                case "mm":
                    setkm(in/1000000);
                    break;
                case "mc":
                    setkm(in/1000000000);
                    break;
                case "nm":
                    double d = 1000000 * 1000000;
                    setkm(in/d);
                    break;
                case "mile":
                    setkm(in/1609);
                    break;
                case "yard":
                    setkm(in/1093.61);
                    break;
                case "ft":
                    setkm(in/3280.84);
                    break;
                case "in":
                    setkm(in/39370);
                    break;
            }
        }
    }

    public void setkm(double km_in){
        km.setText(String.valueOf(km_in));
        m.setText(String.valueOf(km_in*1000));
        cm.setText(String.valueOf(km_in*100000));
        mm.setText(String.valueOf(km_in*1000000));
        mc.setText(String.valueOf(km_in*1000000000));
        nm.setText(String.valueOf(km_in*1000000 * 1000000));
        mile.setText(String.valueOf(km_in/1609));
        yard.setText(String.valueOf(km_in*1093.61));
        ft.setText(String.valueOf(km_in*3280.84));
        in.setText(String.valueOf(km_in*39370));

    }
}