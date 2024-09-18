package com.example.b2;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button bt_ctc, bt_ctf, bt_clear;
    EditText ed_c, ed_f;

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

        ed_c = findViewById(R.id.ed_c);
        ed_f = findViewById(R.id.ed_f);
        bt_ctc = findViewById(R.id.bt_ctc);
        bt_ctf = findViewById(R.id.bt_ctf);
        bt_clear = findViewById(R.id.bt_clear);

        bt_ctc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!ed_f.getText().toString().trim().equals("")) {
                    double number = Double.parseDouble(ed_f.getText().toString());
                    ed_c.setText(String.valueOf((number - 32) * 5 / 9));
                } else {
                    Toast.makeText(MainActivity.this, "Hãy nhập Fahrenheit", Toast.LENGTH_SHORT).show();
                }
            }
        });

        bt_ctf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!ed_c.getText().toString().trim().equals("")) {
                    double number = Double.parseDouble(ed_c.getText().toString());
                    ed_f.setText(String.valueOf(number * 9 / 5 + 32));
                } else {
                    Toast.makeText(MainActivity.this, "Hãy nhập Celsius", Toast.LENGTH_SHORT).show();
                }
            }
        });
        bt_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ed_f.setText("");
                ed_c.setText("");
            }
        });
    }
}