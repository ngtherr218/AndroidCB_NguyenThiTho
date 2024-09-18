package com.example.b4;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    Button bt_bmi_caculator;
    EditText ed_height, ed_weight, ed_bmi, ed_diagnosis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        init();
        bt_bmi_caculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double height = Double.parseDouble(ed_height.getText().toString());
                Double weight = Double.parseDouble(ed_weight.getText().toString());
                Double bmi = weight/Math.pow(height,2);
                ed_bmi.setText(String.valueOf(new DecimalFormat("#.0").format(bmi)));

                String diagnosis="";
                if(bmi<18){
                    diagnosis="Bạn gầy!";
                } else if (bmi<=24.9) {
                    diagnosis ="Bạn bình thường!";
                } else if (bmi<=29.9) {
                    diagnosis ="Bạn bị béo phì cấp độ 1";
                }else if (bmi<=34.9){
                    diagnosis = "Bạn bị béo phì cấp độ 2";
                } else{
                    diagnosis = "Bạn bị béo phì cấp độ 3";
                }
                ed_diagnosis.setText(diagnosis);
            }
        });
    }

    void init() {
        bt_bmi_caculator = findViewById(R.id.bt_bmi_caculator);
        ed_height = findViewById(R.id.ed_height);
        ed_weight = findViewById(R.id.ed_weight);
        ed_bmi = findViewById(R.id.ed_bmi);
        ed_diagnosis = findViewById(R.id.ed_diagnosis);
    }
}