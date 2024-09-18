package com.example.b1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button bt_sum, bt_difference, bt_product, bt_quotient, bt_GCD, bt_exit;
    EditText et_number1, et_number2;
    TextView tv_result;
    int number1, number2;

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

        bt_sum = findViewById(R.id.bt_sum);
        bt_difference = findViewById(R.id.bt_difference);
        bt_product = findViewById(R.id.bt_product);
        bt_quotient = findViewById(R.id.bt_quotient);
        bt_GCD = findViewById(R.id.bt_GCD);
        bt_exit = findViewById(R.id.bt_exit);
        et_number1 = findViewById(R.id.et_number1);
        et_number2 = findViewById(R.id.et_number2);
        tv_result = findViewById(R.id.tv_result);

        bt_sum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkNull()) {
                    number1 = Integer.parseInt(et_number1.getText().toString());
                    number2 = Integer.parseInt(et_number2.getText().toString());
                    tv_result.setText(String.valueOf(number1 + number2));
                } else {
                    Toast.makeText(MainActivity.this, "Hãy nhập đủ dữ liệu", Toast.LENGTH_SHORT).show();
                }
            }
        });
        bt_difference.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkNull()) {
                    number1 = Integer.parseInt(et_number1.getText().toString());
                    number2 = Integer.parseInt(et_number2.getText().toString());
                    tv_result.setText(String.valueOf(number1 - number2));
                } else {
                    Toast.makeText(MainActivity.this, "Hãy nhập đủ dữ liệu", Toast.LENGTH_SHORT).show();
                }
            }
        });
        bt_product.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkNull()) {
                    number1 = Integer.parseInt(et_number1.getText().toString());
                    number2 = Integer.parseInt(et_number2.getText().toString());
                    tv_result.setText(String.valueOf(number1 * number2));
                } else {
                    Toast.makeText(MainActivity.this, "Hãy nhập đủ dữ liệu", Toast.LENGTH_SHORT).show();
                }
            }
        });
        bt_quotient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkNull()) {
                    number1 = Integer.parseInt(et_number1.getText().toString());
                    number2 = Integer.parseInt(et_number2.getText().toString());
                    tv_result.setText(String.valueOf((number1 * 1.0) / number2));
                } else {
                    Toast.makeText(MainActivity.this, "Hãy nhập đủ dữ liệu", Toast.LENGTH_SHORT).show();
                }
            }
        });
        bt_GCD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkNull()) {
                    number1 = Integer.parseInt(et_number1.getText().toString());
                    number2 = Integer.parseInt(et_number2.getText().toString());
                    // Gọi hàm findGCD để tính UCLN
                    int gcd = findGCD(number1, number2);
                    tv_result.setText(String.valueOf(gcd));
                } else {
                    Toast.makeText(MainActivity.this, "Hãy nhập đủ dữ liệu", Toast.LENGTH_SHORT).show();
                }
            }
        });
        bt_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public static int findGCD(int a, int b) {
        if (b == 0) {
            return a;
        }
        return findGCD(b, a % b);
    }

    boolean checkNull() {
        if (et_number1.getText().toString().trim().equals("") || et_number2.getText().toString().trim().equals("")) {
            return false;  // False nghĩa là không hợp lệ vì có trường trống
        }
        return true;  // True nghĩa là hợp lệ
    }
}